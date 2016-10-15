/**  
* @Title: ModuleAction.java
* @Package com.sanji.sjzx.authorityManage.module.action
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2014-9-4 下午2:38:35
* @version V1.0  
*/
package com.sanji.sjzx.authorityManage.module.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.authorityManage.module.service.ModuleService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.login.action.LoginAction;
import com.sanji.sjzx.model.Module;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;
import com.sanji.sjzx.pojo.TreeNode;

/**
 * @ClassName: ModuleAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-4 下午2:38:35
 */
@Namespace("/module")
@Action(value = "moduleAction", results = {
		@Result(name = "toTreeList", location = "/admin/module/treeList.jsp"),
		@Result(name = "toAdd", location = "/admin/module/add.jsp"),
		@Result(name = "toUpdate", location = "/admin/module/edit.jsp")
		})
public class ModuleAction extends BaseAction implements ModelDriven<Module> {

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	
	private Module module = new Module();
	private List<TreeNode> treeNodelist = new ArrayList<TreeNode>();
	private List<TreeNode> rootTreeList = new ArrayList<TreeNode>();
	private List<TreeNode> sonTreeList = new ArrayList<TreeNode>();
	
	@Resource
	private ModuleService moduleService;
	
	private String mark;
	private List<String> list = new ArrayList<String>();
	private boolean flag = false;
	private SessionInfo sInfo = null;
	
	/**
	 * 根据用户权限动态加载左侧菜单
	* @Title: gainTreeMenus
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void gainTreeMenus(){
		//获取登录信息
		SessionInfo sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		//根据角色id查询其权限
		List<Module> modules1 = moduleService.gainModuleBySq1(sInfo.getRoleIds());
		List<Module> modules2 = moduleService.gainModuleBySq2(sInfo.getRoleIds());
		treeNodelist = gainRootTree(modules1,modules2);
		writeJson(treeNodelist);
	}
	
	private List<TreeNode> gainRootTree(List<Module> modules,List<Module> modules2){
		rootTreeList = new ArrayList<TreeNode>();
		if(modules!=null && modules.size()>0){
			for (Module m : modules) {
				TreeNode tn = new TreeNode();
				tn.setMenuid(m.getId());
				if(m.getIcon()!=null){
					tn.setIcon(m.getIcon());
				}else{
					tn.setIcon("icon-employee");
				}
				tn.setMenuname(m.getName());
				tn.setMenus(gainSonTree(tn.getMenuid(),modules2));
				rootTreeList.add(tn);
			}
		}
		return rootTreeList;
	}
	
	private List<TreeNode> gainSonTree(String mid,List<Module> modules2){
		sonTreeList = new ArrayList<TreeNode>();
		for (Module m2 : modules2) {
			if(m2.getPid().equals(mid)){
				TreeNode tn2= new TreeNode();
				tn2.setMenuid(m2.getId());
				tn2.setMenuname(m2.getName());
				if(tn2.getIcon()!=null){
					tn2.setIcon(m2.getIcon());
				}else{
					tn2.setIcon("icon-em_list");
				}
				tn2.setUrl(m2.getUrl());
				tn2.setImType("href");
				sonTreeList.add(tn2);				
			}
		}
		return sonTreeList;
	}	
	
	
	/**
	 * 功能说明：跳转到模块管理列表页面
	* @Title: toTreeList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public String toTreeList(){
		return "toTreeList";
	}
	
	/**
	 * 功能说明：树形模块管理列表
	* @Title: gainModuleTreeList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void gainModuleTreeList(){
		try {
			super.writeJson(moduleService.gainModuleList1(module,mark));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainModuleTreeList() occur error. ", e);
		}
	}
	
	/**
	 * 功能说明：跳转到模块添加页面
	* @Title: toAdd
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public String toAdd(){
		Long l = moduleService.gainModuleAllCount();
		if(l<1){//无数据
			//初次添加模块设置默认值
			moduleService.addModule(setValueForModule());
		}
		return "toAdd";
	}

	/**
	 * @Title: setValueForModule
	 * @Description: TODO(设置默认值)
	 * @param @return    设定文件
	 * @return Module    返回类型
	 */
	private Module setValueForModule(){
		sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		module.setId(ToolsUtil.getUUID());
		module.setName("根模块");
		module.setGrade(Long.parseLong("1"));
		module.setCreatetime(new Date());
		module.setModifytime(new Date());
		module.setUserId(sInfo.getUserId());
		return module;
	}
	
