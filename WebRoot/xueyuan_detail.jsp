<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>学院详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  学院详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>账号：</td><td width='39%'>${xueyuan.zhanghao}</td>     <td width='11%'>密码：</td><td width='39%'>${xueyuan.mima}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${xueyuan.xingming}</td>     <td width='11%'>性别：</td><td width='39%'>${xueyuan.xingbie}</td></tr><tr>     <td width='11%'>联系方式：</td><td width='39%'>${xueyuan.lianxifangshi}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

