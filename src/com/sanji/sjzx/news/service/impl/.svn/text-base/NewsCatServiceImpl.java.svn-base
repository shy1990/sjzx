package com.sanji.sjzx.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.model.NewsCat;
import com.sanji.sjzx.news.dao.NewsCatMapper;
import com.sanji.sjzx.news.service.NewsCatService;


/**
 * @ClassName: NewsCatServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Huifeng Wang
 * @date 2013-5-17 下午3:17:45
 *
 */
@Service("newsCatService")
@Transactional(rollbackFor=Exception.class)
public class NewsCatServiceImpl implements NewsCatService{
	
	@Autowired
	private NewsCatMapper newsCatMapper;
	

	/* (非 Javadoc)
	* <p>Title: gainNewsCatById</p>
	* <p>Description: </p>
	* @param id
	* @return
	* @see com.gx.news.service.NewsCatService#gainNewsCatById(java.lang.String)
	*/
	public NewsCat gainNewsCatById(String id) {
		return newsCatMapper.gainNewsCatById(id);
	}

	/* (非 Javadoc)
	* <p>Title: addNewsCat</p>
	* <p>Description: </p>
	* @param newsCat
	* @see com.gx.news.service.NewsCatService#addNewsCat(com.gx.model.NewsCat)
	*/
	public void addNewsCat(NewsCat newsCat) {
		newsCatMapper.addNewsCat(newsCat);
	}

	/* (非 Javadoc)
	* <p>Title: updateNewsCat</p>
	* <p>Description: </p>
	* @param newsCat
	* @see com.gx.news.service.NewsCatService#updateNewsCat(com.gx.model.NewsCat)
	*/
	public void updateNewsCat(NewsCat newsCat) {
		newsCatMapper.updateNewsCat(newsCat);
	}

	/* (非 Javadoc)
	* <p>Title: gainAllCount</p>
	* <p>Description: </p>
	* @param newsCat
	* @return
	* @see com.gx.news.service.NewsCatService#gainAllCount(com.gx.model.NewsCat)
	*/
	public Long gainAllCount(NewsCat newsCat) {
		// TODO Auto-generated method stub
		return newsCatMapper.gainAllCount(newsCat);
	}

	/* (非 Javadoc)
	* <p>Title: gainAll</p>
	* <p>Description: </p>
	* @param newsCat
	* @return
	* @see com.gx.news.service.NewsCatService#gainAll(com.gx.model.NewsCat)
	*/
	public List<NewsCat> gainAll(NewsCat newsCat) {
		// TODO Auto-generated method stub
		return newsCatMapper.gainAll(newsCat);
	}

	/* (非 Javadoc)
	* <p>Title: drop</p>
	* <p>Description: </p>
	* @param newsCat
	* @see com.gx.news.service.NewsCatService#drop(com.gx.model.NewsCat)
	*/
	public void drop(NewsCat newsCat) {
		// TODO Auto-generated method stub
		newsCatMapper.drop(newsCat);
	}

	/* (非 Javadoc)
	* <p>Title: gainNewsCatChildByPid</p>
	* <p>Description: </p>
	* @param id
	* @return
	* @see com.gx.news.service.NewsCatService#gainNewsCatChildByPid(java.lang.String)
	*/
	public Long gainNewsCatChildByPid(String id) {
		// TODO Auto-generated method stub
		return newsCatMapper.gainNewsCatChildByPid(id);
	}

	/* (非 Javadoc)
	* <p>Title: gainNewsCatByPtree</p>
	* <p>Description: </p>
	* @param ptree
	* @return
	* @see com.gx.news.service.NewsCatService#gainNewsCatByPtree(java.lang.String)
	*/
	public List<NewsCat> gainNewsCatByPtree(String ptree) {
		// TODO Auto-generated method stub
		return newsCatMapper.gainNewsCatByPtree(ptree);
	}

	/* (非 Javadoc)
	* <p>Title: gainSecondNewsCatByFirstId</p>
	* <p>Description: </p>
	* @param parameter
	* @return
	* @see com.gx.news.service.NewsCatService#gainSecondNewsCatByFirstId(java.lang.String)
	*/
	public List<NewsCat> gainSecondNewsCatByFirstId(String id) {
		// TODO Auto-generated method stub
		return newsCatMapper.gainSecondNewsCatByFirstId(id);
	}

	/* (非 Javadoc)
	* <p>Title: gainFirstNewsCat</p>
	* <p>Description: </p>
	* @param newsCat
	* @return
	* @see com.gx.news.service.NewsCatService#gainFirstNewsCat(com.gx.model.NewsCat)
	*/
	public List<NewsCat> gainFirstNewsCat(NewsCat newsCat) {
		// TODO Auto-generated method stub
		return newsCatMapper.gainFirstNewsCat(newsCat);
	}

}
