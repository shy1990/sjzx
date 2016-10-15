<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" charset="utf-8">
	var friendlyLink_datagrid;
	var fid = undefined;
	var friendlyLink_searchForm;
	$(function(){
		friendlyLink_searchForm = $('#friendlyLink_searchForm');
		friendlyLink_datagrid = $('#friendlyLink_datagrid').datagrid({
			url:'friendlyLink/friendlyLinkAction!gainFriendlyLinkList.action',
			fit : true,
			fitColumns : true,
			striped : true,
			idField : 'id',
			sortName : 'orderlist',
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
				title : '公司链接',
				field : 'href',
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
				title : '公司图片',
				field : 'imageUrl',
				width : 150,
				align :'center',
				formatter: function(value,row,index){	
					if(value!=null && value!=''){
						return formatString('<img src="{0}" width="175" height="47" />',value);				
					}else{
						return formatString('<img src="{0}" width="175" height="47" />',value);	
					}			
		        }
			}, 	
				
			  {
				title : '排序',
				field : 'orderlist',
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
						return formatString('<img onclick="friendlyLink_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="friendlyLink_remove(\'{2}\');" src="{3}"/>', row.id, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
					}
		        }
			}] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					friendlyLink_add();
				}
			}, '-', {
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					friendlyLink_remove();
				}
			},  '-'			
			],
		});
	});
	
	/**
	 * 添加友情链接公司
	 */	
	function friendlyLink_add() {
		$('<div/>').dialog({
			href : 'friendlyLink/friendlyLinkAction!toAdd.action',
			width : 450,
			height : 250,
			modal : true,
			title : '添加友情链接公司',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#friendlyLink_addForm').form({
						url : 'friendlyLink/friendlyLinkAction!addFriendlyLink.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
								    friendlyLink_datagrid.datagrid('load');
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
					$('#friendlyLink_addForm').submit();
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	
	/**
	 * 编辑友情链接公司
	 */
	function friendlyLink_edit(id) {
		friendlyLink_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'friendlyLink/friendlyLinkAction!toUpdate.action?id='+id,
			width : 450,
			height : 230,
			modal : true,
			title : '编辑友情链接公司',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#friendlyLink_editForm').form('submit', {
						url : 'friendlyLink/friendlyLinkAction!updateFriendlyLink.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									friendlyLink_datagrid.datagrid('updateRow', {
										index : friendlyLink_datagrid.datagrid('getRowIndex', id),
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
				var index = friendlyLink_datagrid.datagrid('getRowIndex', id);
				var rows = friendlyLink_datagrid.datagrid('getRows');
			    var o = rows[index];
				o.str = stringToList(rows[index].str);
				$('#friendlyLink_editForm').form('load', o);
			}
		});		
	}
	
	
	
	/**
	 * 单条或批量删除友情链接公司
	 */
	function friendlyLink_remove(id) {
		var rows;
		if(fid != id){
			friendlyLink_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			friendlyLink_datagrid.datagrid('checkRow', friendlyLink_datagrid.datagrid('getRowIndex', id));	
			rows = friendlyLink_datagrid.datagrid('getChecked');	
		}else{
			rows = friendlyLink_datagrid.datagrid('getSelections');
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
						url : 'friendlyLink/friendlyLinkAction!dropFriendlyLink.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								friendlyLink_datagrid.datagrid('load');
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
					friendlyLink_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	
	
/**
	 * 检索
	 */	
	function friendlyLink_search(){
		friendlyLink_datagrid.datagrid('load', sy.serializeObject(friendlyLink_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function friendlyLink_clean(){
		$('#friendlyLink_searchForm input').val('');
		friendlyLink_datagrid.datagrid('load', {});	
	}
	
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="friendlyLink_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>友情链接公司名称:</th>
					<td><input name="name" placeholder="请输入友情链接公司名称"/></td>
					
					<th>操作:</th>
					<td style="width: 80%">
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="friendlyLink_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="friendlyLink_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="friendlyLink_datagrid"></table>
	</div>
</div>
