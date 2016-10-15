/**  
* @Title: AdminAction.java
* @Package com.sanji.sjzx.authorityManage.admin.action
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2014-9-4 下午7:15:04
* @version V1.0  
*/
package com.sanji.sjzx.authorityManage.admin.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.authorityManage.admin.dao.AdminRoleMapper;
import com.sanji.sjzx.authorityManage.admin.service.AdminInfoMsgService;
import com.sanji.sjzx.authorityManage.admin.service.AdminService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.MD5;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.Admin;
import com.sanji.sjzx.model.AdminInfoMsg;
import com.sanji.sjzx.model.AdminRole;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;

/**
 * @ClassName: AdminAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-4 下午7:15:04
 */
@Namespace("/admin")
@Action(value = "adminAction", results = {
		@Result(name = "toAdminList", location = "/admin/user/list.jsp"),
		@Result(name = "toAdd", location = "/admin/user/add.jsp"),
		@Result(name = "toUpdate", location = "/admin/user/edit.jsp"),
		@Result(name = "toUpdatePassword", location = "/admin/user/editPassword.jsp"),
		@Result(name = "toBatchSetRole", location = "/admin/user/setRole.jsp"),
		@Result(name = "toMsgAuthorize", location = "/admin/user/msgAuthorize.jsp"),
		@Result(name = "toShowUser", location = "/admin/user/showUser.jsp")})
