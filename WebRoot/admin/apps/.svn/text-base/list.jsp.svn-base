<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var admin_apps_datagrid;
	var editRow = undefined;
	var aid = undefined;
	var admin_apps_searchForm;
	$(function(){	
		admin_apps_searchForm = $('#admin_apps_searchForm');
		admin_apps_datagrid = $('#admin_apps_datagrid').datagrid({
			url:'apps/appsAction!gainAppsList.action',
			fit : true,
			fitColumns : true,
			idField : 'id',
			pagination : true,
			pageSize : 25,
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
				title : '会员登录名称',
				field : 'mname',
				width : 150,
				align :'center',
				formatter: function(value,row,index){	
					return formatString('<a id="btn" style="text-decoration:underline;color:#f00" onclick="showInfo(\'{0}\');">'+value+'</a>', row.id);				
		        }, 
									
			},{
				title : '店铺名称',
				field : 'shopName',
				width : 150,
				align :'center',
				formatter: function(value,row,index){	
					if(value !=null || value !=undefined){
						return formatString('<a id="btn" style="text-decoration:underline;color:#f00" onclick="showInfo(\'{0}\');">'+value+'</a>', row.id);				
		       		}else{
		       			value="无";
		       			return value;
		       		}
		        }, 
			    styler: function(value,row,index){
					if (value ==null){
						return 'color:#ccc';
					}else{
						return 'color:red';
					}
				}  
			},{
				title : '店铺地址',
				field : 'address',
				width : 150,
				align :'center',
				formatter: function(value,row,index){	
					if(value ==null || value ==undefined){
						value="无";
		       		}
		       		return value;
		        }, 
			    styler: function(value,row,index){
					if (value ==null){
						return 'color:#ccc';
					}
				}  
			}/* {
				title : '店铺正面图片',
				field : 'zhengmian',
				width : 150,
				align :'center',
				formatter: function(value,row,index){				
					if(value!=null&&value!=''){
						return formatString('<img width="60px" height="40px" src="{0}"/>', value);
					}else{
						value="无";
						return value;
					}	
		        },
		        styler: function(value,row,index){
					if (value ==null){
						return 'color:#ccc';
					}
				}
 			}, */,{
				title : '收货人',
				field : 'tname',
				width : 150,
				align :'center'
			},{
				title : '店主姓名',
				field : 'shopkeeperName',
				width : 150,
				align :'center',
				formatter: function(value,row,index){	
					if(value ==null || value ==undefined){
		       			value="无";
		       		}
		       		return value;
		        }, 
			    styler: function(value,row,index){
					if (value ==null){
						return 'color:#ccc';
					}
				}  
			},{
				title : '店主生日',
				field : 'shopkeeperBirth',
				width : 150,
				align :'center',
				sortable :true,
				formatter: function(value,row,index){	
					if(value ==null || value ==undefined){
		       			value="----";
		       		}else{
		       			value=value.substring(0, 10);
		       		}
		       		return value;
		        }, 
			    styler: function(value,row,index){
					if (value ==null){
						return 'color:#ccc';
					}
				}  
			},{
				title : '店庆日期',
				field : 'anniversaryBirth',
				width : 150,
				align :'center',
				sortable :true,
				formatter: function(value,row,index){	
					if(value ==null || value ==undefined){
		       			value="----";
		       		}else{
		       			value=value.substring(0, 10);
		       		}
		       		return value;
		        }, 
			    styler: function(value,row,index){
					if (value ==null){
						return 'color:#ccc';
					}
				}  
			},{
				title : '操作人',
				field : 'aname',
				width : 150,
				align :'center'
			},{
				title : '三个月之内的采购次数',
				field : 'oid',
				width : 150,
				align :'center',
				sortable :true,
				formatter: function(value,row,index){	
					if(value ==null || value ==undefined){
		       			value="0";
		       		}
		       		return value;
		        }, 
			    styler: function(value,row,index){
					if (value ==null){
						return 'color:#ccc';
					}
				}  
			},{
				title : '三个月之内的采购台数',
				field : 'nums',
				width : 150,
				align :'center',
				sortable :true,
				formatter: function(value,row,index){	
					if(value ==null || value ==undefined){
		       			value="0";
		       		}
		       		return value;
		        }, 
			    styler: function(value,row,index){
					if (value ==null){
						return 'color:#ccc';
					}
				}  
			},{
				title : '三个月之内的交易金额',
				field : 'totalCost',
				width : 150,
				align :'center',
				sortable :true,
				formatter: function(value,row,index){	
					if(value ==null || value ==undefined){
		       			value="0";
		       		}
		       		return value;
		        }, 
			    styler: function(value,row,index){
					if (value ==null){
						return 'color:#ccc';
					}
				}  
			},{
				title : '操作',
				field : 'action',
				width : 150,
				align :'center',
				formatter: function(value,row,index){		
					return formatString('<img onclick="admin_apps_edit(\'{0}\');" src="{1}"/>',row.id,'style/images/pencil.png');											 
		        }			
			}
							
			] ],
			toolbar : [],
		});
	});
	/**
	 * 查看详情
	 */
  	showInfo = function(id) {
 		admin_apps_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
 		var subtitle="查看详细信息";
 		var url="apps/appsAction!toShowInfo.action?id="+id;
 		$('#admin_apps_showForm').form('load', {});
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
	 * 修改商家信息
	 */
	admin_apps_edit = function(id){
		admin_apps_datagrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		var subtitle="修改商家信息";
		var url="apps/appsAction!toUpdate.action?id="+id;console.info("id======"+id);
		var icon="icon icon-magic";
		$("#admin_apps_editForm").form('load',{});
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
	 * 检索
	 */	
	function admin_app_search(){
		admin_apps_datagrid.datagrid('load',sy.serializeObject(admin_apps_searchForm));	
	}
	
	/**
	 * 清空条件
	 */
	function admin_app_clean(){
		$('#admin_apps_searchForm input').val('');
		admin_apps_datagrid.datagrid('load', {});	
	}
	
</script>
<div class="easyui-layout" data-options="border:false,fit:true">
	<div data-options="region:'north',border:false,split:false" style="height: 66px;overflow: hidden;">
		<div class="easyui-panel" data-options="border:false">
		<form class="easyui-form" id="admin_apps_searchForm">
			<table class="tableForm datagrid-toolbar" style="width:100%;height: 100%">
				<tr>
					<th>店铺名称:</th>
					<td><input name="shopName" placeholder="请输入店铺名称"/></td>
					<th>店主姓名:</th>
					<td><input name="shopkeeperName" placeholder="请输入店主姓名"/></td>
					<th>收货人:</th>
					<td><input name="tname" placeholder="请输入收货人姓名"/></td>
					<th>操作人:</th>
					<td><input name="aname" placeholder="请输入操作人姓名"/></td>	
				</tr>				
				<tr>	
					<th>店主生日(起):</th>
					<td><input id="admin_starttime" name="_startTime"  class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_endtime\')}'" /></td>
					<th>店主生日(至):</th>
					<td><input id="admin_endtime" name="_endTime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_starttime\')}'" /></td>
					<th>店庆时间(起):</th>
					<td><input id="admin_oneStartTime" name="_oneStartTime"  class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_oneEndTime\')}'" /></td>
					<th>店庆时间(至):</th>
					<td><input id="admin_oneEndTime" name="_oneEndTime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_oneStartTime\')}'" /></td>
					<th>操作:</th>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="admin_app_search();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="admin_app_clean();">清空条件</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false">
	   <table id="admin_apps_datagrid"></table>
	</div>
</div>