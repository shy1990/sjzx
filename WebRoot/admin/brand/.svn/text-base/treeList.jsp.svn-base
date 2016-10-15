<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var brand_list_treegrid;
	var $$ = self.parent.$;
	var pid = '';
	$(function() {
		brand_list_treegrid = $('#brand_list_treegrid').treegrid({
			url : 'brand/brandAction!gainBrandTreeList.action?mark='+1,
			idField : 'id',
			treeField : 'name',
			parentField : 'pid',
			remoteSort : true,
			fit : true,
			fitColumns : true,
			striped : true,
			columns : [ [{
				field : 'id',
				title : 'ID',
				width : 150,
				hidden : true
			}, {
				field : 'pid',
				title : '上级模块ID',
				width : 150,
				hidden : true
			},{
				field : 'name',
				title : '品牌名称',
				width : 150
			},{
				field : 'ptree',
				title : '父类路径',
				width : 200,
				hidden : true
			}, {
				field : 'remark',
				title : '备注',
				width : 150
			}, {
				field : 'grade',
				title : '分类级别',
				width : 150,
				hidden : true
			}, {
				field : 'p_order',
				title : '排序',
				width : 150,
				sortable :true
			}, {
				field : 'action',
				title : '操作',
				width : 100,
				formatter : function(value, row, index) {
					return formatString('<img onclick="brand_edit(\'{0}\',\'{1}\');" src="{2}"/>&nbsp;<img onclick="brand_remove(\'{3}\');" src="{4}"/>', row.id, row.pid, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
				}
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					brand_append();
				}
			}, '-', {
				text : '展开',
				iconCls : 'icon-redo',
				handler : function() {
					var node = brand_list_treegrid.treegrid('getSelected');
					if (node) {
						brand_list_treegrid.treegrid('expandAll', node.cid);
					} else {
						brand_list_treegrid.treegrid('expandAll');
					}
				}
			}, '-', {
				text : '折叠',
				iconCls : 'icon-undo',
				handler : function() {
					var node = brand_list_treegrid.treegrid('getSelected');
					if (node) {
						brand_list_treegrid.treegrid('collapseAll', node.cid);
					} else {
						brand_list_treegrid.treegrid('collapseAll');
					}
				}
			}, '-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					brand_list_treegrid.treegrid('reload');
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
		    	brand_list_treegrid.treegrid('collapseAll');
		    }
		});
	});

	/**
	 * 品牌添加
	 */
	function brand_append() {
		var rows = brand_list_treegrid.treegrid('getSelected');
		if(rows!=null){
			pid = rows.id;
		}
		$('<div/>').dialog({
			href : 'brand/brandAction!toAdd.action?pid='+pid,
			width : 450,
			height : 260,
			modal : true,
			title : '添加品牌',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#brand_addForm').form('submit', {
						url : 'brand/brandAction!addBrand.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									brand_list_treegrid.treegrid('append', {
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
	 * 品牌信息修改
	 */
	function brand_edit(id,pid) {
		if (id != undefined) {
			brand_list_treegrid.treegrid('select', id);
		}
		var node = brand_list_treegrid.treegrid('getSelected');
		$('<div/>').dialog({
			href : 'brand/brandAction!toUpdate.action?id='+id,
			width : 450,
			height : 260,
			modal : true,
			title : '品牌信息编辑',
			buttons : [ {
				text : '编辑',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#brand_editForm').form('submit', {
						url : 'brand/brandAction!updateBrand.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									brand_list_treegrid.treegrid('reload');
									d.dialog('destroy');
									$$.messager.show({
										title : '提示',
										msg : r.msg
									});	
								}else{
									$.messager.alert('提示', r.msg);							
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
				$('#brand_editForm').form('load', node);
			}
		});
	}
	
	/**
	 * 删除相应的品牌信息
	 */
	function brand_remove(id) {
		if (id != undefined) {
			brand_list_treegrid.treegrid('select', id);
		}
		var node = brand_list_treegrid.treegrid('getSelected');
		if (node) {
			$.messager.confirm('询问', '您确定要删除【' + node.name + '】？', function(b) {
				if (b) {
					$.ajax({
						url : 'brand/brandAction!dropBrand.action',
						data : {
							id : node.id
						},
						cache : false,
						dataType : 'JSON',
						success : function(r) {
							if (r.success) {
								brand_list_treegrid.treegrid('remove', r.obj);
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
<table id="brand_list_treegrid" class="easyui-treegrid"></table>