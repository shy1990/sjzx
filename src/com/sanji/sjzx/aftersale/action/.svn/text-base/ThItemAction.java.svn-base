package com.sanji.sjzx.aftersale.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.aftersale.service.ThFormService;
import com.sanji.sjzx.aftersale.service.ThItemService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.EcErpUtil;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.model.ThForm;
import com.sanji.sjzx.model.ThItem;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;
@Namespace("/thForm")
@Action(value="thItemAction",results={
		@Result(name="showItem",location="/admin/thForm/thItem.jsp"),
		@Result(name="toList",location="/admin/thForm/list.jsp")
})
public class ThItemAction extends BaseAction implements ModelDriven<ThItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ThItem thItem = new ThItem();
	@Resource
	private ThItemService thItemService;
	@Resource
	private ThFormService thFormService;
	
	private String  GyShipStatus;
	/**
	 * 判断申请退货退款状态
	* @Title: existStatus
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void existStatus(){
		Json j = new Json();
		SessionInfo si = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		ThForm thForm = thFormService.gainThForm(thItem.getFormId());
		if("PROCESS".equals(thForm.getStatus()) && si.getUserId().equals(thForm.getReadUserId())){
			j.setMsg("正在处理中");
			j.setSuccess(true);
		}else if("ABORT".equals(thForm.getStatus()) && si.getUserId().equals(thForm.getReadUserId())){
			j.setMsg("已终止");
			j.setSuccess(true);
		}else if("INIT".equals(thForm.getStatus())){
			thForm.setReadUserId(si.getUserId());
			thForm.setStatus("PROCESS");
			updateThItem(thForm);
			j.setMsg("已受理");
			j.setSuccess(true);
		}else if("PROCESS".equals(thForm.getStatus()) && !si.getUserId().equals(thForm.getReadUserId())){
			j.setMsg("正在处理中");
			j.setSuccess(false);
		}else if("ABORT".equals(thForm.getStatus()) && !si.getUserId().equals(thForm.getReadUserId())){
			j.setMsg("已终止");
			j.setSuccess(false);
		}else{
			j.setMsg("已完成");
			j.setSuccess(false);
		}
		super.writeJson(j);
	}
	/**
	 * 跳转到退货详情
	* @Title: showThItem
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public String showThItem(){
		//String orderNumber = thFormService.gainThFormForOrderNumById(thItem.getFormId());
		boolean Status = EcErpUtil.gyShipStatus(thFormService.gainThFormForOrderNumById(thItem.getFormId()));
		
		if(Status){
			 GyShipStatus = "已发货";
		}else{
			GyShipStatus = "未发货";
		}
		request.setAttribute("GyShipStatus", GyShipStatus);
		request.setAttribute("thItemList", thItemService.gainThItem(thItem));
		request.setAttribute("thForm", thFormService.gainUserNameAndMobileById(thItem.getFormId()));
		return "showItem";
	}
	/**
	 * 更新退货详情
	* @Title: updateThItem
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	private void updateThItem(ThForm thForm){
		thFormService.updateThItem(thForm);
	}
	

	public ThItem getModel() {
		// TODO Auto-generated method stub
		return thItem;
	}

}
