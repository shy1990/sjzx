<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script>
	var treegrid;
	$(function() {
		var admin_newsCat_add_tableForm = $('#admin_newsCat_add_tableForm');
		treegrid = admin_newsCat_add_tableForm.treegrid({
			url : 'newsCat!gainAll.action',
			idField : 'id',
			treeField : 'name',
			parentField : 'pid',
			fitColumns : true,
			fit:true,
	        onLoadSuccess:function(){
	        	 treegrid.treegrid('collapseAll');
	        },
	        onClickRow: function(node) {
	            if (!treegrid.treegrid('isLeaf', node.id)) {
	                if(node.state=='open'){
						treegrid.treegrid('collapse',node.id);
					}else{
						treegrid.treegrid('expand',node.id);
					}
	            }
	        },
			columns : [ [ {
				title : '文章分类名称',
				field : 'name',
				width : 300
			}, {
				field : 'newsCatType',
				title : '所属类别',
				width : 300
			}, {
				field : 'remark',
				title : '描述',
				width : 300
			}, {
				field : 'porder',
				title : '排序',
				width : 80
			}, {
				field : 'grade',
				title : '深度',
				width : 80
			}, {
				field : 'disabled',
				title : '显示与否',
				width : 100,
				formatter:function(value, row, index){
					if(value=='true'){
						return '不显示';
					}else{
						return '显示';
					}
				}
			}]],
			toolbar : [ {
				text : '展开',
				iconCls : 'icon-redo',
				handler : function() {
					var node = treegrid.treegrid('getSelected');
					if (node) {
						treegrid.treegrid('expandAll', node.cid);
					} else {
						treegrid.treegrid('expandAll');
					}
				}
				}, '-', {
				text : '折叠',
				iconCls : 'icon-undo',
				handler : function() {
					var node = treegrid.treegrid('getSelected');
					if (node) {
						treegrid.treegrid('collapseAll', node.cid);
					} else {
						treegrid.treegrid('collapseAll');
					}
				}
				}, '-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					treegrid.treegrid('reload');
				}
				}, '-', {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					append();
				}
				}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					remove();
				}
				}, '-', {
				text : '编辑',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
				}, '-' ]
		});
		
		var append=function(){
			var node = treegrid.treegrid('getSelected');
			var id="";
			if(node != null){
				id = node.id;
			}
			var p = undefined;
			p=sy.dialog({
			title : '添加菜单',
			href : '${pageContext.request.contextPath}/newsCat!toAdd.action?id='+id,
			width : 500,
			height : 260,
			buttons : [ {
				text : '添加',
				handler : function() {
					var f = p.find('form');
					f.form('submit', {
						url : '${pageContext.request.contextPath}/newsCat!add.action',
						success : function(d) {
							var json = $.parseJSON(d);
							if (json.success) {
								p.dialog('close');
								treegrid.treegrid('reload');/*刷新*/
							}
							sy.messagerShow({
								msg : json.msg,
								title : '提示'
							});
						}
					});
				}
			}]
			});
		};
		var remove=function(){
			var node = treegrid.treegrid('getSelected');
			if (node) {
				sy.messagerConfirm('询问', '您确定要删除【' + node.name + '】？', function(b) {
					if (b) {
						$.ajax({
							url : '${pageContext.request.contextPath}/newsCat!drop.action',
							data : {
								id : node.id
							},
							cache : false,
							dataType : 'JSON',
							success : function(r) {
								if (r.success) {
									treegrid.treegrid('reload');/*刷新*/
								}
								sy.messagerShow({
									msg : r.msg,
									title : '提示'
								});
							}
						});
					}
				});
			}
		};
		var edit=function(){
			var node = treegrid.treegrid('getSelected');
			if (node) {
				var p=undefined;
				p= sy.dialog({
					title : '编辑菜单',
					href : '${pageContext.request.contextPath}/newsCat!toEdit.action?id='+node.id,
					width : 500,
					height : 260,
					buttons : [ {
						text : '编辑',
						handler : function() {
							var f = p.find('form');
							f.form('submit', {
								url : '${pageContext.request.contextPath}/newsCat!edit.action',
								success : function(d) {
									var json = $.parseJSON(d);
									if (json.success) {
										p.dialog('close');
										treegrid.treegrid('reload');/*刷新*/
									}
									parent.sy.messagerShow({
										msg : json.msg,
										title : '提示'
									});
								}
							});
						}
					} ]
				});
				
			} else {
				$.messager.alert('提示', '请选中要编辑的记录！', 'error');
			}
		};
	});
</script>
<table id="admin_newsCat_add_tableForm"></table>
