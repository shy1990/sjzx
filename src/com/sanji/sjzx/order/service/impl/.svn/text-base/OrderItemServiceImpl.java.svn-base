package com.sanji.sjzx.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.model.Order;
import com.sanji.sjzx.model.OrderItem;
import com.sanji.sjzx.order.dao.OrderItemMapper;
import com.sanji.sjzx.order.service.OrderItemService;
import com.sanji.sjzx.order.service.OrderService;
import com.sanji.sjzx.pojo.DataGrid;
@Service("orderItemService")
@Transactional(rollbackFor = Exception.class)
public class OrderItemServiceImpl implements OrderItemService {
    @Resource
	private OrderItemMapper orderItemMapper;

	public List<OrderItem> gainOrderItemById(String orderId) {
	    List<OrderItem> itemList = orderItemMapper.gainOrderItemById(orderId);
	    if(itemList != null && itemList.size() >0){
	    	return itemList;
	    }else{
	    	return null;
	    }
	}

}
