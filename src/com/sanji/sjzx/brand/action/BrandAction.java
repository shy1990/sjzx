
package com.sanji.sjzx.brand.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.brand.service.BrandService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.Brand;
import com.sanji.sjzx.pojo.Json;
import com.sanji.sjzx.pojo.TreeNode;
/**
 * @author Administrator
 *
 */
@Namespace("/brand")
@Action(value = "brandAction", results = {
		@Result(name = "toTreeList", location = "/admin/brand/treeList.jsp"),
		@Result(name = "toAdd", location = "/admin/brand/add.jsp"),
		@Result(name = "toUpdate", location = "/admin/brand/edit.jsp")
		})
public class BrandAction extends BaseAction implements ModelDriven<Brand> {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BrandAction.class);
	
	private Brand brand = new Brand();
	private List<TreeNode> rootTreeList = new ArrayList<TreeNode>();
	private List<TreeNode> sonTreeList = new ArrayList<TreeNode>();
	
	@Resource
	private BrandService brandService;
	
	private String mark;
	private List<String> list = new ArrayList<String>();
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<TreeNode> getRootTreeList() {
		return rootTreeList;
	}

	public void setRootTreeList(List<TreeNode> rootTreeList) {
		this.rootTreeList = rootTreeList;
	}

	public List<TreeNode> getSonTreeList() {
		return sonTreeList;
	}

	public void setSonTreeList(List<TreeNode> sonTreeList) {
		this.sonTreeList = sonTreeList;
	}

	public BrandService getBrandService() {
		return brandService;
	}

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return logger;
	}

	private boolean flag = false;
	
	public void gainAllBrand(){
		try {
			super.writeJson(brandService.gainAllGoodsBrand(brand));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	/**
	 * 获取手机的品牌
	 * 
	 * @Title:gainSkuBrandName
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void gainSkuBrandName() {
		try {
			super.writeJson(brandService.gainSkuBrandName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainSkuBrandName() occur error. ", e);
		}
	}
	
	@SuppressWarnings("unused")
	private List<TreeNode> gainRootTree(List<Brand> brands,List<Brand> brands2){
		rootTreeList = new ArrayList<TreeNode>();
		if(brands!=null && brands.size()>0){
			for (Brand b : brands) {
				TreeNode tn = new TreeNode();
				tn.setMenuid(b.getId());
				if(b.getPic()!=null){
					tn.setIcon(b.getPic());
				}else{
					tn.setIcon("icon-employee");
				}
				tn.setMenuname(b.getName());
				tn.setMenus(gainSonTree(tn.getMenuid(),brands2));
				rootTreeList.add(tn);
			}
		}
		return rootTreeList;
	}
	
	private List<TreeNode> gainSonTree(String bid,List<Brand> brands2){
		sonTreeList = new ArrayList<TreeNode>();
		for (Brand b2 : brands2) {
			if(b2.getPid().equals(bid)){
				TreeNode tn2= new TreeNode();
				tn2.setMenuid(b2.getId());
				tn2.setMenuname(b2.getName());
				if(tn2.getIcon()!=null){
					tn2.setIcon(b2.getPic());
				}else{
					tn2.setIcon("icon-em_list");
				}
				tn2.setUrl(b2.getPic());
				tn2.setImType("href");
				sonTreeList.add(tn2);				
			}
		}
		return sonTreeList;
	}	
	
	/**
	 * 跳转到品牌管理列表
	 * @return
	 */
	public String toTreeList(){
		return "toTreeList";
	}
	/**
	 * 树形列表
	 */
	public void gainBrandTreeList(){
		try {
			super.writeJson(brandService.gainBrandList1(brand,mark));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("gainBrandTreeList() occur error. ", e);
		}
	}
	
	/**
	 * 跳转到品牌添加页面
	 * @return
	 */
	public String toAdd(){
		Long l = brandService.gainBrandAllCount();
		if(l<1){//无数据
			//初次添加模块设置默认值
			brandService.addBrand(setValueForBrand());
		}
		return "toAdd";
	}

	private Brand setValueForBrand(){
		brand.setId(ToolsUtil.getUUID());
		brand.setName("根模块");
		brand.setGrade(Long.parseLong("1"));
		brand.setP_order(Long.parseLong("1"));
		return brand;
	}
	
	/**
	 * 添加品牌信息
	 */
	public void addBrand(){
		Json j = new Json();
		try {
			//查询验证品牌名称是否存在
			flag = brandService.gainIsExistName(brand.getName());
			if(flag){//不存在
				brand.setId(ToolsUtil.getUUID());
				brandService.addBrand(brand);
				j.setObj(brand);
				j.setMsg("添加成功!");
				j.setSuccess(true);				
			}else{
				j.setMsg("此品牌名称已存在!");
				j.setSuccess(false);					
			}
		} catch (Exception e) {
			j.setMsg("添加失败!");
			j.setSuccess(false);
			logger.error("addBrand() occur error. ", e);
			e.printStackTrace();
		}	
		writeJson(j);
	}
	
	/**
	 * 跳转到品牌修改页面
	 * @return
	 */
	public String toUpdate(){
		return "toUpdate";
	}

	/**
	 * 修改品牌信息
	 */
	public void updateBrand(){
		Json j = new Json();
		try {
			//查询验证品牌名称是否存在
			flag = brandService.gainBrandForExceptUsername(brand.getId(), brand.getName());
			if(flag){
				brandService.modifyBrand(brand);
				j.setObj(brand);
				j.setMsg("修改成功!");
				j.setSuccess(true);
			}else{
				j.setMsg("此品牌名称已存在!");
				j.setSuccess(false);					
			}
		} catch (Exception e) {
			j.setMsg("修改失败!");
			j.setSuccess(false);
			logger.error("updateBrand() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	/**
	 * 删除品牌记录(物理删除)
	 */
	public void dropBrand(){
		Json j = new Json();
		try {
			if(!brandService.gainIsExistChildBrand(brand.getId())){
				j.setMsg("该品牌含有子模块,无法删除!");
				j.setSuccess(false);
			}else if(!brandService.gainGoodsByBrandId(brand.getId())){
				j.setMsg("该品牌下有关联商品,无法删除!");
				j.setSuccess(false);
			}else{
				brandService.dropBrand(brand.getId());
				j.setObj(brand.getId());
				j.setMsg("删除成功！");
				j.setSuccess(true);			
			}
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
			logger.error("dropBrand() occur error. ", e);
			e.printStackTrace();
		}
		writeJson(j);
	}
	
	public Brand getModel() {
		return brand;
	}
}
