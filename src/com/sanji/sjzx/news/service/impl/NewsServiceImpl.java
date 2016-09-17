package com.sanji.sjzx.news.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.common.util.FtpUtil;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.model.News;
import com.sanji.sjzx.news.dao.NewsMapper;
import com.sanji.sjzx.news.service.NewsService;



/**
 * @ClassName: NewsServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Huifeng Wang
 * @date 2013-5-7 下午1:07:35
 *
 */
@Service("newsService")
@Transactional(rollbackFor=Exception.class)
public class NewsServiceImpl implements NewsService{

	@Autowired
	private NewsMapper newsMapper;

	/**
	* @Title: gainAll
	* @Description: TODO获取所有发布的新闻信息
	* @param @param news
	* @param @return    设定文件
	* @return List<News>    返回类型
	*/
	public List<News> gainAll(News news) {
		// TODO Auto-generated method stub
		return newsMapper.gainAll(news);
	}

	/**
	* @Title: gainAllCount
	* @Description: TODO获得数量
	* @param @param news
	* @param @return    设定文件
	* @return Long    返回类型
	*/
	public Long gainAllCount(News news) {
		// TODO Auto-generated method stub
		return newsMapper.gainAllCount(news);
	}

	/* (非 Javadoc)
	* <p>Title: add</p>
	* <p>Description: </p>
	* @param news
	* @see com.gx.news.service.NewsService#add(com.gx.model.News)
	*/
	public void addNews(News news) {
		if("焦点".equals(news.getNewsattr())){
			newsMapper.updateNewsByProperty(news);//更新其他新闻,保证每个分类只有一个焦点新闻
		}
		newsMapper.addNews(news);
	}

	/* (非 Javadoc)
	* <p>Title: updateNews</p>
	* <p>Description: </p>
	* @param news
	* @see com.gx.news.service.NewsService#updateNews(com.gx.model.News)
	*/
	public void updateNews(News news) {
		if("焦点".equals(news.getNewsattr())){
			newsMapper.updateNewsByProperty(news);//更新其他新闻,保证每个分类只有一个焦点新闻
		}
		newsMapper.updateNews(news);
	}

	public Long gainNewsCountByNewsCatId(String id){
		return newsMapper.gainNewsCountByNewsCatId(id);
	}

	/* (非 Javadoc)
	* <p>Title: delete</p>
	* <p>Description: </p>
	* @param stringConvertList
	* @see com.gx.news.service.NewsService#delete(java.util.List)
	*/
	public void delete(List<String> stringConvertList) {
		newsMapper.delete(stringConvertList);
	}

	/* (非 Javadoc)
	* <p>Title: recover</p>
	* <p>Description: </p>
	* @param stringConvertList
	* @see com.gx.news.service.NewsService#recover(java.util.List)
	*/
	public void recover(List<String> stringConvertList) {
		newsMapper.recover(stringConvertList);
	}

	/* (非 Javadoc)
	* <p>Title: drop</p>
	* <p>Description: </p>
	* @param stringConvertList
	* @see com.gx.news.service.NewsService#drop(java.util.List)
	*/
	public void drop(List<String> stringConvertList) {
		newsMapper.drop(stringConvertList);
	}

	/* (非 Javadoc)
	* <p>Title: gainNewsById</p>
	* <p>Description: </p>
	* @param id
	* @return
	* @see com.gx.news.service.NewsService#gainNewsById(java.lang.String)
	*/
	public News gainNewsById(String id) {
		return newsMapper.gainNewsById(id);
	}

	/* (非 Javadoc)
	* <p>Title: upload</p>
	* <p>Description: </p>
	* @param map
	* @return
	* @see com.gx.news.service.NewsService#upload(java.util.Map)
	*/
	public Map<String, Object> upload(Map<String, Object> map) throws Exception {
		FtpUtil ftp= new FtpUtil(ResourceUtil.getFtpIp(), ResourceUtil.getFtpUserName(), ResourceUtil.getFtpPassword());
		ftp.connectServer();
		String savePath=String.valueOf(map.get("savePath"));
		if(!ftp.isDirExist(savePath)){
			ftp.createDir(savePath);
		}
		ftp.cd(savePath);
		ftp.uploadFile(String.valueOf(map.get("path")), String.valueOf(map.get("fileName")));
		ftp.closeServer();
		return null;
	}

}
