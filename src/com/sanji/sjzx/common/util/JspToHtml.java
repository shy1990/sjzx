/**  
* @Title: JspToHtml.java
* @Package com.sanji.mall.common.util
* @Description: TODO(用一句话描述该文件做�?��)
* @author ZhouZhangbao  
* @date 2014-7-23 下午4:52:26
* @version V1.0  
*/
package com.sanji.sjzx.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName: JspToHtml
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-7-23 下午4:52:26
 */
public class JspToHtml {
	/**
	* @Title: JspToHtmlByURL
	* @Description: 
	* @param @param u 要转换的路径:http://www.xx.com/index.jsp
	* @param @param path 输出路径  c:\\cc.html
	* @param @return    设定文件
	* @return boolean    返回类型
	*/
	public static boolean JspToHtmlByURL(String u, String path) { 
        //从utl中读取html存为str 
        String str = ""; 
        try { 
                URL url = new URL(u); 
                URLConnection uc = url.openConnection(); 
                InputStream is = uc.getInputStream(); 
                BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
                while (br.ready()) { 
                        str += br.readLine() + "\n"; 
                         
                } 
                is.close(); 
               // str=new String(str.getBytes("utf-8"),"GBK");
                //写入文件 
                File f = new File(path); 
                OutputStreamWriter filerWriter = new OutputStreamWriter(new FileOutputStream(f,true),"utf-8");//设置输出编码
                BufferedWriter o = new BufferedWriter(filerWriter); 
                o.write(str); 
                o.close(); 
                str = ""; 
                return true; 
        } catch (Exception e) { 
                e.printStackTrace(); 
                return false; 
        } 
	} 
	public static String snatchHtml(String u){
		StringBuffer html = new StringBuffer();
		try{
		      URL url = new URL(u);
		      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		      InputStreamReader isr = new InputStreamReader(conn.getInputStream());
		      BufferedReader br = new BufferedReader(isr);
		      String temp;
		      while ((temp = br.readLine()) != null) {
		        html.append(temp).append("\n");
		      }
		      br.close();
		      isr.close();
		}catch(Exception e){
		System.out.println(e.getMessage());
		}
		return html.toString();
		}
	public static void main(String[] args) {
		//System.out.println(ResourceUtil.getWebAppPath());
		String s=snatchHtml("http://localhost:8080/index.jsp");
		System.out.println(s);
		JspToHtmlByURL("http://localhost:8080", "c:/c.html");
	}
}
