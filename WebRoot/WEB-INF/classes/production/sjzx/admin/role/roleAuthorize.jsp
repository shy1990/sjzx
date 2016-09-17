<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
		var module_tree;
		var $$ = self.parent.$;
		var rid = '${rid}';
		$(function() {
			 module_tree = $('#module_tree').tree({
			 	  url:'module/moduleAction!gainModuleTree.action',
		    	  idFiled:'id',
		    	  textFiled:'name',
		    	  parentField:'pid',
		    	  checkbox:true,            
	              onLoadSuccess:function(){
	                  $.ajax({
	                     url:'role/roleAction!gainRoleModulesByRid.action?rid='+rid,
	                     cache:false,
	                     dataType:'text',
	                     success:function(data){ 
	                      	 var result = $.parseJSON(data);
	                      	 if(result!=null && result!=""){
	                         	var arr = result.split(',');
		                        for(var i=0;i<arr.length;i++)
		                        {
		                           var node = module_tree.tree('find',arr[i]);
		                           module_tree.tree('check',node.target);
		                        }	                      	 
	                      	 }
	                     }
	                  });
	              }
	          });
		});
		function getSelected(){
			var mids = [];
		    var node = $("#module_tree").tree('getChecked');
			for ( var i = 0; i < node.length; i++) {
				mids.push(node[i].id);
			}
			$('#role_module_addForm').form('submit', {   
			    url:'role/roleAction!addAuthorize.action?mids='+mids,   
				success : function(result) {
					var r = $.parseJSON(result);
					try {
						if (r.success) {
							if ($('#tabs').tabs('exists', '授权管理')) {
								$('#tabs').tabs('close','授权管理');
							}
							window.location.href="loginAction!doNotNeedSession_login.action";
						}
						$$.messager.show({
							title : '提示',
							msg : r.msg
						});
					} catch (e) {
						$$.messager.alert('提示', r.msg);
					}
				}   
			});		     
		 
		}
</script>
  <form id="role_module_addForm" method="post">
	<input name="rid" value="<s:property value='rid'/>" type="hidden"/>
	<ul id="module_tree" class="easyui-tree"></ul> 
	<a id="btn" href="javascript:getSelected();" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="float:right">保存</a> 
</form>
<!--<ul class="easyui-tree" id="module_tree">  
       <li>  
           <span checkbox="true">商品管理</span>  
           <ul>  
               <li><span>商品列表</span></li>  
               <li><span>添加商品</span></li>  
               <li><span>商品分类管理</span></li>  
           </ul>  
       </li>  
       <li>
	 	  <span>汽车品牌和配件管理</span>
	 	  <ul>
	 	       <li><span>汽车品牌管理</span></li>
	 	  </ul>
       </li>  
   </ul>-->  
