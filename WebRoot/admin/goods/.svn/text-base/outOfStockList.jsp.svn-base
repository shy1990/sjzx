<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_sku_datagrid;
	var editRow = undefined;
	var gid = undefined;
	var goods_list_import;
	var admin_sku_searchForm;
	$(function(){	
		admin_sku_searchForm = $('#admin_sku_searchForm');
		admin_sku_datagrid = $('#admin_sku_datagrid').datagrid({
			url : 'sku/skuAction!gainSkuOutOfSockList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			pagination : true,
			pageSize : 20,
			pageList : [ 5, 10,20, 40 ,50 ],			
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
				field : 'goodsName',
				width : 150,
				align :'center'
/* 				formatter: function(value,row,index){				
					return formatString('<a id="btn" onclick="g0ainGoods(\'{0}\');">'+value+'</a>', row.id);				
		        } */
										
			}, {
				title : '商品品牌',
				field : 'brandName',
				width : 150,
				align :'center'
			},{
				title : '商品代码',
				field : 'skuCode',
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
				align :'center'
			} ,{
				title : '下架时间',
				field : 'shelvesTime',
				width : 150,
				align :'center'
			} ] ],
			
		});
		
		$('#admin_sku_searchForm input').keydown(function(event){
			if(event.keyCode==13){
				admin_sku_search();
			}
		});
	});

	
	
	
	
	/**
	 * 检索
	 */	
	function admin_sku_search(){
		admin_sku_datagrid.datagrid('load',sy.serializeObject(admin_sku_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_sku_clean(){
		$('#admin_sku_searchForm input').val('');
		admin_sku_datagrid.datagrid('load', {});	
	}
	
	
		
		
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_sku_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>商品名称:</th>
					<td><input name="goodsName" placeholder="请输入商品名称"/></td>
					<th>商品代码:</th>
					<td><input name="skuCode" placeholder="请输入商品编号"/></td>
					<th>商品品牌:</th>
					<td><input id="brandName" name="brandName" class="easyui-combobox" 
							data-options="url:'brand/brandAction!gainAllBrand.action',valueField:'name',textField:'name',editable:false,multiple:false"/></td>
					<th>下架时间:</th>
					<td>
					  <select  id="timeInterval" name="timeInterval" >
						  <option selected value=''>--请选择--</option>
						  <option  value='1'>当天</option>  
						  <option  value='3'>三天以内</option>
						  <option  value='7'>七天以内</option>  
						  <option  value='15'>15天以内</option>  
						  <option  value='30'>一个月以内</option>  
						  <option  value='-30'>一个月以上</option>  
						</select>
					</td>			
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_sku_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_sku_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_sku_datagrid"></table>
	</div>
</div>