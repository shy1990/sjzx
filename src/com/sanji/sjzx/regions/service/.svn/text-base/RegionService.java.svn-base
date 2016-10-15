/**  
* @Title: RegionService.java
* @Package com.sanji.sjzx.regions.service
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2015-2-5 上午11:18:36
* @version V1.0  
*/
package com.sanji.sjzx.regions.service;

import java.util.List;

import com.sanji.sjzx.model.Regions;

/**
 * @ClassName: RegionService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2015-2-5 上午11:18:36
 */
public interface RegionService {
	
	/**
	 * 根据父ID查询
	* @Title: gainRegionByPid
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param pid
	* @param @return    设定文件
	* @return List<Regions>    返回类型
	* @author ZhouZhangbao
	 */
	public List<Regions> gainRegionByPid(String pid);
	/**
	 * 根据父ID查询
	* @Title: gainRegionByPid
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param pid
	* @param @return    设定文件
	* @return List<Regions>    返回类型
	* @author ZhouZhangbao
	 */
	public List<Regions> gainRegionByPid2(Regions regions);

	/**
	 * 根据ID查询包含子类
	* @Title: gainReionById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param string
	* @param @return    设定文件
	* @return List<Regions>    返回类型
	* @author ZhouZhangbao
	*/
	
	public List<Regions> gainReionById(String id);
	
	/**
	 * 获取省市区树信息
	 * @Title:gainRegionsList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param regions
	 * @param @return 设定文件
	 * @return List<Regions> 返回类型
	 * @throws
	 * @param regions
	 * @return
	 */
	public List<Regions> gainRegionsList(Regions regions);
	

	/**
	 * 根据pid获取省市区树信息
	 * gainRegionsListByPid
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param regions
	 * @param @return 设定文件
	 * @return List<Regions> 返回类型
	 * @throws
	 * @param regions
	 * @return
	 */
	public List<Regions> gainRegionsListByPid(Regions regions);
	/**
	 * 根据id获取省市区树信息
	 * gainRegionsForExsitChild
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param regions
	 * @param @return 设定文件
	 * @return List<Regions> 返回类型
	 * @throws
	 * @param regions
	 * @return
	 */
	public Long gainRegionsForExsitChild(String id);


}
