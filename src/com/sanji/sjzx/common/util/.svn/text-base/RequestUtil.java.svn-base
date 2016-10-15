/**  
* @Title: RequestUtil.java
* @Package com.sanji.mall.common.util
* @Description: TODO(用一句话描述该文件做�?��)
* @author ZhouZhangbao  
* @date 2014-7-24 上午11:50:58
* @version V1.0  
*/
package com.sanji.sjzx.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: RequestUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-7-24 上午11:50:58
 */
public class RequestUtil {

	/**
	 * 获得请求路径
	* @Title: getRequestPath
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param request
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI();
		requestPath = requestPath.substring(request.getContextPath().length());// 去掉项目路径
		return requestPath;
	}
}