public class AdminAction extends BaseAction implements ModelDriven<Admin>{
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminAction.class);
	private Admin admin = new Admin();
	private AdminRole adminRole = new AdminRole();
	private boolean flag = false;
	private boolean flag1 = false;
	private boolean flag2 = false;
	private String oldPassword;
	private String rePassword;
	private SessionInfo sInfo = null;
	private String aid;
	private String mids;
	private String infoType;
	
	@Resource
	private AdminService adminService;
	@Resource
	private AdminInfoMsgService adminInfoMsgService;
	
	/**
	 * 跳转到用户列表页面
	* @Title: toAdminList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public String toAdminList(){
		return "toAdminList";
	}

	/**
	 * 获取用户列表
	 * @return
	 */
	public void gainAdminList(){
		try {
			super.writeJson(adminService.gainAdminList(admin));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainAdminList() occur error. ", e);
		}
	}
	
	/**
	 * 跳转到用户添加页面
	 * @return
	 */
	public String toAdd(){
		return "toAdd";
	}
	
	/**
	 * 用户添加
	 */
	public void addAdmin(){
		Json j = new Json();
		try {
			sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			//查询验证用户名是否存在
			flag = adminService.gainIsExistUsername(null,admin.getUsername(),"1");
			//查询验证手机号码是否存在
			flag1 = adminService.gainIsExistMobilephone(null,admin.getMobilephone(),"1");
			//查询验证邮箱是否存在
			flag2 = adminService.gainIsExistEmail(null,admin.getEmail(),"1");
			if(!flag){//用户名存在
				j.setMsg("此用户名已存在,请更换其用户名！");
				j.setSuccess(false);				
			}else if(!flag1){//手机号码存在
				j.setMsg("此手机号码已存在,请填写其它手机号码！");
				j.setSuccess(false);				
			}else if(!flag2){//邮箱存在
				j.setMsg("此邮箱已存在,请填写其它邮箱！");
				j.setSuccess(false);					
			}else{
				admin.setId(ToolsUtil.getUUID());
				//将密码进行MD5加密
				admin.setPassword(MD5.encrypt(admin.getPassword()));
				admin.setUserUrl(admin.getUserUrl());
				admin.setCreatetime(new Date());
				admin.setModifytime(new Date());
				admin.setUserId(sInfo.getUserId());
				adminRole = getAR();
				adminRole.setAdminId(admin.getId());
				adminService.addAdmin(admin,adminRole);
				j.setMsg("添加成功！");
				j.setSuccess(true);					
			}
		} catch (Exception e) {
			j.setMsg("添加失败！");
			j.setSuccess(false);
			logger.error("addAdmin() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 为AdminRole设置值
	 * @return
	 */
	private AdminRole getAR(){
		sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		adminRole.setId(ToolsUtil.getUUID());
		adminRole.setRoleId(admin.getRoleId());
		adminRole.setCreatetime(new Date());
		adminRole.setModifytime(new Date());
		adminRole.setUserId(sInfo.getUserId());
		return adminRole;
	}
	
	/**
	 * 跳转到用户修改页面
	 * @return
	 */
	public String toUpdate(){
		String imgUrl = adminService.gainAdminByIdForImageUrl(admin.getId());
		request.setAttribute("imgUrl", imgUrl);
		return "toUpdate";
	}
	/**
	 * 跳转到用户密码修改页面
	 * @return
	 */
	public String toUpdatePassword(){
		return "toUpdatePassword";
	}
	/***
	 * 用户密码修改
	 */
	public void updatepwd(){
		Json j = new Json();
		SessionInfo sessionInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		String oldpwd = MD5.encrypt(oldPassword);
		if(null != oldpwd &&  !"".equals(oldpwd)){
			if(oldpwd.equals(adminService.gainAdminPwdById(admin.getId()))){
				try {
				admin.setPassword(MD5.encrypt(rePassword));
				admin.setModifytime(new Date());
				admin.setId(admin.getId());
				admin.setUserId(sessionInfo.getUserId());
				adminService.modifyAdmin(admin);
				j.setMsg("修改成功！");
				j.setSuccess(true);
				j.setObj(admin);
			} catch (Exception e) {
				j.setMsg("修改失败！");
				j.setSuccess(false);
				logger.error("updatepwd() occur error. ", e);
				e.printStackTrace();
			}
			}else{
				j.setMsg("原始密码不正确，请重新输入！");
				j.setSuccess(false);
			}
		}
		writeJson(j);
	}
	/**
	 * 用户修改
	 */
	public void updateAdmin(){
		Json j = new Json();
		try {
			sInfo = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
			//查询验证用户名是否存在
			flag = adminService.gainIsExistUsername(admin.getId(),admin.getUsername(),"2");
			//查询验证手机号码是否存在
			flag1 = adminService.gainIsExistMobilephone(admin.getId(),admin.getMobilephone(),"2");
			//查询验证邮箱是否存在
			flag2 = adminService.gainIsExistEmail(admin.getId(),admin.getEmail(),"2");
			if(!flag){//用户名存在
				j.setMsg("此用户名已存在,请更换其用户名！");
				j.setSuccess(false);				
			}else if(!flag1){//手机号码存在
				j.setMsg("此手机号码已存在,请填写其它手机号码！");
				j.setSuccess(false);				
			}else if(!flag2){//邮箱存在
				j.setMsg("此邮箱已存在,请填写其它邮箱！");
				j.setSuccess(false);					
			}else{
				admin.setModifytime(new Date());
				admin.setUserId(sInfo.getUserId());
				adminRole.setId(admin.getArId());
				adminRole.setModifytime(new Date());
				adminRole.setUserId(sInfo.getUserId());
				adminRole.setRoleId(admin.getRoleId());
				adminService.modifyAdmin(admin,adminRole);
				j.setMsg("修改成功！");
				j.setSuccess(true);				
			}
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
			logger.error("updateAdmin() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 *  单条或批量删除用户(逻辑删除)
	 */
	public void deleteAdmin(){
		Json j = new Json();
		try {
			adminService.deleteAdmin(ToolsUtil.StringConvertList(admin.getIds()));
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("deleteAdmin() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 *  单条或批量删除用户(物理删除)
	 */
	public void dropAdmin(){
		Json j = new Json();
		try {
			adminService.dropAdmin(ToolsUtil.StringConvertList(admin.getIds()));
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("dropAdmin() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 *   跳转到批量设置角色页面
	 * @return
	 */
	public String toBatchSetRole(){
		return "toBatchSetRole";
	}
	/**
	 * 批量设置角色
	 */
	public void addAdminRole(){
		Json j = new Json();
		try {
			adminRole.setRoleId(admin.getRoleId());
			adminService.addAdminRoleForBatch(adminRole, ToolsUtil.StringConvertList(admin.getIds()));
			j.setMsg("设置成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("设置失败！");
			j.setSuccess(false);
			logger.error("addAdminRole() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);		
	}

	/**
	 * @Title: toShowUser
	 * @Description: TODO(首页个人信息)
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public String toShowUser(){
		admin = adminService.gainAdminById(admin.getId());
		return "toShowUser";
	}
	
	/**
	 * 短信通知授权
	* @Title: toMsgAuthorize
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public String toMsgAuthorize(){
		
		return "toMsgAuthorize";
	}
	
	public void gainInfoMsgByuserId(){
		String ids = "";
		AdminInfoMsg adminInfoMsg = new AdminInfoMsg();
		adminInfoMsg.setUserId(aid);
		adminInfoMsg.setType(infoType);
		List<AdminInfoMsg> adminInfoMsgs = adminInfoMsgService.gainInfoMsgByUserId(adminInfoMsg);
		if (adminInfoMsgs != null && adminInfoMsgs.size() >0) {
			for (int i = 0; i < adminInfoMsgs.size(); i++) {
				ids+=adminInfoMsgs.get(i).getRegions()+",";
			}
			ids = ids.substring(0,ids.length()-1);
		}
		super.writeJson(ids);
	}
	
	/**
	 * 添加短信授权
	* @Title: addMsgAuthorize
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void addMsgAuthorize(){
		Json json = new Json();
		try {
			AdminInfoMsg adminInfoMsg = new AdminInfoMsg();
			adminInfoMsg.setType(infoType);
			adminInfoMsg.setUserId(aid);
			adminInfoMsg.setRegionsList(ToolsUtil.StringConvertList(admin.getIds()));
			adminInfoMsgService.addMsgAuthors(adminInfoMsg);
			json.setMsg("短信授权成功！");
			json.setSuccess(true);
		} catch (Exception e) {
			json.setMsg("短信授权失败！请联系管理员");
			json.setSuccess(false);
			e.printStackTrace();
		}
		
		super.writeJson(json);
	}
	
	
	/* (非 Javadoc)
	* <p>Title: getModel</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.ModelDriven#getModel()
	*/
	
	/**
	 * @return the admin
	 */
	public Admin getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 * @return the adminRole
	 */
	public AdminRole getAdminRole() {
		return adminRole;
	}

	/**
	 * @param adminRole the adminRole to set
	 */
	public void setAdminRole(AdminRole adminRole) {
		this.adminRole = adminRole;
	}

	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	/**
	 * @return the flag1
	 */
	public boolean isFlag1() {
		return flag1;
	}

	/**
	 * @param flag1 the flag1 to set
	 */
	public void setFlag1(boolean flag1) {
		this.flag1 = flag1;
	}

	/**
	 * @return the flag2
	 */
	public boolean isFlag2() {
		return flag2;
	}

	/**
	 * @param flag2 the flag2 to set
	 */
	public void setFlag2(boolean flag2) {
		this.flag2 = flag2;
	}

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the rePassword
	 */
	public String getRePassword() {
		return rePassword;
	}

	/**
	 * @param rePassword the rePassword to set
	 */
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	/**
	 * @return the sInfo
	 */
	public SessionInfo getsInfo() {
		return sInfo;
	}

	/**
	 * @param sInfo the sInfo to set
	 */
	public void setsInfo(SessionInfo sInfo) {
		this.sInfo = sInfo;
	}

	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}

	/**
	 * @return the aid
	 */
	public String getAid() {
		return aid;
	}

	/**
	 * @param aid the aid to set
	 */
	public void setAid(String aid) {
		this.aid = aid;
	}

	/**
	 * @return the mids
	 */
	public String getMids() {
		return mids;
	}

	/**
	 * @param mids the mids to set
	 */
	public void setMids(String mids) {
		this.mids = mids;
	}

	/**
	 * @return the infoType
	 */
	public String getInfoType() {
		return infoType;
	}

	/**
	 * @param infoType the infoType to set
	 */
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}


}
