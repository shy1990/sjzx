<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_datagrid;
	var editRow = undefined;
	var aid = undefined;
	var admin_searchForm;
	$(function(){
		admin_searchForm = $('#admin_searchForm');
		admin_datagrid = $('#admin_datagrid').datagrid({
			url:'admin/adminAction!gainAdminList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			pagination : true,
			pageSize : 20,
			pageList : [ 20, 30, 40 ,50 ],			
			nowrap : false,
			striped : true,
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '登录名称',
				field : 'username',
				width : 150,
				align :'center'
			}, {
				field : 'arId',
				title : '关联id',
				width : 150,
				hidden : true
			}, {
				field : 'roleId',
				title : '所属角色ID',
				width : 150,
				hidden : true
			},{
				title : '所属角色',
				field : 'roleName',
				width : 150,
				align :'center'
			}, {
				title : '真实姓名',
				field : 'truename',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return value;
					}else{
						return '---';
					}
		        }
			},{
				title : '工号',
				field : 'userNum',
				width : 150,
				align :'center'
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
					if(row.id == '3e3807282423416fabbb264871ce8b8e'){
						return '系统用户';
					}else{
						return formatString('<img onclick="admin_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="admin_remove(\'{2}\');" src="{3}"/>&nbsp;<button onclick="reSetPwd(\'{4}\');">重置密码</ button>', row.id, 'style/images/pencil.png', row.id, 'style/images/cancel.png',row.id);
					}
		        }
			}] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					admin_add();
				}
			}, '-', {
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					admin_remove();
				}
			}, '-', {
				text : '批量分配角色',
				iconCls : 'icon-add',
				handler : function() {
					batchSetRole();
				}
			}, '-', {
				text : '注册短信通知授权',
				iconCls : 'icon-add',
				handler : function() {
					msgAuthorize('1');
				}
			}, '-', {
				text : '下单短信通知授权',
				iconCls : 'icon-add',
				handler : function() {
					msgAuthorize('2');
				}
			}, '-'
			],
		});
	});
	
	/**
	 * 重置密码
	 */
	function reSetPwd(id){
	  admin_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'admin/adminAction!toUpdatePassword.action?id='+id,
			width : 500,
			height : 350,
			modal : true,
			title : '重置密码',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#pwd_editForm').form('submit', {
						url : 'admin/adminAction!updatepwd.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									admin_datagrid.datagrid('load');
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
				var index = admin_datagrid.datagrid('getRowIndex', id);
				var rows = admin_datagrid.datagrid('getRows');
				var o = rows[index];
				$('#pwd_editForm').form('load', o);
			}
		});		
	}
	/**
	 * 添加用户
	 */
	function admin_add() {
		$('<div/>').dialog({
			href : 'admin/adminAction!toAdd.action',
			width : 500,
			height : 480,
			modal : true,
			title : '添加用户',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#admin_addForm').form({
						url : 'admin/adminAction!addAdmin.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
								    admin_datagrid.datagrid('load');
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
					$('#admin_addForm').submit();
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	
	/**
	 * 编辑用户
	 */
	function admin_edit(id) {
		admin_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'admin/adminAction!toUpdate.action?id='+id,
			width : 500,
			height : 350,
			modal : true,
			title : '编辑用户',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#admin_editForm').form('submit', {
						url : 'admin/adminAction!updateAdmin.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									admin_datagrid.datagrid('load');
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
				var index = admin_datagrid.datagrid('getRowIndex', id);
				var rows = admin_datagrid.datagrid('getRows');
				var o = rows[index];
				$('#admin_editForm').form('load', o);
			}
		});		
	}
	
	/**
	 * 单条或批量删除用户
	 */	
	function admin_remove(id) {
		var rows;
		if(aid != id){
			admin_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_datagrid.datagrid('checkRow', admin_datagrid.datagrid('getRowIndex', id));
			rows = admin_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
						
					}
					$.ajax({
						url : 'admin/adminAction!dropAdmin.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_datagrid.datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	
	/**
	 * 批量分配角色
	 */
	function batchSetRole() {
		var rows = admin_datagrid.datagrid('getSelections');
		var ids = [];
		if (rows.length > 0) {
			for ( var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			}
			$('<div/>').dialog({
				href : 'admin/adminAction!toBatchSetRole.action',
				width : 350,
				height : 150,
				modal : true,
				title : '批量分配用户角色',
				buttons : [ {
					text : '保存',
					iconCls : 'icon-add',
					handler : function() {
						var d = $(this).closest('.window-body');
						$('#admin_role_addForm').form('submit', {
							url : 'admin/adminAction!addAdminRole.action',
							success : function(result) {
								var r = $.parseJSON(result);
								try {
									if (r.success) {
										admin_datagrid.datagrid('load');
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
					$('#admin_role_addForm').form('load', {
						ids : ids
					});
				}
			});
		} else {
			$.messager.alert('提示','请勾选要设置角色的记录！','info');
		}
	}
	/**
	* 短信通知授权
	*/
	function msgAuthorize(infoType){
		var rows = admin_datagrid.datagrid('getChecked');
		var aid = "";
		if(rows.length == 1){
			for ( var i = 0; i < rows.length; i++) {
				aid = rows[i].id;
			}
			var subtitle = '短信通知授权';	
			if (!$('#tabs').tabs('exists', subtitle)) {
					$('#tabs').tabs('add', {
						title : subtitle,
						href : 'admin/adminAction!toMsgAuthorize.action?aid='+aid+'&infoType='+infoType,
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
	
	
	/**
	 * 检索
	 */	
	function admin_search(){
		admin_datagrid.datagrid('load', sy.serializeObject(admin_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_clean(){
		$('#admin_searchForm input').val('');
		admin_datagrid.datagrid('load', {});	
	}
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>用户名:</th>
					<td><input name="username" placeholder="请输入用户名"/></td>
					<th>创建时间:</th>
					<td><input id="admin_starttime" name="_startTime"  class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_endtime\')}'" />
					          至&nbsp;<input id="admin_endtime" name="_endTime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_starttime\')}'" />
					</td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_datagrid"></table>
	</div>
</div>