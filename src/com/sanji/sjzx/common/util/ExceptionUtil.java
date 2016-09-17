/**  
* @Title: ExceptionUtil.java
* @Package com.sanji.mall.common.util
* @Description: TODO(用一句话描述该文件做�?��)
* @author ZhouZhangbao  
* @date 2014-7-21 下午4:54:47
* @version V1.0  
*/
package com.sanji.sjzx.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;


/**
 * Exception工具�?
 * @ClassName: ExceptionUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-7-21 下午4:54:47
 */
public class ExceptionUtil {
	
	private static final Logger logger = Logger.getLogger(ExceptionUtil.class);

	/**
	 * 返回错误信息字符�?
	* @Title: getExceptionMessage
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param ex
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String getExceptionMessage(Exception ex) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String errorMessage = sw.toString();
		pw.close();
		try {
			sw.close();
		} catch (IOException e) {
			logger.error(e);
		}
		return errorMessage;
	}

}
