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
			<form class="form-inline">
				<fieldset>
					<h4>
						编辑考试信息
					</h4><input type="text" /><input type="text" />
					<div class="controls input-append date" id="datetimepicker">
						<input class="span2" size="16" type="text" /> 
                        <span class="add-on"><em class="icon-remove"></em></span>
                        <span class="add-on"> <em class="icon-remove"&gt;></em></span>
					</div> <label class="checkbox"><input type="checkbox" /> 自动开始</label> <button type="submit" class="btn btn-primary">提交</button>
				</fieldset>
			</form>
			<form class="form-inline">
				<fieldset>
					<legend><strong>上传试卷</strong></legend> 
                    <span class="help-block">请选择试卷文件.</span>
                    <button class="btn btn-warning" type="button">浏览</button>
                    <button class="btn btn-primary" type="submit">上传</button>
				</fieldset>
			</form>
			<form class="form-inline">
				<fieldset>
					 <legend><strong>添加学生信息</strong></legend> 
                     <span class="help-block">请添加考试学员信息.</span>
                     <button class="btn btn-primary" type="submit">添加学生信息</button>
				</fieldset>
			</form>
			<form>
				<fieldset>
					<legend><strong>开始考试</strong></legend> 
                    <span class="help-block">这里填写帮助信息.</span> 
                    <button class="btn btn-warning btn-large" type="submit">开始考试</button>
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