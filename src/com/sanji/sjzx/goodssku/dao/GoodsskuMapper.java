package com.sanji.sjzx.goodssku.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.Goods;
import com.sanji.sjzx.model.GoodsSku;

/**
 * @ClassName:goodsskuMapper
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author yangningning
 * @date 2014-10-16上午11:32:31
 */
public interface GoodsskuMapper {
	
	/**
	 * 根据商品编号查询该商品所有的单品
	 * @Title:gainSkuByGoodsId
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param goodsId
	 * @param @return 设定文件
	 * @return List<GoodsSku> 返回类型
	 * @throws
	 * @param goodsId
	 * @return
	 */
	public List<GoodsSku> gainSkuByGoodsId(String goodsId);
    /**
     * 获取所有颜色名称
	 * @Title:GainSkuColorName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<GoodsSku> 返回类型
	 * @throws
	 * @return
	 */
	public List<GoodsSku> gainSkuColorName();    
    /**
     * 批量添加单品信息
     * @Title:addGoodsSku
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param skuList 设定文件
     * @return void 返回类型
     * @throws
     * @param skuList
     */
    public void addGoodsSkuList(List<GoodsSku> list);
    /**
     * 添加单条信息
     * @Title:addGoodsSku
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goodsSku 设定文件
     * @return void 返回类型
     * @throws
     * @param goodsSku
     */
    public void addGoodsSku(GoodsSku goodsSku);
    /**
     * 添加时根据skuCode查询是否存在该单品
     * @Title:gainSkuBySkuCode
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param skuCode 设定文件
     * @return void 返回类型
     * @throws
     * @param skuCode
     */
    public List<GoodsSku> gainSkuBySkuCode(String skuCode);
    /**
     * 添加时根据skuNum查询是否存在该单品
     * @Title:gainSkuBySkuNum
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param skuNum
     * @param @return 设定文件
     * @return List<GoodsSku> 返回类型
     * @throws
     * @param skuNum
     * @return
     */
    public List<GoodsSku> gainSkuBySkuNum(String skuNum);
    /**
     * 批量修改单品信息
     * @Title:updateGoodsSku
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param sku 设定文件
     * @return void 返回类型
     * @throws
     * @param sku
     */
    public void updateGoodsSkuList(List<GoodsSku> goodsSkus);
    
    /**
     * 修改单条单品信息
     * @Title:updateGoodsSku
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goodsSku 设定文件
     * @return void 返回类型
     * @throws
     * @param goodsSku
     */
    public void updateGoodsSku(GoodsSku goodsSku);
    /**
     * 修改时校验商品代码是否存在
     * @Title:gainSkuBySkuCodeandId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param map
     * @param @return 设定文件
     * @return List<GoodsSku> 返回类型
     * @throws
     * @param map
     * @return
     */
    public List<GoodsSku> gainSkuBySkuCodeandId(Map<String, Object> map);
    /**
     * 修改时校验单品编号是否存在
     * @Title:gainSkuBySkuNumandId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param id
     * @param @param skuNum
     * @param @return 设定文件
     * @return List<GoodsSku> 返回类型
     * @throws
     * @param id
     * @param skuNum
     * @return
     */
    public List<GoodsSku> gainSkuBySkuNumandId(Map<String, Object> map);
    
    /**
     * 批量删除单品信息(物理删除)
     * @Title:dropGoodsSku
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param list 设定文件
     * @return void 返回类型
     * @throws
     * @param list
     */
    public void dropGoodsSku(List<String> idss);
    
    /**
     * 单条删除单品信息(物理删除)
     * @Title:dropGoodsSkuById
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param id 设定文件
     * @return void 返回类型
     * @throws
     * @param id
     */
    public void dropGoodsSkuById(String id);
    /**
     * 根据sku编号更新价格、库存
    * @Title: updatePriceByNum
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param goodsSku    设定文件
    * @return void    返回类型
    * @author ZhouZhangbao
     */
    public void updatePriceByNum(GoodsSku goodsSku);
    /**
     * 批量修改单品价格库存数据
     * @Title:updatePriceandStock
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param skus 设定文件
     * @return void 返回类型
     * @throws
     * @param skus
     */
    public void updateSkuPriceandStock(GoodsSku goodsSku);
    /**
     * 向宝贝仓库放商品时，修改为下架添加下架时间
     * @Title:updateShelves
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goodsSku 设定文件
     * @return void 返回类型
     * @throws
     * @param goodsSku
     */
    public void updateShelves(GoodsSku goodsSku);
    /**
     * 根据goodsId获取宝贝仓库中相应的下架的单品记录
     * @Title:gainRecycelSkuByGoodsId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goodsId
     * @param @return 设定文件
     * @return List<GoodsSku> 返回类型
     * @throws
     * @param goodsId
     * @return
     */
    public List<GoodsSku> gainRecycelSkuByGoodsId(String goodsId);
    /**
     * 恢复宝贝仓库中的单品，修改为上架
     * @Title:recycleSheleves
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goodsSku 设定文件
     * @return void 返回类型
     * @throws
     * @param goodsSku
     */
    public void recycleSheleves(GoodsSku goodsSku);

    /**
     * 获取sku库存为零的的单品列表
    * @Title: gainSkuOutOfStockList
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param goodsSku    设定文件
    * @return void    返回类型
    * @author songbaozhen
     */
	public List<GoodsSku> gainSkuOutOfStockList(GoodsSku sku);
	
	/**
     * 获取sku库存为零的的单品总数
    * @Title: gainSkuOutOfStockCount
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param goodsSku    设定文件
    * @return Long    返回类型
    * @author songbaozhen
     */
    public Long gainSkuOutOfStockCount(GoodsSku sku);

    
    /**
     * 根据条件查询SKU用于导出
    * @Title: gainGoosdSKUByExport
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param goods
    * @param @return    设定文件
    * @return List<GoodsSku>    返回类型
    * @author ZhouZhangbao
     */
    public List<GoodsSku> gainGoosdSKUByExport(Goods goods);
    /**
     * 获取sku列表
    * @Title: gianSkuList
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param sku
    * @param @return    设定文件
    * @return List<GoodsSku>    返回类型
    * @author songbaozhen
     */
	public List gainSkuList(GoodsSku sku);
	/**
     * 获取sku列表总行数
    * @Title: gainSkuListCount
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param sku
    * @param @return    设定文件
    * @return lang    返回类型
    * @author songbaozhen
     */
	public Long gainSkuListCount(GoodsSku sku);
	/**
     * 批量更新单品信息
     *  @Title: updateGoodsSkuByIds
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param list 设定文件
     * @return void 返回类型
     * @throws
     * @param list
     */
	public void updateGoodsSkuIsCheckedByIds(List<String> ids);
	/**
     * 批量更新单品信息
     * @Title:updateGoodsSku
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @return void 返回类型
     * @throws
     */
	public void updateGoodsSkuIsChecked();
	/**
     * 根据id 和 skuNum查询单品
     * @Title:updateGoodsSku
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @return void 返回类型
     * @throws
     */
	public GoodsSku gainSkuByIdAndSkuNum(Map<String, String> map);

}