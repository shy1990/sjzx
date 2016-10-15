<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" charset="utf-8">
	var dlyCorp_datagrid;
	var did = undefined;
	var dlyCorp_searchForm;
	$(function(){
		dlyCorp_searchForm = $('#dlyCorp_searchForm');
		dlyCorp_datagrid = $('#dlyCorp_datagrid').datagrid({
			url:'dlyCorp/dlyCorpAction!gainDlyCorpList.action',
			fit : true,
			fitColumns : true,
			striped : true,
			idField : 'id',
			sortName : 'ordernum',
			sortOrder : 'desc',
			remoteSort : true,
			pagination : true,
			pageSize : 20,
			pageList : [ 20, 30, 40 ,50 ],
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '公司名称',
				field : 'name',
				width : 150,
				align :'center'
			}, {
				title : '公司代码',
				field : 'type',
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
				title : '公司网址',
				field : 'website',
				width : 150,
				align :'center'
			}, {
				title : '是否禁用/启用',
				field : 'disable',
				width : 150,
				align :'center',
				styler: function(value,row,index){
				if (value != 'false'){
					return 'color:red;';
					}else{
					return 'color:green;';
					}
				},
				formatter: function(value,row,index){
					if(value !='false'){
						return '已禁用';
					}else{
						return '已启用';
					}
		        }	
				
				
			},  {
				title : '排序',
				field : 'ordernum',
				width : 150,
				align :'center',
				sortable : true
				
			}, {
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(row.id == '7475de6e22cd4cd783acb85605eda9bd'){
						return '系统角色';
					}else{
						return formatString('<img onclick="dlyCorp_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="dlyCorp_remove(\'{2}\');" src="{3}"/>', row.id, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
					}
		        }
			}] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					dlyCorp_add();
				}
			}, '-', {
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					dlyCorp_remove();
				}
			}, '-', {
				text : '批量禁用',
				iconCls : 'icon-no',
				handler : function() {
					dlyCorp_ban();
				}
			}, '-', {
				text : '批量启用',
				iconCls : 'icon-ok',
				handler : function() {
					dlyCorp_open();
				}
			}, '-'			
			],
		});
	});
	
	/**
	 * 添加物流公司
	 */	
	function dlyCorp_add() {
		$('<div/>').dialog({
			href : 'dlyCorp/dlyCorpAction!toAdd.action',
			width : 450,
			height : 235,
			modal : true,
			title : '添加物流公司',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#dlyCorp_addForm').form({
						url : 'dlyCorp/dlyCorpAction!addDlyCorp.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
								    dlyCorp_datagrid.datagrid('load');
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
					$('#dlyCorp_addForm').submit();
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	
	/**
	 * 编辑物流公司
	 */
	function dlyCorp_edit(id) {
		dlyCorp_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'dlyCorp/dlyCorpAction!toUpdate.action?id='+id,
			width : 450,
			height : 235,
			modal : true,
			title : '编辑物流公司',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#dlyCorp_editForm').form('submit', {
						url : 'dlyCorp/dlyCorpAction!updateDlyCorp.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									dlyCorp_datagrid.datagrid('updateRow', {
										index : dlyCorp_datagrid.datagrid('getRowIndex', id),
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
				var index = dlyCorp_datagrid.datagrid('getRowIndex', id);
				var rows = dlyCorp_datagrid.datagrid('getRows');
			    var o = rows[index];
				o.str = stringToList(rows[index].str);
				$('#dlyCorp_editForm').form('load', o);
			}
		});		
	}
	
	
	
	/**
	 * 单条或批量删除物流公司
	 */
	function dlyCorp_remove(id) {
		var rows;
		if(did != id){
			dlyCorp_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			dlyCorp_datagrid.datagrid('checkRow', dlyCorp_datagrid.datagrid('getRowIndex', id));	
			rows = dlyCorp_datagrid.datagrid('getChecked');	
		}else{
			rows = dlyCorp_datagrid.datagrid('getSelections');
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
						url : 'dlyCorp/dlyCorpAction!dropDlyCorp.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								dlyCorp_datagrid.datagrid('load');
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
					dlyCorp_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	
	/**
	 * 禁用单条或批量禁用物流公司
	 */
	function dlyCorp_ban(id) {
		var rows;
		if(did != id){
			dlyCorp_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			dlyCorp_datagrid.datagrid('checkRow', dlyCorp_datagrid.datagrid('getRowIndex', id));	
			rows = dlyCorp_datagrid.datagrid('getChecked');	
		}else{
			rows = dlyCorp_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要禁用当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						var ddd = rows[i].id;
						ids.push(ddd);
					}
					console.info(ids);
					$.ajax({
						url : 'dlyCorp/dlyCorpAction!danDlyCorp.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								dlyCorp_datagrid.datagrid('load');
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
					dlyCorp_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要禁用的记录！','info');
		}
	}
	
	/**
	 * 禁用单条或批量启用物流公司
	 */
	function dlyCorp_open(id) {
		var rows;
		if(did != id){
			dlyCorp_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			dlyCorp_datagrid.datagrid('checkRow', dlyCorp_datagrid.datagrid('getRowIndex', id));	
			rows = dlyCorp_datagrid.datagrid('getChecked');	
		}else{
			rows = dlyCorp_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要启用当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						var ddd = rows[i].id;
						ids.push(ddd);
					}
					console.info(ids);
					$.ajax({
						url : 'dlyCorp/dlyCorpAction!openDlyCorp.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								dlyCorp_datagrid.datagrid('load');
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
					dlyCorp_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要启用的记录！','info');
		}
	}
	
/**
	 * 检索
	 */	
	function dlyCorp_search(){
		dlyCorp_datagrid.datagrid('load', sy.serializeObject(dlyCorp_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function dlyCorp_clean(){
		$('#dlyCorp_searchForm input').val('');
		dlyCorp_datagrid.datagrid('load', {});	
	}
	
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="dlyCorp_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>物流公司名称:</th>
					<td><input name="name" placeholder="请输入物流公司名称"/></td>
					<th>公司代码</th>
					<td><input name="type" placeholder="请输入物流公司代码"/></td>
					<th>是否启用:</th>
					<td>
						<select  id="isdisable" name="disable">
						  <option selected value=''>--请选择--</option>
						  <option  value='false'>启用</option>  
						  <option  value='true'>禁用</option>    
						</select>
					</td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="dlyCorp_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="dlyCorp_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="dlyCorp_datagrid"></table>
	</div>
</div>
