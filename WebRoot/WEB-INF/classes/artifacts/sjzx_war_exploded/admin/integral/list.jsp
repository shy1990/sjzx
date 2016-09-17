<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_integral_datagrid;
	var editRow = undefined;
	var nid = undefined;
	var admin_integral_searchForm;
	$(function(){	
		admin_integral_searchForm = $('#admin_integral_searchForm');
		admin_integral_datagrid = $('#admin_integral_datagrid').datagrid({
			url : 'integral/integralAction!gainIntegralGoodsList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			pagination : true,
			pageSize : 20,
			pageList : [ 5, 10, 20, 40 ,50 ],			
			nowrap : false,
			striped : true,
			remoteSort : true,
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 120,
				checkbox : true
			},{
				title : '积分商品名称',
				field : 'name',
				width : 250,
				align :'center'
			},{
				title : '商品代码',
				field : 'integralCode',
				width : 120,
				align :'center'
			},{
				title : '规格代码',
				field : 'specCode',
				width :  120,
				align :'center'
			},{
				title : '图片地址',
				field : 'pic',
				width : 120,
				align :'center',
				formatter: function(value,row,index){				
					if(value!=null&&value!=''){
						return formatString('<img width="60px" height="40px" src="{0}"/>', value);
					}	
		        }
								
			},{
				title : '价格',
				field : 'price',
				width : 120,
				align :'center'
			},{
				title : '库存',
				field : 'stock',
				width : 120,
				align :'center'
			},{
				title : '是否上架',
				field : 'isshelves',
				width : 120,
				align :'center',
				formatter: function(value,row,index){				
					if(value=="true"){
						value="上架";
					}else if(value=="false"){
						value="下架";
					}	
					return value;			
		        },
		        styler: function(value,row,index){
					if (value == "true"){
						return 'color:green';
					}else if(value=="false"){
						return 'color:red';
					}
				} 
			},{
				title : '换取所需积分',
				field : 'integral',
				width : 120,
				align :'center'
			},{
				title : '商品类型',
				field : 'type',
				width : 120,
				align :'center',
				formatter: function(value,row,index){				
					if(value=="手机相关"){
						value="手机相关";
					}else if(value=="生活用品"){
						value="生活用品";
					}	
					return value;			
		        },
		        styler: function(value,row,index){
					if (value == "手机相关"){
						return 'color:green;';
					}else if(value=="生活用品"){
						return 'color:#f00;';
					}
				} 
			},{
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<img onclick="admin_integral_edit(\'{0}\');" src="{1}"/>&nbsp;&nbsp;<img onclick="admin_integral_remove(\'{2}\');" src="{3}"/>&nbsp;&nbsp;<img onclick="admin_integral_shelves(\'{4}\')" src="{5}"/>',row.id,'style/images/pencil.png', row.id,'style/images/cancel.png',row.id,'style/images/tip.png');									
		        }			
			}] ],
			toolbar : [{
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					admin_integral_add();
				}
			}, '-',{
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					admin_integral_remove();
				}
			}],
			
		});
	});

	/**
	 * 添加积分商品信息
	 */
	function admin_integral_add(){
		$('<div/>').dialog({
			href : "integral/integralAction!toAdd.action",
			width : 480,
			height : 400,
			modal : true,
			title : '添加积分商品',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
 					if(flag1 == false){
						return;
					}
					if(flag2 == false){
						return;
					} 
					if(validPreTable()==false){
						return;
					}
					if(priceCall()==false){
						return;
					}
					$('#admin_integral_addForm').form({
						url : 'integral/integralAction!addIntegralGoods.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
								    admin_integral_datagrid.datagrid('load');
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
					$('#admin_integral_addForm').submit();
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	/**
	 * 编辑积分商品信息
	 */
	function admin_integral_edit(id) {
		admin_integral_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : "integral/integralAction!toUpdate.action?id="+id,
			width : 480,
			height : 400,
			modal : true,
			title : '修改积分商品',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					if(flag1 == false){
						return;
					}
					if(flag2 == false){
						return;
					} 
					if(validPreTable()==false){
						return;
					}
					if(priceCall()==false){
						return;
					}
					$("#admin_integral_editForm").form('submit', {
						url :'integral/integralAction!updateIntegralGoods.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									admin_integral_datagrid.datagrid('load');
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
				var index = admin_integral_datagrid.datagrid('getRowIndex', id);
				var rows = admin_integral_datagrid.datagrid('getRows');
				var o = rows[index];
				$("#admin_integral_editForm").form('load', o);
			}
		});		
	}
	/**
	 * 单条或批量删除配件信息
	 */		
	function admin_integral_remove(id) {
		var rows;
		if(nid != id){
			admin_integral_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_integral_datagrid.datagrid('checkRow', admin_integral_datagrid.datagrid('getRowIndex', id));
			rows = admin_integral_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_integral_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : 'integral/integralAction!dropIntegralGoods.action?ids='+ids,
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_integral_datagrid.datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_integral_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	/**
	 * 检索
	 */	
	function admin_integral_search(){
		admin_integral_datagrid.datagrid('load',sy.serializeObject(admin_integral_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_integral_clean(){
		$('#admin_integral_searchForm input').val('');
		admin_integral_datagrid.datagrid('load', {});	
	}
	/**
	 * 下架积分商品
	 */
	admin_integral_shelves = function(id){
		var rows;
		if(nid != id){
			admin_integral_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_integral_datagrid.datagrid('checkRow', admin_integral_datagrid.datagrid('getRowIndex', id));
			rows = admin_integral_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_integral_datagrid.datagrid('getSelections');
		}
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要下架当前选中的积分商品，如果下架该商品，其库存、价格将默认为0!', function(r) {
				if (r) {
					$.ajax({
						url : 'integral/integralAction!updateShelves.action?id='+id,
						//data : {'id' : id},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_integral_datagrid.datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_integral_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要下架的积分商品！','info');
		}
	};
	
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_integral_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>积分商品名称:</th>
					<td><input name="name" placeholder="请输入积分商品名称"/></td>
					<th>商品代码:</th>
					<td><input name="integralCode" placeholder="请输入商品代码"/></td>
					<th>规格代码:</th>
					<td><input name="specCode" placeholder="请输入规格代码"/></td>
					<th>商品类型:</th>
					<td>
						<select name="type" style="width:120px;">
							<option value="-1">请选择</option>
							<option value="手机相关">手机相关</option>
							<option value="生活用品">生活用品</option>
							<option value="店铺推广">店铺推广</option>
						</select>
					</td>
					<th>操作:</th>
					<td>																											
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_integral_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_integral_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_integral_datagrid"></table>
	</div>
</div>