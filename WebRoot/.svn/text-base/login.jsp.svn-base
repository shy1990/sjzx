<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页</title>
    <script type="text/javascript" src="js/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
	<script type="text/JavaScript">
	String.prototype.trim=function(){
	    return this.replace(/(^\s*)|(\s*$)/g, "");
	 };
	 String.prototype.ltrim=function(){
	    return this.replace(/(^\s*)/g,"");
	 };
	 String.prototype.rtrim=function(){
	    return this.replace(/(\s*$)/g,"");
	 };
	function MM_preloadImages() { //v3.0
	  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
	    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
	    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
	}
	
	function MM_swapImgRestore() { //v3.0
	  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
	}
	
	function MM_findObj(n, d) { //v4.01
	  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
	    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
	  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
	  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
	  if(!x && d.getElementById) x=d.getElementById(n); return x;
	}
	
	function MM_swapImage() { //v3.0
	  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
	   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
	}
	submitForm=function(){
		if($('#username').val().trim().length<=0){
			$('#username').val("").focus();
			$('#errorMsg').text("请输入登陆名!");
			return false;
		}
		if($('#password').val().trim().length<=0){
			$('#password').val("").focus();
			$('#errorMsg').text("请输入密码!");
			return false;
		}
		$('#loginForm').submit();
	};
	var reset=function(){
		$('#username').val("");
		$('#password').val("");
	};
	$(function(){
		$('#username').val("").focus();
		$('#loginForm input').keydown(function(event){
			if(event.keyCode==13){
				if($('#username').val().trim().length<=0){
					$('#username').val("").focus();
					$('#errorMsg').text("请输入登陆名!");
					return false;
				}
				if($('#password').val().trim().length<=0){
					$('#password').val("").focus();
					$('#errorMsg').text("请输入密码!");
					return false;
				}
				submitForm();
			}
		});
	});
	</script>
  </head>
  <body style="background:#02609C;margin:0;" onLoad="MM_preloadImages('images/login/login_09_1.gif','images/login/login_10_1.gif')">
  <form action="loginAction!doNotNeedSession_login.action" id="loginForm" method="post" style="margin:0;">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="margin:0;">
	  <tr>
	    <td bgcolor="#02395f">&nbsp;</td>
	  </tr>
	  <tr>
	    <td height="607" align="center" background="images/login/login_02.gif " ><table width="974" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td height="331" background="images/login/login_01.jpg">&nbsp;</td>
	      </tr>
	      <tr>
	        <td height="116"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td width="393" height="116" background="images/login/login_05.gif">&nbsp;</td>
	            <td width="174"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td height="81" background="images/login/login_06.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="24%"><div align="center"><font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">用户</font></div></td>
	                    <td width="76%" height="25"><input type="text" name="username" id="username"  style="width:125px; height:20px; background:#B4E1FF; font-size:12px; border:solid 1px #0468a7; color:#14649f;"></td>
	                  </tr>
	                  <tr>
	                    <td><div align="center"><font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">密码</font></div></td>
	                    <td height="25"><input type="password" name="password" id="password"  style="width:125px; height:20px; background:#B4E1FF; font-size:12px; border:solid 1px #0468a7; color:#14649f;"></td>
	                  </tr>
	                  <tr><td colspan="2" style="text-align: center;"><font color="red" size="2"><label id="errorMsg">${msg}</label></font></td></tr>
	                </table></td>
	              </tr>
	              <tr>
	                <td height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="50" height="35"><img src="images/login/login_08.gif" width="50" height="35"></td>
	                    <td width="46"><a href="javascript:void(0)" onclick="submitForm();"><img src="images/login/login_09.gif" name="Image1" width="46" height="35" border="0" id="Image1" onMouseOver="MM_swapImage('Image1','','images/login/login_09_1.gif',1)" onMouseOut="MM_swapImgRestore()"></a></td>
	                    <td width="45"><a href="javascript:void(0)" onclick="reset()"><img src="images/login/login_10.gif" name="Image2" width="45" height="35" border="0" id="Image2" onMouseOver="MM_swapImage('Image2','','images/login/login_10_1.gif',1)" onMouseOut="MM_swapImgRestore()"></a></td>
	                    <td width="33"><img src="images/login/login_11.gif" width="33" height="35"></td>
	                  </tr>
	                </table></td>
	              </tr>
	            </table></td>
	            <td width="407" background="images/login/login_07.gif">&nbsp;</td>
	          </tr>
	        </table></td>
	      </tr>
	      <tr>
	        <td height="160" background="images/login/login_12.gif">&nbsp;</td>
	      </tr>
	    </table></td>
	  </tr>
	  <tr>
	    <td bgcolor="#02609c">&nbsp;</td>
	  </tr>
	</table>
	</form>
</body>
</html>