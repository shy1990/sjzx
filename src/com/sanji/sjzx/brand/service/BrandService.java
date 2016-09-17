
package com.sanji.sjzx.brand.service;

import java.util.List;

import com.sanji.sjzx.model.Brand;
import com.sanji.sjzx.pojo.DataGrid;

public interface BrandService {

    /**
     * 查询品牌列表信息
     * @param brand
     * @return
     */
   public List<Brand> gainBrandList1(Brand brand,String num);
  // public List<Brand> gainBrandList();
   /**
    * 获取总行数
    * @return
    */
   public Long gainBrandAllCount();

    /**
     * 添加品牌信息
     * @param brand
     */
    public void addBrand(Brand brand);
    
    /**
     * 修改品牌信息
     * @param brand
     */
    public void modifyBrand(Brand brand);
     /**
     * 根据id删除相应的品牌信息(物理删除)
     * @param id
     */
    public void dropBrand(String id);
    
    /**
     * 获取根元素列表
     * @return
     */
    //public List<Brand> gainRootBrand();

    /**
     * 根据父ID查询子信息
     * @param pid
     * @return
     */
    public List<Brand> gainChildBrandListByPid(String pid);
    
    /**
     * 查询验证该品牌是否含有子信息
     * @param pid
     * @return
     */
    public boolean gainIsExistChildBrand(String pid);
    
    /**
     * 根据品牌名称进行查询
     * @param name
     * @return
     */
    public boolean gainIsExistName(String name);

    /**
     * 修改时进行查询是否存在用户名
     * @return
     */            
    public boolean gainBrandForExceptUsername(String id,String name);
    /**
     * 获取所有品牌
     */
    //public List<Brand> gainAll();
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
    public boolean gainGoodsByBrandId(String brandId);
    
    /**
     * 获取所有单品品牌
     * @param brand 
     * gainAllGoodsBrand
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param brand
     * @param @return 设定文件
     * @return List<Brand> 返回类型
     * @author songbaozhen
     */
	public List<Brand> gainAllGoodsBrand(Brand brand);
	/**
     * 获取所有分类为手机的商品的品牌
     * @param brand 
     * @Title:gainSkuBrandName
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @param 
     * @param @return 设定文件
     * @return List<Brand> 返回类型
     * @author songbaozhen
     */
	public List<Brand> gainSkuBrandName();
}
