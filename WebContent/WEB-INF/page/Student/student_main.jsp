<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="javax.servlet.http.HttpSession,org.apache.struts2.ServletActionContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生考试</title>
<style type="text/css"> 
.align-center{ 
position:fixed;left:50%;top:50%;margin-left:width/2;margin-top:height/2;border:1px solid #F00;
} 
.Up{  width:100px; height:100px; border:1px solid #F00; clear:both;}
.Down{ width:100px; height:100px; border:1px solid #F00; clear:both;}
</style>
</head>
<body>
<%
		HttpSession msession = ServletActionContext.getRequest().getSession();
	%>
<jsp:include page="student_head.jsp"></jsp:include>
<!-- loginsuccess！ -->
	<div class="align-center"> 
		<div class=".Up"><h3><%= msession.getAttribute("username") %> 上机考试中</h3></div>
		<div class=".Down">
			<div style="float:left;margin-left:7px;display:inline; padding-top:7px;border:1px solid #F00;">
				<h2>试卷下载</h2>
<!-- 				<a href="student/download_DownloadAction_downloadFile.action?fileName=6135_250x.jpg">试卷下载地址</a> -->
					<a href="${pageContext.request.contextPath}/student/DownLoadAction.action?number=1">点击下载</a>
			</div>
			<div style="padding-top:5px;float:right;padding-right:4px;border:1px solid #F00;">
				<h2>答案上传</h2>
				<form action="student/HandinAction" enctype="multipart/form-data" method="post">
	     			 上传文件:<input type="file" name="upload"/><br/>
	        		<input type="submit" value="提交"/>
	   			</form>
			</div>
		</div>
	</div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>