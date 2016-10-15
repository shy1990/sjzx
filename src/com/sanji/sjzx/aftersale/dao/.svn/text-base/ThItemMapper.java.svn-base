package com.sanji.sjzx.aftersale.dao;

import java.util.List;

import com.sanji.sjzx.model.ThItem;


public interface ThItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(ThItem record);

    int insertSelective(ThItem record);

    ThItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ThItem record);

    int updateByPrimaryKey(ThItem record);

	public List<ThItem> gainThItemByFormId(String id);

	public List<String> gainOrderItemIdsByFormId(String id);
}