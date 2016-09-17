<%@page import="com.sanji.sjzx.common.util.PathUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String basePath = PathUtil.getPath(request);
%>

 	<div align="center">
 	  <form id="qhForm_addForm" method="post">
 	     <table class="tableForm" style="margin-left: 10px;margin-top: 15px">
 	     	<tr>
 	     	  <th>申请人：</th><input type="hidden" name="thFormId" value="${id}">
 	     	  <td colspan="3"><input name="userName" class="easyui-validatebox"
						data-options="required:true" value="${member.username}" style="width:230px" placeholder="请输入申请人名称"/>
 	     	    
 	     	  </td>
 	     	</tr>
 	     	<tr>
 	     	  <th>地址：</th>
 	     	  <td colspan="3"><input name="address" class="easyui-validatebox"
						data-options="required:true" value="${member.pname}${member.cname}${member.aname}" style="width:230px" placeholder="请输入申请人地址"/>
 	     	    
 	     	  </td>
 	     	</tr>
 	     </table >
 	     <hr>
 	     <div> <s:iterator value="#request.thItemList" var="thItem" status="status">
 	     	<table class="tableItemForm" id="qhItemTable" style="margin-left: 10px;margin-top: 15px">
	 	     	<tr>
	 	     	  <th>商品名称：</th>
	 	     	  <td colspan="3"><input name="itemList[${status.index}].name" class="easyui-validatebox"
							data-options="required:true" value="${thItem.name}" style="width:230px" />
	 	     	    
	 	     	  </td>
	 	     	</tr>
	 	     	<tr>
	 	     	  <th>商品数量：</th>
	 	     	  <td colspan="3"><input name="itemList[${status.index}].quantity" class="easyui-validatebox"
							data-options="required:true" value="${thItem.quantity}" style="width:230px" />
	 	     	    
	 	     	  </td>
	 	     	</tr>
	 	     	<tr>
	 	     	  <th>备注：</th>
	 	     	  <td colspan="3"><input name="itemList[${status.index}].remark"
							 value="${thItem.remark}" style="width:230px" />
	 	     	    
	 	     	  </td>
	 	     	</tr>
 	     </table>
 	     <!-- <table>
 	          <tr>
 	            <td><input type="button" id="qhItem_add_on"  value="继续添加" /> </td>
 	             <td colspan="3"><input type="button" id="qhItem_add_cancel"  value="取消添加" /></td>
 	          </tr>
 	     </table> -->
 	     </s:iterator>
 	  </form>
 	</div>

