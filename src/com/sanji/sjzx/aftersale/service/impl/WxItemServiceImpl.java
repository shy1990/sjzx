package com.sanji.sjzx.aftersale.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.aftersale.dao.WxItemMapper;
import com.sanji.sjzx.aftersale.service.WxItemService;
import com.sanji.sjzx.model.WxItem;

@Service("wxItemService")
@Transactional(rollbackFor = Exception.class)
public class WxItemServiceImpl  implements	WxItemService {

	@Resource
	private  WxItemMapper wxItemMapper;

	public List<WxItem> gainWxItem(WxItem wxItem) {
		// TODO Auto-generated method stub
		 List<WxItem>	itemList = wxItemMapper.gainWxItemByFormId(wxItem.getFormId());
		if(itemList != null && itemList.size() > 0){
			return itemList;
		}
		return null;
	}

	public List<WxItem> gainWxItemList(String id) {
		// TODO Auto-generated method stub
		 List<WxItem>	itemList = wxItemMapper.gainWxItemByFormId(id);
		if(itemList != null && itemList.size() > 0){
			return itemList;
		}
		return null;
	}

}
