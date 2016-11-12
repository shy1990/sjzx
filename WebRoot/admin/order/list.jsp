<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" charset="utf-8">
	var order_datagrid;
	var orderItem_datagrid;
	var did = undefined;
	var order_searchForm;
	$(function(){
		order_searchForm = $('#order_searchForm');
		order_datagrid = $('#order_datagrid').datagrid({
			url:'order/orderAction!gainOrderList.action',
			fit : true,
			fitColumns : true,
			striped : true,
			idField : 'id',
			sortName : 'createtime',
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
			},{
				title : '订单号',
				field : 'orderNum',
				width : 150,
				align :'center',
				sortable :true,
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return formatString('<a id="btn" style="color:red;text-decoration:none;"onclick="showOrderItem(\'{0}\',\'{1}\',\'{2}\',\'{3}\',\'{4}\',\'{5}\',\'{6}\',\'{7}\',\'{8}\');">'+value+'</a>', row.id,row.totalCost,row.carriage,row.remark,row.actualPayNum,row.walletNum,row.walletPayNo,row.hbNo,row.hbNum);				
					}
				}
			},{
				title : '管易单据编号',
				field : 'ecerpNo',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '店铺名称',
				field : 'shopName',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '订单状态',
				field : 'status',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value=='0'){
						return '正常';
					}else if(value=='1'){
						return '未审核';
					}else if(value=='2'){
						return '已审核';
					}else if(value=='3'){
						return '已取消';
					}else if(value=='4'){
						return '无效';
					}else {
						return '未知状态';
					}
				}
			},{
				title : '发货状态',
				field : 'shipStatus',
				width : 130,
				align :'center',
				formatter: function(value,row,index){
					if(value=='0'){
						return '未发货';
					}else if(value=='1'){
						return '已发货';
					}else if(value=='2'){
						return '已送达(地包)';
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
			},{
				title : '支付状态',
				field : 'payStatus',
				width : 120,
				align :'center',
				sortable :true,
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
			},{
				title : '是否删除',
				field : 'disabled',
				width : 100,
				align :'center',
				sortable :true,
				formatter: function(value,row,index){
					if(value=='true'){
						return '已删除';
					}else if(value=='false'){
						return '正常';
					}else {
						return '未知状态';
					}
				}
			},{
				title : '支付类型',
				field : 'payMent',
				width : 150,
				align :'center',
				sortable :true,
				formatter: function(value,row,index){
					if(value=='0'){
						return '网上支付';
					}else if(value=='1'){
						return '货到付款';
					}else if(value=='2'){
						return 'POS付款';
					}else {
						return '未知状态';
					}
				}
			},{
				title : '支付时间',
				field : 'payTime',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '支付方式',
				field : 'dealType',
				width : 150,
				align :'center',
				sortable :true,
				formatter: function(value,row,index){
					/* if(value=='yeePay'){
						return '易宝网银支付';
					}else if(value=='LH'){
						return '联行支付';
					}else if(value=='sandPay'){
						return '杉德POS支付';
					}else if(value=='yeepay'){
						return '易宝POS支付';
					}else if(value=='yitongPay'){
						return '易通POS支付';
					}else if(value == undefined){
						return '-';
					}else {
						return '未知，代码:'+value;
					} */
					if(value=='yeePay'){
						return '联行支付';
					}else if(value=='pos'){
						return 'POS支付';
					}else if(value=='现金支付'){
						return '现金支付';
					} else if(value=="微信/支付宝"){
						return "微信/支付宝";
					} else if (value=="储蓄卡/信用卡"){
						return "储蓄卡/信用卡";
					}
					else {
						return '--';
					}
					
				}
			},{
				title : '支付序列号',
				field : 'dealId',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '总数量',
				field : 'totalNum',
				width : 90,
				align :'center',
				sortable :true
			},{
				title : '运费',
				field : 'carriage',
				width : 90,
				align :'center',
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return value;
					}else {
						return '无';
					}
				}
			},{
				title : '总金额',
				field : 'totalCost',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value=='0'){
						return '网上支付';
					}else {
						return value;
					}
				}
			},{
				title : '钱包支付金额',
				field : 'walletNum',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value=='0'){
						return '---';
					}else {
						return value;
					}
				}
			},{
				title : '红包支付金额',
				field : 'hbNum',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value=='0'){
						return '---';
					}else {
						return value;
					}
				}
			},{
				title : '红包交易单号',
				field : 'hbNo',
				hidden : true,
			},{
				title : '钱包交易单号',
				field : 'walletPayNo',
				hidden : true,
			},{
				title : '实际支付金额',
				field : 'actualPayNum',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value=='0'){
						return '网上支付';
					}else {
						return value;
					}
				}
			},{
				title : '收货人姓名',
				field : 'shipName',
				width : 130,
				align :'center',
				sortable :true
			},{
				title : '收货人手机',
				field : 'shipTel',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '下单时间',
				field : 'createtime',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '订单备注',
				field : 'remark',
				width : 150,
				//hidden : true,
				formatter : function(value) {
				    if (value) {
				        return '<span title="' + value + '">' + value + '</span>';
				    }//else{
				   // 	return '------';
				    //}
				}
			},{
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){	
					return formatString('<img onclick="order_edit(\'{0}\');" src="{1}"/>&nbsp;&nbsp; <button   onclick="tuisong(\'{2}\',\'{3}\',\'{4}\',\'{5}\',\'{6}\');">重新推送</button>', 	
										 row.id,'style/images/pencil.png',row.id,row.ecerpNo,row.payStatus,row.payMent,row.status);											 
		        }}]],
		        
		        
			toolbar : [{
				text : '批量导出',
				iconCls : 'icon-print',
				handler : function() {
					order_list_export();
				}
			}],
		});
	});
	
	/**
	推送订单
	*/
	function tuisong(id,ecerpNo,payStatus,payMent,status){
	/* if(ecerpNo == 'undefined' && ((payStatus =='0' && (payMent == '1' || payMent == '2')) || (payStatus =='1' && payMent == '0'))&&(status != '3' && status != '4')){ */
	  order_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'order/orderAction!toPush.action?id='+id,
			width : 450,
			height : 200,
			modal : true,
			title : '推送订单',
			buttons : [ {
				text : '推送管易',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#topushpushone').form('submit', {
						url : 'order/orderAction!pushOrder.action',
						success : function(result) {
						    
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									order_datagrid.datagrid('updateRow', {
										index : order_datagrid.datagrid('getRowIndex', id),
										row : r.obj,
									});
									d.dialog('destroy');
									order_datagrid.datagrid('load'); 
								}
								
				  				 $.messager.show({
										title : '提示',
										msg : r.msg
									     });
							} catch (e) {
								$.messager.alert('提示', r.msg,'info');
							}
						},
					});
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				var index = order_datagrid.datagrid('getRowIndex', id);
				var rows = order_datagrid.datagrid('getRows');
			    var o = rows[index];
				o.str = stringToList(rows[index].str);
				$('#topushpushone').form('load', o);
			},
		});		
	/* }else{
	$.messager.alert('提示', '此订单已推送成功  或者网上支付未付款  或订单已取消','info');
	} */
	  
	}
	
	/**
	 * 编辑订单金额
	 */
	function order_edit(id,orderNum) {
	    
		order_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'order/orderAction!toUpdate.action?id='+id+'&orderNum='+orderNum,
			width : 450,
			height : 235,
			modal : true,
			title : '编辑订单金额',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#order_editForm').form('submit', {
						url : 'order/orderAction!updatePrice.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									order_datagrid.datagrid('updateRow', {
										index : order_datagrid.datagrid('getRowIndex', id),
										row : r.obj,
									});
									d.dialog('destroy');
									order_datagrid.datagrid('load'); 
								}
								
				  				 $.messager.show({
										title : '提示',
										msg : r.msg
									     });
							} catch (e) {
								$.messager.alert('提示', r.msg,'info');
							}
						},
					});
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {
				var index = order_datagrid.datagrid('getRowIndex', id);
				var rows = order_datagrid.datagrid('getRows');
			    var o = rows[index];
				o.str = stringToList(rows[index].str);
				$('#order_editForm').form('load', o);
			},
		});		
	}
	
	
	function showOrderItem(id,totalCost,carriage,remark,actualPayNum,walletNum,walletPayNo,hbNo,hbNum){
		$('<div/>').dialog({
			href : 'orderItem/orderItemAction!showOrderItem.action?id='+id+'&totalCost='+totalCost+'&carriage='+carriage+'&actualPayNum='+actualPayNum+'&walletNum='+walletNum+'&walletPayNo='+walletPayNo+'&hbNo='+hbNo+'&hbNum='+hbNum+'&remark='+remark,
			width : 1200,
			height : 600,
			modal : true,
			title : '订单详情',
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	
	/**
	 * 批量导出订单
	 */
	order_list_export=function(){
		order_searchForm.form('submit',{
			url:'order/orderAction!exportOrderExcel.action'
		});
	};	
	/**
	 * 检索
	 */	
	function order_search(){
		order_datagrid.datagrid('load', sy.serializeObject(order_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function order_clean(){
		$('#order_searchForm input').val('');
		order_datagrid.datagrid('load', {});	
	}
	$('#order_searchForm input').keydown(function(event){
		if(event.keyCode==13){
			order_search();
		}
	});
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 66px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="order_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
				    <th>订单Id:</th>
					<td><input name="id" placeholder="请输入需要查询的订单号"/></td>
					<th>订单号:</th>
					<td><input name="orderNum" placeholder="请输入需要查询的订单号"/></td>
					<th>管易单据号:</th>
		  			<td><input name="ecerpNo"  placeholder="请输入需要查询的单据号"/></td>
					<th>支付序列号:</th>
					<td><input name="dealId"  placeholder="请输入需要查询的序列号"/></td>
					<!-- th>订单状态:</th>
					<td>
						<select class="easyui-combobox" name="status" >
    						<option></option>  
    						<option value="0">未审核</option>  
    						<option value="1">已审核</option>  
    						<option value="2">取消</option>  
    						<option value="3">无效</option>  
						</select> 
					</td-->
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
		
					<th>支付方式:</th>
					<td>
						<select class="easyui-combobox" name="dealType" >
    						<option value="-1">--请选择--</option>  
    						<option value="yeePay">易宝支付</option>  
    						<option value="sandPay">杉德POS端支付</option>  
    						<option value="LH">联行支付</option>     
						</select>
					</td>
				</tr>
				<tr>	
					<th>下单时间(起):</th>
					<td><input name="_startTime" id="admin_order_list_starttime" class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_order_list_endtime\')}'"/>
					<th>下单时间(至):</th>
					<td>
						<input name="_endTime" id="admin_order_list_endtime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_order_list_starttime\')}'"/>
					</td>
					<th>支付时间(起):</th>
					<td><input name="_payStartTime" id="admin_order_list_payStarttime" class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_order_list_payEndtime\')}'"/>
					<th>支付时间(至):</th>
					<td>
						<input name="_payEndTime" id="admin_order_list_payEndtime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_order_list_payStarttime\')}'"/>
					</td>
					<th>订单推送是否成功:</th>
					<td>
						<select class="easyui-combobox" name="ecerpNum" >
    						<option value ="" >--请选择--</option>  
    						<option value="1">推送成功</option>  
    						<option value="2">推送失败</option>  
						</select>
					</td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="order_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="order_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="order_datagrid"></table>
	</div>
</div>
