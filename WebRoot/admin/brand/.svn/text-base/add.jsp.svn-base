<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
			title : "上传图片",
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
				var thumbPaths = fw.thumbPaths;
				$(this).window('destroy');
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
		UploaderForAdd(chunk, function(files, thumbPaths) {
			if (files && files.length > 0) {
				var admin_brand_upload_add_thumbPic =document.getElementById('admin_brand_upload_add_thumbPic');
				var thumb = thumbPaths.join(",").split(",");
				for ( var i = 0; i < thumb.length; i++) {
					var img=document.createElement("img");
					document.getElementById('url').value=thumb[0];
					img.setAttribute("id",sy.UUID()); 
					img.setAttribute('src',thumb[i]);
					img.style.height='41px';
					img.style.width='55px';
					img.style.marginRight='10px';
					img.style.display="inline";
					img.ondblclick= function(){
						brand_add_dropDom(this);
					};
					admin_brand_upload_add_thumbPic.appendChild(img);
				} ;
			};
		});
	}
	
</script>
<div align="center">
	<form id="brand_addForm" method="post">
		<table class="tableForm" style="margin-left: 10px;margin-top: 15px">
			<tr>
				<th>品牌名称：</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:true" style="width:230px" placeholder="请输入品牌名称"/>
				</td>
			</tr>
			<tr>
				<th>品牌图片路径：</th>
				<td>
				<a class="easyui-linkbutton" href="javascript:makerUploadForAdd(false)">选择图片</a>
				<input type="hidden" id="url" name="pic"/>
				&nbsp;&nbsp;&nbsp;<span id="admin_brand_upload_add_thumbPic"></span>
				</td>
			</tr>
			<tr>
				<th>父类路径：</th>
				<td><input id="b_pid" name="pid" value="${pid}" class="easyui-combotree" data-options="url:'brand/brandAction!gainBrandTreeList.action?mark='+3,parentField : 'pid',textFiled:'name',required:true,lines : true" style="width:235px;" />
				<img src="style/images/cut_red.png" onclick="$('#b_pid').combotree('clear');" />
				</td>
			</tr>
			<tr>
				<th>排序：</th>
				<td><input name="p_order" class="easyui-numberbox" data-options="required:true" style="width: 230px" placeholder="请输入排序数字"/><span style="color:#F00">&nbsp;&nbsp;只能输入数字</span></td>
			</tr>
			
			<tr>
				<th>备注：</th>
				<td><input name="remark" class="easyui-validatebox" data-options="required:true" style="width: 230px" placeholder="请输入备注"/></td>
			</tr>						
		</table>
	</form>
</div>