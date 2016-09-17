package com.sanji.sjzx.members.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import jxl.CellView;
import jxl.Workbook;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.goodssku.dao.GoodsskuMapper;
import com.sanji.sjzx.members.dao.MembersGoodsShowMapper;
import com.sanji.sjzx.members.dao.MembersMapper;
import com.sanji.sjzx.members.service.MembersService;
import com.sanji.sjzx.model.Apps;
import com.sanji.sjzx.model.Members;
import com.sanji.sjzx.model.MembersGoodsShow;
import com.sanji.sjzx.pojo.DataGrid;
@Service("membersService")
@Transactional(rollbackFor=Exception.class)
public class MembersServiceImpl implements MembersService {
	@Resource
	private MembersMapper membersMapper;
	@Resource
	private MembersGoodsShowMapper membersGoodsShowMapper;
	@Resource
	private GoodsskuMapper goodsskuMapper;
	
	public MembersMapper getMembersMapper() {
		return membersMapper;
	}

	public void setMembersMapper(MembersMapper membersMapper) {
		this.membersMapper = membersMapper;
	}

	/**
	 * 获取会员分页列表
	 * <p>Title: gainMembersList</p>
	 * <p>Description:TODO</p>
	 * @param @param members
	 * @param @return
	 * @return 
	 * @see com.sanji.sjzx.members.service.MembersService#gainMembersList(com.sanji.sjzx.model.Members)
	 */
	public DataGrid gainMembersList(Members members) {
		DataGrid j=new DataGrid();
		j.setRows(membersMapper.gainMembersList(members));
		j.setTotal(membersMapper.gainMembersCount(members));
		return j;
	}

	/**
	 * (非 Javadoc)
	 * <p>Title: deleteMembers</p>
	 * <p>Description:TODO(根据主键进行批量或单条逻辑删除)</p>
	 * @param @param ids
	 * @return 
	 * @see com.sanji.sjzx.members.service.MembersService#deleteMembers(java.util.List)
	 */
	public void deleteMembers(List<String> ids) {
		membersMapper.deleteMembers(ids);
	}
	
	/**
	 * (非 Javadoc)
	 * <p>Title: deleteBlackMembers</p>
	 * <p>Description:TODO(根据主键进行批量或单条逻辑删除)</p>
	 * @param @param ids
	 * @return 
	 * @see com.sanji.sjzx.members.service.MembersService#deleteBlackMembers(java.util.List)
	 */
	public void deleteBlackMembers(List<String> ids) {
		
			membersMapper.deleteBlackMembers(ids);
	}

	/**
	 * 根据id进行查询会员信息
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.members.service.MembersService#gainMembersById(java.lang.String)
	 */
	public Members gainMembersById(String id) {
		return membersMapper.gainMembersById(id);
	}
	
	/**
	 * 根据memberId查询相应记录
	 */
	public List<Members> gainBlackMembersById(String memberId) {
		return membersMapper.gainBlackMembersById(memberId);
	}
	
	/**
	 * (非 Javadoc)
	 * <p>Title: deleteMembers</p>
	 * <p>Description:TODO(根据membersid插入)</p>
	 * @param @param ids
	 * @return 
	 * @see com.sanji.sjzx.members.service.MembersService#insertBlackMembers(java.util.List)
	 */
	public void insertBlackMembers(List<String> ids) {
		for(String id : ids){
			membersMapper.insertBlackMembers(id);
		}
		
	}
	
	/**
	 根据用户名(username)进行查询会员信息
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.members.service.MembersService#gainMemberByUsername(java.lang.String)
	 */
	public Members gainMemberByUsername(String userName) {
		Members member = membersMapper.gainMembersByUsername(userName);
		if(member != null && !"".equals(member)){
			return member;
		}
		return null;
	}

	/**
	 * 添加不可见单品
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.members.service.MembersService#addVisibleSku()
	 */
	public void addVisibleSku(MembersGoodsShow membersGoodsShow,String mids, List<String> skuIds) {
		// TODO Auto-generated method stub
		String uid = membersGoodsShow.getUserId();
		 String[] arr = mids.split(",");  
		 for(String mid:arr){  
				membersGoodsShowMapper.dropMembersGoodsByMembersId(mid);
	            List<MembersGoodsShow> memberGoodsList = new ArrayList<MembersGoodsShow>();
	           
	            if(skuIds != null && skuIds.size()>0){
	            	for(int i = 0; i < skuIds.size(); i++){
	            	    membersGoodsShow = new MembersGoodsShow();
	            		membersGoodsShow.setId(ToolsUtil.getUUID());
	            		membersGoodsShow.setMembersId(mid);
	            		membersGoodsShow.setSkuId(skuIds.get(i));
	            		membersGoodsShow.setCreateTime(new Date());
	            		membersGoodsShow.setUserId(uid);
	            		membersGoodsShow.setDisabled("false");
	            		memberGoodsList.add(membersGoodsShow);
	            	}
					membersGoodsShowMapper.addVisibleSku(memberGoodsList);
					if(gainMembersGoodsBySkuId(skuIds)){
						goodsskuMapper.updateGoodsSkuIsCheckedByIds(skuIds);
					}else{
						goodsskuMapper.updateGoodsSkuIsChecked();
					}
	            }
	            	
	        }  
		
	}
	/**
	 * 添加不可见单品
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.members.service.MembersService#gainMembersGoodsByMembersId(java.lang.String)
	 */

