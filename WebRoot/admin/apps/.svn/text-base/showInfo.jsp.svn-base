<%@ page language="java"
	import="java.util.*,com.sanji.sjzx.common.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String basePath = PathUtil.getPath(request);
%>

<style type="text/css">
	.show .t1 a:hover img{
	    -webkit-transform:scale(4,4) translate(0,-30px);
	    -moz-transform:scale(4,4) translate(0,-30px);
	    -transform:scale(4,4) translate(0,-30px);
	}
	.show .t2 a:hover img{
	    -webkit-transform:scale(4,4) translate(0,-60px);
	    -moz-transform:scale(4,4) translate(0,-60px);
	    -transform:scale(4,4) translate(0,-60px);
	}
</style>

<p style="margin-left:70px;font-size:20px; font-weight: bold;">以下是商家信息:</p>
<div style="border:1px solid #ccc;width:1200px;margin-left:70px">
	<form id="admin_apps_showForm" method="post">
		<p style="margin-left:65px; font-weight: bold;">信息操作人:<span>${apps.aname}</span></p>
		<table style="width:100%;margin:auto" class="show">
			<tr>
				<th>店铺名称:</th>
				<td><input style="width:160px" value="${apps.shopName}" readonly="readonly"/></td>
				<th>店铺地址:</th>
				<td><input style="width:160px" value="${apps.address}" readonly="readonly"/></td>
				<th>营业面积:</th>
				<td><input style="width:160px" value="${apps.businessArea}" readonly="readonly"/></td>		
			</tr>
			<tr>
				<th>柜台数量:</th>
				<td><input style="width:160px" value="${apps.counterNum}" readonly="readonly"/></td>
				<th>开店年数:</th>
				<td><input style="width:160px" value="${apps.businessYear}" readonly="readonly"/></td>
				<th>店庆时间:</th>
				<td>
					<input style="width:160px" value="<s:date name="apps.anniversaryBirth" format="yyyy-MM-dd" />" />
				</td>		
			</tr>
			<tr>
				<th>会员名称:</th>
				<td><input style="width:160px" value="${apps.mname}" readonly="readonly"/></td>
				<th>店主姓名:</th>
				<td><input style="width:160px" value="${apps.shopkeeperName}" readonly="readonly"/></td>
				<th>店主生日:</th>
				<td>
					<input style="width:160px" value="<s:date name="apps.shopkeeperBirth" format="yyyy-MM-dd" />"/>
				</td>
			</tr>
			<tr>
				<th>店主手机:</th>
				<td><input style="width:160px" value="${apps.mobile}" readonly="readonly"/></td>
				<th>店主座机:</th>
				<td><input style="width:160px" value="${apps.telephone}" readonly="readonly"/></td>
				<th>店主QQ:</th>
				<td><input style="width:160px" value="${apps.qq}" readonly="readonly"/></td>		
			</tr>
			<tr>
				<th>品牌一:</th>
				<td><input style="width:160px" value="${apps.brand1}" readonly="readonly"/></td>
				<th>销量一:</th>
				<td><input style="width:160px" value="${apps.sale1}" readonly="readonly"/></td>
				<th>炒货商:</th>
				<td><input style="width:160px" value="${apps.store}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>品牌二:</th>
				<td><input style="width:160px" value="${apps.brand2}" readonly="readonly"/></td>
				<th>销量二:</th>
				<td><input style="width:160px" value="${apps.sale2}" readonly="readonly"/></td>
				<th>代理商:</th>
				<td><input style="width:160px" value="${apps.agent}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>品牌三:</th>
				<td><input style="width:160px" value="${apps.brand3}" readonly="readonly"/></td>
				<th>销量三:</th>
				<td><input style="width:160px" value="${apps.sale3}" readonly="readonly"/></td>
				<th>运营商:</th>
				<td><input style="width:160px" value="${apps.operation}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>品牌四:</th>
				<td><input style="width:160px" value="${apps.brand4}" readonly="readonly"/></td>
				<th>销量四:</th>
				<td><input style="width:160px" value="${apps.sale4}" readonly="readonly"/></td>
				<th>厂家:</th>
				<td><input style="width:160px" value="${apps.factory}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>其他品牌:</th>
				<td><input style="width:160px" value="${apps.brandOther}" readonly="readonly"/></td>
				<th>其他销量:</th>
				<td><input style="width:160px" value="${apps.saleOther}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>功能机0~300:</th>
				<td><input style="width:160px" value="${apps.functionLingSanbai}" readonly="readonly"/></td>
				<th>智能机0~300:</th>
				<td><input style="width:160px" value="${apps.smartLingSanbai}" readonly="readonly"/></td>
				<th>进货频率:</th>
				<td><input style="width:160px" value="${apps.stockRate}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>功能机300~600:</th>
				<td><input style="width:160px" value="${apps.functionSanbaiLiubai}" readonly="readonly"/></td>
				<th>智能机300~600:</th>
				<td><input style="width:160px" value="${apps.smartSanbaiLiubai}" readonly="readonly"/></td>
				<th>进货台数:</th>
				<td><input style="width:160px" value="${apps.stockNum}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>功能机600~1000:</th>
				<td><input style="width:160px" value="${apps.functionLiubaiYiqian}" readonly="readonly"/></td>
				<th>智能机600~1000:</th>
				<td><input style="width:160px" value="${apps.smartLiubaiYiqian}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>功能机1000~1500:</th>
				<td><input style="width:160px" value="${apps.functionYiqianYiqianwu}" readonly="readonly"/></td>
				<th>智能机1000~1500:</th>
				<td><input style="width:160px" value="${apps.smartYiqianYiqianwu}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>功能机1500以上:</th>
				<td><input style="width:160px" value="${apps.functionYiqianwuMore}" readonly="readonly"/></td>
				<th>智能机1500以上:</th>
				<td><input style="width:160px" value="${apps.smartYiqianwuMore}" readonly="readonly"/></td>
			</tr>
			<tr class="t1">
				<th>店铺正面:</th>
				<td>
				<c:if test="${!empty apps.zhengmian}">
					<a href="#"><img src="${apps.zhengmian}" width = '162px' height = '216px'/></a>
				</c:if>
				<c:if test="${empty apps.zhengmian}">
					无
				</c:if>
				</td>
				<th>店铺合影:</th>
				<td>
				<c:if test="${!empty apps.heying}">
					<a href="#"><img src="${apps.heying}" width = '162px' height = '216px'/></a>
				</c:if>
				<c:if test="${empty apps.heying}">
					无
				</c:if>
				</td>
				<th>店铺前面:</th>
				<td>
				<c:if test="${!empty apps.qianmian}">
					<a href="#"><img src="${apps.qianmian}" width = '162px' height = '216px'/></a>
				</c:if>
				<c:if test="${empty apps.qianmian}">
					无
				</c:if>
				</td>
			</tr>
			<tr class="t2">
				<th>店铺后面:</th>
				<td>
				<c:if test="${!empty apps.houmian}">
					<a href="#"><img src="${apps.houmian}" width = '162px' height = '216px'/></a>
				</c:if>
				<c:if test="${empty apps.houmian}">
					无
				</c:if>
				</td>
				<th>店铺左面:</th>
				<td>
				<c:if test="${!empty apps.zuomian}">
					<a href="#"><img src="${apps.zuomian}" width = '162px' height = '216px'/></a>
				</c:if>
				<c:if test="${empty apps.zuomian}">
					无
				</c:if>
				</td>
				<th>店铺右面:</th>
				<td>
				<c:if test="${!empty apps.youmian}">
					<a href="#"><img src="${apps.youmian}" width = '162px' height = '216px'/></a>
				</c:if>
				<c:if test="${empty apps.youmian}">
					无
				</c:if>
				</td>
			</tr>
		</table>
	</form>
</div>


