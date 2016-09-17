<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_members_datagrid;
	var editRow = undefined;
	var mid = undefined;
	var admin_members_searchForm;
	var atype_list_import;
	$(function(){
		admin_members_searchForm = $('#admin_members_searchForm');
		admin_members_datagrid = $('#admin_members_datagrid').datagrid({
			url:'members/membersAction!gainMembersList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			pagination : true,
			pageSize : 25,
			pageList : [ 100, 200, 300, 500,1000 ],	
			nowrap : false,
			striped : true,
			sortName : 'id',
			sortOrder : 'desc',
			remoteSort : true,
			toolbar : [/*{
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					admin_members_remove();
				}
			}*/{
				text : '设置不可见单品',
				iconCls : 'icon-no',
				handler : function() {
					admin_goods_memberInvisible();
				}
			},'-',{
				text : '批量导出',
				iconCls : 'icon-print',
				handler : function() {
					admin_members_export();
				}
			},'-',{
				text : '关闭货到付款',
				iconCls : 'icon-no',
				handler : function() {
					admin_members_closePay();
				}
			},'-',{
				text : '打开货到付款',
				iconCls : 'icon-ok',
				handler : function() {
					admin_members_openPay();
				}
			}, '-',{
				text : '批量导入地域类型',
				iconCls : 'icon-remove',
				handler : function() {
					atype_list_import();
				}
			}], 
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '登录名称',
				field : 'username',
				width : 200,
				align :'left',	
				formatter: function(value,row,index){				
					return formatString('<a id="btn" onclick="gainMembers(\'{0}\');">'+value+'</a>', row.id);				
		        }
			},{
				title : '真实姓名',
				field : 'truename',
				width : 80,
				align :'left',
				formatter: function(value,row,index){
					if(value!=null && value!=''){
						return value;
					}else{
						return '---';
					}
		        }
			},{
				title : '所在地区',
				field : 'address',
				width : 200,
				align :'left'
				/* ,
				formatter: function(value,row,index){
					if(typeof(value) != 'undefined'){
						if(value.length > 10){
							return "<span title="+value+">" + value.substr(0, 10) + "</span>";
						}else{
							return "<span title="+value+">" + value + "</span>";
						}	
					}
		        } */
		    },{
				title : '所在街道',
				field : 'three_a',
				width : 230,
				align :'left',
				
			},{
				title : '联系地址',
				field : 'saddress',
				width : 230,
				align :'left'
				
			},{
				title : '地域类别',
				field : 'aType',
				width : 60,
				align :'center'
				
			},{
				title : '渠道编码',
				field : 'ditchEncode',
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
				title : '移动电话',
				field : 'mobile',
				width : 100,
				align :'center'
			
			},{
				title : '固定电话',
				field : 'telphone',
				width : 100,
				align :'center',
				sortable : true
			
			},{
				title : '注册时间',
				field : 'regTime',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '业务人员姓名',
				field : 'sname',
				width : 120,
				align :'left'
			},{
				title : '业务人员手机号码',
				field : 'smobile',
				width : 120,
				align :'center'
			},{
				title : '操作',
				field : 'action',
				width : 100,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<img onclick="admin_members_remove(\'{0}\');" src="{1}"/>', row.id, 'style/images/cancel.png');				
		        }
				
			}] ],
		});
	});
	
	$(".datagrid-cell:contains('登录名称')").css("text-align","center");
	$(".datagrid-cell:contains('真实姓名')").css("text-align","center");
	$(".datagrid-cell:contains('所在地区')").css("text-align","center");
	$(".datagrid-cell:contains('业务人员姓名')").css("text-align","center");
	
	/**
	 * 单条或批量删除用户(物理删除)
	 */	
	function admin_members_remove(id) {
		var rows;
		if(mid != id){
			admin_members_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_members_datagrid.datagrid('checkRow', admin_members_datagrid.datagrid('getRowIndex', id));
			rows = admin_members_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_members_datagrid.datagrid('getSelections');
			
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : 'members/membersAction!deleteMembers.action?ids='+ids,
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_members_datagrid.datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_members_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	function admin_goods_memberInvisible(){
	     	var rows;
	     	var skuRows;
		rows = admin_members_datagrid.datagrid('getSelections');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要为当前选中的商户设置不可见商品？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$('<div/>').dialog({
						            href : 'sku/skuAction!toInvisibleSkuList.action',
								    width : 1500,
						            height : 700,
									modal : true,
									title : '单品列表',
									buttons : [{
								    text : '设置',
								     //iconCls : 'icon-add',
								    handler : function() {
								       var skuIds = [] ;
											skuRows = admin_sku_datagrid.datagrid('getSelections');
										//	if (skuRows.length > 0) {
												for ( var i = 0; i < skuRows.length; i++) {
														skuIds.push(skuRows[i].id);
													}
											 $.ajax({
											    type:"post",
											    url:"members/membersAction!addVisibleSku.action",
											    data : {
														ids : ids.join(','),
														skuIds : skuIds.join(',')
												      },
											    dataType:"JSON",
									            success : function(obj){
									             if (obj.success) {
									             	$('#admin_sku_searchForm').closest('.window-body').dialog('destroy');
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
													
									//	}
										}},{
								text : '取消',
								handler : function() {
								   $('#admin_sku_searchForm').closest('.window-body').dialog('destroy');
									    }
								  }],
								  onClose : function() {
										$(this).dialog('destroy');
												}  
									});
				}else{
					admin_members_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要设置的记录！','info');
		}
	
	}
	
	/**
	  * 批量导出
	  */
	 admin_members_export = function(){
		 admin_members_searchForm.form('submit',{
		 	url:'members/membersAction!exportMembersExcel.action'
		 });
	 };
	 
	 /**
	 * 单条或批量关闭用户货到付款
	 */	
	function admin_members_closePay() {
		var rows;
		rows = admin_members_datagrid.datagrid('getSelections');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要关闭当前选中商户的货到付款？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : 'members/membersAction!closePay.action?ids='+ids,
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								
								$.messager.show({
									title : '提示',
									msg : result.msg
								});
							}else{
								$.messager.show({
									title : '提示',
									msg : result.msg
								});
							}
						}
					});
				} else {
					admin_members_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示', '请勾选要关闭的商户！', 'info');
		}
	}
	
	 /**
	 * 单条或批量打开用户货到付款
	 */	
	function admin_members_openPay() {
		var rows;
		rows = admin_members_datagrid.datagrid('getSelections');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要打开当前选中商户的货到付款？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : 'members/membersAction!openPay.action?ids='+ids,
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								
								$.messager.show({
									title : '提示',
									msg : result.msg
								});
							}else{
								$.messager.show({
									title : '提示',
									msg : result.msg
								});
							}
						}
					});
				} else {
					admin_members_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示', '请勾选要打开的商户！', 'info');
		}
	}
	
	//批量上传
		atype_list_import=function(){
			$('<div/>').dialog({
				href : 'members/membersAction!toImport_Ex_atypeData.action',
				width : 400,
				height : 150,
				modal : true,
				title : '导入地域表',
				iconCls:'icon-ok',
				buttons : [ {
					text : '导入',
					iconCls : 'icon-ok',
					handler : function() {
						var d = $(this).closest('.window-body');
						$.messager.progress();
						var atype_Ex_import=$('#atype_Ex_import');
						atype_Ex_import.form('submit',{
							url:'members/membersAction!import_Ex_atypeData.action',
							onSubmit:function(){
								var isValid = atype_Ex_import.form('validate');
								if (!isValid){
									$.messager.progress('close');	// 当form不合法的时候隐藏工具条
								}
								return isValid;
							},
							success : function(json) {
							   var j = $.parseJSON(json);
								$.messager.progress('close');	// 当成功提交之后隐藏进度条
								try {
									console.info(json);
									
								} catch (e) {
									$.messager.alert('Warning','脚本错误,请重试!');  
								}
								if(j.success){
									/* $.messager.show({
										title : '提醒',
										msg : j.msg,
										timeOut : 5000,
										showType : 'slide'
									});  */
									$.messager.alert('提示',j.msg);
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
	 * 省市区树形列表
	 */
	$(function() {
		$('#member_region_tree')
				.combotree(
						{
							url : 'region/regionAction!gainRegionTreeList.action',
							valueField : 'id',
							textField : 'text',
							required : false,
							lines : true,
							cascaseCheck : true,
							//multiple : true,
							onBeforeExpand : function(node) {
								$('#member_region_tree').combotree("tree")
										.tree("options").url = "region/regionAction!gainRegionTreeList.action?pid="
										+ node.id;
							},
							onLoadSuccess : function(node, data) {
								//$("#member_region_tree").combotree('tree').tree("collapseAll");
								// alert(JSON.stringify(data));  
							}
						});

	});

	/**
	 * 检索
	 */
	function admin_members_search() {
		admin_members_datagrid.datagrid('load', sy
				.serializeObject(admin_members_searchForm));
	}

	/**
	 * 清空条件
	 */
	function admin_members_clean() {
		$('#admin_members_searchForm input').val('');
		admin_members_datagrid.datagrid('load', {});
	}

	/**
	 * 查看具体会员信息
	 */
	gainMembers = function(id) {
		/*  		admin_members_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		 var subtitle="查看会员信息";
		 var url="members/membersAction!toShowMembers.action?id="+id;
		 $('#admin_showMembers_showForm').form('load', {});
		 if(!$('#tabs').tabs('exists',subtitle)){
		 $('#tabs').tabs('add',{
		 title : subtitle,
		 href :url,
		 closable : true
		 });
		 }
		 tabClose(); */
		$('<div/>').dialog({
			href : "members/membersAction!toShowMembers.action?id=" + id,
			width : 450,
			height : 600,
			modal : true,
			title : '查看会员信息',
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	};
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_members_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>登录名称:</th>
					<td><input name="username" placeholder="请输入用户名"/></td>
					<th>真实姓名:</th>
					<td><input name="truename" placeholder="请输入真实姓名"/></td>
<%--  					<th>手机号:</th>
					<td><input name="mobile" placeholder="请输入手机号"/></td> 
				</tr>
				<tr>
 					<th>状态:</th>
					<td>
						<select class="easyui-combobox" name="state" style="width:140px">
							<option value=-1 selected="selected">请选择</option>
							<option value=0>未审核</option>
							<option value=1>审核通过</option>
							<option value=2>审核未通过</option>
						</select>
					</td>  --%>
					<th>注册时间:</th>
					<td><input id="admin_starttime" name="_startTime"  class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_endtime\')}'" />
					          至&nbsp;<input id="admin_endtime" name="_endTime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_starttime\')}'" />
					</td>
					<th>按地域选择商户:</th>
					<td>
					<input id="member_region_tree" name = "regional" />
					
					</td>
													
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_members_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_members_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_members_datagrid"></table>
	</div>
</div>