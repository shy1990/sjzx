package com.sanji.sjzx.gyts.dao;

import java.util.List;

import com.sanji.sjzx.model.Gyts;

public interface GytsMapper {
	/**
	 * 获取推送订单列表
	 * @Title:gainGytsList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @return List<Gyts> 返回类型
	 * @throws
	 * @param gyts
	 */
	public List<Gyts> gainGytsList(Gyts gyts);
	/**
	 * 获取推送订单列表总行数
	 * @Title:gainGytsCount
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @return Long 返回类型
	 * @throws
	 * @param gyts
	 */
	public Long gainGytsCount(Gyts gyts);
	/**
	 * 添加推送订单
	 * @Title:insertGyts
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param gyts 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param gyts
	 */
    void addGyts(Gyts gyts);
 
 }