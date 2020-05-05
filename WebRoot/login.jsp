<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="code" scope="page" class="com.util.CheckCode" />
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<title>高校困难生管理系统</title>

<style type="text/css">
<!--

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	
	background-repeat: repeat-x;
	background-color: #075EC8;
}
.STYLE6 {color: #FFFFFF}
.STYLE5 {color: #CCFFCC;
	font-size: 26pt;
}
.STYLE3 {color: #FFFFFF; font-size:12px}
-->
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
	<script type="text/javascript">
	function hsgchecklogin() {
	if(document.f11.username.value=="" || document.f11.pwd.value=="" || document.f11.pagerandom.value=="")
	{
		alert("请输入完整");
		return false;
	}
	if (document.f11.pagerandom.value != document.f11.yzm.value) {
			alert("验证码错误！");
			document.f11.pagerandom.focus();
			return false;
	}
	
	}
	</script>      
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="993" height="583" border="0" align="center" cellpadding="0" cellspacing="0" background="images/hsgbg.jpg" id="__01">
  <tr>
    <td height="180" colspan="3" ><table width="64%" height="138" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="56"><div style="font-family:宋体; color:#ffffff; WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 28pt; margin-top:5pt">
      <div align="center" >高校困难生管理系统</div>
    </div></td>
      </tr>
      <tr>
        <td height="80">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td width="314" rowspan="2">&nbsp;</td>
    <td width="352" height="271" >
	
	 <form name="f11" id="f11" method="post" action="hsgloginyanzheng.jsp"><table width="205" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="44" height="30"><span class="STYLE3">用户:</span></td>
                <td height="30" colspan="2"><input name="username" type="text" id="username" style="width:100px; height:16px; border:solid 1px #000000; color:#666666"></td>
              </tr>
              <tr>
                <td height="30"><span class="STYLE3">密码:</span></td>
                <td height="30" colspan="2"><input name="pwd" type="password" id="pwd" style="width:100px; height:16px; border:solid 1px #000000; color:#666666"></td>
              </tr>
              <tr>
                <td height="30"><span class="STYLE3">权限:</span></td>
                <td height="30" colspan="2"><select name="cx" id="cx">
                    <option value="管理员">管理员</option>
<option value="教师">教师</option>
<option value="学生">学生</option>
<option value="困难生">困难生</option>
<option value="学院">学院</option>
<option value="用工部门">用工部门</option>

                  </select>
                </td>
              </tr>
              <tr>
                <td height="30"><span class="STYLE3">验证码:</span></td>
                <td width="59" height="30"><input name="pagerandom" type="text" id="pagerandom" style=" height:20px; border:solid 1px #000000; color:#666666; width:50px" />
                <td width="102"><%
								String yzm=code.getCheckCode();
								%>  <input type="hidden" name="yzm" value="<%=yzm %>" >
								   <span class="STYLE3"><%=yzm %></span></td>
              </tr>
              <tr>
                <td height="30" colspan="3"><input type="submit" name="Submit" value="登陆" onClick="return hsgchecklogin();">
                    <input type="reset" name="Submit2" value="重置"></td>
              </tr>
            </table>	</form>
			
			</td>
    <td width="336" rowspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td height="132">&nbsp;</td>
  </tr>
</table>
</body>
</html>