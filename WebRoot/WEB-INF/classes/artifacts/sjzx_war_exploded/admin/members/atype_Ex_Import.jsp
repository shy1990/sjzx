<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div>
	<form id="atype_Ex_import"  method="post"  enctype="multipart/form-data">
		地域类型表导入:<input type="file" name="myFile" id="myFile"/>
	</form>
</div>