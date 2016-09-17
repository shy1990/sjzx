<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var disabled_members_datagrid;
	var editRow = undefined;
	var mid = undefined;
	var disabled_members_searchForm;
	$(function(){
		 disabled_members_searchForm = $('#disabled_members_searchForm');
		 disabled_members_datagrid = $('#disabled_members_datagrid').datagrid({
			url:'members/membersAction!gainDisabledMembersList.action',
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
				text : '设置为注册用户',
				iconCls : 'icon-no',
				handler : function() {
				 enabled_members();
				}}], 
			columns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				checkbox : true
			},{
				title : '登录名称',
				field : 'username',
				width : 150,
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
				width : 250,
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
				width : 150,
				align :'left'
			},{
				title : '业务人员手机号码',
				field : 'smobile',
				width : 150,
				align :'center'
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
	function enabled_members(id) {
		var rows;
		if(mid != id){
			 disabled_members_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			 disabled_members_datagrid.datagrid('checkRow', disabled_members_datagrid.datagrid('getRowIndex', id));
			rows = disabled_members_datagrid.datagrid('getChecked');		
		}else{
			rows = disabled_members_datagrid.datagrid('getSelections');
		}
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要设置当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : 'members/membersAction!enableMembers.action?ids='+ids,
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								 disabled_members_datagrid.datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : result.msg
							});
						}
					});
				}else{
					 disabled_members_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
				}
			});
		} else {
			$.messager.alert('提示','请勾选要删除的记录！','info');
		}
	}
	
	
	/**
	 * 检索
	 */	
	function disabled_members_search(){
	     alert("okk");
		 disabled_members_datagrid.datagrid('load',sy.serializeObject(disabled_members_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function disabled_members_clean(){
		$('#disabled_members_searchForm input').val('');
		 disabled_members_datagrid.datagrid('load', {});	
	}

	/**
	 * 查看具体会员信息
	 */
  	gainMembers = function(id) {
/*  		 disabled_members_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
			href : "members/membersAction!toShowMembers.action?id="+id,
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
		<form class="easyui-form" id="disabled_members_searchForm">
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
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="disabled_members_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="disabled_members_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="disabled_members_datagrid"></table>
	</div>
</div>