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
				var admin_cat_upload_add_thumbPic =document.getElementById('admin_cat_upload_add_thumbPic');
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
						cat_add_dropDom(this);
					};
					admin_cat_upload_add_thumbPic.appendChild(img);
				} ;
			};
		});
	}
	
</script>
<div align="center">
	<form id="admin_cat_addForm" method="post">
		<table  id="admin_cat_datagrid" class="tableForm" style="margin-left: 40px;margin-top: 15px">
			<tr>
				<th>名称：</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:true" style="width:230px" placeholder="请输入名称"/>
				</td>
			</tr>
			<tr>
				<th>图片路径：</th>
				<td>
				<a class="easyui-linkbutton" href="javascript:makerUploadForAdd(false)">选择图片</a>
				<input type="hidden" id="url" name="pic"/>
				&nbsp;&nbsp;&nbsp;<span id="admin_cat_upload_add_thumbPic"></span>
				</td>
			</tr>
			<tr>
				<th>是否可用：</th>
				<td colspan="3">
					<select class="easyui-combobox" name="disabled" style="width:140px">
						<option value='false' selected="selected">可用</option>
						<option value='true'>不可用</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>备注：</th>
				<td><input name="remark" class="easyui-validatebox" data-options="required:true" style="width: 230px" placeholder="请输入app备注"/></td>
			</tr>	
		</table>
	</form>
</div>