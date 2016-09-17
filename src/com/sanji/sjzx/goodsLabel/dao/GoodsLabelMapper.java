package com.sanji.sjzx.goodsLabel.dao;

import java.util.List;

import com.sanji.sjzx.model.GoodsLabel;


public interface GoodsLabelMapper {
	/**
	 *根据主键删除一条记录
	* @Title: deleteByPrimaryKey
	* @Description: TODO(根据主键删除一条记录)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    public int deleteByPrimaryKey(String id);
    /**
	 *增加一条记录
	* @Title: insert
	* @Description: TODO(增加一条记录)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    public int insert(GoodsLabel record);
    /**
	 *有选择性的增加一条记录
	* @Title: insertSelective
	* @Description: TODO(有选择性的增加一条记录)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    public int insertSelective(GoodsLabel record);
    /**
	 *根据主键查询信息
	* @Title: selectByPrimaryKey
	* @Description: TODO(根据主键查询信息)
	* @param @param id
	* @param @return    设定文件
	* @return GoodsLabel  返回类型
	* @author songbaozhen
	 */
    public GoodsLabel selectByPrimaryKey(String id);
    /**
	 *有选择性的更新一条记录
	* @Title: updateByPrimaryKeySelective
	* @Description: TODO(有选择性的更新一条记录)
	* @param @param record
	* @param @return    设定文件
	* @return int  返回类型
	* @author songbaozhen
	 */
    public int updateByPrimaryKeySelective(GoodsLabel record);
    /**
	 *更新一条记录
	* @Title: updateByPrimaryKeySelective
	* @Description: TODO(更新一条记录)
	* @param @param record
	* @param @return    设定文件
	* @return int  返回类型
	* @author songbaozhen
	 */
    public int updateByPrimaryKey(GoodsLabel record);
    /**
	 *根据主键查询记录信息
	* @Title: updateByPrimaryKeySelective
	* @Description: TODO(根据主键查询记录信息)
	* @param @param ids
	* @param @return    设定文件
	* @return void  返回类型
	* @author songbaozhen
	 */
	public List gainGoodsLabelByIds(List<String> ids);
}