<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
.addNews {
	padding-left: 100px;
	padding-top: 20px;
	padding-bottom: 200px;
}
.newsTable{
	border-collapse: collapse;
	
}
.newsTable th{
	text-align: right;
	padding: 10px;
}
</style>
<div align="center" style="padding: 5px;">
	<form method="post">
		<input type="hidden" value="${newsCatType.id }" name="id" />
		<table class="newsTable">
			<tr>
				<th>类别名称</th>
				<td><input name="name" value="${newsCatType.name }" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写菜单名称'" />
				</td>
			</tr>
			<tr>
				<th>排序</th>
				<td><input name="porder"  class="easyui-numberspinner" data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择菜单排序'" value="${newsCatType.porder }" style="width:150px;" />
				</td>
			</tr>
			<tr>
				<th>是否显示</th>
				<td>
					<s:if test="%{newsCatType.disabled=='false'}">
						<input type="radio" name="disabled" value="false" checked="checked"/>显示<input type="radio" name="disabled" value="true" />不显示
					</s:if>
					<s:else>
						<input type="radio" name="disabled" value="false" />显示<input type="radio" name="disabled" value="true" checked="checked"/>不显示
					</s:else>
				</td>
			</tr>
			<tr>
				<th>备注</th>
				<td><input name="remark"  value="${newsCatType.remark }"/>
				</td>
			</tr>
		</table>
	</form>
</div>