<%@page import="com.sanji.sjzx.common.util.PathUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String basePath = PathUtil.getPath(request);
%>

 	<div align="center">
 	  <form id="wxForm_addForm" method="post">
 	     <table class="tableForm" style="margin-left: 10px;margin-top: 15px">
 	     	<tr><input type="hidden" name="id" value="${id}">
 	     	  <th>拒绝原因：</th>
 	     	  <td colspan="3"><input name="abortReason" class="easyui-validatebox"
						data-options="required:true"  style="width:150px;height:40px;" placeholder="请输入原因"/>
 	     	    
 	     	  </td>
 	     	</tr>
 	     </table >
 	  </form>
 	</div>

