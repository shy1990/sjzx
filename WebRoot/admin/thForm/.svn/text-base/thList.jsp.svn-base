<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><base href="<%=basePath%>" />
<script language="JavaScript"> 
/* function myrefresh() 
{ 
       window.location.reload(); 
} 
setTimeout('myrefresh()',1000*10); //指定1秒刷新一次  */
</script>
<script type="text/javascript" charset="utf-8">
	var thForm_datagrid;
	var did = undefined;
	var thForm_searchForm;
	$(function(){
		thForm_searchForm = $('#thForm_searchForm');
		thForm_datagrid = $('#thForm_datagrid').datagrid({
			url:'thForm/thFormAction!gainThFormInitList.action',
			fit : true,
			fitColumns : true,
			striped : true,
			idField : 'id',
			sortName : 'createTime',
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
				title : '用户Id',
				field : 'userId',
				width : 150,
				hidden : true
			},{
				title : '订单号',
				field : 'orderId',
				width : 150,
				align :'center',
				hidden: true,
			},{
				title : '订单编号',
				field : 'orderNo',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showThItem(\'{0}\',\'{1}\',\'{2}\',\'{3}\');">'+value+'</a>', row.id,row.orderId,row.money,row.userId);				
					}
				}
			}, {
				title : '申请人',
				field : 'username',
				width : 150,
				align :'center'
			},{
				title : '退款金额',
				field : 'money',
				width : 150,
				align :'center'
			}, {
				title : '状态',
				field : 'status',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value =='INIT'){
						return '待处理';
					}else if(value =='PROCESS'){
						return '正在处理中';
					}else if(value =='NOTIFIYED'){
						return '已通知取货';
					}else if(value =='DOWNSENDED'){
						return '地包已发货';
					}else if(value =='ABORT'){
						return '已拒绝退款';
					}else if(value =='COMPLETE'){
						return '已完成退款';
					}else if(value =='UPSENDED'){
						return '售后已发货';
					}else if(value =='AUDITREJECT'){
						return '修改退款退货申请';
					}else if(value =='EDITPROCESS'){
						return '正在处理修改后的申请';
					}else if(value =='CLIENTSEND'){
						return '等待商家处理';
					}
		        }	
			},{
				title : '发货状态',
				field : 'shipStatus',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value =='0'){
						return '未发货';
					}else if(value =='1'){
						return '已发货';
					}else if(value =='2'){
						return '已送达（地包）';
					}else if(value =='3'){
						return '已收货';
					}else if(value =='4'){
						return '待退货';
					}else if(value =='5'){
						return '已退货';
					}else if(value =='6'){
						return '卖家拒绝退货';
					}
		        }	
			}, {
				title : '终止原因',
				field : 'abortReason',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return value;
					}else{
						return '---';
					}
				}
				
			}, {
				title : '取货单号',
				field : 'qhFormId',
				width : 150,
				align :'center',
				hidden : true
				
			}, {
				title : '创建时间',
				field : 'createTime',
				width : 150,
				align :'center',
				sortable : true
				
			}, {
				title : '联系方式',
				field : 'mobile',
				width : 150,
				align :'center',
				//sortable : true
				
			},{
				title : '备注',
				field : 'remark',
				width : 150,
				align :'center',
			}, {
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				hidden : true
				/* formatter: function(value,row,index){
					if(row.id == '7475de6e22cd4cd783acb85605eda9bd'){
						return '系统角色';
					}else{
						return formatString('<img onclick="thForm_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="thForm_remove(\'{2}\');" src="{3}"/>', row.id, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
					}
		        } */
			}] ],
			
		});
		
		thForm_searchForm_right = $('#thForm_searchForm_right');
		thForm_datagrid_right = $('#thForm_datagrid_right').datagrid({
			url:'thForm/thFormAction!gainThFormList.action',
			fit : true,
			fitColumns : true,
			striped : true,
			idField : 'id',
			sortName : 'createTime',
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
				title : '用户Id',
				field : 'userId',
				width : 150,
				hidden : true
			},{
				title : '取货单号',
				field : 'qhFormId',
				width : 150,
				align :'center',
				hidden : true
			}, {
				title : '订单号',
				field : 'orderId',
				width : 150,
				align :'center',
				hidden:true,
			},{
				title : '订单编号',
				field : 'orderNo',
				width : 150,
				align :'center',
				
			},{
				title : '申请人',
				field : 'username',
				width : 150,
				align :'center',
			},{
				title : '退款金额',
				field : 'money',
				width : 150,
				align :'center'
			}, {
				title : '退货状态',
				field : 'status',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value =='INIT'){
						 return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\',\'{2}\',\'{3}\',\'{4}\',\'{5}\');">待处理</a>',row.id, row.orderId,row.money,row.status,row.readUserId,row.userId);			
					}else if(value =='PROCESS'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\',\'{2}\',\'{3}\',\'{4}\',\'{5}\');">正在处理中</a>',row.id,row.orderId,row.money,row.status,row.readUserId,row.userId);			
					}else if(value =='NOTIFIYED'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\');">已通知取货</a>', row.status,row.qhFormId);			
					}else if(value =='DOWNSENDED'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\',\'{2}\');">地包已发货</a>',row.id, row.status,row.qhFormId);			
					}else if(value =='ABORT'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\');">已拒绝退款</a>', row.status,row.qhFormId);			
					}else if(value =='COMPLETE'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\');">已完成</a>', row.status,row.qhFormId);
					}else if(value =='UPRECEIVED'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\',\'{2}\');">售后已收货</a>',  row.id,row.status,row.qhFormId);
					}else if(value =='UPSENDED'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\');">售后已发货</a>', row.status,row.qhFormId);
					}else if(value =='AUDITREJECT'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\',\'{2}\',\'{3}\',\'{4}\',\'{5}\');">修改申请</a>',row.id,row.orderId,row.money,row.status,row.readUserId,row.userId);
					}else if(value =='REJECTCLIENT'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\',\'{2}\');">买家发货</a>',row.id, row.status,row.readUserId);
					}else if(value =='CLIENTSEND'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\',\'{2}\',\'{3}\',\'{4}\',\'{5}\');">等待收货</a>',row.id,row.orderId,row.money,row.status,row.readUserId,row.userId);
					}
		        }
		        	
			},{
				title : '发货状态',
				field : 'shipStatus',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value =='0'){
						return '未发货';
					}else if(value =='1'){
						return '已发货';
					}else if(value =='2'){
						return '已送达（地包）';
					}else if(value =='3'){
						return '已收货';
					}else if(value =='4'){
						return '待退货';
					}else if(value =='5'){
						return '已退货';
					}else if(value =='6'){
						return '卖家拒绝退货';
					}
		        }	
			}, {
				title : '终止原因',
				field : 'abortReason',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return value;
					}else{
						return '---';
					}
				}
				
			},  {
				title : '创建时间',
				field : 'createTime',
				width : 150,
				align :'center',
				sortable : true
				
			}, {
				title : '联系方式',
				field : 'mobile',
				width : 150,
				align :'center',
				
			},{
				title : '备注',
				field : 'remark',
				width : 150,
				align :'center',
			},{
				title : '操作人',
				field : 'readUserId',
				width : 150,
				align :'center',
				hidden : true
				/* formatter: function(value,row,index){
					if(row.id == '7475de6e22cd4cd783acb85605eda9bd'){
						return '系统角色';
					}else{
						return formatString('<img onclick="thForm_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="thForm_remove(\'{2}\');" src="{3}"/>', row.id, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
					}
		        } */
			}] ],
			
		});
		
		
	});
	//查看退货退款/换货申请根据发货状态判断直接退货退款或进入售后流程
	function showThItem(id,orderId,money,userId){
		$.messager.confirm('确认', '您是否要受理当前选中的项目？', function(r) {
		  if (r){
		         $.ajax({
		                   type:"post",
						   url:'thForm/thFormAction!existOrderShipStatus.action?id='+id,
						   //data:formValue,
						   dataType:"JSON",
				           success : function(obj){
				           if (obj.success) {
						       $('<div/>').dialog({
						           href : 'thForm/thItemAction!showThItem.action?formId='+id,
								    width : 450,
						            height : 400,
									modal : true,
									title : '退款详情',
									buttons : [{
								    text : '拒绝受理',
								     //iconCls : 'icon-add',
								    handler : function() {
										$('<div/>').dialog({
											href : 'thForm/thFormAction!toUpdate.action?id='+$('#id').val(),
											width : 300,
											height : 150,
											modal : true,
											title : '拒绝受理',
											buttons : [ {
												text : '保存',
												iconCls : 'icon-add',
												handler : function() {
													var d = $(this).closest('.window-body');
													$('#thForm_addForm').form({
														url : 'thForm/thFormAction!updateThForm.action',
														success : function(result) {
															var r = $.parseJSON(result);
															try {
																if (r.success) {
																   // thForm_datagrid_right.datagrid('load');
																	d.dialog('destroy');
																	$('#order_addForm').closest('.window-body').dialog('destroy');
																	thForm_datagrid.datagrid('load');
									    						    thForm_datagrid_right.datagrid('load');
																	$.messager.show({
																		title : '提示',
																		msg : r.msg
																	});									
																}else{
																	$.messager.show('提示', r.msg,'info');								
																}
															} catch (e) {
																$.messager.show('提示', r.msg,'info');
															}
														}
													});
													$('#thForm_addForm').submit();
												
												
												}} ], onClose : function() {
												$(this).dialog('destroy');
											}});}},{
								text : '确定受理',
								//iconCls : 'icon-add',
								handler : function() {
									   $.ajax({
										    type:"post",
										    url:"thForm/thFormAction!updateStatus.action?id="+id,
											//data:formValue,
										    dataType:"JSON",
								            success : function(obj){
									             if (obj.success) {
									             	$('#order_addForm').closest('.window-body').dialog('destroy');
									             	  thForm_datagrid.datagrid('load');
							    					  thForm_datagrid_right.datagrid('load');
										             	  $.messager.show({
																	title : '提示',
																	msg : obj.msg
															});
									              }
								             }
									   	 });
									    }
								  }],
								  onClose : function() {
										$(this).dialog('destroy');
												}  
									});
				           
				           
					          }else{
								           		
						         $('<div/>').dialog({
							           href : 'thForm/thItemAction!showThItem.action?formId='+id,
									    width : 450,
							            height : 400,
										modal : true,
										title : '退款详情',
										buttons : [{
										text : '确定退款',
										//iconCls : 'icon-add',
										handler : function() {
										   $.ajax({
										        type:"post",
										        url:"thForm/thFormAction!returnMoney.action?orderId="+orderId+"&money="+money+"&status="+'COMPLETE'+"&id="+id+"&userId="+userId,//调用退款接口
											    //data:formValue,
										         dataType:"JSON",
										        //dataType: "jsonp",
 										        //jsonp: "callback",
									            success : function(obj){
										             if (obj.success) {
										                   $('#order_addForm').closest('.window-body').dialog('destroy');
								             	            thForm_datagrid.datagrid('load');
								             	            thForm_datagrid_right.datagrid('load');
										                   $.messager.show({
																title : '提示',
																msg : obj.msg
																    }); 
										                
										              }else{
										              	$.messager.show({
															title : '提示',
															msg : obj.msg
														 }); 
										              }
									             }
										   	 });
										    }
									  }],
									  onClose : function() {
											$(this).dialog('destroy');
													}  
										});    		
					           }
				          }
		         });
		    }		
		});
	}
	
	//受理守候
	function showQhItem(id,orderId,money,status,readUserId,userId){
		           if(status == "INIT" ||status == "AUDITREJECT"){
				          $('<div/>').dialog({
						           href : 'thForm/thItemAction!showThItem.action?formId='+id,
								    width : 450,
						            height : 400,
									modal : true,
									title : '退款详情',
									buttons : [{
								    text : '拒绝',
								     //iconCls : 'icon-add',
								    handler : function() {
								       $.ajax({
										    type:"post",
										    url:"thForm/thFormAction!updateStatus.action?id="+id+"&status="+'PROCESS',
											//data:formValue,
										    dataType:"JSON",
								            success : function(obj){
									             if (obj.success) {
									             	$('#order_addForm').closest('.window-body').dialog('destroy');
									             	  thForm_datagrid.datagrid('load');
							    					  thForm_datagrid_right.datagrid('load');
										             	  $.messager.show({
																	title : '提示',
																	msg : obj.msg
															});
									              }
								             }
									   	 });
								       
								       /*  var d = $(this).closest('.window-body');
								        d.dialog('destroy'); */
										}},{
								text : '确定',
								//iconCls : 'icon-add',
								handler : function() {
									   $.ajax({
										    type:"post",
										    url:"thForm/thFormAction!updateStatus.action?id="+id+"&status="+'REJECTCLIENT',
											//data:formValue,
										    dataType:"JSON",
								            success : function(obj){
									             if (obj.success) {
									             	$('#order_addForm').closest('.window-body').dialog('destroy');
									             	  thForm_datagrid.datagrid('load');
							    					  thForm_datagrid_right.datagrid('load');
										             	  $.messager.show({
																	title : '提示',
																	msg : obj.msg
															});
									              }
								             }
									   	 });
									    }
								  }],
								  onClose : function() {
										$(this).dialog('destroy');
												}  
									});
				           
				 }else if(status == "CLIENTSEND"){
				     $('<div/>').dialog({
						           href : 'thForm/thItemAction!showThItem.action?formId='+id,
								    width : 450,
						            height : 400,
									modal : true,
									title : '退款详情',
									buttons : [{
								    text : '拒绝退款退货',
								     //iconCls : 'icon-add',
								    handler : function() {
										$('<div/>').dialog({
											href : 'thForm/thFormAction!toUpdate.action?id='+$('#id').val(),
											width : 300,
											height : 150,
											modal : true,
											title : '拒绝退款退货',
											buttons : [ {
												text : '保存',
												iconCls : 'icon-add',
												handler : function() {
													var d = $(this).closest('.window-body');
													$('#thForm_addForm').form({
														url : 'thForm/thFormAction!updateThForm.action',
														success : function(result) {
															var r = $.parseJSON(result);
															try {
																if (r.success) {
																   // thForm_datagrid_right.datagrid('load');
																	d.dialog('destroy');
																	$('#order_addForm').closest('.window-body').dialog('destroy');
																	thForm_datagrid.datagrid('load');
									    						    thForm_datagrid_right.datagrid('load');
																	$.messager.show({
																		title : '提示',
																		msg : r.msg
																	});									
																}else{
																	$.messager.show('提示', r.msg,'info');								
																}
															} catch (e) {
																$.messager.show('提示', r.msg,'info');
															}
														}
													});
													$('#thForm_addForm').submit();
												
												
												}} ], onClose : function() {
												$(this).dialog('destroy');
											}});}},{
								text : '同意退款退货',
								//iconCls : 'icon-add',
								handler : function() {
									   $.ajax({
									   		type:"post",
										    url:"thForm/thFormAction!returnMoney.action?orderId="+orderId+"&money="+money+"&status="+'COMPLETE'+"&id="+id+"&userId="+userId,//调用退款接口
											//data:formValue,
										    dataType:"JSON",
										   // dataType: "jsonp",
     										//jsonp: "callback",
     										//jsonpCallback:"callback",
								            success : function(obj){
									             if (obj.success) {
									              $('#order_addForm').closest('.window-body').dialog('destroy');
								             	   thForm_datagrid.datagrid('load');
						    					   thForm_datagrid_right.datagrid('load');
									              $.messager.show({
													title : '提示',
													msg : obj.msg
																});
									              }else{
									                $.messager.show({
															title : '提示',
															msg : obj.msg
																}); 
									              }
								             }
									   	 });
									    }
								  }],
								  onClose : function() {
										$(this).dialog('destroy');
												}  
									});
				 }
	
	}
	
	
	
