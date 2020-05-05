<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>

<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />

<TITLE>高校困难生管理系统</TITLE>
<link rel="stylesheet" href="Images/CssAdmin.css">

<SCRIPT language=JavaScript>
function switchSysBar()
{
   if (switchPoint.innerText==3)
   {
      switchPoint.innerText=4
      document.all("frameTitle").style.display="none"
   }
   else
   {
      switchPoint.innerText=3
      document.all("frameTitle").style.display=""
   }
}
</SCRIPT>
</HEAD>

<BODY scroll="no" topmargin="0" bottom="0" leftmargin="0" rightmargin="0">
<TABLE height="100%" cellSpacing="0" cellPadding="0" border="0" width="100%">
  <TR>
    <TD colSpan="3">
	<IFRAME 
      style="Z-INDEX:1; VISIBILITY:inherit; WIDTH:100%; height:99px"
      name="topFrame" id="topFrame" marginWidth="0" marginHeight="0"
      src="top.jsp" frameBorder="0" noResize scrolling="no">	</IFRAME>	</TD>
  </TR>
  <TR>
    <TD width="170" height="100%" rowspan="2" align="middle" bgcolor="#367BDA" id="frameTitle" >
    <IFRAME 
      style="Z-INDEX:2; VISIBILITY:inherit; WIDTH:180; HEIGHT:100%" 
      name="leftFrame" id="leftFrame"  marginWidth="0" marginHeight="0"
      src="mygo.jsp" frameBorder="0" noResize scrolling="yes">
	</IFRAME>
	</TD>
    <TD width="10" height="100%" rowspan="2" align="center" bgcolor="#367BDA" onClick="switchSysBar()">
	<FONT style="FONT-SIZE: 10px; CURSOR: hand; COLOR: #ffffff; FONT-FAMILY: Webdings">
	  <SPAN id="switchPoint">3</SPAN>
	</FONT>
	</TD>
    
  </TR>
  <TR>
    <TD height="100%" bgcolor="#FFFFFF">
	<iframe 
      style="Z-INDEX:4; VISIBILITY:inherit; WIDTH:100%; HEIGHT:100%"
	  name="hsgmain" id="hsgmain" marginwidth="16" marginheight="16"
	  src="sy.jsp" frameborder="0" noresize scrolling="yes">
	</iframe>
	</TD>
  </TR>
</TABLE>
</BODY>
</HTML>