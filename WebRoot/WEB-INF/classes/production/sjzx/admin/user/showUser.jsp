<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String basePath = PathUtil.getPath(request);
%>
<script type="text/javascript">
	$(function() {
		$('#admin_role_show_combobox').combogrid({
			url : 'role/roleAction!gainRoleListForCombobox.action',
			panelWidth : 450,
			panelHeight : 200,
			required: true,
			idField : 'roleId',
			textField : 'name',
			nowrap : false,
			fitColumns : true,
			editable : false,
			rownumbers : true,
			mode : 'remote',
			delay : 500,
			pagination : true,
			pageSize : 5,
			pageList : [ 5,10,15,20 ],
			columns : [ [ {
				field : 'roleId',
				title : '编号',
				width : 150,
				hidden : true
			}, {
				field : 'name',
				title : '角色名称',
				width : 150
			}, {
				title : '可访问权限',
				field : 'str',
				width : 300
			} ] ]
		});
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
		<form id="admin_showUser_editForm" method="post">
			<input name="id" readonly="readonly" type="hidden"/>
			<input name="arId" readonly="readonly" type="hidden"/>
			<table class="tableForm" style="margin-left: 70px;margin-top: 15px">
				<tr>
					<th>登录名称：</th>
					<td colspan="3"><input name="username" class="easyui-validatebox"
						data-options="required:true" style="width:160px" readonly="readonly" value="<s:property value='admin.username'/>"/></td>
				</tr>
				<tr>
					<th>登录密码：</th>
					<td colspan="3"><input type="password" name="password" class="easyui-validatebox"
						data-options="required:true" style="width:160px" readonly="readonly" value="<s:property value='admin.password'/>"/></td>
				</tr>
				<tr>
					<th>真实姓名：</th>
					<td><input name="truename" class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='admin.truename'/>"/></td>
				</tr>
				<tr>
					<th>手机号码：</th>
					<td><input name="mobilephone" class="easyui-validatebox"
						data-options="validType:'mobilePhone'" style="width:160px" readonly="readonly" value="<s:property value='admin.mobilephone'/>"/></td>
				</tr>
				<tr>
					<th>固定电话：</th>
					<td colspan="3"><input name="telephone"
						class="easyui-validatebox" style="width:160px" readonly="readonly" value="<s:property value='admin.telephone'/>"/></td>
				</tr>
				<tr>
					<th>邮箱：</th>
					<td colspan="3"><input name="email"
						class="easyui-validatebox" data-options="validType:'email'"
						style="width:230px" readonly="readonly" value="<s:property value='admin.email'/>"/></td>
				</tr>
				<tr>
					<th>联系地址：</th>
					<td colspan="3"><input name="address"
						class="easyui-validatebox" style="width:230px" readonly="readonly" value="<s:property value='admin.address'/>"/></td>
				</tr>
				<tr>
					<th>所属角色：</th>
					<td><input id="admin_role_show_combobox" name="roleId" style="width:200px;" readonly="readonly" value="<s:property value='admin.roleId'/>"/></td>
				</tr>				
			</table>
		</form>
	</div>
</div>
