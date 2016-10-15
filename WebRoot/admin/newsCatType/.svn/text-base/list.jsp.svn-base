<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<script type="text/javascript" charset="utf-8">
	
	var newsCatType_list_datagrid;
	$(function() {
			newsCatType_list_datagrid = $('#newsCatType_list_datagrid').datagrid({
			url : 'newsCatType!gainAllList.action',
			pagination : true,
			fit : true,
			striped : true,
			singleSelect:true,
			checkOnSelect:true,
			selectOnCheck:true,
			fitColumns:true ,
			idField:'id',
			sortName : 'id',
			sortOrder : 'desc',
			pageSize : 10,
			pageList : [ 10, 30, 40, 50 ],
			columns : [ [ {
				title : '编号',
				field : 'id',
				align :'center',
				width : 150
			},{
				title : '分类类别名称',
				field : 'name',
				width : 150,
				align :'center',
				sortable:true
			}, {
				title : '描述',
				field : 'remark',
				width : 150,
				align :'center',
				sortable:true
			}, {
				title : '是否显示',
				field : 'disabled',
				width : 150,
				align :'center',
				sortable:true
			}, {
				title : '排序',
				field : 'porder',
				width : 150,
				align :'center',
				sortable:true
			}] ],
			toolbar : [  {
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
			var p = sy.dialog({
				title : '添加类别',
				href : '${pageContext.request.contextPath}/newsCatType!toAdd.action',
				width : 400,
				height : 300,
				buttons : [ {
					text : '添加类别',
					handler : function() {
						var d = $(this).closest('.window-body');
						var f = p.find('form');
						f.form('submit',{
							url : '${pageContext.request.contextPath}/newsCatType!add.action',
							success : function(d) {
								var json = $.parseJSON(d);
								if (json.success) {
									p.dialog('close');
									newsCatType_list_datagrid.datagrid('reload');/*刷新*/
								}
								parent.sy.messagerShow({
									msg : json.msg,
									title : '提示'
								});
							}
						});
					}
				} ],
			});
		};
		var remove=function(){
			var node = newsCatType_list_datagrid.datagrid('getSelected');
			if (node) {
				sy.messagerConfirm('询问','您确定要删除【' + node.name + '】？',
					function(b) {
						if (b) {
							$.ajax({
								url : '${pageContext.request.contextPath}/newsCatType!drop.action',
								data : {id : node.id},
								cache : false,
								dataType : 'JSON',
								success : function(r) {
									if (r.success) {
										newsCatType_list_datagrid.datagrid('reload');/*刷新*/
									}
									parent.sy.messagerShow({
										msg : r.msg,
										title : '提示'
									});
								}
							});
					}
				});
			}else{
				sy.messagerShow({
					msg : "请选择需要删除的行",
					title : '提示'
				});
			}
		};
		var edit=function(){
			var node = newsCatType_list_datagrid.datagrid('getSelected');
			if(node){
				var p = sy.dialog({
						title : '编辑商品分类',
						href : '${pageContext.request.contextPath}/newsCatType!toEdit.action?id='+node.id,
						width : 600,
						height : 400,
						buttons : [ {
							text : '保存',
							handler : function() {
							$('#admin_car_editCarBrand_textarea').val();
								var d = $(this).closest('.window-body');
								var f = p.find('form');
								f.form('submit',{
									url : '${pageContext.request.contextPath}/newsCatType!update.action',
									success : function(d) {
										var json = $.parseJSON(d);
										if (json.success) {
											p.dialog('close');
											newsCatType_list_datagrid.datagrid('reload');/*刷新*/
										}
										sy.messagerShow({
											msg : json.msg,
											title : '提示'
										});
									}
								});
							}
						} ]
					});
			}else{
			sy.messagerShow({
				msg : "请选择商品分类",
				title : '提示'
				});
			}
		};
	});
</script>
<table id="newsCatType_list_datagrid" style="height:680px" data-options="fit:true"></table>
