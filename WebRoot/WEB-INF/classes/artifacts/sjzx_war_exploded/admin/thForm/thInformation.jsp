<%@page import="com.sanji.sjzx.common.util.PathUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String basePath = PathUtil.getPath(request);
%>

 	<div align="center">
 	     
 	  <form id="order_addForm" method="post">
 	     <table class="tableForm" style="margin-left: 10px;margin-top: 15px;border: solid 1px; border-color: black;">
 	       <tr>
 	     	  <td style="border: solid 1px; border-color: black;">申请人名称：</td>
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="text" id="username" value="${member.username}" readonly="readonly" style="border: 0px"></td>
 	     	</tr>
 	     	<tr>
 	     	  <td style="border: solid 1px; border-color: black;">联系方式：</td>
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="text" value="${member.mobile}" readonly="readonly" style="border: 0px"></td>
 	     	</tr>
 	     </table><input type="hidden" id="id" value="${member.id}">
 	     <hr>
 	     <table class="tableForm" style="margin-left: 10px;margin-top: 15px;border: solid 1px; border-color: black;" >
 	        <s:iterator value="#request.thItemList" var="thItem" status="status">
 	        <tr>
 	     	  <td style="border: solid 1px; border-color: black;">商品名称：</td>
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="text" value="${thItem.name}" readonly="readonly" style="border: 0px"></td>
 	     	</tr>
 	     	<tr>
 	     	  <td style="border: solid 1px; border-color: black;">数量：</td>
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="text" value="${thItem.quantity}" readonly="readonly" style="border: 0px;"></td>
 	     	</tr>
 	     	<tr>
 	     	  <td style="border: solid 1px; border-color: black;">备注：</td>
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="text" value="${thItem.remark}" readonly="readonly" style="border: 0px;"></td>
 	     	</tr>
 	     	</s:iterator>
 	     	
 	     </table>
 	  </form>
 	</div>

