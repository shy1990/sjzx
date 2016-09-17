package com.sanji.sjzx.integral.service;

import java.util.List;

import com.sanji.sjzx.model.IntegralGoods;
import com.sanji.sjzx.pojo.DataGrid;

public interface IntegralGoodsService {
	
    /**
     * 获取积分商品分页列表
     * @Title:gainIntegralGoodsList
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param integralGoods
     * @param @return 设定文件
     * @return List<IntegralGoods> 返回类型
     * @throws
     * @param integralGoods
     * @return
     */
    public DataGrid gainIntegralGoodsList(IntegralGoods integralGoods);
    
    /**
     * 添加积分商品信息
     * @Title:addIntegralGoods
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param integralGoods 设定文件
     * @return void 返回类型
     * @throws
     * @param integralGoods
     */
    public void addIntegralGoods(IntegralGoods integralGoods);
    /**
     * 添加时根据积分商品名称查询是否存在此积分商品名称
     * @Title:gainIntegralGoodsByName
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param name
     * @param @return 设定文件
     * @return boolean 返回类型
     * @throws
     * @param name
     * @return
     */
	public boolean gainIntegralGoodsByName(String name);
    /**
     * 修改积分商品信息
     * @Title:updateIntegralGoods
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param integralGoods 设定文件
     * @return void 返回类型
     * @throws
     * @param integralGoods
     */
    public void updateIntegralGoods(IntegralGoods integralGoods); 
    /**
     * 跳转到修改时根据id获取积分商品信息
     * @Title:gainIntegralGoodsById
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param id
     * @param @return 设定文件
     * @return IntegralGoods 返回类型
     * @throws
     * @param id
     * @return
     */
	public IntegralGoods gainIntegralGoodsById(String id);
	/**
	 * 修改时根据id和积分商品名称查询是否存在此积分商品名称
	 * @Title:gainIntegralGoodsByIdandName
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
	public boolean gainIntegralGoodsByIdandName(String id,String name);

	/**
	 * 批量或单条删除积分商品信息(物理删除)
	 * @Title:dropIntegralGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param ids 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param ids
	 */
	public void dropIntegralGoods(List<String> ids);
	
	/**
	 * 添加时根据商品代码查询是否存在此积分商品
	 * @Title:gainIntegralGoodsByIntegralCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param integralCode
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 * @param integralCode
	 * @return
	 */
	public boolean gainIntegralGoodsByIntegralCode(String integralCode);
	/**
	 * 添加时根据规格代码查询是否存在此积分商品
	 * @Title:gainIntegralGoodsBySpecCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param specCode
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 * @param specCode
	 * @return
	 */
	public boolean gainIntegralGoodsBySpecCode(String specCode);
	
	/**
	 * 修改时根据id和商品代码查询是否存在此积分商品
	 * @Title:gainIntegralGoodsByIdandIntegralCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @param integralCode
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 * @param id
	 * @param integralCode
	 * @return
	 */
	public boolean gainIntegralGoodsByIdandIntegralCode(String id,String integralCode);
	
	/**
	 * 修改时根据id和规格代码查询是否存在此积分商品
	 * @Title:gainIntegralGoodsByIdandSpecCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @param specCode
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 * @param id
	 * @param specCode
	 * @return
	 */
	public boolean gainIntegralGoodsByIdandSpecCode(String id,String specCode);
    /**
     * 获取下架积分商品列表
     * @Title:gainIntegralGoodsList
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param integralGoods
     * @param @return 设定文件
     * @return List<IntegralGoods> 返回类型
     * @throws
     * @param integralGoods
     * @return
     */
    public DataGrid gainShelvesIntegralGoodsList(IntegralGoods integralGoods);
    /**
     * 恢复上架
     * @Title:updateRecover
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param integralGoods 设定文件
     * @return void 返回类型
     * @throws
     * @param integralGoods
     */
    public void updateRecover(IntegralGoods integralGoods);
    /**
     * 恢复时进行修改价格
     * @Title:updatePrice
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param integralGoods 设定文件
     * @return void 返回类型
     * @throws
     * @param integralGoods
     */
    public void updatePrice(IntegralGoods integralGoods);
}
