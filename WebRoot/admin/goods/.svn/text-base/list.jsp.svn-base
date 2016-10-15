<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_goods_datagrid;
	var editRow = undefined;
	var gid = undefined;
	var goods_list_import;
	var admin_goods_searchForm;
	$(function(){	
		admin_goods_searchForm = $('#admin_goods_searchForm');
		admin_goods_datagrid = $('#admin_goods_datagrid').datagrid({
			url : 'goods/goodsAction!gainGoodsList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			pagination : true,
			pageSize : 20,
			pageList : [ 100, 200, 300, 500,1000 ],	
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
				field : 'name',
				width : 150,
				align :'center'
			},{
				title : '品牌',
				field : 'brandName',
				width : 150,
				align :'center'							
			},{
				title : '是否电商热销',
				field : 'isShellingSupplier',
				width : 150,
				align :'center',
				styler: function(value,row,index){
				if (value != 'false'){
					return 'color:red;';
					}else{
					return 'color:green;';
					}},
					formatter: function(value,row,index){
					if(value !='false'){
						return '是';
					}else{
						return '否';
					}}						
			}, {
				title : '商品代码',
				field : 'goodsNum',
				width : 150,
				align :'center'			
			},{
				title : '规格代码',
				field : 'skuNum',
				width : 150,
				align :'center'
			},{
				title : '库存',
				field : 'stock' ,
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<a id="btn" style="text-decoration:underline;color:#f00" onclick="editPriceandStock(\'{0}\');">'+value+'</a>', row.id);				
		        } 
			},{
				title : '单价',
				field : 'pstring',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<a id="btn" style="text-decoration:underline;color:#f00" onclick="editPriceandStock(\'{0}\');">'+value+'</a>', row.id);				
		        } 

			},{
				title : '报价单热销',
				field : 'isQuotationHot',
				width : 150,
				align :'center',
 				formatter: function(value,row,index){				
					if(value=="true"){
						value="是报价单热销";
					}else if(value=="false"){
						value="非报价单热销";
					}	
					return value;			
		        },
		        styler: function(value,row,index){
					if (value == "true"){
						return 'color:red';
					}else if(value=="false"){
						return 'color:green';
					}
				} 
			
			},{
				title : '颜色',
				field : 'colorName',
				width : 150,
				align :'center'
			},{
				title : '最后操作人',
				field : 'userName',
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
			},{
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){//	&nbsp;&nbsp;&nbsp;&nbsp;<img onclick="admin_goods_modify(\'{4}\');" src="{5}"/>	,row.id,'style/images/tip.png'		
					return formatString('<img onclick="admin_goods_edit(\'{0}\');" src="{1}"/>&nbsp;&nbsp;&nbsp;&nbsp;<img onclick="admin_goods_remove(\'{2}\');" src="{3}"/>',
										 row.id,'style/images/pencil.png', row.id,'style/images/cancel.png');											 
		        }			
			}] ],
			toolbar : [{
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					admin_goods_add();
				}
			}, '-',{
				text : '批量移入仓库',
				iconCls : 'icon-remove',
				handler : function() {
					admin_goods_remove();
				}
			}, '-',{
				text : '批量导出',
				iconCls : 'icon-print',
				handler : function() {
					goods_list_export();
				}
			}, '-',{
				text : '批量导入价格',
				iconCls : 'icon-remove',
				handler : function() {
					goods_list_import();
				}
			},'-', {
				text : '批量设置为电商热销',
				iconCls : 'icon-ok',
				handler : function() {
					admin_goods_open();
				}},'-', {
				text : '批量取消电商热销',
				iconCls : 'icon-no',
				handler : function() {
					admin_goods_dan();
				}}],
			
		});
		
		$('#admin_goods_searchForm input').keydown(function(event){
			if(event.keyCode==13){
				admin_goods_search();
			}
		});
	});

	/**
	 * 查看具体商品信息
	 */
  	gainGoods = function(id) {
 		admin_goods_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
 		var subtitle="查看商品信息";
 		var url="goods/goodsAction!toShowGoods.action?id="+id;
 		$('#admin_showGoods_showForm').form('load', {});
  		if(!$('#tabs').tabs('exists',subtitle)){
 	 		$('#tabs').tabs('add',{
	 			title : subtitle,
	 			href :url,
	 			closable : true
	 		});
 		}else{
			$('#tabs').tabs('select', subtitle);
			$('#mm-tabupdate').click();	
 		}
 		tabClose();
	};
	/**
	 * 添加商品信息
	 */
	admin_goods_add = function(){
		admin_goods_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		var subtitle="添加商品(抓取外链)";
		var url="goods/goodsAction!toParam.action";
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
	 * 编辑商品信息
	 */
	admin_goods_edit = function(id){
		admin_goods_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		var subtitle="修改商品";
		var url="goods/goodsAction!toUpdate.action?id="+id;
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
				$.messager.alert('提示','已经打开一个编辑页面,请完成后再操作!','info');
				return;
				$('#mm-tabupdate').click();
		}
		tabClose();
	};
	/**
	 * 修改商品信息(抓取外链)
	 */
