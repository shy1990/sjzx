package com.sanji.sjzx.aftersale.service;

import java.util.List;

import com.sanji.sjzx.model.ThForm;
import com.sanji.sjzx.pojo.DataGrid;

public interface ThFormService {

	public DataGrid gainThFormInitList(ThForm thForm);

	public void updateThItem(ThForm thForm);

	public ThForm gainThForm(String formId);

	public DataGrid gainThFormList(ThForm thForm);

	public ThForm gainUserNameAndMobileById(String formId);

	public void updateThForm(ThForm thForm);

	public ThForm gainThForm(ThForm thForm);

	public void updateStatus(ThForm thForm);

	public boolean existOrderShipStatus(ThForm thForm);

	public String gainThFormForOrderNumById(String formId);



}
