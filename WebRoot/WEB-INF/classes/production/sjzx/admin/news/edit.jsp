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
		/**
			商品详情的在线编辑
		 */
			window.setTimeout(function() {
				editor = KindEditor.create('#admin_news_edit_textarea', {
					width : '680px',
					height : '300px',
					items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak', 'anchor', 'link', 'unlink' ],
					uploadJson : 'up!upload.action'
				});
			}, 1);
		
		
			$('#admin_news_edit_view').bind('click',function(){
				editor.sync();
				var obj=sy.serializeObject($('#admin_news_edit_editForm'));
				window.showModalDialog("<%=basePath%>admin/news/view.jsp",obj,"dialogWidth=1080px;center:yes;resizable:1");
			});
			
			
		
		$('#admin_news_edit_save').bind('click',function(){
			$('#admin_news_edit_editForm').form( 'submit',{
								url : 'news!updateNews.action',
								onSubmit : function() {
									editor.sync();
									var isValid = $('#admin_news_edit_editForm').form('validate');
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
										$('#tabs').tabs('close','文章编辑');
									} else {
										$.messager.alert('错误',j.msg,'error');
									}
								}
				});
		});
	});
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
}
</style>
<div class="addNews">
	<form method="post" id="admin_news_edit_editForm"  enctype="multipart/form-data">
		<input type="hidden" name="id" value="${news.id }" />
		<table class=newsTable>
			<tr>
				<th>文章标题</th>
				<td><input type=text class=easyui-validatebox name="firstTitle"
					data-options='required:true' style="width:250px;" placeholder="请填写文章标题" value="${news.firstTitle }"/>
				</td>
			</tr>
			<tr>
				<th>文章摘要</th>
				<td><textarea name='secondTitle'  style="width:300px;height:80px;" class="easyui-validatebox" data-options="required:true">${news.secondTitle }</textarea>
				</td>
			</tr>
			<tr>
				<th>标题图片</th>
				<td><input type="file" name="myFile" /><span style="color: red">重新上传图片会覆盖原来图片!</span>
				</td>
			</tr>
			<tr>
				<th>&nbsp</th>
				<td><img  src="${news.newsPic }" height="50px" width="60px"> <input type="hidden" value="${news.newsPic }" name="newsPic" />
				</td>
			</tr>
			<tr>
				<th>文章分类</th>
				<td><strong>一级</strong><input class="easyui-combobox" value="${news.newsCatPid }" data-options="url:'newsCat!gainFirstNewsCat.action',valueField:'id',textField: 'name',editable:false,onChange:function(newValue, oldValue){
				            $('#admin_news_edit_secondCat').combobox('clear').combobox('reload','newsCat!gainSecondNewsCat.action?id='+newValue);
				        }" >&nbsp
					<strong>二级</strong> <input class="easyui-combobox" name="newsCatId" id="admin_news_edit_secondCat" value="${news.newsCatId }" data-options="url:'newsCat!gainSecondNewsCat.action?id=${news.newsCatPid }',valueField:'id',textField: 'name',editable:false" ><a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增分类</a>					
				</td>
			</tr>
			<tr>
				<th>文章属性</th>
				<td>
					<input type="radio"  name="newsattr" value="普通" <s:if test="%{news.newsattr=='普通'}">checked="checked"</s:if>/>普通
					<input type="radio"  name="newsattr" value="重点" <s:if test="%{news.newsattr=='重点'}">checked="checked"</s:if>/>重点
					<input type="radio"  name="newsattr" value="推荐" <s:if test="%{news.newsattr=='推荐'}">checked="checked"</s:if>/>推荐
					<input type="radio"  name="newsattr" value="顶置" <s:if test="%{news.newsattr=='顶置'}">checked="checked"</s:if>/>顶置
					<input type="radio"  name="newsattr" value="焦点" <s:if test="%{news.newsattr=='焦点'}">checked="checked"</s:if>/>焦点
				</td>
			</tr>
			<tr>
				<th>首页显示</th>
				<td>
					<input type="radio"  name="kz1" value="false" <s:if test="%{news.kz1=='false'}">checked="checked"</s:if>/>否
					<input type="radio"  name="kz1" value="true" <s:if test="%{news.kz1=='true'}">checked="checked"</s:if>/>是
				</td>
			</tr>
			<tr>
				<th>文章来源</th>
				<td>
					<input type="text" class="easyui-validatebox" name="resources"  value="${news.resources }" placeholder="请输入自定义来源" data-options="required:true"/>
				</td>
			</tr>
			<tr>
				<th>文章作者</th>
				<td><input type="text" class="easyui-validatebox" name="author" value="${news.author }" placeholder="请填写文章作者" />
				</td>
			</tr>
			<tr>
				<th>文章内容</th>
				<td><textarea name='content' id="admin_news_edit_textarea"
						style="width:800px;height:500px;">${news.content }</textarea>
				</td>
			</tr>
			<tr>
				<th>关键词</th>
				<td><input type="text" class="easyui-validatebox" name="keywords" value="${news.keywords }" />
				</td>
			</tr>
			<tr>
				<th>网页描述</th>
				<td><textarea style="width:400px;height:100px;resize:none" name="description" >${news.description }</textarea>
				</td>
			</tr>
			<tr>
				<th>外部链接</th>
				<td><input type="text" class="easyui-validatebox" placeholder="http://"/>
				</td>
			</tr>
			<tr>
				<th>发布时间</th>
				<td><input type="text" class="easyui-my97" name="createtime" value="<s:date name='news.createtime' format='yyyy-MM-dd HH:mm:ss'/>"/>
				</td>
			</tr>
		</table>
		<input type="button" value="预览" id="admin_news_edit_view"/>
		<input type="button" value="保存" id="admin_news_edit_save"/>
	</form>
</div>
