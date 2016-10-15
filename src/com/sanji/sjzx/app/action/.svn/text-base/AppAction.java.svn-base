package com.sanji.sjzx.app.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.app.service.AppService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.App;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;
@Namespace("/app")
@Action(value = "appAction", results = {
		@Result(name = "toAppList", location = "/admin/app/list.jsp"),
		@Result(name = "toAdd", location = "/admin/app/add.jsp"),
		@Result(name = "toUpdate", location = "/admin/app/edit.jsp")})

public class AppAction extends BaseAction implements ModelDriven<App>{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AppAction.class);
	private App app = new App();
	private List<App> appList;
	private SessionInfo sInfo = null;

	@Resource
	private AppService appService;
	public App getApp() {
		return app;
	}
	public void setApp(App app) {
		this.app = app;
	}
	public List<App> getAppList() {
		return appList;
	}
	public void setAppList(List<App> appList) {
		this.appList = appList;
	}
	public AppService getAppService() {
		return appService;
	}
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	public static Logger getLogger() {
		return logger;
	}
	
	public SessionInfo getsInfo() {
		return sInfo;
	}
	public void setsInfo(SessionInfo sInfo) {
		this.sInfo = sInfo;
	}

	private boolean flag = false;

	/**
	 * 跳转到app列表页面
	 * @return
	 */
	public String toAppList(){
		return "toAppList";
	}
	/**
	 * app列表
	 */
	public void gainAppList(){
		try{
			super.writeJson(appService.gainAppList(app));
		}catch(Exception e){
			logger.error("gainAppList() occur error. ",e);
			e.printStackTrace();
		}
	}
	public App getModel() {
		return app;
	}
	/**
	 * 跳转到添加页面
	 */
	public String toAdd(){
		return "toAdd";
	}
	/**
	 * 添加页面
	 */
	public void addApp(){
		Json j = new Json();
		try {
			sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			flag=appService.gainAppByName(app.getName());
			if(flag){//该name不存在
				app.setId(ToolsUtil.getUUID());
				app.setUserId(sInfo.getUserId());
				appService.addApp(app);
				j.setObj(app);
				j.setMsg("添加成功!");
				j.setSuccess(true);				
			}else{
				j.setMsg("此app名称已经存在!");
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setMsg("添加失败!");
			j.setSuccess(false);
			logger.error("addApp() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 跳转到修改页面
	 */
	public String toUpdate(){
		return "toUpdate";
	}
	/**
	 * 修改页面
	 */
	public void updateApp(){
		Json j = new Json();
		try {
			flag=appService.gainAppForExceptName(app.getId(), app.getName());
			if(flag){
				appService.updateApp(app);
				j.setMsg("修改成功!");
				j.setSuccess(true);				
			}else{
				j.setMsg("此app名称已经存在");
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setMsg("修改失败!");
			j.setSuccess(false);
			logger.error("updateApp() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	/**
	 * 删除相应记录的app信息
	 */
	public void dropApp(){
		Json j = new Json();
		try {  
			appService.dropApp(ToolsUtil.StringConvertList(app.getIds()));
			System.out.println("id="+app.getId());
			j.setMsg("删除成功！");
			j.setSuccess(true);			
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("dropApp() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
}
