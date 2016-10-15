<%@page import="com.sanji.sjzx.common.util.PathUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String basePath = PathUtil.getPath(request);
%>

 	<div align="center">
 	     
 	  <form id="qhItem_addForm" method="post">
 	     <input type="hidden" id="id" name="id" value="${formId}">
 	     <table class="tableForm" style="margin-left: 10px;margin-top: 15px;border: solid 1px; border-color: black;" >
 	        <s:iterator value="#request.qhItemList" var="thItem" status="status">
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

