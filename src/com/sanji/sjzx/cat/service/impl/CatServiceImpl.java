package com.sanji.sjzx.cat.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.cat.dao.CatMapper;
import com.sanji.sjzx.cat.service.CatService;
import com.sanji.sjzx.goods.dao.GoodsMapper;
import com.sanji.sjzx.model.Cat;
import com.sanji.sjzx.model.Goods;
import com.sanji.sjzx.pojo.DataGrid;
@Service("catService")
@Transactional(rollbackFor=Exception.class)

public class CatServiceImpl implements CatService {
	@Resource
	private CatMapper catMapper;
	@Resource
	private GoodsMapper goodsMapper;
	public CatMapper getCatMapper() {
		return catMapper;
	}

	public void setCatMapper(CatMapper catMapper) {
		this.catMapper = catMapper;
	}
	/**
	 * 获取分类分页列表
	 */
	public DataGrid gainCatList(Cat cat) {
		DataGrid j = new DataGrid();
		j.setRows(catMapper.gainCatList(cat));
		j.setTotal(catMapper.gainCatCount(cat));
		return j;
	}
	/**
	 * 添加分类信息
	 */
	public void addCat(Cat cat) {
		catMapper.addCat(cat);
	}
	/**
	 * 添加时根据name进行查询是否存在该cat
	 */
	public boolean gainCatByName(String name) {
		List<Cat> list = catMapper.gainCatByName(name);
		if(list!=null &&list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 修改分类信息
	 */
	public void updateCat(Cat cat) {
		catMapper.updateCat(cat);
	}
	/**
	 * 查询时根据id和name进行查询是否存在该cat
	 */
	public boolean gainCatByNameandId(String id, String name) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("name", name);
		List<Cat> list = catMapper.gainCatByNameandId(map);
		if(list!=null&&list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 删除相应id的记录
	 */
	public void dropCat(List<String> ids) {
		catMapper.dropCat(ids);
	}
	/**
	 * 根据类别id获取类别信息（用于类别管理中删除类别时判断该类别是否关联商品）
	 */
	public boolean gainGoodsByCatId(String catId) {
		List<Goods> list = goodsMapper.gainGoodsByCatId(catId);
		if(list!=null && list.size()>0){//存在
			return false;
		}else {
			return true;
		}
	}

}
