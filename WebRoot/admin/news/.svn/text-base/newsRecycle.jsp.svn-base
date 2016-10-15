<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script>
	$(function(){
		var newsRecycle_list_datagrid=$('#newsRecycle_list_datagrid').datagrid({
			url : 'news!gainAllRecycle.action',
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
			pageSize : 10,
			pageList : [ 10, 30, 40, 50 ],
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '文章主标题',
				field : 'firstTitle',
				width : 150,
				align :'center',
				sortable:true
			},{
				title : '文章副标题',
				field : 'secondTitle',
				width : 150,
				align :'center',
				sortable:true,
				formatter:function(value, row, index){
					if(value==''){
							return '无';
						}else{
							return value;
						}
					}
			}, {
				title : '文章分类',
				field : 'newsCatName',
				width : 150,
				align :'center',
				sortable:true
			}, {
				title : '创建时间',
				field : 'createtime',
				width : 150,
				align :'center',
				sortable:true
			},{
				title : '修改时间',
				field : 'modifytime',
				width : 150,
				align :'center',
				sortable:true
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
				sortable:true
			},{
				title : '关键字',
				field : 'keywords',
				width : 150,
				align :'center',
				sortable:true
			},{
				title : '文章描述',
				field : 'description',
				width : 150,
				align :'center',
				sortable:true
			},{
				title : '作者',
				field : 'author',
				width : 150,
				align :'center',
				sortable:true
			},{
				title : '文章属性',
				field : 'newsattr',
				width : 150,
				align :'center',
				sortable:true
			},{
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					return formatString('<img onclick="newsRecycle_recoverById(\'{0}\');" src="{1}"/>&nbsp;<img onclick="newsRecycle_dropById(\'{2}\');" src="{3}"/>', row.id, 'style/images/redo.png', row.id, 'style/images/cancel.png');
		        }
			}] ],
			toolbar : [ {
				text : '批量删除',
				iconCls : 'icon-cut',
				handler : function() {
					newsRecycle_drop();
				}
				}, '-', {
				text : '批量恢复',
				iconCls : 'icon-redo',
				handler : function() {
					newsRecycle_recover();
				}
				}, '-', {
				text : '取消所有选中',
				iconCls : 'icon-tip',
				handler : function() {
					$('#newsRecycle_list_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');	
				}
				}, '-' ]
		});
		
		var newsRecycle_drop=function(){
			var rows=newsRecycle_list_datagrid.datagrid('getSelections');
			var ids=[];
			if(rows.length>0){
				$.messager.confirm('Confirm','确定要删除?删除后该文章后不能恢复!',function(r){   
				    if (r){   
				    	for ( var int = 0; int < rows.length; int++) {
							var id = rows[int].id;
							ids.push(id);
						}
						$.ajax({
							url : 'news!drop.action',
							data : {
								ids : ids.join(',')
							},
							dataType : 'json',
							success : function(result) {
								if (result.success) {
									newsRecycle_list_datagrid.datagrid('load');
									newsRecycle_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
		var newsRecycle_recover=function(){
			var rows=newsRecycle_list_datagrid.datagrid('getSelections');
			var ids=[];
			if(rows.length>0){
				$.messager.confirm('Confirm','确定要恢复?',function(r){   
				    if (r){   
				    	for ( var int = 0; int < rows.length; int++) {
							var id = rows[int].id;
							ids.push(id);
						}
						$.ajax({
							url : 'news!recover.action',
							data : {
								ids : ids.join(',')
							},
							dataType : 'json',
							success : function(result) {
								if (result.success) {
									newsRecycle_list_datagrid.datagrid('load');
									newsRecycle_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
									if($('#news_list_datagrid')){
										$('#news_list_datagrid').datagrid('load');
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
		newsRecycle_recoverById=function(id){
			var ids=[];
			$.messager.confirm('Confirm','确定要恢复?',function(r){   
			    if (r){   
					ids.push(id);
					$.ajax({
						url : 'news!recover.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								newsRecycle_list_datagrid.datagrid('load');
								newsRecycle_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								if($('#news_list_datagrid')){
									$('#news_list_datagrid').datagrid('load');
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
		newsRecycle_dropById=function(id){
			var ids=[];
			$.messager.confirm('Confirm','确定要删除?删除后该文章后不能恢复!',function(r){   
			    if (r){   
					ids.push(id);
					$.ajax({
						url : 'news!drop.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								newsRecycle_list_datagrid.datagrid('load');
								newsRecycle_list_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false" id="admin_newsRecycle_list">
	<div data-options="region:'north',border:false,split:false" style='height:98px;overflow: hidden'>
		<div class="easyui-panel" data-options="border:false">
			<form class="easyui-form" id="newsRecycle_list_searchForm" method="post">
				<table class='tableForm datagrid-toolbar'
					style="width:100%;height: 100%">
					<tr>
						<th>文章标题:</th>
						<td><input name="bn" class="easyui-validatebox" placeholder="请输入原厂编号"/>
						</td>
						<th>作者:</th>
						<td><input name="productBn" class="easyui-validatebox" placeholder="请输入商品货号"/>
						</td>
						<th>审核状态:</th>
						<td><input>
						</td>
						<th>备用查询:</th>
						<td>
						</td>
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
						<td><a class='easyui-linkbutton' onclick="goods_list_search()"
							data-options="plain:true,iconCls:'icon-search'"
							href='javascript:void(0)'>查询</a> <a class='easyui-linkbutton'
							onclick="goods_list_clean()"
							data-options="plain:true,iconCls:'icon-reload'"
							href='javascript:void(0)'>清空</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div data-options="region:'center',border:false,split:false">
		<table id="newsRecycle_list_datagrid">
		</table>
	</div>
</div>