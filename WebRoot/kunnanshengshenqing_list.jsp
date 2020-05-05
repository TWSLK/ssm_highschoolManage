<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>困难生申请查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">困难生申请列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="kunnanshengshenqingList.do" name="myform" method="post">
									查询   学号：<input name="xuehao" type="text" id="xuehao" style='border:solid 1px #000000; color:#666666' size="12" />  姓名：<input name="xingming" type="text" id="xingming" style='border:solid 1px #000000; color:#666666' size="12" />  性别：<input name="xingbie" type="text" id="xingbie" style='border:solid 1px #000000; color:#666666' size="12" />  班级：<input name="banji" type="text" id="banji" style='border:solid 1px #000000; color:#666666' size="12" />  困难类别：<input name="kunnanleibie" type="text" id="kunnanleibie" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>学号</td>
    <td align='center'>姓名</td>
    <td  width='40' align='center'>性别</td>
    <td align='center'>班级</td>
    <td align='center'>申请理由</td>
    <td align='center'>教师审核</td>
    <td align='center'>学院审核</td>
    <td align='center'>学校审核</td>
    <td align='center'>困难类别</td>
    <td  width='80' align='center'>是否审核</td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.xuehao}</td>
    <td>${u.xingming}</td>
    <td align='center'>${u.xingbie}</td>
    <td>${u.banji}</td>
    <td>${u.shenqingliyou}</td>
    <td>${u.jiaoshishenhe}</td>
    <td>${u.xueyuanshenhe}</td>
    <td>${u.xuexiaoshenhe}</td>
    <td>${u.kunnanleibie}</td>
    <td align='center'>${u.issh} <input type="button" value="审核" onClick="javascript:location.href='sh3.jsp?id=${u.id}&yuan=${u.issh}&xuehao=${u.xuehao}&kunnanleibie=${u.kunnanleibie}&tablename=kunnanshengshenqing'"/></td>
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateKunnanshengshenqinglb3.do?id=${u.id }">审核</a> <a href="doUpdateKunnanshengshenqing.do?id=${u.id }">编辑</a>  <a href="deleteKunnanshengshenqing.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="kunnanshengshenqingDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="kunnanshengshenqingList.do?page=1" >首页</a>
             <a href="kunnanshengshenqingList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="kunnanshengshenqingList.do?page=${page.page+1 }">下一页</a>
			<a href="kunnanshengshenqingList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
