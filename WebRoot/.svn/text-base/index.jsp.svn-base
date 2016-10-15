<%@page import="com.sanji.sjzx.pojo.SessionInfo"%>
<%@page import="com.sanji.sjzx.common.util.ResourceUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SessionInfo sInfo = (SessionInfo)session.getAttribute(ResourceUtil.getSessionInfoName());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>三际在线后台管理</title>
<jsp:include page="init.jsp"></jsp:include>
<script>
//修改操作
	var pwd_datagrid;
	function password_edit() {
		pwd_datagrid = $('<div/>').dialog({
				href : 'admin/admin!toUpdatePassword.action',
				width : 500,
				height : 380,
				modal : true,
				title : '修改密码',
				buttons : [ {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						$('#pwd_editForm').form('submit', {
							url : 'admin/admin!updatepwd.action',
							success : function(result) {
								var r = $.parseJSON(result);
								try {
									if (r.success) {
										pwd_datagrid.dialog('close');
										$.messager.show({
											title : '提示',
											msg : r.msg
										});
									}else{
										$.messager.alert('提示', r.msg);
									}
								} catch (e) {
									$.messager.alert('提示', r.msg);
								}
							}
						});
					}
				} ],
				onClose : function() {
					$(this).dialog('destroy');
				},
				
			});		
	}
	function showUserInfo(id) {
		$('<div/>').dialog({
			href : 'admin/admin!toShowUser.action?id='+id,
			width : 500,
			height : 380,
			modal : true,
			title : '个人信息',
			onClose : function() {
				$(this).dialog('destroy');
			}
		});				
	}
	function logout(b) {
		
	}
</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden" data-options="fit:true"  scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div></noscript>

<div id="loading-mask" style="position:absolute;top:0px; left:0px; width:100%; height:100%; background:#D2E0F2; z-index:20000">
<div id="pageloading" style="position:absolute; top:50%; left:50%; margin:-120px 0px 0px -120px; text-align:center;  border:2px solid #8DB2E3; width:200px; height:40px;  font-size:14px;padding:10px; font-weight:bold; background:#fff; color:#15428B;"> 
    <img src="images/loading.gif" align="absmiddle" /> 正在加载中,请稍候...</div>
</div>
    <div data-options="region:'north',split:false,border:true" style="overflow: hidden; height: 60px;">
        <div id="sessionInfoDiv" style="position: absolute;right: 5px;top:10px;">
			[<strong>${sessionInfo.loginName}</strong>]，欢迎你！您使用[<strong>${sessionInfo.ip}</strong>]IP登录！
		</div>
		<div style="position: absolute; right: 0px; bottom: 0px; ">
<!-- 			<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'icon-ok'">更换皮肤</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_zxMenu',iconCls:'icon-back'">注销</a>
 -->		</div>
		<div id="layout_north_pfMenu" style="width: 120px; display: none;">
			<div onclick="sy.changeTheme('default');">default</div>
			<div onclick="sy.changeTheme('bootstrap');">bootstrap</div>
			<div onclick="sy.changeTheme('black');">black</div>
			<div onclick="sy.changeTheme('gray');">gray</div>
			<div onclick="sy.changeTheme('metro');">metro</div>
			<div onclick="sy.changeTheme('ui-cupertino');">ui-cupertino</div>
			<div onclick="sy.changeTheme('ui-dark-hive');">ui-dark-hive</div>
			<div onclick="sy.changeTheme('ui-pepper-grinder');">ui-pepper-grinder</div>
			<div onclick="sy.changeTheme('ui-sunny');">ui-sunny</div>
		</div>
		<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
			<div onclick="showUserInfo('${sessionInfo.userId}');">个人信息</div>
			<div onclick="password_edit();">密码修改</div>
			<div class="menu-sep"></div>
			<div>
				<span>更换主题</span>
				<div style="width: 120px;">
					<div onclick="sy.changeTheme('default');">default</div>
					<div onclick="sy.changeTheme('cupertino');">cupertino</div>
					<div onclick="sy.changeTheme('dark-hive');">dark-hive</div>
					<div onclick="sy.changeTheme('blue');">blue</div>
					<div onclick="sy.changeTheme('metro-blue');">metro-blue</div>
					<div onclick="sy.changeTheme('metro-gray');">metro-gray</div>
					<div onclick="sy.changeTheme('metro-green');">metro-green</div>
					<div onclick="sy.changeTheme('metro-orange');">metro-orange</div>
					<div onclick="sy.changeTheme('metro-red');">metro-red</div>
					<div onclick="sy.changeTheme('pepper-grinder');">pepper-grinder</div>
					<div onclick="sy.changeTheme('sunny');">sunny</div>
				</div>
			</div>
		</div>
		<div id="layout_north_zxMenu" style="width: 100px; display: none;">
			<div onclick="">锁定窗口</div>
			<div class="menu-sep"></div>
			<div onclick="logout();">重新登录</div>
			<div onclick="logout(true)">退出系统</div>
		</div>
    </div>
    <!--  导航内容 -->
    <div data-options="region:'west',split:true"  title="导航菜单" style="width:170px;" id="west">
			<div id="nav">
			</div>
    </div>
    <div id="mainPanle" data-options="region:'center',border:false" title="" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs" data-options="fit:true,border:false">
			<div title="欢迎使用" style="padding:20px;overflow:hidden; color:red;">
				本系统仅支持:IE8或以上,Chorme,火狐浏览器,如果您的浏览器版本过低,请升级您的浏览器以体验更流畅的效果,谢谢!
			</div>
		</div>
    </div>
    <div data-options="region:'south',split:false,border:true"  style="height: 25px;">
        <div class="footer">CopyRight© 2014 All rights reserved  版权所有山东三际电子商务有限公司</div>
    </div><%--
    <div data-options="region:'east',title:'日历'"  style="width: 182px;">
    	<div class="easyui-calendar" data-options="border:false"></div>
    </div>
	--%>
	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="refresh" data-options="iconCls:'icon-reload'">刷新</div>
		<div class="menu-sep"></div>
		<div id="close" data-options="iconCls:'icon-cancel'">关闭</div>
		<div id="closeall" data-options="iconCls:'icon-no'">全部关闭</div>
		<div id="closeother" data-options="iconCls:'icon-remove'">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="exit" data-options="iconCls:'icon-back'">退出</div>
	</div>
</body>
</html>