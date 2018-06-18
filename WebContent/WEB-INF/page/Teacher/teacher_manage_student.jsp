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


<div class="container-fluid" style="margin-left:20px;margin-top:60px">
	<div class="row-fluid">
		<div class="span12">
			 <button class="btn btn-block btn-primary btn-large" type="button">返回</button>
			<form class="form-inline">
				<fieldset>
					<h4>单个导入学生信息</h4>
                    <input type="text" name="studentid" placeholder="学号"/>
                    <input type="text" name="studentname" placeholder="姓名"/>
                    <input type="text" name="sttudentclass" placeholder="班级"/>
                    <input type="text"  placeholder="用户名"/> 
                    <button type="submit" class="btn btn-primary">添加</button>
				</fieldset>
			</form>
			<table class="table">
				<thead>
					<tr>
						<th>
							学号
						</th>
						<th>
							姓名
						</th>
						<th>
							班级
						</th>
						<th>
						</th>
					</tr>
				</thead>

                <tbody>
                      <tr>
                     
                      </tr>
                </tbody>
				
			</table>
			<form class="form-inline">
				<fieldset>
					<legend><strong>批量导入学生信息</strong></legend>
                    <span class="help-block">请选择学生信息文件.</span>
                    <button class="btn btn-warning" type="button">浏览</button>
                    <button class="btn btn-primary" type="submit">上传</button>
				</fieldset>
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