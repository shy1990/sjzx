package com.sanji.sjzx.system.friendlylink.service;

import java.util.List;

import com.sanji.sjzx.model.FriendlyLink;
import com.sanji.sjzx.pojo.DataGrid;

/**
 * @ClassName: FriendlyLinkService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author songbaozhen
 * @date 2014-9-6 下午14:44
 */
public interface FriendlyLinkService {
	
	/**
	 * 获取友情链接公司列表
	 * @Title: gainFriendlyLinkList
	 * @Description: TODO(获取友情链接公司列表)
	 * @param friendlyLink
	 * @return    设定文件
	 * @return DataGrid    返回类型
	 */
	public DataGrid gainFriendlyLinkList(FriendlyLink friendlyLink);
	/**
	 * 增加友情链接公司
	 * @Title: addFriendlyLink
	 * @Description: TODO(增加友情链接公司)
	 * @param friendlyLink
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void addFriendlyLink(FriendlyLink friendlyLink);
	/**
	 * 根据主键id单条或批量删除友情链接公司(逻辑删除，此处为物理删除)
	 * @Title: deleteFriendlyLink
	 * @Description: TODO(根据主键id单条或批量删除物流公司(逻辑删除))
	 * @param ids
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void deleteFriendlyLinkById(List<String> ids);
	/**
	 * 根据主键id单条或批量删除友情链接公司(物理删除)
	 * @Title: dropFriendlyLinkById
	 * @Description: TODO(根据主键id单条或批量删除友情链接公司)
	 * @param ids
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void dropFriendlyLinkById(List<String> ids);
	/**
	 * 编辑友情链接公司
	 * @Title: modifyFriendlyLink
	 * @Description: TODO(编辑友情链接公司)
	 * @param  friendlyLink
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void modifyFriendlyLink(FriendlyLink friendlyLink);
	
	/**
	 * 根据名称和主键验证友情链接公司是否存在
	 * @Title:gainIsExistName
	 * @Description: TODO(根据名称验证友情链接公司是否存在)
	 * @param name
	 * @return boolean
	 */
	public boolean gainIsExistName(String name , String id);
	/**
	 * 查找友情链接公司最大排序号的值
	 * @Title:gainIsExistName
	 * @Description: TODO(查找友情链接公司最大排序号的值)
	 * @param 
	 * @return int
	 */
	public int getMaxOrderNum();
	/**
	 * 根据主键查找友情链接公司
	 * @Title:gainFriendlyLinkById
	 * @Description: TODO(根据主键查找友情链接公司,返回imageUrl)
	 * @param id
	 * @return FriendlyLink
	 */
	public String gainFriendlyLinkByIdForImageUrl(String id);
}
