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

<form class="exam-form form-inline" action="teacher_manage_binding_search"
	method="post">
	<h4>按学生查找已登录信息</h4>
	<input type="text" name="sno" placeholder="学号" size="20" />
	<input type="text" name="sname" placeholder="姓名" size="20" />
	<input type="text" name="sclass" placeholder="班级" size="20" />
	<button type="submit" class="btn btn-primary"><i class="icon-search"></i> 查找</button>
</form>

<form class="exam-form form-inline" action="teacher_manage_binding_searchip"
	method="post">
	<h4>按ip地址查找已登录信息</h4>
	<input type="text" name="ip" placeholder="ip地址" size="20" />
	<button type="submit" class="btn btn-primary"><i class="icon-search"></i> 查找</button>
</form>

</div>


<div class="container-fluid">
	<div class="row-fluid">
		<h4>查找结果</h4>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="span3">学号</th>
					<th class="span2">姓名</th>
					<th class="span3">班级</th>
					<th class="span3">ip地址</th>
					<th>&nbsp;</th>
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