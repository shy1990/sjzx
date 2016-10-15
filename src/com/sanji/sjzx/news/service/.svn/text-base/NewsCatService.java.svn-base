package com.sanji.sjzx.news.service;

import java.util.List;

import com.sanji.sjzx.model.NewsCat;



/**
 * @ClassName: NewsCatService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2013-5-17 下午3:17:28
 *
 */
public interface NewsCatService {
	/**
	* @Title: gainNewsCatById
	* @param @param id
	* @param @return    设定文件
	* @return NewsCat    返回类型
	*/
	public NewsCat gainNewsCatById(String id);
	
	/**
	* @Title: addNewsCat
	* @Description: TODO添加分类
	* @param @param newsCat    设定文件
	* @return void    返回类型
	*/
	public void addNewsCat(NewsCat newsCat);
	
	/**
	* @Title: updateNewsCat
	* @Description: TODO更新分类
	* @param @param newsCat    设定文件
	* @return void    返回类型
	*/
	public void updateNewsCat(NewsCat newsCat);

	/**
	* @Title: gainAllCount
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param newsCat
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainAllCount(NewsCat newsCat);

	/**
	* @Title: gainAll
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param newsCat
	* @param @return    设定文件
	* @return List    返回类型
	*/
	public List<NewsCat> gainAll(NewsCat newsCat);

	/**
	* @Title: drop
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param newsCat    设定文件
	* @return void    返回类型
	*/
	public void drop(NewsCat newsCat);

	/**
	* @Title: gainNewsCatChildByPid
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainNewsCatChildByPid(String id);
	
	/**
	* @Title: gainNewsCatByPtree
	* @Description: TODO根据ptree查询newsCat
	* @param @param ptree
	* @param @return    设定文件
	* @return List<NewsCat>    返回类型
	*/
	public List<NewsCat> gainNewsCatByPtree(String ptree);

	/**
	* @Title: gainSecondNewsCatByFirstId
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param parameter
	* @param @return    设定文件
	* @return Object    返回类型
	*/
	public List<NewsCat> gainSecondNewsCatByFirstId(String parameter);

	/**
	* @Title: gainFirstNewsCat
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param newsCat
	* @param @return    设定文件
	* @return Object    返回类型
	*/
	public List<NewsCat> gainFirstNewsCat(NewsCat newsCat);
}
