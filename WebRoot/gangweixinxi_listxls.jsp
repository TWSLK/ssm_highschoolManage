<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="gangweixinxihsgb" scope="page" class="com.bean.GangweixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=gangweixinxi.xls");
%>
<html>
  <head>
    <title>��λ��Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from gangweixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>�����ʺ�</td>    <td align='center'>��������</td>    <td align='center'>��ϵ�绰</td>    <td align='center'>��ַ</td>    <td align='center'>��λ</td>        <td align='center'>ѧԺ���</td>    <td  width='80' align='center'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=gangweixinxihsgb.getAllGangweixinxi(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bumenzhanghao}</td>    <td>${u.bumenmingcheng}</td>    <td>${u.lianxidianhua}</td>    <td>${u.dizhi}</td>    <td>${u.gangwei}</td>        <td>${u.xueyuanshenhe}</td>    <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=gangweixinxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

