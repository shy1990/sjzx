package com.sanji.sjzx.aftersale.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.aftersale.dao.QhItemMapper;
import com.sanji.sjzx.aftersale.service.QhItemService;
import com.sanji.sjzx.model.QhItem;
@Service("qhItemService")
@Transactional(rollbackFor = Exception.class)
public class QhItemServiceImpl implements QhItemService {

	@Resource
	private QhItemMapper qhItemMapper;

	public List<QhItem> gainQhItemList(QhItem qhItem) {
		List<QhItem> qhItemList = qhItemMapper.gainQhItemList(qhItem);
		if(qhItemList != null && !"".equals(qhItemList)){
			return qhItemList;
		}
		return null;
	}
	
	
}
