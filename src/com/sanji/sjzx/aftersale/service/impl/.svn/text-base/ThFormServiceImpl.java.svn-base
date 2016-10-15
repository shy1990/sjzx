package com.sanji.sjzx.aftersale.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.aftersale.dao.QhFormMapper;
import com.sanji.sjzx.aftersale.dao.QhItemMapper;
import com.sanji.sjzx.aftersale.dao.ThFormMapper;
import com.sanji.sjzx.aftersale.dao.ThItemMapper;
import com.sanji.sjzx.aftersale.service.ThFormService;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.members.dao.MembersMapper;
import com.sanji.sjzx.model.Members;
import com.sanji.sjzx.model.QhForm;
import com.sanji.sjzx.model.ThForm;
import com.sanji.sjzx.model.ThItem;
import com.sanji.sjzx.order.dao.OrderItemMapper;
import com.sanji.sjzx.pojo.DataGrid;
@Service("thFormService")
@Transactional(rollbackFor = Exception.class)
public class ThFormServiceImpl implements ThFormService {

	@Resource
	private ThFormMapper thFormMapper;
	@Resource
	private OrderItemMapper orderItemMapper;
	@Resource
	private ThItemMapper thItemMapper;
	@Resource
	private QhFormMapper qhFormMapper;
	@Resource
	private MembersMapper membersMapper;
	// TODO 积分系数未设置
	private float pointCoefficient = 10;
	
