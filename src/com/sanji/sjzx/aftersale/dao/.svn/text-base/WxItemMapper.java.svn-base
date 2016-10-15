package com.sanji.sjzx.aftersale.dao;

import java.util.List;

import com.sanji.sjzx.model.ThItem;
import com.sanji.sjzx.model.WxItem;


public interface WxItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(WxItem record);

    int insertSelective(WxItem record);

    WxItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WxItem record);

    int updateByPrimaryKey(WxItem record);
    
    public List<WxItem> gainWxItemByFormId(String id);
}