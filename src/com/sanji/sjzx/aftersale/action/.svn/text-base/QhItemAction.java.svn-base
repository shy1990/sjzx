package com.sanji.sjzx.aftersale.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.sanji.sjzx.aftersale.service.QhItemService;
import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.model.QhItem;
@Namespace("/qhItem")
@Action(value="qhItemAction", results={
		@Result(name = "showItem", location = "/admin/qhForm/qhItem.jsp")
})
public class QhItemAction extends BaseAction implements ModelDriven<QhItem> {
	
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(QhItemAction.class);

	private QhItem qhitem = new QhItem();
	
	@Resource
	private QhItemService qhItemService;
	/**
	 * 显示取货单明细
	* @Title: toAddWxForm
	* @Description: TODO(显示取货单明细)
	* @param @return    设定文件
	* @return String   返回类型
	* @author songbaozhen
	 */
	public 	String showQhItem(){
		List<QhItem> itemlist = qhItemService.gainQhItemList(qhitem);
		request.setAttribute("qhItemList", itemlist);
		request.setAttribute("formId",qhitem.getId());
		return "showItem";
	}

	public QhItem getModel() {
		// TODO Auto-generated method stub
		return qhitem;
	}

}