	/**
	 * 更新用户积分信息
	 * 
	 * @Title: editPoint
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param money
	 *            退款金额数量
	 * @return void 返回类型
	 * @author 田超强
	 * @throws
	 */
	public void editPoint(BigDecimal money, String userId) {
		Members member = membersMapper.selectByPrimaryKey(userId);
		BigDecimal point = BigDecimal.ZERO;// 初始化积分变量为0
		point = point.add(money.divide(BigDecimal.valueOf(pointCoefficient)));// 钱数/积分换算系数=积分数量
		point = BigDecimal.valueOf(Math.floor(point.doubleValue()));// 对计算出的积分取整

		// 消费积分
		point = member.getPoint().subtract(point);// 用户已有积分减去本次退款应减的积分

		// 更新积分
		// pointGoodsMaper.updatePoint(member.getId(), point);
		member.setPoint(point);
		membersMapper.updateByPrimaryKey(member);
	}
	/**
	 * 查询申请退款退货初始化列表
	 * 
	 * @Title: gainThFormInitList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param thForm
	 *            退款金额数量
	 * @return DataGrid 返回类型
	 * @author songbaozhen
	 * @throws
	 */
	public DataGrid gainThFormInitList(ThForm thForm) {
		DataGrid j = new DataGrid();
		j.setRows(thFormMapper.gainThFormInitList(thForm));
		j.setTotal(thFormMapper.gainThFormInitCount(thForm));
		return j;
	}
	/**
	 * 更新退货表
	 * 
	 * @Title: gainThForm
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param thForm
	 *            退款金额数量
	 * @return void 返回类型
	 * @author songbaozhen
	 * @throws
	 */
	public void updateThItem(ThForm thForm) {
		thFormMapper.updateByPrimaryKeySelective(thForm);
		
	}
	/**
	 * 根据Id查询
	 * 
	 * @Title: gainThForm
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param formId
	 *            退款金额数量
	 * @return ThForm 返回类型
	 * @author songbaozhen
	 * @throws
	 */
	public ThForm gainThForm(String formId) {
		ThForm thForm = thFormMapper.gainThFormById(formId);
			return thForm;
	}
	/**
	 * 查询申请退款退货非初始化列表
	 * 
	 * @Title: gainThFormList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param readUserId
	 *            退款金额数量
	 * @return DataGrid 返回类型
	 * @author songbaozhen
	 * @throws
	 */
	public DataGrid gainThFormList(ThForm thForm) {
		DataGrid j = new DataGrid();
		j.setRows(thFormMapper.gainThFormList(thForm));
		j.setTotal(thFormMapper.gainThFormCount(thForm));
		return j;
	}
	/**
	 * 根据id查询退货信息及用户名和电话号码
	 * 
	 * @Title: gainUserNameAndMobileById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param formId
	 *            退款金额数量
	 * @return thForm 返回类型
	 * @author songbaozhen
	 * @throws
	 */
	public ThForm gainUserNameAndMobileById(String formId) {
		ThForm thForm = thFormMapper.gainUserNameAndModbileById(formId);
		if(thForm != null && !"".equals(thForm)){
			return thForm;
		}
		return null;
	}
	/**
	 * 更新退款退货
	 * 
	 * @Title: updateThForm
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param thForm
	 *            退款金额数量
	 * @return void 返回类型
	 * @author songbaozhen
	 * @throws
	 */
	public void updateThForm(ThForm thForm) {
		
		thFormMapper.updateThForm(thForm);
		chanageOrderShipStatus(thForm);
	}
	/**
	 * 查询退款退货
	 * 
	 * @Title: gainThForm
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param thForm
	 *            退款金额数量
	 * @return ThForm 返回类型
	 * @author songbaozhen
	 * @throws
	 */
	public ThForm gainThForm(ThForm thForm) {
		// TODO Auto-generated method stub
		ThForm tForm = thFormMapper.gainThFormById(thForm.getId());
		if(tForm != null && tForm != null){
			return tForm;
		}
		return null;
	}
	/**
	 * 更新退款退货及订单项状态
	 * 
	 * @Title: updateStatus
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param thForm
	 *            退款金额数量
	 * @return void 返回类型
	 * @author songbaozhen
	 * @throws
	 */
	public void updateStatus(ThForm thForm) {
		// TODO Auto-generated method stub
		if("REJECTCLIENT".equals(thForm.getStatus())){
			
			QhForm qhForm = new QhForm();
			String qhid = ToolsUtil.getUUID();
			qhForm.setId(qhid);
			qhFormMapper.insertSelective(qhForm);
			thForm.setQhFormId(qhid);
		}else if("COMPLETE".equals(thForm.getStatus())){
			
			editPoint(thForm.getMoney(),thForm.getUserId());
		}
		thFormMapper.updateByPrimaryKeySelective(thForm);
		if(thForm.getStatus() != null && !"".equals(thForm.getStatus()) && !"PROCESS".equals(thForm.getStatus())){
			chanageOrderShipStatus(thForm);
		}else if(thForm.getStatus() != null && !"".equals(thForm.getStatus())){
			thForm.setStatus("AUDITREJECT");
			chanageOrderShipStatus(thForm);
		}
  }
	/**
	 * 判断订单发货状态
	 * 
	 * @Title: existOrderShipStatus
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param thForm
	 *            退款金额数量
	 * @return boolean 返回类型
	 * @author songbaozhen
	 * @throws
	 */
	public boolean existOrderShipStatus(ThForm thForm) {
		// TODO Auto-generated method stub
		String shipStatus = thFormMapper.gainOderShipStatus(thForm);
		if(shipStatus != null && !"".equals(shipStatus) && !"3".equals(shipStatus)){
			return  true;
		}
		return false;
	}
	/**
	 * 更新订单发货状态
	 * 
	 * @Title: chanageOrderShipStatus
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param thForm
	 *            退款金额数量
	 * @return void 返回类型
	 * @author songbaozhen
	 * @throws
	 */
	private void  chanageOrderShipStatus(ThForm thForm){
		List<String> ids = thItemMapper.gainOrderItemIdsByFormId(thForm.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		if("PROCESS".equals(thForm.getStatus())){
		 map.put("thStatus","AUDITREJECT");
		// orderItemMapper.updateOrderItemStateByMap(map);
		}else{
		 map.put("thStatus",thForm.getStatus());
	    }
		 orderItemMapper.updateOrderItemStateByMap(map);
		}
	/**
	 * 查询订单orderNum
	 * 
	 * @Title: gainThFormForOrderNumById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param  id
	 *            退款金额数量
	 * @return String 返回类型
	 * @author songbaozhen
	 * @throws
	 */
	public String gainThFormForOrderNumById(String id) {
		// TODO Auto-generated method stub
		String orderNum = thFormMapper.gainThFormForOrderNumById(id);
		if(orderNum.length() > 0){
			return orderNum;
		}
		return null;
	}

}
