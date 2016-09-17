<%@page import="com.sanji.sjzx.common.util.PathUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String basePath = PathUtil.getPath(request);
%>
<script type="text/javascript" src="js/ddcolorposter.js"></script>
<script type="text/javascript">
	function color_select() {
		$('<div/>').dialog({
			href : 'color/colorAction!selectColor.action',
			top:410,
			left:1185,
			width : 410,
			height : 400,
			modal : true,
			title : '添加颜色',
			buttons : [ {
				text : '确定',
				iconCls : 'icon-add',
				handler : function() {
				var d = $(this).closest('.window-body');
				d.dialog('destroy');
				}
				
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	
</script>

 	<div align="center">
 	  <form id="color_addForm" name="color_Form" method="post">
 	     <table class="tableForm" style="margin-left: 10px;margin-top: 15px">
 	     	<tr>
 	     	  <th>颜色名称：</th>
 	     	  <td colspan="3"><input name="colorName" class="easyui-validatebox"
						data-options="required:true" style="width:230px" placeholder="请输入颜色名称"/>
 	     	    
 	     	  </td>
 	     	</tr>
 	        <tr>
 	     	  <th>颜色代码：</th>
 	     	  <td colspan="3"><input name="colorRgb" class="easyui-validatebox" 
 	     	     onclick="color_select();"	data-options="required:true" style="width:230px" placeholder="请输入颜色代码">
 	     	  </td>
 	     	</tr>
 	     		
 	     </table>
 	  </form>
 	</div>

