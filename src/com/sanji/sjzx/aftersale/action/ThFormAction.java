package com.sanji.sjzx.aftersale.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.aftersale.service.ThFormService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.HttpClientUtils;
import com.sanji.sjzx.common.util.JsonUtil;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.Order;
import com.sanji.sjzx.model.ThForm;
import com.sanji.sjzx.order.dao.OrderMapper;
import com.sanji.sjzx.order.service.OrderService;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;
import com.sanji.sjzx.system.friendlylink.action.FriendlyLinkAction;
@Namespace("/thForm")
@Action(value="thFormAction", results={
		@Result(name="toList",location="/admin/thForm/thList.jsp"),
		@Result(name="toUpdate",location="/admin/thForm/update.jsp"),
		@Result(name="showInformation",location="/admin/thForm/thInformation.jsp")
})
public class ThFormAction extends BaseAction implements ModelDriven<ThForm> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ThFormAction.class);
	@Resource
	private ThFormService thFormService;
	
	@Autowired
	private OrderService orderService;
	
	private ThForm thForm = new ThForm();
	
	private SessionInfo si;
	
	private boolean flag;
	/**
	 * 跳转到申请退货列表页面
	* @Title: toList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author songbaozhen
	 */
	public String toList(){
		
		return "toList";
	}
	
	private String  getAdminUserId(){
		si = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		return si.getUserId();
	}
	
	/**
	 * 获取初始化申请退货列表
	* @Title: gainThFormInitList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void gainThFormInitList(){
		try {
			super.writeJson(thFormService.gainThFormInitList(thForm));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("gainThFormInitList() occur error. ", e);
		}
	}
	/**
	 * 获取初始化申请退货列表
	* @Title: showInformation
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return string    返回类型
	* @author songbaozhen
	 */
	public String showInformation(){
		//ThForm	tForm = thFormService.gainThForm(thForm);
		request.setAttribute("thForm", thFormService.gainThForm(thForm));
			return "showInformation";
		
	}
	/**
	 * 更新受理退货退款后的状态
	* @Title: updateStatus
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void updateStatus(){
		
		Json j = new Json();
		try {
			changeStatus(thForm);
			j.setMsg("受理成功！");
			j.setSuccess(true);	
		} catch (Exception e) {
			j.setMsg("受理失败！");
			j.setSuccess(false);
			logger.error("updateStatus() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	private void changeStatus(ThForm thForm){
			si = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			thForm.setReadUserId(si.getUserId());
		thFormService.updateStatus(thForm);
	}
	/**
	 * 获取受理后的申请退货的列表
	* @Title: gainThFormList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void gainThFormList(){
		try {
			si = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			thForm.setReadUserId(si.getUserId());
			super.writeJson(thFormService.gainThFormList(thForm));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("gainThFormList() occur error. ", e);
		}
	}
	/**
	 * 获取受理后的申请退货的列表
	* @Title: gainThFormList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public String toUpdate(){
		request.setAttribute("id", thForm.getId());
		return "toUpdate";
	}
	/**
	 * 更新申请退货
	* @Title: updateThForm
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void updateThForm(){
		Json j = new Json();
		try {
			si = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			thForm.setReadUserId(si.getUserId());
			thForm.setStatus("ABORT");
			thFormService.updateThForm(thForm);
			j.setMsg("拒绝成功！");
			j.setSuccess(true);				
		} catch (Exception e) {
			j.setMsg("拒绝失败！");
			j.setSuccess(false);
			logger.error("updateThForm() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 判断发货状态
	* @Title: existOrderShipStatus
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void existOrderShipStatus(){
		Json j = new Json();
		try {
			flag = thFormService.existOrderShipStatus(thForm);
			if(!flag){
				
				j.setSuccess(true);		
			}else{
				
				j.setSuccess(false);	
			}
		} catch (Exception e) {
			logger.error("existOrderShipStatus() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 退款
	* @Title: returnMoney
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void returnMoney(){
		Json j = new Json();
		try {
			if( thForm.getMoney().intValue() > 0){
				Map<String,String> params = new HashMap<String,String>();
				params.put("orderId", thForm.getOrderId());
				params.put("reFundAmt", String.valueOf(thForm.getMoney()));
				
				if(thForm.getOrderId()!=null&& !"".equals(thForm.getOrderId())){
					Order order = orderService.selectByPrimaryKey(thForm.getOrderId());
					if(!order.getShipStatus().equals("3")){//如果收货状态不是已签收那么就整单退，钱数从订单表取
						order.setStatus("2");
						order.setPayStatus("3");
						orderService.updateByPrimaryKey(order);//如果是整单退，那么就改变订单状态
					}
				}
				
				String s = HttpClientUtils.sendPostSSLRequest("http://www.3j1688.com/yeePay/toRefund.html", params);
				if(s != null && !"".equals(s)&& thForm.getUserId() != null && !"".equals(thForm.getUserId())&&"COMPLETE".equals(thForm.getStatus())&&thForm.getId() != null && !"".equals(thForm.getId()) ){
					j =(Json)JsonUtil.getObject4JsonString(s,Json.class);
					if(j.getSuccess()){
						changeStatus(thForm);
					}
		            
				}
			
			}else{
				j.setMsg("退款金额不能为0");
				j.setSuccess(false);
				
			}
		
		} catch (Exception e) {
			logger.error("returnMoney() occur error. ", e);
			e.printStackTrace();
			j.setMsg("退款失败");
			j.setSuccess(false);
		}
		writeJson(j);
		
	}
	
	
	public ThForm getModel() {
		// TODO Auto-generated method stub
		return thForm;
	}

}
