
package com.sanji.sjzx.brand.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.brand.dao.BrandMapper;
import com.sanji.sjzx.brand.service.BrandService;
import com.sanji.sjzx.goods.dao.GoodsMapper;
import com.sanji.sjzx.model.Brand;
import com.sanji.sjzx.model.Goods;
import com.sanji.sjzx.pojo.DataGrid;

@Service("brandService")
@Transactional(rollbackFor=Exception.class)
public class BrandServiceImpl implements BrandService{
	@Resource 
	private BrandMapper brandMapper;
	@Resource
	private GoodsMapper goodsMapper;
	/**
	 * 获取品牌列表
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.brand.service.BrandService#gainBrandList(com.sanji.sjzx.model.Brand)
	 */
	public List<Brand> gainBrandList1(Brand brand,String num) {
		List<Brand> list = new ArrayList<Brand>();
		if(num.equals("1")){
			list = brandMapper.gainBrandList1(brand);
		}else if(num.equals("2")){
			list = brandMapper.gainBrandListForExcept(brand.getId());
		}else{
			list = brandMapper.gainBrandList();
		}
		return list;
    }

	/**
	 * 添加品牌信息
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.brand.service.BrandService#addBrand(com.sanji.sjzx.model.Brand)
	 */
	public void addBrand(Brand brand) {
		List<Brand> brandList = brandMapper.gainBrandById(brand.getPid());//获取父元素的属性
		if(brandList!=null && brandList.size()>0){
			if(brandList.get(0).getPtree() != null){				
				brand.setPtree(brandList.get(0).getPtree()+brand.getId()+"，");
			}else{
				brand.setPtree("，"+brand.getPid()+"，");
			}
			brand.setGrade(brandList.get(0).getGrade()+1);
		}
		brandMapper.addBrand(brand);
	}
	
	/**
	 * 修改品牌信息
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.brand.service.BrandService#modifyBrand(com.sanji.sjzx.model.Brand)
	 */
	//含有子元素的元素,元素和子元素的父类路径都要修改
	public void modifyBrand(Brand brand) {
		//进行修改brand节点后,根据pid获取父节点的属性数组，从而获取父节点的ptree，父节点的ptree+","+brand.getId()就得到了自己ptree
		List<Brand> brandList=brandMapper.gainBrandById(brand.getPid());//获取父元素的属性
		if(brandList!=null&&brandList.size()>0){
			for(int i=0;i<brandList.size();i++){
				String self_ptree=brandList.get(i).getPtree()+brand.getId()+"，";
				brand.setPtree(self_ptree);
				brand.setGrade(brandList.get(i).getGrade()+1);
				brandMapper.modifyBrand(brand);
				boolean flag=gainIsExistChildBrand(brand.getId());
				if(flag==false){//如果节点存在子元素
					List<Brand> child=brandMapper.gainChildBrandListByPid(brand.getId());
					for(int j=0;j<child.size();j++){
						modifyBrand(child.get(j));
					}
				}else{//如果节点不存在子元素
					brand.setPtree(self_ptree);
				}
				brand.setName(brand.getName());
				brand.setPic(brand.getPic());
				brand.setRemark(brand.getRemark());
				brand.setP_order(brand.getP_order());
				brandMapper.modifyBrand(brand);
			}
		}
	}
	
	/**
	 * 根据id删除相应的品牌记录(物理删除)
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.brand.service.BrandService#dropBrand(java.lang.String)
	 */
	public void dropBrand(String id) {
		brandMapper.dropBrand(id);
	}

	/**
	 * 获取根元素列表
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.brand.service.BrandService#gainRootBrand()
	 */
//	public List<Brand> gainRootBrand() {
//		return brandMapper.gainRootBrand();
//	}

	/**
	 * 根据父ID获取子信息  
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.brand.service.BrandService#gainChildBrandListByPid(java.lang.String)
	 */
	public List<Brand> gainChildBrandListByPid(String pid) {
		return brandMapper.gainChildBrandListByPid(pid);
	}

	/**
	 * 验证该父ID是否存在子元素
	 * @param pid
	 * @return
	 */
	public boolean gainIsExistChildBrand(String pid) {
		List<Brand> brandList = gainChildBrandListByPid(pid);
		if(brandList!=null && brandList.size()>0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 根据品牌名进行查询
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.brand.service.BrandService#gainIsExistName(java.lang.String)
	 */
	public boolean gainIsExistName(String name) {
		List<Brand> list = brandMapper.gainBrandByName(name);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 获取总行数
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.brand.service.BrandService#gainBrandAllCount()
	 */
	public Long gainBrandAllCount() {
		return brandMapper.gainBrandAllCount();
	}
	/**
	 * 修改时进行查询品牌名是否存在
	 */
	public boolean gainBrandForExceptUsername(String id, String name) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("id", id);
		map.put("name", name);
		List<Brand> list=brandMapper.gainBrandForExceptUsername(map);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 获取所有品牌
	 */
//	public List<Brand> gainAll() {
//		return brandMapper.gainBrandAll();
//	}
	/**
	 * 根据品牌id获取品牌信息（用于品牌管理中删除品牌时判断该品牌是否关联商品）
	 */
	public boolean gainGoodsByBrandId(String brandId) {
		List<Goods> list = goodsMapper.gainGoodsByBrandId(brandId);
		if(list!=null && list.size()>0){//存在
			return false;
		}else{
			return true;
		}
	}

	public List<Brand> gainAllGoodsBrand(Brand brand) {
		List<Brand> bList = brandMapper.gainAllGoodsBrand(brand);
		if(bList!= null  && bList.size() > 0){
			return bList;
		}
		return null;
	}
	/**
	 * 获取所有分类为手机的商品的品牌（用于品牌管理中删除品牌时判断该品牌是否关联商品）
	 */
	public List<Brand> gainSkuBrandName() {
		
		List<Brand> bList = brandMapper.gainSkuBrandName();;
		if(bList!= null  && bList.size() > 0){
			return bList;
		}
		return null;
	}

}
