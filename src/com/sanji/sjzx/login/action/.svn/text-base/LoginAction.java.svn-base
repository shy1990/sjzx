/**  
* @Title: LoginAction.java
* @Package com.sanji.sjzx.login.action
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2014-9-3 下午2:45:51
* @version V1.0  
*/
package com.sanji.sjzx.login.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;


import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.MD5;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.login.service.LoginService;
import com.sanji.sjzx.model.Admin;
import com.sanji.sjzx.pojo.SessionInfo;

/**
 * @ClassName: LoginAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-3 下午2:45:51
 */
@Action(value = "loginAction", results = {
		@Result(name = "login",  location = "/index.jsp"),
		@Result(name = "noSession", location = "/login.jsp") })
public class LoginAction extends BaseAction implements ModelDriven<Admin>{
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 1L;
	
	private Admin admin = new Admin();
	private String username;
	private String password;
	
	@Resource
	private LoginService loginService;
	
	/**
	 * 登录
	* @Title: doNotNeedSession_login
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public String doNotNeedSession_login() {
		
		SessionInfo si = (SessionInfo) session.get(ResourceUtil.getSessionInfoName());
		String un = si==null?null:si.getLoginName();
		String pw = si==null?null:si.getLoginPassword();
		admin = loginService.gainAdmin(admin.getUsername() == null ? un : admin.getUsername().trim(),admin.getPassword() == null?pw:MD5.encrypt(admin.getPassword().trim()));
		if (admin != null) {
			SessionInfo sessionInfo = new SessionInfo();
			try {
				sessionInfo = loginService.gainUserAuthority(admin);
				sessionInfo.setIp(request.getRemoteAddr());
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.put(ResourceUtil.getSessionInfoName(), sessionInfo);
			return "login";
		} else {
			request.setAttribute("msg", "用户名或者密码错误！");
			return "noSession";
		}
	}
	
	public void testSys(){
		System.out.println("你竟然过来了！这有点意外……");
	}
	
	

	/* (非 Javadoc)
	* <p>Title: getModel</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.ModelDriven#getModel()
	*/
	
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}



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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
}
