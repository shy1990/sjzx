package com.sanji.sjzx.pic.service;

import java.util.List;

import com.sanji.sjzx.model.GoodsPic;

public interface PicService {
	
	/**
	 * 根据商品id和单品id获取图片
	 * @Title:gainPic
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param goodsId
	 * @param @param skuId
	 * @param @return 设定文件
	 * @return List<GoodsPic> 返回类型
	 * @throws
	 * @param goodsId
	 * @param skuId
	 * @return
	 */
	//public List<GoodsPic> gainPic(Map<String, String> paramMap);
	public List<GoodsPic> gainPic(String skuId);
	/**
	 * 添加图片
	 * @Title:addPic
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param pic 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param pic
	 */
	public void addPic(GoodsPic pic) ;

	/**
	 * 修改图片
	 * @Title:updatePic
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param pic 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param pic
	 */
	public void updatePic(GoodsPic pic);
    /**
     * 根据商品id删除该商品下的所有图片
     * @Title:DropPic
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goodsId 设定文件
     * @return void 返回类型
     * @throws
     * @param goodsId
     */
    public void DropPic(String goodsId);
    
    /**
     * 根据商品id获取图片信息
     * @Title:gainPicByGoodsId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goodsId
     * @param @return 设定文件
     * @return List<GoodsPic> 返回类型
     * @throws
     * @param goodsId
     * @return
     */
    public List<GoodsPic> gainPicByGoodsId(String goodsId);
}

