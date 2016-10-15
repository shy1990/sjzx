package com.sanji.sjzx.aftersale.dao;

import java.util.List;

import com.sanji.sjzx.model.WxForm;


public interface WxFormMapper {
    int deleteByPrimaryKey(String id);

    int insert(WxForm record);

    int insertSelective(WxForm record);

    WxForm selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WxForm record);

    int updateByPrimaryKey(WxForm record);

	public List gainWxFormInitList(WxForm wxForm);
	
	public List gainWxFormList(String readUserId);

	public Long gainWxFormCount(String readUserId);

	public void updateThItem(WxForm wxForm);

	public WxForm gainWxFormById(String id);

	public Long gainWxFormInitCount(WxForm wxForm);

	public WxForm gainUserNameAndModbileById(String id);

	public void updateWxForm(WxForm wxForm);

}