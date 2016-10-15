package com.sanji.sjzx.news.dao;


import java.util.List;

import com.sanji.sjzx.model.NewsCat;



public interface NewsCatMapper {
	/**
	* @Title: gainNewsCatById
	* @Description: TODO根据Id查询newsCat
	* @param @param id
	* @param @return    设定文件
	* @return NewsCat    返回类型
	*/
	NewsCat gainNewsCatById(String id);
	/**
	* @Title: addNewsCat
	* @param @param newsCat    设定文件
	* @return void    返回类型
	*/
	void addNewsCat(NewsCat newsCat);
	/**
	* @Title: updateNewsCat
	* @param @param newsCat    设定文件
	* @return void    返回类型
	*/
	void updateNewsCat(NewsCat newsCat);
	/**
	* @Title: gainAll
	* @Description: TODO获取所有分类
	* @param @param newsCat
	* @param @return    设定文件
	* @return List<NewsCat>    返回类型
	*/
	List<NewsCat> gainAll(NewsCat newsCat);
	/**
	* @Title: gainAllCount
	* @Description: TODO获取所有分类数量
	* @param @param newsCat
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long gainAllCount(NewsCat newsCat);
	/**
	* @Title: drop
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param newsCat    设定文件
	* @return void    返回类型
	*/
	void drop(NewsCat newsCat);
	/**
	* @Title: gainNewsCatChildByPid
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long gainNewsCatChildByPid(String id);
	/**
	* @Title: gainNewsCatByPtree
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param ptree
	* @param @return    设定文件
	* @return List<NewsCat>    返回类型
	*/
	List<NewsCat> gainNewsCatByPtree(String ptree);
	/**
	* @Title: gainFirstNewsCat
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param newsCat
	* @param @return    设定文件
	* @return List<NewsCat>    返回类型
	*/
	List<NewsCat> gainFirstNewsCat(NewsCat newsCat);
	/**
	* @Title: gainSecondNewsCatByFirstId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return List<NewsCat>    返回类型
	*/
	List<NewsCat> gainSecondNewsCatByFirstId(String id);
}