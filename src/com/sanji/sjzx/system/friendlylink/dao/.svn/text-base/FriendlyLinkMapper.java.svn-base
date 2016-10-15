package com.sanji.sjzx.system.friendlylink.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.FriendlyLink;


public interface FriendlyLinkMapper {
	/**
	 * 根据主键查询友情链接公司,返回imageUrl
	* @Title: gainFriendlyLinkByIdForImageUrl
	* @Description: TODO(根据主键查询友情链接公司,返回imageUrl)
	* @param @param id
	* @param @return    设定文件
	* @return friendlyLink    返回类型
	* @author songbaozhen
	 */
   public String gainFriendlyLinkByIdForImageUrl(String id);
	/**
	 * 根据主键删除友情链接公司
	* @Title: deleteByPrimaryKey
	* @Description: TODO(根据主键删除友情链接公司)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
   public int deleteByPrimaryKey(String id);
   /**
	 * 插入一条新数据
	* @Title: insert
	* @Description: TODO(插入一条新数据)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
   public int insert(FriendlyLink record);
   /**
	 * 选择性插入一条新数据
	* @Title: insertSelective
	* @Description: TODO(选择性插入一条新数据)
	* @param @param  record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
   public int insertSelective(FriendlyLink record);
   /**
	 * 根据主键查询友情链接公司
	* @Title: selectByPrimaryKey
	* @Description: TODO(根据主键查询友情链接公司)
	* @param @param id
	* @param @return    设定文件
	* @return friendlyLink    返回类型
	* @author songbaozhen
	 */
   public String selectByPrimaryKey(String id);
   /**
	 * 根据主键更新友情链接公司
	* @Title: updateByPrimaryKeySelective
	* @Description: TODO(根据主键更新友情链接公司)
	* @param @param  record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
   public int updateByPrimaryKeySelective(FriendlyLink record);
   /**
	 * 根据主键选择性更新友情链接公司
	* @Title: updateByPrimaryKey
	* @Description: TODO(根据主键更新友情链接公司)
	* @param @param FriendlyLink record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
 //  public int updateByPrimaryKey(FriendlyLink record);
   /**
	 * 查询最后增加的友情链接公司，返回其排序号
	* @Title: gainLastFriendlyLink
	* @Description: TODO(查询最后增加的友情链接公司，返回其排序号)
	* @param @param 
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
   public int gainLastFriendlyLink();
   
  
   
   /**
	 * 验证友情链接公司是否存在
	* @Title: existFriendlyLinkByMap
	* @Description: TODO(验证友情链接公司是否存在)
	* @param @param map
	* @param @return    设定文件
	* @return Long   返回类型
	* @author songbaozhen
	 */
   public Long existFriendlyLinkByMap(Map<String, String> map);
   /**
	 * 查询友情链接数量
	* @Title: gainFriendlyLinkCount
	* @Description: TODO(查询友情链接数量)
	* @param @param friendlyLink
	* @param @return    设定文件
	* @return Long   返回类型
	* @author songbaozhen
	 */
   public Long gainFriendlyLinkCount(FriendlyLink friendlyLink);
   /**
	 * 查询友情链接公司列表
	* @Title:  gainFriendlyLinkList
	* @Description: TODO(查询友情链接公司列表)
	* @param @param friendlyLink
	* @param @return    设定文件
	* @return list    返回类型
	* @author songbaozhen
	 */
   public List gainFriendlyLinkList(FriendlyLink friendlyLink);
   /**
	 * 单条或多条删除友情链接公司(物理删除)
	* @Title: dropFriendlyLinkByIds
	* @Description: TODO(插入一条新数据)
	* @param @param ids
	* @param @return    设定文件
	* @return void   返回类型
	* @author songbaozhen
	 */
   public void dropFriendlyLinkByIds(List<String> ids);
   /**
	 * 单条或多条删除友情链接公司(逻辑删除)
	* @Title: deleteFriendlyLinkByIds
	* @Description: TODO(单条或多条删除友情链接公司)
	* @param @param ids
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
   public void deleteFriendlyLinkByIds(List<String> ids);
   /**
	 * 编辑友情链接公司
	* @Title: modifyFriendlyLink
	* @Description: TODO(编辑友情链接公司)
	* @param @param friendlyLink
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
   public void modifyFriendlyLink(FriendlyLink friendlyLink);
}