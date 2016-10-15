<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" charset="utf-8">
	var wxForm_datagrid;
	var did = undefined;
	var wxForm_searchForm;
	$(function(){
		wxForm_searchForm = $('#wxForm_searchForm');
		wxForm_datagrid = $('#wxForm_datagrid').datagrid({
			url:'wxForm/wxFormAction!gainWxFormInitList.action',
			fit : true,
			fitColumns : true,
			striped : true,
			idField : 'id',
			//sortName : 'ordernum',
			//sortOrder : 'desc',
			//remoteSort : true,
			pagination : true,
			pageSize : 20,
			pageList : [ 20, 30, 40 ,50 ],
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			}, {
				title : '申请人',
				field : 'username',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showThItem(\'{0}\');">'+value+'</a>', row.id);				
					}
				}
			}, {
				title : '维修金额',
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
						return '已终止';
					}else if(value =='COMPLETE'){
						return '已完成';
					}else if(value =='UPSENDED'){
						return '售后已发货';
					}
		        }	
			}, {
				title : '终止原因',
				field : 'abortReason',
				width : 150,
				align :'center',
				sortable : true
				
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
				sortable : true
				
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
				/* formatter: function(value,row,index){
					if(row.id == '7475de6e22cd4cd783acb85605eda9bd'){
						return '系统角色';
					}else{
						return formatString('<img onclick="wxForm_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="wxForm_remove(\'{2}\');" src="{3}"/>', row.id, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
					}
		        } */
			}] ],
			
		});
		
		//wxForm_searchForm_right = $('#wxForm_searchForm');
		wxForm_datagrid_right = $('#wxForm_datagrid_right').datagrid({
			url:'wxForm/wxFormAction!gainWxFormList.action',
			fit : true,
			fitColumns : true,
			striped : true,
			idField : 'id',
			//sortName : 'ordernum',
			//sortOrder : 'desc',
			//remoteSort : true,
			pagination : true,
			pageSize : 20,
			pageList : [ 20, 30, 40 ,50 ],
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '取货单号',
				field : 'qhFormId',
				width : 150,
				align :'center',
				hidden : true
			},{
				title : '申请人',
				field : 'username',
				width : 150,
				align :'center',
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return value;				
					}
				}
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
						 return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\');">待处理</a>', row.status,row.qhFormId);			
					}else if(value =='PROCESS'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\');">正在处理中</a>', row.status,row.qhFormId);			
					}else if(value =='NOTIFIYED'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\');">已通知取货</a>', row.status,row.qhFormId);			
					}else if(value =='DOWNSENDED'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\',\'{2}\');">地包已发货</a>',row.id, row.status,row.qhFormId);			
					}else if(value =='ABORT'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\');">已终止</a>', row.status,row.qhFormId);			
					}else if(value =='COMPLETE'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\');">已完成</a>', row.status,row.qhFormId);
					}else if(value =='UPRECEIVED'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\',\'{2}\');">售后已收货</a>',  row.id,row.status,row.qhFormId);
					}else if(value =='UPSENDED'){
						return formatString('<a id="btn" style="color:red;text-decoration:none;" onclick="showQhItem(\'{0}\',\'{1}\');">售后已发货</a>', row.status,row.qhFormId);
					}
		        }
		        	
			}, {
				title : '终止原因',
				field : 'abortReason',
				width : 150,
				align :'center',
				sortable : true
				
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
				sortable : true
				
			},{
				title : '备注',
				field : 'remark',
				width : 150,
				align :'center',
			},{
				title : '操作',
				field : 'action',
				width : 150,
				/* align :'center',
				formatter: function(value,row,index){
					if(row.id == '7475de6e22cd4cd783acb85605eda9bd'){
						return '系统角色';
					}else{
						return formatString('<img onclick="wxForm_edit(\'{0}\');" src="{1}"/>&nbsp;<img onclick="wxForm_remove(\'{2}\');" src="{3}"/>', row.id, 'style/images/pencil.png', row.id, 'style/images/cancel.png');
					}
		        } */
			}] ],
			
		});
		
		
	});
	
	
	function showThItem(id){
		$.messager.confirm('确认', '您是否要受理当前选中的项目？', function(r) {
		
			if (r){
			
				$.ajax({
				type:"post",
				url:"wxForm/wxItemAction!existStatus.action?formId="+id,
				//data:formValue,
				dataType:"JSON",
				success : function(obj){
				if (obj.success) {
					$('<div/>').dialog({
			           href : 'wxForm/wxItemAction!showWxItem.action?formId='+id,
					   width : 450,
			           height : 600,
						modal : true,
						title : '退款详情',
						buttons : [
						 {
						text : '拒绝维修',
						//iconCls : 'icon-add',
						handler : function() {
							     $('<div/>').dialog({
									href : 'wxForm/wxFormAction!toUpdate.action?id='+$('#id').val(),
									width : 300,
									height : 150,
									modal : true,
									title : '拒绝原因',
									buttons : [ {
										text : '保存',
										iconCls : 'icon-add',
										handler : function() {
											var d = $(this).closest('.window-body');
											$('#wxForm_addForm').form({
												url : 'wxForm/wxFormAction!updateWxForm.action',
												success : function(result) {
													var r = $.parseJSON(result);
													try {
														if (r.success) {
														   // wxForm_datagrid_right.datagrid('load');
															d.dialog('destroy');
															$('#order_addForm').closest('.window-body').dialog('destroy');
															wxForm_datagrid.datagrid('load');
							    						    wxForm_datagrid_right.datagrid('load');
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
											$('#wxForm_addForm').submit();
										}
									} ],
									onClose : function() {
										$(this).dialog('destroy');
									}
								});

						}}, {
						text : '添加取货单',
						//iconCls : 'icon-add',
						handler : function() {
							$('<div/>').dialog({
								href : 'qhForm/qhFormAction!toAddWxForm.action?userName='+$('#username').val()+'&id='+$('#id').val(),
								width : 450,
								height : 500,
								modal : true,
								title : '添加取货单',
								buttons : [ {
									text : '保存',
									iconCls : 'icon-add',
									handler : function() {
										var d = $(this).closest('.window-body');
										$('#qhForm_addForm').form({
											url : 'qhForm/qhFormAction!addQhForm.action',
											success : function(result) {
												var r = $.parseJSON(result);
												try {
													if (r.success) {
														d.dialog('destroy');
														wxForm_datagrid.datagrid('load');
													    wxForm_datagrid_right.datagrid('load');
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
										$('#qhForm_addForm').submit();
									}
								} ],
								onClose : function() {
									$(this).dialog('destroy');
								}
							     });$('#order_addForm').closest('.window-body').dialog('destroy');
									}}],
										  onClose : function() {
											$(this).dialog('destroy');
										}  
							        });
							        $.messager.show({
											title : '提示',
											msg : obj.msg});
								 }else {
										
										$.messager.alert('提示', obj.msg,'info');
									}
									
								 }});
						
						        }
			
		});
		
	}
	
	
	
	function showQhItem(id,status,formId){
	      if(status == "DOWNSENDED"){
	      	$('<div/>').dialog({
			href : 'qhItem/qhItemAction!showQhItem.action?id='+id+'&formId='+formId,
			width : 450,
			height : 500,
			modal : true,
			title : '添加取货单',
			buttons : [{
				text : '确认收货',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$.ajax({
					type:"post",
				    url:'qhForm/qhFormAction!changeStatus.action?id='+$('#id').val()+'&status=UPRECEIVED',
				    //data:formValue,
				    dataType:"JSON",
				    success : function(obj){
				      try {
						 if (obj.success) {
				    		 wxForm_datagrid_right.datagrid('load');
									d.dialog('destroy');
									$.messager.show({
										title : '提示',
										msg : r.msg
									});									
								}else{
									$.messager.alert('提示', r.msg,'info');								
								}
				        
					} catch (e) {
						// TODO: handle exception
						$.messager.alert('提示', r.msg,'info');
					}
				     }});
					
					
					/* $('#qhForm_addForm').form({
						url : 'qhForm/qhFormAction!changeStatus.action?qhFormId='+$("#qhFormId").val()+'&status=UPRECEIVED',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
								    wxForm_datagrid_right.datagrid('load');
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
					$('#qhForm_addForm').submit(); */
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	      
	      }else if(status == "UPRECEIVED"){
	      	$('<div/>').dialog({
			href : 'qhItem/qhItemAction!showQhItem.action?id='+id+'&formId='+formId,
			width : 450,
			height : 500,
			modal : true,
			title : '添加取货单',
			buttons : [{
				text : '确认发货',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$.ajax({
					type:"post",
				    url:'qhForm/qhFormAction!changeStatus.action?id='+$('#id').val()+'&status=UPSENDED',
				    //data:formValue,
				    dataType:"JSON",
				    success : function(obj){
				      try {
						 if (obj.success) {
				    		 wxForm_datagrid_right.datagrid('load');
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
				     }});
					
				}
			}],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	      }else{
	        $.messager.alert('提示', r.msg,'info');
	      
	      }
				
	} 
/**
	 * 检索
	 */	
	function wxForm_search(){
		wxForm_datagrid.datagrid('load', sy.serializeObject(wxForm_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function wxForm_clean(){
		$('#wxForm_searchForm input').val('');
		wxForm_datagrid.datagrid('load', {});	
	}
	
</script>
<!-- <div class="easyui-layout" data-options="border:false,fit:true">
  
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		
		 
		<!-- 
		<form class="easyui-form" id="wxForm_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>订单号:</th>
					<td><input name="orderId" placeholder="请输入物流公司名称"/></td>
					<th>退款金额</th>
					<td><input name="" placeholder="请输入物流公司代码"/></td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="wxForm_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="wxForm_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form> 
		</div>
	</div>
	<div data-options="region:'center',border:false">
	     <table id="wxForm_datagrid"  style="width:100%;height: 100%"></table>
	   <div>
	-->
     
 
	<div class="easyui-layout" data-options="fit:true,border:true"style="background-color: #e1e1e1;border: 1px solid #e1e1e1">
	    <div data-options="region:'center',border:false">
			<div class="easyui-layout" data-options="fit:true,border:false">
				<div data-options="region:'center',border:false">
					<table id="wxForm_datagrid"  style="width:100%;height: 100%"></table>
				</div>
			</div>
		</div>
		<div data-options="region:'east',border:false"
			style="width:1000px;">
			<div class="easyui-layout" data-options="fit:true,border:false">
				<div data-options="region:'center',border:true">
				  <table id="wxForm_datagrid_right"  style="width:100%;height: 100%"></table>
				</div>
			</div>
		</div>
	</div>
				
</div>
