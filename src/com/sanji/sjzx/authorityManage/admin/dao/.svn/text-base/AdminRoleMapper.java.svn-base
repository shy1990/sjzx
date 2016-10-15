package com.sanji.sjzx.authorityManage.admin.dao;

import java.util.List;

import com.sanji.sjzx.model.AdminRole;



public interface AdminRoleMapper {
    
    /**
     * 批量设置角色
     * @Title: addAdminRole
     * @Description: TODO(批量设置角色)
     * @param @param adminRoles    设定文件
     * @return void    返回类型
     */
    public void addAdminRoleForBatch(List<AdminRole> adminRoles);
    
    /**
     * 单用户设置角色
     * @Title: addAdminRole
     * @Description: TODO(单用户设置角色)
     * @param @param adminRole    设定文件
     * @return void    返回类型
     */
    public void addAdminRole(AdminRole adminRole);

    /**
     * 删除用户角色信息(物理删除)
     * @Title: dropAdminRoleByAids
     * @Description: TODO(删除用户角色信息(物理删除))
     * @param @param aids    设定文件
     * @return void    返回类型
     */
    public void dropAdminRoleByAids(List<String> aids);
    
    /**
     * 修改用户角色
     * @Title: modifyAdminRoleByAid
     * @Description: TODO(修改用户角色)
     * @param @param aid    设定文件
     * @return void    返回类型
     */
    public void modifyAdminRole(AdminRole adminRole);
    
    /**
     * 根据角色id查询
     * @Title: gainAdminRoleByRoleId
     * @Description: TODO(根据角色id查询)
     * @param @param roleId
     * @param @return    设定文件
     * @return List<AdminRole>    返回类型
     */
    public List<AdminRole> gainAdminRoleByRoleId(List<String> ids);
}