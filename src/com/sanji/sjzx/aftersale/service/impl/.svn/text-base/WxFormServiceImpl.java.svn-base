package com.sanji.sjzx.aftersale.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.sjzx.aftersale.dao.WxFormMapper;
import com.sanji.sjzx.aftersale.service.WxFormService;
import com.sanji.sjzx.model.WxForm;
import com.sanji.sjzx.pojo.DataGrid;
@Service("wxFormService")
@Transactional(rollbackFor = Exception.class)
public class WxFormServiceImpl implements WxFormService {

	@Resource
	private WxFormMapper WxFormMapper;

	public DataGrid gainWxFormInitList(WxForm WxForm) {
		DataGrid j = new DataGrid();
		j.setRows(WxFormMapper.gainWxFormInitList(WxForm));
		j.setTotal(WxFormMapper.gainWxFormInitCount(WxForm));
		return j;
	}

	public void updateWxItem(WxForm WxForm) {
		WxFormMapper.updateByPrimaryKeySelective(WxForm);
		
	}

	public WxForm gainWxForm(String formId) {
		WxForm WxForm = WxFormMapper.gainWxFormById(formId);
			return WxForm;
	}

	public DataGrid gainWxFormList(String readUserId) {
		DataGrid j = new DataGrid();
		j.setRows(WxFormMapper.gainWxFormList(readUserId));
		j.setTotal(WxFormMapper.gainWxFormCount(readUserId));
		return j;
	}

	public WxForm gainUserNameAndMobileById(String formId) {
		WxForm WxForm = WxFormMapper.gainUserNameAndModbileById(formId);
		if(WxForm != null && !"".equals(WxForm)){
			return WxForm;
		}
		return null;
	}

	public void updateWxForm(WxForm WxForm) {
		WxFormMapper.updateWxForm(WxForm);
	}
}
