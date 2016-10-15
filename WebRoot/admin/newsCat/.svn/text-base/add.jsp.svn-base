<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div align="center" style="padding: 5px;">
	<form method="post">
		<table class="tableForm" id="admin_newsCat_add_table">
			<tr>
				<th>分类名称</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写名称'" />
				</td>
				<th>排序</th>
				<td><input name="porder" class="easyui-numberspinner" data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择菜单排序'" value="0" style="width:150px;" />
				</td>
			</tr>
			<tr>
				<th>是否显示</th>
				<td colspan="3"><input type="radio" name="disabled" value="false" checked="checked" style="width: 20px"/>显示<input type="radio" name="disabled" value="true" style="width: 20px" />不显示
				</td>
			</tr>
			<tr>
				<th>上级菜单</th>
				<td>
					<input name="pid" value="${pid }" id="admin_newsCat_add_table_pid" class="easyui-combotree" style="width:150px;"  
       			 		data-options="url:'newsCat!gainAll.action', parentField:'pid', textFiled:'name',panelHeight:'auto',idField:'id',readonly:true,onLoadSuccess:function(){
       			 			$('#admin_newsCat_add_table_pid').combotree('tree').tree('collapseAll');
       			 		}" />
				</td>
			</tr>
			<tr>
				<th>所属类别</th>
				<td>
					<input name="typeId" class="easyui-combobox"  style="width:150px;"  
       			 	data-options="url:'newsCatType!gainAll.action',textField:'name',valueField:'id',panelHeight:'auto',editable:false,required:true"/>
				</td>
			</tr>
			<tr>
				<th>描述</th>
				<td>
					<input name="remark" class="easyui-validatebox" />
				</td>
			</tr>
		</table>
	</form>
</div>