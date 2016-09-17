package com.sanji.sjzx.aftersale.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.aftersale.dao.ThItemMapper;
import com.sanji.sjzx.aftersale.service.ThItemService;
import com.sanji.sjzx.members.dao.MembersMapper;
import com.sanji.sjzx.model.Members;
import com.sanji.sjzx.model.ThItem;
@Service("thItemService")
@Transactional(rollbackFor = Exception.class)
public class ThItemServiceImpl implements ThItemService {

	@Resource
	private ThItemMapper thItemMapper;

	public List<ThItem> gainThItem(ThItem thItem) {
		// TODO Auto-generated method stub
		 List<ThItem>	itemList = thItemMapper.gainThItemByFormId(thItem.getFormId());
		if(itemList != null && itemList.size() > 0){
			return itemList;
		}
		return null;
	}

	public List<ThItem> gainThItemList(String id) {
		// TODO Auto-generated method stub
		 List<ThItem>	itemList = thItemMapper.gainThItemByFormId(id);
		if(itemList != null && itemList.size() > 0){
			return itemList;
		}
		return null;
	}
}
