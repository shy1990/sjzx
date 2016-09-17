<%@ page language="java" import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sanji.sjzx.common.util.ResourceUtil"%>
<%@page import="com.sanji.sjzx.pojo.SessionInfo"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String basePath = PathUtil.getPath(request);
	SessionInfo sessionInfo = (SessionInfo) request.getSession()
			.getAttribute(ResourceUtil.getSessionInfoName());
	String userId = sessionInfo.getUserId();
%>
<script type="text/javascript">
	var goParam;
	var overParam=[];
	$(document).ready(
		function addTab(subtitle, url, icon){
			var tabCount = $('#tabs').tabs('tabs').length;//获取当前打开窗口总数量
			var hasTab = $('#tabs').tabs('exists', '添加商品(抓取外链)'); //根据名称判断窗口是否已打开
			//console.info("tabCount====="+tabCount);
			if(hasTab){
				$.messager.alert('提示','添加商品页面只能打开一个!','info');
				tabClose();
				$('#tabs').tabs('close', '添加商品(手动录入)');
			}
			if (tabCount > 3 && !hasTab) { 
				$.messager.alert('提示','您当前打开商品页面太多，如果继续打开，会造成程序运行缓慢，无法流畅操作!','info');
				tabClose();
				$('#tabs').tabs('close', '添加商品(手动录入)');
	    	 }
		 }
	);
	var m = 0;
	var array = new Array();
	var arrayJSON;
 	var flag = true;
 	
 	//添加下一个单品前，校验前一个单品信息是否符合条件
 	function validPreTable()
 	{
 		var tableNum = $("#admin_goods_add_sku").children("table").length;
		var index = tableNum - 1;
		var skuCode = 'list[' + index + '].skuCode';
		var skuNum = 'list[' + index + '].skuNum';
		var price = 'list[' + index + '].price';
		var originalPrice = 'list[' + index + '].originalPrice';
		//var tmallPrice = 'list[' + index + '].tmallPrice';
		var stock = 'list[' + index + '].stock';
		var colorId = 'list[' + index + '].colorId';
		
		skuCodeOb = $("input[name='" + skuCode + "']");
		skuNumOb = $("input[name='" + skuNum + "']");
		priceOb = $("input[name='" + price + "']");
		originalPriceOb = $("input[name='" + originalPrice + "']");
		//tmallPriceOb = $("input[name='" + tmallPrice + "']");
		stockOb = $("input[name='" + stock + "']");
		colorIdOb = $("input[name='" + colorId + "']");
		
		if(checkSkuCode(skuCodeOb) == false){
			$(skuCodeOb).focus();
			return false;
		}
		
		if (checkSkuNum(skuNumOb) == false) {
			//alert("单品编号验证未通过！");
			$(skuNumOb).focus();
			return false;
		}

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

/* 		if (validPrice(tmallPriceOb,'天猫价') == false) {
			//alert("请输入单品天猫价！");	
			$(tmallPriceOb).focus();
			return false;
		} */

		if (colorIdOb.val() == null || colorIdOb.val() == 'undefined' || colorIdOb.val() == '') {
		 alert("请选择单品颜色！");
		 return false;
		} 

		if (validStock(stockOb) == false) {
			//alert("请输入单品库存！");	
			$(stockOb).focus();
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
		var skuNameAttr = $(obj).attr("name");
		if (skuCode == null || skuCode == "") {
			$(skuCodeMsgObj).text("商品代码不能为空！");
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
/* 		var tableNum = $("#admin_goods_add_sku").children("table").length;
		for ( var tabIndex = 0; tabIndex < tableNum; tabIndex++) {
			var tableObj = $("#admin_goods_add_sku").children("table")[tabIndex];
			var tdObj = $(tableObj).find("input")[0];

			var tdValue = $(tdObj).val();
			var tdNameValue = $(tdObj).attr("name");
			if (skuNameAttr != tdNameValue && skuCode == tdValue) {
				$(skuCodeMsgObj).text("商品代码不能重复");
				$(skuCodeMsgObj).css("color", "#f00");
				skuCodeFlag = false;
				return skuCodeFlag;
			}
		}
		//发送同步请求给skuCodeValidate 
		$.ajax({
			url : "goods/goodsAction!skuCodeValidate.action",
			type : "POST",
			dataType : "JSON",
			data : {
				"sku.skuCode" : skuCode
			},
			async : false,
			success : function(j) {
				if (j.success) {
					//如果返回值为true，则校验通过
					$(skuCodeMsgObj).text("ok");
					$(skuCodeMsgObj).css("color", "#00f");
					skuCodeFlag = true;
				} else {
					//如果返回值为false，则校验不通过
					$(skuCodeMsgObj).text("此商品代码已存在");
					$(skuCodeMsgObj).css("color", "#f00");
					skuCodeFlag = false;
				}
			}
		}); */
		return skuCodeFlag;
 	}
 	
	//验证单品编号是否存在和重复
	function checkSkuNum(obj) {
		var skuNumFlag = false;
		//取得文本框的值
		var skuNumMsgObj = $(obj).next();
		var skuNum = $(obj).val();
		var skuNameAttr = $(obj).attr("name");
		if (skuNum == null || skuNum == "") {
			$(skuNumMsgObj).text("商品规格代码不能为空！");
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
 		var tableNum = $("#admin_goods_add_sku").children("table").length;
		for ( var tabIndex = 0; tabIndex < tableNum; tabIndex++) {
			var tableObj = $("#admin_goods_add_sku").children("table")[tabIndex];
			var tdObj = $(tableObj).find("input")[1];

			var tdValue = $(tdObj).val();
			var tdNameValue = $(tdObj).attr("name");
			if (skuNameAttr != tdNameValue && skuNum == tdValue) {
				$(skuNumMsgObj).text("商品规格代码不能重复");
				$(skuNumMsgObj).css("color", "#f00");
				skuNumFlag = false;
				return skuNumFlag;
			}
		} 
		//发送同步请求给skuNumValidate 
 		$.ajax({
			url : "goods/goodsAction!skuNumValidate.action",
			type : "POST",
			dataType : "JSON",
			data : {
				"sku.skuNum" : skuNum
			},
			async : false,
			success : function(j) {
				if (j.success) {
					//如果返回值为true，则校验通过
					$(skuNumMsgObj).text("ok");
					$(skuNumMsgObj).css("color", "#00f");
					skuNumFlag = true;
				} else {
					//如果返回值为false，则校验不通过
					$(skuNumMsgObj).text("此商品规格代码已存在");
					$(skuNumMsgObj).css("color", "#f00");
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
	//var stockReg=/^-?(0|[1-9]\d+)$/;
	var stockReg=/^\d+$/;
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
	//整体控制
	$(function() {
		var admin_goods_addForm = $('#admin_goods_addForm');
		var admin_goods_add_save = $('#admin_goods_add_save');
		var admin_goods_add_uninGoods_left = $('#admin_goods_add_uninGoods_left');
		var admin_goods_add_uninGoods_right = $('#admin_goods_add_uninGoods_right');
		var admin_goods_add_uninGoods_select = $('#admin_goods_add_uninGoods_select');
		var admin_goods_add_uninGoods_unselect = $('#admin_goods_add_uninGoods_unselect');
		var admin_goods_add_uninGoods_delSelect = $('#admin_goods_add_uninGoods_delSelect');
		var admin_goods_add_searchButton = $('#admin_goods_add_searchButton');
		var admin_goods_add_on = $('#admin_goods_add_on');
		var admin_goods_add_sku_table = $('#admin_goods_add_sku_table');
		var admin_goods_minus_on = $('#admin_goods_minus_on');
		var goodsName = $('#goodsName');
		
		var screenSize = $('#screenSize');
		var clickRate = $('#clickRate');
		var weight = $('#weight');
		var warrantyTime = $('#warrantyTime');
		
		var i = 0;

		/**
		 * 商品关联左边datagrid
		 */
		admin_goods_add_uninGoods_left.datagrid({
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
		admin_goods_add_uninGoods_right.datagrid({
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
		admin_goods_add_searchButton.bind('click', function() {
			admin_goods_add_uninGoods_left.datagrid('load', {
				name : $('#admin_goods_add_searchName').val(),
				accessoriesNum : $('#admin_goods_add_searchBn').val(),

			});
		});

		/**
		 * 选择
		 */
		admin_goods_add_uninGoods_select
				.bind(
						'click',
						function() {
							var admin_goods_add_uninGoods_left_data = admin_goods_add_uninGoods_left.datagrid('getChecked');
							var admin_goods_add_uninGoods_right_hasSelect = admin_goods_add_uninGoods_right.datagrid('getRows');
							var lh = admin_goods_add_uninGoods_left_data.length;
							var rh = admin_goods_add_uninGoods_right_hasSelect.length;
							//alert("左边数据的个数1h==="+lh);
							//alert("右边数据的个数rh==="+rh);
/* 							if(lh>1){//如果左边选择的行记录大于1，那么提示只能选一个赠品
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
								}else{//如何右边没有数据，那么可以添加赠品*/
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
											admin_goods_add_uninGoods_right.datagrid(
													'insertRow', {
														row : e
													});
										}
									}
							//	}
							//} 
			
							
						});
		/**
		 * 取消选择
		 */
		admin_goods_add_uninGoods_unselect.bind('click', function() {
			admin_goods_add_uninGoods_left.datagrid('uncheckAll').datagrid(
					'unselectAll').datagrid('clearSelections');
		});
		/**
		 * 删除右边已选择
		 */
		admin_goods_add_uninGoods_delSelect.bind('click', function() {
			var rows = admin_goods_add_uninGoods_right.datagrid('getChecked');
			for ( var i = 0; i < rows.length; i++) {
				admin_goods_add_uninGoods_right.datagrid('deleteRow',
						admin_goods_add_uninGoods_right.datagrid('getRowIndex',
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
				items : [ 'source', '|', 'undo', 'redo', '|', 'preview',
						'print', 'template', 'code', 'cut', 'copy', 'paste',
						'plainpaste', 'wordpaste', '|', 'justifyleft',
						'justifycenter', 'justifyright', 'justifyfull',
						'insertorderedlist', 'insertunorderedlist', 'indent',
						'outdent', 'subscript', 'superscript', 'clearhtml',
						'quickformat', 'selectall', '|', 'fullscreen', '/',
						'formatblock', 'fontname', 'fontsize', '|',
						'forecolor', 'hilitecolor', 'bold', 'italic',
						'underline', 'strikethrough', 'lineheight',
						'removeformat', '|', 'image', 'flash', 'media',
						'insertfile', 'table', 'hr', 'emoticons', 'baidumap',
						'pagebreak', 'anchor', 'link', 'unlink' ],
				uploadJson : 'up!upload.action'
			});
		}, 1);

		/**
		 *判断商品名称是否存在
		 */
 		goodsName.blur(function() {
			validGoodsName();
		});

		function validGoodsName() {

			var goodsNameFlag = false;
			//取得文本框的值
			var goodsName = $("#goodsName").val();
			if (goodsName == null || goodsName == "") {
				$("#nameMsg").text("商品名称不能为空！");
				$("#nameMsg").css("color", "#f00");
				goodsNameFlag = false;
				return goodsNameFlag;
			}else{
				$("#nameMsg").text("ok");
				$("#nameMsg").css("color", "#00f");
				goodsNameFlag = true;
				return goodsNameFlag;
			}
			//发送同步请求给goodsNameValidate 
/* 			$.ajax({
				url : "goods/goodsAction!goodsNameValidate.action",
				type : "POST",
				dataType : "JSON",
				data : "name=" + goodsName,
				async : false,
				success : function(j) {
					if (j.success) {
						//如果返回值为true，则校验通过
						$("#nameMsg").text("ok");
						$("#nameMsg").css("color", "#00f");
						goodsNameFlag = true;
					} else {
						//如果返回值为false，则校验不通过
						$("#nameMsg").text("此商品名称已存在");
						$("#nameMsg").css("color", "#f00");
						goodsNameFlag = false;
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
		
		//加载完所有节点之后
		$(document)
				.ready(
						function() {
							//console.info("m===="+m);
							var tableNum1 = $("#admin_goods_add_sku").children("table").length;
							var tableObj1 = $("#admin_goods_add_sku").children("table")[tableNum1 - 1];
							var spanNum1 = $(tableObj1).find("span").length;
							for ( var n = 0; n < spanNum1; n++) {
								var spanObj1 = $(tableObj1).find("span")[n];
								var spanAttrValue1 = $(spanObj1).attr("id");
								if (spanAttrValue1 != undefined) {
									var modifyAttrValue1 = spanAttrValue1.replace(/\_\m/, "_" + m);
									$(spanObj1).attr("id", modifyAttrValue1);
								}
							}
							var inputNum1 = $(tableObj1).find("input").length;
							for(var h=0;h<inputNum1;h++){
								var inputObj1 = $(tableObj1).find("input")[h];
								var inputAttrValue1 = $(inputObj1).attr("id");
								if(inputAttrValue1 !=undefined){
									var modifyAttrValue1 = inputAttrValue1.replace(/\_\m/, "_" + m);
									$(inputObj1).attr("id",modifyAttrValue1);
								}
							}							
						
							
						});
		/**
		 * 继续添加单品
		 */
		admin_goods_add_on
				.bind('click',
						function() {
						
							//复制之前判断前一个单品信息
							if (validPreTable() == false)
							{
								return;
							}
						
							//复制table
							admin_goods_add_sku_table.clone().insertBefore(admin_goods_add_sku_operator);
							
							var tableNum = $("#admin_goods_add_sku").children("table").length;//复制之后所有的table个数
							var tableObj = $("#admin_goods_add_sku").children("table")[tableNum - 1];//复制之后最后一个table
							$(tableObj).show();
							var tdNum = $(tableObj).find("input").length;

							//复制之后把当前倒数第二个table里面的a标签隐藏
/* 							var tableObj2 = $("#admin_goods_add_sku").children("table")[tableNum - 2];
							var aNum = $(tableObj2).find("a").length;
							for(var aa=0;aa<aNum;aa++){
								var aNumObj = $(tableObj2).find("a")[aa];
								$(aNumObj).css("display","none");
							}  */
							//清空复制之后的提示信息
							var divNum = $(tableObj).find("div").length;
							for (var divN = 0; divN < divNum; divN++)
							{
								var skuNumMsgObj = $(tableObj).find("div")[divN];
								$(skuNumMsgObj).text("");
							}	
							
							i++;
							m++;
							//复制之后控制每个table中的a标签属性
							var aObj = $(tableObj).find("a")[0];
							var aObjIdValue = $(aObj).attr("id");
							if(aObjIdValue != undefined){
								$(aObj).attr("id","a_"+m);
								$(aObj).attr("href",'javascript:makerUploadForAdd(false,'+m+')');
							}	
							var spanNum = $(tableObj).find("span").length;
							//console.info("spanNum>>>>>>>"+spanNum);
							//console.info("------------------------------------------------------------");
							//复制后控制颜色、图片父节点、网络类型span的id属性
 							var spanObj1 = $(tableObj).find("span")[0];//具体第一个span是color的父节点
							var spanAttrValue1 = $(spanObj1).attr("id");
							//console.info("spanAttrValue1===>>>>>"+spanAttrValue1);
							if (spanAttrValue1 != undefined) {
								var newStr1 = spanAttrValue1.substr(0,spanAttrValue1.length - 1);
								var modifyAttrValue1 = newStr1 + m;
								//console.info("modifyAttrValue1:"+modifyAttrValue1);
								$(spanObj1).attr("id", modifyAttrValue1);
								var inputNum = $(spanObj1).find("input").length;
								//console.info("颜色对象的个数"+inputNum);
								if(inputNum>0){
									$(spanObj1).empty();
									var span_color =document.getElementById(modifyAttrValue1);
									//console.info("span_color==="+span_color);
									var input = document.createElement("input");
									$(input).attr("id","colorId_"+m);
									$(input).attr("name","list["+m+"].colorId");
									$(input).attr("class","easyui-combobox");
									$(input).css("width","160px");
									span_color.appendChild(input);	
								} 
							}
							//console.info("jjjjjjjjj------------------------------------------------------------");
							var spanNum = $(tableObj).find("span").length;
							//console.info("***  spanNum==="+spanNum);
						for(var j=1;j<2;j++){
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
						for(var j=2;j<11;j++){
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
 					  	   $("#colorId_"+m).combobox({
								url:'goods/goodsAction!gainSkuColorName.action',
								valueField:'colorId',
								textField:'colorName',
								editable:false,
								multiple:false
							});  
 							$("#netsuitId_"+m).combobox({
								url:'admin/goods/netsuitType.json',
								valueField:'id',
								textField:'text',
								editable:true,
								multiple:true
							});  
							//console.info("控制当前table中的input的list[index]^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");	
							for ( var index = 0; index < tdNum; index++) {
								var tdObj = $(tableObj).find("input")[index];
								var attrValue = $(tdObj).attr("name");
								if (attrValue != undefined) {
									var modifyValue = attrValue.replace(/list\[\w\]/, "list[" + i + "]");
									$(tdObj).attr("name", modifyValue);
									$(tdObj).val("");
								}																
							}
							//控制当前table中的isDelete 的input
							var t = tableNum - 1;//下标
							//console.info("t========>>>"+t);
							var inputName = 'list[' + t + '].isDelete';
							var inputNameObj = $("input[name='" + inputName + "']");
							inputNameObj.val('1');//设置成删除
							
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
							
							//控制当前table中的select
							var tdSelectObj = $(tableObj).find("select")[0];
							var tdSelectObj1 = $(tableObj).find("select")[1]; 
							var tdSelectObj2 = $(tableObj).find("select")[2];
							//var tdSelectObj3 = $(tableObj).find("select")[3];
							
							var tdSelectValue = $(tdSelectObj).attr("name");
							var tdSelectValue1 = $(tdSelectObj1).attr("name");
							var tdSelectValue2 = $(tdSelectObj2).attr("name");
							//var tdSelectValue3 = $(tdSelectObj3).attr("name");
							
							if (tdSelectValue != undefined) {
								var modifyValue = tdSelectValue.replace(/list\[\w\]/, "list[" + i + "]");
								$(tdSelectObj).attr("name", modifyValue);
							}
							if(tdSelectValue1!=undefined){
								var modifyValue1 = tdSelectValue1.replace(/list\[\w\]/, "list[" + i + "]");
								$(tdSelectObj1).attr("name", modifyValue1);
							}
							if(tdSelectValue2!=undefined){
								var modifyValue2 = tdSelectValue2.replace(/list\[\w\]/, "list[" + i + "]");
								$(tdSelectObj2).attr("name", modifyValue2);
							}
/* 							if(tdSelectValue3!=undefined){
								var modifyValue3 = tdSelectValue3.replace(/list\[\w\]/, "list[" + i + "]");
								$(tdSelectObj3).attr("name", modifyValue3);
							} */
							
							//控制当前table中设置地域价格按钮的id
							//console.info("****************控制当前table中设置地域价格按钮的id***************");
							var count = $(tableObj).find("input").length;
							//console.info("count==="+count);
							var tdObj2 = $(tableObj).find("input")[18];//当前table中最后一个input的前一个input
							//console.info("tdObj2===="+tdObj2);
							var attrValue2 = $(tdObj2).attr("id");
							//console.info("attrValue2====>>>>>>"+attrValue2);//admin_goods_set_m
							if(attrValue2 != undefined){
								//console.info("i====>>>>>>"+i);
								var modifyValue2 = attrValue2.substr(0,attrValue2.length-1)+i;
								//console.info("modifyValue2====>>>>>>"+modifyValue2);
								$(tdObj2).attr("id",modifyValue2);
								//console.info("id===>>>>>"+$(tdObj2).attr("id"));
							}
							
							var tdObj3 = $(tableObj).find("input")[19];//当前table中最后一个input的前一个input
							//console.info("tdObj3===="+tdObj3);
							var attrValue3 = $(tdObj3).attr("id");
							//console.info("attrValue3====>>>>>>"+attrValue3);//admin_goods_set_m
							if(attrValue3 != undefined){
								//console.info("i====>>>>>>"+i);
								var modifyValue3 = attrValue3.substr(0,attrValue3.length-1)+i;
								//console.info("modifyValue3====>>>>>>"+modifyValue3);
								$(tdObj3).attr("id",modifyValue3);
								//console.info("id===>>>>>"+$(tdObj3).attr("id"));
							}
							
							var tdObj4 = $(tableObj).find("input")[20];//当前table中最后一个input的前一个input
							//console.info("tdObj4===="+tdObj4);
							var attrValue4 = $(tdObj4).attr("id");
							//console.info("attrValue4====>>>>>>"+attrValue4);//admin_goods_set_m
							if(attrValue4 != undefined){
								//console.info("i====>>>>>>"+i);
								var modifyValue4 = attrValue4.substr(0,attrValue4.length-1)+i;
								//console.info("modifyValue4====>>>>>>"+modifyValue4);
								$(tdObj4).attr("id",modifyValue4);
								//console.info("id===>>>>>"+$(tdObj4).attr("id"));
							}
							
							
						});
		/**
		 * 取消添加单品
		 */
		admin_goods_minus_on.bind('click', function() {
			if (i > 0) {
				i--;
				m--;
				var num = $("#admin_goods_add_sku").children("table").length;
				var obj = $("#admin_goods_add_sku").children("table")[num - 1];
/* 				if(num>0&&num<=1){
					alert("最少保留一个单品");
					return;
				} */
				$(obj).remove();
				//点击取消添加的时候,给该div中最后一个table中的a标签设置为display值inline
/* 				var newNum = $("#admin_goods_add_sku").children("table").length;
				var tableObj = $("#admin_goods_add_sku").children("table")[newNum - 1];
				var aNum = $(tableObj).find("a").length;
				for(var n=0;n<aNum;n++){
					var aObj = $(tableObj).find("a")[n];
					$(aObj).css("display","inline");
				} */
			}
		});
		/**
		 *商品保存按钮
		 */
		admin_goods_add_save.bind('click', function() {

 			if (validGoodsName() == false) {
				$("#nameMsg").text("商品名称校验未通过");
				$("#nameMsg").css("color", "#f00");
				$("#goodsName").focus();
				return;
			}

			var brandId = $("input[name='brandId']").val();
 			if (brandId == null || brandId == undefined || brandId == '') {
				$("#brandMsg").text("请选择商品品牌！");
				alert("请选择商品品牌！");
				$("#brandMsg").css("color", "#f00");
				$("#brandMsg").focus();
				return;
			}else{
				$("#brandMsg").text("ok");
				$("#brandMsg").css("color", "#00f");
			}

			var catId = $("input[name='catId']").val();
			if (catId == null || catId == undefined || catId == '') {
				$("#catMsg").text("请选择商品类别！");
				alert("请选择商品类别！");
				$("#catMsg").css("color", "#f00");
				$("#catMsg").focus();
				return;
			}else{
				$("#catMsg").text("ok");
				$("#catMsg").css("color", "#00f");
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
			if (validPreTable() == false)
			{
				return;
			}
			if(priceCall() == false){
				return;
			}
			//页面赠品值
			var giftSelected = [];
			var rows = admin_goods_add_uninGoods_right.datagrid('getRows');
			for ( var ii = 0; ii < rows.length; ii++) {
				giftSelected.push(rows[ii].id);
			}
			
			//处理图片	 admin_goods_add_thumbPic_m
			var tableNum = $("#admin_goods_add_sku").children("table").length;//table个数
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
				for(var t=0;t<imgNum;t++){
					var imgObj = $(admin_goods_add_thumbPic).find("img")[t];//具体某张图片
					var imgSrc = $(imgObj).attr("src");
					//console.info("imgObj==="+imgObj+"  imgSrc==="+imgSrc);
					if(imgSrc!=null && imgSrc!=undefined && imgSrc!=""){
						imgSrcs.push(imgSrc);
					}
					//console.info("$$$$$$$$$$imgSrcs==="+imgSrcs);
				} 
				obj["skuNum"]=skuNum;
				obj["imgs"]=imgSrcs;
				if(imgSrcs.length>0){
					array.push(obj);
					arrayJSON = $.toJSON(array);
					//console.info("arrayJSON=="+arrayJSON);
				}
			}		
  			//console.info("arrayJSON>>>>>>=="+arrayJSON);
  			//获取手机分类的值
    		//var machineType = $('#machineType').combobox('getText');
    		var machineType = $('#machineType').combobox('getValues');
   			//console.info("machineType==="+machineType);
			//提交
			admin_goods_addForm.form('submit', {
				url : 'goods/goodsAction!addGoods.action?idList='
						+ giftSelected 
						+ '&machineType=' + machineType
						+ '&array=' + arrayJSON,
						 
				onSubmit : function() {
					editor.sync();
				},
				success : function(json) {
					try {
						j = $.parseJSON(json);
					} catch (e) {
						$.messager.alert('Warning', '脚本错误,请重试!');
					}
					if (j.success) {
						$.messager.progress('close');
						$('#admin_goods_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
						var subtitle = "商品列表";
						var url = "goods/goodsAction!toGoodsList.action";
						//console.info("url???????????"+url);
						//var url = "goods/goodsAction!toList.action";
						var icon = "icon icon-em_list";
						if (!$('#tabs').tabs('exists', subtitle)) {
							$('#tabs').tabs('add', {
								title : subtitle,
								href : url,
								closable : true,
								icon : icon
							});
						} else {
							$('#tabs').tabs('select', subtitle);
							$('#admin_goods_datagrid').datagrid('load', {});
						}
						tabClose();
						$('#tabs').tabs('close', '添加商品(手动录入)');
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
	 */
	function UploaderForAdd(chunk, strId, callBack) {
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
		
		UploaderForAdd(chunk, strId, function(files, thumbPaths, strId) {
			
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
			$("#" + obj.id).remove();
		}
	}
	/**
	 * 删除单品
	 */
	 var j=0;
	 function dropSku(obj){
	 	//console.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始判断已经隐藏的table的个数>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		var id = $(obj).attr("id");	
		//console.info("id==="+id); 
 		var tableNum = $("#admin_goods_add_sku").children("table").length;//所有table个数
 		//console.info("tableNum========="+tableNum);

		for(var t=0;t<tableNum;t++){
			var tableObj = $("#admin_goods_add_sku").children("table")[t];//具体每个table
			var objNum = $(tableObj).find(obj).size();
			//console.info("objNum===="+objNum);
			if(objNum>0){
				//console.info("*******************开始删除*******************");
				if(tableNum>j && tableNum-j==1){
					alert("该单品不能删除，最少保留一个单品");
					return;
				}
				var flag = confirm("确定要删除该单品？");
				//console.info("flag===="+flag);
				if(flag==true){
					//清空input的值
 					var inputNum = $(tableObj).find("input").length;
					for(var u=0;u<inputNum;u++){
						var inputObj = $(tableObj).find("input")[u];
						$(inputObj).val("");
					} 
					
					var inputName = 'list[' + t + '].isDelete';
					var inputNameObj = $("input[name='" + inputName + "']");
					inputNameObj.val('0');//设置成删除
					
					var buttId  = 'admin_goods_delete_'+t;
					var buttObj = document.getElementById(buttId);
					$(buttObj).val('删除');
					//把图片清空
					//console.info("===>>>>>>>>>>>>>清空图片===>>>>>>>>>>>>>");
					var spanNum = $(tableObj).find("span").length;
					for(var f=0;f<spanNum;f++){
						var spanObj = $(tableObj).find("span")[f];
						var spanAttrValue = $(spanObj).attr("id");
						//console.info("spanAttrValue===>>>>>"+spanAttrValue);
						if (spanAttrValue != undefined) {
							var imgNum = $(spanObj).find("img").length;
							//console.info("imgNum====>>>>"+imgNum);
							if (imgNum > 0) {
								$(spanObj).empty();
							}
						} 
					}
					$(tableObj).hide();
					alert("删除成功！");
					j++;
					//console.info("j===="+j);
				}else{
					//console.info("cancel");
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
	  	var tableNum = $("#admin_goods_add_sku").children("table").length;//点击提交按钮之前所有的table个数
	  	for(var t=0;t<tableNum;t++){
	  		
	  		var priceFlag = false;
	  		
	  		var shelves = 'list[' + t + '].shelves';
	  		var shelvesObj = $("select[name='" + shelves + "']");
	  		var shelvesValue = $(shelvesObj).val();
	  		//console.info("shelvesValue:"+shelvesValue);
	  		
	  		var price = 'list[' + t + '].price';
	  		var priceObj = $("input[name='" + price + "']");
	  		var priceValue = $(priceObj).val();
	  		//console.info("priceValue:"+priceValue);
			
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
	   * 设置地域价格
	   */
	  //数组allResult 存放对象allParam
	  var allResult = [];
	  //对象allParam  封装单品规格代码skuValue和数组regionParam
	  var allParam={};
	  //数组regionParam 存放对象regionObj
	  var regionParam=[];
	  //对象regionObj 封装区域代码regionCode和区域价格regionPrice
	  var regionObj={};
	  //区域代码
	  var regionCode;
	  //区域价格 
	  var regionPrice;
	  var oldSku;//已保存的规格代码
	  var newSku;//将要保存的规格代码
 	  function toSet(obj){
	  	//获取当前按钮的id
	  	var objattr= $(obj).attr("id");
	  	//console.info("objattr==="+objattr);
	  	//截取最后一个字符m即数字
	  	var index = objattr.substring(objattr.length-1,objattr.length);
	  	//console.info("index==="+index);
	  	//获取当前按钮所对应的单品规格代码
  		var skuNum = 'list[' + index + '].skuNum';	
    	var skuValue= $("input[name='" + skuNum + "']").val();
    	//console.info("skuValue==="+skuValue);
    	if(skuValue==null || skuValue ==undefined ||skuValue==""){
    		alert("请填写正确的规格代码才能进行地域价格设置！");
    		return;
    	}else{
    		alert("设置地域价格之后，如果修改规格代码，那么重新设置地域价格！");
    	}
	  	//遍历overParam终结数组 用于显示
	  	var oneParam;//封装当前单品skuValue所对应的区域代码
	  	if(overParam!=null && overParam.length>0){
	  		for (var i=0; i<overParam.length; i++){
		    	if (overParam[i].index == index){
		    		oneParam=overParam[i].result;
		    		//console.info("oneParam==="+oneParam);
		    	}
	    	}
	  	}
	    //paramObj该对象用于传递到addPrice.jsp页面把该单品skuValue的区域代码对应的价格显示在自定义插件文本上
	    //skuValue:单品唯一标识，oneParam:用于显示树结构显示（单品skuValue所对应的区域代码和浮动价格）
	    var paramObj = {index:index, skuValue:skuValue, oneParam:oneParam};
	    $("#paramObj").val($.toJSON(paramObj));
	    
	    //?paramObj='+$.toJSON(paramObj)
	   // console.info("paramObj===="+paramObj);
	  	$('<div/>').dialog({
			href : 'goods/goodsAction!toAddPrice.action',//$.toJSON(paramObj);
			width : 560,
			height : 700,
			modal : true,
			title : '添加地域价格',
			buttons : [ {
				text : '绑定到单品',
				iconCls : 'icon-add',
				handler : function() {
					//数组overParam保存一个对象之前，先解析数组获取单品规格代码
					//该单品规格代码用来和要保存的新对象中的单品规格代码进行比较
					//解析新接收的goParam
   					goParam = $("#goParam").val();					
					//console.info("i'm add.jsp handler>>>>> "+goParam);
					goParam=$.parseJSON(goParam);//解析json
					//console.info("解析之后："+goParam);
					newIndex = goParam["index"];
					//console.info("newIndex==="+newIndex);
					if(overParam!=null && overParam.length>0){
						for(var i=0;i<overParam.length;i++){
							oldIndex =overParam[i]["index"];
							//console.info("oldIndex ==="+oldIndex);
 							if(oldIndex==newIndex){
								overParam.splice(i, 1);
								break;
							}
 						}
					}
					overParam.push(goParam);
					//console.info("overParam==="+overParam);
					$("#overParam").val($.toJSON(overParam));
					//console.info(">>>>==="+$("#overParam").val());
/* 					if(overParam !=null && overParam.length>0){
						for(var i=0;i<overParam.length;i++){
							console.info(overParam[i]["skuValue"]+"  "+ overParam[i]["result"]);
						}
					}
 */					var d = $(this).closest('.window-body');
					d.dialog('destroy');
				}
			} ],
			onClose : function() {
 		    	$(this).dialog('destroy');
			}
		});
	  }  
	  
	  
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
	<!--<s:debug />
	<s:property value="a.id" />-->
	<div data-options="region:'center',border:true,split:false">
		<form id="admin_goods_addForm" method="post" action="">
			<input type="hidden" name="userId" value="<%=userId%>" />
			<input type="hidden" name="paramObj" id="paramObj"/>
			<div style="margin-left:70px;margin-top:15px;">
				<h2>商品信息添加:</h2>
			</div>
			<div style="border:1px solid #ccc;width:80%;margin-left:70px;">
				<table id="admin_goods_add_datagrid" class="tableForm"
					style="margin-top: 15px; width:100%;">
					<tr>
						<th><font color="#FF0000">*</font>商品名称:</th>
						<td><input id="goodsName" name="name"
							class="easyui-validatebox" data-options="required:true"
							style="width:160px" placeholder="请输入商品名称" />
							<div class="validate_msg_short" id="nameMsg"></div>
						</td>
						<th><font color="#FF0000">*</font>商品品牌:</th>
						<td><span> <input id="brandId" name="brandId"
								class="easyui-combobox"
								data-options="url:'goods/goodsAction!gainGoodsBrandName.action',valueField:'brandId',textField:'brandName',editable:false,multiple:false"
								style="width:160px" /> </span><div class="validate_msg_short" id="brandMsg"></div></td>
						<th><font color="#FF0000">*</font>商品类别:</th>
						<td><span> <input id="catId" name="catId"
								class="easyui-combobox"
								data-options="url:'goods/goodsAction!gainGoodsCatName.action',valueField:'catId',textField:'catName',editable:false,multiple:false"
								style="width:160px" /> </span><div class="validate_msg_short" id="catMsg"></div></td>
					</tr>
					<tr>
						<th>手机类型:</th>
						<td><input name="cellphoneType" style="width:160px;"placeholder="请输入手机类型"/>
						</td>
						<th>手机分类:</th>
						<td><input id="machineType" class="easyui-combobox" style="width:160px"
								data-options=
									"url:'admin/goods/machineType.json',
									method:'post',
									valueField:'id',
									textField:'text',
									editable:true,
									multiple:true"/>
						</td>
						<th>分辨率:</th>
						<td>
						<select name="resolution" style="width:160px">
						    <option value="无">无</option>
							<option value="2k">2k</option>
							<option value="720p">720p</option>
							<option value="1080p">1080p</option>
							<option value="128x128">128x128像素</option>
							<option value="160x128">160x128像素</option>
							<option value="220x176">220x176像素</option>
							<option value="320x240">320x240像素</option>
							<option value="480x320">480x320像素</option>
							<option value="800x480">800x480像素</option>
							<option value="854x480">854x480像素</option>
							<option value="960x540" selected="selected">960x540像素</option>
							<option value="960x640">960x640像素</option>
							<option value="1280x800">1280x800像素</option>
							<option value="1334×750">1334×750像素</option>
							<option value="1136x640">1136x640像素</option>
							<option value="1920X1152">1920X1152像素</option>
							<option value="1920X1200">1920X1200像素</option>
							<option value="2560×1440">2560×1440像素</option>
							<option value="2048x1536">2048x1536像素</option>
							<option value="1024x600">1024x600像素</option>
							<option value="1024x768">1024x768像素</option>
							<option value="1920x1080">1920x1080像素</option>
							<option value="1280x720">1280×720像素</option>
						</select>
						</td>
					</tr>
					<tr>
						<th>电池类型:</th>
						<td><input name='batteryType' style="width:160px;"
							placeholder="请输入电池类型" />
						</td>
						<th>电池容量:</th>
						<td><input name="batteryCapacity" style="width:160px"
							placeholder="请输入电池容量" />
						</td>
						<th>屏幕尺寸:</th>
						<td>
						<input id="screenSize" type="number" name="screenSize" min="3.0"max="6.0"step="0.1" value="4.5" style="width:80px"/>&nbsp;&nbsp;英寸
						<div id="screenSizeMsg"></div>
						</td>
					</tr>
					<tr>
						<th>操作系统:</th>
						<td>
						<select name="operationSystem" style="width:160px">
							<option value="Android5.0" selected="selected">Android5.0</option>
							<option value="Android4.4">Android OS 5.1</option>
							<option value="Android4.4">Android4.4</option>
							<option value="Android4.3">Android4.3</option>
							<option value="Android4.2">Android4.2</option>
							<option value="Android4.1">Android4.1</option>
							<option value="Android OS">Android OS</option>
							<option value="Android OS6.0">Android OS6.0</option>
							<option value="Android OS">Android</option>
							<option value="iOS6">iOS6</option>
							<option value="iOS7">iOS7</option>
							<option value="iOS8">iOS8</option>
							<option value="iOS9">iOS9</option>
							<option value="Windows phone 8">Windows phone 8</option>
							<option value="Windows phone 8.1">Windows phone 8.1</option>
							<option value="Windows 10">Windows 10</option>
							<option value="Symbian/塞班">Symbian/塞班</option>
							<option value="nubia UI 2.0 V5">nubia UI 2.0 V5</option>
							<option value="Flyme 4.1">Flyme 4.1</option>
							<option value="MIUI 7">MIUI 7</option>
							<option value="Flyme 5.0">Flyme 5.0</option>
							<option value="Flyme 5.1">Flyme 5.1</option>
							<option value="MIUI">MIUI</option>
							<option value="Nucleus">Nucleus</option>
							<option value="YunOS ">YunOS </option>
							<option value="其他">其他</option>
							<option value="无">无</option>
						</select>
						</td>
						<th>CPU核心数:</th>
						<td>
						<select name="cpuNumber" style="width:160px">
							<option value="无">无</option>
							<option value="单核">单核</option>
							<option value="双核">双核</option>
							<option value="3核">3核</option>
							<option value="4核" selected="selected">4核</option>
							<option value="6核">6核</option>
							<option value="8核">8核</option>
							<option value="8核">10核</option>
							<option value="16核">16核</option>
						</select>
						</td>
						<th>运行内存RAM:</th>
						<td>
							<select name="ram" style="width:160px">
								<option value="无">无</option>
								<option value="6GB">6GB</option>
								<option value="4GB">4GB</option>
								<option value="3GB">3GB</option>
								<option value="2GB" selected="selected">2GB</option>
								<option value="1.5GB">1.5GB</option>
								<option value="1GB">1GB</option>
								<option value="768MB">768MB</option>
								<option value="512MB">512MB</option>
								<option value="256MB">256MB</option>
								<option value="64MB">64MB</option>
								<option value="32MB">32MB</option>
								<option value="4MB">4MB</option>
								<option value="128MB">128MB</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>是否报价单热销:</th>
						<td>
							<select name="isQuotationHot" style="width:160px">
								<option value="true">是报价单热销</option>
								<option value="false" selected="selected">非报价单热销</option>
							</select>
						</td>
						<th>手机尺寸:</th>
						<td><input name='cellphoneSize' style="width:160px;"
							placeholder="请输入手机尺寸" />
						</td>
						<th>导航:</th>
						<td><input name="navigation" style="width:160px"
							placeholder="请输入导航信息" />
						</td>
					</tr>
					<tr>
						<th>摄像头类型:</th>
						<td>
						<input type="text" name="cameraType" style="width:160px" placeholder="请输入摄像头类型"/>
						</td>
						<th>前置摄像头:</th>
						<td><input name="frontCamera" style="width:160px"
							placeholder="请输入前置摄像头信息" />
						</td>
						<th>后置摄像头:</th>
						<td><input name="postCamera" style="width:160px"
							placeholder="请输入后置摄像头信息" />
						</td>
					</tr>
					<tr>
						<th>屏幕技术 :</th>
						<td><input name="screenTechnology" style="width:160px"
							placeholder="请输入屏幕技术" />
						</td>
						<th>屏幕像素密度:</th>
						<td><input name="sreenPixDensity" style="width:160px"
							placeholder="请输入屏幕像素密度" />
						</td>
						<th>wlan功能:</th>
						<td><input name="wlanFunction" style="width:160px"
							placeholder="请输入wlan功能信息" />
						</td>
					</tr>
					<tr>
						<th>存储卡:</th>
						<td><input name='memoryCard' style="width:160px;"
							placeholder="请输入存储卡信息" />
						</td>
						<th>窄边框:</th>
						<td><input name='narrowFrame' style="width:160px;"
							placeholder="请输入窄边框信息" />
						</td>
						<th>连接与共享 :</th>
						<td><input name="connectionShare" style="width:160px"
							placeholder="请输入连接与共享信息" />
						</td>
					</tr>
					<tr>
						<th>用户界面:</th>
						<td><input name='userInterface' style="width:160px;"
							placeholder="请输入用户界面" />
						</td>
						<th>扩展容量:</th>
						<td><input name="extendedCapacity" style="width:160px"
							placeholder="请输入扩展容量" />
						</td>
						<th>三际天猫官方地址 :</th>
						<td><input name="tmallUrl" style="width:160px"
							placeholder="请输入三际天猫官方地址" />
						</td>

					</tr>
					<tr>
						<th>点击量:</th>
						<td><input id="clickRate" name="clickRate" style="width:160px"
							placeholder="请输入点击量信息" /><div id="clickRateMsg"></div>
						</td>
						<th>gpu型号:</th>
						<td><input name="gpuModel" style="width:160px"
							placeholder="请输入GUP型号" />
						</td>						<th>理论待机时间:</th>
						<td><input name="theoryStandbyTime" style="width:160px"
							placeholder="请输入理论待机时间" />
						</td>
					</tr>
					<tr>
						<th>曝光日期:</th>
						<td><!-- class="easyui-my97" <s:date name="exposureDate" format="yyyy-MM" /> id="admin_starttime" --> 
						 
						<input name="exposure" class="Wdate" onfocus="WdatePicker({dateFmt: 'yyyy-MM'})" />
						
						</td>
						<th>理论通话时间:</th>
						<td><input name='talkTime' style="width:160px;"
							placeholder="请输入理论通话时间" />
						</td>
						<th>传感器类型:</th>
						<td><input name="sensorType" style="width:160px;"placeholder="请输入传感器类型" /></td>
					</tr>
					<tr>
						<th>摄像头:</th>
						<td><input name='camera' style="width:160px;"
							placeholder="请输入摄像头简介" />
						</td>
						<th>摄像头认证:</th>
						<td><input name='cameraCertification' style="width:160px;"
							placeholder="请输入摄像头认证信息" />
						</td>
						<th>屏幕占比:</th>
						<td><input name='screenRatio' style="width:160px;"
							placeholder="请输入屏幕占比" />
						</td>
					</tr>
					<tr>
						<th>闪光灯:</th>
						<td><input name="flashLamp" style="width:160px"
							placeholder="请输入闪光灯信息" />
						</td>
						<th>视频拍摄:</th>
						<td><input name='videoShoot' style="width:160px;"
							placeholder="请输入视频拍摄信息" />
						</td>
						<th>拍照功能:</th>
						<td><input name="shootFunction" style="width:160px"
							placeholder="请输入拍照功能信息" />
						</td>
					</tr>
					<tr>
						<th>光圈:</th>
						<td><input name='aperture' style="width:160px;"
							placeholder="请输入光圈信息" />
						</td>
						<th>焦距:</th>
						<td><input name="focalLength" style="width:160px"
							placeholder="请输入焦距信息" />
						</td>
						<th>特色:</th>
						<td><input name="cameraFeatures" style="width:160px"
							placeholder="请输入摄像头特色信息" />
						</td>
					</tr>
					<tr>
						<th>其他摄像头参数:</th>
						<td><input name='cameraOtherparams' style="width:160px;"
							placeholder="请输入其他摄像头参数信息" />
						</td>
						<th>造型设计:</th>
						<td><input name="modelDesign" style="width:160px"
							placeholder="请输入造型设计信息" />
						</td>
						<th>手机重量:</th>
						<td><input id="weight" name='weight' style="width:150px;"
							placeholder="请输入手机重量" />&nbsp;g<div id="weightMsg"></div>
						</td>
					</tr>
					<tr>
						<th>机身特点:</th>
						<td><input name="bodyFeatures" style="width:160px"
							placeholder="请输入机身特点信息" />
						</td>
						<th>操作类型:</th>
						<td><input name="operationType" style="width:160px"
							placeholder="请输入操作类型信息" />
						</td>
						<th>感应器类型:</th>
						<td><input name='outSensorType' style="width:160px;"
							placeholder="请输入感应器类型信息" />
						</td>
					</tr>
					<tr>
						<th>sim卡类型:</th>
						<td><input name="simType" style="width:160px"
							placeholder="请输入sim卡类型信息" />
						</td>
						<th>机身接口:</th>
						<td><input name='bodyInterface' style="width:160px;"
							placeholder="请输入机身接口信息" />
						</td>
						<th>机身材质:</th>
						<td><input name="bodyMaterial" style="width:160px"
							placeholder="请输入机身材质信息" />
						</td>
					</tr>
					<tr>
						<th>音频支持:</th>
						<td><input name="audioSupport" style="width:160px"
							placeholder="请输入音频支持信息" />
						</td>
						<th>视频支持:</th>
						<td><input name='videoSupport' style="width:160px;"
							placeholder="请输入视频支持信息" />
						</td>
						<th>图片支持:</th>
						<td><input name="imgSupport" style="width:160px"
							placeholder="请输入图片支持信息" />
						</td>
					</tr>
					<tr>
						<th>常用功能:</th>
						<td><input name='commonFunctions' style="width:160px;"
							placeholder="请输入常用功能" />
						</td>
						<th>商务功能:</th>
						<td><input name="businessFunctions" style="width:160px"
							placeholder="请输入商务功能" />
						</td>
						<th>包装清单:</th>
						<td><input name="optionalAccessory" style="width:160px"
							placeholder="请输入包装清单信息" />
						</td>
					</tr>
					<tr>
						<th>保修政策:</th>
						<td><input name='warrantyPolicy' style="width:160px;"
							placeholder="请输入保修政策信息" />
						</td>
						<th>质保时间:</th>
						<td><input id="warrantyTime" name="warrantyTime" style="width:150px"
							placeholder="请输入质保时间" />&nbsp;年<div id="warrantyTimeMsg"></div>
						</td>
						<th>质保备注:</th>
						<td><input name='warrantyRemark' style="width:160px;"
							placeholder="请输入质保备注信息" />
						</td>
					</tr>
					<tr>
						<th>客服电话:</th>
						<td><input name="servicePhone" style="width:160px"
							placeholder="请输入客服电话息" />
						</td>
						<th>电话备注:</th>
						<td><input name="phoneRemark" style="width:160px"
							placeholder="请输入电话备注信息" />
						</td>
						<th>详细内容:</th>
						<td><input name='detailContents' style="width:160px;"
							placeholder="请输入详细内容" />
						</td>
					</tr>
					<tr>
						<th>cpu型号:</th>
						<td><input name='cpuModel' style="width:160px;"placeholder="请输入CPU型号" />
						</td>
						<th>CPU频率:</th>
						<td><input name="cpuRate" style="width:160px" placeholder="请输入CPU频率" /></td>
						<th>触摸屏类型:</th>
						<td><input name="touchscreenType" style="width:160px"
							placeholder="请输入触摸屏类型" />
						</td>
					</tr>
				</table>
			</div>
			<div style="margin-left:70px;">
				<h2>单品信息添加:</h2>
			</div>
			<div>
				<input type="hidden" id="goParam"/><!-- 每次从addPrice.jsp页面传来的参数 -->
 				<input type="hidden" id="overParam" name="overParam"/><!-- 最终的所有参数 -->
			</div>
			<div id="admin_goods_add_sku"
				style="border:1px solid #ccc;width:80%;margin-left:70px;">
				<table id="admin_goods_add_sku_table"
					style="margin-top: 15px;width:100%;">
					<tr>
						<th><font color="#FF0000">*</font>商品代码:</th>
						<td><input id="skuCode" 
							name="list[0].skuCode" onblur="checkSkuCode(this)" class="easyui-validatebox"
							data-options="required:true" style="width:160px"
							placeholder="请输入商品代码" />
							<div class="validate_msg_short" id="skuCodeMsg"></div>
						</td>
						<th><font color="#FF0000">*</font>规格代码:</th>
						<td><input id="skuNum" 
							name="list[0].skuNum" onblur="checkSkuNum(this)" class="easyui-validatebox"
							data-options="required:true" style="width:160px"
							placeholder="请输入商品规格代码" />
							<div class="validate_msg_short" id="skuNumMsg"></div>
						</td>
						<th><font color="#FF0000">*</font>库存:</th>
						<td><input name="list[0].stock" onblur="validStock(this)" class="easyui-validatebox"
							data-options="required:true" style="width:160px"
							placeholder="请输入库存数量" /><div class="validate_msg_short"></div>
						</td>
					</tr>
					<tr>
						<th><font color="#FF0000">*</font>单价:</th>
						<td><input name="list[0].price" onblur="validPrice(this,'单价')" class="easyui-validatebox"
							data-options="required:true" style="width:160px"
							placeholder="请输入单价" /><div class="validate_msg_short"></div>
						</td>
						<th>原价:</th>
						<td><input name="list[0].originalPrice" onblur="validPrice(this,'原价')"
							class="easyui-validatebox" data-options="required:true"
							style="width:160px" placeholder="请输入原价" /><div class="validate_msg_short"></div>
						</td>
						<th>天猫价:</th><!-- onblur="validPrice(this,'天猫价')" -->
						<td><input name="list[0].tmallPrice" 
							class="easyui-validatebox" data-options="required:true"
							style="width:160px" placeholder="请输入天猫价" /><div class="validate_msg_short"></div>
						</td>
					</tr>
					<tr>
				    <th><font color="#FF0000">*</font>颜色:</th>
					<td>
					<span id="span_color_m">
						<input id="colorId" name="list[0].colorId" class="easyui-combobox" 
						data-options="url:'goods/goodsAction!gainSkuColorName.action',valueField:'colorId',textField:'colorName',editable:false,multiple:false"style="width:160px"/>
					</span>
					</td>
					<th>制式:</th>
						<td>
						<select name="list[0].standard" style="width:160px">
							<option value="联通2G">联通2G</option>
							<option value="联通3G">联通3G</option>
							<option value="联通4G">联通4G</option>
							<option value="移动2G">移动2G</option>
							<option value="移动3G">移动3G</option>
							<option value="移动4G" selected="selected">移动4G</option>
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
						<td><select name="list[0].shelves" style="width:160px">
								<option value='true' selected="selected">上架</option>
								<option value='false'>下架</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>网络类型:</th>
						<td>
						<span id="span_netsuit_m">
							<input id="netsuitType" name="list[0].netsuitType" class="easyui-combobox" style="width:160px"
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
							<input name="list[0].changeNum" data-options="required:true" style="width:160px" placeholder="请输入浮动数量" />
						</td>
						<th>浮动价格:</th>
						<td>
							<input name="list[0].changePrice" data-options="required:true" style="width:160px" placeholder="请输入浮动价格" />
						</td>
					</tr>
					<tr>
						<th>网络模式:</th>
						<td>
							<select name="list[0].netModel" style="width:160px">
								<option value = "单卡单模">单卡单模</option>
								<option value = "单卡多模">单卡多模</option>
								<option value = "双卡双模">双卡双模</option>
								<option value = "双卡双待" selected="selected">双卡双待</option>
							</select>	
						</td>
						<th>3G网络:</th>
						<td><input name="list[0].networkThree"
							data-options="required:true" style="width:160px"
							placeholder="请输入3G网络 " />
						</td>
						<th>4G网络:</th>
						<td><input name="list[0].networkFour"
							data-options="required:true" style="width:160px"
							placeholder="请输入4G网络 " />
						</td>
					</tr>
					<tr>
						<th>机身内存:</th>
						<td><input id="shelves" name="list[0].storage"
							data-options="required:true" style="width:160px"
							placeholder="请输入机身内存" />
						</td>
						<th>版本:</th>
						<td><input name="list[0].edition"
							data-options="required:true" style="width:160px"
							placeholder="请输入版本号" />
						</td>
						<th>支持频段:</th>
						<td>
						<input name="list[0].supportChannel"
							data-options="required:true" style="width:160px"
							placeholder="请输入支持频段 " />
						</td>
					</tr>
					<tr>
						<th>添加图片:</th>
						<td colspan="5">
							<span>
								<a id="a_0" href="javascript:makerUploadForAdd(false,0)" class="easyui-linkbutton">选择图片</a>&nbsp;&nbsp;
								<label style="color: red"></label>
							</span><br/><br/>
							<span id="admin_goods_add_thumbPic_m"></span>
						</td>
					</tr>
					<tr>
  						<th></th>
						<td><input type="button" id="admin_goods_set_m" onclick="toSet(this)" style="width:100px" value="设置地域价格"/>&nbsp;&nbsp;&nbsp;
						</td>				
 						<th></th>
						<td><input type="hidden" name="list[0].isDelete" value="1" /></td>
						<th></th>
						<td><input type="button" id="admin_goods_delete_m" onclick="dropSku(this);" style="width:100px" value="删除"/></td>
					</tr>
				</table>
				<div style="text-align:left;margin-left:100px;margin-top:30px;"
					id="admin_goods_add_sku_operator">
					<input type="button" id="admin_goods_add_on" style="width:100px" value="继续添加" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" id="admin_goods_minus_on" style="width:100px" value="取消添加" />
				</div>

			</div>
			<div style="margin-left:70px;">
				<h2>赠品信息添加:</h2>
			</div>
			<div>
				<div
					style="margin-left:70px;height: 300px;width:80%;background-color: #f1f1f1;"
					id="admin_goods_add_uninGoods_div">
					<div class="easyui-layout" data-options="fit:true,border:true"
						style="background-color: #e1e1e1;border: 1px solid #e1e1e1">
						<div data-options="region:'center',border:false">
							<div class="easyui-layout" data-options="fit:true,border:false">
								<div data-options="region:'north',border:false"
									style="background-color: #f1f1f1;height:33px">
									<div style="padding: 3px">
										<span> <label>赠品编号:</label><input
											id="admin_goods_add_searchBn" />&nbsp; <label>赠品名称:</label><input
											id="admin_goods_add_searchName" />&nbsp; <input
											type="button" id="admin_goods_add_searchButton" value="查询" />
										</span>
									</div>
								</div>
								<div data-options="region:'center',border:false">
									<table id="admin_goods_add_uninGoods_left" style="width:60%">
										<thead>
											<tr>
												<th data-options="field:'id',width:80,checkbox:true">赠品ID</th>
												<th data-options="field:'name',width:80,sortable:true,formatter:function(value, row, index){var s = '<span title='+value+'>' + value + '</span>'; return s;}">赠品名称</th>
												<th data-options="field:'accessoriesNum',width:80,sortable:true">赠品编号</th>
												<th data-options="field:'brandName',width:80,sortable:true">赠品品牌</th>
												<th data-options="field:'catName',width:80,sortable:true">赠品类别</th>
											</tr>
										</thead>
									</table>
								</div>
								<div data-options="region:'south',border:false"
									style="height: 25px;background-color: #e1e1e1">
									<input type="button" id="admin_goods_add_uninGoods_select"
										style="margin-right: 50px;float: right" value="选择" /> <input
										type="button" id="admin_goods_add_uninGoods_unselect"
										style="margin-right: 50px;float: right" value="取消选择" />
								</div>
							</div>
						</div>
						<div data-options="region:'east',border:false"
							style="width:400px;">
							<div class="easyui-layout" data-options="fit:true,border:false">
								<div data-options="region:'north',border:false"
									style="height: 33px;background-color:#f1f1f1;">
									<h1 align="center">已选择赠品</h1>
								</div>
								<div data-options="region:'center',border:true">
									<table id="admin_goods_add_uninGoods_right">
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
									<input type="button" id="admin_goods_add_uninGoods_delSelect"
										style="margin-right: 50px;float: right" value="剔除已选择" />
								</div>
							</div>
						</div>

					</div>
				</div>

				<div style="width:700px;height:350px;float:left;margin-left:70px;">

					<h2>商品详情:</h2>
					<div style="height:350px;width:680px;">
						<textarea name='goodsDetail' id="admin_goods_add_textarea"></textarea>
					</div>
				</div>

				<div
					style="float:right; width:100px;height:350px;margin-right:650px;">
					<div style="margin-top:300px;width:40px;">
						<input type="button" id="admin_goods_add_save" value="保存" />
					</div>
				</div>
			</div>			
		</form>
		
	</div>
</div>
