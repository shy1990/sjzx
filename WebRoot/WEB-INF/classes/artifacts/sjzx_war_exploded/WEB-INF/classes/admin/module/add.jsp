<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
	<form id="module_addForm" method="post">
		<table class="tableForm" style="margin-left: 10px;margin-top: 15px">
			<tr>
				<th>模块名称：</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:true" style="width:230px" placeholder="请输入模块名称"/>
				</td>
			</tr>
			<tr>
				<th>模块地址：</th>
				<td><input name="url" class="easyui-validatebox" style="width:230px" placeholder="请输入模块地址"/>
				</td>
			</tr>
			<tr>
				<th>上级模块：</th>
				<td><input id="m_pid" name="pid" value="${pid}" class="easyui-combotree" data-options="url:'module/moduleAction!gainModuleTreeList.action?mark='+3,parentField : 'pid',textFiled:'name',required:true,lines : true" style="width:235px;" />
				<img src="style/images/cut_red.png" onclick="$('#m_pid').combotree('clear');" />
				</td>
			</tr>
			<tr>
				<th>模块图标：</th>
				<td colspan="3"><input id="iconCls" name="icon" style="width: 235px; height: 29px;" /></td>
			</tr>						
		</table>
	</form>
</div>