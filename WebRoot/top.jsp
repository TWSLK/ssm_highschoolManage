<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%
if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")=="")
{
	out.print("<script>javascript:alert('对不起，您已超时或未登陆,请在IE中重新打开登陆！');window.parent.location.href='login.jsp';</script>");
	out.close();
}
%>
<style type="text/css">
<!--

.STYLE7x {color: #FFFFFF}
.STYLE1 {color: #0033FF; font-size: 12px; }
-->
</style><body topmargin="0" bottom="0" leftmargin="0" rightmargin="0">
<table width="100%" height="99" border="0px" cellpadding="0" cellspacing="0">
<tr>
			<td height="68" colspan="3" style="background:url(images/head_bg.gif);"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="24%" height="50"><div style="font-family:宋体; color:#006633;  WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 24pt; margin-top:5pt">
                    <div align="center" class="STYLE5">高校困难生管理系统</div>
                </div></td>
                <td width="76%" valign="bottom"></td>
              </tr>
            </table></td>
</tr>
		<tr>
			<td height="30" colspan="3" style="font-size:12px;background:url(images/navsub_bg.gif) repeat-x;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="74%"><marquee behavior=alternate width=100% scrollAmount=3 class="STYLE1">
                    欢迎登陆我站，希望能给你带来好心情，其他话语请您自己修改，谢谢合作！（注：此处文字您可以在top.jsp中自己修改）
                  </MARQUEE></td>
                <td width="26%" align="right" class="STYLE1" style="padding-right:15px;">当前用户：${sessionScope.username} 权限：${sessionScope.cx} <a href="logout.jsp" target="_parent">退出</a> <a href="default.jsp" target="_parent">返回首页</a> </td>
              </tr>
            </table></td>
		</tr>
</table>
</body>