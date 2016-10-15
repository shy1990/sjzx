<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

	<div align="center">
		<form id="order_editForm" method="post">
			<input name="id" readonly="readonly" type="hidden"/>
			<table class="tableForm" style="margin-left: 10px;margin-top: 15px;" >
				<tr>
					<th>实际支付金额：</th>
					<td colspan="3"><input name="actualPayNum" class="easyui-validatebox"
						data-options="required:true" style="width:150px;height:25px;"/></td>
				</tr>
				<tr>
 	     	  		<th>备注：</th>
 	     	 		 <td colspan="3"><input name="remark" class="easyui-validatebox" 
 	     	  			data-options="required:true" style="width:230px;height:100px">
 	     			 </td>
 	     		</tr>
			</table>
		</form>
	</div>
