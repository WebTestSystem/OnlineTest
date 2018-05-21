<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="teacher_head.jsp"></jsp:include>

<div style="margin-left:20px;margin-top:60px">

<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th class="span3">考试名称</th>
			<th class="span3">考试时间</th>
			<th>创建人</th>
			<th>上传试卷</th>
			<th>自动开始</th>
			<th>进行中</th>
			<th>已结束</th>
			<th>已归档</th>
			<th>已清理</th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		
		<tr>
			<td>java</td>
			<td>2018-4-10 15:29:12</td>
			<td>1</td>
			<td></td>
			<td><i class="icon-ok"></i></td>
			<td><i class="icon-ok"></i></td>
			<td></td>
			<td></td>
			<td></td>
			<td>			
					<a class="btn btn-primary" href="teacher_exam_finish?id=1"><i class="icon-off"></i>停止考试</a>							
			</td>
		</tr>
		
	</tbody>
</table>

</div>



    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>