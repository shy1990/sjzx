<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%
String basePath = PathUtil.getPath(request);
%>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
		<form id="role_addForm" method="post">
			<table class="tableForm" style="margin-left: 70px;margin-top: 15px">
				<tr>
					<th>角色名称：</th>
					<td colspan="3"><input name="name" class="easyui-validatebox"
						data-options="required:true" style="width:230px" placeholder="请输入角色名称"/></td>
				</tr>
				<tr>
					<th>角色备注：</th>
					<td><textarea name="remark" style="width:230px;height:130px"></textarea></td>
				</tr>
				<tr>
					<th>授权：</th>
					<td colspan="3"><input id="role_authorize_mid" name="mids" class="easyui-combotree" data-options="url:'module/moduleAction!gainModuleTreeList.action?mark='+1,parentField : 'pid',textFiled:'name',lines : true,multiple:true" style="width: 230px;" />
					<img src="style/images/cut_red.png" onclick="$('#role_authorize_mid').combotree('clear');" /></td>
				</tr>				
			</table>
		</form>
	</div>
</div>
