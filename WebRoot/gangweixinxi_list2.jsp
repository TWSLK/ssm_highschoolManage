﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<TITLE>岗位信息查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	   <script language="javascript">
		   function zhifu(id,biao)
           {
                   window.location.href="zhifu/index.jsp?id="+id+"&biao="+biao;
           }
       </script>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">岗位信息列表</td>
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
								<form action="gangweixinxiList2.do" name="myform" method="post">
									查询   部门帐号：<input name="bumenzhanghao" type="text" id="bumenzhanghao" style='border:solid 1px #000000; color:#666666' size="12" />  部门名称：<input name="bumenmingcheng" type="text" id="bumenmingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  联系电话：<input name="lianxidianhua" type="text" id="lianxidianhua" style='border:solid 1px #000000; color:#666666' size="12" />  地址：<input name="dizhi" type="text" id="dizhi" style='border:solid 1px #000000; color:#666666' size="12" />  岗位：<input name="gangwei" type="text" id="gangwei" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>部门帐号</td>    <td align='center'>部门名称</td>    <td align='center'>联系电话</td>    <td align='center'>地址</td>    <td align='center'>岗位</td>        <td align='center'>学院审核</td>    <td  width='80' align='center'>是否审核</td>
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
                             <td>${u.bumenzhanghao}</td>    <td>${u.bumenmingcheng}</td>    <td>${u.lianxidianhua}</td>    <td>${u.dizhi}</td>    <td>${u.gangwei}</td>        <td>${u.xueyuanshenhe}</td>    <td align='center'>${u.issh} </td>
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateGangweixinxi.do?id=${u.id }">编辑</a>  <a href="deleteGangweixinxi.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="gangweixinxiDetail.do?id=${u.id }">详细</a></td>
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
              <a href="gangweixinxiList2.do?page=1" >首页</a>
             <a href="gangweixinxiList2.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="gangweixinxiList2.do?page=${page.page+1 }">下一页</a>
			<a href="gangweixinxiList2.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
