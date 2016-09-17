package com.sanji.sjzx.common.util;

import java.util.Map;
import java.util.ResourceBundle;

import org.apache.struts2.ServletActionContext;

/**
 * 项目参数工具�?
* @ClassName: ResourceUtil
* @Description: TODO(获取系统级别的参�?
* @author ZhouZhangbao
* @date 2014-7-14 下午3:25:22
 */
public class ResourceUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("config");
	
	private static Map<String, Object> session;

	public static Map<String, Object> getSession() {
		return session;
	}

	public static void setSession(Map<String, Object> session) {
		ResourceUtil.session = session;
	}

	/**
	 * 获得sessionInfo名字
	 * 
	 * @return
	 */
	public static final String getSessionInfoName() {
		return bundle.getString("sessionInfoName");
	}
	
	public static final String getRegisterMobileCode(){
		return bundle.getString("registerMobileCode");
	}
	
	
	
	/**
	 * 获取tomcat目录�?webapp的路�?
	 */
	public static final String getWebAppPath(){
		 String path=ServletActionContext.getServletContext().getRealPath(
					"")+"/";
		 return path;
	}
	
	public static final String getGoods_Img_Directory(){
		return bundle.getString("goods_Img_Directory");
	}
	
	
	/**
	 * FTP�?��
	* @Title: getWaterPath
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	*/
	public static String getWaterPath() {
		// TODO Auto-generated method stub
		return bundle.getString("waterPath");
	}
	
	public static String getWebPath(){
		return bundle.getString("webpath");
	}
	
	public static String getFtpIp(){
		return bundle.getString("ftpIp");
	}
	public static String getFtpUserName(){
		return bundle.getString("ftpUserName");
	}
	public static String getFtpPassword(){
		return bundle.getString("ftpPassword");
	}
	
	/**
	 * 通过KEY获取�?
	* @Title: get
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param key
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	* @throws
	 */
	public static final String get(String key) {
		return bundle.getString(key);
	}
	/**
	 * 编辑器所�?��
	* @Title: getKindeditorFieldName
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static final String getKindeditorFieldName(){
		return bundle.getString("kindeditorFieldName");
	}
	
	public static final String getKindeditorUploadFileExts(){
		return bundle.getString("kindeditorUploadFileExts");
	}
	
	public static final String getDomain(){
		return bundle.getString("domain");
	}
	
	/**
	 * @Title: getRandNum
	 * @Description: TODO(获取有效时间) 
	 * @param @return    设定文件 
	 * @return String 返回类型 
	 * @author wangmei
	 */
	public static final String getValidTime (String type){
		if("1".equals(type)){
			return bundle.getString("validTimeForMobile");
		}else{
			return bundle.getString("validTimeForEmail");
		}
	}
	
	/**
	 * 获取联行支付的MerId
	* @Title: getLhMerId
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static final String getLhMerId(){
		return bundle.getString("LhMerId");
	}
	
	/**
	 *  获取联行支付的授权码key
	* @Title: getLhKey
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static final String getLhKey(){
		return bundle.getString("LhKey");
	}
	
	/**
	 * 支付完成后支付结果返回到该url，主要用于结果展�?
	* @Title: getLhDealReturn
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static final String getLhDealReturn(){
		return bundle.getString("LhDealReturn");
	}
	
	/**
	 * 支付完成后支付结果�?知到该url，主要用于�?知接�?
	* @Title: getLhDealNotify
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static final String getLhDealNotify(){
		return bundle.getString("LhDealNotify");
	}
	
	public static final String getUploadDirectory(){
		return bundle.getString("uploadDirectory");
	}
	
	public static final String getUploadFieldName(){
		return bundle.getString("uploadFieldName");
	}
	
	public static final String getUploadFileExts(){
		return bundle.getString("uploadFileExts");
	}

	/**
	* @Title: getUploadFileMaxSize
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return long    返回类型
	* @author ZhouZhangbao
	*/
	
	public static long getUploadFileMaxSize() {
		// TODO Auto-generated method stub
		return Long.valueOf(bundle.getString("uploadFileMaxSize"));
	}
	
	public static String getNewsUploadDirectory(){
		return bundle.getString("newsUploadDirectory");
	}
	
	public static String getImage_Ext(){
		return bundle.getString("images_Ext");
	}
}
