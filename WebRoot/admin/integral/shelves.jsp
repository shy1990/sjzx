<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_shelves_integral_datagrid;
	var editRow = undefined;
	var nid = undefined;
	var admin_shelves_integral_searchForm;
	$(function(){	
		admin_shelves_integral_searchForm = $('#admin_shelves_integral_searchForm');
		admin_shelves_integral_datagrid = $('#admin_shelves_integral_datagrid').datagrid({
			url : 'integral/integralAction!gainShelvesIntegralGoodsList.action',
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
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<a id="btn" style="text-decoration:underline;color:#f00" onclick="editRecoverPrice(\'{0}\');">'+value+'</a>', row.id);				
		        } 
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
				title : '下架时间',
				field : 'shelvesTime',
				width : 150,
				align :'center',
			
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
					return formatString('<img onclick="admin_integral_recover(\'{0}\')" src="{1}"/>',row.id,'style/images/redo.png');									
		        }		 	
			}] ],
			
		});
	});

	/**
	 * 检索
	 */	
	function admin_integral_search(){
		admin_shelves_integral_datagrid.datagrid('load',sy.serializeObject(admin_shelves_integral_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_integral_clean(){
		$('#admin_shelves_integral_searchForm input').val('');
		admin_shelves_integral_datagrid.datagrid('load', {});	
	}
	/**
	 * 积分商品恢复
	 */
	admin_integral_recover = function(id){
		var rows;
		if(nid != id){
			admin_shelves_integral_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_shelves_integral_datagrid.datagrid('checkRow', admin_shelves_integral_datagrid.datagrid('getRowIndex', id));
			rows = admin_shelves_integral_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_shelves_integral_datagrid.datagrid('getSelections');
		}
		if (rows.length > 0) {
			$.messager.confirm('确认', '确定要恢复?', function(r) {
				if (r) {
					$.ajax({
						url : 'integral/integralAction!recoverShelves.action?id='+id,
						//data : {'id' : id},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_shelves_integral_datagrid.datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_shelves_integral_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要下架的配件！','info');
		}
	};
	
	/**
	 * 修改积分商品价格
	 */
	 editRecoverPrice = function(id){
	 	$('<div/>').dialog({
	 		href : 'integral/integralAction!toEditPrice.action?id='+id,
			width : 400,
			height : 300,
			modal : true,
			title : '编辑积分商品价格',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					if(validPreTable()==false){
						return;
					}
					$('#admin_integral_recover_editForm').form('submit', {
						url : 'integral/integralAction!updatePrice.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									admin_shelves_integral_datagrid.datagrid('load');
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
				var index = admin_shelves_integral_datagrid.datagrid('getRowIndex', id);
				var rows = admin_shelves_integral_datagrid.datagrid('getRows');
				var o = rows[index];
				$('#admin_integral_recover_editForm').form('load', o);
			}
	 	});
	 };
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_shelves_integral_searchForm">
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
	   <table id="admin_shelves_integral_datagrid"></table>
	</div>
</div>