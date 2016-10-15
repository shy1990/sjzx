package com.sanji.sjzx.apps.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.apps.service.AppsService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.model.Apps;
@Namespace("/apps")
@Action(value = "appsAction", results = {
		@Result(name = "toAppsList", location = "/admin/apps/list.jsp"),
		@Result(name = "toShowInfo", location = "/admin/apps/showInfo.jsp"),
		@Result(name = "toUpdate", location = "/admin/apps/edit.jsp")})
public class AppsAction extends BaseAction implements ModelDriven<Apps>{

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/	
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private AppsService appsService;
	private Apps apps = new Apps();
	//private List<Apps> appsList;
	
	/**
	 * 跳转到app列表页面
	 * @Title:toAppsList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toAppsList() {
		return "toAppsList";
	}
	/**
	 * 获取app列表
	 * @Title:gainAppsList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param  设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainAppsList(){
		try {
			super.writeJson(appsService.gainAppsList(apps));
		} catch (Exception e) {
			log.error("gainAppsList occur error. ",e);
			e.printStackTrace();
		}
	}
	/**
	 * 跳转到详情页面
	 * @Title:toShowInfo
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toShowInfo(){
		try {
			apps = appsService.gainAppsById(apps.getId());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("toShowInfo() occur error. ", e);
		}
		return "toShowInfo";
	}
	/**
	 * 跳转到修改页面
	 * @Title:toUpdate
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @return String 返回类型
	 */
	public String toUpdate() {
		apps = appsService.gainAppsById(apps.getId());
		return "toUpdate";
	}
	
	public void setApps(Apps apps) {
		this.apps = apps;
	}
	public Apps getModel() {
		return apps;
	}
	public Apps getApps() {
		return apps;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
}
