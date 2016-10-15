<%@page import="com.sanji.sjzx.common.util.PathUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String basePath = PathUtil.getPath(request);
%>


 	<div align="center">
 	  <form id="dlyCorp_addForm" method="post">
 	     <table class="tableForm" style="margin-left: 10px;margin-top: 15px">
 	     	<tr>
 	     	  <th>物流公司名称：</th>
 	     	  <td colspan="3"><input name="name" class="easyui-validatebox"
						data-options="required:true" style="width:230px" placeholder="请输入物流公司名称"/>
 	     	    
 	     	  </td>
 	     	</tr>
 	     	<tr>
 	     	  <th>物流公司代码：</th>
 	     	  <td colspan="3"><input name="type" class="easyui-validatebox" 
 	     	  			data-options="required:true" style="width:230px" placeholder="请输入物流公司代码">
 	     	  </td>
 	     	</tr>	
 	     	<tr>
 	     	<th>物流公司排序：</th>
			  <td><input name="ordernum" class="easyui-numberspinner"
						data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择菜单排序'" value="${dlyCorp.ordernum}" size="43" />
			  </td>
 	     	</tr>
 	     	<tr>
 	     	  <th>物流公司网址：</th>
 	     	  <td colspan="3"><input name="website" class="easyui-validatebox"
 	     	  			data-options="required:true" style="width:230px;height:29px;" placeholder="请输入物流公司网址">
 	     	  </td>
 	     	</tr>
 	     </table>
 	  </form>
 	</div>

