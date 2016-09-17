package com.sanji.sjzx.goods.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.goods.dao.GoodsHotMapper;
import com.sanji.sjzx.goods.service.GoodsHotService;
import com.sanji.sjzx.model.GoodsHot;
import com.sanji.sjzx.pojo.DataGrid;
@Service("goodsHotService")
@Transactional(rollbackFor = Exception.class)
public class GoodsHotServiceImpl implements GoodsHotService {

	@Resource
	private GoodsHotMapper goodsHotMapper;
	
	/**
	 * (non-Javadoc)
	 * @Title:gainGoodsList
	 * @Description: TODO(获取热销有关的商品列表)
	 * @param goodsHot
	 * @return DataGrid
	 */
	public DataGrid gainGoodsList(GoodsHot goodsHot) {
		DataGrid j = new DataGrid();
		
		try {
			if("accessories".equals(goodsHot.getGoodsType()) ){//去跟sku表相关联的查询
				j.setRows(goodsHotMapper.gainAccessoriesList(goodsHot));
				j.setTotal(goodsHotMapper.gainAccessoriesCount(goodsHot));
				
			}else{//去根配件表相关联的查询
				j.setRows(goodsHotMapper.gainGoodsSkuList(goodsHot));
				j.setTotal(goodsHotMapper.gainGoodsSkuCount(goodsHot));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return j;
	}

	/**
	 * (non-Javadoc)
	 * deleteGoodsHotByIds
	 * @Description: TODO(将商品设为未热销商品)
	 * @param ids
	 * @return void
	 */
	public void deleteGoodsHotByIds(List<String> ids) {
		goodsHotMapper.deleteById(ids);
		
	}
	
	/**
	 * (non-Javadoc)
	 * gainGoodsNameById
	 * @Description: TODO(根据id获取热销商品)
	 * @param id
	 * @return GoodsHot
	 */
	public GoodsHot gainGoodsById(String id) {
	 GoodsHot goodsHot = goodsHotMapper.gainGoodsHotById(id);
	 if(goodsHot!=null && !"".equals(goodsHot.getTargetId())){
		  return goodsHot;
	 }
		return null;
	}

	/**
	 * (non-Javadoc)
	 * existGoodsHotByIdAndNum
	 * @Description: TODO(验证排行为num的商品是否存在)
	 * @param String id, BigDecimal num
	 * @return boolean
	 */

	public boolean existGoodsHotByIdAndNum(String id, BigDecimal num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("targetId", id);
		map.put("num", num);
		Long hotNum = goodsHotMapper.gainGoodsHotByMap(map);
		if(hotNum > 0){
			return false;
		}else{
			return true;
		}
 		
	}
	/**
	 * (non-Javadoc)
	 * addGoodsHot
	 * @Description: TODO(添加商品是否存在)
	 * @param goodsHot
	 * @return void
	 */

	public void addGoodsHot(GoodsHot goodsHot) {
		goodsHotMapper.insertSelective(goodsHot);	
	}
	/**
	 * (non-Javadoc)
	 * gainMaxNum
	 * @Description: TODO(获取热销最大排行)
	 * @param goodsHot
	 * @return BigDecimal
	 */
	public int gainMaxNum() {
	  int   num =	goodsHotMapper.gainMaxNum();
	    if(num  > 0){
	    	return num;
	    }
		return 1;
	}
	/**
	 * 根据单品id获取热销商品信息
	 */
	public GoodsHot gainGoodsHotsBySkuId(String skuId) {
		return goodsHotMapper.gainGoodsHotsBySkuId(skuId);
	}
	/**
	 * 根据单品id删除相应热销记录
	 */
	public void deleteHotBySkuId(String skuId) {
		goodsHotMapper.deleteHotBySkuId(skuId);
	}
}
