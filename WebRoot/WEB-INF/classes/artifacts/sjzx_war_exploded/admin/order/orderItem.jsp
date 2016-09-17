<%@page import="com.sanji.sjzx.common.util.PathUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String basePath = PathUtil.getPath(request);
%>

 	<div align="center">
 	  <form id="order_addForm" method="post">
 	      <table class="tableForm"  style="margin-top: 50px;border: solid 1px; border-color: black;" >
 	        <tr align="center">
 	          <td  style="border: solid 1px; border-color: black;">商铺名称</td>
 	     	  <td  style="border: solid 1px; border-color: black;">商品名称/配件名称/赠品名称</td>
 	     	  <td  style="border: solid 1px; border-color: black;">制式</td>
 	     	  <td  style="border: solid 1px; border-color: black;">内存</td>
 	          <td  style="border: solid 1px; border-color: black;">品牌</td>
 	          <td  style="border: solid 1px; border-color: black;">颜色</td>
 	          <td  style="border: solid 1px; border-color: black;">单价/元</td>
 	          <td  style="border: solid 1px; border-color: black;">商品数量</td>
 	          <td  style="border: solid 1px; border-color: black;">订单备注</td>
 	          <td  style="border: solid 1px; border-color: black;">小计/元</td>
	          <!-- 
	          <td  style="border: solid 1px; border-color: black;">成交价</td>
	          <td  style="border: solid 1px; border-color: black;">折后差价</td>
	          <td  style="border: solid 1px; border-color: black;">会员折扣</td>
	          <td  style="border: solid 1px; border-color: black;">ROOT数量</td> -->
 	        </tr>
 	         <s:iterator value="#request.orderItemList" var="orderItem" status="status">
 	        <tr>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text"  value="${orderItem.shopName}" readonly="readonly" style="border: 0px;width: 160px"></td>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text"  value="${orderItem.name}" readonly="readonly" style="border: 0px;width: 260px"></td>
 	        <s:if test="%{#orderItem.targetType=='accessories' or #orderItem.targetType=='gift' or #orderItem.targetType=='point'}">
 	         <td  style="border: solid 1px; border-color: black;"><input type="text"  value="------------" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text"  value="------------" readonly="readonly" style="border: 0px;width: 80px"></td>
 	        </s:if>
 	        <s:else>
 	        <td  style="border: solid 1px; border-color: black;"><input type="text"  value="${orderItem.standard}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	        <td  style="border: solid 1px; border-color: black;"><input type="text"  value="${orderItem.storage}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	        </s:else>
 	         <s:if test="%{#orderItem.targetType=='point'}">
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="------------" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="------------" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="0.00" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="0.00" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="0.00" readonly="readonly" style="border: 0px;width: 80px"></td>
 	        </s:if>
 	        <s:else>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="${orderItem.brandName}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="${orderItem.colorName}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="${orderItem.marketbalePrice}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="${orderItem.nums}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         
 	        </s:else>
 	        <s:if test="%{#remark=='' or null == remark}">
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="------------" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="${orderItem.marketbalePrice*orderItem.nums}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         </s:if>
 	        <s:else>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="${remark}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="${orderItem.marketbalePrice*orderItem.nums}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	        </s:else>
 	       <%--  <td  style="border: solid 1px; border-color: black;"><input type="text" value="${orderItem.dealPrice}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	          <s:if test="%{#orderItem.memberlvRedceMoney!=null}">
 	          <td  style="border: solid 1px; border-color: black;"><input type="text" value="${orderItem.memberlvRedceMoney}" readonly="readonly" style="border: 0px;width: 80px"> </td>
 	         </s:if>
 	         <s:else>
 	          <td style="border: solid 1px; border-color: black;"><input type="text" value="--------" readonly="readonly" style="border: 0px;width: 80px;"> </td>
 	         </s:else>
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="${orderItem.memberlvDiscount}" readonly="readonly" style="border: 0px;width: 80px"> </td>
 	         <s:if test="%{#orderItem.targetType=='sku'}">
 	         <td  style="border: solid 1px; border-color: black;"><input type="text" value="${orderItem.rootNum}" readonly="readonly" style="border: 0px;width: 80px"> </td>
 	         </s:if>
 	         <s:else>
 	           <td  style="border: solid 1px; border-color: black;"><input type="text" value="--------" readonly="readonly" style="border: 0px;width: 80px"> </td>
 	         </s:else> --%>
 	        </tr></s:iterator>
 	         <s:if test="%{carriage !='undefined'}">
 	         <tr >
 	          <td align="center" colspan="9" style="border: solid 1px; border-color: black;">运费/元</td>
 	           <td  style="border: solid 1px; border-color: black;"><input type="text" value="${carriage}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	        </tr>
 	        </s:if>
 	         <s:else>
 	         <tr >
 	          <td align="center" colspan="9" style="border: solid 1px; border-color: black;">运费/元</td>
 	           <td  style="border: solid 1px; border-color: black;"><input type="text" value="无" readonly="readonly" style="border: 0px;width: 80px"></td>
 	        </tr>
 	         </s:else>  
 	         <tr >
 	          <td align="center" colspan="9" style="border: solid 1px; border-color: black;">总金额/元</td>
 	           <td  style="border: solid 1px; border-color: black;"><input type="text" value="${totalCost}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	        </tr>
 	        
 	         <tr >
 	         <td align="center" colspan="3" style="border: solid 1px; border-color: black;">钱包交易号</td>
 	           <td colspan="2" style="border: solid 1px; border-color: black;">${walletPayNo}</td>
 	          <td align="center" colspan="4" style="border: solid 1px; border-color: black;">钱包支付金额/元</td>
 	           <td  style="border: solid 1px; border-color: black;"><input type="text" value="${walletNum}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	        </tr>
 	          <tr >
 	         <td align="center" colspan="3" style="border: solid 1px; border-color: black;">红包交易号</td>
 	           <td colspan="2" style="border: solid 1px; border-color: black;">${hbNo}</td>
 	          <td align="center" colspan="4" style="border: solid 1px; border-color: black;">红包支付金额/元</td>
 	           <td  style="border: solid 1px; border-color: black;"><input type="text" value="${hbNum}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	        </tr>
 	        <tr >
 	          <td align="center" colspan="9" style="border: solid 1px; border-color: black;">实际支付金额/元</td>
 	           <td  style="border: solid 1px; border-color: black;"><input type="text" value="${actualPayNum}" readonly="readonly" style="border: 0px;width: 80px"></td>
 	        </tr>
 	      </table>
 	      
 	  </form>
 	</div>

