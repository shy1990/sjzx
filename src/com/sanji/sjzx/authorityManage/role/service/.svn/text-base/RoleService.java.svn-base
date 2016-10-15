package com.sanji.sjzx.authorityManage.role.service;

import java.util.List;

import com.sanji.sjzx.model.Role;
import com.sanji.sjzx.model.RoleModule;
import com.sanji.sjzx.pojo.DataGrid;


public interface RoleService {
	
	/**
	 * @Title: gainRoleList
	 * @Description: TODO(查询角色列表信息)
	 * @param @param role
	 * @param @return    设定文件
	 * @return DataGrid    返回类型
	 */
    public DataGrid gainRoleList(Role role);
    
    /**
     * @Title: addRole
     * @Description: TODO(添加角色)
     * @param @param role    设定文件
     * @return void    返回类型
     */
    public void addRole(Role role,List<String> mids);
    
    /**
     * @Title: modifyRole
     * @Description: TODO(修改角色)
     * @param @param role    设定文件
     * @return void    返回类型
     */
    public void modifyRole(Role role,List<String> mids);
    
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
     * @Title: addAuthorize
     * @Description: TODO(授权)
     * @param @param rm
     * @param @param mids    设定文件
     * @return void    返回类型
     */
    public void addAuthorize(RoleModule rm, List<String> mids);
    
    /**
     * @Title: gainRoleModuleByRoleId
     * @Description: TODO(根据角色id查询其权限)
     * @param @param roleId
     * @param @return    设定文件
     * @return List<RoleModule>    返回类型
     */
    public List<RoleModule> gainRoleModuleByRoleId(String roleId);
    
    /**
     * @Title: gainRoleListForCombobox
     * @Description: TODO(查询角色列表)
     * @param @return    设定文件
     * @return List<Role>    返回类型
     */
    public DataGrid gainRoleListForCombobox(Role role);
    
    /**
     * @Title: gainIsExistRoleName
     * @Description: TODO(查询验证角色名称是否存在)
     * @param @param name
     * @param @return    设定文件
     * @return boolean    返回类型
     */
    public boolean gainIsExistName(String name);
    
    /**
     * @Title: gainModuleIdsByRoleId
     * @Description: TODO(根据角色id查询权限id集合)
     * @param @param roleId
     * @param @return    设定文件
     * @return List<String>    返回类型
     */
    public List<String> gainModuleIdsByRoleId(String roleId);
    
    /**
     * @Title: gainIsExistRoleId
     * @Description: TODO(查询验证角色是否被使用)
     * @param @param roleId
     * @param @return    设定文件
     * @return boolean    返回类型
     */
    public boolean gainIsExistRoleId(List<String> ids);
}
