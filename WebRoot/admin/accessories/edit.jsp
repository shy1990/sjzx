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
var admin_acc_editForm = $('#admin_acc_editForm');
var admin_acc_edit_save = $('#admin_acc_edit_save');
var admin_acc_datagrid = $('#admin_acc_datagrid');
var flag1=true;
var flag2=true;
var flag3=true;
var accName = $('#accName');
var accNum = $('#accNum');
var specCode = $('#specCode');
var accId = $('#accId').val();

	 /**
	  * 校验价格、原价、天猫价
	  */
	function validPreTable()
 	{		
		var priceOb = $("#price");
		var originalPriceOb = $("#originalPrice");
		var tmallPriceOb = $("#tmallPrice");

		if (validPrice(priceOb,'单价') == false) {
			//alert("请输入单品单价！");
			$(priceOb).focus();
			return false;
		}

		if (validPrice(originalPriceOb,'原价') == false) {
			//alert("请输入单品原价！");	
			$(originalPriceOb).focus();
			return false;
		}

		if (validPrice(tmallPriceOb,'天猫价') == false) {
			//alert("请输入单品天猫价！");	
			$(tmallPriceOb).focus();
			return false;
		}
		return true;
 	}  
	/**
 	 * 分别校验
 	 */
 	function validPrice(obj,desc){

		var flag = false;
	 	var validMsg = $(obj).next();
	 	var objValue = $(obj).val();
	 		
	 	var reg = /^-?(0|[1-9]\d*)(\.\d{1,2})?$/;
		if (objValue == '') {
			$(validMsg).text("请输入价格"+desc);
			$(validMsg).css("color", "#f00");
			return flag;
		}
		
		if(!reg.test(objValue)){
			$(validMsg).text(desc+"请输入数字，最多保留两位小数");
			$(validMsg).css("color", "#f00");
			return flag;
		}
		
		if(objValue<0){
			$(validMsg).text(desc+"请输入正数，最多保留两位小数");
			$(validMsg).css("color", "#f00");
			return flag;
		}
		
		$(validMsg).text("ok");
		$(validMsg).css("color", "#00f");
		flag = true;
		return flag;
	}
	
	/**
 	 * 校验点库存
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
				return f;
 			}else if(stock<0){
 				$("#stockMsg").text("请输入正整数");
				$("#stockMsg").css("color","#f00");
				return f;
 			}else{
 				$("#stockMsg").text("ok");
				$("#stockMsg").css("color","#00f");
				f = true;
 			}
 		}
  		return f;
 	}
	/**
 	 * 校验点击量
 	 */ 
 	function validClickRate(){
 		var f = false;
 		var clickRate = $("#clickRate").val();
 		var reg=/^(0|[1-9][0-9]*)$/ ; 
 		if(clickRate !=null && clickRate!="" && clickRate!=undefined){
 			if(!reg.test(clickRate)){
 				$("#clickRateMsg").text("请输入正整数");
				$("#clickRateMsg").css("color","#f00");
				return f;
 			}
 			if(clickRate<0){
 				$("#clickRateMsg").text("请输入正整数");
				$("#clickRateMsg").css("color","#f00");
				return f;
 			}
		 	$("#clickRateMsg").text("ok");
			$("#clickRateMsg").css("color","#00f");
			f = true;
 		}else{
 			$("#clickRateMsg").text("");
 			f = true;
 		}
 		return f;
 	}	
