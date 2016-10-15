package com.sanji.sjzx.pic.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.model.GoodsPic;
import com.sanji.sjzx.pic.dao.PicMapper;
import com.sanji.sjzx.pic.service.PicService;

@Service("picService")
@Transactional(rollbackFor=Exception.class)
public class PicServiceImpl implements PicService {
	@Resource
	private PicMapper picMapper;
	/**
	 * 根据单品id查询图片
	 */
/*	public List<GoodsPic> gainPic(Map<String, String> paramMap) {
		return picMapper.gainPic(paramMap);
	}*/
	public List<GoodsPic> gainPic(String skuId){
		return picMapper.gainPic(skuId);
	}
	/**
	 * 添加图片
	 */
	public void addPic(GoodsPic pic) {
		picMapper.addPic(pic);
	}
	/**
	 * 修改图片
	 */
	public void updatePic(GoodsPic pic) {
		picMapper.updatePic(pic);
	}
	/**
	 * 根据商品id删除该商品下的所有图片
	 */
	public void DropPic(String goodsId) {
		picMapper.DropPic(goodsId);
	}
	/**
	 * 根据商品id获取图片信息
	 */
	public List<GoodsPic> gainPicByGoodsId(String goodsId) {
		return picMapper.gainPicByGoodsId(goodsId);
	}

}
