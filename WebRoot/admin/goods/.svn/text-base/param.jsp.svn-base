<%@ page language="java"
	import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sanji.sjzx.common.util.ResourceUtil"%>
<%@page import="com.sanji.sjzx.pojo.SessionInfo"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String basePath = PathUtil.getPath(request);
	SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ResourceUtil.getSessionInfoName());
	String userId = sessionInfo.getUserId();
%>
<script type="text/javascript">
	/**
	 *判断商品名称是否存在
	 */
$(function() {
	var admin_goods_addForm = $('#admin_goods_addForm');
	var admin_goods_add_save = $('#admin_goods_add_save');
    var goodsName = $('#goodsName');
	var goodsNum = $('#goodsNum');
    var address = $('#address');
    
/* 	goodsName.blur(function() {
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
		}
		//发送同步请求给goodsNameValidate 
		$.ajax({
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
		});
		return goodsNameFlag;
	}
	/**
	 *判断商品编号是否存在
	 */
/* 	goodsNum.blur(function() {
		validGoodsNum();
	});

	function validGoodsNum() {
		var goodsNumFlag = false;
		//取得文本框的值
		var goodsNum = $("#goodsNum").val();
		if (goodsNum == null || goodsNum == "") {
			$("#numMsg").text("商品编号不能为空！");
			$("#numMsg").css("color", "#f00");
			goodsNumFlag = false;
			return goodsNumFlag;
		}
		//发送同步请求给goodsNumValidate 
		$.ajax({
			url : "goods/goodsAction!goodsNumValidate.action",
			type : "POST",
			dataType : "JSON",
			data : "goodsNum=" + goodsNum,
			async : false,
			success : function(j) {
				if (j.success) {
					//如果返回值为true，则校验通过
					$("#numMsg").text("ok");
					$("#numMsg").css("color", "#00f");
					flag = true;
					goodsNumFlag = true;
				} else {
					//如果返回值为false，则校验不通过
					$("#numMsg").text("此商品编号已存在");
					$("#numMsg").css("color", "#f00");
					goodsNumFlag = false;
				}
			}
		});
		return goodsNumFlag;
	}  */
	/**
	 * 验证url
	 */	
/* 	address.blur(function() {
		validUrl();
	});
	function validUrl() {
		var urlFlag = false;
		//取得文本框的值
		var address = $("#address").val();
		if (address == null || address == "") {
			$("#urlMsg").text("商品编号不能为空！");
			$("#urlMsg").css("color", "#f00");
			urlFlag = false;
			return urlFlag;
		}
		if(address=="http://detail.zol.com.cn/274/273715/param.shtml"){
			$("#urlMsg").text("ok");
			$("#urlMsg").css("color", "#00f");
			urlFlag = true;
			return urlFlag;
		}else{
			$("#urlMsg").text("url地址错误！");
			$("#urlMsg").css("color", "#f00");
			urlFlag = false;
			return urlFlag;
		}
		return urlFlag;
	}  */
	  
	//提交
	admin_goods_add_save.bind('click', function() {
/* 	 	if (validGoodsName() == false) {
			$("#nameMsg").text("商品名称校验未通过");
			$("#nameMsg").css("color", "#f00");
			$("#goodsName").focus();
			return;
		}
		if (validGoodsNum() == false) {
			$("#numMsg").text("商品编号校验未通过！");
			$("#numMsg").css("color", "#f00");
			$("#goodsNum").focus();
			return;
		}
		if (validUrl() == false) {
			$("#urlMsg").text("url校验未通过！");
			$("#urlMsg").css("color", "#f00");
			$("#urlMsg").focus();
			return;
		}
		var brandId = $("input[name='brandId']").val();
		console.info("brandId==="+brandId);
		alert("brandId==="+brandId);
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
		console.info("catId==="+catId);alert("catId==="+catId);
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
  */
		var address = $("#address").val();
		console.info("address>>>>>>>>>>>"+address);
		admin_goods_addForm.form('submit', {
			url : 'goods/goodsAction!newAddGoods.action?address='+address,
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
					var url = "goods/goodsAction!toList.action";
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
					$('#tabs').tabs('close', '添加商品参数');
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
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:true,split:false">
	<form id="admin_goods_addForm" method="post">
		<input type="hidden" name="userId" value="<%=userId%>" />
		<table id="admin_goods_datagrid" class="tableForm" style="margin-top: 15px; width:60%;">
			<tr>
				<th>商品名称：</th>
				<td><input id="goodsName" name="name" class="easyui-validatebox" data-options="required:true"
					style="width:160px" placeholder="请输入商品名称" />
					<div class="validate_msg_short" id="nameMsg"></div>
				</td>
				<th>商品编号：</th>
				<td><input id="goodsNum" name="goodsNum" class="easyui-validatebox" data-options="required:true"
					style="width:160px" placeholder="请输入商品编号" />
					<div class="validate_msg_short" id="numMsg"></div>
				</td>
			  </tr>
			  <tr>
				<th>商品品牌:</th>
				<td><span> <input id="brandId" name="brandId" class="easyui-combobox"
						data-options="url:'goods/goodsAction!gainGoodsBrandName.action',valueField:'brandId',textField:'brandName',editable:false,multiple:false"
						style="width:160px" /> </span><div class="validate_msg_short" id="brandMsg"></div></td>
				<th>商品类别:</th>
				<td><span> <input id="catId" name="catId"
						class="easyui-combobox"
						data-options="url:'goods/goodsAction!gainGoodsCatName.action',valueField:'catId',textField:'catName',editable:false,multiple:false"
						style="width:160px" /> </span><div class="validate_msg_short" id="catMsg"></div></td>
				<th>三际天猫官方地址 :</th>
				<td><input name="tmallUrl" style="width:160px"
					placeholder="请输入三际天猫官方地址" />
				</td>
			</tr>
			<tr>
				<th>url地址 :</th>
				<td>
					<input id="address" type="text" style="width:160px" placeholder="请输入url地址" />
					<div class="validate_msg_short" id="urlMsg"></div>
				</td>
			</tr>
		</table>
		<div style="margin-top:10px;margin-left:20px;">
			<input type="button" id="admin_goods_add_save" value="保存" />
		</div>
	</form>
</div>
</div>

