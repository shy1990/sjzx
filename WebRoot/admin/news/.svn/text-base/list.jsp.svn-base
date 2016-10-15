<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script>

	var news_list_search;
	var news_list_clean;
	$(function(){
		var news_list_searchForm = $('#news_list_searchForm');
		
		var news_list_datagrid=$('#news_list_datagrid').datagrid({
			url : 'news!gainAll.action',
			pagination : true,
			fit : true,
			striped : true,
			singleSelect:false,
			checkOnSelect:true,
			selectOnCheck:true,
			fitColumns:true ,
			idField:'id',
			sortName : 'createtime',
			sortOrder : 'desc',
			pageSize : 30,
			pageList : [ 10, 30, 40, 50 ],
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '文章标题',
				field : 'firstTitle',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index) {
					if(value!=undefined){
						var s = '<span title='+value+'>' + value + '</span>';
						return s;
					}
				}
			},{
				title : '文章摘要',
				field : 'secondTitle',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index) {
					if(value!=undefined){
						var s = '<span title='+value+'>' + value + '</span>';
						return s;
					}
				}
			}, {
				title : '文章分类',
				field : 'newsCatName',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index) {
					if(value!=undefined){
						var s = '<span title='+value+'>' + value + '</span>';
						return s;
					}
				}
			}, {
				title : '创建时间',
				field : 'createtime',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index) {
					if(value!=undefined){
						var s = '<span title='+value+'>' + value + '</span>';
						return s;
					}
				}
			},{
				title : '修改时间',
				field : 'modifytime',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index) {
					if(value!=undefined){
						var s = '<span title='+value+'>' + value + '</span>';
						return s;
					}
				}
			},{
				title : '审核状态',
				field : 'status',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index){
					if(value=='true'){
							return '通过';
						}else{
							return '不通过';
						}
					},
				styler: function(value,row,index){
					if(value=='true'){
							return 'color:green;';
						}else{
							return 'color:red;';
						}
					}
			},{
				title : '文章来源',
				field : 'resources',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index) {
					if(value!=undefined){
						var s = '<span title='+value+'>' + value + '</span>';
						return s;
					}
				}
			},{
				title : '关键字',
				field : 'keywords',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index) {
					if(value!=undefined){
						var s = '<span title='+value+'>' + value + '</span>';
						return s;
					}
				}
			},{
				title : '文章描述',
				field : 'description',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index) {
					if(value!=undefined){
						var s = '<span title='+value+'>' + value + '</span>';
						return s;
					}
				}
			},{
				title : '作者',
				field : 'author',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index) {
					if(value!=undefined){
						var s = '<span title='+value+'>' + value + '</span>';
						return s;
					}
				}
			},{
				title : '文章属性',
				field : 'newsattr',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index) {
					if(value!=undefined){
						var s = '<span title='+value+'>' + value + '</span>';
						return s;
					}
				}
			},{
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					return formatString('<img onclick="admin_news_list_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="admin_news_list_remove(\'{2}\');" src="{3}"/>', row.id, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
		        }
			}] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					news_append();
				}
				}, '-', {
				text : '批量删除',
				iconCls : 'icon-cut',
				handler : function() {
					news_remove();
				}
				}, '-', {
				text : '取消所有选中',
				iconCls : 'icon-tip',
				handler : function() {
					$('#news_list_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');	
				}
				}, '-' ]
		});
		
		admin_news_list_edit=function(id){
			news_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			var subtitle="文章编辑";
			var url="news!toEdit.action?id="+id;
			var icon="icon icon-magic";
			if (!$('#tabs').tabs('exists', subtitle)) {
					$('#tabs').tabs('add', {
						title : subtitle,
						href:url,
						closable : true,
						icon:icon
					});
			} else {
				$.messager.alert('提示','已经打开一个编辑页面!','info');
				return;
				$('#tabs').tabs('select', subtitle);
				$('#mm-tabupdate').click();
			}
			tabClose();
		};
		admin_news_list_remove=function(id){
			var ids=[];
			$.messager.confirm('Confirm','确定要删除?如果恢复请到回收站查看',function(r){   
			    if (r){   
					ids.push(id);
					$.ajax({
						url : 'news!delete.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								news_list_datagrid.datagrid('load');
								news_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								if($('#newsRecycle_list_datagrid')){
									$('#newsRecycle_list_datagrid').datagrid('load');
								}
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
			    }   
			});  
		};
		var news_append=function(){
			news_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			var subtitle="文章添加";
			var url="news!toAdd.action";
			var icon="icon icon-magic";
			if (!$('#tabs').tabs('exists', subtitle)) {
					$('#tabs').tabs('add', {
						title : subtitle,
						href:url,
						closable : true,
						icon:icon
					});
			} else {
				$('#tabs').tabs('select', subtitle);
				$('#mm-tabupdate').click();
			}
			tabClose();
		};
		
		var news_remove=function(){
			var rows=news_list_datagrid.datagrid('getSelections');
			var ids=[];
			if(rows.length>0){
				$.messager.confirm('Confirm','确定要删除?如果恢复请到回收站查看',function(r){   
				    if (r){   
				    	for ( var int = 0; int < rows.length; int++) {
							var id = rows[int].id;
							ids.push(id);
						}
						$.ajax({
							url : 'news!delete.action',
							data : {
								ids : ids.join(',')
							},
							dataType : 'json',
							success : function(result) {
								if (result.success) {
									news_list_datagrid.datagrid('load');
									news_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
									if($('#newsRecycle_list_datagrid')){
										$('#newsRecycle_list_datagrid').datagrid('load');
									}
								}
								$.messager.show({
									title : '提示',
									msg : result.msg
								});
							}
						});
				    }   
				});  
			}else {
				$.messager.show({
					title : '提示',
					msg : '请勾选要删除的记录！'
				});
			}
		};
		news_list_search = function() {
			news_list_datagrid.datagrid('load', sy.serializeObject(news_list_searchForm));
		};
		news_list_clean = function() {
			$('#news_list_searchForm input').val("");
			news_list_datagrid.datagrid('load', {});
		};
		
		$('#news_list_searchForm input').keydown(function(event){
			if(event.keyCode==13){
				news_list_search();
			}
		});
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false" id="admin_news_list">
	<div data-options="region:'north',border:false,split:false" style='height:68px;overflow: hidden'>
		<div class="easyui-panel" data-options="border:false">
			<form class="easyui-form" id="news_list_searchForm" method="post">
				<table class='tableForm datagrid-toolbar'
					style="width:100%;height: 100%">
					<tr>
						<th>文章标题:</th>
						<td><input name="firstTitle" class="easyui-validatebox" placeholder="请输入文章标题"/>
						<th>文章分类:</th>
						<td><input name="newsCatName" class="easyui-validatebox" placeholder="请输入文章分类"/>
						<th>首页显示:</th>
						<td><input name="kz1"  type="checkbox" value="true" style="width:auto; "/></td>
					</tr>
					<tr>
						<th>创建时间:</th>
						<td><input name="_startTime" id="admin_goods_list_starttime" class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_goods_list_endtime\')}'"/>之后
						<th>创建时间:</th>
						<td>
						<input name="_endTime"
							id="admin_goods_list_endtime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_goods_list_starttime\')}'"/>之前
						</td>
						<th>操作:</th>
						<td><a class='easyui-linkbutton' onclick="news_list_search()"
							data-options="plain:true,iconCls:'icon-search'"
							href='javascript:void(0)'>查询</a> <a class='easyui-linkbutton'
							onclick="news_list_clean()"
							data-options="plain:true,iconCls:'icon-reload'"
							href='javascript:void(0)'>清空</a>
						</td>
					</tr>
					<tr>
						
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div data-options="region:'center',border:false,split:false">
		<table id="news_list_datagrid">
		</table>
	</div>
</div>