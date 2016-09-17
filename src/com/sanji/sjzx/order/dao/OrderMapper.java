package com.sanji.sjzx.order.dao;

import java.util.List;

import com.sanji.sjzx.model.Order;



public interface OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

	public List<Order> gainOrderList(Order order);

	public Long gainOrderCount(Order order);
	/**
	 * 根据查询条件获取order数据用于导出
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
	 * 获取货到付款终结订单列表
	 * @Title:gainOverOrderList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param order
	 * @param @return 设定文件
	 * @return List<Order> 返回类型
	 * @throws
	 * @param order
	 * @return
	 */
	public List<Order> gainOverOrderList(Order order);
	/**
	 * 获取货到付款终结订单列表行数
	 * @Title:gainOverOrderCount
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param order
	 * @param @return 设定文件
	 * @return Long 返回类型
	 * @throws
	 * @param order
	 * @return
	 */
	public Long gainOverOrderCount(Order order);
	/**
	 * 修改终结订单
	 * @Title:updateOverOrder
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param order 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param order
	 */
	public void updateOverOrder(Order order);
}