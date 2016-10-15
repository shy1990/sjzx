<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String basePath = PathUtil.getPath(request);
%>
<script type="text/javascript">
	//验证库存数据
 	function validStock(stockObj){
		var stockReg=/^\d+$/;
		var stockFlag = false;
	 	var stockValidObj = $(stockObj).next();
	 	var stockValue = $(stockObj).val();
		
		if (stockValue == '') {
			$(stockValidObj).text("库存不能为空");
			$(stockValidObj).css("color", "#f00");
			return stockFlag;
		}
		if(!stockReg.test(stockValue)){
			$(stockValidObj).text("库存请输入正整数");
			$(stockValidObj).css("color", "#f00");
			return stockFlag;
		}
		if(stockValue<0){
			$(stockValidObj).text("库存请输入正整数");
			$(stockValidObj).css("color", "#f00");
			return stockFlag;
		}
		
		$(stockValidObj).text("ok");
		$(stockValidObj).css("color", "#00f");
		stockFlag = true;
		return stockFlag;
	} 
	//验证单价数据
	function validPrice(priceObj){
		var priceFlag = false;
	 	var priceValidObj = $(priceObj).next();
	 	var priceValue = $(priceObj).val();
	 		
	 	var reg = /^-?(0|[1-9]\d*)(\.\d{1,2})?$/;
		if (priceValue == '') {
			$(priceValidObj).text("请输入单价");
			$(priceValidObj).css("color", "#f00");
			return priceFlag;
		}
		if(!reg.test(priceValue)){
			$(priceValidObj).text("单价请输入数字，最多保留两位小数");
			$(priceValidObj).css("color", "#f00");
			return priceFlag;
		}
		if(priceValue<0){
			$(priceValidObj).text("单价请输入正数，最多保留两位小数");
			$(priceValidObj).css("color", "#f00");
			return priceFlag;
		}
		
		$(priceValidObj).text("ok");
		$(priceValidObj).css("color", "#00f");
		priceFlag = true;
		return priceFlag;
	}
	function validPreTable(){
		var stockObj = $("#stock");
		var priceObj = $("#price");
		if(validStock(stockObj)==false){
			$(stockObj).focus();
			return false;
		}
		if(validPrice(priceObj)==false){
			$(priceObj).focus();
			return false;
		}
	}
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
		<form id="admin_acc_recover_editForm" method="post">
				<table class="tableForm" style="margin-left: 20px;margin-top: 15px">
					<tr>
						<th></th>
						<td><input name="id" type="hidden" style="width:120px" value="${a.id}"/></td>
					</tr>
					<tr>
						<th>配件名称:</th>
						<td><input name="name" class="easyui-validatebox" data-options="required:true" style="width:120px;background:#ccc;" value="${a.name}" readonly="readonly"/></td>
					</tr>
					<tr>						
						<th>商品代码:</th>
						<td><input id="accNum" name="accessoriesNum" class="easyui-validatebox" data-options="required:true" style="width:120px;background:#ccc;" value="${a.accessoriesNum}" readonly="readonly"/></td>
					</tr>
					<tr>
						<th>配件库存:</th>
						<td><input id="stock" name="stock" onblur="validStock(this)"  class="easyui-validatebox" data-options="required:true" style="width:120px" value="${a.stock}"/><div></div></td>
					</tr>
					<tr>
						<th>配件单价:</th>
						<td><input id="price" name="price" onblur="validPrice(this)" class="easyui-validatebox" data-options="required:true" style="width:120px" value="${a.price}"/><div></div></td>
					</tr>
					<tr>
						<th>配件颜色:</th>
						<td>
							<input id="colorId" name="colorId" class="easyui-combobox" value="${a.colorId}"
							data-options="url:'acc/accAction!gainAllColor.action',valueField:'colorId',textField:'colorName',editable:false,multiple:false"style="width:120px"/>
						</td>
					</tr>
				</table>
		</form>
	</div>
</div>
