<%@page import="com.sanji.sjzx.common.util.PathUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String basePath = PathUtil.getPath(request);
%>

 	<div align="center">
 	     
 	  <form id="order_addForm" method="post">
 	     <table class="tableForm" style="width:380px;margin-right: 10px; margin-left: 10px;margin-top: 15px;border: solid 1px; border-color: black;">
 	       <tr>
 	     	  <td style="border: solid 1px; border-color: black;width: 130px">申请人名称：</td>
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="text" id="username" value="${thForm.username}" readonly="readonly" style="border: 0px"></td>
 	     	</tr>
 	     	<tr>
 	     	  <td style="border: solid 1px; border-color: black;">联系方式：</td>
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="text" value="${thForm.mobile}" readonly="readonly" style="border: 0px"></td>
 	     	</tr>
 	     	
 	     	<tr>
 	     	  <td style="border: solid 1px; border-color: black;">物流状态：</td>
 	     	  <c:if test="${thForm.shipStatus == 0}">
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="text" value="未发货" readonly="readonly" style="border: 0px"></td>
 	     	  </c:if>
 	     	  <c:if test="${thForm.shipStatus == 1}">
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="text" value="已发货" readonly="readonly" style="border: 0px"></td>
 	     	  </c:if>
 	     	  <c:if test="${thForm.shipStatus == 3}">
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="text" value="已收货" readonly="readonly" style="border: 0px"></td>
 	     	  </c:if>
 	     	</tr>
 	     	<tr>
 	     	  <td style="border: solid 1px; border-color: black;">管易物流状态：</td>
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="text" value="${GyShipStatus}" readonly="readonly" style="border: 0px"></td>
 	     	</tr>
 	     	<tr>
 	     	  <td style="border: solid 1px; border-color: black;">申请原因：</td>
 	     	  <td colspan="3" style="border: solid 1px; border-color: black;"><input type="t" value="${thForm.remark}" readonly="readonly" style="border: 0px"></td>
 	     	</tr>
 	     </table><input type="hidden" id="id" value="${thForm.id}">
 	     <hr>
 	     <table class="tableForm" style="width:380px;margin-right: 10px;margin-left: 10px;margin-top: 15px;border: solid 1px; border-color: black;" >
 	        <s:iterator value="#request.thItemList" var="thItem" status="status">
 	        <tr>
 	     	  <td style="border: solid 1px; border-color: black; width: 130px">商品名称：</td>
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

