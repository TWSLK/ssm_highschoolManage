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
		<TITLE>修改助学金</TITLE>
	    
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
	document.location.href="zhuxuejin_add.jsp?id=<%=id%>";
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
			<form action="updateZhuxuejin.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改助学金<input type="hidden" name="id" value="${zhuxuejin.id}" /></td>
						</tr>
						<tr ><td width="200">学号：</td><td><input name='xuehao' type='text' id='xuehao' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelxuehao' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("xueshengxinxi","xingming","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		<tr ><td width="200">性别：</td><td><input name='xingbie' type='text' id='xingbie' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.xingbie.value='<%=connDbBean.readzd("xueshengxinxi","xingbie","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingbie.setAttribute("readOnly",'true');</script>		<tr ><td width="200">困难类别：</td><td><input name='kunnanleibie' type='text' id='kunnanleibie' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.kunnanleibie.value='<%=connDbBean.readzd("xueshengxinxi","kunnanleibie","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.kunnanleibie.setAttribute("readOnly",'true');</script>		<tr ><td width="200">申请理由：</td><td><input name='shenqingliyou' type='text' id='shenqingliyou' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr style='display:none'><td width="200">学院审核：</td><td><select name='xueyuanshenhe' id='xueyuanshenhe'><option value="通过">通过</option><option value="不通过">不通过</option></select></td></tr>		<tr style='display:none'><td width="200">学校审核：</td><td><select name='xuexiaoshenhe' id='xuexiaoshenhe'><option value="通过">通过</option><option value="不通过">不通过</option></select></td></tr>		<tr style='display:none'><td width="200">助学金额：</td><td><input name='zhuxuejine' type='text' id='zhuxuejine' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.xuehao.value='${zhuxuejin.xuehao}';</script>	<script language="javascript">document.form1.xingming.value='${zhuxuejin.xingming}';</script>	<script language="javascript">document.form1.xingbie.value='${zhuxuejin.xingbie}';</script>	<script language="javascript">document.form1.kunnanleibie.value='${zhuxuejin.kunnanleibie}';</script>	<script language="javascript">document.form1.shenqingliyou.value='${zhuxuejin.shenqingliyou}';</script>	<script language="javascript">document.form1.xueyuanshenhe.value='${zhuxuejin.xueyuanshenhe}';</script>	<script language="javascript">document.form1.xuexiaoshenhe.value='${zhuxuejin.xuexiaoshenhe}';</script>	<script language="javascript">document.form1.zhuxuejine.value='${zhuxuejin.zhuxuejine}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var xuehaoobj = document.getElementById("xuehao"); if(xuehaoobj.value==""){document.getElementById("clabelxuehao").innerHTML="&nbsp;&nbsp;<font color=red>请输入学号</font>";return false;}else{document.getElementById("clabelxuehao").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
