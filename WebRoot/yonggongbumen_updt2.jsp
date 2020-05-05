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
		<TITLE>修改用工部门</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>


	<body>
			<form action="updateYonggongbumen2.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改用工部门<input type="hidden" name="id" value="${yonggongbumen.id}" /></td>
						</tr>
						<tr ><td width="200">部门帐号：</td><td><input name='bumenzhanghao' type='text' id='bumenzhanghao' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelbumenzhanghao' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmima' /></td></tr>		<tr ><td width="200">部门名称：</td><td><input name='bumenmingcheng' type='text' id='bumenmingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelbumenmingcheng' /></td></tr>		<tr ><td width="200">负责人：</td><td><input name='fuzeren' type='text' id='fuzeren' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelfuzeren' /></td></tr>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabellianxidianhua' /></td></tr>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bumenzhanghao.value='${yonggongbumen.bumenzhanghao}';</script>	<script language="javascript">document.form1.mima.value='${yonggongbumen.mima}';</script>	<script language="javascript">document.form1.bumenmingcheng.value='${yonggongbumen.bumenmingcheng}';</script>	<script language="javascript">document.form1.fuzeren.value='${yonggongbumen.fuzeren}';</script>	<script language="javascript">document.form1.lianxidianhua.value='${yonggongbumen.lianxidianhua}';</script>	<script language="javascript">document.form1.dizhi.value='${yonggongbumen.dizhi}';</script>	
					 </table>
			</form>
   </body>
</html>



<!--hssgchesck-->


<script language=javascript >  
 
 function checkform(){  
 
	var bumenzhanghaoobj = document.getElementById("bumenzhanghao"); if(bumenzhanghaoobj.value==""){document.getElementById("clabelbumenzhanghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入部门帐号</font>";return false;}else{document.getElementById("clabelbumenzhanghao").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var bumenmingchengobj = document.getElementById("bumenmingcheng"); if(bumenmingchengobj.value==""){document.getElementById("clabelbumenmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入部门名称</font>";return false;}else{document.getElementById("clabelbumenmingcheng").innerHTML="  "; } 	var fuzerenobj = document.getElementById("fuzeren"); if(fuzerenobj.value==""){document.getElementById("clabelfuzeren").innerHTML="&nbsp;&nbsp;<font color=red>请输入负责人</font>";return false;}else{document.getElementById("clabelfuzeren").innerHTML="  "; } 	var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value==""){document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>请输入联系电话</font>";return false;}else{document.getElementById("clabellianxidianhua").innerHTML="  "; } 	var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(lianxidianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxidianhuaobj.value)){document.getElementById("clabellianxidianhua").innerHTML=""; }else{document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
