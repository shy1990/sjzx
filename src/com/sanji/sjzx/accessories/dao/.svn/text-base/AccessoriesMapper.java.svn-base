package com.sanji.sjzx.accessories.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.Accessories;
import com.sanji.sjzx.model.Gift;
public interface AccessoriesMapper{

    /**
     * 获取配件列表
     * @Title:gainAccessoriesList
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param a
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param a
     * @return
     */
    public List<Accessories> gainAccessoriesList(Accessories a);    
   
    /**
     * 获取列表总行数
     * @Title:gainAccessoriesCount
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param a
     * @param @return 设定文件
     * @return Long 返回类型
     * @throws
     * @param a
     * @return
     */
    public Long gainAccessoriesCount(Accessories a);
    
    /**
     * 获取配件保护膜行数
     * @Title:gainAccessoriesMaskCount
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param a
     * @param @return 设定文件
     * @return Long 返回类型
     * @throws
     * @param a
     * @return
     */
    public Long gainAccessoriesMaskCount(Accessories a);
    
    /**
     * 添加配件信息
     * @Title:addAccessories
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param a 设定文件
     * @return void 返回类型
     * @throws
     * @param a
     */
    public void addAccessories(Accessories a);
    
    /**
     * 根据配件名称查询是否存在该配件名称
     * @Title:gainAccessoriesByName
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param accName
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param accName
     * @return
     */
    public List<Accessories> gainAccessoriesByName(String accName);
    
    /**
     * 根据配件编号查询是否存在该配件编号
     * @Title:gainAccessoriesByNum
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param accNum
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param accNum
     * @return
     */
    public List<Accessories> gainAccessoriesByNum(String accNum);
    
    /**
     * 根据规格代码查询是否存在该配件代码
     * @Title:gainAccessoriesBySpecCode
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param specCode
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param specCode
     * @return
     */
    public List<Accessories> gainAccessoriesBySpecCode(String specCode);
    /**
     * 根据goodsId查询该配件信息 
     * @param id
     * @return
     */
    public List<Accessories> gainAccessoriesByGoodsId(String goodsId);
    
    /**
     * 根据id获取配件信息
     * @Title:gainAccessoriesById
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param id
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param id
     * @return
     */
    public Accessories gainAccessoriesById(String id);
    
    /**
     * 修改配件信息
     * @Title:updateAccessories
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param a 设定文件
     * @return void 返回类型
     * @throws
     * @param a
     */
    public void updateAccessories(Accessories a);
    
    /**
     * 修改时根据id和配件名称查询是否存在此配件名称
     * @Title:gainAccessoriesByIdandName
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param map
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param map
     * @return
     */
    public List<Accessories> gainAccessoriesByIdandName(Map<String, Object> map);
    	
    /**
     * 修改时根据id和配件编号查询是否存在此配件编号
     * @Title:gainAccessoriesByIdandNum
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param map
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param map
     * @return
     */
    public List<Accessories> gainAccessoriesByIdandNum(Map<String, Object> map);
    
    /**
     * 修改时根据id和规格代码查询是否存在此规格代码
     * @Title:gainAccessoriesByIdandSpecCode
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param map
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param map
     * @return
     */
    public List<Accessories> gainAccessoriesByIdandSpecCode(Map<String, Object> map);
    /**
     * 批量或单条删除配件信息(逻辑删除)
     * @Title:deleteAccessories
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param ids 设定文件
     * @return void 返回类型
     * @throws
     * @param ids
     */
    public void deleteAccessories(List<String> ids);
    /**
     * 根据配件id查询该id关联的赠品
     * @Title:gainGiftByAccId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param accId
     * @param @return 设定文件
     * @return List<Gift> 返回类型
     * @throws
     * @param accId
     * @return
     */
    public List<Gift> gainGiftByAccId(String accId);
    /**
     * 批量或单条删除配件信息(物理删除)
     * @Title:DropAccessories
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param ids 设定文件
     * @return void 返回类型
     * @throws
     * @param ids
     */
    public void dropAccessories(List<String> ids);
    
    /**
     * 获取配件保护膜列表
     * @Title:gainAccessoriesMaskList
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param a
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param a
     * @return
     */
    public List<Accessories> gainAccessoriesMaskList(Accessories a);  
    
    /**
     * 根据商品id获取被选择的配件贴膜信息
     * @Title:gainAccessoriesMaskByGoodsId
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param goodsId
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param goodsId
     * @return
     */
    public List<Accessories> gainAccessoriesMaskByGoodsId(String goodsId);
    
    /**
     * 根据规格代码更新价格以及库存
    * @Title: updatePriceByCode
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param accessories    设定文件
    * @return void    返回类型
    * @author ZhouZhangbao
     */
    public void updatePriceByCode(Accessories accessories);
    /**
     * 根据配件id下架配件，修改可用状态，修改库存为0，修改价格为0，修改上下架状态，添加下架时
     * @Title:updateShelves
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param  设定文件
     * @return void 返回类型
     * @throws
     */
    public void updateShelves(Accessories accessories);
    /**
     * 获取配件仓库列表即下架配件列表 
     * @Title:gainShelvesList
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param a
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param a
     * @return
     */
    public List<Accessories> gainShelvesList(Accessories a);
    /**
     * 获取仓库列表下架配件行数
     * @Title:gainShelvesAccount
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param a
     * @param @return 设定文件
     * @return Long 返回类型
     * @throws
     * @param a
     * @return
     */
    public Long gainShelvesCount(Accessories a);
    /**
     * 根据配件id获取相应的配件信息
     * @Title:gainShelvesById
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param id
     * @param @return 设定文件
     * @return Accessories 返回类型
     * @throws
     * @param id
     * @return
     */
    public Accessories gainShelvesById(String id);
    /**
     * 恢复时进行修改价格
     * @Title:updatePrice
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param accessories 设定文件
     * @return void 返回类型
     * @throws
     * @param accessories
     */
    public void updatePrice(Accessories accessories);
    /**
     * 进行上架恢复操作
     * @Title:updateRecover
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param accessories 设定文件
     * @return void 返回类型
     * @throws
     * @param accessories
     */
    public void updateRecover(Accessories accessories);
    /**
     * 根据条件进行查询获取acc数据用于导出
     * @Title:gainAccByExport
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param accessories
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param accessories
     * @return
     */
    public List<Accessories> gainAccByExport(Accessories accessories);
    /**
     * 根据条件进行查询获取acc数据
     * @Title:gainAccByExport
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param accessories
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param accessories
     * @return
     */
	public long gainAccBySpecCode(String specCode);
	 /**
     * 批量更新acc
     * @Title:updateByAccList
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param accessories
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param accessories
     * @return
     */
	public void updateByAcc(Accessories acc);

}