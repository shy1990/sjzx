package com.sanji.sjzx.color.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.color.dao.ColorMapper;
import com.sanji.sjzx.color.service.ColorService;
import com.sanji.sjzx.model.Color;
import com.sanji.sjzx.pojo.DataGrid;
/**
 * @ClassName: ColorServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author SongBaozhen
 * @date 2014-9-6 下午15:11
 */
@Service("colorService")
@Transactional(rollbackFor = Exception.class)
public class ColorServiceImpl implements ColorService {

	@Resource
	private ColorMapper colorMapper;

	/**
	 * (non-Javadoc)
	 * @Title:gainColorList
	 * @Description: TODO(获取颜色列表)
	 * @param color
	 * @return DataGrid
	 */
	public DataGrid gainColorList(Color color) {
		DataGrid j = new DataGrid();
		j.setRows( colorMapper.gainColorList(color));
		j.setTotal(colorMapper.gainColorCount(color));
		return j;
	}

	/**
	 * (non-Javadoc)
	 * @Title:gainIsExistName
	 * @Description: TODO(根据名称和id判断该颜色是否存在)
	 * @param color
	 * @return boolean
	 */
	public boolean gainIsExistName(String colorName, BigDecimal id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("colorName", colorName);
		map.put("id", id);
		Long cnum = colorMapper.gainColorByMap(map);
		if(cnum >= 1){
			return false;
		} 
		return true;
	}
	/**
	 * (non-Javadoc)
	 * @Title:addColor
	 * @Description: TODO(添加颜色)
	 * @param color
	 * @return void
	 */
	public void addColor(Color color) {
		colorMapper.insert(color);
	}
	/**
	 * (non-Javadoc)
	 * @Title:modifyColor
	 * @Description: TODO(修改颜色)
	 * @param color
	 * @return void
	 */
	public void modifyColor(Color color) {
		colorMapper.modifyColor(color);
		
	}
	/**
	 * (non-Javadoc)
	 * @Title:deleteColorById
	 * @Description: TODO(根据id删除该颜色)
	 * @param ids
	 * @return void
	 */
	public void deleteColorById(List<String> ids) {
		colorMapper.deleteByIds(ids);
		
	}
	/**
	 * (non-Javadoc)
	 * @Title:existColorIsused
	 * @Description: TODO(根据id验证该颜色是否正在使用)
	 * @param ids
	 * @return boolean
	 */
	public boolean existColorIsused(List<String> ids) {
		 List<Color> clist =  colorMapper.gainColorByIds(ids);
		 if(clist !=null && clist.size()>0){
			 return false;
		 }
		 return true;
	}
	/**
	 * (non-Javadoc)
	 * @Title:gainAllColors
	 * @Description: TODO(获取所有颜色)
	 * @param ids
	 * @return boolean
	 */
	public List<Color> gainAllColors(Color color) {
		 List<Color> clist =  colorMapper.gainAllColors(color);
		 if(clist !=null && clist.size()>0){
			 return clist;
		 }
		 return null;
	}
}
