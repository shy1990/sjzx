/**
 * @Title: MsgUtil.java
 * @Package com.sanji.mall.common.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author ZhouZhangbao
 * @date 2014-10-8 下午2:56:34
 * @version V1.0
 */
package com.sanji.sjzx.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.sanji.sjzx.model.Members;
import com.sanji.sjzx.model.Order;
import com.sanji.sjzx.model.OrderItem;

/**
 * 短信方法类
 * @author ZhouZhangbao
 */
public class MsgUtil {
/*  private static String uri = "http://222.73.117.158/msg/";// 应用地址
  private static String account = "dianshang";// 账号
  private static String pswd = "Tch123456";// 密码
  private static boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
  // private static String product = "229611062";// 产品ID
  private static String product = "281249147";// 产品ID
  private static String extno = "168";// 扩展码
  private static String MSG_Signature = "";// 短信签名

  private static String MSGCODE_START = "您的验证码:";
  private static String MSGCODE_END = ",请在一分钟之内完成操作，请勿告诉别人!";
  private static String PAY_SUCCESS_START = "客官您好，您订单号为："; // 支付成功头部
  private static String PAY_SUCCESS_END = "的订单，已完成支付，我们会尽快安排发货，请耐心等待";// 支付成功尾部
  private static String HDFK_SUCCESS_START = "客官您好，您订单号为："; // 货到付款成功头部
  private static String HDFK_SUCCESS_END = "的订单，您选择的为货到付款！，我们会尽快安排发货，请耐心等待";// 货到付款成功尾部
  private static String REGISTER_SUCCESS = "客官您好，您已成功注册三际手机采购网，并获得5000积分，请牢记您的账号和密码。赶快登陆www.3j1688.com，享受一站式采购的极致体验吧！";// 注册成功
  private static String BINDING_SUCCESS_START = "客官您好，您的绑定手机已成功修改为：";// 绑定手机头部
  private static String BINDING_SUCCESS_END = "，请牢记。如有疑问，请致电0531-67860013";// 绑定手机尾部
  private static String SUBMITORDER_SUCCESS_START = "客官您好，您已成功提交订单，订单号为：";// 提交订单头部
  private static String SUBMITORDER_SUCCESS_END = "，您拍下的宝贝数量有限，请抓紧付款";// 提交订单尾部
  // ----------已发货
  private static String FHCG_SUCCESS_START = "客官您好，您采购的宝贝已发货，运单号为：";
  private static String FHCG_SUCCESS_END = "，请注意查收";
  // ---------已签收
  private static String SIGN_SUCCESS = "客官您好，您采购的宝贝已被签收，请确定为本人签收！如有疑问，请致电0531-67860013";
  // ---------申请售后
  private static String SJ_SQSH = "客官您好，我们已收到您的售后申请，售后人员会第一时间联系您，请耐心等到。如有疑问，请致电0531-67860013";
  // ---------货物发回
  private static String SJ_HWFH = "客官您好，您的售后商品已寄回，我们会尽快处理，请耐心等待。如有疑问，请致电0531-67860013";
  // ---------退款信息
  // ---------到货提醒
  private static String SJ_DHTX_START = "客官您好，之前您关注的商品:";
  private static String SJ_DHTX_END = "现已到货，赶紧去采购吧。";
  // 注册通知管理员信息
  private static String SJ_INFO_ADMIN_ZC_1 = "领导您好，";
  private static String SJ_INFO_ADMIN_ZC_2 = "于";
  private static String SJ_INFO_ADMIN_ZC_3 = "注册成功！";
  // 下单通知管理员信息
  private static String SJ_INFO_ADMIN_XD = "";
  // 向注册用户群发信息
  private static String SJ_DXQF_MEMBER_content = "尊敬的手机零售商店主：您已开通三际手机采购网会员权限，网址为WWW.3J1688.COM，可足不出户尊享全品类一站式手机采购服务，天天低价，限时送达，货到付款，两年延保，30天退换，当地三际服务站为您提供快速响应的无忧售后服务。您的登录名即为您的手机号码，默认密码为123456.请您务必及时登录及时修改密码以确保您的账户安全。如有问题请咨询当地移动公司渠道经理或三际服务站服务人员，也可拨打电话：400-937-1688。三际手机采购网竭诚为您服务。";

  private static Logger logger = Logger.getLogger(MsgUtil.class);
  
  private static String APPLIED_REGISTER_SUCCESS = "申请注册";// 申请注册成功
*/
  
  public static void  editOrderPrice(String orderNo, BigDecimal acutalPrice){
	  
	  Map<String, String> params = new HashMap<String, String>();
	  JSONObject obj = new JSONObject();
	  obj.put("orderNo", orderNo);
	  obj.put("acutalPrice", String.valueOf(acutalPrice));
	  params.put("msg", obj.toJSONString());
	  params.put("acutalPrice", String.valueOf(acutalPrice));
	    HttpClientUtils.sendPostRequest("http://115.28.87.182:28503/v1/push/pushAcutalPrice",
	     params, null, null);
	   
  }
  
  
 
  public static void main(String[] args) {
    
  }

  
  /**
   * 向指定 URL 发送POST方法的请求
   * @param url 发送请求的 URL
   * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
   * @return 所代表远程资源的响应结果
   */
  public static String sendPost(String url, String param) {
    PrintWriter out = null;
    BufferedReader in = null;
    String result = "";
    try {
      URL realUrl = new URL(url);
      // 打开和URL之间的连接
      URLConnection conn = realUrl.openConnection();
      // 设置通用的请求属性
      conn.setRequestProperty("accept", "*/*");
      conn.setRequestProperty("connection", "Keep-Alive");
      conn.setRequestProperty("user-agent",
       "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
      conn.setConnectTimeout(5000);
      // 发送POST请求必须设置如下两行
      conn.setDoOutput(true);
      conn.setDoInput(true);
      // 获取URLConnection对象对应的输出流
      out = new PrintWriter(conn.getOutputStream());
      // 发送请求参数
      out.print(param);
      // flush输出流的缓冲
      out.flush();
      // 定义BufferedReader输入流来读取URL的响应
      in = new BufferedReader(
       new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = in.readLine()) != null) {
        result += line;
      }
    } catch (Exception e) {
      System.out.println("发送 POST 请求出现异常！" + e);
      e.printStackTrace();
    }
    //使用finally块来关闭输出流、输入流
    finally {
      try {
        if (out != null) {
          out.close();
        }
        if (in != null) {
          in.close();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return result;
  }


}
