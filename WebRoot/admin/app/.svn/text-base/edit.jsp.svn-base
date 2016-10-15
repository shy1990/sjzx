<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String basePath = PathUtil.getPath(request);
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
				var admin_app_upload_add_thumbPic =document.getElementById('admin_app_upload_add_thumbPic');
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
					admin_app_upload_add_thumbPic.appendChild(img);
				} ;
			};
		});
	}
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
		<form id="app_editForm" method="post">
			<input name="id" type="hidden" class="easyui-validatebox" 
			data-options="required:true" style="width:160px"/>
			<table class="tableForm" style="margin-left: 70px;margin-top: 15px">
				<tr>
					<th>app名称：</th>
					<td colspan="3"><input name="name" class="easyui-validatebox"
						data-options="required:true" style="width:160px"/></td>
				</tr>
				<tr>
					<th>app图片路径：</th>
					<td>
					<a class="easyui-linkbutton" href="javascript:makerUploadForAdd(false)">选择app图片</a>
					<input id="url" type="hidden" name="pic"/>
				&nbsp;&nbsp;&nbsp;<span id="admin_app_upload_add_thumbPic"></span>
					</td>
				</tr>
				<tr>
					<th>版本号：</th>
					<td><input name="verionNum" class="easyui-validatebox" data-options="required:true" style="width: 230px"/></td>
				</tr>						
				<tr>
					<th>下载路径：</th>
					<td><input name="url" class="easyui-validatebox" data-options="required:true" style="width: 230px"/></td>
				</tr>						
				<tr>
					<th>创建时间：</th>
					<td><input id="admin_starttime" name="createTime" class="easyui-my97" data-options="readOnly : true,maxDate:'#F{$dp.$D(\'admin_endtime\')}'" /></td>
				</tr>						
				<tr>
					<th>修改时间：</th>
					<td><input id="admin_endtime" name="modifyTime" class="easyui-my97" data-options="readOnly : true,minDate:'#F{$dp.$D(\'admin_starttime\')}'" /></td>
				</tr>									
				<tr>
					<th>备注：</th>
					<td><input name="remark" class="easyui-validatebox" data-options="required:true" style="width: 230px" placeholder="请输入app备注"/></td>
				</tr>	
				<tr>
					<th>包名：</th>
					<td><input name="packName" class="easyui-validatebox" data-options="required:true" style="width: 230px" placeholder="请输入包名"/></td>
				</tr>						
				<tr>
					<th>app类型：</th>
					<td colspan="3">
					<select class="easyui-combobox" name="type" style="width:140px">
						<s:if test="value=='0'">
							<option value='0' selected="selected">默认</option>
						</s:if>
						<s:if test="value=='1'">
							<option value='1' selected="selected">推荐功能</option>
						</s:if>
						<s:if test="value=='2'">
							<option value='2' selected="selected">本地应用</option>
						</s:if>
						<option value='0'>默认</option>
						<option value='1'>推荐功能</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>是否被卸载：</th>
					<td colspan="3">
						<select class="easyui-combobox" name="nuinstall" style="width:140px">
							<s:if test="nuinstall=='0'">
								<option value='0' selected="selected">未被卸载</option>
							</s:if>
							<option value='1'>已卸载</option>
							<s:if test="nuinstall=='1'">
								<option value='1' selected="selected">已卸载</option>
							</s:if>
							<option value='0'>未被卸载</option>		
						</select>
					</td>
			   </tr>					
			   <tr>
					<th>被点击次数：</th>
					<td><input name="opentime" class="easyui-validatebox" data-options="required:true" style="width: 230px" placeholder="请输入被点击次数"/></td>
			   </tr>			
			</table>
		</form>
	</div>
</div>
