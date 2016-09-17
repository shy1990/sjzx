/**  
* @Title: ModuleService.java
* @Package com.sanji.sjzx.authorityManage.module.service
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2014-9-4 下午4:30:56
* @version V1.0  
*/
package com.sanji.sjzx.authorityManage.module.service;

import java.util.List;

import com.sanji.sjzx.model.Module;
import com.sanji.sjzx.model.RoleModule;
import com.sanji.sjzx.pojo.DataGrid;


/**
 * @ClassName: ModuleService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-4 下午4:30:56
 */
public interface ModuleService {
	/**
	 * 根据角色查询一级权限
	* @Title: gainModuleBySq1
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param rid
	* @param @return    设定文件
	* @return List<Module>    返回类型
	* @author ZhouZhangbao
	 */
	public List<Module> gainModuleBySq1(String rid);
	/**
	 * 根据角色查询二级权限
	* @Title: gainModuleBySq2
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param rid
	* @param @return    设定文件
	* @return List<Module>    返回类型
	* @author ZhouZhangbao
	 */
    public List<Module> gainModuleBySq2(String rid);
    
    
    /**
	 * @Title: gainModuleList
	 * @Description: TODO(查询模块列表信息)
	 * @param @param module
	 * @param @return    设定文件
	 * @return DataGrid    返回类型
	 */
    public DataGrid gainModuleList(Module module);
    public List<Module> gainModuleList1(Module module,String num);
    public List<Module> gainModuleList();

    /**
     * @Title: addModule
     * @Description: TODO(添加模块)
     * @param @param module    设定文件
     * @return void    返回类型
     */
    public void addModule(Module module);
    
    /**
     * @Title: modifyModule
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
     * @Title: gainChildModuleListByPid
     * @Description: TODO(根据父模块id查询子模块)
     * @param @param pid
     * @param @return    设定文件
     * @return List<Module>    返回类型
     */
    public List<Module> gainChildModuleListByPid(String pid);
    
    /**
     * @Title: gainIsExistChildModule
     * @Description: TODO(查询验证该模块是否含有子模块)
     * @param @param pid
     * @param @return    设定文件
     * @return boolean    返回类型
     */
    public boolean gainIsExistChildModule(String pid);
    
    /**
     * @Title: gainRoleModuleByMid
     * @Description: TODO(根据模块id查询)
     * @param @param mid
     * @param @return    设定文件
     * @return List<RoleModule>    返回类型
     */
    public List<RoleModule> gainRoleModuleByMid(String mid);
    
    /**
     * @Title: gainIsAuthorizeModule
     * @Description: TODO(查询验证该模块是否作为权限被分配)
     * @param @param mid
     * @param @return    设定文件
     * @return boolean    返回类型
     */
    public boolean gainIsAuthorizeModule(String mid);
    
    /**
     * @Title: gainIsExistName
     * @Description: TODO(根据模块名称查询)
     * @param @param name
     * @param @return    设定文件
     * @return boolean    返回类型
     */
    public boolean gainIsExistName(String name);
    
   
    /**
     * @Title: gainModuleAllCount
     * @Description: TODO(查询总行数)
     * @param @return    设定文件
     * @return Long    返回类型
     */
    public Long gainModuleAllCount();

}
