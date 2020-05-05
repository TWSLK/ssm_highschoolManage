<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>用工部门详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  用工部门详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>部门帐号：</td><td width='39%'>${yonggongbumen.bumenzhanghao}</td>     <td width='11%'>密码：</td><td width='39%'>${yonggongbumen.mima}</td></tr><tr>     <td width='11%'>部门名称：</td><td width='39%'>${yonggongbumen.bumenmingcheng}</td>     <td width='11%'>负责人：</td><td width='39%'>${yonggongbumen.fuzeren}</td></tr><tr>     <td width='11%'>联系电话：</td><td width='39%'>${yonggongbumen.lianxidianhua}</td>     <td width='11%'>地址：</td><td width='39%'>${yonggongbumen.dizhi}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

