<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="teacher_head.jsp"></jsp:include>


<div class="container-fluid" style="margin-left:20px;margin-top:60px">
	<div class="row-fluid">
		<div class="span12 exam-info">
			<h4><strong>java</strong>进行情况：</h4>
			<p>参加考试学生总数： 1 </p>
			<p>已登录学生数量： <a class="btn-primary" href="teacher_manage_showbind"><i class="icon-search icon-white"></i>0</a>，
			未登录学生数量： <a class="btn-primary" href="teacher_manage_showunbind"><i class="icon-search icon-white"></i>1</a>
			</p>
			<p>已登录学生中，提交文件学生数量：<a class="btn-primary" href="teacher_manage_showsubmit"><i class="icon-search icon-white"></i>0</a>，
			未提交文件学生数量： <a class="btn-primary" href="teacher_manage_showunsubmit"><i class="icon-search icon-white"></i>0</a>
			</p>
		</div>
	</div>
</div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>