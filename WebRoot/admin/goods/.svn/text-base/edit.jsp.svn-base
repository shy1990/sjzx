<%@page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sanji.sjzx.common.util.ResourceUtil" %>
<%@page import="com.sanji.sjzx.pojo.SessionInfo" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
String basePath = PathUtil.getPath(request);
SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute(ResourceUtil.getSessionInfoName());
String userId = sessionInfo.getUserId();
%>
<script type="text/javascript">
	var goParam;
	var overParam=[];

	$(document).ready(
		function addTab(subtitle, url, icon){
			var tabCount = $('#tabs').tabs('tabs').length;//获取当前打开窗口总数量
			var hasTab = $('#tabs').tabs('exists', subtitle); //根据名称判断窗口是否已打开
			if (tabCount > 3 && !hasTab) { 
				$.messager.alert('提示','您当前打开页面太多，如果继续打开，会造成程序运行缓慢，无法流畅操作!','info');
				tabClose();
				$('#tabs').tabs('close', '修改商品');
	    	 }
    	 }
	);
	var tableNumInit = 0;//记录页面跳转过来时，table的数量
	var m=0;
	var flag = true;
	var array = new Array();
	var arrayJSON;
	var a=0;//用于加载时控制原有图片的id
	//添加下一个单品前，校验前一个单品信息是否符合条件
 	function validPreTable()
 	{
 		var tableNum = $("#admin_goods_edit_sku").children("table").length;
		var index = tableNum - 1;
		var skuCode = 'list[' + index + '].skuCode';
		var skuNum = 'list[' + index + '].skuNum';
		var price = 'list[' + index + '].price';
		var originalPrice = 'list[' + index + '].originalPrice';
		//var tmallPrice = 'list[' + index + '].tmallPrice';
		var stock = 'list[' + index + '].stock';
		var colorId = 'list[' + index + '].colorId';
		var changeNum = 'list[' + index + '].changeNum';
		var changePrice = 'list[' + index + '].changePrice';
	
		skuCodeOb = $("input[name='" + skuCode + "']");
		skuNumOb = $("input[name='" + skuNum + "']");
		priceOb = $("input[name='" + price + "']");
		originalPriceOb = $("input[name='" + originalPrice + "']");
		//tmallPriceOb = $("input[name='" + tmallPrice + "']");
		stockOb = $("input[name='" + stock + "']");
		colorIdOb = $("input[name='" + colorId + "']");
		changeNumOb = $("input[name='"+changeNum+"']");
		changePriceOb = $("input[name='"+changePrice+"']");
		
		if(checkSkuCode(skuCodeOb) == false){
			$(skuCodeOb).focus();
			return false;
		}
		if (checkSkuNum(skuNumOb) == false) {
			$(skuNumOb).focus();
			return false;
		}

		if (validPrice(priceOb,'单价') == false) {
			$(priceOb).focus();
			return false;
		}

		if (validPrice(originalPriceOb,'原价') == false) {
			$(originalPriceOb).focus();
			return false;
		}

/* 		if (validPrice(tmallPriceOb,'天猫价') == false) {
			$(tmallPriceOb).focus();
			return false;
		} */

		if (colorIdOb.val() == null || colorIdOb.val() == 'undefined' || colorIdOb.val() == '') {
		 alert("请选择单品颜色！");
		 return false;
		} 

		if (validStock(stockOb) == false) {
			$(stockOb).focus();
			return false;
		}
		if(validChangeNum(changeNumOb)==false){
			$(changeNumOb).focus();
			return false;
		}
		if(validChangePrice(changePriceOb,'变动的价格')==false){
			$(changePriceOb).focus();
			return false;
		}
		return true;
 	}
 	//验证商品代码是否存在和重复
 	function checkSkuCode(obj){
 		var skuCodeFlag = false;
	 	//取得文本框的值
	 	var skuCodeMsgObj = $(obj).next();
 		var skuCode = $(obj).val();
 		//获取当前单品的单品ID
 		//var skuId = $(obj).parents("table").prev().val();
 		//var skuId = $(obj).parents("table").find("input").first().val();//当前table中第一个input
 		//console.info("wwwwwwwwwwwwwwww>>>>>>>skuId=="+skuId);
 		var skuNameAttr = $(obj).attr("name");
	 	if(skuCode == null || skuCode ==""){
 			$(skuCodeMsgObj).text("商品代码不能为空!");
 			$(skuCodeMsgObj).css("color", "#f00");
 			skuCodeFlag = false;
 			return skuCodeFlag;
 		}else{
			$(skuCodeMsgObj).text("ok");
			$(skuCodeMsgObj).css("color", "#00f");
			skuCodeFlag = true;
			return skuCodeFlag;
		}
 		
	 	//校验一下其他的单品是否已经拥有此商品代码
/* 	 	var tableNum = $("#admin_goods_edit_sku").children("table").length;
	 	for (var tabIndex=0; tabIndex<tableNum; tabIndex++)
	 	{
	 		var tableObj = $("#admin_goods_edit_sku").children("table")[tabIndex];
	 		var tdObj = $(tableObj).find("input")[1];
	 		
	 		var tdValue = $(tdObj).val();
	 		var tdNameValue = $(tdObj).attr("name");
	 		if (skuNameAttr != tdNameValue && skuCode == tdValue)
	 		{	
				$(skuCodeMsgObj).text("商品代码不能重复");
				$(skuCodeMsgObj).css("color","#f00");
				skuCodeFlag = false;
				return skuCodeFlag;
	 		}
	 	}
	 	
 		//发送异步请求给skuCodeValidate 
 		$.ajax({
			url : "goods/goodsAction!skuCodeValidateWhenUpdate.action",
			type : "POST",
			dataType : "JSON",
			data : {"sku.id":skuId,"sku.skuCode":skuCode},
			async : false,
			success : function(j) {
				if(j.success){					
					//如果返回值为true，则校验通过
 					$(skuCodeMsgObj).text("ok");
 					$(skuCodeMsgObj).css("color","#00f");
 					skuCodeFlag = true;				
				}else{
 					//如果返回值为false，则校验不通过
 					$(skuCodeMsgObj).text("此商品代码已存在");
 					$(skuCodeMsgObj).css("color","#f00");
 					skuCodeFlag = false;
				}
			}
		});		 */
		return skuCodeFlag; 
 	}
	//验证单品编号是否存在和重复
	function checkSkuNum(obj)
	{
		var skuNumFlag = false;
	 	//取得文本框的值
	 	var skuNumMsgObj = $(obj).next();
 		var skuNum = $(obj).val();
 		//获取当前单品的单品ID
 		//var skuId = $(obj).parents("table").prev().val();
 		var skuId = $(obj).parents("table").find("input").first().val();//当前table中第一个input
 		var skuNameAttr = $(obj).attr("name");
	 	if(skuNum == null || skuNum ==""){
 			$(skuNumMsgObj).text("商品规格代码不能为空!");
 			$(skuNumMsgObj).css("color", "#f00");
 			skuNumFlag = false;
 			return skuNumFlag;
 		}/* else{
			$(skuNumMsgObj).text("ok");
			$(skuNumMsgObj).css("color", "#00f");
			skuNumFlag = true;
			return skuNumFlag;
		} */
 		
	 	//校验一下其他的单品是否已经拥有此单品编号
 	 	var tableNum = $("#admin_goods_edit_sku").children("table").length;
	 	for (var tabIndex=0; tabIndex<tableNum; tabIndex++)
	 	{
	 		var tableObj = $("#admin_goods_edit_sku").children("table")[tabIndex];
	 		var tdObj = $(tableObj).find("input")[2];
	 		
	 		var tdValue = $(tdObj).val();
	 		var tdNameValue = $(tdObj).attr("name");
	 		if (skuNameAttr != tdNameValue && skuNum == tdValue)
	 		{	
				$(skuNumMsgObj).text("商品规格代码不能重复");
				$(skuNumMsgObj).css("color","#f00");
				skuNumFlag = false;
				return skuNumFlag;
	 		}
	 	} 
	 	
 		//发送异步请求给skuNumValidate 
  		$.ajax({
			url : "goods/goodsAction!skuNumValidateWhenUpdate.action",
			type : "POST",
			dataType : "JSON",
			data : {"sku.id":skuId,"sku.skuNum":skuNum},
			async : false,
			success : function(j) {
				if(j.success){					
					//如果返回值为true，则校验通过
 					$(skuNumMsgObj).text("ok");
 					$(skuNumMsgObj).css("color","#00f");
 					skuNumFlag = true;				
				}else{
 					//如果返回值为false，则校验不通过
 					$(skuNumMsgObj).text("此商品规格代码已存在");
 					$(skuNumMsgObj).css("color","#f00");
 					skuNumFlag = false;
				}
			}
		});		 
		return skuNumFlag; 
	}
	
	// 校验单品单价、原价和天猫价
	function validPrice(skuPriceObj,desc){

		var skuPriceFlag = false;
	 	var skuPriceValidObj = $(skuPriceObj).next();
	 	var skuPriceValue = $(skuPriceObj).val();
	 		
	 	var reg = /^-?(0|[1-9]\d*)(\.\d{1,2})?$/;
		if (skuPriceValue == '') {
			$(skuPriceValidObj).text("请输入单品"+desc);
			$(skuPriceValidObj).css("color", "#f00");
			return skuPriceFlag;
		}
		
		if(!reg.test(skuPriceValue)){
			$(skuPriceValidObj).text("单品"+desc+"请输入数字，最多保留两位小数");
			$(skuPriceValidObj).css("color", "#f00");
			return skuPriceFlag;
		}
		
		if(skuPriceValue<0){
			$(skuPriceValidObj).text("单品"+desc+"请输入正数，最多保留两位小数");
			$(skuPriceValidObj).css("color", "#f00");
			return skuPriceFlag;
		}
		
		$(skuPriceValidObj).text("ok");
		$(skuPriceValidObj).css("color", "#00f");
		skuPriceFlag = true;
		return skuPriceFlag;
	}
	
	// 校验库存
	function validStock(stockObj)
	{
		//var stockReg=/^-?\d+$/;  
		var stockReg=/^(0|[1-9][0-9]*)$/ ; 
		var skuStockFlag = false;
	 	var skuStockValidObj = $(stockObj).next();
	 	var skuStockValue = $(stockObj).val();
		
		if (skuStockValue == '') {
			$(skuStockValidObj).text("请输入单品库存");
			$(skuStockValidObj).css("color", "#f00");
			return skuStockFlag;
		}
		if(!stockReg.test(skuStockValue)){
			$(skuStockValidObj).text("单品库存请输入正整数");
			$(skuStockValidObj).css("color", "#f00");
			return skuStockFlag;
		}
		if(skuStockValue<0){
			$(skuStockValidObj).text("单品库存请输入正整数");
			$(skuStockValidObj).css("color", "#f00");
			return skuStockFlag;
		}
		
		$(skuStockValidObj).text("ok");
		$(skuStockValidObj).css("color", "#00f");
		skuStockFlag = true;
		return skuStockFlag;
	}
	// 校验变动的价格
	function validChangePrice(changePriceObj,desc){

		var changePriceFlag = false;
	 	var changePriceValidObj = $(changePriceObj).next();
	 	var changePriceValue = $(changePriceObj).val();
	 		
	 	var reg = /^-?(0|[1-9]\d*)(\.\d{1,2})?$/;	
	 	if(changePriceValue!=null && changePriceValue!="" && changePriceValue!=undefined){
		 	if(!reg.test(changePriceValue)){
				$(changePriceValidObj).text("变动"+desc+"请输入数字，最多保留两位小数");
				$(changePriceValidObj).css("color", "#f00");
				return changePriceFlag;
			}
			
			if(changePriceValue<0){
				$(changePriceValidObj).text("变动"+desc+"请输入正数，最多保留两位小数");
				$(changePriceValidObj).css("color", "#f00");
				return changePriceFlag;
			}
			
			$(changePriceValidObj).text("ok");
			$(changePriceValidObj).css("color", "#00f");
			changePriceFlag = true;
	 	}else{
	 		$(changePriceValidObj).text("");
	 		changePriceFlag = true;
	 	}	

		return changePriceFlag;
	}
	//校验变动的数量
	function validChangeNum(changeNumObj)
	{
		//var stockReg=/^-?\d+$/;  
		var reg=/^(0|[1-9][0-9]*)$/ ; 
		var changeNumFlag = false;
	 	var changeNumValidObj = $(changeNumObj).next();
	 	var changeNumValue = $(changeNumObj).val();
		
		if(changeNumValue!=null && changeNumValue!="" && changeNumValue!=undefined){
			if(!reg.test(changeNumValue)){
				$(changeNumValidObj).text("变动的数量请输入正整数");
				$(changeNumValidObj).css("color", "#f00");
				return changeNumFlag;
			}
			if(changeNumValue<0){
				$(changeNumValidObj).text("变动的数量请输入正整数");
				$(changeNumValidObj).css("color", "#f00");
				return changeNumFlag;
			}
			$(changeNumValidObj).text("ok");
			$(changeNumValidObj).css("color", "#00f");
			changeNumFlag = true;
		}else{
			$(changeNumValidObj).text("");
			changeNumFlag = true;
		}
		return changeNumFlag;
	}
	
 $(function(){
	var admin_goods_editForm = $('#admin_goods_editForm');
	var admin_goods_edit_save = $('#admin_goods_edit_save');
	var admin_goods_edit_uninGoods_left = $('#admin_goods_edit_uninGoods_left');
	var admin_goods_edit_uninGoods_right = $('#admin_goods_edit_uninGoods_right');
	var admin_goods_edit_uninGoods_select = $('#admin_goods_edit_uninGoods_select');
	var admin_goods_edit_uninGoods_unselect = $('#admin_goods_edit_uninGoods_unselect');
	var admin_goods_edit_uninGoods_delSelect = $('#admin_goods_edit_uninGoods_delSelect');
	var admin_goods_edit_searchButton = $('#admin_goods_edit_searchButton');
	var admin_goods_add_on = $('#admin_goods_add_on');
	var admin_goods_edit_sku_table = $('#admin_goods_edit_sku_table');
	var admin_goods_minus_on = $('#admin_goods_minus_on');
	var goodsName = $('#goodsName');
	
	var screenSize = $('#screenSize');
	var clickRate = $('#clickRate');
	var weight = $('#weight');
	var warrantyTime = $('#warrantyTime');
	
	var i=0;
	var flag = false;
		
		/**
		 * 商品关联左边datagrid
		 */
		admin_goods_edit_uninGoods_left.datagrid({
			url : 'acc/accAction!gainAccessoriesMaskList.action',
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
 			url:'goods/goodsAction!gainSelectedGift.action?goods.id=${goods.id}',
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
				accessoriesNum : $('#admin_goods_edit_searchBn').val()
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
					   		var rh = admin_goods_add_uninGoods_right_hasSelect.length;
							//alert("左边数据的个数1h==="+lh);
/* 							//alert("右边数据的个数rh==="+rh);
							if(lh>1){//如果左边选择的行记录大于1，那么提示只能选一个赠品
								$.messager.show({
									title : '提醒',
									msg : '一个商品只能选择一个赠品,谢谢.',
									timeout : 5000,
									showType : 'slide'
								});
							}else{//如果确保了左边选择的行记录为1，那么判断右边是否已经有数据
								if(rh>0){//如果右边已经有数据了，那么提示只能选一个赠品
									$.messager.show({
										title : '提醒',
										msg : '一个商品只能选择一个赠品,您已经选择赠品了,谢谢.',
										timeout : 5000,
										showType : 'slide'
									});
								}else{//如何右边没有数据，那么可以添加赠品 */
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
								//}
							//}
/* 							for ( var int = 0; int < lh; int++) {
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
							} */
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
 	 * 商品详情的编辑
     */
	window.setTimeout(function() {
		editor = KindEditor.create('#admin_goods_add_textarea', {
			width : '680px',
			height : '300px',
			items : [ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak', 'anchor', 'link', 'unlink' ],
			uploadJson : 'up!upload.action'
		});
	}, 1);

	/**
	 *判断商品名称是否存在
	 */
	 var id = $("#id").val();
	 goodsName.blur(function(){
	 	 	validGoodsName();
	 	 }
	 );  
	 function validGoodsName(){
	 		var goodsNameFlag = false;
	 		//取得文本框的值
	 		var goodsName = $("#goodsName").val();
 	 		if(goodsName == null || goodsName ==""){
 	 			$("#nameMsg").text("商品名称不能为空");
 	 			$("#nameMsg").css("color", "#f00");
	 			goodsNameFlag = false;
	 			return goodsNameFlag;
	 		}else{
				$("#nameMsg").text("ok");
				$("#nameMsg").css("color", "#00f");
				goodsNameFlag = true;
				return goodsNameFlag;
			}
 	 		//发送异步请求给goodsNameValidate 
/* 	 		$.ajax({
				url : "goods/goodsAction!goodsNameValidateWhenUpdate.action",
				type : "POST",
				dataType : "JSON",
				data : "id="+id+"&name="+goodsName,
				async : false,
				success : function(j) {				
					if(j.success){
						//如果返回值为true，则校验通过
	 					$("#nameMsg").text("ok");
	 					$("#nameMsg").css("color","#00f");
	 					flag=true;
	 					goodsNameFlag = true;
					}else{
	 					//如果返回值为false，则校验不通过
	 					$("#nameMsg").text("此商品名称已存在");
	 					$("#nameMsg").css("color","#f00");
	 					flag = false;
					}
				}
			}); */
			return goodsNameFlag;				
	 	}

	 	/**
	 	 * 校验屏幕尺寸、手机重量、质保时间、点击量
	 	 * 屏幕尺寸要求精度:保留小数点后两位
	 	 */
		 screenSize.blur(function(){
		 	validScreenSize();
		 });  
	 	function validScreenSize(){
	 		var f = false;
	 		var screenSize = $("#screenSize").val();
	 		//console.info("screenSize===="+screenSize);
	 		var reg = /^(\d+)(\.\d{0,2})?$/;
	 		if(screenSize !=null && screenSize!="" && screenSize!=undefined){
	 			if(!reg.test(screenSize)){
	 				$("#screenSizeMsg").text("请输入正数，最多保留两位小数");
					$("#screenSizeMsg").css("color","#f00");
					return f;
	 			}
	 			if(screenSize<0){
	 				$("#screenSizeMsg").text("请输入正数，最多保留两位小数");
					$("#screenSizeMsg").css("color","#f00");
					return f;
	 			}
			 	$("#screenSizeMsg").text("ok");
				$("#screenSizeMsg").css("color","#00f");
				f = true;
	 		}else{
	 			$("#screenSizeMsg").text("");
	 			f = true;
	 		}
	 		return f;
	 	}
	 	/**
	 	 * 校验手机重量
	 	 */ 
	 	weight.blur(function(){
		 	validWeight();
		 });  
	 	function validWeight(){
	 		var f = false;
	 		var weight = $("#weight").val();
	 		var reg = /^-?(0|[1-9]\d*)(\.\d{1,2})?$/;
	 		if(weight !=null && weight!="" && weight!=undefined){
	 			if(!reg.test(weight)){
	 				$("#weightMsg").text("请输入正数，最多保留两位小数");
					$("#weightMsg").css("color","#f00");
					return f;
	 			}
	 			if(weight<0){
	 				$("#weightMsg").text("请输入正数，最多保留两位小数");
					$("#weightMsg").css("color","#f00");
					return f;
	 			}
			 	$("#weightMsg").text("ok");
				$("#weightMsg").css("color","#00f");
				f = true;
	 		}else{
	 			$("#weightMsg").text("");
	 			f = true;
	 		}
	 		return f;
	 	}
	 	
	 	/**
	 	 * 校验点击量
	 	 */ 
	 	clickRate.blur(function(){
		 	validClickRate();
		 });  
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
	 	/**
	 	 * 校验质保时间
	 	 */ 
	 	warrantyTime.blur(function(){
		 	validwarrantyTime();
		 });  
	 	function validwarrantyTime(){
	 		var f = false;
	 		var warrantyTime = $("#warrantyTime").val();
	 		var reg=/^(0|[1-9][0-9]*)$/ ; 
	 		if(warrantyTime !=null && warrantyTime!="" && warrantyTime!=undefined){
	 			if(!reg.test(warrantyTime)){
	 				$("#warrantyTimeMsg").text("请输入正整数");
					$("#warrantyTimeMsg").css("color","#f00");
					return f;
	 			}
	 			if(warrantyTime<0){
	 				$("#warrantyTimeMsg").text("请输入正整数");
					$("#warrantyTimeMsg").css("color","#f00");
					return f;
	 			}
			 	$("#warrantyTimeMsg").text("ok");
				$("#warrantyTimeMsg").css("color","#00f");
				f = true;
	 		}else{
	 			$("#warrantyTimeMsg").text("");
	 			f = true;
	 		}
	 		return f;
	 	}
	 	 function loadData() {
					//页面加载时，为手机分类赋值
					var machineType = $("#machine").html();
				//	console.info("machineType==="+machineType);
					
					var s = machineType.substring(1,machineType.length-1).split(",");
					
					//console.info("s.length=="+s.length);
					 var mach;
					$('#machineType').combobox({   
					    onLoadSuccess:function(){
							//	console.info('加载完毕设置默认值');
									$(this).combobox('setValues',  s); 
							}	
					});  
					
					//console.info("mach==="+mach);
				//	$("#machineType").val(mach);
                    
					var tableNum1 = $("#admin_goods_edit_sku").children("table").length;//子元素table的个数
					for(var i =0;i<tableNum1;i++){
						var tableObj1 = $("#admin_goods_edit_sku").children("table")[i];//具体每个table对象
						//页面加载时，修改a标签的属性id的值
						var aNum = $(tableObj1).find("a").length;//一个table中的a标签的个数
						for(var aa=0;aa<aNum;aa++){
							var aObj = $(tableObj1).find("a")[aa];//具体的某个a标签
							var aObjValue = $(aObj).attr("id");
							if(aObjValue!=undefined){
								var aObjNewValue = aObjValue.replace(/\_\m/, "_" + i);
								$(aObj).attr("id",aObjNewValue);
							}
						}
						//加载时修改具体某个table中所有span的id属性，包括（颜色父节点span、原有图片父节点span、新添加图片父节点span）
						var spanNum = $(tableObj1).find("span").length;//找具体某个table里的span个数
						for(var ii=0;ii<spanNum;ii++){
							var spanObj = $(tableObj1).find("span")[ii];
							var spanObjValue = $(spanObj).attr("id");
							if(spanObjValue!= undefined){
								var spanObjNewValue = spanObjValue.replace(/\_\m/, "_" + i);
								$(spanObj).attr("id",spanObjNewValue);
							}
						}
						//页面加载时修改所有select的id属性
						var selectNum = $(tableObj1).find("select").length;//找具体某个table里的select个数
						for(var ii=0;ii<selectNum;ii++){
							var selectObj = $(tableObj1).find("select")[ii];//具体某个select对象
							var selectObjValue = $(selectObj).attr("id");
							if(selectObjValue!=undefined){
								var selectObjNewValue = selectObjValue.replace(/\_\m/, "_" + i);
								$(selectObj).attr("id",selectObjNewValue);
							}
						}
						
						//设置原有图片父节点span包含的图片的id属性
						var spanId = 'admin_goods_add_thumbPic_'+i;
						var spanLoadSpanObj = document.getElementById(spanId);
						var imgNum = $(spanLoadSpanObj).find("img").length;//图片父节点span包含的图片个数
						for(var mm = 0;mm<imgNum;mm++){
							var imgObj = $(spanLoadSpanObj).find("img")[mm];//具体的某张图片
							var imgObjValue = $(imgObj).attr("id");
							if(imgObjValue!=undefined){//img_n
								var newStr = imgObjValue.substr(0,imgObjValue.length - 1);
								var modifyAttrValue = newStr + a;
								$(imgObj).attr("id",modifyAttrValue);
								a++;
								//console.info('$(imgObj).attr("id")=='+$(imgObj).attr("id"));
							}
						}  
						//控制当前table中最后一个input的id
						var tdObj1 = $(tableObj1).find("input").last();//当前table中最后一个input
						var attrValue1 = $(tdObj1).attr("id");
						//console.info("attrValue1====>>>>>>"+attrValue1);//admin_goods_delete_m
						if(attrValue1 != undefined){
							//console.info("i====>>>>>>"+i);
							var modifyValue1 = attrValue1.substr(0,attrValue1.length-1)+i;
							//console.info("modifyValue1====>>>>>>"+modifyValue1);
							$(tdObj1).attr("id",modifyValue1);
						//	console.info("id===>>>>>"+$(tdObj1).attr("id"));
						}
				    }	
				    m = tableNum1 - 1;
					tableNumInit = tableNum1;
				    	}					
		//加载完所有节点之后
		$(document).ready(function(){
			loadData();
		  }
		);
	 	
	/**
	 * 继续添加单品
	 */
	admin_goods_add_on.bind(
		'click',function(){		
		//复制之前判断前一个单品信息
		if (validPreTable() == false)
		{
			return;
		}
		
		 admin_goods_edit_sku_table.clone().insertBefore(admin_goods_add_sku_operator);
		 var tableNum = $("#admin_goods_edit_sku").children("table").length;//div中table的个数
		 var tableObj = $("#admin_goods_edit_sku").children("table")[tableNum-1];//div中最后一个table
		 $(tableObj).show();
		 var tdNum = $(tableObj).find("input").length;
		// console.info("tdNum>>>^^^^==="+tdNum);
		 //清空复制之后的提示信息
		 var divNum = $(tableObj).find("div").length;
		 for (var divN = 0; divN < divNum; divN++)
		 {
			 var skuNumMsgObj = $(tableObj).find("div")[divN];
			 $(skuNumMsgObj).text("");
		 }	
		 i++;	
		 m++;
		  
		 var numList = tableNum-1;
		 for (var index=0; index<tdNum; index++){
		 	var tdObj = $(tableObj).find("input")[index];
		 	var attrValue = $(tdObj).attr("name");
		 	if(attrValue != undefined){
			 	var modifyValue = attrValue.replace(/list\[\w\]/,"list["+numList+"]");
			 	$(tdObj).attr("name",modifyValue);
				$(tdObj).val("");
		 	}
		 }
		//控制当前table中的isDelete 的input
		var t = tableNum - 1;//下标
		//console.info("t========>>>"+t);
		var inputName = 'list[' + t + '].isDelete';
		var inputNameObj = $("input[name='" + inputName + "']");
		inputNameObj.val('1');//设置成未删除
		//控制当前table中最后一个input的id
		var tdObj1 = $(tableObj).find("input").last();//当前table中最后一个input
		var attrValue1 = $(tdObj1).attr("id");
		//console.info("attrValue1====>>>>>>"+attrValue1);//admin_goods_delete_m
		if(attrValue1 != undefined){
			//console.info("i====>>>>>>"+i);
			var modifyValue1 = attrValue1.substr(0,attrValue1.length-1)+i;
			//console.info("modifyValue1====>>>>>>"+modifyValue1);
			$(tdObj1).attr("id",modifyValue1);
			//console.info("id===>>>>>"+$(tdObj1).attr("id"));
		}
		//控制第19个input
		var inputObj11 =$(tableObj).find("input")[19];
		var inputObjValue11=$(inputObj11).attr("id");
		//console.info("inputObjValue11==="+inputObjValue11);
		if(inputObjValue11 !=undefined){
			var modifyValue11 = inputObjValue11.substr(0,inputObjValue11.length-1)+t;
			//console.info("modifyValue11====>>>>>>"+modifyValue11);
			$(inputObj11).attr("id",modifyValue11);
			//console.info("id===>>>>>"+$(inputObj11).attr("id"));
			
		}
		 //修改所有select的name属性
		 var selectNum = $(tableObj).find("select").length;//table中select的个数
		 for(var s=0;s<selectNum;s++){
		 	var selectObj = $(tableObj).find("select")[s];//具体某个select
		 	
		 	var selectObjAttr = $(selectObj).attr("name");
		 	var newSelectObjAttr = selectObjAttr.replace(/list\[\w\]/,"list["+numList+"]");
		 	$(selectObj).attr("name",newSelectObjAttr);
		 }
		 /**
		  * 点击继续添加按钮时，a标签的属性id值进行控制,然后把a标签的触发函数控制一下
		  *///href="javascript:makerUploadForAdd(false,m)"
		var aObj = $(tableObj).find("a")[0];
		var aObjIdValue = $(aObj).attr("id");
		if(aObjIdValue != undefined){
			$(aObj).attr("id","a_"+m);
			$(aObj).attr("href",'javascript:makerUploadForAdd(false,'+m+')');
		}	
		
		 /**
		  * 点击继续添加按钮时，对颜色span的id和图片span的id的控制  
		  */
		//console.info("*****------------------------------------------------------------*****");
		var spanNum = $(tableObj).find("span").length;
		//console.info("spanNum====>>>>>"+spanNum);
		//第一个span为颜色父节点，添加之后修改其ID
		var colorParentSpanObj = $(tableObj).find("span")[0];
		var colorParentSpanIdValue = $(colorParentSpanObj).attr("id");
		if (colorParentSpanIdValue != undefined)
		{
			$(colorParentSpanObj).attr("id","span_color_"+m);
		}
		//如果颜色父节点下已有颜色，就删掉重建
		var colorNum = $(colorParentSpanObj).find("input").length;
		if(colorNum>0){
			$(colorParentSpanObj).empty();
			
			var input = document.createElement("input");
			$(input).attr("id","colorId_"+m);
			$(input).attr("name","list["+m+"].colorId");
			$(input).attr("class","easyui-combobox");
			$(input).css("width","160px");
			colorParentSpanObj.appendChild(input);		 						
		}
		$("#colorId_"+m).combobox({
			url:'goods/goodsAction!gainSkuColorName.action',
			valueField:'colorId',
			textField:'colorName',
			editable:false,
			multiple:false
		}); 
			//console.info("jjjjjjjjj------------------------------------------------------------");
		for(var j=4;j<5;j++){
			var spanObj2 = $(tableObj).find("span")[j];//具体第四个span是netsuitType的父节点
			//console.info("spanObj2===="+spanObj2);
			var spanAttrValue2 = $(spanObj2).attr("id");
			//console.info("spanAttrValue2===>>>>>"+spanAttrValue2);
			if (spanAttrValue2 != undefined) {
				var newStr2 = spanAttrValue2.substr(0,spanAttrValue2.length - 1);
				var modifyAttrValue2 = newStr2 + m;
				//console.info("modifyAttrValue2:"+modifyAttrValue2);
				$(spanObj2).attr("id", modifyAttrValue2);
				var inputNum = $(spanObj2).find("input").length;
				//console.info("网络类型对象的个数"+inputNum);
				if(inputNum>0){
					$(spanObj2).empty();//span_netsuit_m
					var span_netsuit=document.getElementById(modifyAttrValue2);
					//console.info("span_netsuit==="+span_netsuit);
					var input=document.createElement("input");
					$(input).attr("id","netsuitId_"+m);
					$(input).attr("name","list["+m+"].netsuitType");
					$(input).attr("class","easyui-combobox");
					$(input).css("width","160px");
					span_netsuit.appendChild(input);	 	
				} 
			}
		}
			//console.info("jjjjjjjjj------------------------------------------------------------");
		for(var j=8;j<9;j++){
			var spanObj3 = $(tableObj).find("span")[j];//具体第八个span是img的父节点
			var spanAttrValue3 = $(spanObj3).attr("id");
			//console.info("spanAttrValue3===>>>>>"+spanAttrValue3);
			if (spanAttrValue3 != undefined) {
				var newStr3 = spanAttrValue3.substr(0,spanAttrValue3.length - 1);
				var modifyAttrValue3 = newStr3 + m;
				//console.info("modifyAttrValue3:"+modifyAttrValue3);
				$(spanObj3).attr("id", modifyAttrValue3);
				var imgNum = $(spanObj3).find("img").length;
				if (imgNum > 0) {
					$(spanObj3).empty();
				}
			} 
		}
		//第八个span为原有图片的父节点,添加之后,删除该span
		$("#netsuitId_"+m).combobox({
			url:'admin/goods/netsuitType.json',
			valueField:'id',
			textField:'text',
			editable:true,
			multiple:true
		});  

	});
	
	/**
	 * 取消添加单品
	 */
	admin_goods_minus_on.bind(
		'click',function(){
			if (m > tableNumInit-1)
			{
				i--;
				m--;
				var num = $("#admin_goods_edit_sku").children("table").length;
				var obj = $("#admin_goods_edit_sku").children("table")[num-1];
				$(obj).remove();
			}
		}
	);
	/**
 	 *商品保存按钮
     */	
 	admin_goods_edit_save.bind(
		'click',function() {
			//提交时再控制一下验证框
			if(validGoodsName() == false){
				$("#nameMsg").text("商品名称校验未通过");
				$("#nameMsg").css("color", "#f00");
				$("#goodsName").focus();
				return;
			}
			if(validScreenSize() == false){
				$("#screenSizeMsg").text("屏幕尺寸校验未通过");
				$("#screenSizeMsg").css("color", "#f00");
				$("#screenSize").focus();
				return;
			}
			if(validWeight() == false){
				$("#weightMsg").text("手机重量校验未通过");
				$("#weightMsg").css("color", "#f00");
				$("#weight").focus();
				return;
			}
			if(validClickRate() == false){
				$("#clickRateMsg").text("点击量校验未通过");
				$("#clickRateMsg").css("color", "#f00");
				$("#clickRate").focus();
				return;
			}
			if(validwarrantyTime() == false){
				$("#warrantyTimeMsg").text("质保时间校验未通过");
				$("#warrantyTimeMsg").css("color", "#f00");
				$("#warrantyTime").focus();
				return;
			}
			
			var tableNum = $("#admin_goods_edit_sku").children("table").length;
			for ( var index = 0; index < tableNum; index++) {
				var skuCode = 'list[' + index + '].skuCode';
				var skuNum = 'list[' + index + '].skuNum';
				var price = 'list[' + index + '].price';
				var originalPrice = 'list[' + index + '].originalPrice';
				//var tmallPrice = 'list[' + index + '].tmallPrice';
				var stock = 'list[' + index + '].stock';
				
				skuCodeOb = $("input[name='" + skuCode + "']");
				skuNumOb = $("input[name='" + skuNum + "']");
				priceOb = $("input[name='" + price + "']");
				originalPriceOb = $("input[name='" + originalPrice + "']");
				//tmallPriceOb = $("input[name='" + tmallPrice + "']");
				stockOb = $("input[name='" + stock + "']");
				
				if(checkSkuCode(skuCodeOb) == false){
					$(skuCodeOb).focus();
					return;
				}
				
				if (checkSkuNum(skuNumOb) == false) {
					$(skuNumOb).focus();
					return;
				} 

				if (validPrice(priceOb,'单价') == false)
				{
					$(priceOb).focus();
					return;
				}
				
				if (validPrice(originalPriceOb,'原价') == false)
				{
					$(originalPriceOb).focus();
					return;
				}
				
/* 				if (validPrice(tmallPriceOb,'天猫价') == false)
				{
					$(tmallPriceOb).focus();
					return;
				} */
				
				if (validStock(stockOb) == false)
				{
					$(stockOb).focus();
					return;
				}
			}
			if (validPreTable() == false)
			{
				return;
			}
			if(priceCall() == false){
				return;
			}
			//页面赠品值
			var giftSelected=[];
			var rows = admin_goods_edit_uninGoods_right.datagrid('getRows');
			for ( var ii = 0; ii < rows.length; ii++) {
				giftSelected.push(rows[ii].id);
			}
			//处理图片	 
			//admin_goods_add_thumbPic_load_m
			var tableNum = $("#admin_goods_edit_sku").children("table").length;//table个数
			for(var s=0;s<tableNum;s++){
				var showID = "admin_goods_add_thumbPic_" + s;//console.info("showID======="+showID);
				var admin_goods_add_thumbPic = document.getElementById(showID);
				var imgNum = $(admin_goods_add_thumbPic).find("img").length;
				//console.info("imgNum=="+imgNum);
				
				var skuNumAttr = 'list['+s+'].skuNum';
				var skuNumObj = $("input[name='" + skuNumAttr + "']");
				var skuNum = $(skuNumObj).val();//获取单品编号
				//console.info("skuNum==="+skuNum);
				
				var imgSrcs =[];
				var obj = new Object();//用于封装skuNum和imgSrcs
				
				for(var t=0;t<imgNum;t++){console.info("图片个数==="+imgNum);
					var imgObj = $(admin_goods_add_thumbPic).find("img")[t];//具体某张图片
					var imgSrc = $(imgObj).attr("src");
					//console.info("imgObj==="+imgObj+"  imgSrc==="+imgSrc);
					if(imgSrc!=null && imgSrc!=undefined && imgSrc!=""){
						imgSrcs.push(imgSrc);
					}
					//console.info("$$$$$$$$$$imgSrcs==="+imgSrcs);
				} 
				obj["imgs"]=imgSrcs;
				obj["skuNum"]=skuNum;
				if(imgSrcs.length>0){//如果图片数组 不为空
					array.push(obj);
					arrayJSON = $.toJSON(array);
					//console.info("arrayJSON=="+arrayJSON);
				}
			}		
  			//console.info("arrayJSON>>>>>>=="+arrayJSON);
  			//保存之前获取手机分类的值
  			var ma = $('#machineType').combobox('getText');
  			console.info("ma==="+ma);
  			var machineType = $('#machineType').combobox('getValues');
   			console.info("machineType==="+machineType);
  			
			//提交
			admin_goods_editForm.form(
				'submit',
				{
					url : 'goods/goodsAction!updateGoods.action?idList='+giftSelected+'&array='+arrayJSON+ '&machineType=' + machineType,
					
					onSubmit : function() {
						editor.sync();
 					},
					success : function(j) {
						try {
							
							j = $.parseJSON(j);
							
						} catch (e) {
							console.info(e);
							$.messager.alert('Warning','脚本错误,请重试!');
						}
						if (j.success) {
							$.messager.progress('close');
							$('#admin_goods_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								var subtitle = "商品列表";
								var url = "goods/goodsAction!toList.action";
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
									$('#tabs').tabs('select',subtitle);
									$('#admin_goods_datagrid').datagrid('load',{});
								}
								tabClose();
								$('#tabs').tabs('close','修改商品');
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
	 * 创建上传窗口 公共方法
	 * @param chunk 是否分割大文件
	 * @param callBack 上传成功之后的回调
	 */
	function UploaderForAdd(chunk, strId, callBack) {
		var editWin = $('<div style="overflow: hidden;"/>');
		var upladoer = $('<iframe/>');
		upladoer.attr({
			'src' :'imagesAction!toUpLoaderForAdd.action?chunk=' + chunk,
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
				callBack.call(this, files, thumbPaths, strId);
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
	/**
	 * 上传图片触发的事件
	 */
	function makerUploadForAdd(chunk, strId) {
		// 上传图片之前先校验单品编号是否为空
		var skuNum='list[' + strId + '].skuNum';
		var skuNumOb = $("input[name='" + skuNum + "']");
		if (checkSkuNum(skuNumOb) == false)
		{
			return;
		}
		//上传图片触发的事件
		UploaderForAdd(chunk, strId, function(files, thumbPaths, strId) {
		console.info('>>>>>'+strId);
			if (files && files.length > 0) {
				var showID = "admin_goods_add_thumbPic_" + strId;
				var admin_goods_add_thumbPic = document.getElementById(showID);
				var thumb = thumbPaths.join(",").split(",");
				for ( var i = 0; i < thumb.length; i++) {
					var img = document.createElement("img");
					img.setAttribute("id", sy.UUID());
					img.setAttribute('src', thumb[i]);
					img.style.height = '41px';
					img.style.width = '55px';
					img.style.marginRight = '10px';
					img.style.display = "inline";
					img.ondblclick = function() {
						goods_add_dropDom(this);
					};
					admin_goods_add_thumbPic.appendChild(img);
				};	
			};			
		});
	}
	/**
	 * 双击可删除图片
	 */
	function goods_add_dropDom(obj) {
		if (window.confirm("确定要删除该上传的图片?")) {
			//alert('$("#" + obj.id)==='+$("#" + obj.id)+'obj.id==='+obj.id);
			$("#" + obj.id).remove();
		}
	}
	
	/**
	 * 删除单品
	 */
	 var g=0;
	 function dropSku(obj){
	 	console.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始判断已经隐藏的table的个数>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		var id = $(obj).attr("id");	
		console.info("id==="+id); 
 		var tableNum = $("#admin_goods_edit_sku").children("table").length;//所有table个数
 		console.info("tableNum========="+tableNum);

		for(var t=0;t<tableNum;t++){
			var tableObj = $("#admin_goods_edit_sku").children("table")[t];//具体每个table
			var objNum = $(tableObj).find(obj).size();
			console.info("objNum===="+objNum);
			if(objNum>0){
				console.info("*******************开始删除*******************");
				if(tableNum>g && tableNum-g==1){
					alert("该单品不能删除，最少保留一个单品");
					return;
				}
				var flag = confirm("确定要删除该单品？");
				console.info("flag===="+flag);
				if(flag==true){
	
					var skuId = $(obj).parents("table").find("input").first().val();//当前table中第一个input
					console.info("根据skuId删除单品信息  skuId====="+skuId);
					if(skuId!=null){
						$.ajax({
							url:"sku/skuAction!dropGoodsSkuById.action",
							type:"POST",
							dataType:"JSON",
							data:{"sku.id":skuId},
							async : false,
							success : function(j) {
								if(j.success){
									$.messager.show({
										title : '提醒',
										msg : j.msg,
										timeout : 5000,
										showType : 'slide'
									});
									//清空input的值
/* 									 var inputCount = $(tableObj).find("input").length;console.info("inputCount:"+inputCount);
									for(var d=0;d<inputCount-1;d++){
										var inputObj = $(tableObj).find("input")[d];
										$(inputObj).val("");
									}  */   
									//修改isDelete的值为0  即已删除
									var inputName = 'list[' + t + '].isDelete';
									var inputNameObj = $("input[name='" + inputName + "']");
									inputNameObj.val('0');//设置成删除
									//把图片清空
									console.info("===>>>>>>>>>>>>>清空图片===>>>>>>>>>>>>>");
									var spanNum = $(tableObj).find("span").length;
									for(var f=0;f<spanNum;f++){
										var spanObj = $(tableObj).find("span")[f];
										var spanAttrValue = $(spanObj).attr("id");
										console.info("spanAttrValue===>>>>>"+spanAttrValue);
										if (spanAttrValue != undefined) {
											var imgNum = $(spanObj).find("img").length;
											console.info("imgNum====>>>>"+imgNum);
											if (imgNum > 0) {
												$(spanObj).empty();
											}
										} 
									}	
									$(tableObj).hide();
									alert("删除成功！");
									g++;
									console.info("g====="+g);	
								}else{
									$.messager.show({
										title : '提醒',
										msg : j.msg,
										timeout : 5000,
										showType : 'slide'
									});
								}
							}
						});
					}

				}else{
					console.info("cancel");
					return;
				} 
			}
		} 
	 }
	 /**
	  * 点击提交按钮时，判断某个具体table中的shelves的值如果是true（即上架）,那么获取相应的单价
	  * 如果单价为0，则提示其单价应该大于0
	  */
	  function priceCall(){
	  	var tableNum = $("#admin_goods_edit_sku").children("table").length;//点击提交按钮之前所有的table个数
	  	for(var t=0;t<tableNum;t++){
	  		//var tableObj = $("#admin_goods_add_sku").children("table")[t];//具体每个table
	  		var priceFlag = false;
	  		
	  		var shelves = 'list[' + t + '].shelves';
	  		var shelvesObj = $("select[name='" + shelves + "']");
	  		var shelvesValue = $(shelvesObj).val();
	  		console.info("shelvesValue:"+shelvesValue);
	  		
	  		var price = 'list[' + t + '].price';
	  		var priceObj = $("input[name='" + price + "']");
	  		var priceValue = $(priceObj).val();
	  		console.info("priceValue:"+priceValue);
			
			var priceValidObj = $(priceObj).next();
			
	  		if(shelvesValue!=undefined && shelvesValue == "true"){
	  			if(priceValue!=undefined &&priceValue!=null && priceValue!='' && priceValue==0){
	  				$(priceValidObj).text("请修改上架单品单价大于0！");
	  				$(priceValidObj).css("color", "#f00");
	  				alert("请修改上架单品单价大于0！");
	  				priceFlag = false;
	  				return priceFlag;
	  			}
	  		}
	  	}
	  }
	  /**
	   * 设置客户价格
	   */
	  //数组allResult 存放对象allParam
	  var allResult = [];
	  //对象allParam  封装单品规格代码skuValue和数组regionParam
	  var allParam={};
	  //数组regionParam 存放对象regionObj
	  var memberParam=[];
	  //对象regionObj 封装区域代码memberId和区域价格memberPrice
	  var memberObj={};
	  //区域代码
	  var memberId;
	  //区域价格 
	  var memberPrice;
	  var oldSkuId;//已保存的规格代码
	  var newSkuId;//将要保存的规格代码
	  
	  function setMemberPrice(obj){
	    var objattr= $(obj).attr("id");
	  	console.info("objattr==="+objattr);
	  	//截取最后一个字符m即数字
	  	var index = objattr.substring(objattr.length-1,objattr.length);
	  	console.info("index==="+index);
	  	//获取当前按钮所对应的单品id
  		var sId = 'list[' + index + '].id';	
    	var skuId= $("input[name='" + sId + "']").val();
    	console.info("skuId===》》》"+skuId);   	
    	if(skuId==null || skuId==undefined || skuId==""){
    		alert("修改页面新加单品暂不支持设置客户价格！");
    		return;
    	}
	  	$('<div/>').dialog({
			href : 'goods/goodsAction!toEditPrice.action?skuId='+skuId,//$.toJSON(paramObj);
			width : 1000,
			height : 800,
			modal : true,
			title : '设置客户价格',
			buttons : [{
				text : '绑定到单品',
				iconCls : 'icon-add',
				handler : function() {
				    goParam = $("#goParam").val();					
					//console.info("i'm add.jsp handler>>>>> "+goParam);
					goParam=$.parseJSON(goParam);//解析json
					console.info("解析之后：=========="+$.parseJSON(goParam));
					newSkuId=goParam["skuId"];
					console.info("newSkuId==="+newSkuId);
					if(overParam!=null && overParam.length>0){
						for(var i=0;i<overParam.length;i++){
							oldSkuId=overParam[i]["skuId"];
							console.info("oldSkuId==="+oldSkuId);
 							if(oldSkuId==newSkuId){
								overParam.splice(i, 1);
								break;
							}
 						}
					}
					overParam.push(goParam);
					$("#overParam").val($.toJSON(overParam));
					console.info(">>>>==="+$("#overParam").val());
					var d = $(this).closest('.window-body');
					d.dialog('destroy');
				}
			} ],
			onClose : function() {
 		    	$(this).dialog('destroy');
			}
		});
	  
	  }
	  
</script>

<div class="easyui-layout" data-options="fit:true,border:false"><!--<s:debug/><s:property value="a.id"/>-->
	<div data-options="region:'center',border:true,split:false">
		<form id="admin_goods_editForm" method="post">
		<input type="hidden" name="userId" value="<%=userId %>"/>
		<input type="hidden" id="id" name="id" value="${goods.id}"/>
		<div style="margin-left:70px;margin-top:15px;"><h2>商品信息修改:</h2></div>
		<div style="border:1px solid #ccc;width:80%;margin-left:70px;">			
			<table id="admin_goods_datagrid" class="tableForm" style="margin-top: 15px; width:100%">				
				<tr>
					<th>商品名称:</th>
					<td><input id="goodsName" name="name" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${goods.name}"/><div class="validate_msg_short" id="nameMsg"></div></td>
					<th>商品品牌:</th>
					<td>
						<span>
							<input id="brandId" name="brandId" class="easyui-combobox" 
							data-options="url:'goods/goodsAction!gainGoodsBrandName.action',valueField:'brandId',textField:'brandName',editable:false,multiple:false"style="width:160px" value="${goods.brandId }"/>
						</span>
					</td>
					<th>商品类别:</th>
					<td>
						<span>
							<input name="catId" class="easyui-combobox" 
							data-options="url:'goods/goodsAction!gainGoodsCatName.action',valueField:'catId',textField:'catName',editable:false,multiple:false"style="width:160px" value="${goods.catId}"/>
						</span>
					</td>
				</tr>
				<tr>		
					<th>手机类型:</th>
					<td>
					<input name="cellphoneType" style="width:160px;" value="${goods.cellphoneType}">
					</td>
					<th>手机分类:</th>
					<td><input id="machineType" name="machineType" class="easyui-combobox" style="width:160px" 
							data-options=
								"url:'admin/goods/machineType.json',
								method:'post',
								valueField:'id',
								textField:'text',
								multiple:true"
								/>
					</td>
					<th>分辨率:</th>
					<td>
					<s:select list="resolutionList" listValue="dictName" listKey="dictValue" name="goods.resolution" id="resolution"
           			cssStyle="width:160px" theme="simple" value="%{goods.resolution}">
           			</s:select> 
					</td>
				</tr>
				<tr>
					<th>电池类型:</th>
					<td><input name='batteryType' style="width:160px;" value="${goods.batteryType}"/></td>
					<th>电池容量:</th>
					<td><input name="batteryCapacity" style="width:160px" value="${goods.batteryCapacity}"/></td>
					<th>屏幕尺寸:</th>
					<td>
					<input type="number" id="screenSize" name="screenSize" style="width:80px" min="3.0" max="6.0" step="0.1" value="${goods.screenSize}"/>&nbsp;&nbsp;英寸
					<div id="screenSizeMsg"></div>
					</td>
				</tr>
				<tr>
					<th>操作系统:</th>
					<td>
					<s:select list="osList" listValue="dictName" listKey="dictValue" name="goods.operationSystem" id="operationSystem"
           			cssStyle="width:160px" theme="simple" value="%{goods.operationSystem}">
           			</s:select> 
					</td>
					<th>CPU核心数:</th>
					<td>
					<s:select list="cpuList" listValue="dictName" listKey="dictValue" name="goods.cpuNumber" id="cpuNumber"
           			cssStyle="width:160px" theme="simple" value="%{goods.cpuNumber}">
           			</s:select> 
					</td>
					<th>运行内存RAM:</th>
					<td>
						<s:select list="ramList" listValue="dictName" listKey="dictValue" name="goods.ram" id="ram"
            			cssStyle="width:160px" theme="simple" value="%{goods.ram}">
            			</s:select> 
					</td>
				</tr>
				<tr>
					<th>是否报价单热销:</th>
					<td>
						<select name="isQuotationHot" style="width:160px">
							<c:if test="${goods.isQuotationHot=='true'}">
								<option value="true" selected="selected">是报价单热销</option>
							</c:if>
							<option value="false">非报价单热销</option>
							<c:if test="${goods.isQuotationHot=='false'}">
								<option value="false" selected="selected">非报价单热销</option>
							</c:if>
							<option value="true">是报价单热销</option>
						</select>
					</td>
					<th>手机尺寸:</th>
					<td><input name='cellphoneSize' style="width:160px;" value="${goods.cellphoneSize}" /></td>
					<th>导航:</th>
					<td><input name="navigation" style="width:160px" value="${goods.navigation}" /></td>				
				</tr>
				<tr>
					<th>摄像头类型:</th>
					<td>
					<input name="cameraType" style="width:160px" value="${goods.cameraType}"/>
					</td>
					<th>前置摄像头:</th>
					<td><input name="frontCamera" style="width:160px" value="${goods.frontCamera}"/></td>
					<th>后置摄像头:</th>
					<td><input name="postCamera" style="width:160px" value="${goods.postCamera}" /></td>
				</tr>
				<tr>
					<th>屏幕技术 :</th>
					<td><input name="screenTechnology" style="width:160px" value="${goods.screenTechnology}"/></td>
					<th>屏幕像素密度:</th>
					<td><input name="sreenPixDensity" style="width:160px" value="${goods.sreenPixDensity}"/></td>
					<th>wlan功能:</th>
					<td><input name="wlanFunction" style="width:160px" value="${goods.wlanFunction}" /></td>
				</tr>
				<tr>
					<th>存储卡:</th>
					<td><input name='memoryCard' style="width:160px;" value="${goods.memoryCard}"/></td>
					<th>窄边框:</th>
					<td><input name='narrowFrame' style="width:160px;" value="${goods.narrowFrame}"/></td>
					<th>连接与共享 :</th>
					<td><input name="connectionShare" style="width:160px" value="${goods.connectionShare}"/></td>
				</tr>
				<tr>
					<th>用户界面:</th>
					<td><input name='userInterface' style="width:160px;" value="${goods.userInterface}" /></td>
					<th>扩展容量:</th>
					<td><input name="extendedCapacity" style="width:160px" value="${goods.extendedCapacity}"/></td>
					<th>三际天猫官方地址 :</th>
					<td><input name="tmallUrl" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${goods.tmallUrl}"/></td>
				</tr>
				<tr>
					<th>点击量:</th>
					<td><input id="clickRate" name="clickRate" style="width:160px" value="${goods.clickRate}" /><div id="clickRateMsg"></div></td>
					<th>gpu型号:</th>
					<td><input name="gpuModel" style="width:160px" value="${goods.gpuModel }"/></td>
					<th>理论待机时间:</th>
					<td><input name="theoryStandbyTime" style="width:160px" value="${goods.theoryStandbyTime}" /></td>
				</tr>
				<tr>
					<th>曝光日期:</th>
					<td><input type="hidden" value="${goods.exposure}"/>
					<input name="exposure" class="Wdate" onfocus="WdatePicker({dateFmt: 'yyyy-MM'})" value="${goods.exposure}" style="width:160px;"/>
					</td>
					<th>理论通话时间:</th>
					<td><input name='talkTime' style="width:160px;" value="${goods.talkTime}"/></td>
					<th>传感器类型:</th>
					<td>
					<input name="sensorType" style="width:160px" value="${goods.sensorType}"/>
					</td>
				</tr>
				<tr>
					<th>摄像头:</th>
					<td><input name='camera' style="width:160px;" value="${goods.camera}" /></td>
					<th>摄像头认证:</th>
					<td><input name='cameraCertification' style="width:160px;" value="${goods.cameraCertification}"/></td>
					<th>屏幕占比:</th>
					<td><input name='screenRatio' style="width:160px;" value="${goods.screenRatio}"/></td>				
				</tr>
				<tr>
					<th>闪光灯:</th>
					<td><input name="flashLamp" style="width:160px" value="${goods.flashLamp}"></td>
					<th>视频拍摄:</th>
					<td><input name='videoShoot' style="width:160px;" value="${goods.videoShoot}" /></td>
					<th>拍照功能:</th>
					<td><input name="shootFunction" style="width:160px" value="${goods.shootFunction}"/></td>
				</tr>
				<tr>
					<th>光圈:</th>
					<td><input name='aperture' style="width:160px;" value="${goods.aperture}"/></td>
					<th>焦距:</th>
					<td><input name="focalLength" style="width:160px" value="${goods.focalLength}"/></td>
					<th>特色:</th>
					<td><input name="cameraFeatures" style="width:160px" value="${goods.cameraFeatures}"/></td>
				</tr>
				<tr>
					<th>其他摄像头参数:</th>
					<td><input name='cameraOtherparams' style="width:160px;" value="${goods.cameraOtherparams}"/></td>
					<th>造型设计:</th>
					<td><input name="modelDesign" style="width:160px" value="${goods.modelDesign}"/></td>
					<th>手机重量:</th>
					<td><input id="weight" name='weight' style="width:150px;" value="${goods.weight}"/>&nbsp;g
					<div id="weightMsg"></div></td>
				</tr>
				<tr>
					<th>机身特点:</th>
					<td><input name="bodyFeatures" style="width:160px" value="${goods.bodyFeatures}"/></td>
					<th>操作类型:</th>
					<td><input name="operationType" style="width:160px" value="${goods.operationType}"/></td>
					<th>感应器类型:</th>
					<td><input name='outSensorType' style="width:160px;" value="${goods.outSensorType}"/></td>
				</tr>
				<tr>
					<th>sim卡类型:</th>
					<td><input name="simType" style="width:160px" value="${goods.simType}"/></td>
					<th>机身接口:</th>
					<td><input name='bodyInterface' style="width:160px;" value="${goods.bodyInterface}"/></td>
					<th>机身材质:</th>
					<td><input name="bodyMaterial" style="width:160px" value="${goods.bodyMaterial}"/></td>
				</tr>
				<tr>
					<th>音频支持:</th>
					<td><input name="audioSupport" style="width:160px" value="${goods.audioSupport}" /></td>
					<th>视频支持:</th>
					<td><input name='videoSupport' style="width:160px;" value="${goods.videoSupport}"/></td>
					<th>图片支持:</th>
					<td><input name="imgSupport" style="width:160px" value="${goods.imgSupport}" /></td>
				</tr>
				<tr>
					<th>常用功能:</th>
					<td><input name='commonFunctions' style="width:160px;" value="${goods.commonFunctions}" /></td>
					<th>商务功能:</th>
					<td><input name="businessFunctions" style="width:160px" value="${goods.businessFunctions}" /></td>
					<th>包装清单:</th>
					<td><input name="optionalAccessory" style="width:160px" value="${goods.optionalAccessory}" /></td>
				</tr>
				<tr>
					<th>保修政策:</th>
					<td><input name='warrantyPolicy' style="width:160px;" value="${goods. warrantyPolicy}"/></td>
					<th>质保时间:</th>
					<td><input id="warrantyTime" name="warrantyTime" style="width:150px" value="${goods.warrantyTime}" />&nbsp;年<div id="warrantyTimeMsg"></div></td>
					<th>质保备注:</th>
					<td><input name='warrantyRemark' style="width:160px;" value="${goods.warrantyRemark}"/></td>
				</tr>
				<tr>
					<th>客服电话:</th>
					<td><input name="servicePhone" style="width:160px" value="${goods.servicePhone }" /></td>
					<th>电话备注:</th>
					<td><input name="phoneRemark" style="width:160px" value="${goods.phoneRemark}" /></td>
					<th>详细内容:</th>
					<td><input name='detailContents' style="width:160px;" value="${goods.detailContents}"/></td>
				</tr>
				<tr>
					<th>cpu型号:</th>
					<td><input name='cpuModel' style="width:160px;" value="${goods.cpuModel}" /></td>
					<th>CPU频率:</th>
					<td><input name="cpuRate" style="width:160px" value="${goods.cpuRate}" /></td>
					<th>触摸屏类型:</th>
					<td><input name="touchscreenType" style="width:160px" value="${goods.touchscreenType}"/></td>
				</tr> 
				<tr>		
					<th>商品详情:</th>	
					<td colspan="9"><textarea name='goodsDetail' id="admin_goods_add_textarea" style="width:60%;height:50px;">${goods.goodsDetail}</textarea></td>					
				</tr>
			</table>
			</div>
			<div>
				<!-- 数据库中已存的节点数据 -->
				<input type="hidden" id="rpList" value="rpList" />
<%-- 				<c:forEach items="${rpList}" var="rp" varStatus="status">
					<input type="text" id="orignalData" value="${rp.regionsId}"/>
				</c:forEach>				
 --%> 			
 				<input type="hidden" name="paramObj" id="paramObj" /><!-- 传向edit.jsp页面的参数 -->
 				<input type="hidden" id="goParam"/><!-- 每次从editPrice.jsp页面传来的参数 -->
				<input type="hidden" id="overParam" name="overParam"/><!-- 最终的所有参数 -->
			</div>
		    <div style="margin-left:70px;"><h2>单品信息修改:</h2></div>
		    <div id="admin_goods_edit_sku" style="border:1px solid #ccc;width:80%;margin-left:70px;">
		    <c:forEach items="${list}" var="gs" varStatus="status">	
			    <div id="machine" style="display:none"  >${gs.machineType}</div> <!-- style="display:none" -->
				<table id="admin_goods_edit_sku_table" class="tableForm" style="margin-top: 15px; width:100%">
					<tr>
						<th></th>
						<td><input id = "list[${status.index}]_sId" name="list[${status.index}].id" type="hidden" value="${gs.id}"/></td>
					</tr>	
					<tr>
						<th>商品代码:</th>
						<td><input id = "skuCode" name="list[${status.index}].skuCode" onblur="checkSkuCode(this)" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.skuCode}"/><div class="validate_msg_short" id="skuCodeMsg"></div></td>
						<th>规格代码: </th>
						<td><input id="skuNum" name="list[${status.index}].skuNum" onblur="checkSkuNum(this)" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.skuNum}"/><div class="validate_msg_short" id="skuNumMsg"></div></td>
						<th>库存:</th>
						<td><input name="list[${status.index}].stock" onblur="validStock(this)"  class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.stock}"/><div class="validate_msg_short" id="skuStock"></div>
					</tr>
					<tr>
						<th>单价:</th>
						<td><input id="skuPricesb" name="list[${status.index}].price" onblur="validPrice(this,'单价')" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.price}"/><div class="validate_msg_short" id="skuPrice"></div></td>
						<th>原价:</th>
						<td><input name="list[${status.index}].originalPrice" onblur="validPrice(this,'原价')" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.originalPrice}"/><div class="validate_msg_short" id="skuOriginalPrice"></div></td>
						<!-- <div class="validate_msg_short" id="skuTmallPriceMsg"></div> -->
						<th>天猫价:</th><!-- onblur="validPrice(this,'天猫价')"  class="easyui-validatebox" data-options="required:true" -->
						<td><input name="list[${status.index}].tmallPrice" style="width:160px" value="${gs.tmallPrice}"/></td>
					</tr>
					<tr>
						<th>颜色:</th>
						<td>						
						<span id="span_color_m">
							<input name="list[${status.index}].colorId" class="easyui-combobox" value="${gs.colorId}"
							data-options="url:'goods/goodsAction!gainSkuColorName.action',valueField:'colorId',textField:'colorName',editable:false,multiple:false"style="width:160px"/>
						</span>
						</td>
						<th>制式:</th>
						<td>
	          				<select name="list[${status.index}].standard" style="width:160px">
	          					<option value="${gs.standard}" selected="selected">${gs.standard}</option>
								<option value="联通2G">联通2G</option>
								<option value="联通3G">联通3G</option>
								<option value="联通4G">联通4G</option>
								<option value="移动2G">移动2G</option>
								<option value="移动3G">移动3G</option>
								<option value="移动4G">移动4G</option>
								<option value="电信2G">电信2G</option>
								<option value="电信3G">电信3G</option>
								<option value="电信4G">电信4G</option>
								<option value="双2G">双2G</option>
								<option value="双3G">双3G</option>
								<option value="双4G">双4G</option>
								<option value="全网通">全网通</option>
								<option value="全网通">无</option>
							</select>
						</td>
						<th>是否上架:</th>
						<td>
						<select name="list[${status.index}].shelves" style="width:140px">
							<c:if test="${gs.shelves=='true'}">　
							<option value="true" selected="selected">上架</option>  
							</c:if>
							<option value="false">下架</option>  
							<c:if test="${gs.shelves=='false'}">　
							<option value="false" selected="selected">下架</option>  
							</c:if>
							<option value="true">上架</option>  
						</select>
						</td>	
					</tr>
					<tr>
						<th>网络类型:</th>
						<td>
						<span id="span_netsuit_m">
							<input id="netsuitType" name="list[${status.index}].netsuitType" class="easyui-combobox" value="${gs.netsuitType}" style="width:160px"
							data-options=
								"url:'admin/goods/netsuitType.json',
								 method:'post',
								 valueField:'id',
								 textField:'text',
								 editable:true,
								 multiple:true"/>
						</span>						
						</td>		
						<th>浮动数量:</th>
						<td>
							<input name="list[${status.index}].changeNum" onblur="validChangeNum(this)" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.changeNum}"/><div></div>
						</td>
						<th>浮动价格:</th>
						<td>
							<input name="list[${status.index}].changePrice" onblur="validChangePrice(this,'变动的价格')" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.changePrice}"/><div></div>
						</td>
					</tr>
					<tr>
						<th>网络模式</th>
						<td>
							<select name="list[${status.index}].netModel" style="width:160px">
								<option value = "${gs.netModel}" selected="selected">${gs.netModel}</option>
								<option value = "单卡单模">单卡单模</option>
								<option value = "单卡多模">单卡多模</option>
								<option value = "双卡双模">双卡双模</option>
								<option value = "双卡双待">双卡双待</option>
							</select>	
						</td>
						<th>3G网络:</th>
						<td><input name="list[${status.index}].networkThree" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.networkThree}"/></td>
						<th>4G网络:</th>
						<td><input name="list[${status.index}].networkFour" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.networkFour}"/></td>
					</tr>
					<tr>
						<th>机身内存:</th>
						<td><input name="list[${status.index}].storage" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.storage}"/></td>
						<th>版本:</th>
						<td><input name="list[${status.index}].edition" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.edition}"/></td>
						<th>支持频段:</th>
						<td><input name="list[${status.index}].supportChannel" class="easyui-validatebox" data-options="required:true" style="width:160px" value="${gs.supportChannel}"/></td>					
					</tr>												
					<tr>
						<th>添加图片:</th>
						<td colspan="5">
							<span> 																
								<a id="a_m" class="easyui-linkbutton" href="javascript:makerUploadForAdd(false,${status.index})">选择图片</a>&nbsp;&nbsp;&nbsp;
								<label style="color: red"></label> 
							</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							 <span id="admin_goods_add_thumbPic_m">	
							 <c:if test="${!empty gs.picList[0].picSrc}">
							 	 <c:forEach items = "${gs.picList}" var="ppp" varStatus="status1">			 							
		 							<img id="img_n" width = '55px' height = '41px' src="${ppp.picSrc}" onclick="goods_add_dropDom(this)" />		 							
								</c:forEach>
							 </c:if>
							 </span>
						</td>
					</tr> 
					<tr>
					  	<th></th>
						<td><input type="button" id="admin_goods_set_${status.index}" onclick="setMemberPrice(this)" style="width:100px" value="设置客户价格"/>&nbsp;&nbsp;&nbsp;
						</td>				
						<th colspan="1"></th>
						<td colspan="1">
							<input type="hidden" name="list[${status.index}].isDelete" value="${gs.isDelete}" />
						</td>
						<th colspan="1"></th>
						<td colspan="1">
						<input type="button" id="admin_goods_delete_m" onclick="dropSku(this)" style="width:100px" value="删除"/>
						</td>
					</tr>
				</table>
			</c:forEach>	
			<div style="text-align:left;margin-left:80px;margin-top:30px;" id="admin_goods_add_sku_operator">
				<input type="button" id="admin_goods_add_on" style="width:100px" value="继续添加" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" id="admin_goods_minus_on" style="width:100px" value="取消添加" />	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>	
			</div>
			<div style="margin-left:70px;"><h2>赠品信息修改:</h2></div>		
			<div>
			<div style="margin-left:70px;height: 300px;width:80%;background-color: #f1f1f1;"id="admin_goods_add_uninGoods_div" >
				<div class="easyui-layout" data-options="fit:true,border:true"style="background-color: #e1e1e1;border: 1px solid #e1e1e1">
					<div data-options="region:'center',border:false">
						<div class="easyui-layout" data-options="fit:true,border:false">
							<div data-options="region:'north',border:false" style="background-color: #f1f1f1;height:33px">
								<div style="padding: 3px">
									<span>
									<label>赠品编号:</label><input id="admin_goods_edit_searchBn" />&nbsp;
									<label>赠品名称:</label><input id="admin_goods_edit_searchName" />&nbsp; 
									<input type="button" id="admin_goods_edit_searchButton" value="查询" />
									</span>
								</div>
							</div>
							<div data-options="region:'center',border:false">
								<table id="admin_goods_edit_uninGoods_left" style="width:60%">
									<thead>
										<tr>
											<th data-options="field:'id',width:80,checkbox:true">赠品ID</th>
											<th
												data-options="field:'name',width:80,sortable:true,formatter:function(value, row, index){
												var s = '<span title='+value+'>' + value + '</span>';
												return s;
											}">赠品名称</th>
											<th data-options="field:'accessoriesNum',width:80,sortable:true">赠品编号</th>
											<th data-options="field:'price',width:80,sortable:true">赠品单价</th>
											<th data-options="field:'brandName',width:80,sortable:true">赠品品牌</th>
										    <th data-options="field:'catName',width:80,sortable:true">赠品类别</th>
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
								<h1 align="center">已选择赠品</h1>
							</div>
							<div data-options="region:'center',border:true">
								<table id="admin_goods_edit_uninGoods_right">
									<thead>
										<tr>
											<th data-options="field:'id',width:50,checkbox:true">赠品ID</th>
											<th data-options="field:'accessoriesNum',width:70,sortable:true">赠品编号</th>
											<th data-options="field:'name',width:80,sortable:true,formatter:function(value, row, index){var s = '<span title='+value+'>' + value + '</span>'; return s;}">赠品名称</th>

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
			
			<div style="left; width:400px;height:400px;margin-left:80px;">
				<div style="float:left;margin-top:15px;"><input type="button" id="admin_goods_edit_save" value="保存" /></div>
			</div>	
					 
		 </div> 	
		 
		</form>
	</div>
</div>


