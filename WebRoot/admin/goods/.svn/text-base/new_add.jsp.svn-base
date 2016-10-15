<%@ page language="java"
	import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
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
	$(document).ready(
		function addTab(subtitle, url, icon){
			var tabCount = $('#tabs').tabs('tabs').length;//获取当前打开窗口总数量
			var hasTab = $('#tabs').tabs('exists', '添加商品(手动录入)'); //根据名称判断窗口是否已打开
			console.info("tabCount====="+tabCount);
			if(hasTab){
				$.messager.alert('提示','添加商品页面只能打开一个!','info');
				tabClose();
				$('#tabs').tabs('close', '添加商品(抓取外链)');
			}
			if (tabCount > 3 && !hasTab) { 
				$.messager.alert('提示','您当前打开页面太多，如果继续打开，会造成程序运行缓慢，无法流畅操作!','info');
				tabClose();
				$('#tabs').tabs('close', '添加商品(抓取外链)');
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
		var tmallPrice = 'list[' + index + '].tmallPrice';
		var stock = 'list[' + index + '].stock';
		var colorId = 'list[' + index + '].colorId';
		var changeNum = 'list[' + index + '].changeNum';
		var changePrice = 'list[' + index + '].changePrice';
		
		skuCodeOb = $("input[name='" + skuCode + "']");
		skuNumOb = $("input[name='" + skuNum + "']");
		priceOb = $("input[name='" + price + "']");
		originalPriceOb = $("input[name='" + originalPrice + "']");
		tmallPriceOb = $("input[name='" + tmallPrice + "']");
		stockOb = $("input[name='" + stock + "']");
		colorIdOb = $("input[name='" + colorId + "']");
		changeNumOb = $("input[name='"+changeNum+"']");
		changePriceOb = $("input[name='"+changePrice+"']");
		
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
		}
 */
		if (colorIdOb.val() == null || colorIdOb.val() == 'undefined' || colorIdOb.val() == '') {
		 alert("请选择单品颜色！");
		 return false;
		} 

		if (validStock(stockOb) == false) {
			//alert("请输入单品库存！");	
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
		} */
		//发送同步请求给skuNumValidate 
/* 		$.ajax({
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
					$(skuCodeMsgObj).text("此商品规格代码已存在");
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
		}

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
		
		var url = $('#url');
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
								}else{//如何右边没有数据，那么可以添加赠品
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
								}
							}
										
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
		 * 校验url
		 */
/* 		url.blur(function() {
			validUrl();
		}); */

/* 		function validUrl() {
			var urlFlag = false;
			//取得文本框的值
			var url = $("#url").val();
			var u = url.substr(0,24);
			console.info("u=============="+u);
 			if (url == null || url == "") {
				$("#urlMsg").text("规格参数外链不能为空！");
				$("#urlMsg").css("color", "#f00");
				urlFlag = false;
				return urlFlag;
			}else{ 
				if(u=="http://detail.zol.com.cn"){
					$("#urlMsg").text("ok！");
					$("#urlMsg").css("color", "#00f");
					urlFlag = true;
					return urlFlag;
				}else{
					$("#urlMsg").text("规格参数外链错误！");
					$("#urlMsg").css("color", "#f00");
					urlFlag = false;
					return urlFlag;
				}
			}
			return urlFlag;
		}  */
		
		//加载完所有节点之后
		$(document)
				.ready(
						function() {
							var tableNum1 = $("#admin_goods_add_sku").children(
									"table").length;
							var tableObj1 = $("#admin_goods_add_sku").children(
									"table")[tableNum1 - 1];
							var spanNum1 = $(tableObj1).find("span").length;
							for ( var n = 0; n < spanNum1; n++) {
								var spanObj1 = $(tableObj1).find("span")[n];
								var spanAttrValue1 = $(spanObj1).attr("id");
								if (spanAttrValue1 != undefined) {
									var modifyAttrValue1 = spanAttrValue1
											.replace(/\_\m/, "_" + m);
									$(spanObj1).attr("id", modifyAttrValue1);
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
							//复制后控制颜色、图片父节点、网络类型span的id属性
 							var spanObj1 = $(tableObj).find("span")[0];//具体第一个span是color的父节点
							var spanAttrValue1 = $(spanObj1).attr("id");
							console.info("spanAttrValue1===>>>>>"+spanAttrValue1);
							if (spanAttrValue1 != undefined) {
								var newStr1 = spanAttrValue1.substr(0,spanAttrValue1.length - 1);
								var modifyAttrValue1 = newStr1 + m;
								console.info("modifyAttrValue1:"+modifyAttrValue1);
								$(spanObj1).attr("id", modifyAttrValue1);
								var inputNum = $(spanObj1).find("input").length;
								console.info("颜色对象的个数"+inputNum);
								if(inputNum>0){
									$(spanObj1).empty();
									var span_color =document.getElementById(modifyAttrValue1);
									console.info("span_color==="+span_color);
									var input = document.createElement("input");
									$(input).attr("id","colorId_"+m);
									$(input).attr("name","list["+m+"].colorId");
									$(input).attr("class","easyui-combobox");
									$(input).css("width","160px");
									span_color.appendChild(input);	
								} 
							}
							console.info("jjjjjjjjj------------------------------------------------------------");
							var spanNum = $(tableObj).find("span").length;
							console.info("***  spanNum==="+spanNum);
						for(var j=1;j<2;j++){
							var spanObj2 = $(tableObj).find("span")[j];//具体第四个span是netsuitType的父节点
							console.info("spanObj2===="+spanObj2);
							var spanAttrValue2 = $(spanObj2).attr("id");
							console.info("spanAttrValue2===>>>>>"+spanAttrValue2);
							if (spanAttrValue2 != undefined) {
								var newStr2 = spanAttrValue2.substr(0,spanAttrValue2.length - 1);
								var modifyAttrValue2 = newStr2 + m;
								console.info("modifyAttrValue2:"+modifyAttrValue2);
								$(spanObj2).attr("id", modifyAttrValue2);
								var inputNum = $(spanObj2).find("input").length;
								console.info("网络类型对象的个数"+inputNum);
								if(inputNum>0){
									$(spanObj2).empty();//span_netsuit_m
									var span_netsuit=document.getElementById(modifyAttrValue2);
									console.info("span_netsuit==="+span_netsuit);
									var input=document.createElement("input");
									$(input).attr("id","netsuitId_"+m);
									$(input).attr("name","list["+m+"].netsuitType");
									$(input).attr("class","easyui-combobox");
									$(input).css("width","160px");
									span_netsuit.appendChild(input);	 	
								} 
							}
						}
							console.info("jjjjjjjjj------------------------------------------------------------");
						for(var j=2;j<11;j++){
							var spanObj3 = $(tableObj).find("span")[j];//具体第八个span是img的父节点
							var spanAttrValue3 = $(spanObj3).attr("id");
							console.info("spanAttrValue3===>>>>>"+spanAttrValue3);
							if (spanAttrValue3 != undefined) {
								var newStr3 = spanAttrValue3.substr(0,spanAttrValue3.length - 1);
								var modifyAttrValue3 = newStr3 + m;
								console.info("modifyAttrValue3:"+modifyAttrValue3);
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
								
							for ( var index = 0; index < tdNum; index++) {
								var tdObj = $(tableObj).find("input")[index];
								var attrValue = $(tdObj).attr("name");
								if (attrValue != undefined) {
									var modifyValue = attrValue.replace(/list\[\w\]/, "list[" + i + "]");
									$(tdObj).attr("name", modifyValue);
									$(tdObj).val("");
								}
							}
							
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
							}
 */							
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
				$(obj).remove();
				//点击取消添加的时候,给该div中最后一个table中的a标签设置为display值inline
				var newNum = $("#admin_goods_add_sku").children("table").length;
				var tableObj = $("#admin_goods_add_sku").children("table")[newNum - 1];
				var aNum = $(tableObj).find("a").length;
				for(var n=0;n<aNum;n++){
					var aObj = $(tableObj).find("a")[n];
					$(aObj).css("display","block");
				}
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
/* 			if(validUrl() == false){
				$("#urlMsg").text("url地址校验未通过！");
				$("#urlMsg").css("color", "#f00");
				$("#url").focus();
				return;
			} */
			if (validPreTable() == false)
			{
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
				var showID = "admin_goods_add_thumbPic_" + s;console.info("showID======="+showID);
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
					console.info("arrayJSON=="+arrayJSON);
				}
			}		
  			//console.info("arrayJSON>>>>>>=="+arrayJSON);
  			var path = [];
  			var url = $("#url").val();
  			path.push(url);
			//提交
			admin_goods_addForm.form('submit', {
				url : 'goods/goodsAction!addGoods.action?idList='
						+ giftSelected 
						+ '&array=' + arrayJSON 
						+ '&road=' + path,
						
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
						//$('#admin_goods_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
						var subtitle = "商品列表";
						var url = "goods/goodsAction!toGoodsList.action";
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
						$('#tabs').tabs('close', '添加商品(抓取外链)');
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
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
		<form id="admin_goods_addForm" method="post">
			<input type="hidden" name="userId" value="<%=userId%>" />
			<div style="margin-left:70px;margin-top:15px;">
				<h2>商品信息添加:</h2>
			</div>
			<div style="border:1px solid #ccc;width:80%;margin-left:70px;">
				<table id="admin_goods_add_datagrid" class="tableForm"
					style="margin-top: 15px; width:100%;">
					<tr>
						<th>商品名称:</th>
						<td><input id="goodsName" name="name"
							class="easyui-validatebox" data-options="required:true"
							style="width:160px" placeholder="请输入商品名称" />
							<div class="validate_msg_short" id="nameMsg"></div>
						</td>
						<th>商品品牌:</th>
						<td><span> <input id="brandId" name="brandId" class="easyui-combobox"
								data-options="url:'goods/goodsAction!gainGoodsBrandName.action',valueField:'brandId',textField:'brandName',editable:false,multiple:false"
								style="width:160px" /> </span><div class="validate_msg_short" id="brandMsg"></div></td>
						<th>商品类别:</th>
						<td><span> <input id="catId" name="catId"
								class="easyui-combobox"
								data-options="url:'goods/goodsAction!gainGoodsCatName.action',valueField:'catId',textField:'catName',editable:false,multiple:false"
								style="width:160px" /> </span><div class="validate_msg_short" id="catMsg"></div></td>						
					</tr>
					<tr>
						<th>三际天猫官方地址:</th>
						<td><input name="tmallUrl" style="width:160px"
							placeholder="请输入三际天猫官方地址" />
						</td>
						<th>抓取规格参数外链:</th>
						<td>
							<input id="url" type="text" style="width:160px" placeholder="请输入规格参数外链" />
							<div class="validate_msg_short" id="urlMsg"></div>
						</td>
					</tr>
				</table>
			</div>
			<div style="margin-left:70px;">
				<h2>单品信息添加:</h2>
			</div>
			<div id="admin_goods_add_sku"
				style="border:1px solid #ccc;width:80%;margin-left:70px;">
				<table id="admin_goods_add_sku_table" class="tableForm"
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
							<input id="netsuitType" name="list[0].netsuitType" class="easyui-combobox"
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
								<a id="a_0" class="easyui-linkbutton" href="javascript:makerUploadForAdd(false,0)">选择图片</a>&nbsp;&nbsp;
								<label style="color: red">第一张图片作为页面默认图片</label>
							</span><br/><br/>
							<span id="admin_goods_add_thumbPic_m"> </span>
						</td>
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
									<table id="admin_goods_add_uninGoods_left" style="width:100%">
										<thead>
											<tr>
												<th data-options="field:'id',width:80,checkbox:true">赠品ID</th>
												<th data-options="field:'name',width:80,sortable:true,formatter:function(value, row, index){var s = '<span title='+value+'>' + value + '</span>'; return s;}">赠品名称</th>
												<th data-options="field:'accessoriesNum',width:80,sortable:true">赠品编号</th>
												<th data-options="field:'brandName',width:80,sortable:true">赠品品牌</th>
												<th data-options="field:'catName',width:80,sortable:true">赠品类别</th>
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
							style="width:250px;">
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
