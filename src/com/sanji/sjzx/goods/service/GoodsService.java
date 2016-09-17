package com.sanji.sjzx.goods.service;

import java.util.List;

import com.sanji.sjzx.model.Goods;
import com.sanji.sjzx.model.GoodsSku;
import com.sanji.sjzx.pojo.DataGrid;

/**
 * @ClassName:GoodsService
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author yangningning
 * @date 2014-10-13下午2:21:58
 */
public interface GoodsService {
	/**
	 * 获取商品列表
	 * @Title:gainGoodsList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param goods
	 * @param @return 设定文件
	 * @return DataGrid 返回类型
	 * @throws
	 * @param goods
	 * @return
	 */
	public DataGrid gainGoodsList(Goods goods);
	/**
	 * 获取适用机型列表
	 * @Title:gainApplicationModelList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param goods
	 * @param @return 设定文件
	 * @return DataGrid 返回类型
	 * @throws
	 * @param goods
	 * @return
	 */
	public DataGrid gainApplicationModelList(Goods goods);
	/**
	 * 获取回收站列表
	 * @Title:gainRecycleList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param goods
	 * @param @return 设定文件
	 * @return DataGrid 返回类型
	 * @throws
	 * @param goods
	 * @return
	 */
	public DataGrid gainRecycleList(Goods goods);
	/**
	 * 获取商品品牌
	 * @Title:gaingainGoodsBrandName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<Brand> 返回类型
	 * @throws
	 * @return
	 */
	public List<Goods> gainGoodsBrandName();
	/**
	 * 获取商品类别
	 * @Title:gainGoodsCatName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<Goods> 返回类型
	 * @throws
	 * @return
	 */
	public List<Goods> gainGoodsCatName();
	/**
	 * 根据id获取商品信息
	 * @Title:gainAll
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<Goods> 返回类型
	 * @throws
	 * @return
	 */
	public Goods gainAll(String id);
	/**
	 * 添加商品信息
	 * @Title:addGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param goods 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param goods
	 */
	public void addGoods(Goods goods,List<GoodsSku> goodsSkus);
	//public void addGoods(Goods goods);
	/**
	 * 查询时根据goodsNum查询是否存在该goods
	 * @Title:gainGoodsByGoodsNum
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param goodsNum
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 * @param goodsNum
	 * @return
	 */
	public boolean gainGoodsByGoodsNum(String goodsNum);
	/**
	 * 添加时根据商品名称进行查询是否存在该goods
	 * @Title:gainGoodsByName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param name
	 * @param @return 设定文件
	 * @return List<Goods> 返回类型
	 * @throws
	 * @param name
	 * @return
	 */
	public boolean gainGoodsByName(String name);

	/**
	 * 修改商品信息
	 * @Title:updateGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param goods
	 * @param @param goodsSkus 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param goods
	 * @param goodsSkus
	 */
	public void updateGoods(Goods goods,List<GoodsSku> goodsSkus);
	public void updateGoodsById(Goods goods);
	/**
	 * 修改时根据商品名称和id进行查询是否存在该goods
	 * @Title:gainGoodsByNameandId
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @param name
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean gainGoodsByNameandId(String id,String name);	
	
	/**
	 * 修改时根据商品编号和id进行查询是否存在该goods
	 * @Title:gainGoodsByNumandId
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @param goodsNum
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 * @param id
	 * @param goodsNum
	 * @return
	 */
	public boolean gainGoodsByNumandId(String id,String goodsNum);
	/**
	 * 逻辑删除商品信息
	 * @Title:deleteGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param id
	 */
	//public void deleteGoods(List<String> ids);
	public void deleteGoodsandSku(List<String> ids,List<GoodsSku> list);
	/**
	 * 恢复删除到回收站的商品
	 * @Title:recoverGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param ids 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param ids
	 */
	//public void recoverGoods(List<String> ids);
	public void recoverGoodsandSku(List<String> ids,List<GoodsSku> recycleList);
    /**
     * 物理删除商品信息
     * @Title:dropGoods
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param ids 设定文件
     * @return void 返回类型
     * @throws
     * @param ids
     */
    public void dropGoods(List<String> ids,List<String> idss,List<String> giftIdss);
    
    /**
     * 根据配件id获取适用机型信息
     * @Title:gainGoodsByAppModelId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param id
     * @param @return 设定文件
     * @return List<Goods> 返回类型
     * @throws
     * @param id
     * @return
     */
    public List<Goods> gainGoodsByAccId(String accId);
    /**
     * 批量修改单品价格库存数据
     * @Title:updatePriceandStock
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param skus 设定文件
     * @return void 返回类型
     * @throws
     * @param skus
     */
    public void updatePriceandStockList(List<GoodsSku> skus);
    /**
     * 根据goodsId获取宝贝仓库中具体某个商品的信息
     * @Title:gainRecycleGoodsandSku
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param id
     * @param @return 设定文件
     * @return Goods 返回类型
     * @throws
     * @param id
     * @return
     */
    public Goods gainRecycleGoodsandSku(String id);
    
    /**
	 * 取消单品为电商热销
	* @Title: danGoodsById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param ids    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void danGoodsById(List<String> ids);
	/**
	 * 设置单品为电商热销
	* @Title: openGoodsById
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param ids    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
	public void openGoodsById(List<String> ids);
}
