package com.sanji.sjzx.news.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.News;


/**
* @ClassName: NewsMapper
* @Description: TODO新闻类接口
* @author ZhouZhangbao
* @date 2013-5-7 下午1:22:28
*
*/
public interface NewsMapper {

	/**
	* @Title: gainAll
	* @Description: 获取所有发布的文章信息
	* @param @param news
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	List<News> gainAll(News news);

	/**
	* @Title: gainAllCount
	* @Description: TODO获得数量
	* @param @param news
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	Long gainAllCount(News news);

	/**
	* @Title: addNews
	* @Description: TODO添加文章
	* @param @param news    设定文件
	* @return void    返回类型
	*/
	void addNews(News news);

	/**
	* @Title: updateNews
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param news    设定文件
	* @return void    返回类型
	*/
	void updateNews(News news);
	
	Long gainNewsCountByNewsCatId(String id);

	/**
	* @Title: delete
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	void delete(List<String> stringConvertList);

	/**
	* @Title: recover
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	void recover(List<String> stringConvertList);

	/**
	* @Title: drop
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param stringConvertList    设定文件
	* @return void    返回类型
	*/
	void drop(List<String> stringConvertList);

	/**
	* @Title: gainNewsById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param id
	* @param @return    设定文件
	* @return News    返回类型
	*/
	News gainNewsById(String id);

	/**
	* @Title: updateNewsByProperty
	* @Description: 更新其他新闻,保证每个分类只有一个焦点新闻
	* @param @param map    设定文件
	* @return void    返回类型
	*/
	void updateNewsByProperty(News news);
	
	/**
	 * @Title: gainNewsReadCountStatistics
	 * @Description: TODO(按时间段查询各资讯频道文章数量及阅读次数统计) 
	 * @param @param newsCatName
	 * @param @return    设定文件 
	 * @return Long 返回类型 
	 * @author wangmei
	 */
	Long gainNewsReadCountStatistics(Map<String, Object> map);
	
	/**
	 * @Title: gainNewsReadRankStatistics
	 * @Description: TODO(文章阅读排名统计) 
	 * @param @return    设定文件 
	 * @return List<News> 返回类型 
	 * @author wangmei
	 */
	List<News> gainNewsReadRankStatistics();
}