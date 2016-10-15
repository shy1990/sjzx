package com.sanji.sjzx.login.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.Admin;



public interface AdminMapper {
    
	/**
	 * 插入一条新数据
	* @Title: insertSelective
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author ZhouZhangbao
	 */
	public int insertSelective(Admin record);
	
	

    /**
     * 选择性更新<br> 实体中有值得的更新，为空的保持原有值
    * @Title: updateByPrimaryKeySelective
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param record
    * @param @return    设定文件
    * @return int    返回类型
    * @author ZhouZhangbao
     */
    public int updateByPrimaryKeySelective(Admin record);

    /**
     * 全部更新成为实体中的数据
    * @Title: updateByPrimaryKey
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param record
    * @param @return    设定文件
    * @return int    返回类型
    * @author ZhouZhangbao
     */
    public int updateByPrimaryKey(Admin record);

	/**
	 * 根据用户名或邮箱或手机号码和密码查询
	* @Title: gainAdminByCondition
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return Admin    返回类型
	* @author ZhouZhangbao
	*/
	
	public Admin gainAdminByCondition(Map<String, Object> map);
	
	//-------

	/**
	 * 查询用户列表
	* @Title: gainAdminList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param admin
	* @param @return    设定文件
	* @return List    返回类型
	* @author ZhouZhangbao
	*/
	public List gainAdminList(Admin admin);

	/**
	 * 查询总条数
	* @Title: gainAdminCount
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param admin
	* @param @return    设定文件
	* @return Long    返回类型
	* @author ZhouZhangbao
	*/
	public Long gainAdminCount(Admin admin);

	/**
	 * 批量删除（逻辑删除）
	* @Title: deleteAdmin
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param ids    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	*/
	public void deleteAdmin(List<String> ids);

	/**
	 * 批量删除（物理删除删除）
	* @Title: dropAdmin
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param ids    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	*/
	public void dropAdmin(List<String> ids);

	/**
	 * 根据登陆名查询用户
	* @Title: gainAdminByUsername
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param username
	* @param @return    设定文件
	* @return List<Admin>    返回类型
	* @author ZhouZhangbao
	*/
	public List<Admin> gainAdminByUsername(String username);

	/**
	* @Title: gainAdminForExceptUsername
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return List<Admin>    返回类型
	* @author ZhouZhangbao
	*/
	public List<Admin> gainAdminForExceptUsername(Map<String, String> map);

	/**
	 * 根据手机号查询
	* @Title: gainAdminByMobilephone
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param mobilephone
	* @param @return    设定文件
	* @return List<Admin>    返回类型
	* @author ZhouZhangbao
	*/
	public List<Admin> gainAdminByMobilephone(String mobilephone);

	/**
	* @Title: gainAdminForExceptMobilephone
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return List<Admin>    返回类型
	* @author ZhouZhangbao
	*/
	public List<Admin> gainAdminForExceptMobilephone(Map<String, String> map);

	/**
	 * 根据邮箱查询
	* @Title: gainAdminByEmail
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param email
	* @param @return    设定文件
	* @return List<Admin>    返回类型
	* @author ZhouZhangbao
	*/
	public List<Admin> gainAdminByEmail(String email);

	/**
	* @Title: gainAdminForExceptEmail
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param map
	* @param @return    设定文件
	* @return List<Admin>    返回类型
	* @author ZhouZhangbao
	*/
	public List<Admin> gainAdminForExceptEmail(Map<String, String> map);



	/**
	* @Title: gainAdminById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return Admin    返回类型
	* @author ZhouZhangbao
	*/
	public Admin gainAdminById(String id);

	/**
	* @Title: gainAdminByIdForImageUrl
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return Admin    返回类型
	* @author ZhouZhangbao
	*/

	public String gainAdminByIdForImageUrl(String id);

	/**
	* @Title: gainPwdById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return String    返回类型
	* @author Songbaozhen
	*/

	public String gainPwdById(String id);
}