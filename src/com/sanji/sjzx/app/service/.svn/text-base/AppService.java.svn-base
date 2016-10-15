package com.sanji.sjzx.app.service;

import java.util.List;

import com.sanji.sjzx.model.App;
import com.sanji.sjzx.pojo.DataGrid;

public interface AppService {
	/**
	 * 获取app列表
	 * @param app
	 * @return
	 */
	public DataGrid gainAppList(App app);
	
	/**
	 * 添加app
	 * @param app
	 */
	public void addApp(App app);
	/**
	 * 修改app
	 * @param app
	 */
	public void updateApp(App app);
    /**
     * 添加时根据app名称进行查询
     * @param name
     * @return
     */
    public boolean gainAppByName(String name);
    /**
     * 修改时根据id和app名称是否存在
     */
    public boolean gainAppForExceptName(String id,String name);

	/**
	 * 删除相应记录的app信息
	 */
    public void dropApp(List<String> ids);
}