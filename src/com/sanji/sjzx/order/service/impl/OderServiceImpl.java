package com.sanji.sjzx.order.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.common.util.MsgUtil;
import com.sanji.sjzx.model.Order;
import com.sanji.sjzx.order.dao.OrderMapper;
import com.sanji.sjzx.order.service.OrderService;
import com.sanji.sjzx.pojo.DataGrid;

@Service("orderService")
@Transactional(rollbackFor = Exception.class)
public class OderServiceImpl implements OrderService {
	@Resource
	private OrderMapper orderMapper;

	public DataGrid gainOrderList(Order order) {
		DataGrid j = new DataGrid();
		j.setRows(orderMapper.gainOrderList(order));
		j.setTotal(orderMapper.gainOrderCount(order));
		return j;
	}

	public Order selectByPrimaryKey(String id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKey(Order record) {
		return orderMapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据查询条件获取order数据用于导出
	 */
	public List<Order> gainOrderByExport(Order order) {
		return orderMapper.gainOrderByExport(order);
	}

	/**
	 * 流
	 */
	public InputStream exportDateToExcel(List<?> list) {
		if (list == null) {
			try {
				throw new Exception("list is null in exportDateToExcel method,it mustn't be null.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		putDataOnOutputStream(out, list);
		return new ByteArrayInputStream(out.toByteArray());
	}

	/**
	 * 流
	 * 
	 * @Title:putDataOnOutputStream
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param os
	 * @param @param list 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param os
	 * @param list
	 */
	private void putDataOnOutputStream(OutputStream os, List<?> list) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (list == null)
			try {
				throw new Exception("list is null in exportDateToExcel method,it mustn't be null.");
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(os);
			WritableSheet sheet = workbook.createSheet("Sheet1", 0);
			sheet.getSettings().setDefaultColumnWidth(20);
			sheet.addCell(new jxl.write.Label(0, 0, "订单唯一码"));
			sheet.addCell(new jxl.write.Label(1, 0, "订单编号"));
			sheet.addCell(new jxl.write.Label(2, 0, "店铺名称"));
			sheet.addCell(new jxl.write.Label(3, 0, "订单状态"));
			sheet.addCell(new jxl.write.Label(4, 0, "发货状态"));
			sheet.addCell(new jxl.write.Label(5, 0, "支付状态"));
			sheet.addCell(new jxl.write.Label(6, 0, "支付类型"));
			sheet.addCell(new jxl.write.Label(7, 0, "支付时间"));
			sheet.addCell(new jxl.write.Label(8, 0, "支付方式"));
			sheet.addCell(new jxl.write.Label(9, 0, "支付序列号"));
			sheet.addCell(new jxl.write.Label(10, 0, "总金额"));
			sheet.addCell(new jxl.write.Label(11, 0, "管易单据编号"));
			sheet.addCell(new jxl.write.Label(12, 0, "钱包支付金额"));
			sheet.addCell(new jxl.write.Label(13, 0, "红宝支付金额"));
			sheet.addCell(new jxl.write.Label(14, 0, "实际支付金额"));
			sheet.addCell(new jxl.write.Label(15, 0, "收货人姓名"));
			sheet.addCell(new jxl.write.Label(16, 0, "收货人手机"));
			sheet.addCell(new jxl.write.Label(17, 0, "下单时间"));
			// 循环遍历到数据集
			for (int i = 0; i < list.size(); i++) {
				Order o = (Order) list.get(i);
				sheet.addCell(new jxl.write.Label(0, i + 1, o.getId()));
				sheet.addCell(new jxl.write.Label(1, i + 1, o.getOrderNum()));
				sheet.addCell(new jxl.write.Label(2, i + 1, o.getShopName()));
				String Status = o.getStatus();
				if("0".equals(Status)){
					Status = "正常";
				}else if("1".equals(Status)){
					Status = "未审核";
				}else if("2".equals(Status)){
					Status = "已审核";
				}else if("3".equals(Status)){
					Status = "取消";
				}else if("4".equals(Status)){
					Status = "无效";
				}
				sheet.addCell(new jxl.write.Label(3, i + 1, Status));
				String shipStatus = o.getShipStatus();
				if("0".equals(shipStatus)){
					shipStatus = "未发货";
				}else if("1".equals(shipStatus)){
					shipStatus = "已发货";
				}else if("2".equals(shipStatus)){
					shipStatus = "已送达";
				}else if("3".equals(shipStatus)){
					shipStatus = "已收货";
				}else if("4".equals(shipStatus)){
					shipStatus = "待退货";
				}else if("5".equals(shipStatus)){
					shipStatus = "已退货";
				}else if("6".equals(shipStatus)){
					shipStatus = "卖家拒绝退货";
				}
				sheet.addCell(new jxl.write.Label(4, i + 1, shipStatus));
				String payStatus = o.getPayStatus();
				if ("1".equals(payStatus)) {
					payStatus = "已付款";
				}
				if ("0".equals(payStatus)) {
					payStatus = "未支付";
				}
				if ("3".equals(payStatus)) {
					payStatus = "已退款";
				}
				if ("2".equals(payStatus)) {
					payStatus = "待退款";
				}
				if ("4".equals(payStatus)) {
					payStatus = "卖家拒绝退款";
				}
				sheet.addCell(new jxl.write.Label(5, i + 1, payStatus));
				String payMent = o.getPayMent();
				if ("0".equals(payMent)) {
					payMent = "网上支付";
				} else if ("1".equals(payMent)) {
					payMent = "货到付款";
				}else if ("2".equals(payMent)) {
					payMent = "pois付款";
				}
				sheet.addCell(new jxl.write.Label(6, i + 1, payMent));
				if (o.getPayTime() != null) {
					sheet.addCell(new jxl.write.Label(7, i + 1, sdf.format(o.getPayTime())));
				}
				String dealType = o.getDealType();
				if ("yeePay".equals(dealType)) {
					dealType = "易宝支付";
				} else if ("LH".equals(dealType)) {
					dealType = "联行支付";
				} else if ("sandPay".equals(dealType)) {
					dealType = "杉德POS端支付";
				}
				sheet.addCell(new jxl.write.Label(8, i + 1, dealType));
				sheet.addCell(new jxl.write.Label(9, i + 1, o.getDealId()));
				sheet.addCell(new jxl.write.Label(10, i + 1, String.valueOf(o.getTotalCost())));
				sheet.addCell(new jxl.write.Label(11, i + 1, o.getEcerpNo()));
				sheet.addCell(new jxl.write.Label(12, i + 1, String.valueOf(o.getWalletNum())));
				sheet.addCell(new jxl.write.Label(13, i + 1, String.valueOf(o.getHbNum())));
				sheet.addCell(new jxl.write.Label(14, i + 1, String.valueOf(o.getActualPayNum())));
				sheet.addCell(new jxl.write.Label(15, i + 1, o.getShipName()));
				sheet.addCell(new jxl.write.Label(16, i + 1, o.getShipTel()));
				if (o.getCreatetime() != null) {
					sheet.addCell(new jxl.write.Label(17, i + 1, sdf.format(o.getCreatetime())));
				}
			}
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			try {
				throw new Exception("putDataOnOutputStream has some error:", e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 获取货到付款终结订单分页列表
	 */
	public DataGrid gainOverOrderList(Order order) {
		DataGrid j = new DataGrid();
		j.setRows(orderMapper.gainOverOrderList(order));
		j.setTotal(orderMapper.gainOverOrderCount(order));
		return j;
	}

	/**
	 * 修改终结订单
	 */
	public void updateOverOrder(Order order) {
		orderMapper.updateOverOrder(order);
	}

	public void updateByPrimaryKeySelective(Order order) {
		orderMapper.updateByPrimaryKeySelective(order);
		MsgUtil.editOrderPrice(order.getOrderNum(),order.getActualPayNum());
	}
}
