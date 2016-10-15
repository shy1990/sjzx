/**  
* @Title: AdminService.java
* @Package com.sanji.sjzx.authorityManage.admin.service
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2014-9-5 上午9:24:34
* @version V1.0  
*/
package com.sanji.sjzx.authorityManage.admin.service;

import java.util.List;

import com.sanji.sjzx.model.Admin;
import com.sanji.sjzx.model.AdminRole;
import com.sanji.sjzx.pojo.DataGrid;


/**
 * @ClassName: AdminService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-5 上午9:24:34
 */
public interface AdminService {
	
	/**
	 * 获取用户列表
	 * @Title: gainAdminList
	 * @Description: TODO(获取用户列表)
	 * @param @param admin
	 * @param @return    设定文件
	 * @return DataGrid    返回类型
	 */
	public DataGrid gainAdminList(Admin admin);
	
	/**
	 * 新增用户
	 * @Title: addAdmin
	 * @Description: TODO(用户添加)
	 * @param @param admin
	 * @param @param adminRole    设定文件
	 * @return void    返回类型
	 */
    public void addAdmin(Admin admin,AdminRole adminRole);
    
    /**
     * 根据主键id单条或批量删除用户(逻辑删除)
     * @Title: deleteAdmin
     * @Description: TODO(根据主键id单条或批量删除用户(逻辑删除))
     * @param @param ids    设定文件
     * @return void    返回类型
     */
    public void deleteAdmin(List<String> ids);
    
    /**
     * 根据主键id单条或批量删除用户(物理删除)
     * @Title: dropAdmin
     * @Description: TODO(根据主键id单条或批量删除用户(物理删除))
     * @param @param ids    设定文件
     * @return void    返回类型
     */
    public void dropAdmin(List<String> ids);
    
    /**
     * 用户修改
     * @Title: modifyAdmin
     * @Description: TODO(用户修改)
     * @param @param admin    设定文件
     * @return void    返回类型
     */
    public void modifyAdmin(Admin admin);
    public void modifyAdmin(Admin admin,AdminRole adminRole);
    /**
     * 批量设置角色
     * @Title: addAdminRole
     * @Description: TODO(批量设置角色)
     * @param @param adminRole
     * @param @param aids    设定文件
     * @return void    返回类型
     */
    public void addAdminRoleForBatch(AdminRole adminRole, List<String> aids);
    
    /**
     * 查询验证用户名是否存在
     * @Title: gainIsExistUsername
     * @Description: TODO(查询验证用户名是否存在)
     * @param @param username
     * @param @return    设定文件
     * @return boolean    返回类型
     */
    public boolean gainIsExistUsername(String id,String username,String index);
    
    /**
     * 查询验证手机号码是否存在
     * @Title: gainIsExistMobilephone
     * @Description: TODO(查询验证手机号码是否存在)
     * @param @param mobilephone
     * @param @return    设定文件
     * @return boolean    返回类型
     */
    public boolean gainIsExistMobilephone(String id,String mobilephone,String index);
    
    /**
     * 查询验证邮箱是否存在
     * @Title: gainIsExistEmail
     * @Description: TODO(查询验证邮箱是否存在)
     * @param @param email
     * @param @return    设定文件
     * @return boolean    返回类型
     */
    public boolean gainIsExistEmail(String id,String email,String index);
    
    /**
     * 根据主键查询
     * @Title: gainAdminById
     * @Description: TODO(根据主键查询)
     * @param @param id
     * @param @return    设定文件
     * @return Admin    返回类型
     */
    public Admin gainAdminById(String id);
    /**
     * 根据主键查询用户照片url
     * @Title: gainAdminByIdForImageUrl
     * @Description: TODO(根据主键查询)
     * @param @param id
     * @param @return    设定文件
     * @return String    返回类型
     */
	public String gainAdminByIdForImageUrl(String id);
	 /**
     * 根据主键查询用户密码
     * @Title: gainAdminPwdById
     * @Description: TODO(根据主键查询)
     * @param @param id
     * @param @return    设定文件
     * @return String    返回类型
     */
	public String gainAdminPwdById(String id);

}
