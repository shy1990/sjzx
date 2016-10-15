<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="com.sanji.sjzx.common.util.ResourceUtil"%>
<%@page import="com.sanji.sjzx.pojo.SessionInfo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute(ResourceUtil.getSessionInfoName());
	String userId = sessionInfo.getUserId();
	String loginName = sessionInfo.getLoginName();
	
%>
<script type="text/javascript" charset="utf-8">
	var order_over_datagrid;
	var did = undefined;
	var order_over_searchForm;
	
	$(function(){
		order_over_searchForm = $('#order_over_searchForm');
		order_over_datagrid = $('#order_over_datagrid').datagrid({
			url:'order/orderAction!gainOverOrderList.action',
			fit : true,
			fitColumns : true,
			striped : true,
			idField : 'id',
			sortName : 'overtime',
			sortOrder : 'desc',
			remoteSort : true,
			pagination : true,
			pageSize : 20,
			pageList : [ 100, 200, 300, 500,1000 ],
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			}, {
				title : '订单唯一码',
				field : 'oid',
				width : 190,
				align :'center'
			},{
				title : '订单号',
				field : 'orderNum',
				width : 150,
				align :'center',
				sortable :true
/* 				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showOrderItem(\'{0}\',\'{1}\',\'{2}\');">'+value+'</a>', row.id,row.totalCost,row.shopName);				
					}
				} */
			},{
				title : '支付状态',
				field : 'payStatus',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value=='0'){
						return '未付款';
					}else if(value=='1'){
						return '已付款';
					}else if(value=='2'){
						return '待退款';
					}else if(value=='3'){
						return '已退款';
					}else if(value=='4'){
						return '卖家拒绝退款';
					}else {
						return '未知状态';
					}
				}
			}, {
				title : '支付类型',
				field : 'payMent',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value=='0'){
						return '网上支付';
					}else if(value=='1'){
						return '货到付款';
					}else {
						return '未知状态';
					}
				}
			},/*{
				title : '支付序列号',
				field : 'dealId',
				width : 150,
				align :'center',
				sortable :true
			}, */{
				title : '总金额',
				field : 'totalCost',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '管易单据编号',
				field : 'ecerpNo',
				width : 150,
				align :'center',
				sortable :true
			}/* ,{
				title : '发货状态',
				field : 'shipStatus',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value=='0'){
						return '未发货';
					}else if(value=='1'){
						return '已发货';
					}else if(value=='2'){
						return '已送达';
					}else if(value=='3'){
						return '已收货';
					}else if(value=='4'){
						return '待退货';
					}else if(value=='5'){
						return '已退货';
					}else if(value=='6'){
						return '卖家拒绝退货';
					}else {
						return '未知状态';
					}
				}
			} */,{
				title : '终结时间',
				field : 'overtime',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '终结操作人',
				field : 'overman', 
				width : 150,
				align :'center'
			},{
				title : '是否终结',
				field : 'isover',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value!=null && value!='' && value=='0'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="admin_order_over(\'{0}\');">未终结</a>', row.id);				
					}else if(value == '1'){
						return formatString('<a id="btn" style="color:green;text-decoration:none;">已终结</a>', row.id);				
					}
				}
			}] ]  

		});		
	});

	/**
	 *	终结订单
	 */
	admin_order_over=function(id){
		var rows;
		if(did != id){
			order_over_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			order_over_datagrid.datagrid('checkRow', order_over_datagrid.datagrid('getRowIndex', id));	
			rows = order_over_datagrid.datagrid('getChecked');	
		}else{
			rows = order_over_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要终结当前订单？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}    
					$.ajax({
						url : 'order/orderAction!updateOverOrder.action',
 						data : {
							ids : ids.join(',')
						},
     					dataType : 'json',
						success : function(result) {
							if (result.success) {
								order_over_datagrid.datagrid('load');
								order_over_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					order_over_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要终结的订单！','info');
		}
	}; 
	
	function showOrderItem(id,totalCost,shopName){
		$('<div/>').dialog({
			href : 'orderItem/orderItemAction!showOrderItem.action?id='+id+'&totalCost='+totalCost,
			width : 1000,
			height : 600,
			modal : true,
			title : '订单详情',
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	/**
	 * 检索
	 */	
	function order_over_search(){
		order_over_datagrid.datagrid('load', sy.serializeObject(order_over_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function order_over_clean(){
		$('#order_over_searchForm input').val('');
		order_over_datagrid.datagrid('load', {});	
	}
	$('#order_over_searchForm input').keydown(function(event){
		if(event.keyCode==13){
			order_over_search();
		}
	});
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 66px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="order_over_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>订单唯一码</th>
					<td><input name="oid" style="width:210px" placeholder="请输入需要查询的订单唯一码"/></td>
					<th>订单号:</th>
					<td><input name="orderNum" placeholder="请输入需要查询的订单号"/></td>
					<th>管易单据号:</th>
					<td><input name="ecerpNo"  placeholder="请输入需要查询的单据号"/></td>
					<th>支付状态:</th>
					<td>
					 	<select class="easyui-combobox" name="payStatus" >
    						<option value="-1">--请选择--</option>  
    						<option value="0">未付款</option>  
    						<option value="1">已付款</option>  
    						<option value="2">待退款</option>  
    						<option value="3">已退款</option>  
    						<option value="4">卖家拒绝退款</option>
						</select> 
					</td>
<%-- 					<th>发货状态:</th>
					<td>
						<select class="easyui-combobox" name="shipStatus" >
    						<option value="-1">--请选择--</option>  
    						<option value="0">未发货</option>  
    						<option value="1">已发货</option>  
    						<option value="2">已送达</option>  
    						<option value="3">已收货</option>  
    						<option value="4">待退货</option>
    						<option value="5">已退货</option>
    						<option value="6">卖家拒绝退货</option>
						</select> 
					</td> --%>
				</tr>
				<tr>	
					<th>终结时间(起):</th>
					<td><input name="_startTime" id="admin_order_list_starttime" class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_order_list_endtime\')}'"/>
					<th>终结时间(至):</th>
					<td><input name="_endTime" id="admin_order_list_endtime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_order_list_starttime\')}'"/></td>
					<th>是否终结:</th>
					<td>
						<select class="easyui-combobox" name="isover" >
    						<option value="-1">--请选择--</option>  
    						<option value="0">未终结</option>  
    						<option value="1">已终结</option>  
						</select> 
					</td>
					<th>终结操作人:</th>
					<td><input name="overman" placeholder="请输入终结操作人"/></td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="order_over_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="order_over_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="order_over_datagrid"></table>
	</div>
</div>

