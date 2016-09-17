package com.sanji.sjzx.goods.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.Goods;

/**
 * @ClassName:GoodsMapper
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author yangningning
 * @date 2014-10-11上午11:05:52
 */
public interface GoodsMapper {
    /**
     * 商品列表
     * @Title:gainGoodsList
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goods
     * @param @return 设定文件
     * @return List<Goods> 返回类型
     * @throws
     * @param goods
     * @return
     */
    public List<Goods> gainGoodsList(Goods goods);
    /**
     * 获取适用机型列表
     * @Title:gainApplicationModelList
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goods
     * @param @return 设定文件
     * @return List<Goods> 返回类型
     * @throws
     * @param goods
     * @return
     */
    public List<Goods> gainApplicationModelList(Goods goods);
    
    /**
     * 获取回收站列表
     * @Title:gainRecycleList
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goods
     * @param @return 设定文件
     * @return List<Goods> 返回类型
     * @throws
     * @param goods
     * @return
     */
    public List<Goods> gainRecycleList(Goods goods);
    /**
     * 列表总行数
     * @Title:gainGoodsCount
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goods
     * @param @return 设定文件
     * @return Long 返回类型
     * @throws
     * @param goods
     * @return
     */
    public Long gainGoodsCount(Goods goods);
    /**
     * 回收站列表总行数
     * @Title:gainRecycleCount
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goods
     * @param @return 设定文件
     * @return Long 返回类型
     * @throws
     * @param goods
     * @return
     */
    public Long gainRecycleCount(Goods goods);
    
    /**
     * 获取所有商品品牌名称
     * @Title:gaingainGoodsBrandName
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @return 设定文件
     * @return List<String> 返回类型
     * @throws
     * @return
     */
    public List<Goods> gainGoodsBrandName();
    
    /**
     * 获取所有类别名称
     * @Title:gainGoodsCatName
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @return 设定文件
     * @return List<Goods> 返回类型
     * @throws
     * @return
     */
    public List<Goods> gainGoodsCatName();
    /**
     * 根据id获取商品信息(id,name,goods_num)
     * @Title:gainGoodsAll
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
    public void addGoods(Goods goods);
    /**
     * 添加商品时根据name查询是否存在该goods
     * @Title:gainGoodsByName
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param name
     * @param @return 设定文件
     * @return List<Goods> 返回类型
     * @throws
     * @param name
     * @return
     */
    public List<Goods> gainGoodsByName(String name);
    
    /**
     * 添加时根据商品编号查询是否存在该goods
     * @Title:gainGoodsByGoodsNum
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goodsNum
     * @param @return 设定文件
     * @return List<Goods> 返回类型
     * @throws
     * @param goodsNum
     * @return
     */
    public List<Goods> gainGoodsByGoodsNum(String goodsNum);
    
    /**
     * 修改时根据id和name查询是否存在该goods
     * @Title:gainGoodsByNameandId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param id
     * @param @param name
     * @param @return 设定文件
     * @return List<Goods> 返回类型
     * @throws
     * @param id
     * @param name
     * @return
     */
    public List<Goods> gainGoodsByNameandId(Map<String, Object> map);
    
    /**
     * 修改时根据id和num查询是否存在该goods
     * @Title:gainGoodsByNumandId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param map
     * @param @return 设定文件
     * @return List<Goods> 返回类型
     * @throws
     * @param map
     * @return
     */
    public List<Goods> gainGoodsByNumandId(Map<String, Object> map);

    /**
     * 修改商品信息
     * @Title:updateGoods
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goods 设定文件
     * @return void 返回类型
     * @throws
     * @param goods
     */
    public void updateGoods(Goods goods);
    public void updateGoodsById(Goods goods);
    
    /**
     * 删除商品信息(逻辑删除)
     * @Title:deleteGoods
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param ids 设定文件
     * @return void 返回类型
     * @throws
     * @param ids
     */   
    public void deleteGoods(List<String> ids);
    /**
     * 恢复删除到回收站的商品信息
     * @Title:recoverGoods
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param ids 设定文件
     * @return void 返回类型
     * @throws
     * @param ids
     */
    public void recoverGoods(List<String> ids);

    /**
     * 删除商品信息(物理删除)
     * @Title:dropGoods
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param ids 设定文件
     * @return void 返回类型
     * @throws
     * @param ids
     */
    public void dropGoods(List<String> ids);
    
    /**
     * 根据品牌id获取品牌信息（用于品牌管理中删除品牌时判断该品牌是否关联商品）
     * @Title:gainGoodsByBrandId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param brandId
     * @param @return 设定文件
     * @return List<Goods> 返回类型
     * @throws
     * @param brandId
     * @return
     */
    public List<Goods> gainGoodsByBrandId(String brandId);
    
    /**
     * 根据类别id获取类别信息（用于类别管理中删除类别时判断该类别是否关联商品）
     * @Title:gainGoodsByCatId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param catId
     * @param @return 设定文件
     * @return List<Goods> 返回类型
     * @throws
     * @param catId
     * @return
     */
    public List<Goods> gainGoodsByCatId(String catId);
    
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
     * 设置单品为电商热销
    * @Title: openGoodsById
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param ids   设定文件
    * @return void   返回类型
    * @author songbaozhen
     */
	public void openGoodsById(List<String> ids);
	/**
     * 取消单品为电商热销
    * @Title:  danGoodsById
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param ids   设定文件
    * @return void   返回类型
    * @author songbaozhen
     */
	public void danGoodsById(List<String> ids);
}