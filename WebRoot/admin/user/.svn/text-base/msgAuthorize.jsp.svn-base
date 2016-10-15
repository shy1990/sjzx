<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	var regions_tree;
	var $$ = self.parent.$;
	var aid = '${aid}';
	var infoType = '${infoType}';
	$(function() {
		regions_tree = $('#regions_tree').tree({
			url : 'region/regionAction!gainRegionByPid.action',
			idFiled : 'id',
			textFiled : 'name',
			parentField : 'pid',
			checkbox : true,
			/*  animate:true,
			 lines:true,
			 onClick:function(node){
			alert(node.text); 
			 	},  */
			onBeforeLoad : function(row, param) {
				if (row)
				$(this).treegrid('options').url = 'region/regionAction!gainRegionByPid.action?pid=row.id';
				},
			onLoadSuccess : function() {
				$.ajax({
					url : 'admin/adminAction!gainInfoMsgByuserId.action?aid='+ aid+'&infoType='+infoType,
					cache : false,
					dataType : 'text',
					success : function(data) {
					var result = $.parseJSON(data);
					if (result != null && result != "") {
						var arr = result.split(',');
						for ( var i = 0; i < arr.length; i++) {
							var node = regions_tree.tree('find',arr[i]);
							regions_tree.tree('check',node.target);
						}
					}
				}
			});
			}
		});
	});
	function getSelected() {
		var mids = [];
		var node = $("#regions_tree").tree('getChecked');
		for ( var i = 0; i < node.length; i++) {
			mids.push(node[i].id);
		}
		$.ajax({
					url : 'admin/adminAction!addMsgAuthorize.action',
					data : {
					        id : $("#id").val(),
							aid:aid,
							ids : mids.join(','),
							infoType:infoType
						},
					dataType : 'text',
					success : function(data) {
					var r = $.parseJSON(data);
				try {
					if (r.success) {
						if ($('#tabs').tabs('exists', '短信通知授权')) {
							$('#tabs').tabs('close', '短信通知授权');
						}
					//window.location.href = "loginAction!doNotNeedSession_login.action";
				}
				
			$$.messager.show({title : '提示',msg : r.msg});
		} catch (e) {
			$$.messager.alert('提示', r.msg);
		}
	}
			});
		
		
		
		/* $('#admin_msgAuthor_addForm').form('submit',{
			url : 'admin/adminAction!addMsgAuthorize.action?mids='+ mids+'&infoType='+infoType,
			 data:{
				mids:mids,
				infoType:infoType
			}, 
			error : function() {
					alert('访问服务器出错');
				},
			success : function(result) {
				var r = $.parseJSON(result);
				try {
					if (r.success) {
						if ($('#tabs').tabs('exists', '短信通知授权')) {
							$('#tabs').tabs('close', '短信通知授权');
						}
					//window.location.href = "loginAction!doNotNeedSession_login.action";
				}
				
			$$.messager.show({title : '提示',msg : r.msg});
		} catch (e) {
			$$.messager.alert('提示', r.msg);
		}
	}
}); */
         
	}
</script>
<form id="admin_msgAuthor_addForm" method="post">
	<input name="aid" value="<s:property value='aid'/>" type="hidden" />
	<ul id="regions_tree" ></ul>
	<a id="btn" href="javascript:getSelected();" class="easyui-linkbutton"
		data-options="iconCls:'icon-add'" style="float:right">保存</a>
</form>

