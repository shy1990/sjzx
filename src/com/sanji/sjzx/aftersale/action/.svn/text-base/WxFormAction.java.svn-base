package com.sanji.sjzx.aftersale.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.aftersale.service.WxFormService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.model.WxForm;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;
@Namespace("/wxForm")
@Action(value="wxFormAction", results={
		@Result(name="toList",location="/admin/wxForm/list.jsp"),
		@Result(name="toUpdate",location="/admin/wxForm/update.jsp")
})
public class WxFormAction extends BaseAction implements ModelDriven<WxForm> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(WxFormAction.class);
	@Resource
	private WxFormService WxFormService;
	
	private WxForm WxForm = new WxForm();
	
	private SessionInfo si;
	
	public String toList(){
		
		return "toList";
	}
	
	
	public void gainWxFormInitList(){
		try {
			
			super.writeJson(WxFormService.gainWxFormInitList(WxForm));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("gainWxFormInitList() occur error. ", e);
		}
	}
	
	public void gainWxFormList(){
		try {
			si = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			super.writeJson(WxFormService.gainWxFormList(si.getUserId()));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("gainWxFormList() occur error. ", e);
		}
	}
	
	public String toUpdate(){
		request.setAttribute("id", WxForm.getId());
		return "toUpdate";
	}
	
	public void updateWxForm(){
		Json j = new Json();
		try {
			WxForm.setStatus("ABORT");
			WxFormService.updateWxForm(WxForm);
			j.setMsg("拒绝成功！");
			j.setSuccess(true);				
		} catch (Exception e) {
			j.setMsg("拒绝失败！");
			j.setSuccess(false);
			logger.error("updateWxForm() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	
	public WxForm getModel() {
		// TODO Auto-generated method stub
		return WxForm;
	}


}
