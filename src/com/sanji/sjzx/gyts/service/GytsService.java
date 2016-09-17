package com.sanji.sjzx.gyts.service;

import com.sanji.sjzx.model.Gyts;
import com.sanji.sjzx.pojo.DataGrid;

public interface GytsService {
	/**
	 * 获取推送订单行数
	 * @Title:gainGytsList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @return DataGrid 返回类型
	 * @throws
	 * @param gyts
	 */
	public DataGrid gainGytsList(Gyts gyts);
	/**
	 * 添加推送订单
	 * @Title:insertGyts
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @return void 返回类型
	 * @throws
	 * @param gyts
	 */
    void addGyts(Gyts gyts);
 }
