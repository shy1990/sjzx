package com.sanji.sjzx.label.service;

import java.util.List;

import com.sanji.sjzx.model.Label;
import com.sanji.sjzx.pojo.DataGrid;

/**
 * @ClassName: LabelService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author songbaozhen
 * @date 2014-9-6 下午14:44
 */
public interface LabelService {
	
	/**
	 * 获取物流公司列表
	 * @Title: gainLabelList
	 * @Description: TODO(获取标签列表)
	 * @param label
	 * @return    设定文件
	 * @return DataGrid    返回类型
	 */
	public DataGrid gainLabelList(Label label);
	/**
	 * 添加标签
	 * @Title: addLabel
	 * @Description: TODO(添加标签)
	 * @param label
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void addLabel(Label label);

	/**
	 * 验证标签名称是否存在
	 * @Title: gainLabelList
	 * @Description: TODO(验证标签名称是否存在)
	 * @param name ， id
	 * @return    设定文件
	 * @return boolean    返回类型
	 */
	public boolean gainIsExistName(String name, String id);
	/**
	 * 修改编辑标签
	 * @Title: modifylabel
	 * @Description: TODO(修改编辑标签)
	 * @param label
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void modifylabel(Label label);
	/**
	 * 根据主键删除单条或批量删除标签(物理删除)
	 * @Title: modifylabel
	 * @Description: TODO(根据主键删除单条或批量删除标签(物理删除))
	 * @param ids
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void droplabelById(List<String> ids);

}
