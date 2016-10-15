package com.sanji.sjzx.order.action;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.web.bind.annotation.RequestBody;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.HttpClientUtils;
import com.sanji.sjzx.common.util.JsonUtil;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.members.service.MembersService;
import com.sanji.sjzx.model.Members;
import com.sanji.sjzx.model.Order;
import com.sanji.sjzx.order.dao.OrderMapper;
import com.sanji.sjzx.order.service.OrderService;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.SessionInfo;

@Namespace("/order")
@Action(value = "orderAction", results = {
		@Result(name = "toList", location = "/admin/order/list.jsp"),

		@Result(name = "exportExcel", type = "stream", params = {
				"contentType", " application/vnd.ms-excel", "inputName",
				"excelStream", "contentDisposition",
				"attachment;filename=\"order.xls\"", "bufferSize", "1024" }),
		@Result(name = "toOverOrderList", location = "/admin/order/overOrder.jsp"),
		@Result(name = "toUpdate", location = "/admin/order/edit.jsp"),
		@Result(name = "toPush", location = "/admin/order/tuisong.jsp") })
public class OrderAction extends BaseAction implements ModelDriven<Order> {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrderAction.class);

	private Order order = new Order();
	@Resource
	private OrderService orderService;
	private InputStream excelStream;
	Date date = new Date();

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	/**
	 * 跳转到推送订单页面
	 */
	public String toPush() {
		return "toPush";
	}

	/**
	 * 手动推送订单
	 * 
	 * @Title: pushOrder
	 * @Description: TODO(跳转到订单列表页面)
	 * @param @return 设定文件
	 * @return void 返回类型
	 * @author SongBaozhen
	 */
	public void pushOrder() {
		Json json = new Json();
		try {
			Map<String, String> params = new HashMap<String, String>();

			params.put("id", order.getId());
			String s = HttpClientUtils
					.sendPostSSLRequest(
							"http://localhost:8080/mall/order/rePushOrder.html",
							params);
			// String s =
			// HttpClientUtils.sendPostSSLRequest("http://www.3j1688.com/order/rePushOrder.html",
			// params);
			if (s != null && !"".equals(s)) {
				json = (Json) JsonUtil.getObject4JsonString(s, Json.class);
			} else {
				json.setMsg("订单推送异常,请联系技术人员!");
				json.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("pushOrder() occur error. ", e);
		}
		writeJson(json);
	}

	/**
	 * 跳转到订单列表页面
	 * 
	 * @Title: toUpdate
	 * @Description: TODO(跳转到订单列表页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author SongBaozhen
	 */

	public String toUpdate() {
		return "toUpdate";
	}

	/**
	 * 跳转到订单列表页面
	 * 
	 * @Title: toLabelList
	 * @Description: TODO(跳转到订单列表页面)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author songbaozhen
	 */

	public String toList() {
		return "toList";
	}

	public void gainOrderList() {
		try {
			super.writeJson(orderService.gainOrderList(order));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainOrderList() occur error. ", e);
		}
	}

	/**
	 * 导出订单
	 * 
	 * @Title:exportOrderExcel
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String exportOrderExcel() {
		List<Order> list = orderService.gainOrderByExport(order);
		if (list != null) {
			excelStream = orderService.exportDateToExcel(list);// 导出excel表格
			return "exportExcel";
		}

		return null;
	}

	/**
	 * 跳转到货到付款终结订单列表
	 * 
	 * @Title:toOverOrderList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 * @return
	 */
	public String toOverOrderList() {
		return "toOverOrderList";
	}

	/**
	 * 获取货到付款终结订单列表
	 * 
	 * @Title:gainOverOrderList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainOverOrderList() {
		try {
			super.writeJson(orderService.gainOverOrderList(order));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainOverOrderList() occur error. ", e);
		}
	}

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
	public void updateOverOrder() {
		Json j = new Json();
		try {
			String id = request.getParameter("ids");
			// System.out.println("id=====" + id);
			order.setId(id);
			// System.out.println(">>>>>>>" + new
			// java.sql.Timestamp(date.getTime()));
			order.setOvertime(new java.sql.Timestamp(date.getTime()));
			order.setPayStatus("1");
			order.setShipStatus("3");
			order.setIsover("1");
			// 获取登录用户名
			SessionInfo sessionInfo = (SessionInfo) request.getSession()
					.getAttribute(ResourceUtil.getSessionInfoName());
			String loginName = sessionInfo.getLoginName();
			// System.out.println("loginName===" + loginName);
			order.setOverman(loginName);
			orderService.updateOverOrder(order);
			j.setMsg("修改成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
			logger.error("updateOverOrder() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

	public Order getModel() {
		return order;
	}

	/**
	 * 修改订单价格
	 * 
	 * @Title: updatePrice
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @author 田超强
	 * @throws
	 */
	public void updatePrice() {
		Json j = new Json();
		try {
			if (null == order || null == order.getId()
					|| null == order.getRemark()
					|| null == order.getActualPayNum()) {
				j.setMsg("参数不完整！");
				j.setSuccess(false);
			} else {
				// 获取登录用户名
				SessionInfo sessionInfo = (SessionInfo) request.getSession()
						.getAttribute(ResourceUtil.getSessionInfoName());
				String loginName = sessionInfo.getLoginName();
				order.setRemark(order.getRemark() + "    " + loginName);
				orderService.updateByPrimaryKeySelective(order);
				j.setMsg("修改成功！");
				j.setSuccess(true);
			}
		} catch (Exception e) {
			j.setMsg("修改失败！");
			j.setSuccess(false);
			logger.error("updateOverOrder() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}

}
