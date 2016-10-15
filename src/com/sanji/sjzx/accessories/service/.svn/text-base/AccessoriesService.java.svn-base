package com.sanji.sjzx.accessories.service;

import java.io.InputStream;
import java.util.List;

import com.sanji.sjzx.model.Accessories;
import com.sanji.sjzx.model.Brand;
import com.sanji.sjzx.model.Cat;
import com.sanji.sjzx.model.Color;
import com.sanji.sjzx.model.Gift;
import com.sanji.sjzx.pojo.DataGrid;

public interface AccessoriesService {
	
	/**
	 * 获取配件列表
	 * @Title:gainAccessoriesList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param a
	 * @param @return 设定文件
	 * @return DataGrid 返回类型
	 * @throws
	 * @param a
	 * @return
	 */
	public DataGrid gainAccessoriesList(Accessories a);
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
	 * 查询时根据配件名称查询是否存在此配件名称
	 * @Title:gainAccessoriesByName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param accName
	 * @param @return 设定文件
	 * @return List<Accessories> 返回类型
	 * @throws
	 * @param accName
	 * @return
	 */
	public boolean gainAccessoriesByName(String accName);
	
    /**
     * 查询时根据配件编号查询是否存在此配件编号
     * @Title:gainAccessoriesByNum
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param accNum
     * @param @return 设定文件
     * @return List<Accessories> 返回类型
     * @throws
     * @param accNum
     * @return
     */
    public boolean gainAccessoriesByNum(String accNum);
    
    /**
     * 添加时根据规格代码查询是否存在此规格代码
     * @Title:gainAccessoriesBySpecCode
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param specCode
     * @param @return 设定文件
     * @return boolean 返回类型
     * @throws
     * @param specCode
     * @return
     */
    public boolean gainAccessoriesBySpecCode(String specCode);
	/**
	 * 根据goodsId获取Accessories
	 * @Title:gainAccessoriesByIds
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param ids
	 * @param @return 设定文件
	 * @return List<Accessories> 返回类型
	 * @throws
	 * @param ids
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
	 * @param @param id
	 * @param @param accName
	 * @param @return 设定文件
	 * @return List<Accessories> 返回类型
	 * @throws
	 * @param id
	 * @param accName
	 * @return
	 */
	public boolean gainAccessoriesByIdandName(String id,String accName);
	
	/**
	 * 修改时根据id和配件编号查询是否存在此配件编号
	 * @Title:gainAccessoriesByIdandNum
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @param accNum
	 * @param @return 设定文件
	 * @return List<Accessories> 返回类型
	 * @throws
	 * @param id
	 * @param accNum
	 * @return
	 */
	public boolean gainAccessoriesByIdandNum(String id,String accNum);
	
	/**
	 * 修改时根据id和规格代码查询是否存在此规格代码
	 * @Title:gainAccessoriesByIdandSpecCode
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
	public boolean gainAccessoriesByIdandSpecCode(String id,String specCode);
	
	/**
	 * 根据配件id查询赠品
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
	 * @Title:dropAccessories
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param ids 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param ids
	 */
	public void dropAccessories(List<String> ids);
	
    /**
    * 获取所有品牌名称
    * @Title:gainAllBrand
    * @Description:TODO(这里用一句话描述这个方法的作用)
    * @param @return 设定文件
    * @return List<Brand> 返回类型
    * @throws
    * @return
    */
   public List<Brand> gainAllBrand();
   
   /**
    * 获取所有类别名称
    * @Title:gainAllCat
    * @Description:TODO(这里用一句话描述这个方法的作用)
    * @param @return 设定文件
    * @return List<Cat> 返回类型
    * @throws
    * @return
    */
   public List<Cat> gainAllCat();
   
   /**
    * 获取所有颜色
    * @Title:gainAllColor
    * @Description:TODO(这里用一句话描述这个方法的作用)
    * @param @return 设定文件
    * @return List<Color> 返回类型
    * @throws
    * @return
    */
   public List<Color> gainAllColor();
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
   public DataGrid gainAccessoriesMaskList(Accessories a); 
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
   * @Title: updatePriceByNum
   * @Description: TODO(这里用一句话描述这个方法的作用)
   * @param @param accessories    设定文件
   * @return void    返回类型
   * @author ZhouZhangbao
    */
   public void updatePriceByNum(Accessories accessories);
   
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
    * 获取配件仓库列表
    * @Title:gainShelvesList
    * @Description:TODO(这里用一句话描述这个方法的作用)
    * @param @param a
    * @param @return 设定文件
    * @return DataGrid 返回类型
    * @throws
    * @param a
    * @return
    */
   public DataGrid gainShelvesList(Accessories a);
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
    * 流
    * @Title:exportDateToExcel
    * @Description:TODO(这里用一句话描述这个方法的作用)
    * @param @param list
    * @param @return 设定文件
    * @return InputStream 返回类型
    * @throws
    * @param list
    * @return
    */
   InputStream exportDateToExcel(List<?> list);
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
    * 根据条件进行判断acc是否存在
    * @Title:exsitAccByAccNum
    * @Description:TODO(这里用一句话描述这个方法的作用)
    * @param @param accessoriesNum
    * @param @return 设定文件
    * @return List<Accessories> 返回类型
    * @throws
    * @param accessories
    * @return
    */
   public boolean exsitAccBySpecCode(String specCode);
   /**
    * 批量更新acc
    * @Title:updatePriceByList
    * @Description:TODO(这里用一句话描述这个方法的作用)
    * @param @param accessoriesNum
    * @param @return 设定文件
    * @return List<Accessories> 返回类型
    * @throws
    * @param accessories
    * @return
    */
   public void updatePriceByAcc(Accessories acc);
}
