/**  
* @Title: AdminServiceImpl.java
* @Package com.sanji.sjzx.authorityManage.admin.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2014-9-5 上午9:35:50
* @version V1.0  
*/
package com.sanji.sjzx.authorityManage.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.authorityManage.admin.dao.AdminRoleMapper;
import com.sanji.sjzx.authorityManage.admin.service.AdminService;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.login.dao.AdminMapper;
import com.sanji.sjzx.model.Admin;
import com.sanji.sjzx.model.AdminRole;
import com.sanji.sjzx.pojo.DataGrid;

/**
 * @ClassName: AdminServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-5 上午9:35:50
 */
@Service("adminService")
@Transactional(rollbackFor=Exception.class)
public class AdminServiceImpl implements AdminService {
	@Resource
	private AdminMapper adminMapper;
	@Resource
	private AdminRoleMapper adminRoleMapper;
	
	/**
	 * (non-Javadoc)
	 * @Title: gainAdminList
	 * @Description: TODO(获取用户列表(分页))
	 * @param admin
	 * @return
	 */
	public DataGrid gainAdminList(Admin admin) {
		DataGrid j=new DataGrid();
		j.setRows(adminMapper.gainAdminList(admin));
		j.setTotal(adminMapper.gainAdminCount(admin));
		return j;
	}
	
	/**
	 * (non-Javadoc)
	 * @Title: addAdmin
	 * @Description: TODO(用户添加)
	 * @param admin
	 * @param adminRole
	 */
    public void addAdmin(Admin admin,AdminRole adminRole){
    	adminRoleMapper.addAdminRole(adminRole);
    	adminMapper.insertSelective(admin);
    }
	
    /**
     * (non-Javadoc)
     * @Title: deleteAdmin
     * @Description: TODO(根据主键id单条或批量删除用户(逻辑删除))
     * @param ids
     */
	public void deleteAdmin(List<String> ids) {
		adminMapper.deleteAdmin(ids);
	}
	
	/**
	 * (non-Javadoc)
	 * @Title: dropAdmin
	 * @Description: TODO(根据主键id单条或批量删除用户(物理删除))
	 * @param ids
	 */
	public void dropAdmin(List<String> ids) {
		adminRoleMapper.dropAdminRoleByAids(ids);
		adminMapper.dropAdmin(ids);
	}

	/**
	 * (non-Javadoc)
	 * @Title: modifyAdmin
	 * @Description: TODO(用户修改)
	 * @param admin
	 */
	public void modifyAdmin(Admin admin) {
		adminMapper.updateByPrimaryKeySelective(admin);
	}
	public void modifyAdmin(Admin admin,AdminRole adminRole) {
		adminRoleMapper.modifyAdminRole(adminRole);
		adminMapper.updateByPrimaryKeySelective(admin);
	}
	/**
	 * (non-Javadoc)
	 * @Title: addAdminRole
	 * @Description: TODO(批量设置角色)
	 * @param adminRole
	 * @param aids
	 */
	public void addAdminRoleForBatch(AdminRole adminRole, List<String> aids) {
		String rid = adminRole.getRoleId();
		AdminRole ar;
		List<AdminRole> adminRoles = new ArrayList<AdminRole>();
		if(aids!=null && aids.size()>0){
			for (int i = 0; i < aids.size(); i++) {
				ar = new AdminRole();
				ar.setId(ToolsUtil.getUUID());
				ar.setAdminId(aids.get(i));
				ar.setRoleId(rid);
				ar.setCreatetime(new Date());
				ar.setModifytime(new Date());
				ar.setUserId("1");
				adminRoles.add(ar);
			}
			adminRoleMapper.addAdminRoleForBatch(adminRoles);
		}
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainIsExistUsername
	 * @Description: TODO(查询验证用户名是否存在)
	 * @param username
	 * @return
	 */
	public boolean gainIsExistUsername(String id,String username,String index) {
		List<Admin> adminList = new ArrayList<Admin>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("username", username);
		if(index.equals("1")){
			adminList = adminMapper.gainAdminByUsername(username);
		}else{
			adminList = adminMapper.gainAdminForExceptUsername(map);
		}
		if(adminList!=null && adminList.size()>0){
			return false;
		}else{
			return true;
		}
	}

	/** (non-Javadoc)
	 * @Title: gainIsExistMobilephone
	 * @Description: TODO(查询验证手机号码是否存在)
	 * @param mobilephone
	 * @return
	 */
	public boolean gainIsExistMobilephone(String id,String mobilephone,String index) {
		List<Admin> adminList = new ArrayList<Admin>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("mobilephone", mobilephone);
		if(index.equals("1")){
			adminList = adminMapper.gainAdminByMobilephone(mobilephone);
		}else{
			adminList = adminMapper.gainAdminForExceptMobilephone(map);
		}
		if(adminList!=null && adminList.size()>0){
			return false;
		}else{
			return true;
		}
	}

	/** (non-Javadoc)
	 * @Title: gainIsExistEmail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param email
	 * @return
	 */
	public boolean gainIsExistEmail(String id,String email,String index) {
		List<Admin> adminList = new ArrayList<Admin>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("email", email);
		if(index.equals("1")){
			adminList = adminMapper.gainAdminByEmail(email);
		}else{
			adminList = adminMapper.gainAdminForExceptEmail(map);
		}
		if(adminList!=null && adminList.size()>0){
			return false;
		}else{
			return true;
		}
	}

	/** (non-Javadoc)
	 * @Title: gainAdminById
	 * @Description: TODO(根据主键查询)
	 * @param id
	 * @return
	 */
	public Admin gainAdminById(String id) {
		return adminMapper.gainAdminById(id);
	}
	/** (non-Javadoc)
	 * @Title: gainAdminByIdForImageUrl
	 * @Description: TODO(根据主键查询)
	 * @param id
	 * @return
	 */
	public String gainAdminByIdForImageUrl(String id) {
		String img = adminMapper.gainAdminByIdForImageUrl(id);
		if(null != img && !"".equals(img)){
			return img;
		}
		return null;
	}

	public String gainAdminPwdById(String id) {
		String pwd = adminMapper.gainPwdById(id);
		if(null != pwd && !"".equals(pwd)){
			return pwd;
		}
		return null;
		
	}
}
