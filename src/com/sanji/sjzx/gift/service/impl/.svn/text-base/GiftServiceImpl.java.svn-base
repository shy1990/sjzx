package com.sanji.sjzx.gift.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.gift.dao.GiftMapper;
import com.sanji.sjzx.gift.service.GiftService;
import com.sanji.sjzx.model.Gift;

@Service("giftService")
@Transactional(rollbackFor=Exception.class)
public class GiftServiceImpl implements GiftService {
	@Resource
	private GiftMapper giftMapper;

	public GiftMapper getGiftMapper() {
		return giftMapper;
	}

	public void setGiftMapper(GiftMapper giftMapper) {
		this.giftMapper = giftMapper;
	}
	/**
	 * 批量添加赠品
	 */
	public void addGiftList(List<Gift> giftList) {
		giftMapper.addGiftList(giftList);
	}
	/**
	 * 单条添加赠品
	 */
	public void addGift(Gift gift){
		giftMapper.addGift(gift);
	}
	/**
	 * 根据goodsId查询该商品关联的所有赠品
	 */
	public List<Gift> gainGiftList(String goodsId) {
		return giftMapper.gainGiftList(goodsId);
	}
	/**
	 * 修改赠品信息
	 */
	public void updateGift(Gift gift) {
		giftMapper.updateGift(gift);
	}
	/**
	 * 修改时删除已选的赠品
	 */
	public void dropGift(String id) {
		giftMapper.dropGift(id);
	}
	/**
	 * 删除上商品时，批量删除该商品下的赠品
	 */
	public void dropGifts(List<String> goodsIds) {
		giftMapper.dropGifts(goodsIds);		
	}
	/**
	 * 根据giftId查询是否存在此gift
	 */
	public List<Gift> gainGiftByGiftId(String goodsId,String giftId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("goodsId", goodsId);
		map.put("giftId", giftId);
		return giftMapper.gainGiftByGiftId(map);
	}
	
}
