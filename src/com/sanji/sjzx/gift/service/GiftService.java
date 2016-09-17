package com.sanji.sjzx.gift.service;

import java.util.List;

import com.sanji.sjzx.model.Gift;

/**
 * @ClassName:GiftService
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author yangningning
 * @date 2014-10-17上午9:10:37
 */
public interface GiftService {

	/**
	 * 批量添加赠品
	 * @Title:addGiftList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param list 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param list
	 */
	public void addGiftList(List<Gift> giftList);
	
	/**
	 * 单条添加赠品
	 * @Title:addGift
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param gift 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param gift
	 */
	public void addGift(Gift gift);
	
	/**
	 * 根据goodsId查询该商品关联的所有的赠品
	 * @Title:gainGiftList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param goodsId
	 * @param @return 设定文件
	 * @return List<Gift> 返回类型
	 * @throws
	 * @param goodsId
	 * @return
	 */
	public List<Gift> gainGiftList(String goodsId);
	
	/**
	 * 修改赠品信息
	 * @Title:updateGift
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param gift 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param gift
	 */
	public void updateGift(Gift gift);
	
	/**
	 * 删除已选的赠品
	 * @Title:dropGift
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param gift 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param gift
	 */
	public void dropGift(String id);
	
	/**
	 * 删除商品时，批量删除该商品下的赠品
	 * @Title:dropGifts
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param idss 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param idss
	 */
	public void dropGifts(List<String> goodsIds);
    /**
     * 根据giftId查询是否存在该gift
     * @Title:gainGiftByGiftId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param giftId
     * @param @return 设定文件
     * @return List<Gift> 返回类型
     * @throws
     * @param giftId
     * @return
     */
    public List<Gift> gainGiftByGiftId(String goodsId,String giftId);
}
