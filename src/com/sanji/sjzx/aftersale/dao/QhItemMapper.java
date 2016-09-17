package com.sanji.sjzx.aftersale.dao;

import java.util.List;

import com.sanji.sjzx.model.QhForm;
import com.sanji.sjzx.model.QhItem;


public interface QhItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(QhItem record);

    int insertSelective(QhItem record);

    QhItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(QhItem record);

    int updateByPrimaryKey(QhItem record);

	public void addQhItrm(QhItem item);

	public List<QhItem> gainQhItemList(QhItem qhItem);
}