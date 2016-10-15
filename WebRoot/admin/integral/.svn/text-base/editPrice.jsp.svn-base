<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String basePath = PathUtil.getPath(request);
%>
<script type="text/javascript">
	/**
	 * 校验价格
	 */
 	function validPrice(){
		var f = false;
		var price = $("#price").val();
	 		
	 	var reg = /^-?(0|[1-9]\d*)(\.\d{1,2})?$/;
		if (price == null || price == "" || price == undefined) {
			$("#priceMsg").text("请输入价格");
			$("#priceMsg").css("color", "#f00");
			return f;
		}
		
		if(!reg.test(price)){
			$("#priceMsg").text("请输入数字，最多保留两位小数");
			$("#priceMsg").css("color", "#f00");
			return f;
		}
		
		if(price<0){
			$("#priceMsg").text("请输入正数，最多保留两位小数");
			$("#priceMsg").css("color", "#f00");
			return f;
		}
		
		$("#priceMsg").text("ok");
		$("#priceMsg").css("color", "#00f");
		f = true;
		return f;
	}
	/**
 	 * 校验库存
 	 */ 
 	function validStock(){
 		var f = false;
 		var stock = $("#stock").val();
 		var reg=/^(0|[1-9][0-9]*)$/ ; 
 		if(stock == null || stock == "" || stock == undefined){
 			$("#stockMsg").text("库存不能为空");
 			$("#stockMsg").css("color","#f00");
 			f = false;
 		}else{
 			if(!reg.test(stock)){
 				$("#stockMsg").text("请输入正整数");
				$("#stockMsg").css("color","#f00");
				f=false;
				return f;
 			}else if(stock<0){
 				$("#stockMsg").text("请输入正整数");
				$("#stockMsg").css("color","#f00");
				f=false;
				return f;
 			}else{
 				$("#stockMsg").text("ok");
				$("#stockMsg").css("color","#00f");
				f = true;
				return f;
 			}
 		}
  		return f;
 	}
 	
 	//对价格、库存总体控制
 	function validPreTable(){
 		if(validPrice()==false){
 			$("#price").focus();
 			return false;
		}
		if(validStock()==false){
			$("#stock").focus();
 			return false;
		}
 	}
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
		<form id="admin_integral_recover_editForm" method="post">
			<table class="tableForm" style="margin-left: 20px;margin-top: 15px">
				<tr>
					<th></th>
					<td><input type="hidden" id="id" name="id"/></td>
				</tr>
				<tr>	
					<th>积分商品名称：</th>
					<td><input id="name" name="name" class="easyui-validatebox" data-options="required:true" style="width:160px;background:#ccc;" readonly="readonly"/></td>
				</tr>
				<tr>	
					<th>商品代码：</th>
					<td>
					<input id="integralCode" name="integralCode" class="easyui-validatebox" data-options="required:true" style="width:160px;background:#ccc;" readonly="readonly"/>
					</td>
				</tr>
				<tr>	
					<th>规格代码：</th>
					<td>
					<input id="specCode" name="specCode" class="easyui-validatebox" data-options="required:true" style="width:160px;background:#ccc;" readonly="readonly"/>
					</td>
				</tr>
				<tr>	
					<th>价格：</th>
					<td><input id="price" name="price" style="width:160px" class="easyui-validatebox" data-options="required:true" onblur="validPrice();"/><span id="priceMsg"></span></td>
				</tr>
				<tr>
					<th>库存：</th>
					<td><input id="stock" name="stock" style="width:160px" class="easyui-validatebox" data-options="required:true" onblur="validStock();"/><span id="stockMsg"></span></td>
				</tr>
			</table>
		</form>
	</div>
</div>
