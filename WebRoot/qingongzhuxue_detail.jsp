<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>勤工助学详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  勤工助学详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>部门帐号：</td><td width='39%'>${qingongzhuxue.bumenzhanghao}</td>     <td width='11%'>部门名称：</td><td width='39%'>${qingongzhuxue.bumenmingcheng}</td></tr><tr>     <td width='11%'>联系电话：</td><td width='39%'>${qingongzhuxue.lianxidianhua}</td>     <td width='11%'>地址：</td><td width='39%'>${qingongzhuxue.dizhi}</td></tr><tr>     <td width='11%'>岗位：</td><td width='39%'>${qingongzhuxue.gangwei}</td>     <td width='11%'>学号：</td><td width='39%'>${qingongzhuxue.xuehao}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${qingongzhuxue.xingming}</td>     <td width='11%'>性别：</td><td width='39%'>${qingongzhuxue.xingbie}</td></tr><tr>     <td width='11%'>班级：</td><td width='39%'>${qingongzhuxue.banji}</td>     <td width='11%'>教师审核：</td><td width='39%'>${qingongzhuxue.jiaoshishenhe}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

