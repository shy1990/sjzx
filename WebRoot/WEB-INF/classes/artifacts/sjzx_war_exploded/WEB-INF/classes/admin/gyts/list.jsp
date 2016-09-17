<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_gyts_datagrid;
	var editRow = undefined;
	var gid = undefined;
	var admin_gyts_searchForm;
	$(function(){
		admin_gyts_searchForm = $('#admin_gyts_searchForm');
		admin_gyts_datagrid = $('#admin_gyts_datagrid').datagrid({
			url:'gyts/gytsAction!gainGytsList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			pagination : true,
			pageSize : 25,
			pageList : [ 100, 200, 300, 500,1000 ],	
			nowrap : false,
			striped : true,
			sortName : 'addTime',
			sortOrder : 'desc',
			remoteSort : true,
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '外部订单号',
				field : 'outerTid',
				width : 150,
				align :'center'
			},{
				title : '管易返回单号',
				field : 'tid',
				width : 150,
				align :'center'
			},{
				title : '买家账号',
				field : 'mail',
				width : 150,
				align :'center'/* ,	
				formatter: function(value,row,index){				
					return formatString('<a id="btn" onclick="gainGytsInfo(\'{0}\');">'+value+'</a>', row.id);				
		        } */
			},{
				title : '商品代码',
				field : 'item',
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
				title : '商品价格',
				field : 'price',
				width : 150,
				align :'center'
			
			},{
				title : '规格代码',
				field : 'sku',
				width : 150,
				align :'center',
				sortable : true
			
			},{
				title : '商品数量',
				field : 'nums',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '收货人',
				field : 'receiverName',
				width : 150,
				align :'center'
			},{
				title : '收货地址',
				field : 'receiverAddress',
				width : 150,
				align :'center'
			},{
				title : '运输方式',
				field : 'logisticsType',
				width : 150,
				align :'center'
			},{
				title : '卖家账号',
				field : 'outerShopCode',  
				width : 150,
				align :'center'
			},{
				title : '订单添加时间',
				field : 'addTime',
				width : 150,
				align :'center',
				sortable :true
			}/* ,{           
				title : '订单推送时间',
				field : 'created',
				width : 150,
				align :'center',   
				sortable :true
			} */,{
				title : '管易返回信息',
				field : 'error',
				width : 150,
				align :'center'
			}/* ,{
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<img onclick="admin_gyts_remove(\'{0}\');" src="{1}"/>', row.id, 'style/images/cancel.png');				
		        } 
			}*/] ],
 			toolbar : [{
				text : '批量导入',
				iconCls : 'icon-add',
				handler : function() {
					gyts_list_import();
				}
			}], 
		});
	});
	$(function(){
		$('#admin_gyts_datagrid').datagrid({
			rowStyler:function(index,row){
				if (row.error != null){
					return 'background-color:pink;color:purple;font-weight:bold;';
				}else{//#80ffff #7AFEC6
					return 'background-color:#80ffff;color:blue;font-weight:bold;';
				}
			}
		});
	});
	/**
	 * 批量导入
	 */
	 gyts_list_import = function(){
		$('<div/>').dialog({
			href : 'gyts/gytsAction!toImport_Ex_orderData.action',
			width : 400,
			height : 150,
			modal : true,
			title : '导入订单',
			iconCls:'icon-ok',
			buttons : [ {
				text : '导入',
				iconCls : 'icon-ok',
				handler : function() {
					var d = $(this).closest('.window-body');
					$.messager.progress();
					var order_Ex_import=$('#order_Ex_import');
					order_Ex_import.form('submit',{
						url:'gyts/gytsAction!import_Ex_orderData.action',
						onSubmit:function(){
							var isValid = order_Ex_import.form('validate');
							if (!isValid){
								$.messager.progress('close');	// 当form不合法的时候隐藏工具条
							}
							return isValid;
						},
						success : function(json) {
							var j = $.parseJSON(json);
							$.messager.progress('close');	// 当成功提交之后隐藏进度条
							try {
								console.info("json==="+json);
							} catch (e) {
								$.messager.alert('Warning','脚本错误,请重试!');  
							}
							
							if(j.success){
								$.messager.alert('提示',j.msg);
								admin_gyts_datagrid.datagrid('load');
								d.dialog('destroy');
							}else{
								$.messager.alert('提示',j.msg,'info');   
							}
						}
					});
				}
			},{
				text : '关闭',
				iconCls : 'icon-cancel',
				handler : function() {
					var d = $(this).closest('.window-body');
					d.dialog('destroy');
				}
			}],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	};
	/**
	 * 检索
	 */	
	function admin_gyts_search(){
		admin_gyts_datagrid.datagrid('load',sy.serializeObject(admin_gyts_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_gyts_clean(){
		$('#admin_gyts_searchForm input').val('');
		admin_gyts_datagrid.datagrid('load', {});	
	}
	/**
	 * 回车搜索
	 */
	$('#admin_gyts_searchForm input').keydown(function(event){
		if(event.keyCode==13){
			admin_gyts_search();
		}
	});
	 
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 66px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_gyts_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>外部订单号:</th>
					<td><input name="outerTid" placeholder="请输入外部订单号"/></td>
					<th>管易返回单号:</th>
					<td><input name="tid" placeholder="请输入管易返回单号"/></td>
					<th>买家账号:</th>
					<td><input name="mail" placeholder="请输入买家账号"/></td>
				</tr>
				<tr>
					<th>商品代码:</th>
					<td><input name="item" placeholder="请输入商品代码"/></td>
					<th>商品规格代码:</th>
					<td><input name="sku" placeholder="请输入规格代码"/></td>
					<th>订单添加时间:</th>
					<td><input id="admin_starttime" name="_startTime"  class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_endtime\')}'" />
					          至&nbsp;<input id="admin_endtime" name="_endTime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_starttime\')}'" />
					</td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_gyts_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_gyts_clean();">清空条件</a>
					</td> 
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_gyts_datagrid"></table>
	</div>
</div>