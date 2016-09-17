<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

	<div align="center">
		<form id="label_editForm" method="post">
			<input name="id" readonly="readonly" type="hidden"/>
			<table class="tableForm" style="margin-left: 10px;margin-top: 15px;" >
				<tr>
					<th>标签名称：</th>
					<td colspan="3"><input name="name" class="easyui-validatebox"
						data-options="required:true" style="width:230px"placeholder="请输入标签名称"/></td>
				</tr>
				<tr>
 	     	  		<th>标签备注：</th>
 	     	 		 <td colspan="3"><input name="remark" class="easyui-validatebox" 
 	     	  			data-options="required:true" style="width:230px" placeholder="请输入标签备注">
 	     			 </td>
 	     		</tr>
			</table>
		</form>
	</div>
