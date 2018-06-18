<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="javax.servlet.http.HttpSession,org.apache.struts2.ServletActionContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<%
		HttpSession msession = ServletActionContext.getRequest().getSession();
		System.out.println("欢迎，" + msession.getAttribute("username"));
	%>


<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<span class="brand"><strong>上机考试系统</strong></span>
<!-- <a class="dropdown-toggle" role="button" aria-expanded="false" aria-haspopup="true" data-toggle="dropdown"> -->
				<ul class="nav navbar-nav">
					<li><a href="LinkAction?index=<%= "1000" %>"><i class="glyphicon glyphicon-home glyphicon-white"></i>首页</a></li>
					<li><a href="LinkAction?index=<%= "1005" %>"><i class="glyphicon glyphicon-cog glyphicon-white"></i>考试操作</a></li>
					<!-- <li class="dropdown"><a class="dropdown-toggle" role="button" aria-expanded="false" aria-haspopup="true" data-toggle="dropdown">
					<i class="icon-time icon-white"></i>学生管理 -->
					<!-- <span class="caret"></span></a>
						<ul class="dropdown-menu"> -->
							<%-- <li><a href="LinkAction?index=<%= "1009" %>"><i class="icon-align-justify"></i>考试概况</a></li> --%>
							<li><a href="LinkAction?index=<%= "1008" %>"><i class="glyphicon glyphicon-align-justify glyphicon-white"></i>学生管理</a></li>
<%-- 							<li><a href="LinkAction?index=<%= "1010" %>"><i class="icon-lock"></i>解除锁定</a></li>
							<li><a href="LinkAction?index=<%= "1007" %>"><i class="icon-bell"></i>通知管理</a></li> --%>
						<!-- </ul>
					</li> -->
				</ul>
				<ul class="nav navbar-nav pull-right">
					<li><a href="LinkAction?index=<%= "0000" %>"><i class="icon-share icon-white"></i>欢迎，<%= msession.getAttribute("username") %></a></li>
				</ul>

				<!--/.nav-collapse -->
			</div>
		</div>
</div>


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>