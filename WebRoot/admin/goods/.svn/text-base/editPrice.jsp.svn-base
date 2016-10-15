<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sanji.sjzx.common.util.ResourceUtil"%>
<%@page import="com.sanji.sjzx.pojo.SessionInfo"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String basePath = PathUtil.getPath(request);
	SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ResourceUtil.getSessionInfoName());
	String userId = sessionInfo.getUserId();
	request.setAttribute("goParam","${goParam}");
%> 
 <script type="text/javascript" src="js/editPrice.js"></script>
 	
	
	<div class="easyui-layout" style="width:100%;height:100%;">
		<div region="west" split="true" title="Navigator" style="width:150px;">
			<ul id="treeDemo" class="ztree"></ul><input id= "skuId" type="hidden" value="${skuId}">
		</div>
		 <div id="mainPanle" data-options="region:'center',border:false" title="" style="background: #eee; overflow-y:hidden">
         <div id="priceTabs" class="easyui-tabs" data-options="fit:true,border:false">
			<!-- <div title="欢迎使用" style="padding:20px;overflow:hidden; color:red;">
				本系统仅支持:IE8或以上,Chorme,火狐浏览器,如果您的浏览器版本过低,请升级您的浏览器以体验更流畅的效果,谢谢!
			</div> -->
		</div>
    </div>
		
	</div>
