<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<HTML>
<HEAD>
<TITLE>后台管理导航</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
<link rel="stylesheet" href="images/CssAdmin2.css">
<SCRIPT language=javascript>
function collapse(objid)
{
	var obj = document.getElementById(objid);
	collapseAll();
	obj.style.display = '';
}
function collapseAll()
{
	for (var i=1; i<=28; i++)
	{
		var obj = document.getElementById('submenu' + i.toString());
		if (obj) obj.style.display = 'none';
	}
}
function expandAll()
{
	for (var i=1; i<=28; i++)
	{
		var obj = document.getElementById('submenu' + i.toString());
		if (obj) obj.style.display = '';
	}
}
</SCRIPT>
</HEAD>

<BODY background="images/SysLeft_bg.gif" onmouseover="self.status='专业为本 服务为先!';return true">
<table width="180" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="44" valign="top"><img src="images/title.gif"></td>
  </tr>
</table>
<table cellpadding="0" cellspacing="0" width="180" align="center">
  
  <tr>
    <td height="97" background="images/title_bg_admin.gif" style="display:" id="submenu0">
      <div  style="width:167">
        <table cellpadding="0" cellspacing="0" align="center" width="130">
          <tr>
            <td height="20"></td>
          </tr>
        </table>
      </div></td>
  </tr>
</table>

<table cellpadding="0" cellspacing="0" width="167" align="center">
  <tr>
    <td height="28" class="menu_title" onMouseOver="this.className='menu_title2'" onMouseOut="this.className='menu_title'" background="images/admin_left_01.gif" id="menuTitle1" onClick="collapse('submenu1')" style="cursor:pointer;"><span class="SystemLeft">个人资料管理</span></td>
  </tr>
  <tr>
    <td style="display:none" align="right" id="submenu1"><div class="sec_menu" style="width:165">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" background="images/SysLeft_bg_link.gif">
	
<tr>
      <td width="36" height="22"></td>
      <td class="SystemLeft"><a href="doUpdateJiaoshixinxi2.do" target="hsgmain">修改个人资料</a></td>
    </tr>

  </table>
    </div>
      <div  style="width:167">
        <table cellpadding="0" cellspacing="0" align="center" width="130">
          <tr>
            <td height="5"></td>
          </tr>
        </table>
      </div></td>
  </tr>
</table>



<!--
<table cellpadding="0" cellspacing="0" width="167" align="center">
  <tr>
    <td height="28" class="menu_title" onMouseOver="this.className='menu_title2'" onMouseOut="this.className='menu_title'" background="images/admin_left_01.gif" id="menuTitle1" onClick="collapse('submenu2')" style="cursor:pointer;"><span class="SystemLeft">困难生申请管理</span></td>
  </tr>
  <tr>
    <td style="display:none" align="right" id="submenu2"><div class="sec_menu" style="width:165">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" background="images/SysLeft_bg_link.gif">
	
<tr>
      <td width="36" height="22"></td>
      <td class="SystemLeft"><a href="kunnanshengshenqing_add.jsp" target="hsgmain">困难生申请添加</a></td>
    </tr>

<tr>
      <td width="36" height="22"></td>
      <td class="SystemLeft"><a href="kunnanshengshenqingList2.do" target="hsgmain">困难生申请查询</a></td>
    </tr>

  </table>
    </div>
      <div  style="width:167">
        <table cellpadding="0" cellspacing="0" align="center" width="130">
          <tr>
            <td height="5"></td>
          </tr>
        </table>
      </div></td>
  </tr>
</table>-->
<table cellpadding="0" cellspacing="0" width="167" align="center">
  <tr>
    <td height="28" class="menu_title" onMouseOver="this.className='menu_title2'" onMouseOut="this.className='menu_title'" background="images/admin_left_01.gif" id="menuTitle1" onClick="collapse('submenu3')" style="cursor:pointer;"><span class="SystemLeft">困难生申请管理</span></td>
  </tr>
  <tr>
    <td style="display:none" align="right" id="submenu3"><div class="sec_menu" style="width:165">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" background="images/SysLeft_bg_link.gif">
	
<%--<tr>
      <td width="36" height="22"></td>
      <td class="SystemLeft"><a href="kunnanshengshenqing_add.jsp" target="hsgmain">困难生申请添加</a></td>
    </tr>--%>

<tr>
      <td width="36" height="22"></td>
      <td class="SystemLeft"><a href="kunnanshengshenqingList3.do" target="hsgmain">困难生申请查询</a></td>
    </tr>

  </table>
    </div>
      <div  style="width:167">
        <table cellpadding="0" cellspacing="0" align="center" width="130">
          <tr>
            <td height="5"></td>
          </tr>
        </table>
      </div></td>
  </tr>
</table>



<table cellpadding="0" cellspacing="0" width="167" align="center">
  <tr>
    <td height="28" class="menu_title" onMouseOver="this.className='menu_title2'" onMouseOut="this.className='menu_title'" background="images/admin_left_01.gif" id="menuTitle1" onClick="collapse('submenu5')" style="cursor:pointer;"><span class="SystemLeft">学生管理</span></td>
  </tr>
  <tr>
    <td style="display:none" align="right" id="submenu5"><div class="sec_menu" style="width:165">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" background="images/SysLeft_bg_link.gif">
	
<tr>
      <td width="36" height="22"></td>
      <td class="SystemLeft"><a href="xueshengxinxiList2.do" target="hsgmain">学生查询</a></td>
    </tr>

  </table>
    </div>
      <div  style="width:167">
        <table cellpadding="0" cellspacing="0" align="center" width="130">
          <tr>
            <td height="5"></td>
          </tr>
        </table>
      </div></td>
  </tr>
</table>




<table cellpadding="0" cellspacing="0" width="167" align="center">
  <tr>
    <td height="28" class="menu_title" onMouseOver="this.className='menu_title2'" onMouseOut="this.className='menu_title'" background="images/admin_left_01.gif" id="menuTitle1" onClick="collapse('submenu14')" style="cursor:pointer;"><span class="SystemLeft">勤工助学管理</span></td>
  </tr>
  <tr>
    <td style="display:none" align="right" id="submenu14"><div class="sec_menu" style="width:165">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" background="images/SysLeft_bg_link.gif">


<tr>
      <td width="36" height="22"></td>
      <td class="SystemLeft"><a href="qingongzhuxueList3.do" target="hsgmain">勤工助学查询</a></td>
    </tr>

  </table>
    </div>
      <div  style="width:167">
        <table cellpadding="0" cellspacing="0" align="center" width="130">
          <tr>
            <td height="5"></td>
          </tr>
        </table>
      </div></td>
  </tr>
</table>











<table cellpadding="0" cellspacing="0" width="167" align="center">
  <tr>
    <td height="28" class="menu_title" onMouseOver="this.className='menu_title2'" onMouseOut="this.className='menu_title'" background="images/admin_left_14.gif" id="menuTitle208"><span>系统信息</span>    </td>
  </tr>
  <tr>
    <td align="right"><div class="sec_menu" style="width:165">
        <table cellpadding="0" cellspacing="0" align="center" width="147">
          <tr>
            <td width="145" height="20"><span style="line-height: 150%;">版本： 
                V1.0 <br>
Copyright：<font color="000000"
					>xxxxx</font><br>
Design By： <font color="000000">xxxxx</font></span><br />
              <br />
            </td>
          </tr>
        </table>
      </div></td>
  </tr>
</table>
</BODY>
</HTML>