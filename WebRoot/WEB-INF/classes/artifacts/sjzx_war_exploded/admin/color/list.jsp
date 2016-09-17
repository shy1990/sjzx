<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" charset="utf-8">
	var color_datagrid;
	var did = undefined;
	var color_searchForm;
	$(function(){
		color_searchForm = $('#color_searchForm');
		color_datagrid = $('#color_datagrid').datagrid({
			url:'color/colorAction!gainColorList.action',
			fit : true,
			fitColumns : true,
			striped : true,
			idField : 'id',
			//sortName : 'ordernum',
			//sortOrder : 'desc',
			//remoteSort : true,
			pagination : true,
			pageSize : 20,
			pageList : [ 20, 30, 40 ,50 ],
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '颜色名称',
				field : 'colorName',
				width : 150,
				align :'center'
			},{
				title : '颜色代码',
				field : 'colorRgb',
				width : 150,
				align :'center'
			}, {
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(row.id == '7475de6e22cd4cd783acb85605eda9bd'){
						return '系统角色';
					}else{
						return formatString('<img onclick="color_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="color_remove(\'{2}\');" src="{3}"/>', row.id, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
					}
		        }
			}] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					color_add();
				}
			}, '-', {
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					color_remove();
				}
			},  '-'			
			],
		});
	});
	
	/**
	 * 添加颜色
	 */	
	function color_add() {
		$('<div/>').dialog({
			href : 'color/colorAction!toAdd.action',
			width : 450,
			height : 160,
			modal : true,
			title : '添加颜色',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#color_addForm').form({
						url : 'color/colorAction!addColor.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
								    color_datagrid.datagrid('load');
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
					$('#color_addForm').submit();
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	
	/**
	 * 编辑颜色
	 */
	function color_edit(id) {
		color_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'color/colorAction!toUpdate.action?id='+id,
			width : 450,
			height : 160,
			modal : true,
			title : '编辑颜色',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#color_editForm').form('submit', {
						url : 'color/colorAction!updateColor.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									color_datagrid.datagrid('updateRow', {
										index : color_datagrid.datagrid('getRowIndex', id),
										row : r.obj
									});
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
				var index = color_datagrid.datagrid('getRowIndex', id);
				var rows = color_datagrid.datagrid('getRows');
			    var o = rows[index];
				o.str = stringToList(rows[index].str);
				$('#color_editForm').form('load', o);
			}
		});		
	}
	
	
	
	/**
	 * 单条或批量删除颜色
	 */
	function color_remove(id) {
		var rows;
		if(did != id){
			color_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			color_datagrid.datagrid('checkRow', color_datagrid.datagrid('getRowIndex', id));	
			rows = color_datagrid.datagrid('getChecked');	
		}else{
			rows = color_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						var ddd = rows[i].id;
						ids.push(ddd);
					}
					console.info(ids);
					$.ajax({
						url : 'color/colorAction!dropColor.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							try {
								
							} catch (e) {
								// TODO: handle exception
							}
							if (result.success) {
								color_datagrid.datagrid('load');
								$.messager.show({
									title : '提示',
									msg : result.msg
								});								
							}else{
								/*$.messager.show({
									title : '提示',
									msg : result.msg
								});*/
								$.messager.alert('提示', result.msg,'info');
							}
						}
					});
				}else{
					color_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	
	
/**
	 * 检索
	 */	
	function color_search(){
		color_datagrid.datagrid('load', sy.serializeObject(color_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function color_clean(){
		$('#color_searchForm input').val('');
		color_datagrid.datagrid('load', {});	
	}
	
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="color_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>颜色名称:</th>
					<td><input name="colorName" placeholder="请输入颜色名称"/></td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="color_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="color_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="color_datagrid"></table>
	</div>
</div>
