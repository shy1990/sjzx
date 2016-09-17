package com.sanji.sjzx.regions.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.model.RegionsPrice;
import com.sanji.sjzx.regions.dao.RegionsPriceMapper;
import com.sanji.sjzx.regions.service.RegionsPriceService;

@Service("regionsPriceService")
@Transactional(rollbackFor=Exception.class)
public class RegionsPriceServiceImpl implements RegionsPriceService {

	@Resource
	private RegionsPriceMapper regionsPriceMapper;
	/**
	 * 添加地域价格信息
	 */
	public void addRegionsPrice(RegionsPrice regionsPrice) {
		regionsPriceMapper.addRegionsPrice(regionsPrice);
	}
    /**
     * 获取所有节点数据
     */
	public List<RegionsPrice> gainAllRegionsPrice() {
		return regionsPriceMapper.gainAllRegionsPrice();
	}
	/**
	 * 根据单品id即goodsSkuId修改地域价格信息
	 */
	public void updateRegionsPriceBySkuId(RegionsPrice regionsPrice) {
		regionsPriceMapper.updateRegionsPriceBySkuId(regionsPrice);
	}
	/**
	 * 根据单品id即goodsSkuId获取相应单品的地域价格
	 */
	public List<RegionsPrice> gainRegionsPriceBySkuId(String skuId) {
		return regionsPriceMapper.gainRegionsPriceBySkuId(skuId);
	}
	public void updateRegionsPriceById(RegionsPrice regionsPrice) {
		 regionsPriceMapper.updateRegionsPriceById(regionsPrice);
	}	
}
