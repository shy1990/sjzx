package com.sanji.sjzx.order.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.OrderItem;



public interface OrderItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

	public List<OrderItem> gainOrderItemById(String orderId);

	public void updateOrderItemStateByMap(Map<String, Object> map);
}