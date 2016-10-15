package com.sanji.sjzx.accessories.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.accessories.dao.AccessoriesMapper;
import com.sanji.sjzx.accessories.service.AccessoriesService;
import com.sanji.sjzx.brand.dao.BrandMapper;
import com.sanji.sjzx.cat.dao.CatMapper;
import com.sanji.sjzx.color.dao.ColorMapper;
import com.sanji.sjzx.model.Accessories;
import com.sanji.sjzx.model.Brand;
import com.sanji.sjzx.model.Cat;
import com.sanji.sjzx.model.Color;
import com.sanji.sjzx.model.Gift;
import com.sanji.sjzx.pojo.DataGrid;

@Service("accService")
@Transactional(rollbackFor=Exception.class)
public class AccessoriesServiceImpl implements AccessoriesService {
	@Resource
	private AccessoriesMapper accMapper;
	@Resource
	private BrandMapper brandMapper;
	@Resource
	private CatMapper catMapper;
	@Resource
	private ColorMapper colorMapper;
	public AccessoriesMapper getAccMapper() {
		return accMapper;
	}
	public void setAccMapper(AccessoriesMapper accMapper) {
		this.accMapper = accMapper;
	}
	/**
	 * 获取配件分页列表
	 */
	public DataGrid gainAccessoriesList(Accessories a) {
		DataGrid j = new DataGrid();
		j.setRows(accMapper.gainAccessoriesList(a));
		j.setTotal(accMapper.gainAccessoriesCount(a));
		return j;	
	}
	/**
	 * 添加配件信息
	 */
	public void addAccessories(Accessories a){
		accMapper.addAccessories(a);
	}
	/**
	 * 根据配件名称进行查询是否存在此配件名称
	 */
	public boolean gainAccessoriesByName(String accName){
		List<Accessories> list = accMapper.gainAccessoriesByName(accName);
		if(list !=null && list.size()>0){//不为空
			return false;
		}else{//为空
			return true;
		}
	}
	/**
	 * 根据配件编号进行查询是否存在此配件编号
	 */
    public boolean gainAccessoriesByNum(String accNum){
    	List<Accessories> list = accMapper.gainAccessoriesByNum(accNum);
    	if(list !=null && list.size()>0){
    		return false;
    	}else{
    		return true;
    	}
    }
    /**
     * 根据规格代码查询是否存在此规格代码
     */
    public boolean gainAccessoriesBySpecCode(String specCode){
    	List<Accessories> list = accMapper.gainAccessoriesBySpecCode(specCode);
    	if(list !=null && list.size()>0){
    		return false;
    	}else{
    		return true;
    	}
    }
	/**
	 * 根据goodsId批量查询Accessories
	 */
	public List<Accessories> gainAccessoriesByGoodsId(String goodsId) {
		return accMapper.gainAccessoriesByGoodsId(goodsId);
	}
	/**
	 * 根据id获取配件信息 
	 */
	public Accessories gainAccessoriesById(String id){
		return accMapper.gainAccessoriesById(id);
	}
	/**
	 * 修改配件信息
	 */
	public void updateAccessories(Accessories a) {
		accMapper.updateAccessories(a);
	}
	/**
	 * 根据id和配件名称查询是否存在此配件名称
	 */
	public boolean gainAccessoriesByIdandName(String id,String accName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", accName);
		List<Accessories> list = accMapper.gainAccessoriesByIdandName(map);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 根据id和配件编号查询是否存在此配件编号
	 */
	public boolean gainAccessoriesByIdandNum(String id, String accNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("accessoriesNum", accNum);
		List<Accessories> list = accMapper.gainAccessoriesByIdandNum(map);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 根据id和规格代码查询是否存在此规格代码
	 */
	public boolean gainAccessoriesByIdandSpecCode(String id,String specCode){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("specCode", specCode);
		List<Accessories> list = accMapper.gainAccessoriesByIdandSpecCode(map);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 根据配件id查询赠品
	 */
	public List<Gift> gainGiftByAccId(String accId){
		return accMapper.gainGiftByAccId(accId);
	}
	/**
	 * 批量或单条删除配件信息(物理删除)
	 */
	public void dropAccessories(List<String> ids) {
		accMapper.dropAccessories(ids);
	}
	/**
	 * 获取所有品牌
	 */
	public List<Brand> gainAllBrand() {
		return brandMapper.gainBrandAll();
	}
	/**
	 * 获取所有类别
	 */
	public List<Cat> gainAllCat() {
		return catMapper.gainAllCat();
	}
	/**
	 * 获取所有颜色
	 */
	public List<Color> gainAllColor() {
		return colorMapper.gainAllColor();
	}
	/**获取配件保护膜分页列表
	 */
	public DataGrid gainAccessoriesMaskList(Accessories a) {
		DataGrid j = new DataGrid();
		j.setRows(accMapper.gainAccessoriesMaskList(a));
		j.setTotal(accMapper.gainAccessoriesMaskCount(a));
		return j;	
	}
	/**
	 * 获取被选择的配件保护膜信息
	 */
	public List<Accessories> gainAccessoriesMaskByGoodsId(String goodsId) {
		return accMapper.gainAccessoriesMaskByGoodsId(goodsId);
	}
	/* (非 Javadoc)
	* <p>Title: updatePriceByNum</p>
	* <p>Description: </p>
	* @param accessories
	* @see com.sanji.sjzx.accessories.service.AccessoriesService#updatePriceByNum(com.sanji.sjzx.model.Accessories)
	*/
	
	public void updatePriceByNum(Accessories accessories) {
		accMapper.updatePriceByCode(accessories);
		
	}
	/**
	 * 根据配件id下架配件，修改可用状态，修改库存为0，修改价格为0，修改上下架状态，添加下架时
	 */
	public void updateShelves(Accessories accessories) {
		accMapper.updateShelves(accessories);
	}
	/**
	 * 获取配件仓库分页列表
	 */
	public DataGrid gainShelvesList(Accessories a) {
		DataGrid j = new DataGrid();
		j.setRows(accMapper.gainShelvesList(a));
		j.setTotal(accMapper.gainShelvesCount(a));
		return j;	
	}
	/**
	 * 根据配件id获取相应的配件信息
	 */
	public Accessories gainShelvesById(String id) {
		return accMapper.gainShelvesById(id);
	}
	/**
	 * 恢复时进行修改配件价格
	 */
	public void updatePrice(Accessories accessories) {
		accMapper.updatePrice(accessories);
	}
	/**
	 * 进行恢复操作
	 */
	public void updateRecover(Accessories accessories) {
		accMapper.updateRecover(accessories);
	}
	/**
	 * 流
	 */
	public InputStream exportDateToExcel(List<?> list) {
		if(list==null){
			try {
				throw new Exception("list is null in exportDateToExcel method,it mustn't be null.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();   
		putDataOnOutputStream(out,list);   
		return new ByteArrayInputStream(out.toByteArray());
	}
	/**
	 * 流
	 * @Title:putDataOnOutputStream
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @param os
	 * @param @param list 设定文件
	 * @return void 返回类型
	 * @throws
	 * @param os
	 * @param list
	 */
	private void putDataOnOutputStream(OutputStream os,List<?> list) {
		if(list==null)
			try {
				throw new Exception("list is null in exportDateToExcel method,it mustn't be null.");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(os);
			WritableSheet sheet = workbook.createSheet("Sheet1", 0);
			sheet.getSettings().setDefaultColumnWidth(20);
			sheet.addCell(new jxl.write.Label(0, 0, "商品代码"));
			sheet.addCell(new jxl.write.Label(1, 0, "配件名称"));
			sheet.addCell(new jxl.write.Label(2, 0, "规格代码"));
			sheet.addCell(new jxl.write.Label(3, 0, "库存"));
			sheet.addCell(new jxl.write.Label(4, 0, "价格"));
			sheet.addCell(new jxl.write.Label(5, 0, "配件类别"));
			sheet.addCell(new jxl.write.Label(6, 0, "配件品牌"));

	        //循环遍历到数据集
	        for(int i= 0;i<list.size();i++){
	        	Accessories a = (Accessories) list.get(i);
	        	sheet.addCell(new jxl.write.Label(0,i+1 ,a.getAccessoriesNum()+""));
	        	sheet.addCell(new jxl.write.Label(1,i+1 ,a.getName()));
	        	sheet.addCell(new jxl.write.Label(2,i+1 ,a.getSpecCode()));
	        	sheet.addCell(new jxl.write.Label(3,i+1 ,a.getStock()));
	        	sheet.addCell(new jxl.write.Label(4,i+1 ,a.getPrice()));
	        	sheet.addCell(new jxl.write.Label(5,i+1 ,a.getCatName()));
	        	sheet.addCell(new jxl.write.Label(6,i+1 ,a.getBrandName()));
	        }
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			try {
				throw new Exception("putDataOnOutputStream has some error:",e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * acc数据导出
	 */
	public List<Accessories> gainAccByExport(Accessories accessories) {
		return accMapper.gainAccByExport(accessories);
	}
	/**
	 * 根据规格代码验证acc是否存在
	 */
	public boolean exsitAccBySpecCode(String specCode) {
		long accNum = accMapper.gainAccBySpecCode(specCode);
		if(accNum > 0){
			return true;
		}
		
		return false;
	}
	/**
	 * 批量更新acc
	 */
	public void updatePriceByAcc(Accessories acc) {
		accMapper.updateByAcc(acc);
	}

}