	/**
	 * 功能说明：添加模块
	* @Title: addModule
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void addModule(){
		Json j = new Json();
		try {
			sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			//查询验证模块名称是否存在
			flag = moduleService.gainIsExistName(module.getName());
			if(flag){//不存在
				module.setId(ToolsUtil.getUUID());
				module.setCreatetime(new Date());
				module.setModifytime(new Date());
				module.setUserId(sInfo.getUserId());
				moduleService.addModule(module);
				j.setObj(module);
				j.setMsg("添加成功!");
				j.setSuccess(true);				
			}else{
				j.setMsg("此模块名称已存在!");
				j.setSuccess(false);					
			}
		} catch (Exception e) {
			j.setMsg("添加失败!");
			j.setSuccess(false);
			logger.error("addModule() occur error. ", e);
			e.printStackTrace();
		}	
		writeJson(j);
	}
	
	/**
	 * 功能说明：跳转到模块修改页面
	* @Title: toUpdate
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public String toUpdate(){
		return "toUpdate";
	}

	/**
	 * 功能说明：修改模块
	* @Title: updateModule
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void updateModule(){
		Json j = new Json();
		try {
			sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			module.setModifytime(new Date());
			module.setUserId(sInfo.getUserId());
			moduleService.modifyModule(module);
			j.setMsg("修改成功!");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("修改失败!");
			j.setSuccess(false);
			logger.error("updateModule() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 功能说明：删除模块(逻辑删除)
	* @Title: deleteModule
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void deleteModule(){
		Json j = new Json();
		try {
			if(!moduleService.gainIsExistChildModule(module.getPid())){
				j.setMsg("该模块含有子模块,无法删除!！");
				j.setSuccess(false);
			}else if(moduleService.gainIsAuthorizeModule(module.getId())){
				j.setMsg("该模块已作为权限被分配,无法删除!");
				j.setSuccess(false);	
			}else{
				moduleService.dropModule(module.getId());
				j.setObj(module.getId());
				j.setMsg("删除成功！");
				j.setSuccess(true);			
			}
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("deleteModule() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 功能说明：删除模块(物理删除)
	* @Title: dropModule
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void dropModule(){
		Json j = new Json();
		try {
			if(!moduleService.gainIsExistChildModule(module.getId())){
				j.setMsg("该模块含有子模块,无法删除!！");
				j.setSuccess(false);
			}else if(!moduleService.gainIsAuthorizeModule(module.getId())){
				j.setMsg("该模块已作为权限被分配,无法删除!");
				j.setSuccess(false);	
			}else{
				moduleService.dropModule(module.getId());
				j.setObj(module.getId());
				j.setMsg("删除成功！");
				j.setSuccess(true);			
			}
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("deleteModule() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 功能说明：树形展示模块
	* @Title: gainModuleTree
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void gainModuleTree(){  
        writeJson(moduleService.gainModuleList());
	}
	
	
	
	

	/* (非 Javadoc)
	* <p>Title: getModel</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.ModelDriven#getModel()
	*/
	
	public Module getModel() {
		// TODO Auto-generated method stub
		return module;
	}



	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}



	/**
	 * @param module the module to set
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * @return the mark
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * @param mark the mark to set
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * @return the list
	 */
	public List<String> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<String> list) {
		this.list = list;
	}
	

}
