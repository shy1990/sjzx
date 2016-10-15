package com.sanji.sjzx.goods.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.GoodsHot;
/**
 * @ClassName:GoodsHotMapper
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author songbaozhen
 * @date 2014-10-11上午11:05:52
 */

public interface GoodsHotMapper {
	/**
	 *根据主键删除一条记录
	* @Title: deleteByPrimaryKey
	* @Description: TODO(根据主键删除一条记录)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    int deleteByPrimaryKey(String id);
    /**
	 *增加一条数据
	* @Title: insert
	* @Description: TODO(根据主键删除一条记录)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    int insert(GoodsHot record);
    /**
	 *有选择性的增加一条数据
	* @Title: insertSelective
	* @Description: TODO(根据主键删除一条记录)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    int insertSelective(GoodsHot record);
    /**
   	 *根据主键查询一条数据
   	* @Title: selectByPrimaryKey
   	* @Description: TODO(根据主键删除一条记录)
   	* @param @param id
   	* @param @return    设定文件
   	* @return GoodsHot    返回类型
   	* @author songbaozhen
   	 */
    GoodsHot selectByPrimaryKey(String id);
    /**
   	 *根据主键有选择性的更新一条数据
   	* @Title: selectByPrimaryKey
   	* @Description: TODO(根据主键删除一条记录)
   	* @param @param record
   	* @param @return    设定文件
   	* @return int    返回类型
   	* @author songbaozhen
   	 */
    int updateByPrimaryKeySelective(GoodsHot record);
    /**
   	 *根据主键更新一条数据
   	* @Title: updateByPrimaryKey
   	* @Description: TODO(根据主键删除一条记录)
   	* @param @param record
   	* @param @return    设定文件
   	* @return int    返回类型
   	* @author songbaozhen
   	 */
    int updateByPrimaryKey(GoodsHot record);
    /**
   	 *获取单品列表
   	* @Title: gainGoodsSkuList
   	* @Description: TODO(根据主键删除一条记录)
   	* @param @param goodsHot
   	* @param @return    设定文件
   	* @return List    返回类型
   	* @author songbaozhen
   	 */
	public List<GoodsHot> gainGoodsSkuList(GoodsHot goodsHot);
	/**
   	 *获取单品总数
   	* @Title: gainGoodsSkuCount
   	* @Description: TODO(根据主键删除一条记录)
   	* @param @param 
   	* @param @return    设定文件
   	* @return Long    返回类型
   	* @author songbaozhen
   	 */
	public Long gainGoodsSkuCount(GoodsHot goodsHot);
	/**
   	 *根据id删除一条记录
   	* @Title: deleteById
   	* @Description: TODO(根据主键删除一条记录)
   	* @param @param id
   	* @param @return    设定文件
   	* @return void    返回类型
   	* @author songbaozhen
   	 */
	public void deleteById(List<String> ids);
	/**
   	 *获取配件列表
   	* @Title:  gainAccessoriesList
   	* @Description: TODO(根据主键删除一条记录)
   	* @param @param goodsHot
   	* @param @return    设定文件
   	* @return List    返回类型
   	* @author songbaozhen
   	 */
	public List<GoodsHot> gainAccessoriesList(GoodsHot goodsHot);
	/**
   	 *获取配件列表
   	* @Title:  gainAccessoriesCount
   	* @Description: TODO(根据主键删除一条记录)
   	* @param @param 
   	* @param @return    设定文件
   	* @return long    返回类型
   	* @author songbaozhen
   	 */
	public Long gainAccessoriesCount(GoodsHot goodsHot);
	/**
   	 *获取配件列表
   	* @Title:  gainGoodsHotByMap
   	* @Description: TODO(根据主键删除一条记录)
   	* @param @param map
   	* @param @return    设定文件
   	* @return long    返回类型
   	* @author songbaozhen
   	 */
	public Long gainGoodsHotByMap(Map<String, Object> map);
	/**
   	 *获取配件列表
   	* @Title:  gainGoodsHotById
   	* @Description: TODO(根据主键删除一条记录)
   	* @param @param id
   	* @param @return    设定文件
   	* @return GoodsHot    返回类型
   	* @author songbaozhen
   	 */
	public GoodsHot gainGoodsHotById(String id);
	/**
   	 *获取热销最大排行
   	* @Title:  gainMaxNum
   	* @Description: TODO(获取热销最大排行)
   	* @param @param id
   	* @param @return    设定文件
   	* @return GoodsHot    返回类型
   	* @author songbaozhen
   	 */
	public int gainMaxNum();
	/**
	 * 根据单品id查询热销商品信息
	 * @Title:gainGoodsHotsBySkuId
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param skuId
	 * @param @return 设定文件
	 * @return List<GoodsHot> 返回类型
	 * @throws
	 * @param skuId
	 * @return
	 */
	public GoodsHot gainGoodsHotsBySkuId(String skuId);
	/**
	 * 根据单品id删除相应的热销记录
	 * @Title:deleteHotBySkuId
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param skuId 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param skuId
	 */
	public void deleteHotBySkuId(String skuId);
}