package com.sanji.sjzx.app.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.App;


public interface AppMapper {
     
    /**
     * 获取app列表
     * @param app
     * @return
     */
    public List<App> gainAppList(App app);
    
    /**
     * 获取总条数
     * @param app
     * @return
     */
    public Long gainAppCount(App app);
    
    /**
     * 添加应用
     * @param app
     */
    public void addApp(App app);
    
    /**
     * 修改app信息
     * @param app
     */
    public void updateApp(App app);
    /**
     * 添加时根据app名称进行查询
     * @param name
     * @return
     */
    public List<App> gainAppByName(String name);
    /**
     * 修改时根据id和app名称是否存在
     */
    public List<App> gainAppForExceptName(Map<String,String> map);

    /**
     * 根据id删除相应记录
     * @param id
     */
    public void dropApp(List<String> ids);
 
}