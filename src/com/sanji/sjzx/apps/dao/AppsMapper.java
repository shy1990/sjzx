package com.sanji.sjzx.apps.dao;

import java.util.List;

import com.sanji.sjzx.model.Apps;

public interface AppsMapper {
	/**
	 * 获取app列表
	 * @Title:gainAppsList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param apps
	 * @param @return 设定文件
	 * @return List<Apps> 返回类型
	 * @throws
	 * @param apps
	 * @return
	 */
	public List<Apps> gainAppsList(Apps apps);
	/**
	 * 获取app列表总行数
	 * @Title:gainAppsListCount
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param apps
	 * @param @return 设定文件
	 * @return Long 返回类型
	 * @throws
	 * @param apps
	 * @return
	 */
	public Long gainAppsListCount(Apps apps);
	/**
	 * 根据id查询相应的记录
	 * @Title:gainAppsById
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @return 设定文件
	 * @return List<Apps> 返回类型
	 * @throws
	 * @param id
	 * @return
	 */
	public Apps gainAppsById(String id);
	/**
	 * 根据memberId查询相应记录
	 * @Title:gainAppsByMemberId
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param memberId
	 * @param @return 设定文件
	 * @return List<Apps> 返回类型
	 * @throws
	 * @param memberId
	 * @return
	 */
	public List<Apps> gainAppsByMemberId(String memberId);
	/**
	 * 修改商家信息
	 * @Title:updateAppsById
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param id
	 */
	public void updateAppsById(String id);
}