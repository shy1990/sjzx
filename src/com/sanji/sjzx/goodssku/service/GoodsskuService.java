package com.sanji.sjzx.goodssku.service;

import java.io.InputStream;
import java.util.List;

import com.sanji.sjzx.model.Goods;
import com.sanji.sjzx.model.GoodsSku;
import com.sanji.sjzx.pojo.DataGrid;


public interface GoodsskuService {
	
	/**
	 * 根据商品id查询该商品所有的单品信息
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
	 * @Title:addGoodsSkuList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param skuList 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param skuList
	 */
	public void addGoodsSkuList(List<GoodsSku> list);
	/**
	 * 添加单条单品信息
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
    public boolean gainSkuBySkuCode(String skuCode);
	/**
	 * 添加时根据单品skuNum查询是否存在此单品
	 * @Title:gainSkuBySkuNum
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param skuNum
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 * @param skuNum
	 * @return
	 */
	public boolean gainSkuBySkuNum(String skuNum);
	/**
	 * 更新单条单品信息
	 * @Title:updateGoodsSku
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param goodsSku 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param goodsSku
	 */
	public void updateGoodsSku(GoodsSku goodsSku);
	/**
	 * 批量更新单品信息
	 * @Title:updateGoodsSkuList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param list 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param list
	 */
	public void updateGoodsSkuList(List<GoodsSku> goodsSkus);
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
    public boolean gainSkuBySkuCodeandId(String id,String skuCode);
	/**
	 * 修改时根据单品id和skuNum查询是否存在此单品
	 * @Title:gainSkuBySkuNumandId
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @param skuNum
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 * @param id
	 * @param skuNum
	 * @return
	 */
	public boolean gainSkuBySkuNumandId(String id,String skuNum);
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
    public void dropGoodsSkuBySkuId(String id);
	/**
	 * 根据SKU编码更新价格以及库存
	* @Title: updatePriceBySkuNum
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param goodsSku    设定文件
	* @return void    返回类型
	* @author ZhouZhangbao
	 */
	public void updatePriceBySkuNum(GoodsSku goodsSku);
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
     * 想宝贝仓库放商品时，修改为下架添加下架时间
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
     * 获取零库存sku列表
     * @Title:gainSkuOutOfStockList
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goodsSku 设定文件
     * @return DataGrid 返回类型
     * @throws
     * @param goodsSku
     */
    public DataGrid gainSkuOutOfStockList(GoodsSku sku);
    
    InputStream exportDateToExcel(List<?> list);
    
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
     * 获取Sku列表
    * @Title: gainSkuList
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param sku
    * @param @return    设定文件
    * @return List<GoodsSku>    返回类型
    * @author ZhouZhangbao
     */
	public DataGrid gainSkuList(GoodsSku sku);
	 /**
     * 获取Sku
    * @Title: gainSkuByIdAndSkuNum
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param sku
    * @param @return    设定文件
    * @return String id, String skuNum    返回类型
    * @author ZhouZhangbao
     */
	public GoodsSku gainSkuByIdAndSkuNum(String id, String skuNum);

}
