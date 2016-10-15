package com.sanji.sjzx.goods.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.annotation.SystemServiceLog;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.gift.dao.GiftMapper;
import com.sanji.sjzx.goods.dao.GoodsMapper;
import com.sanji.sjzx.goods.service.GoodsService;
import com.sanji.sjzx.goodssku.dao.GoodsskuMapper;
import com.sanji.sjzx.model.Goods;
import com.sanji.sjzx.model.GoodsSku;
import com.sanji.sjzx.pojo.DataGrid;

@Service("goodsService")
@Transactional(rollbackFor=Exception.class)
public class GoodsServiceImpl implements GoodsService {
	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private GoodsskuMapper skuMapper;
	@Resource
	private GiftMapper giftMapper;	

	/**
	 * 获取商品列表
	 */
	public DataGrid gainGoodsList(Goods goods) {
		DataGrid j = new DataGrid();
		j.setRows(goodsMapper.gainGoodsList(goods));
		j.setTotal(goodsMapper.gainGoodsCount(goods));
		return j;	
	}
	/**
	 * 适用机型列表
	 */
	public DataGrid gainApplicationModelList(Goods goods){
		DataGrid j = new DataGrid();
		j.setRows(goodsMapper.gainApplicationModelList(goods));
		j.setTotal(goodsMapper.gainGoodsCount(goods));
		return j;
	}
	/**
	 * 获取回收站列表
	 */
	public DataGrid gainRecycleList(Goods goods) {
		DataGrid j = new DataGrid();
		j.setRows(goodsMapper.gainRecycleList(goods));
		j.setTotal(goodsMapper.gainRecycleCount(goods));
		return j;	
	}

	/**
	 * 获取商品品牌
	 */
	public List<Goods> gainGoodsBrandName() {
		return goodsMapper.gainGoodsBrandName();
	}
	/**
	 * 获取商品类别
	 */
	public List<Goods> gainGoodsCatName() {
		return goodsMapper.gainGoodsCatName();
	}
	/**
	 * 根据id获取商品信息
	 */
	public Goods gainAll(String id) {
		return goodsMapper.gainAll(id);
	}

	/**
	 * 添加goods信息
	 */
	public void addGoods(Goods goods,List<GoodsSku> goodsSkus) {
		goodsMapper.addGoods(goods);
		skuMapper.addGoodsSkuList(goodsSkus);
	}
//	public void addGoods(Goods goods){
//		goodsMapper.addGoods(goods);
//	}
	/**
	 * 添加时根据goodsNum查询是否存在此goods
	 */
	public boolean gainGoodsByGoodsNum(String goodsNum) {
		List<Goods> list = goodsMapper.gainGoodsByGoodsNum(goodsNum);
		if(list !=null && list.size()>0){
			return false;
		}else{
			return true;
		}	
	}

	/**
	 * 添加时根据name查询是否存在此goods
	 */
	public boolean gainGoodsByName(String name) {
		List<Goods> list = goodsMapper.gainGoodsByName(name);
		if(list !=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 修改商品信息
	 */
	@SystemServiceLog(description = "修改商品")
	public void updateGoods(Goods goods,List<GoodsSku> list) {
		goodsMapper.updateGoods(goods);
		for (GoodsSku goodsSku : list) {
			if (null != goodsSku && !"".equals(goodsSku.getId())) {
				skuMapper.updateGoodsSku(goodsSku);
			}else {
				goodsSku.setId(ToolsUtil.getUUID());
				skuMapper.addGoodsSku(goodsSku);
			}
		}
	}
	public void updateGoodsById(Goods goods){
		goodsMapper.updateGoodsById(goods);
	}
	/**
	 * 修改时根据name和id查询是否存在此goods
	 */
	public boolean gainGoodsByNameandId(String id, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		List<Goods> list = goodsMapper.gainGoodsByNameandId(map);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 修改时根据num和id查询是否存在此goods
	 */
	public boolean gainGoodsByNumandId(String id, String goodsNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("goodsNum", goodsNum);
		List<Goods> list = goodsMapper.gainGoodsByNumandId(map);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 逻辑删除商品信息
	 */
//	public void deleteGoods(List<String> ids) {
//		goodsMapper.deleteGoods(ids);
//		
//	}
	public void deleteGoodsandSku(List<String> ids,List<GoodsSku> list){
		goodsMapper.deleteGoods(ids);
		//单条修改单品下架添加下架时间
		for(GoodsSku goodsSku:list){
			if (null != goodsSku && !"".equals(goodsSku.getId())) {
				skuMapper.updateShelves(goodsSku);
			}
		}	
	}
	
	/**
	 * 恢复删除到回收站的商品信息
	 */
//	public void recoverGoods(List<String> ids) {
//		goodsMapper.recoverGoods(ids);
//	}
	public void recoverGoodsandSku(List<String> ids,List<GoodsSku> recycleList){
		goodsMapper.recoverGoods(ids);
		for(GoodsSku sku:recycleList){
			if(null != sku && !"".equals(sku.getId())){
				skuMapper.recycleSheleves(sku);
			}
		}
	}

	/**
	 * 物理删除商品信息
	 */
	public void dropGoods(List<String> ids,List<String> idss,List<String> giftIdss) {
		goodsMapper.dropGoods(ids);
		skuMapper.dropGoodsSku(idss);
		giftMapper.dropGifts(giftIdss);
	}
	/**
	 * 根据配件id获取适用机型信息
	 */
	public List<Goods> gainGoodsByAccId(String accId) {
		return goodsMapper.gainGoodsByAccId(accId);
	}
	/**
	 * 单条修改单品价格库存
	 */
	@SystemServiceLog(description = "修改单品价格")
	public void updatePriceandStockList(List<GoodsSku> list) {
		for (GoodsSku goodsSku : list) {
			if (null != goodsSku && !"".equals(goodsSku.getId())) {
				skuMapper.updateSkuPriceandStock(goodsSku);
			}
		}
	}
	/**
	 * 根据goodsId获取宝贝仓库中某个商品的信息
	 */
	public Goods gainRecycleGoodsandSku(String id) {
		return goodsMapper.gainRecycleGoodsandSku(id);
	}

	
	/**
	 * 取消单品为电商热销
	 */
	public void danGoodsById(List<String> ids) {
		// TODO Auto-generated method stub
		goodsMapper.danGoodsById(ids);
	}
	/**
	 * 设置单品为电商热销
	 */
	public void openGoodsById(List<String> ids) {
		// TODO Auto-generated method stub
		goodsMapper.openGoodsById(ids);
	}
}
