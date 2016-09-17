package com.sanji.sjzx.apps.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.apps.dao.AppsMapper;
import com.sanji.sjzx.apps.service.AppsService;
import com.sanji.sjzx.model.Apps;
import com.sanji.sjzx.pojo.DataGrid;

@Service("appsService")
@Transactional(rollbackFor = Exception.class)
public class AppsServiceImpl implements AppsService {
	@Resource
	private AppsMapper appsMapper;
	/**
	 * 获取app分页列表
	 */
	public DataGrid gainAppsList(Apps apps) {
		DataGrid j = new DataGrid();
		j.setRows(appsMapper.gainAppsList(apps));
		j.setTotal(appsMapper.gainAppsListCount(apps));
		return j;
	}
	/**
	 * 根据id查询相应记录
	 */
	public Apps gainAppsById(String id) {
		return appsMapper.gainAppsById(id);
	}
	/**
	 * 根据memberId查询相应记录
	 */
	public List<Apps> gainAppsByMemberId(String memberId) {
		return appsMapper.gainAppsByMemberId(memberId);
	}
	/**
	 * 修改商家信息
	 */
	public void updateAppsById(String id) {
		appsMapper.updateAppsById(id);
	}
}
