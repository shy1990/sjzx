/**  
* @Title: EncryptUtil.java
* @Package com.sanji.mall.common.util
* @Description: TODO(用一句话描述该文件做�?��)
* @author ZhouZhangbao  
* @date 2014-7-21 下午4:38:03
* @version V1.0  
*/
package com.sanji.sjzx.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具�?
 * @ClassName: EncryptUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-7-21 下午4:38:03
 */
public class EncryptUtil {
	
	

	/**
	 * 加密
	 * MD5 32位小写加�?
	* @Title: e
	* @Description: TODO(加密)
	* @param @param inputText �?��加密的内�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String e(String inputText) {
		return md5(inputText);
	}

	/**
	 * 二次加密，应该破解不了了吧？
	* @Title: md5AndSha
	* @Description: TODO(二次加密，应该破解不了了吧？)
	* @param @param inputText �?��加密的内�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String md5AndSha(String inputText) {
		return sha(md5(inputText));
	}

	/**
	 * md5加密
	 * 32位小写加�?
	 * @param inputText
	 */
	public static String md5(String inputText) {
		return encrypt(inputText, "md5");
	}

	/**
	 * sha加密
	* @Title: sha
	* @Description: TODO(sha加密)
	* @param @param inputText �?��加密的内�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	public static String sha(String inputText) {
		return encrypt(inputText, "sha-1");
	}

	
	/**
	 * md5或�?sha-1加密
	* @Title: encrypt
	* @Description: TODO(md5或�?sha-1加密)
	* @param @param inputText 要加密的内容
	* @param @param algorithmName 加密算法名称：md5或�?sha-1，不区分大小�?
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	private static String encrypt(String inputText, String algorithmName) {
		if (inputText == null || "".equals(inputText.trim())) {
			throw new IllegalArgumentException("请输入要加密的内�?");
		}
		if (algorithmName == null || "".equals(algorithmName.trim())) {
			algorithmName = "md5";
		}
		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance(algorithmName);
			m.update(inputText.getBytes("UTF8"));
			byte s[] = m.digest();
			// m.digest(inputText.getBytes("UTF8"));
			return hex(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptText;
	}

	/**
	 * 返回十六进制字符�?
	* @Title: hex
	* @Description: TODO(返回十六进制字符�?
	* @param @param arr
	* @param @return    设定文件
	* @return String    返回类型
	* @author ZhouZhangbao
	 */
	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}

	
	/**
	 * 测试
	* @Title: main
	* @Description: TODO(测试)
	* @param @param args    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public static void main(String[] args) {
		// md5加密测试
		String md5_1 = md5("123456");
		String md5_2 = md5("Zhangbao Zhou");
		System.out.println(md5_1 + "\n" + md5_2);
		// sha加密测试
		String sha_1 = sha("123456");
		String sha_2 = sha("Huifeng Wang");
		System.out.println(sha_1 + "\n" + sha_2);

	}
}
