package com.sanji.sjzx.cat.service;

import java.util.List;

import com.sanji.sjzx.model.Cat;
import com.sanji.sjzx.pojo.DataGrid;

public interface CatService {
	/**
	 * 获取分类列表
	 * @param cat
	 * @return
	 */
	public DataGrid gainCatList(Cat cat);
	/**
	 * 添加分类信息
	 * @param cat
	 */
	public void addCat(Cat cat);
	/**
	 * 添加时根据name进行查询是否存在该cat
	 * @param name
	 * @return
	 */
	public boolean gainCatByName(String name);
	/**
	 * 修改分类信息
	 * @param cat
	 */
	public void updateCat(Cat cat);
	/**
	 * 修改时根据id和name进行查询是否存在该cat
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean gainCatByNameandId(String id,String name);
	/**
	 * 删除相应id的记录
	 * @param ids
	 */
	public void dropCat(List<String> ids);
	/**
	 * 根据类别id获取类别信息（用于类别管理中删除类别时判断该类别是否关联商品）
	 * @Title:gainGoodsByCatId
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param catId
	 * @param @return 设定文件
	 * @return List<Goods> 返回类型
	 * @throws
	 * @param catId
	 * @return
	 */
	public boolean gainGoodsByCatId(String catId);
 
}
