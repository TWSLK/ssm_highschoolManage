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
		<TITLE>修改岗位信息</TITLE>
	    
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
	document.location.href="gangweixinxi_add.jsp?id=<%=id%>";
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
			<form action="updateGangweixinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改岗位信息<input type="hidden" name="id" value="${gangweixinxi.id}" /></td>
						</tr>
						<tr ><td width="200">部门帐号：</td><td><input name='bumenzhanghao' type='text' id='bumenzhanghao' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">部门名称：</td><td><input name='bumenmingcheng' type='text' id='bumenmingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.bumenmingcheng.value='<%=connDbBean.readzd("yonggongbumen","bumenmingcheng","bumenzhanghao",(String)request.getSession().getAttribute("username"))%>';document.form1.bumenmingcheng.setAttribute("readOnly",'true');</script>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.lianxidianhua.value='<%=connDbBean.readzd("yonggongbumen","lianxidianhua","bumenzhanghao",(String)request.getSession().getAttribute("username"))%>';document.form1.lianxidianhua.setAttribute("readOnly",'true');</script>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.dizhi.value='<%=connDbBean.readzd("yonggongbumen","dizhi","bumenzhanghao",(String)request.getSession().getAttribute("username"))%>';document.form1.dizhi.setAttribute("readOnly",'true');</script>		<tr ><td width="200">岗位：</td><td><input name='gangwei' type='text' id='gangwei' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelgangwei' /></td></tr>		<tr ><td width="200">详细：</td><td><textarea name='xiangxi' cols='50' rows='5' id='xiangxi' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		<tr style='display:none'><td width="200">学院审核：</td><td><input name='xueyuanshenhe' type='text' id='xueyuanshenhe' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bumenzhanghao.value='${gangweixinxi.bumenzhanghao}';</script>	<script language="javascript">document.form1.bumenmingcheng.value='${gangweixinxi.bumenmingcheng}';</script>	<script language="javascript">document.form1.lianxidianhua.value='${gangweixinxi.lianxidianhua}';</script>	<script language="javascript">document.form1.dizhi.value='${gangweixinxi.dizhi}';</script>	<script language="javascript">document.form1.gangwei.value='${gangweixinxi.gangwei}';</script>	<script language="javascript">document.form1.xiangxi.value='${gangweixinxi.xiangxi}';</script>	<script language="javascript">document.form1.xueyuanshenhe.value='${gangweixinxi.xueyuanshenhe}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var gangweiobj = document.getElementById("gangwei"); if(gangweiobj.value==""){document.getElementById("clabelgangwei").innerHTML="&nbsp;&nbsp;<font color=red>请输入岗位</font>";return false;}else{document.getElementById("clabelgangwei").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