	public List<MembersGoodsShow> gainMembersGoodsByMembersId(
			List<String> ids) {
		return membersGoodsShowMapper.gainMembersGoodsByMembersId(ids);
	}
	
	private boolean gainMembersGoodsBySkuId(List<String> skuIds){
		Long mgNum = membersGoodsShowMapper.gainMembersGoodsBySkuId(skuIds);
		if(mgNum > 0){
			return true;
		}
		return false;
	}
	/**
	 * 获取未开发移动用户列表
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.members.service.MembersService#gainDisabledMembersList(java.util.List)
	 */
	public DataGrid gainDisabledMembersList(Members members) {
		DataGrid j=new DataGrid();
		j.setRows(membersMapper.gainDisabledMembersList(members));
		j.setTotal(membersMapper.gainDisabledMembersCount(members));
		return j;
	}
	/**
	 * 未开发发移动用户
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.members.service.MembersService#enableMembersById(java.util.List)
	 */
	public void enableMembersById(List<String> ids) {
		membersMapper.enableMembersById(ids);
	}
	
	/**
	 * 添加时查询是否存在此商铺
	 */
	public boolean gainMembersByName(String username) {
		List<Members> list = membersMapper.gainMembersByName(username);
//		System.out.println("--------"+username);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 根据手机号更新地域类型
	 */
	public void updateAtypeByMobile(Members member) {
		membersMapper.updateAtypeByMobile(member);
		
	}
	
	/**
	 * members数据导出
	 */
	public List<Members> gainMembersByExport(Members members) {
		return membersMapper.gainMembersByExport(members);
	}
	
	/**
	 * 流
	 */
	public InputStream exportDateToExcel(List<?> list) {
		if(list==null){
			try {
				throw new Exception("list is null in exportDateToExcel method,it mustn't be null.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();   
		putDataOnOutputStream(out,list);   
		return new ByteArrayInputStream(out.toByteArray());
	}

	/**
	 * 流
	 * @Title:putDataOnOutputStream
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param os
	 * @param @param list 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param os
	 * @param list
	 */
	private void putDataOnOutputStream(OutputStream os,List<?> list) {
		if(list==null)
			try {
				throw new Exception("list is null in exportDateToExcel method,it mustn't be null.");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(os);
			WritableSheet sheet = workbook.createSheet("Sheet1", 0);
			sheet.getSettings().setDefaultColumnWidth(25);
			sheet.addCell(new jxl.write.Label(0, 0, "登录名称"));
			sheet.addCell(new jxl.write.Label(1, 0, "真实姓名"));
			sheet.addCell(new jxl.write.Label(2, 0, "所在地区"));
			sheet.addCell(new jxl.write.Label(3, 0, "所在街道"));
			sheet.addCell(new jxl.write.Label(4, 0, "联系地址"));
			sheet.addCell(new jxl.write.Label(5, 0, "地域类别"));
			sheet.addCell(new jxl.write.Label(6, 0, "渠道编码"));
			sheet.addCell(new jxl.write.Label(7, 0, "移动电话"));
			sheet.addCell(new jxl.write.Label(8, 0, "固定电话"));
			sheet.addCell(new jxl.write.Label(9, 0, "注册时间"));
			sheet.addCell(new jxl.write.Label(10, 0, "业务人员姓名"));
			sheet.addCell(new jxl.write.Label(11, 0, "业务人员手机号码"));

			DateFormat df = new DateFormat("yyyy-MM-dd");
        	WritableCellFormat cf = new WritableCellFormat(df);
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	Date nt=sdf.parse("2000-01-01");
	        //循环遍历到数据集
	        for(int i= 0;i<list.size();i++){
	        	Members members = (Members) list.get(i);
	        	/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        	String regTime=sdf.format(members.getRegTime());*/
	        	sheet.addCell(new jxl.write.Label(0,i+1 ,members.getUsername()+""));
	        	sheet.addCell(new jxl.write.Label(1,i+1 ,members.getTruename()));
	        	sheet.addCell(new jxl.write.Label(2,i+1 ,members.getAddress()));
	        	sheet.addCell(new jxl.write.Label(3,i+1 ,members.getThree_a()));
	        	sheet.addCell(new jxl.write.Label(4,i+1 ,members.getSaddress()));
	        	sheet.addCell(new jxl.write.Label(5,i+1 ,members.getAType()));
	        	sheet.addCell(new jxl.write.Label(6,i+1 ,members.getDitchEncode()));
	        	sheet.addCell(new jxl.write.Label(7,i+1 ,members.getMobile()));
	        	sheet.addCell(new jxl.write.Label(8,i+1 ,members.getTelphone()));
	        	Date regTime=members.getRegTime();
	        	if(regTime != null && !"".equals(regTime)){
	        		sheet.addCell(new DateTime(9, i+1, regTime,cf));
	        	}else{
	        		sheet.addCell(new DateTime(9, i+1, nt,cf));
	        	}
	        	sheet.addCell(new jxl.write.Label(10,i+1 ,members.getSname()));
	        	sheet.addCell(new jxl.write.Label(11,i+1 ,members.getSmobile()));
	        }
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			try {
				throw new Exception("putDataOnOutputStream has some error:",e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<Members> gainMembersByRegions(String areaid) {
		// TODO Auto-generated method stub
		return membersMapper.gainMembersByRegions(areaid);
	}
	

}
