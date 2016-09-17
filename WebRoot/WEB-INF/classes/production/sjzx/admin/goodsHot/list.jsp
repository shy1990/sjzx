<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" charset="utf-8">
	var goodsHot_datagrid;
	var did = undefined;
	var goodsHot_searchForm;
	$(function(){
		goodsHot_searchForm = $('#goodsHot_searchForm');
		goodsHot_datagrid = $('#goodsHot_datagrid').datagrid({
			url:'goods/goodsHotAction!gainGoodsHotList.action',
			fit : true,
			fitColumns : true,
			striped : true,
			idField : 'id',
			sortName : 'num',
			sortName : 'hotType',
			sortOrder : 'desc',
			remoteSort : true,
			pagination : true,
			pageSize : 20,
			pageList : [ 20, 30, 40 ,50 ],
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '商品名称',
				field : 'name',
				width : 150,
				align :'center'
			},{
				title : '商品类型',
				field : 'catName',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value!='手机'&& value != null){
						return '配件';
					}else{
						return '单品';
					}
				}
			},{
				title : '商品价格',
				field : 'price',
				width : 150,
				align :'center'
			},{
				title : '商品版本',
				field : 'edition',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return value;
					}else{
						return '---';
					}
				}
			},{
				title : '热销排行',
				field : 'num',
				width : 150,
				align :'center',
				sortable : true,
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return value;
					}else{
						return '---';
					}
				}
			},{
				title : '商品排名类型',
				field : 'hotType',
				width : 150,
				align :'center',
				sortable : true,
				formatter: function(value,row,index){
					if(value!=null && value!=''){
					return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="goodsHot_ban(\'{0}\');">点击取消热销</a>', row.id);				
					}else{
					return formatString('<a id="btn" style="color:green;text-decoration:none;" onclick="goodsHot_set(\'{0}\');">点击设为热销</a>', row.id);				
					}
				}
			},{
				title : '类型',
				field : 'type',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					/*if(value='0'){
						return 'B2B';
					}else if(value='1'){
						return 'B2C';
					}else{
						return '---';
					}*/
					if(value != null){
					   if(value='0'){
						return 'B2B';
					   }else if(value='1'){
							return 'B2C';
					   }
					}else{
						return '---';
					}
				}
			}] ],
		});
		$('#goodsHot_searchForm input').keydown(function(event){
			if(event.keyCode==13){
				goodsHot_search();
			}
		});
	});
	
	 
	
	/**
	 * 将商品设为热销
	 */
	function goodsHot_set(id){
		
		 $.messager.confirm('确认', '您是否要将当前选中的项目设为热销？', function(r) {
		 	if (r) {
				$('<div/>').dialog({
			href : 'goods/goodsHotAction!toAdd.action?id='+id,
			width : 450,
			height :200,
			modal : true,
			title : '设为热销',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#goodsHot_addForm').form({
						url : 'goods/goodsHotAction!addGoodsHot.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
								    goodsHot_datagrid.datagrid('load');
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
					$('#goodsHot_addForm').submit();
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});	
					
					}
		 });
				
		
	}
	/**
	 * 将商品设为未热销
	 */
	function goodsHot_ban(id){
			var rows;
		if(did != id){
			goodsHot_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			goodsHot_datagrid.datagrid('checkRow', goodsHot_datagrid.datagrid('getRowIndex', id));	
			rows = goodsHot_datagrid.datagrid('getChecked');	
		}else{
			rows = goodsHot_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要将当前选中的项目设为未热销？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						var ddd = rows[i].id;
						ids.push(ddd);
					}
					console.info(ids);
					$.ajax({
						url : 'goods/goodsHotAction!danGoodsHot.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							try {
								if (result.success) {
								goodsHot_datagrid.datagrid('load');
								$.messager.show({
									title : '提示',
									msg : result.msg
								});	}else{
								/*$.messager.show({
									title : '提示',
									msg : result.msg
								});*/
								$.messager.alert('提示', result.msg,'info');
							}
							} catch (e) {
								// TODO: handle exception
							}
						}
					});
				}else{
					goodsHot_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选设为未热销的记录！','info');
		}
	}
	
/**
	 * 检索
	 */	
	function goodsHot_search(){
		goodsHot_datagrid.datagrid('load', sy.serializeObject(goodsHot_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function goodsHot_clean(){
		$('#goodsHot_searchForm input').val('');
		goodsHot_datagrid.datagrid('load', {});	
	}
	
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="goodsHot_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					
					<th>热销品状态:</th>
					<td>
					  <select class="easyui-combobox" name="state" >
					        <option >全部</option>  
					  	    <option value="true">已设为热销品</option>  
    						<option value="false">未设为热销品</option>  
					  </select>
					</td>
					<th>商品名称:</th>
					<td>
					  <input name="name" placeholder="请输入标签名称"/>
					</td>
					<th>类型</th>
					<td>
					  <select class="easyui-combobox" id="goodsType" name="goodsType" >
    						<option value="sku">手机—单品</option>  
    						<option value="accessories">配件</option>  
					  </select>
					</td>  
					<th>排行类型:</th>
					<td>
						<select class="easyui-combobox" name="hotType" >
    						<option value="day">日排行</option>  
    						<option value="week">周排行</option>  
    						<option value="month">月排行</option>  
    						<option value="year">年排行</option>  
    						<option value="brand">品牌排行</option>
    						<option value="4G">4G手机排行</option> 
    						<option value="lt3G">联通3G手机排行</option> 
    						<option value="yd3G">移动3G手机排行</option>
    						<option value="dx3G">电信3G手机排行</option>      
						</select> 
					</td>
					<th>操作: </th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="goodsHot_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="goodsHot_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="goodsHot_datagrid"></table>
	</div>
</div>
