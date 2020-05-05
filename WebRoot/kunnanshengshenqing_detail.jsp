<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>困难生申请详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  困难生申请详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${kunnanshengshenqing.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${kunnanshengshenqing.xingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${kunnanshengshenqing.xingbie}</td>     <td width='11%'>班级：</td><td width='39%'>${kunnanshengshenqing.banji}</td></tr><tr>     <td width='11%'>申请理由：</td><td width='39%'>${kunnanshengshenqing.shenqingliyou}</td>     <td width='11%'>教师审核：</td><td width='39%'>${kunnanshengshenqing.jiaoshishenhe}</td></tr><tr>     <td width='11%'>学院审核：</td><td width='39%'>${kunnanshengshenqing.xueyuanshenhe}</td>     <td width='11%'>学校审核：</td><td width='39%'>${kunnanshengshenqing.xuexiaoshenhe}</td></tr><tr>     <td width='11%'>困难类别：</td><td width='39%'>${kunnanshengshenqing.kunnanleibie}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

