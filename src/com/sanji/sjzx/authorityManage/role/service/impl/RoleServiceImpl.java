package com.sanji.sjzx.authorityManage.role.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.authorityManage.admin.dao.AdminRoleMapper;
import com.sanji.sjzx.authorityManage.role.dao.RoleMapper;
import com.sanji.sjzx.authorityManage.role.dao.RoleModuleMapper;
import com.sanji.sjzx.authorityManage.role.service.RoleService;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.AdminRole;
import com.sanji.sjzx.model.Role;
import com.sanji.sjzx.model.RoleModule;
import com.sanji.sjzx.pojo.DataGrid;



@Service("roleService")
@Transactional(rollbackFor=Exception.class)
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private RoleModuleMapper roleModuleMapper;
	@Resource
	private AdminRoleMapper adminRoleMapper;
	
	/**
	 * 
	* @Title: gainRoleList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param role
	* @param @return    设定文件
	* @return DataGrid    返回类型
	* @author ZhouZhangbao
	 */
	public DataGrid gainRoleList(Role role) {
		DataGrid j=new DataGrid();
		j.setRows(roleMapper.gainRoleList(role));
		j.setTotal(roleMapper.gainRoleCount(role));
		return j;
	}

	/**
	 * 
	* @Title: addRole
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param role
	* @param @param mids    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void addRole(Role role,List<String> mids) {
		roleMapper.addRole(role);
		if(mids!=null && mids.size()>0){
			roleModuleMapper.addAuthorize(getRoleModules(role, mids));
		}
	}

	/**
	 * 
	* @Title: modifyRole
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param role
	* @param @param mids    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void modifyRole(Role role,List<String> mids) {
		roleMapper.modifyRole(role);
		roleModuleMapper.dropRoleModuleByRoleId(role.getId());
		if(mids!=null && mids.size()>0){
			roleModuleMapper.addAuthorize(getRoleModules(role, mids));
		}
	}
	
	/**
	 * 
	* @Title: getRoleModules
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param role
	* @param @param mids
	* @param @return    设定文件
	* @return List<RoleModule>    返回类型
	* @author ZhouZhangbao
	 */
	private List<RoleModule> getRoleModules(Role role,List<String> mids){
		List<RoleModule> roleModules = new ArrayList<RoleModule>();
		for (int i = 0; i < mids.size(); i++) {
			RoleModule rm = new RoleModule();
			rm.setId(ToolsUtil.getUUID());
			rm.setRoleId(role.getId());
			rm.setModuleId(mids.get(i));
			rm.setCreatetime(new Date());
			rm.setModifytime(new Date());
			rm.setUserId(role.getUserId());
			roleModules.add(rm);
		}
		return roleModules;
	}
	
	/**
	 * 
	* @Title: deleteRole
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param ids    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void deleteRole(List<String> ids) {
		roleMapper.deleteRole(ids);
	}
	
	/**
	 * 
	* @Title: dropRole
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param ids    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void dropRole(List<String> ids) {
		roleModuleMapper.dropRoleModuleByRids(ids);
		roleMapper.dropRole(ids);
	}
	
	/**
	 * 
	* @Title: addAuthorize
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param rm
	* @param @param mids    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void addAuthorize(RoleModule rm, List<String> mids) {
		String rid = rm.getRoleId();
		String uid = rm.getUserId();
		roleModuleMapper.dropRoleModuleByRoleId(rid);
		List<RoleModule> roleModules = new ArrayList<RoleModule>();
		if(mids!=null && mids.size()>0){
			for (int i = 0; i < mids.size(); i++) {
				rm = new RoleModule();
				rm.setId(ToolsUtil.getUUID());
				rm.setRoleId(rid);
				rm.setModuleId(mids.get(i));
				rm.setCreatetime(new Date());
				rm.setModifytime(new Date());
				rm.setUserId(uid);
				roleModules.add(rm);
			}
			roleModuleMapper.addAuthorize(roleModules);
		}
	}

	/**
	 * 
	* @Title: gainRoleModuleByRoleId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param roleId
	* @param @return    设定文件
	* @return List<RoleModule>    返回类型
	* @author ZhouZhangbao
	 */
	public List<RoleModule> gainRoleModuleByRoleId(String roleId) {
		return roleModuleMapper.gainRoleModuleByRoleId(roleId);
	}

	/**
	 * 
	* @Title: gainRoleListForCombobox
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param role
	* @param @return    设定文件
	* @return DataGrid    返回类型
	* @author ZhouZhangbao
	 */
	public DataGrid gainRoleListForCombobox(Role role){
		DataGrid j=new DataGrid();
		List<Role> roleList = roleMapper.gainRoleList(role);
		j.setRows(getRoleList(roleList));
		j.setTotal(Long.parseLong(String.valueOf(roleMapper.gainRoleCount(role))));
		return j;		
	}
	
	/**
	 * 
	* @Title: getRoleList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param roleList
	* @param @return    设定文件
	* @return List<Role>    返回类型
	* @author ZhouZhangbao
	 */
	private List<Role> getRoleList(List<Role> roleList){
		List<Role> list = new ArrayList<Role>();
		Map<String, String> map = new HashMap<String, String>();
		if(roleList!=null && roleList.size()>0){
			for (int i = 0; i < roleList.size(); i++) {
				Role r = roleList.get(i);
				List<RoleModule> rmList = roleModuleMapper.gainRoleModuleByRid(r.getId());
				String str="";
				if(rmList!=null && rmList.size()>0){
					for (int k = 0; k < rmList.size(); k++) {
						RoleModule rm = rmList.get(k);
						str+=rm.getMname()+",";
					}
					str = str.substring(0,str.length()-1);
					map.put(r.getId()+"str", str);					
				}
			}
		}
		Role r2 = null;
		for (int i = 0; i < roleList.size(); i++) {
			Role r = roleList.get(i);
			r2 = new Role();
			r2.setRoleId(r.getId());
			r2.setName(r.getName());
			r2.setStr(map.get(r.getId()+"str"));
			list.add(r2);
		}
		return list;
	}
	/** 
	 * 
	* @Title: gainIsExistName
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param name
	* @param @return    设定文件
	* @return boolean    返回类型
	* @author ZhouZhangbao
	 */
	public boolean gainIsExistName(String name) {
		List<Role> list = roleMapper.gainRoleByName(name);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}

	/** 
	 * 
	* @Title: gainModuleIdsByRoleId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param roleId
	* @param @return    设定文件
	* @return List<String>    返回类型
	* @author ZhouZhangbao
	 */
	public List<String> gainModuleIdsByRoleId(String roleId) {
		return roleModuleMapper.gainModuleIdsByRoleId(roleId);
	}

	/** 
	 * 
	* @Title: gainIsExistRoleId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param ids
	* @param @return    设定文件
	* @return boolean    返回类型
	* @author ZhouZhangbao
	 */
	public boolean gainIsExistRoleId(List<String> ids) {
		List<AdminRole> list = adminRoleMapper.gainAdminRoleByRoleId(ids);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
}
