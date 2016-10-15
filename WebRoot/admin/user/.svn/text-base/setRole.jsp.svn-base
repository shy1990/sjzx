<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String basePath = PathUtil.getPath(request);
%>
<script type="text/javascript">
	$(function() {
		$('#admin_role_combobox').combogrid({
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
		<form id="admin_role_addForm" method="post">
			<input name="ids" readonly="readonly" type="hidden"/>
			<table class="tableForm" style="margin-left: 30px;margin-top: 15px">
				<tr>
					<th>选择角色：</th>
					<td><input id="admin_role_combobox" name="roleId" style="width:160px;" /></td>
				</tr>
			</table>
		</form>
	</div>
</div>
