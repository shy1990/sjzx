package com.sanji.sjzx.order.service;

import java.io.InputStream;
import java.util.List;

import com.sanji.sjzx.model.Order;
import com.sanji.sjzx.pojo.DataGrid;

public interface OrderService {

	public DataGrid gainOrderList(Order order);

	public Order selectByPrimaryKey(String id);

	public int updateByPrimaryKey(Order record);

	/**
	 * 根据查询条件获取order数据用于导出
	 * 
	 * @Title:gainOrderByExport
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param order
	 * @param @return 设定文件
	 * @return List<Order> 返回类型
	 * @throws
	 * @param order
	 * @return
	 */
	public List<Order> gainOrderByExport(Order order);

	/**
	 * 流处理
	 * 
	 * @Title:exportDateToExcel
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param list
	 * @param @return 设定文件
	 * @return InputStream 返回类型
	 * @throws
	 * @param list
	 * @return
	 */
	InputStream exportDateToExcel(List<?> list);

	/**
	 * 获取货到付款终结订单分页列表
	 * 
	 * @Title:gainOverOrderList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param order
	 * @param @return 设定文件
	 * @return DataGrid 返回类型
	 * @throws
	 * @param order
	 * @return
	 */
	public DataGrid gainOverOrderList(Order order);

	/**
	 * 修改终结订单
	 * 
	 * @Title:updateOverOrder
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param order 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param order
	 */
	public void updateOverOrder(Order order);

	/**
	 * 有选择的根据Id更新订单信息
	 * 
	 * @Title: updateByPrimaryKeySelective
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param order 设定文件
	 * @return void 返回类型
	 * @author 田超强
	 * @throws
	 */
	public void updateByPrimaryKeySelective(Order order);
}
