package com.sanji.sjzx.pojo;

import java.util.List;

import com.sanji.sjzx.model.Module;





/**
 * 登录信息
* @ClassName: SessionInfo
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 周张豹
* @date 2014-7-15 下午1:47:09
 */
public class SessionInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String userId;// 用户ID
	private String loginName;// 用户登录名称
	private String loginPassword;// 登录密码
	private String userName;
	private String ip;// IP地址
	private List<Module> modules;//权限集合
	private String roleIds;
	private String roleNames;


	private String msg;


	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}


	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	/**
	 * @return the loginPassword
	 */
	public String getLoginPassword() {
		return loginPassword;
	}


	/**
	 * @param loginPassword the loginPassword to set
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}


	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}


	/**
	 * @return the modules
	 */
	public List<Module> getModules() {
		return modules;
	}


	/**
	 * @param modules the modules to set
	 */
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}


	/**
	 * @return the roleIds
	 */
	public String getRoleIds() {
		return roleIds;
	}


	/**
	 * @param roleIds the roleIds to set
	 */
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}


	/**
	 * @return the roleNames
	 */
	public String getRoleNames() {
		return roleNames;
	}


	/**
	 * @param roleNames the roleNames to set
	 */
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}


	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}


	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
}
