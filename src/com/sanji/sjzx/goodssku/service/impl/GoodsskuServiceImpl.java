package com.sanji.sjzx.goodssku.service.impl;

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

import com.sanji.sjzx.goodssku.dao.GoodsskuMapper;
import com.sanji.sjzx.goodssku.service.GoodsskuService;
import com.sanji.sjzx.model.Goods;
import com.sanji.sjzx.model.GoodsSku;
import com.sanji.sjzx.pic.dao.PicMapper;
import com.sanji.sjzx.pojo.DataGrid;

@Service("goodsskuService")
@Transactional(rollbackFor=Exception.class)
public class GoodsskuServiceImpl implements GoodsskuService {
	@Resource
	private GoodsskuMapper skuMapper;
	@Resource
	private PicMapper picMapper;
	
	public GoodsskuMapper getSkuMapper() {
		return skuMapper;
	}
 
	public void setSkuMapper(GoodsskuMapper skuMapper) {
		this.skuMapper = skuMapper;
	}
	/**
	 * 根据商品id查询该商品所有的单品信息
	 */
	public List<GoodsSku> gainSkuByGoodsId(String goodsId) {
		return skuMapper.gainSkuByGoodsId(goodsId);
	}
	/**
	 * 获取所有颜色名称
	 */
	public List<GoodsSku> gainSkuColorName() {
		return skuMapper.gainSkuColorName();
	}

	/**
	 * 批量添加单品信息
	 */
	public void addGoodsSkuList(List<GoodsSku> list) {
		skuMapper.addGoodsSkuList(list);
	}
	/**
	 * 添加单条单品信息
	 */
	public void addGoodsSku(GoodsSku goodsSku) {
		skuMapper.addGoodsSku(goodsSku);
	}
	/**
	 * 添加时查询是否存在此单品
	 */
	public boolean gainSkuBySkuNum(String skuNum) {
		List<GoodsSku> list = skuMapper.gainSkuBySkuNum(skuNum);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 批量更新单品信息
	 */
	public void updateGoodsSkuList(List<GoodsSku> list) {
		skuMapper.updateGoodsSkuList(list);
	}
	/**
	 * 更新单条单品信息
	 */
	public void updateGoodsSku(GoodsSku goodsSku){
		skuMapper.updateGoodsSku(goodsSku);
	}
	/**
	 * 更新时查询是否存在此单品
	 */
	public boolean gainSkuBySkuNumandId(String id, String skuNum) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("skuNum", skuNum);
		List<GoodsSku> list = skuMapper.gainSkuBySkuNumandId(map);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 批量删除单品信息(物理删除)
	 */
	public void dropGoodsSku(List<String> idss) {
		skuMapper.dropGoodsSku(idss);
	}
	/**
	 * 添加时查询是否存在此单品（根据商品代码）
	 */
	public boolean gainSkuBySkuCode(String skuCode) {
		List<GoodsSku> list = skuMapper.gainSkuBySkuCode(skuCode);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
		
	}
	/**
	 * 更新时查询是否存在此单品（根据商品代码）
	 */
	public boolean gainSkuBySkuCodeandId(String id,String skuCode) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("skuCode", skuCode);
		List<GoodsSku> list = skuMapper.gainSkuBySkuCodeandId(map);
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}

	/* (非 Javadoc)
	* <p>Title: updatePriceBySkuNum</p>
	* <p>Description: </p>
	* @param goodsSku
	* @see com.sanji.sjzx.goodssku.service.GoodsskuService#updatePriceBySkuNum(com.sanji.sjzx.model.GoodsSku)
	*/
	
	public void updatePriceBySkuNum(GoodsSku goodsSku) {
		skuMapper.updatePriceByNum(goodsSku);
		
	}
	/**
	 * 单条删除单品信息(物理删除)
	 */
	public void dropGoodsSkuBySkuId(String id) {
		skuMapper.dropGoodsSkuById(id);
		picMapper.DropPicBySkuId(id);
		
	}

	public PicMapper getPicMapper() {
		return picMapper;
	}

	public void setPicMapper(PicMapper picMapper) {
		this.picMapper = picMapper;
	}
	/**
	 * 单条修改单品价格库存
	 */
	public void updateSkuPriceandStock(GoodsSku goodsSku) {
		skuMapper.updateSkuPriceandStock(goodsSku);
	}
	/**
	 * 把商品向宝贝仓库放的时候，修改为下架添加下架时间
	 */
	public void updateShelves(GoodsSku goodsSku) {
		skuMapper.updateShelves(goodsSku);
	}
	/**
	 * 根据goodsId获取宝贝仓库中下架的相应单品记录
	 */
	public List<GoodsSku> gainRecycelSkuByGoodsId(String goodsId) {
		return skuMapper.gainRecycelSkuByGoodsId(goodsId);
	}
	/**
	 * 恢复宝贝仓库中的商品单品，修改为上架
	 */
	public void recycleSheleves(GoodsSku goodsSku) {
		skuMapper.recycleSheleves(goodsSku);
	}
	/* (非 Javadoc)
	* <p>Title: gainSkuOutOfStockList</p>
	* <p>Description: </p>
	* @param goodsSku
	* @see com.sanji.sjzx.goodssku.service.GoodsskuService#gainSkuOutOfStockList(com.sanji.sjzx.model.GoodsSku)
	*/

