<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div align="center" style="padding: 5px;">
	<form method="post">
		<input type="hidden" name="id" value="${newsCat.id }" />
		<table class="tableForm">
			<tr>
				<th>分类名称</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写名称'" value="${newsCat.name }" />
				</td>
				<th>排序</th>
				<td><input name="porder" value="${newsCat.porder }" class="easyui-numberspinner" data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择菜单排序'" value="0" style="width:150px;" />
				</td>
			</tr>
			<tr>
				<th>是否显示</th>
				<td colspan="3">
					<s:if test="%{newsCat.disabled=='false'}">
						<input type="radio" name="disabled" value="false" checked="checked" style="width: 20px"/>显示<input type="radio" name="disabled" value="true"  style="width: 20px"/>不显示
					</s:if>
					<s:else>
						<input type="radio" name="disabled" value="false"  style="width: 20px"/>显示<input type="radio" name="disabled" value="true" checked="checked" style="width: 20px"/>不显示
					</s:else>
				</td>
			</tr>
			<tr>
				<th>上级菜单</th>
				<td>
					<input value="${newsCat.pname }" style="width:150px;" readonly="readonly" />
					<input name="pid" value="${newsCat.pid }" type="hidden" >
				</td>
			</tr>
			<tr>
				<th>所属类别</th>
				<td colspan="3">
					<input name="typeId" value="${newsCat.typeId }" class="easyui-combobox"  style="width:150px;"  
       			 	data-options="url:'newsCatType!gainAll.action',textField:'name',valueField:'id',panelHeight:'auto',required:true,editable:false"/>
       			 	<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">类别</a>
				</td>
			</tr>
			<tr>
				<th>描述</th>
				<td>
					<input name="remark" value="${newsCat.remark }" class="easyui-validatebox" />
				</td>
			</tr>
		</table>
	</form>
</div>