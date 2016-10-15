package com.sanji.sjzx.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.app.dao.AppMapper;
import com.sanji.sjzx.app.service.AppService;
import com.sanji.sjzx.model.App;
import com.sanji.sjzx.pojo.DataGrid;
@Service("appService")
@Transactional(rollbackFor=Exception.class)

public class AppServiceImpl implements AppService {
	@Resource
	private AppMapper appMapper;
	
	public AppMapper getAppMapper() {
		return appMapper;
	}

	public void setAppMapper(AppMapper appMapper) {
		this.appMapper = appMapper;
	}

	/**
	 * 获取app分页列表
	 *  (non-Javadoc)
	 * @see com.sanji.sjzx.app.service.AppService#gainAppList(com.sanji.sjzx.model.App)
	 */
	public DataGrid gainAppList(App app) {
		DataGrid j=new DataGrid();
		j.setRows(appMapper.gainAppList(app));
		j.setTotal(appMapper.gainAppCount(app));
		return j;
	}
	/**
	 * 添加app
	 */
	public void addApp(App app) {
		appMapper.addApp(app);
	}
	/**
	 * 修改app信息
	 */
	public void updateApp(App app) {
		appMapper.updateApp(app);
	}
	/**
	 * 删除相应记录的app
	 */
	public void dropApp(List<String> ids) {
		appMapper.dropApp(ids);
	}
	/**
	 * 查询时根据name查询验证是否已经存在相同的name
	 */
	public boolean gainAppByName(String name) {
		List<App> list=appMapper.gainAppByName(name);
		if(list!=null&&list.size()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 修改时根据id和name查询验证是否修改后的name已经存在
	 */
	public boolean gainAppForExceptName(String id, String name) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("id", id);
		map.put("name", name);
		List<App> list=appMapper.gainAppForExceptName(map);
		if(list!=null&&list.size()>0){
			return false;
		}else{
			return true;
		}
	}
}