	public DataGrid gainSkuOutOfStockList(GoodsSku sku) {
		DataGrid j = new DataGrid();
		j.setRows(skuMapper.gainSkuOutOfStockList(sku));
		j.setTotal(skuMapper.gainSkuOutOfStockCount(sku));
		return j; 
	}

	/* (非 Javadoc)
	* <p>Title: exportDateToExcel</p>
	* <p>Description: </p>
	* @param list
	* @return
	* @see com.sanji.sjzx.goodssku.service.GoodsskuService#exportDateToExcel(java.util.List)
	*/
	
	public InputStream exportDateToExcel(List<?> list) {
		if(list==null){
			try {
				throw new Exception("list is null in exportDateToExcel method,it mustn't be null.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();   
		putDataOnOutputStream(out,list);   
		return new ByteArrayInputStream(out.toByteArray());
	}

	private void putDataOnOutputStream(OutputStream os,List<?> list) {
		if(list==null)
			try {
				throw new Exception("list is null in exportDateToExcel method,it mustn't be null.");
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(os);
			WritableSheet sheet = workbook.createSheet("Sheet1", 0);
			sheet.getSettings().setDefaultColumnWidth(20);
			sheet.addCell(new jxl.write.Label(0, 0, "商品代码"));
			sheet.addCell(new jxl.write.Label(1, 0, "商品名称"));
			sheet.addCell(new jxl.write.Label(2, 0, "规格代码"));
			sheet.addCell(new jxl.write.Label(3, 0, "颜色"));
			sheet.addCell(new jxl.write.Label(4, 0, "库存"));
			sheet.addCell(new jxl.write.Label(5, 0, "成本价"));
			sheet.addCell(new jxl.write.Label(6, 0, "商品品类"));

	        //循环遍历到数据集
	        for(int i= 0;i<list.size();i++){
	        	GoodsSku e = (GoodsSku) list.get(i);
	        	sheet.addCell(new jxl.write.Label(0,i+1 ,e.getSkuCode()+""));
	        	sheet.addCell(new jxl.write.Label(1,i+1 ,e.getGoodsName()));
	        	sheet.addCell(new jxl.write.Label(2,i+1 ,e.getSkuNum()));
	        	sheet.addCell(new jxl.write.Label(3,i+1 ,e.getColorName()));
	        	sheet.addCell(new jxl.write.Label(4,i+1 ,e.getStock()));
	        	sheet.addCell(new jxl.write.Label(5,i+1 ,e.getPrice()));
	        	sheet.addCell(new jxl.write.Label(6,i+1 ,"手机"));

	        }
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			try {
				throw new Exception("putDataOnOutputStream has some error:",e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/* (非 Javadoc)
	* <p>Title: gainGoosdSKUByExport</p>
	* <p>Description: </p>
	* @param goods
	* @return
	* @see com.sanji.sjzx.goodssku.service.GoodsskuService#gainGoosdSKUByExport(com.sanji.sjzx.model.Goods)
	*/
	
	public List<GoodsSku> gainGoosdSKUByExport(Goods goods) {
		// TODO Auto-generated method stub
		return skuMapper.gainGoosdSKUByExport(goods);
	}
	/* (非 Javadoc)
	* <p>Title: gainSkuList</p>
	* <p>Description: </p>
	* @param sku
	* @return
	* @see com.sanji.sjzx.goodssku.service.GoodsskuService#gainSkuList(com.sanji.sjzx.model.Sku)
	*/
	public DataGrid gainSkuList(GoodsSku sku) {
		// TODO Auto-generated method stub
		DataGrid j = new DataGrid();
		j.setRows(skuMapper.gainSkuList(sku));
		j.setTotal(skuMapper.gainSkuListCount(sku));
		return j; 
	}
	/* (非 Javadoc)
	* <p>Title: gainSkuByIdAndSkuNum</p>
	* <p>Description: 根据id和skuNum 查询sku </p>
	* @param sku
	* @return
	* @see com.sanji.sjzx.goodssku.service.GoodsskuService#gainSkuByIdAndSkuNum(String id, String skuNum)
	*/
	public GoodsSku gainSkuByIdAndSkuNum(String id, String skuNum) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("skuNum", skuNum);
		return skuMapper.gainSkuByIdAndSkuNum(map);
	}

}
