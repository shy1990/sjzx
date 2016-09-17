<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_app_datagrid;
	var editRow = undefined;
	var aid = undefined;
	var admin_app_searchForm;
	$(function(){	
		admin_app_searchForm = $('#admin_app_searchForm');
		admin_app_datagrid = $('#admin_app_datagrid').datagrid({
			url:'app/appAction!gainAppList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			pagination : true,
			pageSize : 20,
			pageList : [ 5, 10,20, 40 ,50 ],			
			nowrap : false,
			striped : true,
			remoteSort : true,
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : 'app名称',
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
				title : '版本号',
				field : 'verionNum',
				width : 150,
				align :'center'
			
			},{
				title : '下载路径',
				field : 'url',
				width : 150,
				align :'center',
				hidden : true			
			},{
				title : '创建时间',
				field : 'createTime',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '修改时间',
				field : 'modifyTime',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '操作人',
				field : 'userName',
				width : 150,
				align :'center'
			},{
				title : '备注',
				field : 'remark',
				width : 150,
				align :'center'
			},{
				title : '包名',
				field : 'packName',
				width : 150,
				align :'center'
			},{
				title : 'app类型',
				field : 'type',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					if(value=='0'){
						value='默认';
					}else if(value=='1'){
						value='推荐功能';
					}else{
						value='本地应用';
					} 
					return value;
		        }
			},{
				title : '是否被卸载',
				field : 'nuinstall',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					if(value=='0'){
						value='未被卸载';
					}else{
						value='已卸载';
					}
					return value;
		        }
			},{
				title : '应用点击次数',
				field : 'opentime',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '串号',
				field : 'serialNumber',
				width : 150,
				align :'center',
				hidden : true
			},{
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<img onclick="admin_app_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="admin_app_remove(\'{2}\');" src="{3}"/>',row.id,'style/images/pencil.png', row.id,'style/images/cancel.png');									
		        }				
			}] ],
			toolbar : [{
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					admin_app_add();
				}
			}, '-',{
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					admin_app_remove();
				}
			}],
			
		});
	});
	
	/**
	 * 添加app
	 */
 	function admin_app_add(){
		$('<div/>').dialog({
			href : 'app/appAction!toAdd.action',
			width : 480,
			height : 480,
			modal : true,
			title : '添加app',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#admin_app_addForm').form({
						url : 'app/appAction!addApp.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
								    admin_app_datagrid.datagrid('load');
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
					$('#admin_app_addForm').submit();
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	/**
	 * 编辑app
	 */
	function admin_app_edit(id) {
		admin_app_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'app/appAction!toUpdate.action?id='+id,
			width : 480,
			height : 480,
			modal : true,
			title : '编辑app',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#app_editForm').form('submit', {
						url : 'app/appAction!updateApp.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									admin_app_datagrid.datagrid('load');
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
				var index = admin_app_datagrid.datagrid('getRowIndex', id);
				var rows = admin_app_datagrid.datagrid('getRows');
				var o = rows[index];
				$('#app_editForm').form('load', o);
			}
		});		
	}
	/**
	 * 单条或批量删除app
	 */	
	function admin_app_remove(id) {
		var rows;
		if(aid != id){
			admin_app_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_app_datagrid.datagrid('checkRow', admin_app_datagrid.datagrid('getRowIndex', id));
			rows = admin_app_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_app_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : 'app/appAction!dropApp.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_app_datagrid.datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_app_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	/**
	 * 检索
	 */	
	function admin_app_search(){
		admin_app_datagrid.datagrid('load',sy.serializeObject(admin_app_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_app_clean(){
		$('#admin_app_searchForm input').val('');
		admin_app_datagrid.datagrid('load', {});	
	}
	
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_app_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>app名称:</th>
					<td><input name="name" placeholder="请输入app名称"/></td>
					<th>创建时间:</th>
					<td><input id="admin_starttime" name="_startTime"  class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_endtime\')}'" />&nbsp;至&nbsp;
						<input id="admin_endtime" name="_endTime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_starttime\')}'" />	
					</td>
					<th>是否被卸载:</th>
					<td>
						<select class="easyui-combobox" name="nuinstall" style="width:140px">
							<option value='-1' selected="selected">请选择</option>
							<option value='0'>未被卸载</option>
							<option value='1'>已卸载</option>
						</select>
					</td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_app_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_app_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_app_datagrid"></table>
	</div>
</div>