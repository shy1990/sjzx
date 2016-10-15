<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	$(function() {
		$('#iconCls').combobox({
			data : $.iconData,
			formatter : function(v) {
				return formatString('<span class="{0}" style="display:inline-block;vertical-align:middle;width:16px;height:16px;"></span>{1}', v.value, v.value);
			}
		});
	});
</script>
<div align="center">
	<form id="module_editForm" method="post">
	<input name="id" type="hidden"/>
		<table class="tableForm" style="margin-left: 10px;margin-top: 15px">
			<tr>
				<th>模块名称：</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:true" style="width:230px"/>
				</td>
			</tr>
			<tr>
				<th>模块地址：</th>
				<td><input name="url" class="easyui-validatebox" style="width:230px"/>
				</td>
			</tr>
			<tr>
				<th>上级模块：</th>
				<td><input name="pname" style="width:230px" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>模块图标：</th>
				<td colspan="3"><input id="iconCls" name="icon" style="width: 235px; height: 29px;" /></td>
			</tr>						
		</table>
	</form>
</div>