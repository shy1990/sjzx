package com.sanji.sjzx.color.service;

import java.math.BigDecimal;
import java.util.List;

import com.sanji.sjzx.model.Color;
import com.sanji.sjzx.pojo.DataGrid;
/**
 * @ClassName:  ColorService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author songbaozhen
 * @date 2014-9-6 下午14:44
 */
public interface ColorService {
	/**
	 * 获取颜色列表
	 * @Title:  gainColorList
	 * @Description: TODO(获取颜色列表)
	 * @param color
	 * @return    设定文件
	 * @return DataGrid    返回类型
	 */
	public	DataGrid gainColorList(Color color);
	/**
	 * 根据名称判断该颜色是否存在
	 * @Title:  gainIsExistName
	 * @Description: TODO(根据名称判断该颜色是否存在)
	 * @param colorName,  id
	 * @return    设定文件
	 * @return boolean    返回类型
	 */
	public boolean gainIsExistName(String colorName, BigDecimal id);
	/**
	 * 增加颜色
	 * @Title:  gainIsExistName
	 * @Description: TODO(增加颜色)
	 * @param color
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void addColor(Color color);
	/**
	 * 修改颜色
	 * @Title:  modifyColor
	 * @Description: TODO(修改颜色)
	 * @param color
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void modifyColor(Color color);
	/**
	 * 根据id删除颜色
	 * @Title:  deleteColorById
	 * @Description: TODO(根据id删除颜色)
	 * @param stringConvertList
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void deleteColorById(List<String> stringConvertList);
	/**
	 * 根据id判断该颜色是否正在使用
	 * @Title:  existColorIsused
	 * @Description: TODO(根据id判断该颜色是否正在使用)
	 * @param stringConvertList
	 * @return    设定文件
	 * @return boolean    返回类型
	 */
	public boolean existColorIsused(List<String> stringConvertList);
	/**
	 * 获取所有颜色
	 * @param color 
	 * @Title:  gainAllColors
	 * @Description: TODO(获取所有颜色)
	 * @param color
	 * @return    设定文件
	 * @return boolean    返回类型
	 */
	
	public List<Color> gainAllColors(Color color);
}
