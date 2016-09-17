package com.sanji.sjzx.news.service;

import java.util.List;

import com.sanji.sjzx.model.NewsCatType;


/**
 * @ClassName: NewsCatTypeService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2013-5-11 上午10:13:34
 *
 */
public interface NewsCatTypeService {

	/**
	* @Title: gainAll
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param newCatType    设定文件
	* @return void    返回类型
	*/
	List<NewsCatType> gainAll(NewsCatType newCatType);
	
	Long gainAllCount(NewsCatType newsCatType);

	/**
	* @Title: add
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param newsCatType    设定文件
	* @return void    返回类型
	*/
	void add(NewsCatType newsCatType);

	/**
	* @Title: update
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param newsCatType    设定文件
	* @return void    返回类型
	*/
	void update(NewsCatType newsCatType);

	/**
	* @Title: drop
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param newsCatType    设定文件
	* @return void    返回类型
	*/
	void drop(String string);

	/**
	* @Title: gainNewsCatTypeById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param parameter    设定文件
	* @return void    返回类型
	*/
	NewsCatType gainNewsCatTypeById(String parameter);

	/**
	* @Title: gainAllList
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param newsCatType
	* @param @return    设定文件
	* @return List    返回类型
	*/
	List<NewsCatType> gainAllList(NewsCatType newsCatType);

}
