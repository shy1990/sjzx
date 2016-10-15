/**  
* @Title: ClobUtil.java
* @Package com.sanji.mall.common.util
* @Description: TODO(用一句话描述该文件做�?��)
* @author ZhouZhangbao  
* @date 2014-7-21 下午3:01:45
* @version V1.0  
*/
package com.sanji.sjzx.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

/**
 * 字段Clob和String 直接的转�?
 * @ClassName: ClobUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-7-21 下午3:01:45
 */
public class ClobUtil {
	
	/**
	 * 将CLOB字段转换成STRING 字段
	* @Title: getString
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param c
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String getString(Clob c) {
		StringBuffer s = new StringBuffer();
		if (c != null) {
			try {
				BufferedReader bufferRead = new BufferedReader(c.getCharacterStream());
				try {
					String str;
					while ((str = bufferRead.readLine()) != null) {
						s.append(str);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s.toString();
	}
	
	/**
	 * 获取CLOB字段
	* @Title: getClob
	* @Description: TODO(这里用一句话描述这个方法的作�?
	* @param @param s
	* @param @return    设定文件
	* @return Clob    返回类型
	* @author ZhouZhangbao
	 */
	public static Clob getClob(String s) {
		Clob c = null;
		try {
			if (s != null) {
				c = new SerialClob(s.toCharArray());
			}
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

}
