package com.sanji.sjzx.label.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.label.dao.LabelMapper;
import com.sanji.sjzx.label.service.LabelService;
import com.sanji.sjzx.model.Label;
import com.sanji.sjzx.pojo.DataGrid;
/**
 * @ClassName: LabelServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZhouZhangbao
 * @date 2014-9-6 下午15:11
 */
@Service("labelService")
@Transactional(rollbackFor=Exception.class)
public class LabelServiceImpl implements LabelService {
	@Resource
	private LabelMapper labelMapper;
	
	
	
	/**
	 * (non-Javadoc)
	 * @Title:gainLabelList
	 * @Description: TODO(获取标签列表)
	 * @param label
	 * @return DataGrid
	 */

	public DataGrid gainLabelList(Label label) {
		DataGrid j = new DataGrid();
		j.setRows( labelMapper.gainLabelList(label));
		j.setTotal(labelMapper.gainLabelCount(label));
		return j;
	}
	
	/**
	 * (non-Javadoc)
	 * @Title:gainIsExistName
	 * @Description: TODO(验证标签名)
	 * @param name,id
	 * @return boolean
	 */
	public boolean gainIsExistName(String name, String id) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id",id);
		Long lnum = (Long)labelMapper.gainLabelByMap(map);
		if(lnum >= 1){
			return false;
		}
		return true;
	}
	/**
	 * (non-Javadoc)
	 * @Title:addLable
	 * @Description: TODO(添加标签)
	 * @param label
	 * @return void
	 */
	public void addLabel(Label label) {

		labelMapper.insertSelective(label);
	}
	/**
	 * (non-Javadoc)
	 * @Title:modifylabel
	 * @Description: TODO(修改编辑标签)
	 * @param label
	 * @return void
	 */

	public void modifylabel(Label label) {
		labelMapper.modifylabel(label);
		
	}
	/**
	 * (non-Javadoc)
	 * @Title:droplabelById
	 * @Description: TODO(根据主键删除单条或批量删除标签(物理删除))
	 * @param ids
	 * @return void
	 */
	public void droplabelById(List<String> ids) {
		labelMapper.dropLabelByIds(ids);
		
	}
	

}
