<%@page import="com.sanji.sjzx.common.util.PathUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String basePath = PathUtil.getPath(request);
%>
<script type="text/javascript">
	$(function(){
		$.extend($.fn.validatebox.defaults.rules, {  
        selectValueRequired: {  
        validator: function (value, param) {  
            if (value == "" || value.indexOf('选择') >= 0 || value.indexOf('全部') >= 0) { return false; }  
            else { return true; }  
        },  
        message: '该下拉框为必选项'  
    }  
});  
	});
</script>

 	<div align="center">
 	  <form id="goodsHot_addForm" method="post">
 	     <table class="tableForm" style="margin-left: 10px;margin-top: 15px">
 	     	<tr>
 	     	  <th>商品名称：</th>
 	     	  <td colspan="3" id="goodsName">
 	     	  <input type="hidden" name="targetId" value="${requestScope.goodsHot.id}"/>
 	     	  <span>${requestScope.goodsHot.name}</span>
 	     	  </td>
 	     	</tr>
 	     	<tr>
 	     	  <th>商品排名：</th>
 	     	  <td colspan="3">
 	     	  	<input name="num" class="easyui-numberspinner"
						data-options="min:1,max:999,editable:false,required:true,missingMessage:'请选择菜单排序'" value="${requestScope.num}" size="32" />
 	     	  </td>
 	     	</tr>
 	     	<tr>
 	     		<td><input type="hidden" name="goodsType" value="${requestScope.goodsHot.catName =='手机'?'sku':'accessories'}"/></td>
 	     	</tr>	
 	     	<tr>
 	     	  <th>排名类型：</th>
 	     	  <td colspan="3">
 	     	  	<select class="easyui-combobox " required="true" validtype="selectValueRequired" name="hotType">
 	     	  		 <c:if test="${requestScope.goodsHot.catName =='手机'}">
 	     	  		 	<option  value="">--请选择--</option>    
						<option  value="day">日排行</option>  
						<option  value="week">周排行</option>  
						<option  value="month">月排行</option>  
						<option  value="year">年排行</option>
						<option  value="brand">品牌排行</option>
						<option value="4G">4G手机排行</option> 
						<option value="lt3G">联通3G手机排行</option> 
						<option value="yd3G">移动3G手机排行</option>
						<option value="dx3G">电信3G手机排行</option>
 	     	  		 </c:if>
 	     	  		 <c:if test="${requestScope.goodsHot.catName !='手机'}">
 	     	  		  	<option  value="">--请选择--</option>    
						<option  value="day">日排行</option>  
						<option  value="week">周排行</option>  
						<option  value="month">月排行</option>  
						<option  value="year">年排行</option>
 	     	  		 </c:if>
				</select>
 	     	  </td>
 	     	</tr>
 	     </table>
 	  </form>
 	</div>

