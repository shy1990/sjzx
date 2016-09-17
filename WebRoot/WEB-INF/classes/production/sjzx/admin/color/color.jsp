<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'color.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	

  </head>
  
  <body>
     
      <form id="hcc" name="hcc">
      <TABLE class="jbcolorcontab" cellSpacing="0" cellPadding="0" border="0" align="center">
        <TR>
          <TD>
            <TABLE class="jbcolorcontd" cellSpacing="1" cellPadding="0" width="370" align="center" border="0">
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#190707>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#2a0a0a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#3b0b0b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#610b0b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#8a0808>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#b40404>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#df0101>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#ff0000>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fe2e2e>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fa5858>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f78181>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f5a9a9>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f6cece>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f8e0e0>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fbefef>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#191007>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#2a1b0a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#3b240b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#61380b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#8a4b08>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#b45f04>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#df7401>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#ff8000>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fe9a2e>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#faac58>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f7be81>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f5d0a9>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f6e3ce>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f8ece0>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fbf5ef>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#181907>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#292a0a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#393b0b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#5e610b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#868a08>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#aeb404>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#d7df01>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#ffff00>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f7fe2e>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f4fa58>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f3f781>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f2f5a9>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f5f6ce>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f7f8e0>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fbfbef>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#101907>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#1b2a0a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#243b0b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#38610b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#4b8a08>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#5fb404>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#74df00>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#80ff00>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#9afe2e>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#acfa58>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#bef781>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#d0f5a9>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#e3f6ce>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#ecf8e0>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f5fbef>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#071907>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0a2a0a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0b3b0b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0b610b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#088a08>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#04b404>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#01df01>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#00ff00>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#2efe2e>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#58fa58>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#81f781>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#a9f5a9>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#cef6ce>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#e0f8e0>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#effbef>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#071910>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0a2a1b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0b3b24>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0b6138>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#088a4b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#04b45f>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#01df74>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#00ff80>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#2efe9a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#58faac>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#81f7be>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#a9f5d0>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#cef6e3>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#e0f8ec>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#effbf5>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#071918>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0a2a29>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0b3b39>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0b615e>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#088a85>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#04b4ae>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#01dfd7>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#00ffff>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#2efef7>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#58faf4>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#81f7f3>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#a9f5f2>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#cef6f5>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#e0f8f7>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#effbfb>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#071019>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0a1b2a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0b243b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0b3861>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#084b8a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#045fb4>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0174df>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0080ff>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#2e9afe>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#58acfa>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#81bef7>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#a9d0f5>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#cee3f6>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#e0ecf8>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#eff5fb>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#070719>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0a0a2a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0b0b3b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0b0b61>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#08088a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0404b4>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0101df>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0000ff>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#2e2efe>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#5858fa>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#8181f7>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#a9a9f5>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#cecef6>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#e0e0f8>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#efeffb>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#100719>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#1b0a2a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#240b3b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#380b61>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#4b088a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#5f04b4>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#7401df>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#8000ff>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#9a2efe>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#ac58fa>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#be81f7>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#d0a9f5>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#e3cef6>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#ece0f8>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f5effb>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#190718>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#2a0a29>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#3b0b39>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#610b5e>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#8a0886>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#b404ae>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#df01d7>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#ff00ff>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fe2ef7>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fa58f4>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f781f3>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f5a9f2>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f6cef5>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f8e0f7>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fbeffb>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#190710>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#2a0a1b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#3b0b24>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#610b38>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#8a084b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#b4045f>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#df0174>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#ff0080>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fe2e9a>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fa58ac>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f781be>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f5a9d0>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f6cee3>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f8e0ec>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#fbeff5>&nbsp;</TD>
              </TR>
              <TR height="24">
                <TD onclick=Barva(this.bgColor) bgColor=#000000>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#0b0b0b>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#151515>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#1c1c1c>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#2e2e2e>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#424242>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#585858>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#6e6e6e>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#848484>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#a4a4a4>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#bdbdbd>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#d8d8d8>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#e6e6e6>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#f2f2f2>&nbsp;</TD>
                <TD onclick=Barva(this.bgColor) bgColor=#ffffff>&nbsp;</TD>
              </TR>
            </TABLE>
          </TD>
        </TR>
      </TABLE>
      <TABLE height="23" border="0" cellPadding="0" cellSpacing="0" align="center">
        <TR>
          <TD  valign="middle" id="vzorec">
            <INPUT type="hidden"  id="barva" class="yourscolor" maxLength="7" size="9" name="barva">
          </TD>
        </TR>
      </TABLE>
    </form>
  </body>
</html>
