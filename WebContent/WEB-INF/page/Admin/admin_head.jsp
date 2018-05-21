<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="javax.servlet.http.HttpSession,org.apache.struts2.ServletActionContext"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>

	<%
		HttpSession msession = ServletActionContext.getRequest().getSession();
		System.out.println("欢迎，" + msession.getAttribute("username"));
	%>

<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<%-- <span class="brand"><strong>上机考试系统</strong></span> --%>

				<ul class="nav navbar-nav">
					<li><a id="first_page" href="LinkAction?index=<%= "0001" %>"><i class="icon-home icon-white"></i>首页</a></li>
					<li><a id="manage_teacher" href="LinkAction?index=<%= "0002" %>"><i class="icon-cog icon-white"></i>教师管理</a></li>
					<li><a id="operation_afterexam" href="LinkAction?index=<%= "0003" %>"><i class="icon-check icon-white"></i>考后操作</a></li>					
					<li><a id="setting" href="LinkAction?index=<%= "0004" %>"><i class="icon-cog icon-white"></i>系统配置</a></li>
				</ul>
				<ul class="nav navbar-nav pull-right">
					<li><a href="#"><i class="icon-share icon-white"></i>欢迎，<%= msession.getAttribute("username") %></a></li>
				</ul>

				<!--/.nav-collapse -->
			</div>
		</div>
</div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
</script>
</body>
</html>