package com.sanji.sjzx.cat.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.Cat;

public interface CatMapper {
    int deleteByPrimaryKey(String id);

    Cat selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cat record);

    int updateByPrimaryKey(Cat record);
    /**
     * 获取分类列表
     * @param cat
     * @return
     */
    public List<Cat> gainCatList(Cat cat);
    /**
     * 获取列表总行数
     * @param cat
     * @return
     */
    public Long gainCatCount(Cat cat);
    /**
     * 添加分类信息
     * @param cat
     */
    public void addCat(Cat cat);
    /**
     * 添加时根据名称进行查询是否存在该cat
     * @param name
     * @return
     */
    public List<Cat> gainCatByName(String name);
    /**
     * 修改分类信息
     * @param cat
     */
    public void updateCat(Cat cat);
    /**
     * 修改时根据name和id进行查询是否存在该cat
     * @param map
     * @return
     */
    public List<Cat> gainCatByNameandId(Map<String, String> map);
    /**
     * 删除相应id的记录
     * @param ids
     */
    public void dropCat(List<String> ids);
    
    /**
     * 获取所有类别
     * @Title:gainAllCat
     * @Description:TODO(这里用一句话描述这个方法的作用)
     * @param @return 设定文件
     * @return List<Cat> 返回类型
     * @throws
     * @return
     */
    public List<Cat> gainAllCat();

}