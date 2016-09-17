<%@ page import="com.sanji.sjzx.common.util.PathUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String basePath = PathUtil.getPath(request);
%>

 	<div align="center">
 	  <form id="thForm_addForm" method="post">
 	     <table class="tableForm" style="margin-left: 10px;margin-top: 15px">
 	     	</tr>
 	     	<th>物流单号：</th>
 	     	  <td colspan="3">
 	     	    <select name="ordernum">
 	     	       <s:iterator  value="#request.dlyCorpsList" var="dlyCorps" status="status">
 	     	        <option  value="${dlyCorps.ordernum}">${dlyCorps.name}</option>
 	     	       </s:iterator>
 	     	    </select>—<input name="expressNumber" class="easyui-validatebox"
						data-options="required:true"  style="width:150px;" placeholder="请输入物流单号"/>
 	     	  </td>
 	     	</tr>
 	     	<tr><input type="hidden" name="id" value="${id}">
 	     	  <th>拒绝原因：</th>
 	     	  <td colspan="3"><textarea name="abortReason" class="easyui-validatebox"
						data-options="required:true"  style="width:260px;height:80px;" placeholder="请输入原因"/>
 	     	    
 	     	  </td>
 	     </table >
 	  </form>
 	</div>

