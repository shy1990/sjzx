/**  
 * @Title: EcRrpUtil.java
 * @Package com.sanji.mall.common.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author ZhouZhangbao  
 * @date 2014-11-26 下午2:26:53
 * @version V1.0  
 */
package com.sanji.sjzx.common.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jdom.JDOMException;


import com.sanji.sjzx.model.Gyts;

/**
 * 关于管易ERP接口通用类
 * 
 * @ClassName: EcRrpUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-11-26 下午2:26:53
 */
public class EcErpUtil {

	private static final String ERP_API_URL = "http://121.41.164.77:30014/sjdzcgerp/data.dpk?method=ecerp.shangpin.get&page_size=10&page_no=1";//备份  http://223.4.55.183:30015/data.dpk
	private static final String ERP_API_APPKEY = "9B7988EF20264F7CBDC077925869842C";


	/**
	 * 查询订单发货状态
	 * 
	 * @Title: getOrderShipType
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param orderNo
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @author ZhouZhangbao
	 */
	public static Map<String, Object> getOrderShipType(String orderNo) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("method", "ecerp.tradestate.get");
			params.put("appkey", ERP_API_APPKEY);
			params.put("condition", "LYDH ='" + orderNo + "'");
			String xml = HttpClientUtils.sendPostSSLRequest(ERP_API_URL, params);
			Map<String, String> xmlMap = XmlUtil.xml2Map(xml);
			retMap.put("GUID", xmlMap.get("tradestate_get_response.tradestates.tradestate.guid"));// 订单GUID
			retMap.put("DJBH", xmlMap.get("tradestate_get_response.tradestates.tradestate.djbh"));// 单据编号
			retMap.put("LYDH", xmlMap.get("tradestate_get_response.tradestates.tradestate.lydh"));// 来源单号
			retMap.put("ZDRQ", xmlMap.get("tradestate_get_response.tradestates.tradestate.zdrq"));// 制单日期
			retMap.put("SHENHE", xmlMap.get("tradestate_get_response.tradestates.tradestate.shenhe"));// 是否客审
																										// (
																										// 0-否,1-是
																										// )
			retMap.put("SHENHERQ", xmlMap.get("tradestate_get_response.tradestates.tradestate.shenherq"));// 客审
																											// 日期
			retMap.put("CWSH", xmlMap.get("tradestate_get_response.tradestates.tradestate.cwsh"));// 是否财审
																									// (
																									// 0-否,1-是
																									// )
			retMap.put("CWSHRQ", xmlMap.get("tradestate_get_response.tradestates.tradestate.cwshrq"));// 财神日期
			retMap.put("SM", xmlMap.get("tradestate_get_response.tradestates.tradestate.sm"));// 是否扫描
																								// (
																								// 0-否,1-是
																								// )
			retMap.put("FH", xmlMap.get("tradestate_get_response.tradestates.tradestate.fh"));// 是否发货
																								// (
																								// 0-否,1-是
																								// )
			retMap.put("FHRQ", xmlMap.get("tradestate_get_response.tradestates.tradestate.fhrq"));// 发货日期
			retMap.put("HH", xmlMap.get("tradestate_get_response.tradestates.tradestate.hh"));// 是否换货
																								// (
																								// 0-否,1-是
																								// )
			retMap.put("Refund_Status", xmlMap.get("tradestate_get_response.tradestates.tradestate.refund_status"));// 是否退款(
																													// 大于0表示有退款
																													// )
			retMap.put("IsBad", xmlMap.get("tradestate_get_response.tradestates.tradestate.isbad"));// 是否问题单
																									// (
																									// 0-否,1-是
																									// )
			retMap.put("ZF", xmlMap.get("tradestate_get_response.tradestates.tradestate.zf"));// 是否作废
																								// (
																								// 0-否,1-是
																								// )
			retMap.put("ZFRQ", xmlMap.get("tradestate_get_response.tradestates.tradestate.zfrq"));// 作废日期
			retMap.put("hbguid", xmlMap.get("tradestate_get_response.tradestates.tradestate.hbguid"));// 合并订单GUID
			retMap.put("is_payed", xmlMap.get("tradestate_get_response.tradestates.tradestate.is_payed"));// 是否支付
																											// (
																											// 0-否,1-是
																											// )
			retMap.put("shopcode", xmlMap.get("tradestate_get_response.tradestates.tradestate.shopcode"));// 卖家帐号
			retMap.put("modify_time", xmlMap.get("tradestate_get_response.tradestates.tradestate.modify_time"));// 修改时间
			retMap.put("wlgsdm", xmlMap.get("tradestate_get_response.tradestates.tradestate.wlgsdm"));// 物流公司代码
			retMap.put("wlgsmc", xmlMap.get("tradestate_get_response.tradestates.tradestate.wlgsmc"));// 物流公司名称
			retMap.put("wldh", xmlMap.get("tradestate_get_response.tradestates.tradestate.wldh"));// 物流单号
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retMap;
	}

	/**
	 * 作废管易订单
	 * 
	 * @Title: cancelOderById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param orderNo
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @author ZhouZhangbao
	 */
	public static Map<String, Object> cancelOderById(String orderNo) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("method", "ecerp.trade.cancel");
			params.put("appkey", ERP_API_APPKEY);
			params.put("outer_tid", orderNo);
			String xml = HttpClientUtils.sendPostSSLRequest(ERP_API_URL, params);
			Map<String, String> xmlMap = XmlUtil.xml2Map(xml);
			retMap.put("created", xmlMap.get("TradeCancel.cancel_order_response.trade.created"));// 作废时间
			retMap.put("orderNo", xmlMap.get("TradeCancel.cancel_order_response.trade.tid"));// 订单号
			retMap.put("ERROR", xmlMap.get("TradeOrders.ERROR"));// 出现异常时，所提示的信息
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retMap;
	}

	/**
	 * 查询管易订单状态
	 * 
	 * @Title: gyShipStatus
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param orderNo
	 * @param @return 设定文件
	 * @return boolean false-未发货 ，true-已发货
	 * @author 田超强
	 * @throws
	 */
	public static boolean gyShipStatus(String orderNo) {

		Map<String, Object> map = getOrderShipType(orderNo);
		if (null != map) {
			if (map.containsKey("FH") && null != map.get("FH")) {
				System.out.println("管易发货状态：" + map.get("FH"));
				// 0-否,1-是
				if ("0".equals(map.get("FH"))) {
					return false;
				} else {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 推送的新订单
	* @Title: OrderAddNew
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param gyts
	* @param @return    设定文件
	* @return Map<String,Object>    返回类型<br>
	* 返回map的key为：1 created-管易返回的创建订单时间 ；2 tid-管易所生产的订单号码 ；3 ERROR - 管易创建失败的原因<br>
	* 创建成功map中只有1和2，创建失败map中只有3
	* @author ZhouZhangbao
	 */
	public static Map<String, Object> OrderAddNew(Gyts gyts) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			Map<String, String> params = new HashMap<String, String>();
			
			params.put("mail", gyts.getMail());// 买家账号
			params.put("itemsns", gyts.getItem());// 商品编码列表：以半角逗号(,)分隔。
			params.put("prices", gyts.getPrice());// 商品价格列表：以半角逗号(,)分隔。商品价格个数必须与商品编码个数一致
			params.put("skusns", gyts.getSku());// 商品规格
			params.put("nums", gyts.getNums());// 商品数量：以半角逗号(,)分隔。商品数量个数必须与商品编码个数一致。
			params.put("receiver_name", gyts.getReceiverName());// String 是 张三 收货人
			params.put("receiver_address", gyts.getReceiverAddress());// 收货地址
			params.put("receiver_state", gyts.getReceiverState());// 省
			params.put("receiver_city", gyts.getReceiverCity());// 市
			params.put("receiver_district", gyts.getReceiverDistrict());// 区
			if (null != gyts.getLogisticsType()) {
				params.put("logistics_type", gyts.getLogisticsType());//运输方式  货到付款 要根据管易自定义的代码一直
			} else {
				params.put("logistics_type", "YTO");//运输方式  货到付款 要根据管易自定义的代码一直
			}
			params.put("outer_tid", gyts.getOuterTid());// 外部订单号
			params.put("outer_shop_code", gyts.getOuterShopCode());// 卖家账号
			
			params.put("receiver_phone", gyts.getReceiverPhone());// 电话
			params.put("receiver_mobile", gyts.getReceiverMobile());// 手机
			params.put("outer_ddly", gyts.getOuterDdly());// 订单来源： 0-系统网站, 1-淘宝网站, 2-其他, 3-淘宝分销,
																  // 4-拍拍网站, 5-京东商城, 6-当当网站, 7-E链通,
																  // 8-商派网站, 9-POS门店, 10-商派分销王,
											                      // 11-一号店, 12-凡客商城, 99-商派独立网店
			if (null != gyts.getBuyerMessage())params.put("buyer_message", gyts.getBuyerMessage());//买家留言
			if (null != gyts.getStoreCode()) {
				params.put("store_code", gyts.getStoreCode());// 仓库代码 主仓代码：001
			} else {
				params.put("store_code", "001");// 仓库代码 主仓代码：001
			}
			if(null != gyts.getReceiverZip())params.put("receiver_zip", gyts.getReceiverZip());// receiver_zip邮编
			if(null != gyts.getLogisticsFee())params.put("logistics_fee", gyts.getLogisticsFee());// 运输费用
			if(null != gyts.getFptt())params.put("FPTT", gyts.getFptt());// 发票抬头
			if(null != gyts.getSyfp())params.put("SYFP", gyts.getSyfp());//是否发票：0 - 无发票
			if(null != gyts.getLxdm())params.put("LXDM", gyts.getLxdm());// 发票类型代码
			if(null != gyts.getTicketNo())params.put("ticket_no", gyts.getTicketNo());// 交易单号
			if(null != gyts.getPayCodes())params.put("pay_codes", gyts.getPayCodes());// 支付代码
			if(null != gyts.getPayMoneys())params.put("pay_moneys", gyts.getPayMoneys());// 支付金额
			if(null != gyts.getPayDatatimes())params.put("pay_datatimes", gyts.getPayDatatimes());// 支付时间
			if(null != gyts.getAutosplit())params.put("autosplit", gyts.getAutosplit());//自动拆分组合商品
			if(null != gyts.getTradeMemo())params.put("trade_memo", gyts.getTradeMemo());// 卖家备注
			if(null != gyts.getIsCod())params.put("is_cod", gyts.getIsCod());// 是否货到付款。(0-非货到付款,1-货到付款,如是货到付款toverify为0)
			if(null != gyts.getYgdm())params.put("YGDM", gyts.getYgdm());//员工代码
			if(null != gyts.getInvoiceContent())params.put("invoice_content", gyts.getInvoiceContent());// 发票内容
			if(null != gyts.getInvoiceAmount())params.put("invoice_amount", gyts.getInvoiceAmount());//发票金额
			if(null != gyts.getInvoiceNumber())params.put("invoice_number", gyts.getInvoiceNumber());//发票号
			if(null != gyts.getInvoiceDate())params.put("invoice_date", gyts.getInvoiceDate());//发票日期
			if(null != gyts.getYfrq())params.put("YFRQ", gyts.getYfrq());//预计发货日期
			if(null != gyts.getTbBz())params.put("TB_BZ", gyts.getTbBz());//淘宝备注
			if(null != gyts.getCodFee())params.put("cod_fee", gyts.getCodFee());//到付服务费
			if(null != gyts.getTotalDiscountFee())params.put("total_discount_fee", gyts.getTotalDiscountFee());//让利金额
			if(null != gyts.getPayTradeIds())params.put("pay_trade_ids", gyts.getPayTradeIds());//交易号数组
			if(null != gyts.getPayAccounts())params.put("pay_accounts", gyts.getPayAccounts());//账号数组
			if(null != gyts.getPayMemos())params.put("pay_memos", "");//支付明细备注数组
			//params.put("add_district", "");//自动增加地区信息 ( 0-否,1-是 )
			
			params.put("appkey", ERP_API_APPKEY);
			params.put("method", "ecerp.trade.add_order_new");
			
			String xml = HttpClientUtils.sendPostSSLRequest(ERP_API_URL, params);
			
			Map<String, String> xmlMap = XmlUtil.xml2Map(xml);

			retMap.put("created", xmlMap.get("TradeOrdersNew.trade_orders_response.trade.created"));
			retMap.put("tid", xmlMap.get("TradeOrdersNew.trade_orders_response.trade.tid"));
			retMap.put("ERROR", xmlMap.get("TradeOrdersNew.ERROR"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMap;
	}
}
