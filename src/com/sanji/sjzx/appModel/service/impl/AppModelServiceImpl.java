package com.sanji.sjzx.appModel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.appModel.dao.AppModelMapper;
import com.sanji.sjzx.appModel.service.AppModelService;
import com.sanji.sjzx.model.AppModel;
@Service("appModelService")
@Transactional(rollbackFor=Exception.class)
public class AppModelServiceImpl implements AppModelService {
	@Resource
	private AppModelMapper appModelMapper;
	/**
	 * 添加适用机型信息
	 */
	public void addAppModel(AppModel appModel) {
		appModelMapper.addAppModel(appModel);
	}
	/**
	 * 根据配件id获取适用机型信息
	 */
	public List<AppModel> gainAppModelByAccId(String accId) {
		return appModelMapper.gainAppModelByAccId(accId);
	}
	/**
	 * 删除相应记录的适用机型信息
	 */
	public void dropAppModel(String id) {
		appModelMapper.dropAppModel(id);
	}
	/**
	 * 根据商品id删除适用机型信息
	 */
	public void dropAppModelByGoodsId(String goodsId) {
		appModelMapper.dropAppModelByGoodsId(goodsId);
	}
	/**
	 * 根据商品id获取适用机型信息
	 */
	public List<AppModel> gainAppModelByGoodsId(String goodsId) {
		return appModelMapper.gainAppModelByGoodsId(goodsId);
	}
	/**
	 * 根据配件id删除适用机型信息
	 */
	public void dropAppModelByAccId(String accId) {
		appModelMapper.dropAppModelByAccId(accId);
	}
}
