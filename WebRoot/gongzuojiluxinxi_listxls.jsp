<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="gongzuojiluxinxihsgb" scope="page" class="com.bean.GongzuojiluxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=gongzuojiluxinxi.xls");
%>
<html>
  <head>
    <title>工作记录信息</title>
  </head>

  <body >
 <%
			String sql="select * from gongzuojiluxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>部门帐号</td>    <td align='center'>部门名称</td>    <td align='center'>岗位</td>    <td align='center'>学号</td>    <td align='center'>姓名</td>    <td  width='40' align='center'>性别</td>    <td align='center'>工作记录</td>    <td  width='80' align='center'>是否审核</td><td  width='120'>审核回复</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=gongzuojiluxinxihsgb.getAllGongzuojiluxinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bumenzhanghao}</td>    <td>${u.bumenmingcheng}</td>    <td>${u.gangwei}</td>    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td align='center'>${u.xingbie}</td>    <td>${u.gongzuojilu}</td>    <td align='center'><a href="sh2.jsp?id=${u.id}&tablename=gongzuojiluxinxi">${u.issh}</a></td><td>${u.shhf}</td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

