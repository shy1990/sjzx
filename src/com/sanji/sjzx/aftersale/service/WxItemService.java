package com.sanji.sjzx.aftersale.service;

import java.util.List;

import com.sanji.sjzx.model.WxItem;

public interface WxItemService {
	public List<WxItem> gainWxItem(WxItem wxItem);

	public List<WxItem> gainWxItemList(String id);

}
