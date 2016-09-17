<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_cat_datagrid;
	var editRow = undefined;
	var cid = undefined;
	var admin_cat_searchForm;
	$(function(){
		admin_cat_searchForm = $('#admin_cat_searchForm');
		admin_cat_datagrid = $('#admin_cat_datagrid').datagrid({
			url:'cat/catAction!gainCatList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			pagination : true,
			pageSize : 20,
			pageList : [ 5, 10,20, 40 ,50 ],			
			nowrap : false,
			striped : true,
			//sortName : 'regTime',
			//sortOrder : 'desc',
			//remoteSort : true,
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '名称',
				field : 'name',
				width : 150,
				align :'center'
			},{
				title : '图片路径',
				field : 'pic',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					if(value!=null&&value!=''){
						return formatString('<img width="60px" height="40px" src="{0}"/>', value);
					}	
		        }
			},{
				title : '是否可用',
				field : 'disabled',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					if(value=='false'){
						value='可用';
					}else if(value=='true'){
						value='不可用';
					}
					return value;
		        }
			},{
				title : '备注',
				field : 'remark',
				width : 150,
				align :'center'
			},{
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<img onclick="admin_cat_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="admin_cat_remove(\'{2}\');" src="{3}"/>',row.id,'style/images/pencil.png', row.id,'style/images/cancel.png');									
		        }						
			}] ],
			toolbar : [{
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					admin_cat_add();
				}
			}, '-',{
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					admin_cat_remove();
				}
			}],
		});
	});
	/**
	 * 添加cat
	 */
 	function admin_cat_add(){
		$('<div/>').dialog({
			href : 'cat/catAction!toAdd.action',
			width : 480,
			height : 268,
			modal : true,
			title : '添加cat',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#admin_cat_addForm').form({
						url : 'cat/catAction!addCat.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
								    admin_cat_datagrid.datagrid('load');
									d.dialog('destroy');
									$.messager.show({
										title : '提示',
										msg : r.msg
									});									
								}else{
									$.messager.alert('提示', r.msg,'info');								
								}
							} catch (e) {
								$.messager.alert('提示', r.msg,'info');
							}
						}
					});
					$('#admin_cat_addForm').submit();
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	/**
	 * 编辑cat
	 */
	function admin_cat_edit(id) {
		admin_cat_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'cat/catAction!toUpdate.action?id='+id,
			width : 480,
			height : 268,
			modal : true,
			title : '编辑cat',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#cat_editForm').form('submit', {
						url : 'cat/catAction!updateCat.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									admin_cat_datagrid.datagrid('load');
									d.dialog('destroy');
									$.messager.show({
										title : '提示',
										msg : r.msg
									});
								}else{
									$.messager.alert('提示', r.msg,'info');	
								}
							} catch (e) {
								$.messager.alert('提示', r.msg,'info');
							}
						}
					});
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				var index = admin_cat_datagrid.datagrid('getRowIndex', id);
				var rows = admin_cat_datagrid.datagrid('getRows');
				var o = rows[index];
				$('#cat_editForm').form('load', o);
			}
		});		
	}
	/**
	 * 单条或批量删除用户
	 */	
	function admin_cat_remove(id) {
		var rows;
		if(cid != id){
			admin_cat_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_cat_datagrid.datagrid('checkRow', admin_cat_datagrid.datagrid('getRowIndex', id));
			rows = admin_cat_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_cat_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
						
					}
					$.ajax({
						url : 'cat/catAction!dropCat.action?ids='+ids,
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_cat_datagrid.datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_cat_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	
	
	/**
	 * 检索
	 */	
	function admin_cat_search(){
		admin_cat_datagrid.datagrid('load',sy.serializeObject(admin_cat_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_cat_clean(){
		$('#admin_cat_searchForm input').val('');
		admin_cat_datagrid.datagrid('load', {});	
	}

</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_cat_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>名称:</th>
					<td><input name="name" placeholder="请输入分类名称"/></td>
					<th>是否可用:</th>
					<td>
						<select class="easyui-combobox" name="disabled" style="width:140px">
							<option value="ok" selected="selected">请选择</option>
							<option value="false">可用</option>
							<option value="true">不可用</option>
						</select>
					</td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_cat_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_cat_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_cat_datagrid"></table>
	</div>
</div>