package com.sanji.sjzx.integral.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.integral.dao.IntegralGoodsMapper;
import com.sanji.sjzx.integral.service.IntegralGoodsService;
import com.sanji.sjzx.model.IntegralGoods;
import com.sanji.sjzx.pojo.DataGrid;

@Service("integralService")
@Transactional(rollbackFor=Exception.class)
public class IntegralGoodsServiceImpl implements IntegralGoodsService {
	@Resource
	private IntegralGoodsMapper integralMapper;
	/**
	 * 获取积分商品分页列表
	 */
	public DataGrid gainIntegralGoodsList(IntegralGoods integralGoods) {
		DataGrid j = new DataGrid();
		j.setRows(integralMapper.gainIntegralGoodsList(integralGoods));
		j.setTotal(integralMapper.gainIntegralGoodsCount(integralGoods));
		return j;
	}
	/**
	 * 添加积分商品信息
	 */
	public void addIntegralGoods(IntegralGoods integralGoods) {
		integralMapper.addIntegralGoods(integralGoods);
	}
	/**
	 * 添加时根据积分商品名称查询是否存在此积分商品
	 */
	public boolean gainIntegralGoodsByName(String name) {
		List<IntegralGoods> list = integralMapper.gainIntegralGoodsByName(name);
		if(list !=null && list.size()>0){//存在
			return false;
		}else{//不存在
			return true;
		}
	}
	/**
	 * 修改积分商品信息
	 */
	public void updateIntegralGoods(IntegralGoods integralGoods) {
		integralMapper.updateIntegralGoods(integralGoods);
	}
	/**
	 * 跳转修改时根据id查询积分商品信息
	 */
	public IntegralGoods gainIntegralGoodsById(String id) {
		return integralMapper.gainIntegralGoodsById(id);
	}
	/**
	 * 修改时根据id和积分商品名称进行查询是否存在此积分商品
	 */
	public boolean gainIntegralGoodsByIdandName(String id, String name) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("name", name);
		List<IntegralGoods> list = integralMapper.gainIntegralGoodsByIdandName(map);
		if(list!=null && list.size()>0){//存在
			return false;
		}else{//不存在
			return true;
		}
	}
	/**
	 * 删除相应记录的积分商品信息
	 */
	public void dropIntegralGoods(List<String> ids) {
		integralMapper.dropIntegralGoods(ids);
	}
	/**
	 * 添加时根据商品代码查询是否存在此积分商品
	 */
	public boolean gainIntegralGoodsByIntegralCode(String integralCode) {
		List<IntegralGoods> list = integralMapper.gainIntegralGoodsByIntegralCode(integralCode);
		if(list !=null && list.size()>0){//存在
			return false;
		}else{//不存在
			return true;
		}
	}
	/**
	 * 添加时根据规格代码查询是否存在此积分商品
	 */
	public boolean gainIntegralGoodsBySpecCode(String specCode) {
		List<IntegralGoods> list = integralMapper.gainIntegralGoodsBySpecCode(specCode);
		if(list !=null && list.size()>0){//存在
			return false;
		}else{//不存在
			return true;
		}
	}
	/**
	 * 修改时根据id和商品代码查询是否存在此积分商品
	 */
	public boolean gainIntegralGoodsByIdandIntegralCode(String id, String integralCode) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("integralCode", integralCode);
		List<IntegralGoods> list = integralMapper.gainIntegralGoodsByIdandIntegralCode(map);
		if(list !=null && list.size()>0){//存在
			return false;
		}else{//不存在
			return true;
		}
	}
	/**
	 * 修改时根据id和规格代码查询是否存在此积分商品
	 */
	public boolean gainIntegralGoodsByIdandSpecCode(String id, String specCode) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("specCode", specCode);
		List<IntegralGoods> list = integralMapper.gainIntegralGoodsByIdandSpecCode(map);
		if(list !=null && list.size()>0){//存在
			return false;
		}else{//不存在
			return true;
		}
	}
	/**
	 * 获取积分商品分页列表
	 */
	public DataGrid gainShelvesIntegralGoodsList(IntegralGoods integralGoods) {
		DataGrid j = new DataGrid();
		j.setRows(integralMapper.gainShelvesIntegralGoodsList(integralGoods));
		j.setTotal(integralMapper.gainShelvesIntegralGoodsCount(integralGoods));
		return j;
	}
	/**
	 * 恢复上架
	 */
	public void updateRecover(IntegralGoods integralGoods) {
		integralMapper.updateRecover(integralGoods);
	}
	/**
	 * 恢复时进行价格修改
	 */
	public void updatePrice(IntegralGoods integralGoods) {
		integralMapper.updatePrice(integralGoods);
	}
}
