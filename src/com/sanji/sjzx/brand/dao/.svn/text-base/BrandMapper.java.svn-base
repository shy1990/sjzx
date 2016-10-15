package com.sanji.sjzx.brand.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.Brand;

public interface BrandMapper {

    /**
     * 获取品牌列表
     * @param brand
     * @return
     */
    public List<Brand> gainBrandList1(Brand brand); 
    public List<Brand> gainBrandList();
    /**
     * 获取所有品牌
     * @return
     */
    public List<Brand> gainBrandAll();
  
    /**
     * 根据品牌id查询品牌信息
     * @param bid
     * @return
     */
    public List<Brand> gainBrandListForExcept(String bid);
    
    /**
     * 获取总行数
     * @param brand
     * @return
     */
    public Long gainBrandAllCount();
    
    /**
     * 添加品牌
     * @param brand
     */
    public void addBrand(Brand brand);
  
    /**
     * 根据父模块id查询子模块
     * @param pid
     * @return
     */
    public List<Brand> gainChildBrandListByPid(String pid);
    
    /**
     * 修改品牌信息
     * @param brand
     */
    public void modifyBrand(Brand brand);
    
    //删除模块中的注意点:品牌和商品是相关联的，当点击删除时，需要判断该节点是否有子节点或者是否存在关联的商品，当商品管理做出来之后，需要关注此处
     /**
     * 根据ID删除相应的品牌记录(物理删除)
     * @param id
     */
    public void dropBrand(String id);
    
 
    /**
     * 获取根元素列表
     * @return
     */
    public List<Brand> gainRootBrand();
    
    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    public List<Brand> gainBrandById(String id);
    
    /**
     * 根据品牌名称进行查询
     * @param name
     * @return
     */
    public List<Brand> gainBrandByName(String name);
    /**
     * 修改时进行查询品牌名称是否存在
     */
    public List<Brand> gainBrandForExceptUsername(Map<String,String> map);
    /**
     * 获取所有单品品牌
     */
	public List<Brand> gainAllGoodsBrand(Brand brand);
	/**
     * 获取分类为手机的商品的品牌
     */
	public List<Brand> gainSkuBrandName();

}