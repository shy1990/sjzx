<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var module_list_treegrid;
	var $$ = self.parent.$;
	var pid = '';
	$(function() {
		module_list_treegrid = $('#module_list_treegrid').treegrid({
			url : 'module/moduleAction!gainModuleTreeList.action?mark='+1,
			idField : 'id',
			treeField : 'name',
			parentField : 'pid',
			fit : true,
			fitColumns : true,
			striped : true,
			columns : [ [{
				field : 'name',
				title : '模块名称',
				width : 150
			}, {
				field : 'icon',
				title : '模块图标',
				width : 60,
				formatter : function(value) {
					if (!value) {
						return '---';
					} else {
						return formatString('<span class="{0}" style="display:inline-block;vertical-align:middle;width:16px;height:16px;"></span>', value);
					}
				}
			}, {
				field : 'url',
				title : '模块路径',
				width : 200
			}, {
				field : 'pid',
				title : '上级模块ID',
				width : 150,
				hidden : true
			}, {
				field : 'createtime',
				title : '添加时间',
				width : 80
			}, {
				field : 'action',
				title : '动作',
				width : 50,
				formatter : function(value, row, index) {
					return formatString('<img onclick="module_edit(\'{0}\',\'{1}\');" src="{2}"/>&nbsp;<img onclick="module_remove(\'{3}\');" src="{4}"/>', row.id, row.pid, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
				}
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					module_append();
				}
			}, '-', {
				text : '展开',
				iconCls : 'icon-redo',
				handler : function() {
					var node = module_list_treegrid.treegrid('getSelected');
					if (node) {
						module_list_treegrid.treegrid('expandAll', node.cid);
					} else {
						module_list_treegrid.treegrid('expandAll');
					}
				}
			}, '-', {
				text : '折叠',
				iconCls : 'icon-undo',
				handler : function() {
					var node = module_list_treegrid.treegrid('getSelected');
					if (node) {
						module_list_treegrid.treegrid('collapseAll', node.cid);
					} else {
						module_list_treegrid.treegrid('collapseAll');
					}
				}
			}, '-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					module_list_treegrid.treegrid('reload');
				}
			} ],
			onContextMenu : function(e, row) {
				e.preventDefault();
				$(this).treegrid('unselectAll');
				$(this).treegrid('select', row.id);
				$('#admin_cdgl_menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			},
		    onLoadSuccess :function(){
		    	module_list_treegrid.treegrid('collapseAll');
		    }
		});
	});

	/**
	 * 模块添加
	 */
	function module_append() {
		var rows = module_list_treegrid.treegrid('getSelected');
		if(rows!=null){
			pid = rows.id;
		}
		$('<div/>').dialog({
			href : 'module/moduleAction!toAdd.action?pid='+pid,
			width : 450,
			height : 230,
			modal : true,
			title : '添加模块',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#module_addForm').form('submit', {
						url : 'module/moduleAction!addModule.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									module_list_treegrid.treegrid('append', {
										parent : r.obj.pid,
										data : [ r.obj ]
									});
									d.dialog('destroy');
									$$.messager.show({
										title : '提示',
										msg : r.msg
									});									
								}else{
									$.messager.alert('提示', r.msg);							
								}
							} catch (e) {
								$.messager.alert('提示', r.msg);
							}
						}
					});
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	
	/**
	 * 模块修改
	 */
	function module_edit(id,pid) {
		if (id != undefined) {
			module_list_treegrid.treegrid('select', id);
		}
		var node = module_list_treegrid.treegrid('getSelected');
		$('<div/>').dialog({
			href : 'module/moduleAction!toUpdate.action?id='+id,
			width : 450,
			height : 230,
			modal : true,
			title : '模块编辑',
			buttons : [ {
				text : '编辑',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#module_editForm').form('submit', {
						url : 'module/moduleAction!updateModule.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									window.location.href="loginAction!doNotNeedSession_login.action";
									/*module_list_treegrid.treegrid('reload');
									d.dialog('destroy');
									$$.messager.show({
										title : '提示',
										msg : r.msg
									});*/	
								}
							} catch (e) {
								$$.messager.alert('提示', r.msg);
							}
						}
					});
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				$('#module_editForm').form('load', node);
			}
		});
	}
	
	/**
	 * 删除模块
	 */
	function module_remove(id) {
		if (id != undefined) {
			module_list_treegrid.treegrid('select', id);
		}
		var node = module_list_treegrid.treegrid('getSelected');
		if (node) {
			$.messager.confirm('询问', '您确定要删除【' + node.name + '】？', function(b) {
				if (b) {
					$.ajax({
						url : 'module/moduleAction!dropModule.action',
						data : {
							id : node.id
						},
						cache : false,
						dataType : 'JSON',
						success : function(r) {
							if (r.success) {
								module_list_treegrid.treegrid('remove', r.obj);
								$$.messager.show({
									msg : r.msg,
									title : '提示'
								});
							}else{
								$$.messager.alert('提示',r.msg);
							}
						}
					});
				}
			});
		}
	}
</script>
<table id="module_list_treegrid" class="easyui-treegrid"></table>