/* 	admin_goods_modify = function(id){
		admin_goods_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		var subtitle="修改商品(抓取外链)";
		var url="goods/goodsAction!toModify.action?id="+id;
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
				$.messager.alert('提示','已经打开一个编辑页面,请完成后再操作!','info');
				return;
				$('#mm-tabupdate').click();
		}
		tabClose();
	}; */
	/**
	 * 单条或批量删除goods
	 */	
	function admin_goods_remove(id) {		
		var rows;
		if(gid != id){
			admin_goods_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_goods_datagrid.datagrid('checkRow', admin_goods_datagrid.datagrid('getRowIndex', id));
			rows = admin_goods_datagrid.datagrid('getChecked');		
		}else{
			rows = admin_goods_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您确定移除当前选中的宝贝？如果恢复请到仓库中查看', function(r) {
				
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}    
					$.ajax({
						url : 'goods/goodsAction!deleteGoods.action?ids='+ids,
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_goods_datagrid.datagrid('load');
								admin_goods_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								if($('#admin_recycle_datagrid')){
									$('#admin_recycle_datagrid').datagrid('load');
								}				
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					admin_goods_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	
	
	/**
	 * 禁用单条或批量取消电商热销
	 */
	function admin_goods_dan(id) {
		var rows;
		if(gid != id){
			admin_goods_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_goods_datagrid.datagrid('checkRow', admin_goods_datagrid.datagrid('getRowIndex', id));	
			rows = admin_goods_datagrid.datagrid('getChecked');	
		}else{
			rows = admin_goods_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要取消当前选中的项目为电商热销？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						var ddd = rows[i].id;
						ids.push(ddd);
					}
					$.ajax({
						url : 'goods/goodsAction!danGoods.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_goods_datagrid.datagrid('load');
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
				}else{
					admin_goods_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要取消的记录！','info');
		}
	}
	
	/**
	 * 单条或批量设置为电商热销
	 */
	function admin_goods_open(id) {
	
		var rows;
		if(gid != id){
			admin_goods_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			admin_goods_datagrid.datagrid('checkRow', admin_goods_datagrid.datagrid('getRowIndex', id));	
			rows = admin_goods_datagrid.datagrid('getChecked');	
		}else{
			rows = admin_goods_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要设置当前选中的项目为电商热销？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						var ddd = rows[i].id;
						ids.push(ddd);
					}
					$.ajax({
						url : 'goods/goodsAction!openGoods.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								admin_goods_datagrid.datagrid('load');
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
				}else{
					admin_goods_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要启用的记录！','info');
		}
	}
	/**
	 * 检索
	 */	
	function admin_goods_search(){
		admin_goods_datagrid.datagrid('load',sy.serializeObject(admin_goods_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_goods_clean(){
		$('#admin_goods_searchForm input').val('');
		admin_goods_datagrid.datagrid('load', {});	
	}
	
	//批量上传
		goods_list_import=function(){
			$('<div/>').dialog({
				href : 'goods/goodsAction!toImport_Ex_goodsData.action',
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
						var goods_Ex_import=$('#goods_Ex_import');
						goods_Ex_import.form('submit',{
							url:'goods/goodsAction!import_Ex_goodsData.action',
							onSubmit:function(){
								var isValid = goods_Ex_import.form('validate');
								if (!isValid){
									$.messager.progress('close');	// 当form不合法的时候隐藏工具条
								}
								return isValid;
							},
							success : function(json) {
							   var j = $.parseJSON(json);
								$.messager.progress('close');	// 当成功提交之后隐藏进度条
								try {
									//console.info(json);
									
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
	 * 把商品单品放入宝贝仓库时，进行价格库存的修改
	 */	
	 editPriceandStock = function(id){
	 	//alert("id==="+id);
	 	$('<div/>').dialog({
	 		href : 'goods/goodsAction!toEditPriceandStock.action?id='+id,
			width : 600,
			height : 300,
			modal : true,
			title : '编辑单品价格和库存',
			buttons : [ {
				text : '保存',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					if(validPreTable()==false){
						return;
					}
					$('#admin_sku_editForm').form('submit', {
						url : 'goods/goodsAction!updatePriceandStock.action',
						success : function(result) {
							var r = $.parseJSON(result);
							try {
								if (r.success) {
									admin_goods_datagrid.datagrid('load');
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
				var index = admin_goods_datagrid.datagrid('getRowIndex', id);
				var rows = admin_goods_datagrid.datagrid('getRows');
				var o = rows[index];
				$('#admin_sku_editForm').form('load', o);
			}
	 	});
	 };
	goods_list_export=function(){
			admin_goods_searchForm.form('submit',{
				url:'goods/goodsAction!exportGoodsExcel.action'
			});
		};	
	
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_goods_searchForm" method="post">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>商品名称:</th>
					<td><input name="name" placeholder="请输入商品名称"/></td>
					<th>商品代码:</th>
					<td><input name="goodsNum" placeholder="请输入商品代码"/></td>
					<th>规格代码:</th>
					<td><input name="skuNum" placeholder="请输入规格代码"/></td>
					<th>最后操作人:</th>
					<td><input name="userName" placeholder="请输入最后操作人"/></td>
					<th>商品品牌:</th>
					<td>
						<span style="padding-left:10px">
							<input id="brandName" name="brandName" class="easyui-combobox" 
							data-options="url:'goods/goodsAction!gainGoodsBrandName.action',valueField:'brandName',textField:'brandName',editable:false,multiple:false"/>
						</span>
					</td>	
					<th>是否报价单热销:</th>
					<td>
						<select class="easyui-combobox" name="isQuotationHot" style="width:140px">
							<option value='-1' selected="selected">请选择</option>
							<option value='true'>是报价单热销</option>
							<option value='false'>非报价单热销</option>
						</select>
					</td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_goods_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_goods_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_goods_datagrid"></table>
	</div>
</div>