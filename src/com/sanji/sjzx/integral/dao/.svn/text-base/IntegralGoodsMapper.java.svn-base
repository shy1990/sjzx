package com.sanji.sjzx.integral.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.IntegralGoods;

public interface IntegralGoodsMapper {
 
    /**
     * 获取积分商品列表
     * @Title:gainIntegralGoodsList
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param integralGoods
     * @param @return 设定文件
     * @return List<IntegralGoods> 返回类型
     * @throws
     * @param integralGoods
     * @return
     */
    public List<IntegralGoods> gainIntegralGoodsList(IntegralGoods integralGoods);
    
    /**
     * 获取列表总行数
     * @Title:gainIntegralGoodsCount
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param integralGoods
     * @param @return 设定文件
     * @return Long 返回类型
     * @throws
     * @param integralGoods
     * @return
     */
    public Long gainIntegralGoodsCount(IntegralGoods integralGoods);
    
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
     * 添加时根据积分商品名称查询是否存在此积分商品
     * @Title:gainIntegralGoodsByName
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param name
     * @param @return 设定文件
     * @return List<IntegralGoods> 返回类型
     * @throws
     * @param name
     * @return
     */
    public List<IntegralGoods> gainIntegralGoodsByName(String name);
    /**
     * 添加时根据商品代码查询是否存在此积分商品
     * @Title:gainIntegralGoodsByIntegralCode
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param integralCode
     * @param @return 设定文件
     * @return List<IntegralGoods> 返回类型
     * @throws
     * @param integralCode
     * @return
     */
    public List<IntegralGoods> gainIntegralGoodsByIntegralCode(String integralCode);
    
    /**
     * 添加时 根据规格代码查询是否存在此积分商品
     * @Title:gainIntegralGoodsBySpecCode
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param specCode
     * @param @return 设定文件
     * @return List<IntegralGoods> 返回类型
     * @throws
     * @param specCode
     * @return
     */
    public List<IntegralGoods> gainIntegralGoodsBySpecCode(String specCode);
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
     * 跳转到修改时根据积分商品id查询积分商品信息
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
	 * @Title:gainByIdandName
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
	public List<IntegralGoods> gainIntegralGoodsByIdandName(Map<String, String> map);
	/**
	 * 修改时根据id和商品代码查询是否存在此商品代码
	 * @Title:gainIntegralGoodsByIdandIntegralCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param map
	 * @param @return 设定文件
	 * @return List<IntegralGoods> 返回类型
	 * @throws
	 * @param map
	 * @return
	 */
	public List<IntegralGoods> gainIntegralGoodsByIdandIntegralCode(Map<String, String> map);
	
	/**
	 * 修改时根据id和规格代码查询是否存在此规格代码
	 * @Title:gainIntegralGoodsByIdandSpecCode
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param map
	 * @param @return 设定文件
	 * @return List<IntegralGoods> 返回类型
	 * @throws
	 * @param map
	 * @return
	 */
	public List<IntegralGoods> gainIntegralGoodsByIdandSpecCode(Map<String, String> map);
	/**
	 * 删除相应记录的积分商品信息(物理删除)
	 * @Title:deleteIntegralGoods
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param ids 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param ids
	 */
	public void dropIntegralGoods(List<String> ids);
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
    public List<IntegralGoods> gainShelvesIntegralGoodsList(IntegralGoods integralGoods);
    
    /**
     * 获取下架列表总行数
     * @Title:gainIntegralGoodsCount
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param integralGoods
     * @param @return 设定文件
     * @return Long 返回类型
     * @throws
     * @param integralGoods
     * @return
     */
    public Long gainShelvesIntegralGoodsCount(IntegralGoods integralGoods);
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