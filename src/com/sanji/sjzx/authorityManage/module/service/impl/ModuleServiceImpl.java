/**  
* @Title: ModuleServiceImpl.java
* @Package com.sanji.sjzx.authorityManage.module.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2014-9-4 下午4:36:15
* @version V1.0  
*/
package com.sanji.sjzx.authorityManage.module.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.authorityManage.module.dao.ModuleMapper;
import com.sanji.sjzx.authorityManage.module.service.ModuleService;
import com.sanji.sjzx.authorityManage.role.dao.RoleModuleMapper;
import com.sanji.sjzx.model.Module;
import com.sanji.sjzx.model.RoleModule;
import com.sanji.sjzx.pojo.DataGrid;

/**
 * @ClassName: ModuleServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-4 下午4:36:15
 */
@Service("moduleService")
@Transactional(rollbackFor=Exception.class)
public class ModuleServiceImpl implements ModuleService{
	@Resource 
	private ModuleMapper moduleMapper;
	@Resource
	private RoleModuleMapper roleModuleMapper;
	
	/**
	 * (non-Javadoc)
	 * @Title: gainModuleList
	 * @Description: TODO(查询模块列表信息)
	 * @param module
	 * @return
	 */
	public DataGrid gainModuleList(Module module) {
		DataGrid j=new DataGrid();
		System.out.println(moduleMapper.gainModuleList(module).size());
		j.setRows(moduleMapper.gainModuleList(module));
		j.setTotal(moduleMapper.gainModuleCount(module));
		return j;
	}
	public List<Module> gainModuleList1(Module module,String num) {
		List<Module> list = new ArrayList<Module>();
		if(num.equals("1")){
			list = moduleMapper.gainModuleList1(module);
		}else if(num.equals("2")){
			list = moduleMapper.gainModuleListForExcept(module.getId());
		}else{
			list = moduleMapper.gainModuleAll();
		}
		return list;
    }

	public List<Module> gainModuleList() {
		return moduleMapper.gainModuleList();
	}
	/**
	 * (non-Javadoc)
	 * @Title: addModule
	 * @Description: TODO(添加模块)
	 * @param module
	 */
	public void addModule(Module module) {
		List<Module> moduleList = moduleMapper.gainModuleById(module.getPid());
		if(moduleList!=null && moduleList.size()>0){         
			if(moduleList.get(0).getPtree() != null){
				module.setPtree(moduleList.get(0).getPtree()+module.getPid()+",");
			}else{
				module.setPtree(module.getPid()+",");
			}
			module.setGrade(moduleList.get(0).getGrade()+1);
			module.setPname(moduleList.get(0).getName());
		}
		moduleMapper.addModule(module);
		
		// 根据父模块ID查询其权限信息
		List<RoleModule> roleModules = roleModuleMapper.gainRoleModuleByMid(module.getPid());
		if(roleModules != null && roleModules.size() > 0){
			List<String> list = new ArrayList<String>();
			for (RoleModule rm : roleModules) {
				list.add(rm.getId());
			}
			roleModuleMapper.dropRoleModuleByIds(list);
		}
	}
	
	/**
	 * (non-Javadoc)
	 * @Title: modifyModule
	 * @Description: TODO(修改模块)
	 * @param module
	 */
	public void modifyModule(Module module) {
		List<Module> moduleList = moduleMapper.gainModuleById(module.getPid());
		if(moduleList!=null && moduleList.size()>0){
			if(moduleList.get(0).getPtree() != null){
				module.setPtree(moduleList.get(0).getPtree()+module.getPid()+",");
			}else{
				module.setPtree(module.getPid()+",");
			}
			module.setGrade(moduleList.get(0).getGrade()+1);
			module.setPname(moduleList.get(0).getName());
		}
		moduleMapper.modifyModule(module);
	}
	
	/**
	 * (non-Javadoc)
	 * @Title: deleteModule
	 * @Description: TODO(删除模块(逻辑删除))
	 * @param id
	 */
	public void deleteModule(String id) {
		moduleMapper.deleteModule(id);
	}
	
	/**
	 * (non-Javadoc)
	 * @Title: dropModule
	 * @Description: TODO(删除模块(物理删除))
	 * @param id
	 */
	public void dropModule(String id) {
		moduleMapper.dropModule(id);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainRootModule
	 * @Description: TODO(查询模块根节点)
	 * @return
	 */
	public List<Module> gainRootModule() {
		return moduleMapper.gainRootModule();
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainChildModuleListByPid
	 * @Description: TODO(根据父模块id查询子模块)
	 * @param pid
	 * @return
	 */
	public List<Module> gainChildModuleListByPid(String pid) {
		return moduleMapper.gainChildModuleListByPid(pid);
	}

	/**
	 * (non-Javadoc)
	 * @Title: gainIsExistChildModule
	 * @Description: TODO(查询验证该模块是否含有子模块)
	 * @param pid
	 * @return
	 */
	public boolean gainIsExistChildModule(String pid) {
		List<Module> moduleList = gainChildModuleListByPid(pid);
		if(moduleList!=null && moduleList.size()>0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * (non-Javadoc)
	 * @Title: gainRoleModuleByMid
	 * @Description: TODO(根据模块id查询)
	 * @param mid
	 * @return
	 */
	public List<RoleModule> gainRoleModuleByMid(String mid) {
		return roleModuleMapper.gainRoleModuleByMid(mid);
	}
	
	/**
	 * (non-Javadoc)
	 * @Title: gainIsAuthorizeModule
	 * @Description: TODO(查询验证该模块是否作为权限被分配)
	 * @param mid
	 * @return
	 */
	public boolean gainIsAuthorizeModule(String mid) {
		List<RoleModule> list = gainRoleModuleByMid(mid);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * (non-Javadoc)
	 * @Title: gainIsExistName
	 * @Description: TODO(根据模块名称查询)
	 * @param name
	 * @return
	 */
	public boolean gainIsExistName(String name) {
		List<Module> list = moduleMapper.gainModuleByName(name);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/** (non-Javadoc)
	 * @Title: gainModuleBySq
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param rid
	 * @return
	 */
	public List<Module> gainModuleBySq1(String rid) {
		return moduleMapper.gainModuleBySq1(rid);
	}
	
	/** (non-Javadoc)
	 * @Title: gainModuleBySq1
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param rid
	 * @return
	 */
	public List<Module> gainModuleBySq2(String rid) {
		return moduleMapper.gainModuleBySq2(rid);
	}
	
	/** (non-Javadoc)
	 * @Title: gainModuleAllCount
	 * @Description: TODO(查询总行数)
	 * @return
	 */
	public Long gainModuleAllCount() {
		return moduleMapper.gainModuleAllCount();
	}

}
