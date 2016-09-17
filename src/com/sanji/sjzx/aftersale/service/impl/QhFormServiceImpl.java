package com.sanji.sjzx.aftersale.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.aftersale.dao.QhFormMapper;
import com.sanji.sjzx.aftersale.dao.QhItemMapper;
import com.sanji.sjzx.aftersale.service.QhFormService;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.model.QhForm;
import com.sanji.sjzx.model.QhItem;
@Service("qhFormService")
@Transactional(rollbackFor = Exception.class)
public class QhFormServiceImpl implements QhFormService {
	@Resource
	private QhFormMapper qhFormMapper;
	@Resource
	private QhItemMapper qhItemMapper;

	public void addQhForm(QhForm qhForm, List<QhItem> itemList) {
		
		if(itemList != null && itemList.size() >0){
			qhFormMapper.addQhForm(qhForm);
			for(QhItem item : itemList){
				item.setId(ToolsUtil.getUUID());
				item.setFormId(qhForm.getId());
				qhItemMapper.addQhItrm(item);
			}
			
		}
	}

}
