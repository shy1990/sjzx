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
		var skuStockFlag = false;
	 	var skuStockValidObj = $(stockObj).next();
	 	var skuStockValue = $(stockObj).val();
		
		if (skuStockValue == '') {
			$(skuStockValidObj).text("请输入单品库存");
			$(skuStockValidObj).css("color", "#f00");
			return skuStockFlag;
		}
		if(!stockReg.test(skuStockValue)){
			$(skuStockValidObj).text("单品库存请输入正整数");
			$(skuStockValidObj).css("color", "#f00");
			return skuStockFlag;
		}
		if(skuStockValue<0){
			$(skuStockValidObj).text("单品库存请输入正整数");
			$(skuStockValidObj).css("color", "#f00");
			return skuStockFlag;
		}
		
		$(skuStockValidObj).text("ok");
		$(skuStockValidObj).css("color", "#00f");
		skuStockFlag = true;
		return skuStockFlag;
	}
	//验证单价数据
	function validPrice(skuPriceObj){
		var skuPriceFlag = false;
	 	var skuPriceValidObj = $(skuPriceObj).next();
	 	var skuPriceValue = $(skuPriceObj).val();
	 		
	 	var reg = /^-?(0|[1-9]\d*)(\.\d{1,2})?$/;
		if (skuPriceValue == '') {
			$(skuPriceValidObj).text("请输入单品价格");
			$(skuPriceValidObj).css("color", "#f00");
			return skuPriceFlag;
		}
		if(!reg.test(skuPriceValue)){
			$(skuPriceValidObj).text("单品价格请输入数字，最多保留两位小数");
			$(skuPriceValidObj).css("color", "#f00");
			return skuPriceFlag;
		}
		if(skuPriceValue<0){
			$(skuPriceValidObj).text("单品价格请输入正数，最多保留两位小数");
			$(skuPriceValidObj).css("color", "#f00");
			return skuPriceFlag;
		}
		
		$(skuPriceValidObj).text("ok");
		$(skuPriceValidObj).css("color", "#00f");
		skuPriceFlag = true;
		return skuPriceFlag;
	}
	//单价、库存总体控制
	function validPreTable(){
 		var tableNum = $("#admin_edit_priceandstock").find("table").length;//table的个数
		for(var t=0;t<tableNum;t++){
			var price = 'list[' + t + '].price';
			var stock = 'list[' + t + '].stock';
			var priceObj = $("input[name='" + price + "']");
			var stockObj = $("input[name='" + stock + "']");
			if(validStock(stockObj)==false){
				$(stockObj).focus();
				return false;
			}
			if(validPrice(priceObj)==false){
				$(priceObj).focus();
				return false;
			}
		}
	}
	
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false" id="admin_edit_priceandstock">
		<form id="admin_sku_editForm" method="post">
			<c:forEach items="${list}" var="gs" varStatus="status">	
				<table class="tableForm" style="margin-left: 10px;margin-top: 15px">
					<tr>
						<th></th>
						<td><input name="list[${status.index}].goodsId" type="hidden" style="width:60px" value="${gs.goodsId}"/></td>
						<th></th>
						<td><input name="list[${status.index}].id" type="hidden" style="width:60px" value="${gs.id}"/></td>
						<th>规格代码: </th>
						<td><input id="skuNum" name="list[${status.index}].skuNum" onblur="checkSkuNum(this)" class="easyui-validatebox" data-options="required:true" style="width:60px;background:#ccc" value="${gs.skuNum}" readonly="readonly"/><div class="validate_msg_short" id="skuNumMsg"></div></td>
						<th>库存:</th>
						<td><input name="list[${status.index}].stock" onblur="validStock(this)"  class="easyui-validatebox" data-options="required:true" style="width:60px" value="${gs.stock}"/><div class="validate_msg_short" id="skuStock"></div>
						<th>单价:</th>
						<td><input id="skuPricesb" name="list[${status.index}].price" onblur="validPrice(this)" class="easyui-validatebox" data-options="required:true" style="width:60px" value="${gs.price}"/><div class="validate_msg_short" id="skuPrice"></div></td>
						<th>颜色:</th>
						<td>						
						<span id="span_color_m">
							<input name="list[${status.index}].colorId" class="easyui-combobox" value="${gs.colorId}"
							data-options="url:'goods/goodsAction!gainSkuColorName.action',valueField:'colorId',textField:'colorName',editable:false,multiple:false"style="width:80px"/>
						</span>
						</td>
					</tr>
				</table>
			</c:forEach>
		</form>
	</div>
</div>
