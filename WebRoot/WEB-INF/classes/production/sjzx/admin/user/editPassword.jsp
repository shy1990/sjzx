<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String basePath = PathUtil.getPath(request);
%>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
		<form id="pwd_editForm" method="post">
			<input name="id" readonly="readonly" type="hidden"/>
			<table class="tableForm" style="margin-left: 70px;margin-top: 15px">
				<tr>
					<th>原始密码：</th>
					<td colspan="3"><input type="password" name="oldPassword" id="oldPassword" class="easyui-validatebox"
						data-options="required:true" style="width:160px"/></td>
				</tr>
				<tr>
					<th>新密码：</th>
					<td><input type="password" name="rePassword" class="easyui-validatebox"
						data-options="required:true" style="width:160px"/></td>
				</tr>
				<tr>
					<th>再次输入新密码：</th>
					<td><input type="password" name="repasswordtwo" class="easyui-validatebox"
						data-options="required:true,validType:'rePwd[\'#pwd_editForm input[name=rePassword]\']'" style="width:160px"/></td>
				</tr>
				
			</table>
		</form>
	</div>
</div>
