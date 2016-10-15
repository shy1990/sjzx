<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_acc_recover_datagrid;
	var editRow = undefined;
	var aid = undefined;
	var admin_acc_recover_searchForm;
	$(function(){	
		admin_acc_recover_searchForm = $('#admin_acc_recover_searchForm');
		admin_acc_recover_datagrid = $('#admin_acc_recover_datagrid').datagrid({
			url : 'acc/accAction!gainShelvesList.action',
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
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<a id="btn" style="text-decoration:underline;color:#f00" onclick="editRecoverPrice(\'{0}\');">'+value+'</a>', row.id);				
		        } 
				
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
				title : '下架时间',
				field : 'shelvesTime',
				width : 200,
				align :'center'
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
				width : 80,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<img onclick="admin_acc_recover(\'{0}\')" src="{1}"/>',row.id,'style/images/redo.png');									
		        }			
			}] ],			
		});
		$('#admin_acc_recover_searchForm input').keydown(function(event){
			if(event.keyCode==13){
				admin_acc_recover_search();
			}
		});
	});
	/**
	 * 检索
	 */	
	function admin_acc_recover_search(){
		admin_acc_recover_datagrid.datagrid('load',sy.serializeObject(admin_acc_recover_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_acc_recover_clean(){
		$('#admin_acc_recover_searchForm input').val('');
		admin_acc_recover_datagrid.datagrid('load', {});	
	}
	/**
	 * 配件恢复
	 */
	admin_acc_recover = function(id){
		var rows;
		if(aid != id){
			admin_acc_recover_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_acc_recover_datagrid.datagrid('checkRow', admin_acc_recover_datagrid.datagrid('getRowIndex', id));
			rows = admin_acc_recover_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_acc_recover_datagrid.datagrid('getSelections');
		}
		if (rows.length > 0) {
			$.messager.confirm('确认', '确定要恢复?', function(r) {
				if (r) {
					$.ajax({
						url : 'acc/accAction!recoverShelves.action?id='+id,
						//data : {'id' : id},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_acc_recover_datagrid.datagrid('load');
								//admin_acc_datagrid.datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_acc_recover_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要下架的配件！','info');
		}
	};
	
	/**
	 * 修改配件价格
	 */
	 editRecoverPrice = function(id){
	 	$('<div/>').dialog({
	 		href : 'acc/accAction!toEditPrice.action?id='+id,
			width : 300,
			height : 330,
			modal : true,
			title : '编辑配件价格',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					if(validPreTable()==false){
						return;
					}
					$('#admin_acc_recover_editForm').form('submit', {
						url : 'acc/accAction!updatePrice.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									admin_acc_recover_datagrid.datagrid('load');
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
				var index = admin_acc_recover_datagrid.datagrid('getRowIndex', id);
				var rows = admin_acc_recover_datagrid.datagrid('getRows');
				var o = rows[index];
				$('#admin_acc_recover_editForm').form('load', o);
			}
	 	});
	 };
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_acc_recover_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>配件名称:</th>
					<td><input name="name" placeholder="请输入配件名称"/></td>
					<th>配件编号:</th>
					<td><input name="accessoriesNum" placeholder="请输入配件编号"/></td>
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
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_acc_recover_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_acc_recover_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_acc_recover_datagrid"></table>
	</div>
</div>