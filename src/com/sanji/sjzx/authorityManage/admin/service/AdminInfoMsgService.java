/**  
* @Title: AdminInfoMsgService.java
* @Package com.sanji.sjzx.authorityManage.admin.service
* @Description: TODO(用一句话描述该文件做什么)
* @author ZhouZhangbao  
* @date 2015-2-5 下午4:26:00
* @version V1.0  
*/
package com.sanji.sjzx.authorityManage.admin.service;

import java.util.List;

import com.sanji.sjzx.model.AdminInfoMsg;

/**
 * @ClassName: AdminInfoMsgService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2015-2-5 下午4:26:00
 */
public interface AdminInfoMsgService {
	
	public List<AdminInfoMsg> gainInfoMsgByUserId(AdminInfoMsg adminInfoMsg);

	/**
	* @Title: addMsgAuthors
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param aid 授权管理员的ID
	* @param @param mids 授权区域的ID
	* @param @param type   授权的通知类型 1-注册  2-下单
	* @return void    返回类型
	* @author ZhouZhangbao
	*/
	
	public void addMsgAuthors(AdminInfoMsg adminInfoMsg);

}
