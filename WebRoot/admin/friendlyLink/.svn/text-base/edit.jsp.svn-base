<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
	<script type="text/javascript">
	
	
		
		
		
		/**
		 * 创建上传窗口 公共方法
		 * @param chunk 是否分割大文件
		 * @param callBack 上传成功之后的回调
		 */
		function UploaderForAdd(chunk, callBack) {
			var editWin = $('<div style="overflow: hidden;"/>');
			var upladoer = $('<iframe/>');
			upladoer.attr({
				'src' : 'imagesAction!toUpLoaderForAdd.action?chunk=' + chunk,
				width : '100%',
				height : '100%',
				frameborder : '0',
				scrolling : 'no'
			});
			editWin.window({
				title : "上传文件",
				height : 350,
				width : 550,
				minimizable : false,
				modal : true,
				collapsible : false,
				maximizable : false,
				resizable : false,
				content : upladoer,
				onClose : function() {
					var fw = GetFrameWindowForAdd(upladoer[0]);
					var files = fw.files;
					//var paths=fw.paths;
					var thumbPaths = fw.thumbPaths;
					//var standardPaths=fw.standardPaths;
					$(this).window('destroy');
					//callBack.call(this,files,paths,thumbPaths,standardPaths);
					callBack.call(this, files, thumbPaths);
				},
				onOpen : function() {
					var target = $(this);
					setTimeout(function() {
						var fw = GetFrameWindowForAdd(upladoer[0]);
						fw.target = target;
					}, 100);
				}
			});
		}
	
		/**
		 * 根据iframe对象获取iframe的window对象
		 * @param frame
		 * @returns {Boolean}
		 */
		function GetFrameWindowForAdd(frame) {
			return frame && typeof (frame) == 'object' && frame.tagName == 'IFRAME'
					&& frame.contentWindow;
		}
	
		function makerUploadForAdd(chunk) {
			//Uploader(chunk,function(files,paths,thumbPaths,standardPaths){
			UploaderForAdd(chunk, function(files, thumbPaths) {
				if (files && files.length > 0) {
					var admin_goods_add_thumbPic =document.getElementById('admin_upload_add_thumbPic');
					var thumb = thumbPaths.join(",").split(",");
					$("#img").remove();
					for ( var i = 0; i < thumb.length; i++) {
					document.getElementById('imgUrl').value = thumb[0];
						var img=document.createElement("img"); 
						img.setAttribute("id",sy.UUID()); 
						img.setAttribute('src',thumb[i]);
						img.style.height='40px';
						img.style.width='140px';
						img.style.marginTop='10px';
						img.style.display="inline";
						img.ondblclick= function(){
							goods_add_dropDom(this);
						
						};
						admin_goods_add_thumbPic.appendChild(img);
					} ;
				};
			});
		}
			
		function goods_add_dropDom(obj){
			if(window.confirm("确定要删除该上传的图片?")){
				$("#"+obj.id).remove();
				/*$.ajax({
					url : "goods!dropImg.action",
					type : "POST",
					dataType : "JSON",
					data : "src="+obj.src+"&goodsId=add",
					success : function(j) {
						if(j){
							alert("删除成功");
							
							
						}else{
							alert("删除失败");
							return ;
						}
					}
				});				
				*/
			}
			
		}
		
		$(function() {
	
			/**
				在线编辑
			 */
			window.setTimeout(function() {
				editor = KindEditor.create('#admin_upload_add_textarea', {
					width : '680px',
					height : '300px',
					items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak', 'anchor', 'link', 'unlink' ],
					uploadJson : 'up!upload.action'
				});
			}, 1);
			var img=document.createElement("img");
				img.setAttribute("id","img"); 
				img.setAttribute('src','${requestScope.imgUrl}');
				img.style.height='40px';
				img.style.width='140px';
				img.style.marginTop='10px';
				img.style.display="inline";
			document.getElementById('admin_upload_add_thumbPic').appendChild(img);
		});
		
		
		
	</script>

	<div align="center">
		<form id="friendlyLink_editForm" method="post" enctype="multipart/form-data" >
			<input name="id" readonly="readonly" type="hidden"/>
			<table class="tableForm" style="margin-left: 10px;margin-top: 15px;" >
				<tr>
					<th>友情链接公司名称：</th>
					<td colspan="3"><input id="name" name="name" class="easyui-validatebox"
						data-options="required:true" style="width:230px" placeholder="请输入友情链接公司链接"/></td>
				</tr>
				<tr>
 	     	  		<th>友情链接公司排序：</th>
			        <td><input name="orderlist" class="easyui-numberspinner"
						data-options="min:0,max:999,editable:false,required:true,missingMessage:'请选择菜单排序'"  size="43" />
			        </td>
 	     	   	</tr>
				<tr>
 	     	  		<th>友情链接公司链接：</th>
 	     	 		 <td colspan="3"><input name="href" class="easyui-validatebox" 
 	     	  			data-options="required:true" style="width:230px; height: 29px"  placeholder="请输入友情链接公司链接">
 	     			 </td>
 	     		</tr>
 	     		<tr>
 	     	  		<th >上传友情链接公司图片：</th>
 	     	 		<td colspan="3"><input type="hidden" id="imgUrl" name="imageUrl"  />
 	     	 		  
					 <div style="width:230px; height: 40px">
					 	<span style="padding-right: 5px;padding-top: 18px;float: left"><a class="easyui-linkbutton"
							href="javascript:makerUploadForAdd(false)">选择图片</a>
						</span>
						<span id="admin_upload_add_thumbPic" style="padding-bottom: 15px;float: right" ></span>
					 </div>
 	     	  		</td>
 	     		</tr>
 	     	   		
			</table>
		</form>
	</div>
