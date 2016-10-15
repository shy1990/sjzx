package com.sanji.sjzx.authorityManage.role.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;


import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.authorityManage.role.service.RoleService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.Role;
import com.sanji.sjzx.model.RoleModule;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;

@Namespace("/role")
@Action(value = "roleAction", results = {
		@Result(name = "toRoleList", location = "/admin/role/list.jsp"),
		@Result(name = "toAdd", location = "/admin/role/add.jsp"),
		@Result(name = "toUpdate", location = "/admin/role/edit.jsp"),
		@Result(name = "toAuthorize", location = "/admin/role/roleAuthorize.jsp")})
public class RoleAction extends BaseAction implements ModelDriven<Role> {
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 1L;
	/**
	 * 记录日志
	 */
	private static final Logger logger = Logger.getLogger(RoleAction.class);
	@Resource
	private RoleService roleService;
	private Role role = new Role();
	private RoleModule rm = new RoleModule();
	private List<String> list = new ArrayList<String>();
	private List<RoleModule> roleModuleList = new ArrayList<RoleModule>();
	private String mids;
	private String rid;
	private boolean flag = false;
	private SessionInfo sInfo = null;
	
	public Role getModel() {
		return role;
	}
	
	/**
	 * 跳转到角色管理列表页面
	 * @return
	 */
	public String toRoleList(){
		return "toRoleList";
	}
	
	/**
	 * 获取角色列表
	 * @return
	 */
	public void gainRoleList(){
		try {
			super.writeJson(roleService.gainRoleList(role));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainRoleList() occur error. ", e);
		}
	}
	
	/**
	 * 跳转到角色添加页面
	 * @return
	 */
	public String toAdd(){
		return "toAdd";
	}
	
	/**
	 * 角色添加
	 */
	public void addRole(){
		Json j = new Json();
		try {
			sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			//查询验证角色名称是否存在
			flag = roleService.gainIsExistName(role.getName());
			if(flag){//不存在
				role.setId(ToolsUtil.getUUID());
				role.setCreatetime(new Date());
				role.setModifytime(new Date());
				role.setUserId(sInfo.getUserId());
				roleService.addRole(role,ToolsUtil.StringConvertList(mids));
				j.setMsg("添加成功！");
				j.setSuccess(true);				
			}else{
				j.setMsg("此角色名称已添加！");
				j.setSuccess(false);					
			}
		} catch (Exception e) {
			j.setMsg("添加失败！");
			j.setSuccess(false);
			logger.error("addRole() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 跳转到角色修改页面
	 * @return
	 */
	public String toUpdate(){
		return "toUpdate";
	}
	
	/**
	 * @Title: gainModuleIdsByRoleId
	 * @Description: TODO(根据角色id查询权限id集合)
	 * @param     设定文件
	 * @return void    返回类型
	 */
	public void gainModuleIdsByRoleId(){
		List<String> list = roleService.gainModuleIdsByRoleId(role.getId());
		writeJson(list);	
	}
	/**
	 * 角色修改
	 */
	public void updateRole(){
		Json j = new Json();
		try {
			sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			role.setModifytime(new Date());
			role.setUserId(sInfo.getUserId());
			roleService.modifyRole(role,ToolsUtil.StringConvertList(mids));
			j.setObj(role);
			j.setMsg("修改成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
			logger.error("updateRole() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 *  角色删除(逻辑删除)
	 */
	public void deleteRole(){
		Json j = new Json();
		try {
			roleService.deleteRole(ToolsUtil.StringConvertList(role.getIds()));
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("deleteRole() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 *  角色删除(物理删除)
	 */
	public void dropRole(){
		Json j = new Json();
		try {
			flag = roleService.gainIsExistRoleId(ToolsUtil.StringConvertList(role.getIds()));
			if(!flag){//已被用户使用
				j.setMsg("所选择的角色已被用户使用,无法删除！");
				j.setSuccess(false);				
			}else{
				roleService.dropRole(ToolsUtil.StringConvertList(role.getIds()));
				j.setMsg("删除成功！");
				j.setSuccess(true);				
			}
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("dropRole() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 跳转到授权页面
	 * @return
	 */
	public String toAuthorize(){
		return "toAuthorize";
	}
	
	/**
	 * 功能说明：授权
	 */
	public void addAuthorize(){
		Json j = new Json();
		try {
			sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			rm.setRoleId(rid);
			rm.setUserId(sInfo.getUserId());
			roleService.addAuthorize(rm,ToolsUtil.StringConvertList(mids));
			j.setMsg("授权成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("授权失败！");
			j.setSuccess(false);
			logger.error("deleteRole() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);		
	}

	/**
	 * @Title: gainMid
	 * @Description: TODO(根据角色id获取其权限)
	 * @param     设定文件
	 * @return void    返回类型
	 */
	public void gainRoleModulesByRid(){
		String ids = "";
		//根据角色id查询其权限
		roleModuleList = roleService.gainRoleModuleByRoleId(rid);
		if(roleModuleList!=null && roleModuleList.size()>0){
			for (int i = 0; i < roleModuleList.size(); i++) {
				ids+=roleModuleList.get(i).getModuleId()+",";
			}
			ids = ids.substring(0,ids.length()-1);
		}
		writeJson(ids);
	}
	
	/**
	 * 查询角色列表
	 */
	public void gainRoleListForCombobox(){
		writeJson(roleService.gainRoleListForCombobox(role));
	}
	
	public String getMids() {
		return mids;
	}

	public void setMids(String mids) {
		this.mids = mids;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}
	
}
