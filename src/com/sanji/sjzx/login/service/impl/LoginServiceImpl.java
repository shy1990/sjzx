/**  
* @Title: LoginServiceImpl.java
* @Package com.sanji.sjzx.login.service
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2014-9-3 下午3:28:55
* @version V1.0  
*/
package com.sanji.sjzx.login.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sanji.sjzx.authorityManage.module.dao.ModuleMapper;
import com.sanji.sjzx.authorityManage.role.dao.RoleMapper;
import com.sanji.sjzx.login.dao.AdminMapper;
import com.sanji.sjzx.login.service.LoginService;
import com.sanji.sjzx.model.Admin;
import com.sanji.sjzx.model.Module;
import com.sanji.sjzx.model.Role;
import com.sanji.sjzx.pojo.SessionInfo;

/**
 * @ClassName: LoginServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-3 下午3:28:55
 */
@Service("loginService")
@Transactional(rollbackFor=Exception.class)
public class LoginServiceImpl implements LoginService{
	
	@Resource
	private AdminMapper adminMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private ModuleMapper moduleMapper;

	/* (非 Javadoc)
	* <p>Title: gainUserAuthority</p>
	* <p>Description: </p>
	* @param admin
	* @return
	* @see com.sanji.sjzx.login.service.LoginService#gainUserAuthority(com.sanji.sjzx.model.Admin)
	*/
	
	public SessionInfo gainUserAuthority(Admin admin) {
		SessionInfo sessionInfo = new SessionInfo();
		// 根据用户ID查询角色信息
		List<Role> roles = roleMapper.gainRoleByAdminId(admin.getId());
		Role role = roles.size()==0? null: roles.get(0);
		//根据角色ID查询该角色下的权限
		List<Module> modules = moduleMapper.gainModuleByRoleID(role==null?"":role.getId());
		sessionInfo.setUserId(admin==null?"":admin.getId());
		sessionInfo.setLoginName(admin==null?"":admin.getUsername());
		sessionInfo.setLoginPassword(admin==null?"":admin.getPassword());
		sessionInfo.setUserName(admin==null?"":admin.getTruename());
		sessionInfo.setRoleIds(role==null?"":role.getId());
		sessionInfo.setRoleNames(role==null?"":role.getName());
		sessionInfo.setModules(modules);
		return sessionInfo;
	}

	/* (非 Javadoc)
	* <p>Title: gainAdmin</p>
	* <p>Description: </p>
	* @param username
	* @param password
	* @return
	* @see com.sanji.sjzx.login.service.LoginService#gainAdmin(java.lang.String, java.lang.String)
	*/
	
	public Admin gainAdmin(String username, String password) {
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("username", username);
		map.put("password", password);
		return adminMapper.gainAdminByCondition(map);
	}

}
