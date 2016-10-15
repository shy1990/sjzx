/**  
* @Title: PwdCrypt.java
* @Package com.sanji.mall.common.util
* @Description: TODO(用一句话描述该文件做�?��)
* @author ZhouZhangbao  
* @date 2014-7-23 下午2:03:48
* @version V1.0  
*/
package com.sanji.sjzx.common.util;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * @ClassName: PwdCrypt
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-7-23 下午2:03:48
 */
public class PwdCrypt {
final static String love = "zhouzhangbao@126>COM!@#$%^&";
	
	public static PwdCrypt getInstance(){
		return new PwdCrypt();
	}
    /**
     * 加密操作
    * @Title: encrypt
    * @Description: TODO(这里用一句话描述这个方法的作�?
    * @param @param data
    * @param @return    设定文件
    * @return String    返回类型
    * @author ZhouZhangbao
     */
    public static String encrypt(String data) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(simplecrypt(data).getBytes());
    }
    
    /**
     * 解密操作
    * @Title: decrypt
    * @Description: TODO(这里用一句话描述这个方法的作�?
    * @param @param data
    * @param @return    设定文件
    * @return String    返回类型
    * @author ZhouZhangbao
     */
    public static String decrypt(String data) {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] result = null;
		try {
			result = decoder.decodeBuffer(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return simplecrypt(new String(result));
    }
    
    /**
     * 进行常量异或
    * @Title: simplecrypt
    * @Description: TODO(这里用一句话描述这个方法的作�?
    * @param @param data
    * @param @return    设定文件
    * @return String    返回类型
    * @author ZhouZhangbao
     */
    public static String simplecrypt(String data){
    	char[] a = data.toCharArray();
		for (int i = 0; i < a.length; i++) {
			for(int j=0;j<love.length();j++){
				char c = love.charAt(j);
				a[i] = (char) (a[i] ^ c);
			}
		}
		String s = new String(a);
		return s;
    }
    
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		PwdCrypt pwdCrypt = new PwdCrypt();
//		String estr = pwdCrypt.encrypt("admin");
//		System.out.println("estr is : " + estr);
//		String dstr = pwdCrypt.decrypt(estr);
//		System.out.println("dstr is : " + dstr);
//		  BASE64Decoder decoder = new BASE64Decoder();
//	        byte[] result = null;
//			try {
//				result = decoder.decodeBuffer("UhIUBhEXF1Y=");
//				System.out.println("dstr is : " + pwdCrypt.simplecrypt(new String(result)));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}


}
