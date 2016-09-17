package com.sanji.sjzx.aftersale.service;

import com.sanji.sjzx.model.WxForm;
import com.sanji.sjzx.pojo.DataGrid;

public interface WxFormService {
	

	public DataGrid gainWxFormInitList(WxForm wxForm);

	public void updateWxItem(WxForm wxForm);

	public WxForm gainWxForm(String formId);

	public DataGrid gainWxFormList(String readUserId);

	public WxForm gainUserNameAndMobileById(String formId);

	public void updateWxForm(WxForm wxForm);


}