$(function(){
	var admin_goods_edit_uninGoods_left = $('#admin_goods_edit_uninGoods_left');
	var admin_goods_edit_uninGoods_right = $('#admin_goods_edit_uninGoods_right');
	var admin_goods_edit_uninGoods_select = $('#admin_goods_edit_uninGoods_select');
	var admin_goods_edit_uninGoods_unselect = $('#admin_goods_edit_uninGoods_unselect');
	var admin_goods_edit_uninGoods_delSelect = $('#admin_goods_edit_uninGoods_delSelect');
	var admin_goods_edit_searchButton = $('#admin_goods_edit_searchButton');

	/**
	 *判断配件名称是否存在
	 */
 	 accName.blur(
	 	function(){
	 		//取得文本框的值
	 		var accName = $(this).val();
	 		if(accName == null || accName ==""){
	 			$("#accNameMsg").text("配件名称不能为空");
	 			$("#accNameMsg").css("color","#f00");
	 			$(accName).focus();
	 			flag1 = false;
	 			return;
	 		}else{
	 			$("#accNameMsg").text("");
	 			flag1 = true;
	 		}
	 		//发送异步请求给gainAccessoriesByIdandName 
/* 	 		$.ajax({
				url : "acc/accAction!gainAccessoriesByIdandName.action",
				type : "POST",
				dataType : "JSON",
				data : {"a.id":accId,"a.name":accName},
				success : function(j) {
					if(j.success){
						//如果返回值为true，则校验通过
	 					$("#accNameMsg").text("ok");
	 					$("#accNameMsg").css("color","#00f");
	 					flag1=true;
					}else{
	 					//如果返回值为false，则校验不通过
	 					$("#accNameMsg").text("此配件名称已存在");
	 					$("#accNameMsg").css("color","#f00");
	 					flag1 = false;
					}
				}
			});		 */		
	 	}
	 );  
	/**
	 *判断配件编号是否存在
	 */
	 accNum.blur(
	 	function(){
	 		//取得文本框的值
	 		var accNum = $(this).val();
	 		if(accNum == null || accNum ==""){
	 			$("#accNumMsg").text("商品代码不能为空");
	 			$("#accNumMsg").css("color","#f00");
	 			$(accNum).focus();
	 			flag2 = false;
	 			return;
	 		}else{
	 			$("#accNumMsg").text("");
	 			flag2 = true;
	 		}
	 		
	 		//发送异步请求给gainAccessoriesByIdandNum 
/* 	 		$.ajax({
				url : "acc/accAction!gainAccessoriesByIdandNum.action",
				type : "POST",
				dataType : "JSON",
				data : {"a.id":accId,"a.accessoriesNum":accNum},
				success : function(j) {
					if(j.success){
		 				if(accNum == null || accNum ==""){//配件编号为空
				 			$("#accNumMsg").text("");
				 			$("#accNumMsg").text("商品代码不能为空");
					 		$("#accNumMsg").css("color","#f00");
				 			flag2 = false;
	 					}else{//配件编号不为空
				 			//如果返回值为true，则校验通过
		 					$("#accNumMsg").text("ok");
		 					$("#accNumMsg").css("color","#00f");
		 					flag2=true;
	 					}
					}else{
	 					//如果返回值为false，则校验不通过
	 					$("#accNumMsg").text("此商品代码已存在");
	 					$("#accNumMsg").css("color","#f00");
	 					flag2 = false;
					}
				}
			});	 */
	 	}
	 );
	 
	/**
	 *判断规格代码是否存在
	 */
	 specCode.blur(
	 	function(){
	 		//取得文本框的值
	 		var specCode = $(this).val();
	 		//发送异步请求
	 		$.ajax({
				url : "acc/accAction!gainAccessoriesByIdandSpecCode.action",
				type : "POST",
				dataType : "JSON",
				data : {"a.id":accId,"a.specCode":specCode},
				success : function(j) {
					if(j.success){
		 				if(specCode == null || specCode ==""){//配件编号为空
				 			$("#specCodeMsg").text("规格代码不能为空");
					 		$("#specCodeMsg").css("color","#f00");
				 			flag3 = false;
	 					}else{//配件编号不为空
				 			//如果返回值为true，则校验通过
		 					$("#specCodeMsg").text("ok");
		 					$("#specCodeMsg").css("color","#00f");
		 					flag3=true;
	 					}
					}else{
	 					//如果返回值为false，则校验不通过
	 					$("#specCodeMsg").text("此规格代码已存在");
	 					$("#specCodeMsg").css("color","#f00");
	 					flag3 = false;
					}
				}
			});	
	 	}
	 ); 
	 
	/**
	 * 商品详情的在线编辑
	 */
	window.setTimeout(function() {
		editor = KindEditor.create('#admin_acc_edit_textarea', {
			width : '680px',
			height : '300px',
			items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak', 'anchor', 'link', 'unlink' ],
			uploadJson : 'up!upload.action'
		});
	}, 1);  

	/**
	 * 商品关联左边datagrid
	 */
	admin_goods_edit_uninGoods_left.datagrid({
		url : 'goods/goodsAction!gainApplicationModelList.action',
		pagination : true,
		fit : true,
		striped : true,
		singleSelect : false,
		checkOnSelect : true,
		selectOnCheck : true,
		fitColumns : true,
		idField : 'id',
		sortName : 'id',
		sortOrder : 'desc',
		pageSize : 10,
		pageList : [ 10, 30, 40, 50 ]
	});
	/**
	 * 商品关联右边datagrid
	 */
		admin_goods_edit_uninGoods_right.datagrid({
			url:'acc/accAction!gainSelectedGoods.action?a.id=${a.id}',
		fit : true,
		striped : true,
		singleSelect : false,
		checkOnSelect : true,
		selectOnCheck : true,
		fitColumns : true,
		idField : 'id',
		sortName : 'id',
		sortOrder : 'desc'
	}); 

	/**
	 *商品关联左边datagrid查询
	 */
	admin_goods_edit_searchButton.bind('click', function() {
		admin_goods_edit_uninGoods_left.datagrid('load', {
			name : $('#admin_goods_edit_searchName').val(),
			goodsNum : $('#admin_goods_edit_searchBn').val()
		});
	});

	/**
	 * 选择
	 */
	admin_goods_edit_uninGoods_select
			.bind(
					'click',
					function() {
						var admin_goods_add_uninGoods_left_data = admin_goods_edit_uninGoods_left.datagrid('getChecked');
						var admin_goods_add_uninGoods_right_hasSelect = admin_goods_edit_uninGoods_right.datagrid('getRows');
						var lh = admin_goods_add_uninGoods_left_data.length;
						for ( var int = 0; int < lh; int++) {
							var e = admin_goods_add_uninGoods_left_data[int];
							for ( var s = 0; s < admin_goods_add_uninGoods_right_hasSelect.length; s++) {
								f = admin_goods_add_uninGoods_right_hasSelect[s];
								if (e.id == f.id) {
									$.messager.show({
										title : '提醒',
										msg : '重复选择的会自动剔除,谢谢.',
										timeout : 5000,
										showType : 'slide'
									});
									admin_goods_add_uninGoods_left_data[int] = undefined;
								}
							}
						}
						for ( var int = 0; int < admin_goods_add_uninGoods_left_data.length; int++) {
							var e = admin_goods_add_uninGoods_left_data[int];
							if (e != undefined) {
								admin_goods_edit_uninGoods_right.datagrid(
										'insertRow', {
											row : e
										});
							}
						}
					});
	/**
	 * 取消选择
	 */
	admin_goods_edit_uninGoods_unselect.bind('click', function() {
		admin_goods_edit_uninGoods_left.datagrid('uncheckAll').datagrid(
				'unselectAll').datagrid('clearSelections');
	});
	/**
	 * 删除右边已选择
	 */
	admin_goods_edit_uninGoods_delSelect.bind('click', function() {
		var rows = admin_goods_edit_uninGoods_right.datagrid('getChecked');
		for ( var i = 0; i < rows.length; i++) {
			admin_goods_edit_uninGoods_right.datagrid('deleteRow',
					admin_goods_edit_uninGoods_right.datagrid('getRowIndex',
							rows[i].id));
		}
	});
		
	/**
 	 *配件保存按钮
     */	
 	admin_acc_edit_save.bind(
	'click',function() {
		//所有验证是否通过，若通过则保存，不通过则return
  		if(!flag1){
			return;
		}	
		if(!flag2){
			return;
		}	 
		if(!flag3){
			return;
		}
		if (validPreTable() == false)
		{
			return;
		}  
 		if(validClickRate()==false){
 			$("#clickRate").focus();
			return;
		}
		if(validStock()==false){
			$("#stock").focus();
			return;
		} 
		
		//图片路径
		var picSrc = [];
		var temp = $('#admin_acc_edit_thumbPic img');
		for ( var i = 0; i < temp.length; i++) {
			var e = temp[i];
			var s = e.src;
			picSrc.push(s);
		}
		//页面适用机型值
		var goodsSelected=[];
		var rows = admin_goods_edit_uninGoods_right.datagrid('getRows');
		for ( var ii = 0; ii < rows.length; ii++) {
			goodsSelected.push(rows[ii].id);
		}
		//如果修改配件为上架,其单价为0,那么需要提示修改价格为大于0
		if(priceCall()==false){
			return;
		}
		
		//去掉关联左边的对号
		admin_goods_edit_uninGoods_left.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		//去掉关联右边的对号
		admin_goods_edit_uninGoods_right.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');	 
		//保存	
 		admin_acc_editForm.form(
		   'submit',{
			url : 'acc/accAction!updateAccessories.action?picSrc='+picSrc+'&suitType='+goodsSelected,
 			onSubmit : function() {
				editor.sync();
				var isValid = admin_acc_editForm.form('validate');
				if (!isValid) {
					$.messager
					.progress('close'); // 当form不合法的时候隐藏工具条
				}
				return isValid; 
			}, 
			success : function(json) {
				try {
					j = $.parseJSON(json);
				} catch (e) {
					$.messager.alert('Warning','脚本错误,请重试!');
				}
				if (j.success) {
					$.messager.progress('close');
					$(
						'#admin_acc_datagrid')
						.datagrid('uncheckAll')
						.datagrid('unselectAll')
						.datagrid('clearSelections');
						var subtitle = "配件列表";
						var url = "acc/accAction!toAccList.action";
						var icon = "icon icon-em_list";
						if (!$('#tabs').tabs('exists',subtitle)) {
							$('#tabs').tabs(
								'add',
								{
									title : subtitle,
									href : url,
									closable : true,
									icon : icon
								}
							);
						} else {
							$('#tabs').tabs(
									'select',
									subtitle);
							$('#admin_acc_datagrid').datagrid('load',{});
						}
						tabClose();
						$('#tabs').tabs('close','修改配件');
			} else {
				$.messager.show({
					title : '提醒',
					msg : j.msg,
					timeout : 5000,
					showType : 'slide'
				});
		    }
		}
	});
	});		
});
	/**
	 * 加载完dom之后显示图片
	 */
	$(document).ready(function(){
  		var defaultImg = $("#defaultImg").val();
  		var defaultSrc = defaultImg.split(",");
  		var admin_acc_edit_thumbPic =document.getElementById("admin_acc_edit_thumbPic");
   		if(defaultImg!="" && defaultImg!=null && defaultImg!=undefined){
	    	for(var i=0;i<defaultSrc.length;i++){
	  			var img=document.createElement("img");
				img.setAttribute("id",sy.UUID());  
				img.setAttribute('src',defaultSrc[i]);
				img.style.height='41px';
				img.style.width='55px';
				img.style.marginRight='10px';
				img.style.display="inline";
				img.ondblclick= function(){
					acc_edit_dropDom(this);
				};
				admin_acc_edit_thumbPic.appendChild(img);
	  		}
  		}
	});
	/**
	 * 创建上传窗口 公共方法
	 */
	function UploaderForEdit(chunk, callBack) {
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
				var fw = GetFrameWindowForEdit(upladoer[0]);
				var files = fw.files;
				var thumbPaths = fw.thumbPaths;
				$(this).window('destroy');
				callBack.call(this, files, thumbPaths);
			},
			onOpen : function() {
				var target = $(this);
				setTimeout(function() {
					var fw = GetFrameWindowForEdit(upladoer[0]);
					fw.target = target;
				}, 100);
			}
		});
	}

	/**
	 * 根据iframe对象获取iframe的window对象
	 */
	function GetFrameWindowForEdit(frame) {
		return frame && typeof (frame) == 'object' && frame.tagName == 'IFRAME'
				&& frame.contentWindow;
	}
	/**
	 * 上传图片的触发事件
	 */
	function makerUploaderForEdit(chunk) {
		UploaderForEdit(
				chunk,
				function(files, thumbPaths) {
					if (files && files.length > 0) {
						var admin_acc_edit_thumbPic =document.getElementById("admin_acc_edit_thumbPic"); 
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
								acc_edit_dropDom(this);
							};
							admin_acc_edit_thumbPic.appendChild(img);
						};
					};
			});
	}
	/**
	 * 双击可删除图片
	 */
	function acc_edit_dropDom(obj){
		if(window.confirm("确定要删除该上传的图片?")){
			$("#"+obj.id).remove();
		}
	}
		 /**
	  * 点击提交按钮时，判断某个配件的isshelves的值如果是true（即上架）,那么获取相应的单价
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
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
		<form id="admin_acc_editForm" method="post">
			<input type="hidden" name="userId" value="<%=userId %>"/>
			<input type="hidden" id="accId" name="id" value="${a.id}"/>
			<table  id="admin_acc_datagrid" class="tableForm" style="margin-left: 70px;margin-top: 15px">
				<tr>	
					<th>配件名称：</th>
					<td><input id="accName" name="name" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${a.name}"/><div id="accNameMsg"></div></td>
					<th>商品代码：</th>
					<td><input id="accNum" name="accessoriesNum" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${a.accessoriesNum}"/><div id="accNumMsg"></div></td>
					<th>规格代码：</th>
					<td><input id="specCode" name="specCode" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${a.specCode}"/><div id="specCodeMsg"></div></td>
				</tr>
				<tr>
					<th>价格：</th>
					<td><input id="price" name="price" style="width:160px" class="easyui-validatebox" data-options="required:true" onblur="validPrice(this,'价格')" value="${a.price}"/><div></div></td>
					<th>原价：</th>
					<td><input id="originalPrice" name="originalPrice" style="width:160px" class="easyui-validatebox" data-options="required:true" onblur="validPrice(this,'原价')" value="${a.originalPrice}"/><div></div></td>
					<th>天猫价格：</th>
					<td><input id="tmallPrice" name="tmallPrice" style="width:160px" class="easyui-validatebox" data-options="required:true" onblur="validPrice(this,'天猫价')" value="${a.tmallPrice }"/><div></div></td>
				</tr>		
				<tr>
					<th>配件品牌 ：</th>
					<td>
						<input id="brandId" name="brandId" class="easyui-combobox" 
						data-options="url:'acc/accAction!gainAllBrand.action',valueField:'brandId',textField:'brandName',editable:false,multiple:false"style="width:160px" value="${a.brandId}"/>
					</td>
					<th>配件类别：</th>
					<td>
						<input name="catId" class="easyui-combobox" 
						data-options="url:'acc/accAction!gainAllCat.action',valueField:'catId',textField:'catName',editable:false,multiple:false"style="width:160px" value="${a.catId}"/>
					</td>
					<th>颜色：</th>
					<td>
						<input id="colorId" name="colorId" class="easyui-combobox" value="${a.colorId}"
						data-options="url:'acc/accAction!gainAllColor.action',valueField:'colorId',textField:'colorName',editable:false,multiple:false"style="width:160px"/>
					</td>
				</tr>	
				<tr>
					<th>是否上架：</th>	
					<td>
						<select id="isshelves" name="isshelves" style="width:160px">
							<s:if test="a.isshelves=='true'">
							<option value='true' selected="selected">上架</option>
							</s:if>
							<option value='false'>下架</option>
							<s:if test="a.isshelves=='false'">
							<option value='false' selected="selected">下架</option>
							</s:if>
							<option value='true'>上架</option>
						</select>
					</td>				
					<th>是否原装：</th>
					<td>
						<select name="isoriginal" style="width:160px">
							<s:if test="a.isoriginal=='true'">
							<option value='true' selected="selected">是原装</option>
							</s:if>
							<option value='false'>不是原装</option>
							<s:if test="a.isoriginal=='false'">
							<option value='false' selected="selected">不是原装</option>
							</s:if>
							<option value='true'>是原装</option>
						</select>
					</td>
					<th>是否线控：</th>
					<td>					
						<select name="iswire" style="width:160px">
							<s:if test="a.iswire=='true'">
							<option value='true' selected="selected">是</option>
							</s:if>
							<option value='false'>不是</option>
							<s:if test="a.iswire=='false'">
							<option value='false' selected="selected">不是</option>
							</s:if>
							<option value='true'>是</option>
						</select>
					</td>
				</tr>	
				<tr>
					<th>配件型号：</th>
					<td><input name="accessoriesVersion" style="width:160px" data-options="required:true" value="${a.accessoriesVersion}"/></td>
					<th>库存量：</th>
					<td><input id="stock" name="stock" style="width:160px" data-options="required:true" value="${a.stock}" onblur="validStock()"/><div id="stockMsg"></div></td>
					<th>点击量：</th>
					<td><input id="clickRate" name="clickRate" style="width:160px" data-options="required:true" value="${a.clickRate}" onblur="validClickRate()"/><div id="clickRateMsg"></div></td>
				</tr>
				<tr>
					<th>电池容量：</th>
					<td><input name="batteryCapacity" style="width:160px" data-options="required:true" value="${a.batteryCapacity}"/></td>
					<th>贴膜类型：</th>
					<td><input name="filmType" style="width:160px" data-options="required:true" value="${a.filmType}"/></td>
					<th>材质：</th>
					<td><input name="material" style="width:160px" data-options="required:true" value="${a.material}"/></td>
				</tr>
				<tr>
					<th>款式：</th>
					<td><input name="styles" style="width:160px" data-options="required:true" value="${a.styles}"/></td>
					<th>风格：</th>  
					<td><input name="accessoriesStyle" style="width:160px" data-options="required:true" value="${a.accessoriesStyle}"/></td>
					<th>佩戴方式：</th>
					<td><input name="wearType" style="width:160px" data-options="required:true" value="${a.wearType}"/></td>
				</tr>
				<tr>
					<th>三际天猫地址：</th>
					<td><input name="tmallUrl" style="width:160px" data-options="required:true" value="${a.tmallUrl}" /></td>
				</tr>
				<tr>
					<th>默认图片：</th>
					<td colspan="3">		
						<span>
							<a class="easyui-linkbutton" href="javascript:makerUploaderForEdit(false)">选择图片</a>&nbsp;&nbsp;&nbsp;
							<label style="color: red">第一张图片作为页面默认图片</label>
						</span>
						<span id="admin_acc_edit_pic">
							<span id="admin_acc_edit_thumbPic"></span>	
						</span>
						<input type="hidden" id="defaultImg" name="defaultImg" value="${a.defaultImg}"/>
					</td>
				</tr>
				<tr>
					<th>配件详情：</th>
					<td colspan="7">
						<textarea name='accessoriesDetail' id="admin_acc_edit_textarea" style="width:600px;height:80px;">
						${a.accessoriesDetail}
						</textarea>					
					</td>
				</tr>
			</table>	
			
			<div style="margin-left:70px;"><h4>适用机型信息修改:</h4></div>		
			<div>
			<div style="margin-left:70px;height: 300px;width:80%;background-color: #f1f1f1;"id="admin_goods_add_uninGoods_div" >
				<div class="easyui-layout" data-options="fit:true,border:true"style="background-color: #e1e1e1;border: 1px solid #e1e1e1">
					<div data-options="region:'center',border:false">
						<div class="easyui-layout" data-options="fit:true,border:false">
							<div data-options="region:'north',border:false" style="background-color: #f1f1f1;height:33px">
								<div style="padding: 3px">
									<span>
									<label>编号:</label><input id="admin_goods_edit_searchBn" />&nbsp;
									<label>名称:</label><input id="admin_goods_edit_searchName" />&nbsp; 
									<input type="button" id="admin_goods_edit_searchButton" value="查询" />
									</span>
								</div>
							</div>
							<div data-options="region:'center',border:false">
								<table id="admin_goods_edit_uninGoods_left" style="width:65%">
									<thead>
										<tr>
											<th data-options="field:'id',width:80,checkbox:true">ID</th>
											<th
												data-options="field:'name',width:80,sortable:true,formatter:function(value, row, index){
												var s = '<span title='+value+'>' + value + '</span>';
												return s;
											}">名称</th>
											<th data-options="field:'goodsNum',width:80,sortable:true">编号</th>
											<th data-options="field:'brandName',width:80,sortable:true">品牌</th>
										    <!-- <th data-options="field:'catName',width:80,sortable:true">类别</th> -->
										</tr>
									</thead>
								</table>
							</div>
							<div data-options="region:'south',border:false" style="height: 25px;background-color: #e1e1e1">
								<input type="button" id="admin_goods_edit_uninGoods_select" style="margin-right: 50px;float: right" value="选择" /> 
								<input type="button" id="admin_goods_edit_uninGoods_unselect" style="margin-right: 50px;float: right" value="取消选择" />
							</div>
						</div>
					</div>
					<div data-options="region:'east',border:false" style="width:400px;">
						<div class="easyui-layout" data-options="fit:true,border:false">
							<div data-options="region:'north',border:false" style="height: 33px;background-color:#f1f1f1;">
								<h1 align="center">已选择适用机型</h1>
							</div>
							<div data-options="region:'center',border:true">
								<table id="admin_goods_edit_uninGoods_right">
									<thead>
										<tr>
											<th data-options="field:'id',width:50,checkbox:true">ID</th>
											<th data-options="field:'goodsNum',width:70,sortable:true">编号</th>
											<th data-options="field:'name',width:120,sortable:true">名称</th>
										</tr>
									</thead>
								</table>
							</div>
							<div data-options="region:'south',border:false"
								style="height: 25px;background-color: #e1e1e1">
								<input type="button" id="admin_goods_edit_uninGoods_delSelect"
									style="margin-right: 50px;float: right" value="剔除已选择" />
							</div>
						</div>
					</div>
					
				</div>
			</div>
			</div>
																		 
			<div style="margin-left: 75px;margin-top: 15px"><input type="button" id="admin_acc_edit_save" value="保存" /></div>
		</form>
	</div>
</div>
