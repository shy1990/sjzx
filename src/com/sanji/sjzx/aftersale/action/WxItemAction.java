package com.sanji.sjzx.aftersale.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.aftersale.dao.WxItemMapper;
import com.sanji.sjzx.aftersale.service.WxFormService;
import com.sanji.sjzx.aftersale.service.WxItemService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.model.WxForm;
import com.sanji.sjzx.model.WxItem;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;
@Namespace("/wxForm")
@Action(value="wxItemAction",results={
		@Result(name="showItem",location="/admin/wxForm/wxItem.jsp"),
		@Result(name="toList",location="/admin/wxForm/list.jsp")
})
public class WxItemAction extends BaseAction implements ModelDriven<WxItem> {
	
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(WxItemAction.class);
	
	private WxItem wxItem = new WxItem();
	@Resource
	private WxItemService wxItemService;
	@Resource
	private WxFormService wxFormService;
	
	public void existStatus(){
		Json j = new Json();
		SessionInfo si = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		WxForm wxForm = wxFormService.gainWxForm(wxItem.getFormId());
		if("PROCESS".equals(wxForm.getStatus()) && si.getUserId().equals(wxForm.getReadUserId())){
			j.setMsg("正在处理中");
			j.setSuccess(true);
		}else if("ABORT".equals(wxForm.getStatus()) && si.getUserId().equals(wxForm.getReadUserId())){
			j.setMsg("已终止");
			j.setSuccess(true);
		}else if("INIT".equals(wxForm.getStatus())){
			wxForm.setReadUserId(si.getUserId());
			wxForm.setStatus("PROCESS");
			updateWxItem(wxForm);
			j.setMsg("已受理");
			j.setSuccess(true);
		}else if("PROCESS".equals(wxForm.getStatus()) && !si.getUserId().equals(wxForm.getReadUserId())){
			j.setMsg("正在处理中");
			j.setSuccess(false);
		}else if("ABORT".equals(wxForm.getStatus()) && !si.getUserId().equals(wxForm.getReadUserId())){
			j.setMsg("已终止");
			j.setSuccess(false);
		}else{
			j.setMsg("已完成");
			j.setSuccess(false);
		}
		super.writeJson(j);
	}
	
	public String showWxItem(){
		request.setAttribute("thItemList", wxItemService.gainWxItem(wxItem));
		request.setAttribute("member", wxFormService.gainUserNameAndMobileById(wxItem.getFormId()));
		return "showItem";
	}
	
	private void updateWxItem(WxForm wxForm){
		wxFormService.updateWxForm(wxForm);
	}

	public WxItem getModel() {
		// TODO Auto-generated method stub
		return wxItem;
	}

}
