﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%
if(request.getSession().getAttribute("cx").equals("超级管理员") || request.getSession().getAttribute("cx").equals("普通管理员")){response.sendRedirect("left_guanliyuan.jsp");}
if(request.getSession().getAttribute("cx").equals("教师")){response.sendRedirect("left_jiaoshi.jsp");}
if(request.getSession().getAttribute("cx").equals("学生")){response.sendRedirect("left_xuesheng.jsp");}
if(request.getSession().getAttribute("cx").equals("困难生")){response.sendRedirect("left_xuesheng2.jsp");}
if(request.getSession().getAttribute("cx").equals("学院")){response.sendRedirect("left_xueyuan.jsp");}
if(request.getSession().getAttribute("cx").equals("用工部门")){response.sendRedirect("left_yonggongbumen.jsp");}

 %>
  </body>
</html>