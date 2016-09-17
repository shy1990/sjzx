package com.sanji.sjzx.dict.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.dict.dao.DictMapper;
import com.sanji.sjzx.dict.service.DictService;
import com.sanji.sjzx.model.Dict;
@Service("dictService")
@Transactional(rollbackFor=Exception.class)
public class DictServiceImpl implements DictService{
	@Resource
	private DictMapper dictMapper;
	/**
	 * 获取所有选项
	 */
	public List<Dict> gainDictList() {	
		return dictMapper.gainDictList();
	}
	/**
	 * 获取制式下拉框
	 */
	public List<Dict> gainStandardList() {
		return dictMapper.gainStandardList();
	}
	/**
	 * 获取适用网络类型下拉框
	 */
	public List<Dict> gainNetSuitList() {
		return dictMapper.gainNetSuitList();
	}
}
