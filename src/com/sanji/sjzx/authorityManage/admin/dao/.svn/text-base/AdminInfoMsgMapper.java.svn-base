package com.sanji.sjzx.authorityManage.admin.dao;

import java.util.List;

import com.sanji.sjzx.model.AdminInfoMsg;



public interface AdminInfoMsgMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(AdminInfoMsg record);

    AdminInfoMsg selectByPrimaryKey(String id);

	/**
	* @Title: gainInfoMsgByUserId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param userId
	* @param @return    设定文件
	* @return List<AdminInfoMsg>    返回类型
	* @author ZhouZhangbao
	*/
	
	public List<AdminInfoMsg> gainInfoMsgByUserId(AdminInfoMsg adminInfoMsg);

	/**
	* @Title: deleteByUserIdAndType
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param aid
	* @param @param type    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	*/
	
	public void deleteByUserIdAndType(AdminInfoMsg adminInfoMsg);

	/**
	* @Title: addMsgAuthors
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param msgAuthors    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	*/
	
	public void addMsgAuthors(List<AdminInfoMsg> msgAuthors);

    
}