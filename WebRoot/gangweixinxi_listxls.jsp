<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="gangweixinxihsgb" scope="page" class="com.bean.GangweixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=gangweixinxi.xls");
%>
<html>
  <head>
    <title>岗位信息</title>
  </head>

  <body >
 <%
			String sql="select * from gangweixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>部门帐号</td>    <td align='center'>部门名称</td>    <td align='center'>联系电话</td>    <td align='center'>地址</td>    <td align='center'>岗位</td>        <td align='center'>学院审核</td>    <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=gangweixinxihsgb.getAllGangweixinxi(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bumenzhanghao}</td>    <td>${u.bumenmingcheng}</td>    <td>${u.lianxidianhua}</td>    <td>${u.dizhi}</td>    <td>${u.gangwei}</td>        <td>${u.xueyuanshenhe}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=gangweixinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

