<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="zhuxuejinhsgb" scope="page" class="com.bean.ZhuxuejinBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zhuxuejin.xls");
%>
<html>
  <head>
    <title>助学金</title>
  </head>

  <body >
 <%
			String sql="select * from zhuxuejin  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>学号</td>    <td align='center'>姓名</td>    <td  width='40' align='center'>性别</td>    <td align='center'>困难类别</td>    <td align='center'>申请理由</td>    <td align='center'>学院审核</td>    <td align='center'>学校审核</td>    <td align='center'>助学金额</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=zhuxuejinhsgb.getAllZhuxuejin(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td align='center'>${u.xingbie}</td>    <td>${u.kunnanleibie}</td>    <td>${u.shenqingliyou}</td>    <td>${u.xueyuanshenhe}</td>    <td>${u.xuexiaoshenhe}</td>    <td>${u.zhuxuejine}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

