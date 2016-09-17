package com.sanji.sjzx.goods.service;

import java.math.BigDecimal;
import java.util.List;

import com.sanji.sjzx.model.GoodsHot;
import com.sanji.sjzx.pojo.DataGrid;
/**
 * @ClassName: LabelService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author songbaozhen
 * @date 2014-9-6 下午14:44
 */
public interface GoodsHotService {

	/**
	 * 获取商品列表
	 * @Title: gainGoodsList
	 * @Description: TODO(获取标签列表)
	 * @param goodsHot
	 * @return    设定文件
	 * @return DataGrid    返回类型
	 */
	public DataGrid gainGoodsList(GoodsHot goodsHot);
	/**
	 * 根据id删除热销商品
	 * @Title: deleteGoodsHotByIds
	 * @Description: TODO(获取标签列表)
	 * @param ids
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void deleteGoodsHotByIds(List<String> ids);
	/**
	 * 根据id查询热销商品
	 * @Title: gainGoodsNameById
	 * @Description: TODO(根据id查询热销商品)
	 * @param id
	 * @return    设定文件
	 * @return GoodsHot    返回类型
	 */
	public GoodsHot gainGoodsById(String id);
	/**
	 * 根据id 和 num(排名)判断热销商品
	 * @Title: existGoodsHotByIdAndNum
	 * @Description: TODO(根据id 和 num(排名)判断热销商品)
	 * @param targetId , num
	 * @return    设定文件
	 * @return boolean    返回类型
	 */
	public boolean existGoodsHotByIdAndNum(String targetId, BigDecimal num);
	/**
	 * 添加热销商品
	 * @Title: addGoodsHot
	 * @Description: TODO(获取标签列表)
	 * @param goodsHot
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void addGoodsHot(GoodsHot goodsHot);
	/**
	 * 获取热销最大排行
	 * @Title: gainMaxNum
	 * @Description: TODO(获取热销最大排行)
	 * @param 
	 * @return    设定文件
	 * @return BigDecimal    返回类型
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
