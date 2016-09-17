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
		
		
	});
	
	
	
	
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
				for ( var i = 0; i < thumb.length; i++) {
					var img=document.createElement("img");  
					img.setAttribute("id",sy.UUID()); 
					img.setAttribute('src',thumb[i]);
					img.style.height='41px';
					img.style.width='55px';
					img.style.marginRight='10px';
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
</script>
<div>
	<form id="admin_upload_add_addForm" method="post">		
		<div style="padding-left: 90px;padding-top: 10px;">
			<span style="font-weight: bold;">图片上传</span><span
				style="padding-left: 10px"><a class="easyui-linkbutton"
				href="javascript:makerUploadForAdd(false)">选择11图片</a>&nbsp;&nbsp;&nbsp;<label style="color: red">第一张图片作为页面默认图片</label>
			</span>
			<span id="admin_upload_add_thumbPic"></span>
		</div>
		<div style="padding-left: 90px;padding-top: 10px;">
			<div style="font-weight: bold;float:left">在线编辑器</div>
			<div style="margin-left:63px;">
			<textarea name='infomation'
					id="admin_upload_add_textarea" style="width:800px;height:290px;"></textarea>
			</div>
		</div>
	</form>
</div>