package com.sanji.sjzx.authorityManage.role.dao;

import java.util.List;

import com.sanji.sjzx.model.RoleModule;


public interface RoleModuleMapper {
    
	/**
	 * @Title: addAuthorize
	 * @Description: TODO(授权)
	 * @param @param roleModules    设定文件
	 * @return void    返回类型
	 */
    public void addAuthorize(List<RoleModule> roleModules);
    
    /**
     * @Title: dropRoleModuleByRoleId
     * @Description: TODO(根据角色id删除其权限(物理删除))
     * @param @param roleId    设定文件
     * @return void    返回类型
     */
    public void dropRoleModuleByRoleId(String roleId);
    public void dropRoleModuleByRids(List<String> ids);
    
    /**
     * @Title: gainRoleModuleByRoleId
     * @Description: TODO(根据角色id查询其权限)
     * @param @param roleId
     * @param @return    设定文件
     * @return List<RoleModule>    返回类型
     */
    public List<RoleModule> gainRoleModuleByRoleId(String roleId);
    
    /**
     * @Title: gainRoleModuleByMid
     * @Description: TODO(根据模块id查询)
     * @param @param mid
     * @param @return    设定文件
     * @return List<RoleModule>    返回类型
     */
    public List<RoleModule> gainRoleModuleByMid(String mid);
    
    public List<RoleModule> gainRoleModuleByRid(String roleId);
    
    /**
     * @Title: gainModuleIdsByRoleId
     * @Description: TODO(根据角色id查询权限id集合)
     * @param @param roleId
     * @param @return    设定文件
     * @return List<String>    返回类型
     */
    public List<String> gainModuleIdsByRoleId(String roleId);
    
    /**
     * @Title: dropRoleModuleByIds
     * @Description: TODO(根据主键ID删除权限信息(物理删除)) 
     * @param @param ids    设定文件 
     * @return void 返回类型 
     * @author wangmei
     */
    public void dropRoleModuleByIds(List<String> ids);
}