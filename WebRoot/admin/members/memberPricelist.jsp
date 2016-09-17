<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_membersPrice_datagrid;
	var editRow = undefined;
	var mid = undefined;
	var admin_membersPrice_searchForm;
	var atype_list_import;
	$(function(){
		admin_membersPrice_searchForm = $('#admin_membersPrice_searchForm');
		admin_membersPrice_datagrid = $('#admin_membersPrice_datagrid').datagrid({
			url:'members/membersPriceAction!gainMembersPriceList.action',
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
			toolbar : [{
				text : '批量导出用户价格',
				iconCls : 'icon-print',
				handler : function() {
					admin_membersPrice_export();
			}} ], 
			columns : [[ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '当前日期',
				field : 'currentTime',
				width : 200,
				align :'left',	
				/* formatter: function(value,row,index){				
					return formatString('<a id="btn" onclick="gainmembersPrice(\'{0}\');">'+value+'</a>', row.id);				
		        } */
			},{
				title : '区域',
				field : 'pcat',
				width : 80,
				align :'left',
				/* formatter: function(value,row,index){
					if(value!=null && value!=''){
						return value;
					}else{
						return '---';
					}
		        } */
			},{
				title : '门店名称',
				field : 'userName',
				width : 200,
				align :'left'
		    },{
				title : '提货量',
				field : 'totalNum',
				width : 230,
				align :'left'
				
			},{
				title : '型号',
				field : 'goodsName',
				width : 60,
				align :'center'
				
			},{
				title : '颜色',
				field : 'colorName',
				width : 150,
				align :'center',
				/* formatter: function(value,row,index){
					if(value!=null && value!=''){
						return value;
					}else{
						return '---';
					}
		        } */
			},{
				title : '成本价',
				field : 'price',
				width : 100,
				align :'center'
			
			},{
				title : '原供价',
				field : 'originalPrice',
				width : 100,
				align :'center',
				sortable : true
			
			},{
				title : '调整时间',
				field : 'createTime',
				width : 150,
				align :'center',
				sortable :true
			},{
				title : '操作人',
				field : 'overMan',
				width : 150,
				align :'left'
			},{
				title : '调整后价格',
				field : 'afterFloatPrice',
				width : 100,
				align :'center'
			},{
				title : '日供货量',
				field : 'itemNum',
				width : 100,
				align :'center'
			}/* {
				title : '操作',
				field : 'action',
				width : 100,
				align :'center',
				formatter: function(value,row,index){				
					return formatString('<img onclick="admin_membersPrice_remove(\'{0}\');" src="{1}"/>', row.id, 'style/images/cancel.png');				
		        }
				
			} */] ],
		});
	});
	
	$(".datagrid-cell:contains('登录名称')").css("text-align","center");
	$(".datagrid-cell:contains('真实姓名')").css("text-align","center");
	$(".datagrid-cell:contains('所在地区')").css("text-align","center");
	$(".datagrid-cell:contains('业务人员姓名')").css("text-align","center");
	
	
	
	
	
	
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
	function admin_membersPrice_search() {
		admin_membersPrice_datagrid.datagrid('load', sy
				.serializeObject(admin_membersPrice_searchForm));
	}

	/**
	 * 清空条件
	 */
	function admin_membersPrice_clean() {
		$('#admin_membersPrice_searchForm input').val('');
		admin_membersPrice_datagrid.datagrid('load', {});
	}

		
	/* membersPrice_list_export = function(){
	    admin_membersPrice_searchForm.form('submit',{
			url:'members/membersPriceAction!exportMembersPriceExcel.action'
		});
	}; */
	
	admin_membersPrice_export=function(){
			admin_membersPrice_searchForm.form('submit',{
				url:'members/membersPriceAction!exportMemberPriceExcel.action'
			});
		};	
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 36px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_membersPrice_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>登录名称:</th>
					<td><input name="userName" placeholder="请输入用户名"/></td>
					<!-- <th>真实姓名:</th>
					<td><input name="truename" placeholder="请输入真实姓名"/></td> -->
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
					<th>提货时间:</th>
					<td><input id="admin_starttime" name="_startTime"  class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_endtime\')}'" />
					          至&nbsp;<input id="admin_endtime" name="_endTime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_starttime\')}'" />
					</td>
					<th>按地域选择商户:</th>
					<td>
					<input id="member_region_tree" name = "region" />
					
					</td>
													
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_membersPrice_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_membersPrice_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_membersPrice_datagrid"></table>
	</div>
</div>