package com.sanji.sjzx.label.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.Label;



public interface LabelMapper {
	/**
	 *根据主键删除标签
	* @Title: deleteByPrimaryKey
	* @Description: TODO(根据主键删除标签)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author ZhouZhangbao
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
    public int insert(Label record);
    /**
	 * 有选择性的插入一条新数据
	* @Title: insertSelective
	* @Description: TODO(有选择性的插入一条新数据)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    public int insertSelective(Label record);
    /**
	 * 根据主键查询
	* @Title: selectByPrimaryKey
	* @Description: TODO(根据主键查询)
	* @param @param id
	* @param @return    设定文件
	* @return Label    返回类型
	* @author songbaozhen
	 */
    public Label selectByPrimaryKey(String id);
    /**
	 * 根据主键有选择性的更新一条新数据
	* @Title: updateByPrimaryKeySelective
	* @Description: TODO(根据主键有选择性的更新一条新数据)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
     public int updateByPrimaryKeySelective(Label record);
    /**
	 * 根据主键更新一条新数据
	* @Title: updateByPrimaryKey
	* @Description: TODO(根据主键更新一条新数据)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    public  int updateByPrimaryKey(Label record);
    /**
	 * 获取标签列表
	* @Title: gainLabelList
	* @Description: TODO(获取标签列表)
	* @param @param label
	* @param @return    设定文件
	* @return list    返回类型
	* @author songbaozhen
	 */
	public List gainLabelList(Label label);
	/**
	 * 获取标签总行数
	* @Title: gainLabelCount
	* @Description: TODO(查询标签总行数)
	* @param @param label
	* @param @return    设定文件
	* @return Long    返回类型
	* @author songbaozhen
	 */
	public Long gainLabelCount(Label label);
	/**
	 * 根据map查询标签
	* @Title: gainLabelByMap
	* @Description: TODO(根据map查询标签)
	* @param @param map
	* @param @return    设定文件
	* @return Long    返回类型
	* @author songbaozhen
	 */
	public Long gainLabelByMap(Map<String, String> map);
	/**
	 * 修改编辑标签
	* @Title: modifylabel
	* @Description: TODO(修改编辑标签)
	* @param @param label
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void modifylabel(Label label);
	/**
	 * 根据主键删除单条或批量删除标签(物理删除)
	* @Title: modifylabel
	* @Description: TODO(根据主键删除单条或批量删除标签(物理删除))
	* @param @param ids
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void dropLabelByIds(List<String> ids);

}