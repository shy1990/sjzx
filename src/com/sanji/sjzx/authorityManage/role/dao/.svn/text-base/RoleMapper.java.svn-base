package com.sanji.sjzx.authorityManage.role.dao;

import java.util.List;

import com.sanji.sjzx.model.Role;



public interface RoleMapper {
	
	/**
	 * @Title: modifyRole
	 * @Description: TODO(修改角色)
	 * @param @param role    设定文件
	 * @return void    返回类型
	 */
	public void modifyRole(Role role);

	/**
	 * @Title: gainRoleList
	 * @Description: TODO(查询角色列表信息)
	 * @param @param role
	 * @param @return    设定文件
	 * @return List<Role>    返回类型
	 */
    public List<Role> gainRoleList(Role role);
    
    /**
     * @Title: gainRoleCount
     * @Description: TODO(查询总行数)
     * @param @param role
     * @param @return    设定文件
     * @return Long    返回类型
     */
    public Long gainRoleCount(Role role);
    
    /**
     * @Title: addRole
     * @Description: TODO(添加角色)
     * @param @param role    设定文件
     * @return void    返回类型
     */
    public void addRole(Role role);
    
    /**
     * @Title: deleteRole
     * @Description: TODO(单条或批量删除角色(逻辑删除))
     * @param @param ids    设定文件
     * @return void    返回类型
     */
    public void deleteRole(List<String> ids);
    
    /**
     * @Title: dropRole
     * @Description: TODO(单条或批量删除角色(物理删除))
     * @param @param ids    设定文件
     * @return void    返回类型
     */
    public void dropRole(List<String> ids);
    
    /**
     * @Title: gainRoleListForCombobox
     * @Description: TODO(查询角色列表)
     * @param @return    设定文件
     * @return List<Role>    返回类型
     */
    public List<Role> gainRoleListForCombobox();
    
    /**
     * @Title: gainRoleByName
     * @Description: TODO(根据角色名称查询)
     * @param @param name
     * @param @return    设定文件
     * @return List<Role>    返回类型
     */
    public List<Role> gainRoleByName(String name);
    
    /**
     * 根据adminID查询角色信息
     * @Title: gainRoleByAdminId
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param adminId
     * @param @return    设定文件
     * @return List<Role>    返回类型
     * @author 周张豹
     */
    public List<Role> gainRoleByAdminId(String adminId);
}