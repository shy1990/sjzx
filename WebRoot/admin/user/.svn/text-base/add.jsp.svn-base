<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%
String basePath = PathUtil.getPath(request);
%>
<script type="text/javascript">
$(function(){  
         $.extend($.fn.validatebox.defaults.rules,{
		    mobilePhone: {//value值为文本框中的值
		        validator: function (value) {
		           var reg = /^1[3|4|5|7|8|9]\d{9}$/;
		            return reg.test(value);
		        },
		         message:'手机号码格式不正确'  
		    }
		});
       }) ; 
</script>
<script type="text/javascript">
	$(function() {
		$('#admin_role_combobox').combogrid({
			url : 'role/roleAction!gainRoleListForCombobox.action',
			panelWidth : 450,
			panelHeight : 200,
			required: true,
			idField : 'roleId',
			textField : 'name',
			nowrap : false,
			fitColumns : true,
			editable : false,
			rownumbers : true,
			mode : 'remote',
			delay : 500,
			pagination : true,
			pageSize : 5,
			pageList : [ 5,10,15,20 ],
			columns : [ [ {
				field : 'roleId',
				title : '编号',
				width : 150,
				hidden : true
			}, {
				field : 'name',
				title : '角色名称',
				width : 150
			}, {
				title : '可访问权限',
				field : 'str',
				width : 300
			} ] ]
		});
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
				var admin_user_add_thumbPic =document.getElementById('admin_user_add_thumbPic');
				var thumb = thumbPaths.join(",").split(",");
				document.getElementById('button').style.paddingTop="18px";
				for ( var i = 0; i < thumb.length; i++) {
				document.getElementById('admin_user_add_picHidden').value = thumb[0];
					var img=document.createElement("img");  
					img.setAttribute("id",sy.UUID()); 
					img.setAttribute('src',thumb[i]);
					img.style.height='40px';
					img.style.width='140px';
					img.style.marginTop='10px';
					img.style.display="inline";
					img.ondblclick= function(){
						user_add_dropDom(this);
					
					};
					admin_user_add_thumbPic.appendChild(img);
				} ;
			};
		});
	}
		
	function user_add_dropDom(obj){
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
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
		<form id="admin_addForm" method="post">
			<table class="tableForm" style="margin-left: 85px;margin-top: 15px">
				<tr>
					<th>登录名称：</th>
					<td colspan="3"><input name="username" class="easyui-validatebox"
						data-options="required:true" style="width:200px" placeholder="请输入登录名称"/></td>
				</tr>
				<tr>
					<th>登录密码：</th>
					<td colspan="3"><input type="password" name="password" class="easyui-validatebox"
						data-options="required:true" style="width:200px" placeholder="请输入登录密码"/></td>
				</tr>
				<tr>
					<th>业务ID：</th>
					<td><input name="ywId" class="easyui-validatebox" style="width:200px" placeholder="请输入业务Id"/></td>
				</tr>
				<tr>
					<th>真实姓名：</th>
					<td><input name="truename" class="easyui-validatebox" style="width:200px" placeholder="请输入真实姓名"/></td>
				</tr>
				<tr>
					<th>工号：</th>
					<td><input name="userNum" class="easyui-validatebox" style="width:200px" placeholder="请输入工号"/></td>
				</tr>
				<tr>
					<th>手机号码：</th>
					<td><input name="mobilephone" class="easyui-validatebox"
						data-options="validType:'mobilePhone'" style="width:200px" placeholder="请输入手机号码"/></td>
				</tr>
				<tr>
					<th>固定电话：</th>
					<td><input name="telephone"
						class="easyui-validatebox" style="width:200px" placeholder="请输入固定电话"/></td>
				</tr>
				<tr>
					<th>邮箱：</th>
					<td colspan="3"><input name="email"
						class="easyui-validatebox" data-options="validType:'email'"
						style="width:200px" placeholder="请输入邮箱"/></td>
				</tr>
				<tr>
					<th>联系地址：</th>
					<td colspan="3"><input name="address"
						class="easyui-validatebox" style="width:200px" placeholder="请输入联系地址"/></td>
				</tr>
				<tr>
					<th>选择角色：</th>
					<td><input id="admin_role_combobox" name="roleId" style="width:205px;"/></td>
				</tr>
				<tr>
					<th>员工照片</th>
					<td>
					   <span id="button">
						<a class="easyui-linkbutton" href="javascript:makerUploadForAdd(false,'admin_user_add_thumbPic')">选择图片</a>
						<input type="hidden" id="admin_user_add_picHidden" name="userUrl">
					   </span>
					</td>
				</tr>
				<tr>
					
					<td colspan="2">
						<span id="admin_user_add_thumbPic" ></span>
					</td>
				</tr>
			
			</table>
		</form>
	</div>
</div>
