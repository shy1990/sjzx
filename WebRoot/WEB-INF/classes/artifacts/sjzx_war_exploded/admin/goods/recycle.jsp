<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_recycle_datagrid;
	var editRow = undefined;
	var gid = undefined;
	var admin_goods_searchForm;
	$(function(){	
		admin_goods_searchForm = $('#admin_goods_searchForm');
		admin_recycle_datagrid = $('#admin_recycle_datagrid').datagrid({
			url : 'goods/goodsAction!gainRecycleList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			pagination : true,
			pageSize : 5,
			pageList : [ 5, 10, 40 ,50 ],			
			nowrap : false,
			striped : true,
			remoteSort : true,
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '商品名称',
				field : 'name',
				width : 150,
				align :'center',
 				formatter: function(value,row,index){				
					return formatString('<a id="btn" style="text-decoration:underline;color:#f00" onclick="gainGoods(\'{0}\');">'+value+'</a>', row.id);				
		        } 
										
			},{
				title : '品牌',
				field : 'brandName',
				width : 150,
				align :'center'			
			}, {
				title : '商品代码',
				field : 'goodsNum',
				width : 150,
				align :'center'			
			},{
				title : '规格代码',
				field : 'skuNum',
				width : 150,
				align :'center'
			},{
				title : '库存',
				field : 'stock',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<a id="btn" style="text-decoration:underline;color:#f00" onclick="editRecyclePriceandStock(\'{0}\');">'+value+'</a>', row.id);				
		        } 
			},{
				title : '单价',
				field : 'pstring',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<a id="btn" style="text-decoration:underline;color:#f00" onclick="editRecyclePriceandStock(\'{0}\');">'+value+'</a>', row.id);				
		        } 
			},{
				title : '颜色',
				field : 'colorName',
				width : 150,
				align :'center'
			},{
				title : '最后操作人',
				field : 'userName',
				width : 150,
				align :'center'
			}, {
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<img onclick="admin_goods_recover(\'{0}\');" src="{1}"/>',row.id,'style/images/redo.png');									
					/* return formatString('<img onclick="admin_goods_recover(\'{0}\');" src="{1}"/>&nbsp;<img onclick="admin_goods_drop(\'{2}\');" src="{3}"/>',row.id,'style/images/redo.png', row.id,'style/images/cancel.png');	 */								
		        }			
			}] ],
/* 			toolbar : [{
				text : '批量恢复',
				iconCls : 'icon-redo',
				handler : function() {
					admin_goods_recover();
				}
			}, '-',{ */
				/* text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					admin_goods_drop();
				}
			}, '-',{ */
/* 				text : '取消所有选中',
				iconCls : 'icon-tip',
				handler : function() {
					admin_goods_cancelSelect();
				}
			}], */
			
		});
		
		$('#admin_goods_searchForm input').keydown(function(event){
			if(event.keyCode==13){
				admin_goods_search();
			}
		});
	});

	/**
	 * 查看具体商品信息
	 */
  	gainGoods = function(id) {
 		admin_recycle_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
 		var subtitle="查看宝贝仓库的商品信息";
 		var url="goods/goodsAction!toShowGoods.action?id="+id;
 		$('#admin_showGoods_showForm').form('load', {});
  		if(!$('#tabs').tabs('exists',subtitle)){
 	 		$('#tabs').tabs('add',{
	 			title : subtitle,
	 			href :url,
	 			closable : true
	 		});
 		}else{
			$('#tabs').tabs('select', subtitle);
			$('#mm-tabupdate').click();	
 		}
 		tabClose();
	};

	/**
	 * 恢复删除的商品信息
	 */
	admin_goods_recover = function(id){
	    var rows;
		if(gid != id){
			admin_recycle_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_recycle_datagrid.datagrid('checkRow', admin_recycle_datagrid.datagrid('getRowIndex', id));
			rows = admin_recycle_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_recycle_datagrid.datagrid('getSelections');
		}
	    
		var ids=[];
		if(rows.length>0){
			$.messager.confirm('Confirm','确定要恢复?',function(r){   
			    if (r){   
			    	for ( var int = 0; int < rows.length; int++) {
						var id = rows[int].id;
						ids.push(id);
					}
					$.ajax({
						url : 'goods/goodsAction!recoverGoods.action?ids='+ids,
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_recycle_datagrid.datagrid('load');
								admin_recycle_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								if($('#admin_goods_datagrid')){
									$('#admin_goods_datagrid').datagrid('load');
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
				msg : '请勾选要恢复的记录！'
			});
		}
	};

	/**
	 * 单条或批量删除goods
	 */	
	function admin_goods_drop(id) {		
		var rows;
		if(gid != id){
			admin_recycle_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_recycle_datagrid.datagrid('checkRow', admin_recycle_datagrid.datagrid('getRowIndex', id));
			rows = admin_recycle_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_recycle_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您确定删除？删除后该商品不能恢复!', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : 'goods/goodsAction!dropGoods.action?ids='+ids,
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_recycle_datagrid.datagrid('load');
								admin_recycle_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								if($('#admin_goods_datagrid')){
									$('#admin_goods_datagrid').datagrid('load');
								}								
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_recycle_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	/**
	 * 取消所有选中
	 */
	 admin_goods_cancelSelect=function(){
			admin_recycle_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');	
		};
	/**
	 * 检索
	 */	
	function admin_goods_search(){
		admin_recycle_datagrid.datagrid('load',sy.serializeObject(admin_goods_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_goods_clean(){
		$('#admin_goods_searchForm input').val('');
		admin_recycle_datagrid.datagrid('load', {});	
	}
	/**
	 * 把宝贝仓库商品单品恢复时，进行价格库存的修改
	 */	
	 editRecyclePriceandStock = function(id){
	 	//alert("id==="+id);
	 	$('<div/>').dialog({
	 		href : 'goods/goodsAction!toEditPriceandStock.action?id='+id,
			width : 600,
			height : 300,
			modal : true,
			title : '编辑单品价格和库存',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					if(validPreTable()==false){
						return;
					}
					$('#admin_sku_editForm').form('submit', {
						url : 'goods/goodsAction!updatePriceandStock.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									admin_recycle_datagrid.datagrid('load');
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
				var index = admin_recycle_datagrid.datagrid('getRowIndex', id);
				var rows = admin_recycle_datagrid.datagrid('getRows');
				var o = rows[index];
				$('#admin_sku_editForm').form('load', o);
			}
	 	});
	 };
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_goods_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>商品名称:</th>
					<td><input name="name" placeholder="请输入商品名称"/></td>
					<th>商品编号:</th>
					<td><input id="goodsNum" name="goodsNum" placeholder="请输入商品编号"/></td>
					<th>商品代码:</th>
					<td><input name="goodsNum" placeholder="请输入商品代码"/></td>
					<th>规格代码:</th>
					<td><input name="skuNum" placeholder="请输入规格代码"/></td>
					<th>最后操作人:</th>
					<td><input name="userName" placeholder="请输入最后操作人"/></td>
					<th>商品品牌:</th>
					<td>
						<span style="padding-left:10px">
							<input id="brandName" name="brandName" class="easyui-combobox" 
							data-options="url:'goods/goodsAction!gainGoodsBrandName.action',valueField:'brandName',textField:'brandName',editable:false,multiple:false"/>
						</span>
					</td>		
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_goods_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_goods_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_recycle_datagrid"></table>
	</div>
</div>