<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="yonggongbumenhsgb" scope="page" class="com.bean.YonggongbumenBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=yonggongbumen.xls");
%>
<html>
  <head>
    <title>�ù�����</title>
  </head>

  <body >
 <%
			String sql="select * from yonggongbumen  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>�����ʺ�</td>    <td align='center'>����</td>    <td align='center'>��������</td>    <td align='center'>������</td>    <td align='center'>��ϵ�绰</td>    <td align='center'>��ַ</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=yonggongbumenhsgb.getAllYonggongbumen(8);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bumenzhanghao}</td>    <td>${u.mima}</td>    <td>${u.bumenmingcheng}</td>    <td>${u.fuzeren}</td>    <td>${u.lianxidianhua}</td>    <td>${u.dizhi}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

