<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_acc_datagrid;
	var editRow = undefined;
	var aid = undefined;
	var admin_acc_searchForm;
	$(function(){	
		admin_acc_searchForm = $('#admin_acc_searchForm');
		admin_acc_datagrid = $('#admin_acc_datagrid').datagrid({
			url : 'acc/accAction!gainAccessoriesList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			pagination : true,
			pageSize : 15,
			pageList : [ 5, 15,20, 40 ,50 ],			
			nowrap : false,
			striped : true,
			remoteSort : true,
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '配件名称',
				field : 'name',
				width : 150,
				align :'center'
			}, {
				title : '商品代码',
				field : 'accessoriesNum',
				width : 150,
				align :'center'
			},{
				title : '规格代码',
				field : 'specCode',
				width : 150,
				align :'center'
			},{
				field : 'defaultImg',
				title : '默认图片',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					if(value!=null&&value!=''){
						return formatString('<img width="60px" height="40px" src="{0}"/>', value);
					}	
		        }
			}, {
				title : '操作人',
				field : 'userName',
				width : 150,
				align :'center'
			},{
				title : '库存',
				field : 'stock',
				width : 150,
				align : 'center'
			}, {
				title : '价格',
				field : 'price',
				width : 150,
				align :'center'
			},{
				title : '上下架状态',
				field : 'isshelves',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					if(value =="true"){
						value="上架";
					}else if(value =="false"){
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
				title : '品牌',
				field : 'brandName',
				width : 150,
				align :'center'			
			},{
				title : '类别',
				field : 'catName',
				width : 150,
				align :'center'
			},{
				title : '是否原装',
				field : 'isoriginal',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					if(value=="true"){
						value="是原装";
					}else if(value=="false"){
						value="不是原装";
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
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<img onclick="admin_acc_edit(\'{0}\');" src="{1}"/>&nbsp;&nbsp;&nbsp;&nbsp;<img onclick="admin_acc_remove(\'{2}\');" src="{3}"/>&nbsp;&nbsp;&nbsp;&nbsp;<img onclick="admin_acc_shelves(\'{4}\')" src="{5}"/>',row.id,'style/images/pencil.png', row.id,'style/images/cancel.png',row.id,'style/images/tip.png');									
		        }			
			}] ],
			toolbar : [{
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					admin_acc_add();
				}
			}, '-',{
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					admin_acc_remove();
				}
			},'-',{
				text : '批量导出',
				iconCls : 'icon-print',
				handler : function() {
					admin_acc_export();
				}
			},'-',{
				text : '批量导入',
				iconCls : 'icon-print',
				handler : function() {
					admin_acc_import();
				}
			}],
			
		});
		$('#admin_acc_searchForm input').keydown(function(event){
			if(event.keyCode==13){
				admin_acc_search();
			}
		});
	});

	/**
	 * 添加配件信息
	 */
	admin_acc_add = function(){
		admin_acc_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		var subtitle="添加配件";
		var url="acc/accAction!toAdd.action";
		var icon="icon icon-magic";
		if (!$('#tabs').tabs('exists', subtitle)) {
				$('#tabs').tabs('add', {
					title : subtitle,
					href:url,
					closable : true,
					icon:icon
				});
		} else {
				$('#tabs').tabs('select', subtitle);
				$('#mm-tabupdate').click();
		}
		tabClose();
	};
	/**
	 * 编辑配件信息
	 */
	admin_acc_edit = function(id){
		admin_acc_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		var subtitle="修改配件";
		var url="acc/accAction!toUpdate.action?id="+id;
		var icon="icon icon-magic";
		$("#admin_goods_edit_editForm").form('load',{});
		if (!$('#tabs').tabs('exists', subtitle)) {
				$('#tabs').tabs('add', {
					title : subtitle,
					href:url,
					closable : true,
					icon:icon
				});
		} else {
				$('#tabs').tabs('select', subtitle);
				$.messager.alert('提示','已经打开一个编辑页面,请完成后在操作!','info');
				return;
				$('#mm-tabupdate').click();
		}
		tabClose();
	};

	/**
	 * 单条或批量删除配件信息
	 */		
	function admin_acc_remove(id) {
		var rows;
		if(aid != id){
			admin_acc_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_acc_datagrid.datagrid('checkRow', admin_acc_datagrid.datagrid('getRowIndex', id));
			rows = admin_acc_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_acc_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : 'acc/accAction!dropAccessories.action?ids='+ids,
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_acc_datagrid.datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_acc_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	/**
	 * 检索
	 */	
	function admin_acc_search(){
		admin_acc_datagrid.datagrid('load',sy.serializeObject(admin_acc_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_acc_clean(){
		$('#admin_acc_searchForm input').val('');
		admin_acc_datagrid.datagrid('load', {});	
	}
	/**
	 * 配件下架
	 */
	admin_acc_shelves = function(id){
		var rows;
		if(aid != id){
			admin_acc_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_acc_datagrid.datagrid('checkRow', admin_acc_datagrid.datagrid('getRowIndex', id));
			rows = admin_acc_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_acc_datagrid.datagrid('getSelections');
		}
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要下架当前选中的配件，如果下架该配件，其库存、价格将默认为0!', function(r) {
				if (r) {
					$.ajax({
						url : 'acc/accAction!updateShelves.action?id='+id,
						//data : {'id' : id},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_acc_datagrid.datagrid('load');
								//admin_acc_recover_datagrid.datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_acc_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要下架的配件！','info');
		}
	};
	 /**
	  * 批量导出
	  */
	 admin_acc_export = function(){
		 admin_acc_searchForm.form('submit',{
		 	url:'acc/accAction!exportAccExcel.action'
		 });
	 };
	 /**
	  * 批量导入
	  */
	 /* admin_acc_export = function(){
		 admin_acc_searchForm.form('submit',{
		 	url:'acc/accAction!importAccExcel.action'
		 });
	 }; */
	 
	 admin_acc_import=function(){
			$('<div/>').dialog({
				href : 'acc/accAction!toImport_Ex_accData.action',
				width : 400,
				height : 150,
				modal : true,
				title : '导入考勤表',
				iconCls:'icon-ok',
				buttons : [ {
					text : '导入',
					iconCls : 'icon-ok',
					handler : function() {
						var d = $(this).closest('.window-body');
						$.messager.progress();
						var acc_Ex_import=$('#acc_Ex_import');
						acc_Ex_import.form('submit',{
							url:'acc/accAction!import_Ex_accData.action',
							onSubmit:function(){
								var isValid = acc_Ex_import.form('validate');
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
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_acc_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>配件名称:</th>
					<td><input name="name" placeholder="请输入配件名称"/></td>
					<th>商品代码:</th>
					<td><input name="accessoriesNum" placeholder="请输入商品代码"/></td>
					<th>规格代码:</th>
					<td><input name="specCode" placeholder="请输入规格代码"/></td>
					<th>最后操作人:</th>
					<td><input name="userName" placeholder="请输入最后操作人"/></td>
					<th>配件品牌:</th>
					<td>
						<span style="padding-left:10px">
							<input id="brandName" name="brandName" class="easyui-combobox" 
							data-options="url:'acc/accAction!gainAllBrand.action',valueField:'brandName',textField:'brandName',editable:false,multiple:false"/>
						</span>
					</td>
					<th>配件类别:</th>
					<td>
						<span style="padding-left:10px">
							<input id="catName" name="catName" class="easyui-combobox" 
							data-options="url:'acc/accAction!gainAllCat.action',valueField:'catName',textField:'catName',editable:false,multiple:false"/>
						</span>
					</td>			
					<th>操作:</th>
					<td>																											
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_acc_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_acc_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_acc_datagrid"></table>
	</div>
</div>