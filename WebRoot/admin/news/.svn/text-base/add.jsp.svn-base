<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script>
	$(function() {
		
		window.setTimeout(function() {
			editor = KindEditor.create('#admin_news_add_textarea', {
				width : '680px',
				height : '300px',
				items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak', 'anchor', 'link', 'unlink' ],
				uploadJson : 'up!upload.action'
			});
		}, 1);
		
		$('#admin_news_add_view').bind('click',function(){
			editor.sync();
			var width=screen.width;
			var height=screen.height;
			var obj=sy.serializeObject($('#admin_news_add_addForm'));
			
			window.showModalDialog("<%=basePath%>admin/news/view.jsp",obj,"dialogWidth='+width+';center:yes;resizable:1");
		});
		
		
		
		$('#admin_news_add_save').bind('click',function(){
			$('#admin_news_add_addForm').form( 'submit',{
								url : 'news!addNews.action',
								onSubmit : function() {
									editor.sync();
									var isValid = $('#admin_news_add_addForm').form('validate');
									if (!isValid) {
									}
									return isValid;
								},success : function(json) {
									try {
										j = $.parseJSON(json);
									} catch (e) {
										$.messager.alert('Warning','脚本错误,请重试!');
									}
									if (j.success) {
										$.messager.progress('close');
										$('#news_list_datagrid') .datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
										var subtitle = "文章列表";
										var url = "news!toList.action";
										var icon = "icon icon-em_list";
										if (!$('#tabs').tabs( 'exists', subtitle)) {
											$('#tabs').tabs('add',{
																title : subtitle,
																href : url,
																closable : true,
																icon : icon
															});
										} else {
											$('#tabs').tabs(
													'select',
													subtitle);
											//$('#refresh').click();//要不要刷新整个页面
											$('#news_list_datagrid').datagrid('load',{});
										}
										tabClose();
										$('#tabs').tabs('close','文章添加');
									} else {
										$.messager.alert('错误',j.msg,'error');
									}
								}
				});
		});
	});
	function news_add_dropDom(obj){
		if(window.confirm("确定要删除该上传的图片?")){
			$.ajax({
				url : "goods!dropImg.action",
				type : "POST",
				dataType : "JSON",
				data : "src="+obj.src+"&goodsId=add",
				success : function(j) {
					if(j){
						alert("删除成功");
						$("#"+obj.id).remove();
					}else{
						alert("删除失败");
						return ;
					}
				}
			});				
		}
	}
</script>
<style>
.addNews {
	padding-left: 180px;
	padding-top: 20px;
	padding-bottom: 200px;
}
.newsTable{
	border-collapse: collapse;
	
}
.newsTable th{
	text-align: right;
	padding: 10px;
	width:60px;
	float: left;
}
</style>
<div class="addNews">
	<form method="post" id="admin_news_add_addForm" enctype="multipart/form-data">
		<table class=newsTable>
			<tr>
				<th>文章标题</th>
				<td><input type=text class=easyui-validatebox name="firstTitle"
					data-options='required:true' style="width:250px;" placeholder="请填写文章标题"/>
				</td>
			</tr>
			<tr>
				<th>文章摘要</th>
				<td>
					<textarea name='secondTitle'  style="width:300px;height:80px;" class="easyui-validatebox" data-options="required:true"></textarea>
				</td>
			</tr>
			<tr>
				<th>标题图片</th>
				<td><input type="file" name="myFile" />
				</td>
			</tr>
			<tr>
				<th>文章分类</th>
				<td><strong>一级</strong><input class="easyui-combobox" data-options="url:'newsCat!gainFirstNewsCat.action',valueField:'id',textField: 'name',editable:false,onChange:function(newValue, oldValue){
				           $('#admin_news_add_secondCat').combobox('clear').combobox('reload','newsCat!gainSecondNewsCat.action?id='+newValue);
				        }" >&nbsp
					<strong>二级</strong> <input class="easyui-combobox" name="newsCatId" id="admin_news_add_secondCat" data-options="valueField:'id',required:true,textField: 'name',editable:false,onLoadSuccess:function(){
						var target = $(this);
						var data = target.combobox('getData');
						var options = target.combobox('options');
						if(data && data.length>0){
							var fs = data[0];
							target.combobox('setValue',fs[options.valueField]);
						}
					}" ><a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增分类</a>					
				</td>
			</tr>
			<tr>
				<th>文章属性</th>
				<td>
					<input type="radio"  name="newsattr" value="普通" checked="checked"/>普通
					<input type="radio"  name="newsattr" value="重点"/>重点
					<input type="radio"  name="newsattr" value="推荐"/>推荐
					<input type="radio"  name="newsattr" value="顶置"/>顶置
					<input type="radio"  name="newsattr" value="焦点"/>焦点
				</td>
			</tr>
			<tr>
				<th>首页显示</th>
				<td>
					<input type="radio"  name="kz1" value="false" checked="checked"/>否
					<input type="radio"  name="kz1" value="true" />是
				</td>
			</tr>
			<tr>
				<th>文章来源</th>
				<td>
					<input type="text" class="easyui-validatebox" name="resources" placeholder="请输入文章来源" data-options="required:true"/>
				</td>
			</tr>
			<tr>
				<th>文章作者</th>
				<td><input type="text" class="easyui-validatebox" name="author" placeholder="请填写文章作者" />
				</td>
			</tr>
			<tr>
				<th>文章内容</th>
				<td><textarea name='content' id="admin_news_add_textarea"
						style="width:800px;height:500px;"></textarea>
				</td>
			</tr>
			<tr>
				<th>关键词</th>
				<td><input type="text" class="easyui-validatebox" name="keywords" />&nbsp 建议使用'，'分隔
				</td>
			</tr>
			<tr>
				<th>网页描述</th>
				<td><textarea style="width:400px;height:100px;resize:none" name="description" ></textarea>
				</td>
			</tr>
			<tr>
				<th>外部链接</th>
				<td><input type="text" class="easyui-validatebox" placeholder="http://"/>
				</td>
			</tr>
			<tr>
				<th>发布时间</th>
				<td><input type="text" class="easyui-my97" name="createtime" value="${currentTime }"/>
				</td>
			</tr>
		</table>
		<div style="float: right;margin-right:30%;">
			<input type="button" value="预览" id="admin_news_add_view"/>
			<input type="button" value="保存" id="admin_news_add_save"/>
		</div>
	</form>
</div>
