<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script>
	var obj = window.dialogArguments;
</script>
<style>
.newszd{ width:963px;border:1px solid #DDDDDD; float:left;}
.newszd h1{ width:963px; float:left; text-align:center; font-size:24px; line-height:80px;}
.wzly{
width:920px;
float:left;
background:#f7f7f7;
line-height:28px;
border:1px solid #e8e8e8;
margin-left:21px;
margin-bottom:15px;
display:inline;
text-align:center;
color:#000;
}
.wzly span{padding-right:15px;}
.newssc{ background:url(../images/sc.gif) no-repeat 25px 1px; padding-right:30px;}
.wzzy{
width:880px;
margin-left:21px;
margin-top:15px;
display:inline;
border:1px  dashed #d6d6d6;
padding:5px 20px;
height:98px;
background:#FBFBFB;
float:left;
}
.wzzy h2{
font-size:12px;
font-weight:normal;
color:#8A8A8A;
}
.nrzy{ font-weight:bold;}
.newswznr{
width:920px;
margin-left:21px;
display:inline;
padding:20px 4px 5px 0px;
font-size:14px;
float:left;

}
.newswznr p{
padding-bottom:15px;
line-height:28px;
}
.newswznr p a{
color:#09446E;
}
.newswznr p a:hover{
font-weight:bold;
}
.newspic{ width:340px; height:228px; float:left; padding:4px; border:1px solid #C9C9C9; margin-right:20px; display:inline; margin-bottom:20px;}
</style>
<div class="newszd">
	<h1><script>document.write(obj.firstTitle)</script></h1>
	<p class="wzly">
		<span>文章来源：<script>document.write(obj.resources)</script></span><span>发布时间：2099-12-12 20:15:35</span>
		<span>发布人：<script>document.write(obj.author)</script></span><span>浏览次数：1560</span><span
			class="newssc"><a href="javascript:void(0)" onclick="addfavorite('')">收藏</a> </span>
	</p>
	<div class="wzzy">
		<p class="nrzy">内容摘要</p>
		<h2><script>document.write(obj.secondTitle);</script></h2>
	</div>
	<div class="newswznr"><script>document.write(obj.content)</script></div>
</div>