package com.sanji.sjzx.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.model.NewsCatType;
import com.sanji.sjzx.news.dao.NewsCatTypeMapper;
import com.sanji.sjzx.news.service.NewsCatTypeService;



/**
 * @ClassName: NewsCatTypeServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Huifeng Wang
 * @date 2013-5-11 上午10:13:49
 *
 */
@Service("newsCatTypeService")
@Transactional(rollbackFor=Exception.class)
public class NewsCatTypeServiceImpl implements NewsCatTypeService{

	@Autowired
	private NewsCatTypeMapper newsCatTypeMapper;
	public List<NewsCatType> gainAllList(NewsCatType newsCatType) {
		// TODO Auto-generated method stub
		return newsCatTypeMapper.gainAllList(newsCatType);
	}
	/* (非 Javadoc)
	* <p>Title: gainAllCount</p>
	* <p>Description: </p>
	* @param newsCatType
	* @return
	* @see com.gx.news.service.NewsCatTypeService#gainAllCount(com.gx.model.NewsCatType)
	*/
	public Long gainAllCount(NewsCatType newsCatType) {
		// TODO Auto-generated method stub
		return newsCatTypeMapper.gainAllCount(newsCatType);
	}
	/* (非 Javadoc)
	* <p>Title: add</p>
	* <p>Description: </p>
	* @param newsCatType
	* @see com.gx.news.service.NewsCatTypeService#add(com.gx.model.NewsCatType)
	*/
	public void add(NewsCatType newsCatType) {
		newsCatTypeMapper.add(newsCatType);
	}
	/* (非 Javadoc)
	* <p>Title: update</p>
	* <p>Description: </p>
	* @param newsCatType
	* @see com.gx.news.service.NewsCatTypeService#update(com.gx.model.NewsCatType)
	*/
	public void update(NewsCatType newsCatType) {
		newsCatTypeMapper.update(newsCatType);
	}
	/* (非 Javadoc)
	* <p>Title: drop</p>
	* <p>Description: </p>
	* @param newsCatType
	* @see com.gx.news.service.NewsCatTypeService#drop(com.gx.model.NewsCatType)
	*/
	public void drop(String id) {
		newsCatTypeMapper.drop(id);
	}
	/* (非 Javadoc)
	* <p>Title: gainNewsCatTypeById</p>
	* <p>Description: </p>
	* @param parameter
	* @see com.gx.news.service.NewsCatTypeService#gainNewsCatTypeById(java.lang.String)
	*/
	public NewsCatType gainNewsCatTypeById(String parameter) {
		return newsCatTypeMapper.gainNewsCatTypeById(parameter);
	}
	/* (非 Javadoc)
	* <p>Title: gainAllList</p>
	* <p>Description: </p>
	* @param newsCatType
	* @return
	* @see com.gx.news.service.NewsCatTypeService#gainAllList(com.gx.model.NewsCatType)
	*/
	public List<NewsCatType> gainAll(NewsCatType newsCatType) {
		// TODO Auto-generated method stub
		return  newsCatTypeMapper.gainAll(newsCatType);
	}

}
