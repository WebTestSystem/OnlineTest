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

<div style="margin-left:20px;margin-top:60px">
<form class="exam-form form-inline" action="teacher_manage_notify_add"
	method="post">
	<h4>新增通知消息</h4>
	<input type="text" name="notice" placeholder="通知消息内容" />
	<button type="submit" class="btn btn-primary"><i class="icon-plus"></i> 添加</button>
</form>
</div>


<div class="container-fluid">
	<div class="row-fluid">
		<h4>已有通知消息</h4>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="span7">通知内容</th>
					<th class="span1">&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>
</div>


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>