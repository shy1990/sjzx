package com.sanji.sjzx.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * jsp相对路径设置
* @ClassName: PathUtil
* @Description: TODO(这里用一句话描述这个类的作用)
* @author ZhouZhangbao
* @date 2014-9-4 下午7:51:54
 */
public class PathUtil {
  public static String getPath(HttpServletRequest request){	 
	  String path = request.getContextPath();
	  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	 return basePath; 
  }
}
