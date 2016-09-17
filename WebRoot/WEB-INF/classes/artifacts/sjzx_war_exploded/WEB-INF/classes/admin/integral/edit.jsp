<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sanji.sjzx.common.util.ResourceUtil" %>
<%@page import="com.sanji.sjzx.pojo.SessionInfo" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String basePath = PathUtil.getPath(request);
SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute(ResourceUtil.getSessionInfoName());
String userId = sessionInfo.getUserId();
%>

<script type="text/javascript">
	var flag1 = true;
	var flag2 = true;
	var integralCode = $('#integralCode');
	var specCode = $('#specCode');
	
	$(function(){
		//校验商品代码是否存在
		integralCode.blur(function(){
		var id = $("#id").val();
			//取得文本框的值
	 		var integralCode = $(this).val();
	 		if(integralCode == null || integralCode ==""){
	 			$("#integralCodeMsg").text("");
	 			flag1 = false;
	 			return;
	 		}
	 		//发送异步请求
	 		$.ajax({
				url : "integral/integralAction!gainIntegralGoodsByIdandIntegralCode.action",
				type : "POST",
				dataType : "JSON",
				data : {"id":id,"integralCode":integralCode},
				success : function(j) {
					if(j.success){
						//如果返回值为true，则校验通过
	 					$("#integralCodeMsg").text("ok");
	 					$("#integralCodeMsg").css("color","#00f");
	 					flag1=true;
					}else{
	 					//如果返回值为false，则校验不通过
	 					$("#integralCodeMsg").text("此商品代码已存在");
	 					$("#integralCodeMsg").css("color","#f00");
	 					flag1 = false;
					}
				}
			});				
		});
		//校验规格代码是否存在
		specCode.blur(function(){
		var id = $("#id").val();
		//取得文本框的值
	 		var specCode = $(this).val();
	 		if(specCode == null || specCode ==""){
	 			$("#specCodeMsg").text("");
	 			flag2 = false;
	 			return;
	 		}
	 		//发送异步请求
	 		$.ajax({
				url : "integral/integralAction!gainIntegralGoodsByIdandSpecCode.action",
				type : "POST",
				dataType : "JSON",
				data : {"id":id,"specCode":specCode},
				success : function(j) {
					if(j.success){
						//如果返回值为true，则校验通过
	 					$("#specCodeMsg").text("ok");
	 					$("#specCodeMsg").css("color","#00f");
	 					flag2=true;
					}else{
	 					//如果返回值为false，则校验不通过
	 					$("#specCodeMsg").text("此规格代码已存在");
	 					$("#specCodeMsg").css("color","#f00");
	 					flag2 = false;
					}
				}
			});					
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
	 */
	function GetFrameWindowForAdd(frame) {
		return frame && typeof (frame) == 'object' && frame.tagName == 'IFRAME'
				&& frame.contentWindow;
	}
	/**
	 * 上传图片的函数
	 */
	function makerUploadForAdd(chunk) {
		UploaderForAdd(chunk, function(files, thumbPaths) {
			if (files && files.length > 0) {
				var admin_integral_edit_thumbPic =document.getElementById('admin_integral_edit_thumbPic');
				var imgNum = $(admin_integral_edit_thumbPic).find("img").length;
				var thumb = thumbPaths.join(",").split(",");
				if(imgNum>0){//存在已有图片
					alert("请删掉当前图片，再上传需要的图片");
				}else{
					if(thumb.length>1){
						alert("只能输入一张图片！");
						return;
					}else{
						for ( var i = 0; i < thumb.length; i++) {
							var img=document.createElement("img");
							img.setAttribute("id",sy.UUID()); 
							img.setAttribute('src',thumb[i]);
							img.style.height='41px';
							img.style.width='55px';
							img.style.marginRight='10px';
							img.style.display="inline";
							img.ondblclick= function(){
								integral_edit_dropDom(this);
							};
							admin_integral_edit_thumbPic.appendChild(img);
							var picSrc = [];
							var temp = $('#admin_integral_edit_thumbPic img');
							for ( var i = 0; i < temp.length; i++) {
								var e = temp[i];
								var s = e.src;
								picSrc.push(s);
							}
							var pic =$("#pic");
							$(pic).val(picSrc);
							
						} ;
				    }
			   }
			   
			};
		});
	}
	/**
	 * 双击图片可进行图片删除
	 */	
	function integral_edit_dropDom(obj){
		if(window.confirm("确定要删除该上传的图片?")){
			$("#"+obj.id).remove();
		}
	}
	/**
 	 * 分别校验 价格、库存、积分
 	 */
 	function validPrice(){
		var f = false;
		var price = $("#price").val();
	 		
	 	var reg = /^-?(0|[1-9]\d*)(\.\d{1,2})?$/;
		if (price == null || price == "" || price == undefined) {
			$("#priceMsg").text("请输入价格");
			$("#priceMsg").css("color", "#f00");
			return f;
		}
		
		if(!reg.test(price)){
			$("#priceMsg").text("请输入数字，最多保留两位小数");
			$("#priceMsg").css("color", "#f00");
			return f;
		}
		
		if(price<0){
			$("#priceMsg").text("请输入正数，最多保留两位小数");
			$("#priceMsg").css("color", "#f00");
			return f;
		}
		
		$("#priceMsg").text("ok");
		$("#priceMsg").css("color", "#00f");
		f = true;
		return f;
	}
	/**
 	 * 校验库存
 	 */ 
 	function validStock(){
 		var f = false;
 		var stock = $("#stock").val();
 		var reg=/^(0|[1-9][0-9]*)$/ ; 
 		if(stock == null || stock == "" || stock == undefined){
 			$("#stockMsg").text("库存不能为空");
 			$("#stockMsg").css("color","#f00");
 			f = false;
 		}else{
 			if(!reg.test(stock)){
 				$("#stockMsg").text("请输入正整数");
				$("#stockMsg").css("color","#f00");
				f=false;
				return f;
 			}else if(stock<0){
 				$("#stockMsg").text("请输入正整数");
				$("#stockMsg").css("color","#f00");
				f=false;
				return f;
 			}else{
 				$("#stockMsg").text("ok");
				$("#stockMsg").css("color","#00f");
				f = true;
				return f;
 			}
 		}
  		return f;
 	}
	/**
 	 * 校验积分
 	 */ 
 	function validIntegral(){
 		var f = false;
 		var integral = $("#integral").val();
 		var reg=/^(0|[1-9][0-9]*)$/ ; 
 		if(integral == null || integral == "" || integral == undefined){
 			$("#integralMsg").text("库存不能为空");
 			$("#integralMsg").css("color","#f00");
 			f = false;
 		}else{
 			if(!reg.test(integral)){
 				$("#integralMsg").text("请输入正整数");
				$("#integralMsg").css("color","#f00");
				f=false;
				return f;
 			}else if(integral<0){
 				$("#integralMsg").text("请输入正整数");
				$("#integralMsg").css("color","#f00");
				f=false;
				return f;
 			}else{
 				$("#integralMsg").text("ok");
				$("#integralMsg").css("color","#00f");
				f = true;
				return f;
 			}
 		}
  		return f;
 	}
 	//对价格、库存、积分总体控制
 	function validPreTable(){
 		if(validPrice()==false){
 			$("#price").focus();
 			return false;
		}
		if(validStock()==false){
			$("#stock").focus();
 			return false;
		}
		 if(validIntegral()==false){
		 	$("#integral").focus();
 			return false;
		}
 	}
 	/**
	  * 点击提交按钮时，判断某个积分商品的isshelves的值如果是true（即上架）,那么获取相应的单价
	  * 如果单价为0，则提示其单价应该大于0
	  */
	  function priceCall(){
	  	var isshelves = $("#isshelves").val();console.info("isshelves:"+isshelves);
	  	var priceObj = $("#price");
		var price = $(priceObj).val();console.info("price:"+price);
		var validMsg = $(priceObj).next();
	  	var priceFlag = false;
  		if(isshelves!=undefined && isshelves == "true"){
  			if(price!=undefined &&price!=null && price!='' && price==0){
  				$(validMsg).text("请修改上架单品单价大于0！");
  				$(validMsg).css("color", "#f00");
  				alert("请修改上架单品单价大于0！");
  				priceFlag = false;
  				return priceFlag;
  			}
  		 }
	  }
</script>
<div class="easyui-layout" data-options="fit:true,border:false" id="divObj">
	<div data-options="region:'center',border:true,split:false">
		<form id="admin_integral_editForm" method="post">
			<table  id="admin_integral_datagrid" class="tableForm" style="margin-left: 70px;margin-top: 15px">
				<tr>
					<th></th>
					<td><input type="hidden" id="id" name="id"/></td>
				</tr>
				<tr>	
					<th>积分商品名称：</th>
					<td><input id="name" name="name" class="easyui-validatebox" data-options="required:true" style="width:160px"/></td>
				</tr>
				<tr>	
					<th>商品代码：</th>
					<td>
					<input id="integralCode" name="integralCode" class="easyui-validatebox" data-options="required:true" style="width:160px"/>
					<span id="integralCodeMsg"></span>
					</td>
				</tr>
				<tr>	
					<th>规格代码：</th>
					<td>
					<input id="specCode" name="specCode" class="easyui-validatebox" data-options="required:true" style="width:160px"/>
					<span id="specCodeMsg"></span>
					</td>
				</tr>
				<tr>	
					<th>价格：</th>
					<td><input id="price" name="price" style="width:160px" class="easyui-validatebox" data-options="required:true" onblur="validPrice();"/><span id="priceMsg"></span></td>
				</tr>
				<tr>
					<th>换取所需积分：</th>
					<td><input id="integral" name="integral" style="width:160px" class="easyui-validatebox" data-options="required:true" onblur="validIntegral();"/><span id="integralMsg"></span></td>	
				</tr>	
				<tr>
					<th>库存：</th>
					<td><input id="stock" name="stock" style="width:160px" class="easyui-validatebox" data-options="required:true" onblur="validStock();"/><span id="stockMsg"></span></td>
				</tr>
				<tr>
					<th>是否上架：</th>
					<td>
						<select id="isshelves" name="isshelves">
						<s:if test="isshelves=='true'">
							<option value="true" selected="selected">上架</option>
						</s:if>
							<option value="false">下架</option>
						<s:if test="isshelves=='false'">
							<option value="false" selected="selected">下架</option>
						</s:if>
							<option value="true">上架</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>默认图片：</th>
					<td>
						<span>
							<a class="easyui-linkbutton" href="javascript:makerUploadForAdd(false)">选择图片</a>&nbsp;&nbsp;&nbsp;
							<label style="color: red">请上传236x175px规格的图片</label>
						</span>
						<span id="admin_integral_edit_thumbPic"></span>
						<input id ="pic" type="hidden" name="pic" />
					</td>
				</tr>
				<tr>
					<th>商品类型：</th>
					<td>
						<select name="type">
							<s:if test="type=='手机相关'">
								<option value="手机相关">手机相关</option>
							</s:if>
							<option value="生活用品">生活用品</option>
							<s:if test="type=='生活用品'">
								<option value="生活用品">生活用品</option>
							</s:if>
							<option value="手机相关">手机相关</option>
							<option value="店铺推广">店铺推广</option>
							<s:if test="type=='店铺推广'">
								<option value="店铺推广">店铺推广</option>
							</s:if>
						</select> 
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
