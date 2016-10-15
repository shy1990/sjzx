<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_sku_datagrid;
	var editRow = undefined;
	var gid = undefined;
	var goods_list_import;
	var admin_sku_searchForm;
	$(function(){	
		admin_sku_searchForm = $('#admin_sku_searchForm');
		admin_sku_datagrid = $('#admin_sku_datagrid').datagrid({
			url : 'sku/skuAction!gainInvisibleSkuList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			//sortName : 'sku.id',
			//sortOrder : 'desc',
			pagination : true,
			//remoteSort : true,
			pageSize : 20,
			pageList : [ 20, 30, 40 ,50 ],
			nowrap : false,
			striped : true,
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '品牌',
				field : 'brandName',
				width : 150,
				align :'center'
			},{
				title : '版本',
				field : 'goodsName',
				width : 150,
				align :'center'
			},{
				title : '制式',
				field : 'standard',
				width : 150,
				align :'center'							
			},{
				title : '颜色',
				field : 'colorName',
				width : 150,
				align :'center'
			}, {
				title : 'cpu',
				field : 'cpuNumber',
				width : 150,
				align :'center'			
			},{
				title : '内存',
				field : 'storage',
				width : 150,
				align :'center'
			},{
				title : '商品代码',
				field : 'skuCode' ,
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<a id="btn" style="text-decoration:underline;color:#f00" onclick="editPriceandStock(\'{0}\');">'+value+'</a>', row.id);				
		        } 
			},{
				title : '规格代码',
				field : 'skuNum',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<a id="btn" style="text-decoration:underline;color:#f00" onclick="editPriceandStock(\'{0}\');">'+value+'</a>', row.id);				
		        } 

			},{
				title : '地域',
				field : 'regionsName',
				width : 150,
				align :'center',
			},{
				title : '分类',
				field : 'colorName',
				width : 150,
				align :'center'
			}/* ,{
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){//	&nbsp;&nbsp;&nbsp;&nbsp;<img onclick="admin_sku_modify(\'{4}\');" src="{5}"/>	,row.id,'style/images/tip.png'		
					return formatString('<img onclick="admin_sku_edit(\'{0}\');" src="{1}"/>&nbsp;&nbsp;&nbsp;&nbsp;<img onclick="admin_sku_remove(\'{2}\');" src="{3}"/>',
										 row.id,'style/images/pencil.png', row.id,'style/images/cancel.png');											 
		        }	 		
			}*/] ], 
		    onLoadSuccess:function(){
		        //去重複
			    function unique(arr) {
				    var result = [], hash = {};
				    for (var i = 0, elem; (elem = arr[i]) != null; i++) {
				        if (!hash[elem]) {
				            result.push(elem);
				            hash[elem] = true;
				        }
				    }
				    return result;
				}
		    
		        var membersIds = [] ;
			    var membersRows = admin_members_datagrid.datagrid('getSelections');
			    if(membersRows.length > 0) {
			       for(var i = 0; i < membersRows.length; i++){
			          membersIds.push(membersRows[i].id);
			       }
			    };
	                  $.ajax({
	                     url:'members/membersAction!gainMembersGoodsByMid.action',
	                     cache:false,
	                     data : {
							     ids : membersIds.join(','),
								},
	                     dataType:'text',
	                     success:function(data){ 
	                     	var result=unique($.parseJSON(data));
	                      	  if(result!=null && result!=""){
		                        for(var i=0;i<result.length;i++){
		                        	var rowIndex=admin_sku_datagrid.datagrid('getRowIndex', result[i]);
		                        	if(rowIndex>=0){
		                        		admin_sku_datagrid.datagrid('checkRow',rowIndex);
		                        	}
		                        }	                        	 
	                      	 } 
	                     }
	                  });
	              }
			/* toolbar : [{
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					admin_sku_add();
				}
			}], */
			
		});
		
		$('#admin_sku_searchForm input').keydown(function(event){
			if(event.keyCode==13){
				admin_sku_search();
			}
		});
	});
	/**
	 * 省市区树形列表
	 */		
	 $(function(){
		 $('#sku_region_tree').combotree({   
		     url:'region/regionAction!gainRegionTreeList.action',
		     valueField : 'id',
			 textField : 'text',
		     required:true,
		     lines : true,
		     cascaseCheck:true,
		     //multiple : true,
		    //onlyLeafCheck: true,
		   onBeforeExpand:function(node) {
      $('#sku_region_tree').combotree("tree").tree("options").url = "region/regionAction!gainRegionTreeList.action?pid=" + node.id;
},   
		      onLoadSuccess: function (node, data) {
		      // $("#sku_region_tree").combotree('tree').tree("collapseAll");
		}});
	  });
	
	/**
	 * 检索
	 */	
	function admin_sku_search(){
		admin_sku_datagrid.datagrid('load',sy.serializeObject(admin_sku_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_sku_clean(){
		$('#admin_sku_searchForm input').val('');
		admin_sku_datagrid.datagrid('load', {});	
	}
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_sku_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>分类:</th>
					<td>
					  <select name="machineType">
					    <option value="">--请选择--</option>
					    <option value="lj">裸机</option>
					    <option value="pb">平板</option>
					    <option value="lnj">老年机</option>
					    <option value="etj">儿童机</option>
					    <option value="ptgnj">普通功能机</option>
					    <option value="bxjx">包销机</option>
					    <option value="ydhy">移动合约机</option>
					    <option value="lthy">联通合约机</option>
					    <option value="dxhy">电信合约机</option>
					  </select>
					</td>
					<th>版本:</th>
					<td>
					  <select name="standard">
					    <option value="">--请选择--</option>
					    <option value="移动">移动版</option>
					    <option value="联通">联通版</option>
					    <option value="电信">电信版</option>
					    <option value="全网">全网通</option>
					    <option value="双4G">双4G</option>
					  </select>
					</td>
					<th>商品名称:</th>
					<td>
						<span style="padding-left:10px">
							<input id="goodsName" name="goodsName"/>
						</span>
					</td>
					<th>商品品牌:</th>
					<td>
						<span style="padding-left:10px">
							<input id="brandName" name="brandName" class="easyui-combobox" 
							data-options="url:'brand/brandAction!gainSkuBrandName.action',valueField:'name',textField:'name',editable:false,multiple:false"/>
						</span>
					</td>
					<th>按地域选择单品:</th>
					<td>
					 <input id="sku_region_tree" name = "regional"/>
					</td>	 
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_sku_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_sku_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_sku_datagrid"></table>
	</div>
</div>