<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>助学金详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  助学金详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>学号：</td><td width='39%'>${zhuxuejin.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${zhuxuejin.xingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${zhuxuejin.xingbie}</td>     <td width='11%'>困难类别：</td><td width='39%'>${zhuxuejin.kunnanleibie}</td></tr><tr>     <td width='11%'>申请理由：</td><td width='39%'>${zhuxuejin.shenqingliyou}</td>     <td width='11%'>学院审核：</td><td width='39%'>${zhuxuejin.xueyuanshenhe}</td></tr><tr>     <td width='11%'>学校审核：</td><td width='39%'>${zhuxuejin.xuexiaoshenhe}</td>     <td width='11%'>助学金额：</td><td width='39%'>${zhuxuejin.zhuxuejine}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

