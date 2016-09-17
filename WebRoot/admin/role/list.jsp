<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" charset="utf-8">
	var role_datagrid;
	var rid = undefined;
	$(function(){
		role_datagrid = $('#role_datagrid').datagrid({
			url:'role/roleAction!gainRoleList.action',
			fit : true,
			fitColumns : true,
			striped : true,
			idField : 'id',
			pagination : true,
			pageSize : 20,
			pageList : [ 20, 30, 40 ,50 ],
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '角色名称',
				field : 'name',
				width : 150,
				align :'center'
			}, {
				title : '角色备注',
				field : 'remark',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return value;
					}else{
						return '---';
					}
		        }				
			}, {
				title : '创建时间',
				field : 'createtime',
				width : 150,
				align :'center'
			},{
				title : '修改时间',
				field : 'modifytime',
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
						return formatString('<img onclick="role_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="role_remove(\'{2}\');" src="{3}"/>', row.id, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
					}
		        }
			}] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					role_add();
				}
			}, '-', {
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					role_remove();
				}
			}, '-', {
				text : '授权',
				iconCls : 'icon-add',
				handler : function() {
					role_authorize();
				}
			}
			],
		});
	});
	
	/**
	 * 添加角色
	 */	
	function role_add() {
		$('<div/>').dialog({
			href : 'role/roleAction!toAdd.action',
			width : 480,
			height : 320,
			modal : true,
			title : '添加角色',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#role_addForm').form({
						url : 'role/roleAction!addRole.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
								    role_datagrid.datagrid('load');
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
					$('#role_addForm').submit();
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	
	/**
	 * 编辑角色
	 */
	function role_edit(id) {
		role_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'role/roleAction!toUpdate.action?id='+id,
			width : 480,
			height : 300,
			modal : true,
			title : '编辑角色',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#role_editForm').form('submit', {
						url : 'role/roleAction!updateRole.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									role_datagrid.datagrid('updateRow', {
										index : role_datagrid.datagrid('getRowIndex', id),
										row : r.obj
									});
									d.dialog('destroy');
								}
								$.messager.show({
									title : '提示',
									msg : r.msg
								});
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
				var index = role_datagrid.datagrid('getRowIndex', id);
				var rows = role_datagrid.datagrid('getRows');
				var o = rows[index];
				//o.str = stringToList(rows[index].str);
				$('#role_editForm').form('load', o);
			}
		});		
	}
	
	/**
	 * 单条或批量删除角色
	 */
	function role_remove(id) {
		var rows;
		if(rid != id){
			role_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			role_datagrid.datagrid('checkRow', role_datagrid.datagrid('getRowIndex', id));	
			rows = role_datagrid.datagrid('getChecked');	
		}else{
			rows = role_datagrid.datagrid('getSelections');
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
						url : 'role/roleAction!dropRole.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								role_datagrid.datagrid('load');
								$.messager.show({
									title : '提示',
									msg : result.msg
								});								
							}else{
								$.messager.show({
									title : '提示',
									msg : result.msg
								});
							}
						}
					});
				}else{
					role_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}

	/**
	 * 授权
	 */
	function role_authorize() {
		var rows = role_datagrid.datagrid('getChecked');
		var rid = "";
		if(rows.length == 1){
			for ( var i = 0; i < rows.length; i++) {
				rid = rows[i].id;
			}
			var subtitle = '授权管理';	
			if (!$('#tabs').tabs('exists', subtitle)) {
					$('#tabs').tabs('add', {
						title : subtitle,
						href : 'role/roleAction!toAuthorize.action?rid='+rid,
						closable : true,
						icon : 'icon icon-magic'
					});
			} else {
				$('#tabs').tabs('select', subtitle);
				$.messager.alert('提示','您已打开一个授权页面,请完成后再操作!','info');
				return;
			}
		}else{
			$.messager.alert('提示','请选择一项进行授权！','info');	
		}
	}
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'center',border:false">
	   <table id="role_datagrid"></table>
	</div>
</div>