/**
	 * 检索
	 */	
	function thForm_search(){
		thForm_datagrid.datagrid('load', sy.serializeObject(thForm_searchForm));	
	}
	function thForm_search_right(){
		thForm_datagrid_right.datagrid('load', sy.serializeObject(thForm_searchForm_right));	
	}
	
	/**
	 * 清空条件
	 */
	function thForm_clean(){
		$('#thForm_searchForm input').val('');
		thForm_datagrid.datagrid('load', {});	
	}
	function thForm_clean_right(){
		$('#thForm_searchForm_right input').val('');
		thForm_datagrid_right.datagrid('load', {});	
	}
	
</script>
 
	<div class="easyui-layout" data-options="fit:true,border:true"style="background-color: #e1e1e1;border: 1px solid #e1e1e1">
	    <div data-options="region:'center',border:false">
			<div class="easyui-layout" data-options="fit:true,border:false">
			    <div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
				 <div class="easyui-panel" data-options="border:false">
					<form class="easyui-form" id="thForm_searchForm">
						<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
							<tr>
								<th>订单编号:</th>
								<td><input name="orderNo" placeholder="请输入订单编号"/></td>
								<th>申请人</th>
								<td><input name="username" placeholder="请输入申请人姓名"/></td>
								<th>操作:</th>
								<td>
									<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="thForm_search();">查询</a> 
									<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="thForm_clean();">清空条件</a>
								</td>
							</tr>
						</table>
					</form> 
					</div>
				</div>
				<div data-options="region:'center',border:false">
					<table id="thForm_datagrid"  style="width:100%;height: 100%"></table>
				</div>
			</div>
		</div>
		<div data-options="region:'east',border:false"
			style="width:1000px;">
			<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
				<div class="easyui-panel" data-options="border:false">
					<form class="easyui-form" id="thForm_searchForm_right">
						<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
							<tr>
								<th>订单编号:</th>
								<td><input name="orderNo" placeholder="请输入订单编号"/></td>
								<th>申请人</th>
								<td><input name="username" placeholder="请输入申请人姓名"/></td>
								<th>发货状态</th>
								<td>
								  <select  name="shipStatus" >
								    <option selected value=''>--请选择--</option>
								    <option value="INIT">待处理</option>  
								    <option value="PROCESS">正在处理中</option>  
		    						<option value="AUDITREJECT">修改申请</option>  
		    						<option value="REJECTCLIENT">买家发货</option>
		    						<option value="CLIENTSEND">等待收货</option>
		    						<option value="COMPLETE">已完成退款</option>  
		    						<option value="ABORT">已拒绝退款</option>
		    						
								  </select> 
								</td>
								<th>操作:</th>
								<td>
									<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="thForm_search_right();">查询</a> 
									<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="thForm_clean_right();">清空条件</a>
								</td>
							</tr>
						</table>
					</form> 
					</div>
				</div>
				<div data-options="region:'center',border:true">
				  <table id="thForm_datagrid_right"  style="width:100%;height: 100%"></table>
				</div>
			</div>
		</div>
	</div>
				
</div>
