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
		<TITLE>添加勤工助学</TITLE>
	    

 	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>      
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="qingongzhuxue_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addQingongzhuxue.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加勤工助学</td>
						</tr>
						<tr ><td width="200">部门帐号：</td><td><input name='bumenzhanghao' type='text' id='bumenzhanghao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.bumenzhanghao.value='<%=connDbBean.readzd("gangweixinxi","bumenzhanghao","id",request.getParameter("id"))%>';document.form1.bumenzhanghao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">部门名称：</td><td><input name='bumenmingcheng' type='text' id='bumenmingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.bumenmingcheng.value='<%=connDbBean.readzd("gangweixinxi","bumenmingcheng","id",request.getParameter("id"))%>';document.form1.bumenmingcheng.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.lianxidianhua.value='<%=connDbBean.readzd("gangweixinxi","lianxidianhua","id",request.getParameter("id"))%>';document.form1.lianxidianhua.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.dizhi.value='<%=connDbBean.readzd("gangweixinxi","dizhi","id",request.getParameter("id"))%>';document.form1.dizhi.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">岗位：</td><td><input name='gangwei' type='text' id='gangwei' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.gangwei.value='<%=connDbBean.readzd("gangweixinxi","gangwei","id",request.getParameter("id"))%>';document.form1.gangwei.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">学号：</td><td><input name='xuehao' type='text' id='xuehao' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("xueshengxinxi","xingming","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">性别：</td><td><input name='xingbie' type='text' id='xingbie' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.xingbie.value='<%=connDbBean.readzd("xueshengxinxi","xingbie","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingbie.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">班级：</td><td><input name='banji' type='text' id='banji' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.banji.value='<%=connDbBean.readzd("xueshengxinxi","banji","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.banji.setAttribute("readOnly",'true');</script>
		
		
						<tr align='center'   height="22">
						    <td width="200"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






