package com.sanji.sjzx.order.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.aspectj.internal.lang.annotation.ajcPrivileged;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.model.Order;
import com.sanji.sjzx.model.OrderItem;
import com.sanji.sjzx.order.service.OrderItemService;
import com.sanji.sjzx.pojo.Json;
@Namespace("/orderItem")
@Action(value = "orderItemAction", results = {
		@Result(name="showOrderItem", location="/admin/order/orderItem.jsp")
})
public class OrderItemAction extends BaseAction implements
		ModelDriven<OrderItem> {
	@Resource
	private OrderItemService orderItemService;
	
	private OrderItem orderItem = new OrderItem();
	
	public String showOrderItem(){
		request.setAttribute("orderItemList", orderItemService.gainOrderItemById(orderItem.getId()));
		request.setAttribute("totalCost", orderItem.getTotalCost());
		request.setAttribute("carriage", orderItem.getCarriage());
		request.setAttribute("remark", orderItem.getRemark());
		request.setAttribute("actualPayNum", orderItem.getActualPayNum());
		request.setAttribute("walletPayNo", request.getParameter("walletPayNo").equals("undefined")?"":request.getParameter("walletPayNo"));
		request.setAttribute("walletNum", request.getParameter("walletNum").equals("undefined")?"":request.getParameter("walletNum"));
		request.setAttribute("hbNo", request.getParameter("hbNo").equals("undefined")?"":request.getParameter("hbNo"));
		request.setAttribute("hbNum", request.getParameter("hbNum").equals("undefined")?"":request.getParameter("hbNum"));
		return "showOrderItem";
	}
	
	
	public OrderItem getModel() {
		// TODO Auto-generated method stub
		return orderItem;
	}

}
