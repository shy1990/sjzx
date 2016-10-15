<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" charset="utf-8">
	var label_datagrid;
	var did = undefined;
	var label_searchForm;
	$(function(){
		label_searchForm = $('#label_searchForm');
		label_datagrid = $('#label_datagrid').datagrid({
			url:'label/labelAction!gainLabelList.action',
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
				title : '标签名称',
				field : 'name',
				width : 150,
				align :'center'
			},{
				title : '标签备注',
				field : 'remark',
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
						return formatString('<img onclick="label_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="label_remove(\'{2}\');" src="{3}"/>', row.id, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
					}
		        }
			}] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					label_add();
				}
			}, '-', {
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					label_remove();
				}
			},  '-'			
			],
		});
	});
	
	/**
	 * 添加标签
	 */	
	function label_add() {
		$('<div/>').dialog({
			href : 'label/labelAction!toAdd.action',
			width : 450,
			height : 160,
			modal : true,
			title : '添加标签',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#label_addForm').form({
						url : 'label/labelAction!addLabel.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
								    label_datagrid.datagrid('load');
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
					$('#label_addForm').submit();
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	
	/**
	 * 编辑标签
	 */
	function label_edit(id) {
		label_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'label/labelAction!toUpdate.action?id='+id,
			width : 450,
			height : 160,
			modal : true,
			title : '编辑标签',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#label_editForm').form('submit', {
						url : 'label/labelAction!updateLabel.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									label_datagrid.datagrid('updateRow', {
										index : label_datagrid.datagrid('getRowIndex', id),
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
				var index = label_datagrid.datagrid('getRowIndex', id);
				var rows = label_datagrid.datagrid('getRows');
			    var o = rows[index];
				o.str = stringToList(rows[index].str);
				$('#label_editForm').form('load', o);
			}
		});		
	}
	
	
	
	/**
	 * 单条或批量删除标签
	 */
	function label_remove(id) {
		var rows;
		if(did != id){
			label_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			label_datagrid.datagrid('checkRow', label_datagrid.datagrid('getRowIndex', id));	
			rows = label_datagrid.datagrid('getChecked');	
		}else{
			rows = label_datagrid.datagrid('getSelections');
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
						url : 'label/labelAction!dropLabel.action',
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
								label_datagrid.datagrid('load');
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
					label_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	
	
/**
	 * 检索
	 */	
	function label_search(){
		label_datagrid.datagrid('load', sy.serializeObject(label_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function label_clean(){
		$('#label_searchForm input').val('');
		label_datagrid.datagrid('load', {});	
	}
	
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="label_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>标签名称:</th>
					<td><input name="name" placeholder="请输入标签名称"/></td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="label_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="label_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="label_datagrid"></table>
	</div>
</div>
