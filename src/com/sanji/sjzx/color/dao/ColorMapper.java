package com.sanji.sjzx.color.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.Color;

public interface ColorMapper {
	/**
	 *根据主键删除一条新数据
	* @Title: deleteByPrimaryKey
	* @Description: TODO(根据主键删除一条新数据)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    public int deleteByPrimaryKey(BigDecimal id);
    /**
	 *增加一条新数据
	* @Title: insert
	* @Description: TODO(增加一条新数据)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    public int insert(Color record);
    /**
	 *根据主键有选择的增加一条新数据
	* @Title: insertSelective
	* @Description: TODO(根据主键有选择的增加一条新数据)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    public int insertSelective(Color record);
    /**
	 *根据主键查询信息
	* @Title: selectByPrimaryKey
	* @Description: TODO(根据主键查询信息)
	* @param @param id
	* @param @return    设定文件
	* @return Color  返回类型
	* @author songbaozhen
	 */
    public Color selectByPrimaryKey(BigDecimal id);
    /**
   	 *根据主键有选择性的跟新一条数据
   	* @Title: updateByPrimaryKeySelective
   	* @Description: TODO(根据主键有选择性的跟新一条数据)
   	* @param @param record
   	* @param @return    设定文件
   	* @return int  返回类型
   	* @author songbaozhen
   	 */
    public int updateByPrimaryKeySelective(Color record);
    /**
   	 *根据主键跟新一条数据
   	* @Title: updateByPrimaryKey
   	* @Description: TODO(根据主键跟新一条数据)
   	* @param @param record
   	* @param @return    设定文件
   	* @return int 返回类型
   	* @author songbaozhen
   	 */
    public int updateByPrimaryKey(Color record);
    /**
   	 *获取颜色列表
   	* @Title: gainColorList
   	* @Description: TODO(获取颜色列表)
   	* @param @param color
   	* @param @return    设定文件
   	* @return List 返回类型
   	* @author songbaozhen
   	 */
	public List gainColorList(Color color);
	
	/**
   	 *查询颜色总数
   	* @Title: gainColorCount
   	* @Description: TODO(查询颜色总数)
   	* @param @param color
   	* @param @return    设定文件
   	* @return List 返回类型
   	* @author songbaozhen
   	 */
	public Long gainColorCount(Color color);
	/**
   	 *根据map查询颜色
   	* @Title: gainColorByMap
   	* @Description: TODO(根据map查询颜色)
   	* @param @param map
   	* @param @return    设定文件
   	* @return Long 返回类型
   	* @author songbaozhen
   	 */
	public Long gainColorByMap(Map<String, Object> map);
	/**
   	 *修改颜色
   	* @Title: modifyColor
   	* @Description: TODO(修改颜色)
   	* @param @param color
   	* @param @return    设定文件
   	* @return void 返回类型
   	* @author songbaozhen
   	 */
	public void modifyColor(Color color);
	/**
   	 *根据id查询颜色列表
   	* @Title: gainColorByIds
   	* @Description: TODO(根据id查询颜色列表)
   	* @param @param ids
   	* @param @return    设定文件
   	* @return List<Color> 返回类型
   	* @author songbaozhen
   	 */
	public List<Color> gainColorByIds(List<String> ids);
	/**
   	 *根据id删除颜色
   	* @Title: deleteByIds
   	* @Description: TODO(根据id删除颜色)
   	* @param @param ids
   	* @param @return    设定文件
   	* @return void 返回类型
   	* @author songbaozhen
   	 */
	public void deleteByIds(List<String> ids);
	
	/**
	 * 获取所有颜色
	 * @Title:gainAllColor
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<Color> 返回类型
	 * @throws
	 * @return
	 */
	public List<Color> gainAllColor();
	/**
	 * 获取所有颜色
	 * @Title:gainAllColor
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<Color> 返回类型
	 * @throws
	 * @return
	 */
	public List<Color> gainAllColors(Color color);
	
}