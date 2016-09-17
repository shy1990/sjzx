package com.sanji.sjzx.news.service;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.News;

/**
 * @ClassName: NewsService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2013-5-7 下午1:07:25
 *
 */
public interface NewsService{
	/**
	* @Title: gainAll
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param news
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	public List<News> gainAll(News news);
	/**
	* @Title: gainAllCount
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param news
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainAllCount(News news);
	/**
	* @Title: add
	* @Description: TODO添加文章
	* @param @param news    设定文件
	* @return void    返回类型
	*/
	public void addNews(News news);
	/**
	* @Title: updateNews
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param news    设定文件
	* @return void    返回类型
	*/
	public void updateNews(News news);
	
	public Long gainNewsCountByNewsCatId(String id);
	/**
	* @Title: delete
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	public void delete(List<String> stringConvertList);
	/**
	* @Title: recover
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	public void recover(List<String> stringConvertList);
	/**
	* @Title: drop
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	public void drop(List<String> stringConvertList);
	/**
	* @Title: drop
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	/**
	* @Title: gainNewsById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return News    返回类型
	*/
	public News gainNewsById(String id);

	/**
	* @Title: uploadPic
	* @Description: 
	* @param @param map
	* @param @return    设定文件
	* @return Map<String,Object>    返回类型
	*/
	public Map<String,Object> upload(Map<String,Object> map) throws Exception; 
	
}
