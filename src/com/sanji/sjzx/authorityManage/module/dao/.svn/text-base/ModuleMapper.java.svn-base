package com.sanji.sjzx.authorityManage.module.dao;

import java.util.List;

import com.sanji.sjzx.model.Module;


/**
 * 模块DAO
* @ClassName: ModuleMapper
* @Description: TODO(这里用一句话描述这个类的作用)
* @author ZhouZhangbao
* @date 2014-9-4 下午3:37:35
 */
public interface ModuleMapper {
	/**
	 * @Title: gainModuleList
	 * @Description: TODO(查询模块列表信息)
	 * @param @param module
	 * @param @return    设定文件
	 * @return List<Module>    返回类型
	 */
    public List<Module> gainModuleList(Module module);
    
    /**
     * @Title: gainModuleList1
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param module
     * @param @return    设定文件
     * @return List<Module>    返回类型
     */
    public List<Module> gainModuleList1(Module module);
    
    /**
     * @Title: gainModuleList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @return    设定文件
     * @return List<Module>    返回类型
     */
    public List<Module> gainModuleList();
    
    /**
     * @Title: gainModuleAll
     * @Description: TODO(查询所有模块)
     * @param @return    设定文件
     * @return List<Module>    返回类型
     */
    public List<Module> gainModuleAll();
    
    /**
     * @Title: gainModuleListForExcept
     * @Description: TODO(模块修改时,查询除此模块的所有模块)
     * @param @return    设定文件
     * @return List<Module>    返回类型
     */
    public List<Module> gainModuleListForExcept(String mid);
    
    /**
     * @Title: gainModuleCount
     * @Description: TODO(查询总行数)
     * @param @param module
     * @param @return    设定文件
     * @return Long    返回类型
     */
    public Long gainModuleCount(Module module);
    public Long gainModuleAllCount();
    
    /**
     * @Title: addModule
     * @Description: TODO(添加模块)
     * @param @param module    设定文件
     * @return void    返回类型
     */
    public void addModule(Module module);
    
    /**
     * @Title: gainChildModuleListByPid
     * @Description: TODO(根据父模块id查询子模块)
     * @param @param pid
     * @param @return    设定文件
     * @return List<Module>    返回类型
     */
    public List<Module> gainChildModuleListByPid(String pid);
    
    /**
     * @Title: updateByPrimaryKeySelective
     * @Description: TODO(修改模块)
     * @param @param module    设定文件
     * @return void    返回类型
     */
    public void modifyModule(Module module);
    
    /**
     * @Title: deleteModule
     * @Description: TODO(删除模块(逻辑删除))
     * @param @param id    设定文件
     * @return void    返回类型
     */
    public void deleteModule(String id);
    
    /**
     * @Title: dropModule
     * @Description: TODO(删除模块(物理删除))
     * @param @param id    设定文件
     * @return void    返回类型
     */
    public void dropModule(String id);
    
    /**
     * @Title: gainRootModule
     * @Description: TODO(查询模块根节点)
     * @param @return    设定文件
     * @return List<Module>    返回类型
     */
    public List<Module> gainRootModule();
    
    /**
     * @Title: gainModuleById
     * @Description: TODO(根据id查询)
     * @param @param id
     * @param @return    设定文件
     * @return List<Module>    返回类型
     */
    public List<Module> gainModuleById(String id);
    
    /**
     * @Title: gainModuleByName
     * @Description: TODO(根据模块名称查询)
     * @param @param name
     * @param @return    设定文件
     * @return List<Module>    返回类型
     */
    public List<Module> gainModuleByName(String name);
    
	/**
	 * 根据角色ID查询权限信息
	* @Title: gainModuleByRoleID
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return List<Module>    返回类型
	* @author 周张豹
	*/
	public List<Module> gainModuleByRoleID(String roleId);
	
	/**
	 * @Title: gainModuleBySq1
	 * @Description: TODO(根据角色查询一级权限)
	 * @param @param rid
	 * @param @return    设定文件
	 * @return List<Module>    返回类型
	 */
	public List<Module> gainModuleBySq1(String rid);
	
	/**
	 * @Title: gainModuleBySq2
	 * @Description: TODO(根据角色查询二级权限)
	 * @param @param rid
	 * @param @return    设定文件
	 * @return List<Module>    返回类型
	 */
	public List<Module> gainModuleBySq2(String rid);
}