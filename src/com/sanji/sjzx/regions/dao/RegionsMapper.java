package com.sanji.sjzx.regions.dao;

import java.util.List;

import com.sanji.sjzx.model.Regions;


public interface RegionsMapper {
    
	/**
	 * 根据父ID查询子类
	* @Title: gainRegionByPid
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param pid
	* @param @return    设定文件
	* @return List<Regions>    返回类型
	* @author ZhouZhangbao
	 */
    public List<Regions> gainRegionByPid(Regions regions);
    /**
	 * 根据父ID查询子类
	* @Title: gainRegionByPid
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param pid
	* @param @return    设定文件
	* @return List<Regions>    返回类型
	* @author ZhouZhangbao
	 */
    public List<Regions> gainRegionByPid2(Regions regions);

	/**
	* @Title: gainReionById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param regions
	* @param @return    设定文件
	* @return List<Regions>    返回类型
	* @author ZhouZhangbao
	*/
	
	public List<Regions> gainReionById(Regions regions);
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
	 * 根据id 判断是否有child
	 * @Title:gainCountForRegainsChild
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param regions
	 * @param @return 设定文件
	 * @return List<Regions> 返回类型
	 * @throws
	 * @param regions
	 * @return
	 */
	public Long gainCountForRegainsChild(String id);
}