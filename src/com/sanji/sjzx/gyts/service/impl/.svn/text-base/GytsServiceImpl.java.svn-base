package com.sanji.sjzx.gyts.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.gyts.dao.GytsMapper;
import com.sanji.sjzx.gyts.service.GytsService;
import com.sanji.sjzx.model.Gyts;
import com.sanji.sjzx.pojo.DataGrid;
@Service("gytsService")
@Transactional(rollbackFor=Exception.class)
public class GytsServiceImpl implements GytsService {
	
	@Resource
	private GytsMapper gytsMapper;
	/**
	 * 获取推送订单分页列表
	 */
	public DataGrid gainGytsList(Gyts gyts) {
		DataGrid j = new DataGrid();
		j.setRows(gytsMapper.gainGytsList(gyts));
		j.setTotal(gytsMapper.gainGytsCount(gyts));
		return j;
	}
	/**
	 * 添加推送订单
	 */
	public void addGyts(Gyts gyts) {
		try {
			gytsMapper.addGyts(gyts);       
		} catch (Exception e) {
			e.printStackTrace();
		}     
	}

}
