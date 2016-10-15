package com.sanji.sjzx.dlycorp.action;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.authorityManage.admin.action.AdminAction;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.dlycorp.service.DlyCorpService;
import com.sanji.sjzx.model.DlyCorp;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;
@Namespace("/dlyCorp")
@Action(value ="dlyCorpAction",results = {
		@Result(name = "toDlyCorpList", location = "/admin/dlyCorp/list.jsp"),
		@Result(name = "toAdd", location = "/admin/dlyCorp/add.jsp"),
		@Result(name = "toUpdate", location = "/admin/dlyCorp/edit.jsp")
})
public class DlyCorpAction extends BaseAction implements ModelDriven<DlyCorp>{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DlyCorpAction.class);
	private SessionInfo sInfo = null;
	private boolean flag;
	private DlyCorp dlyCorp ;
	@Resource
	private DlyCorpService dlyCorpService;
	
	public DlyCorp getModel() {
		if(dlyCorp == null){
			dlyCorp = new DlyCorp();
		}
		return dlyCorp;
	}
	/**
	 * 跳转到物流公司列表页面
	* @Title: toDlyCorpLost
	* @Description: TODO(跳转到物流公司列表页面)
	* @param @return    设定文件
	* @return String    返回类型
	* @author songbaozhen
	 */
	public String toDlyCorpList(){
		
		return "toDlyCorpList";
	}
	/**
	 * 获取物流公司列表
	* @Title: gainDlyCorpList
	* @Description: TODO(获取物流公司列表)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void gainDlyCorpList(){
		try {
			super.writeJson(dlyCorpService.gainDlyCorpList(dlyCorp));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainDlyCorpList() occur error. ", e);
		}
		
	}
	
	/**
	 * 跳转到物流公司添加页面
	 * @return
	 */
	public String toAdd(){
	BigDecimal	orderNum = new BigDecimal(dlyCorpService.getMaxOrderNum());
	dlyCorp.setOrdernum(orderNum);
	ActionContext.getContext().getSession().put("dlyCorp", dlyCorp);
		return "toAdd";
	}
	/**
	 * 添加物流公司列表
	* @Title: addDlyCorp
	* @Description: TODO(添加物流公司)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void addDlyCorp(){
		Json j = new Json();
		try {
			//根据名称和主键验证物理公司名称是否存在
			flag = dlyCorpService.gainIsExistName(dlyCorp.getName(),dlyCorp.getId());
			if(flag){//不存在
				dlyCorp.setId(ToolsUtil.getUUID());
				dlyCorp.setName(dlyCorp.getName());
				dlyCorp.setType(dlyCorp.getType());
				dlyCorp.setWebsite(dlyCorp.getWebsite());
				dlyCorp.setOrdernum(dlyCorp.getOrdernum());
			    dlyCorpService.addDlyCorp(dlyCorp);
				j.setMsg("添加成功！");
				j.setSuccess(true);				
			}else{
				j.setMsg("此物流公司已添加！");
				j.setSuccess(false);					
			}
		} catch (Exception e) {
			j.setMsg("添加失败！");
			j.setSuccess(false);
			logger.error("addDlyCorp() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 跳转到物流公司修改页面
	 * @return
	 */
	public String toUpdate(){
		return "toUpdate";
	}
	/**
	 * 更新物流公司
	* @Title: updateDlyCorp
	* @Description: TODO(更新物流公司)
	* @param @return    设定文件
	* @return viud   返回类型
	* @author songbaozhen
	 */
	public void updateDlyCorp(){
		Json j = new Json();
		try {
			//根据名称和主键验证物理公司名称是否存在
			flag = dlyCorpService.gainIsExistName(dlyCorp.getName(),dlyCorp.getId());
			if(flag){
				dlyCorp.setName(dlyCorp.getName());
				dlyCorp.setType(dlyCorp.getType());
				dlyCorp.setWebsite(dlyCorp.getWebsite());
				dlyCorpService.modifyDlyCorp(dlyCorp);
				j.setObj(dlyCorp);
				j.setMsg("修改成功！");
				j.setSuccess(true);
			}else{
				j.setMsg("此物流公司已添加！");
				j.setSuccess(false);		
			}
			
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
			logger.error("updateDlyCorp() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 删除单条或批量删除物流公司(物理删除)
	* @Title: dropDlyCorp
	* @Description: TODO(删除单条或批量删除物流公司)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void dropDlyCorp(){
		Json j = new Json();
		try {
			dlyCorpService.dropDlyCorpById(ToolsUtil.StringConvertList(dlyCorp.getIds()));
			j.setMsg("删除成功！");
			j.setSuccess(true);	
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("dropDlyCorp() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	
	/**
	 * 单条或批量禁用物流公司
	* @Title: danDlyCorp
	* @Description: TODO(单条或批量禁用物流公司)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void danDlyCorp(){
		Json j = new Json();
		try {
			dlyCorpService.danDlyCorpById(ToolsUtil.StringConvertList(dlyCorp.getIds()));
			j.setMsg("禁用成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("禁用失败！");
			j.setSuccess(false);
			logger.error("danDlyCorp() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 单条或批量启用物流公司
	* @Title: openDlyCorp
	* @Description: TODO(单条或批量启用物流公司)
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
	public void openDlyCorp(){
		Json j = new Json();
		try {
			dlyCorpService.openDlyCorpById(ToolsUtil.StringConvertList(dlyCorp.getIds()));
			j.setMsg("启用成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("启用失败！");
			j.setSuccess(false);
			logger.error("openDlyCorp() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	

}
