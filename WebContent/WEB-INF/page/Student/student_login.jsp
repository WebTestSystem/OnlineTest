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
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<div class="span2">
							<dl>
								<dt>
									student
								</dt>
								<dd>
									劳力士创始人为汉斯.威尔斯多夫，1908年他在瑞士将劳力士注册为商标。
								</dd>
							</dl>
						</div>
						<div class="span6">
							<form class="form-horizontal"  action="student/LoginAction" method="post">
								<div class="control-group">
									 <label class="control-label" for="inputEmail">用户名</label>
									<div class="controls">
										<input id="inputId" type="text" name="inputUsername" class="form-control"/>
									</div>
								</div>
								<div class="control-group">
									 <label class="control-label" for="inputPassword">密码</label>
									<div class="controls">
										<input id="inputPassword" type="password" name="inputPasswword" class="form-control"/>
									</div>
								</div>
								<div class="control-group">
									<div class="controls">
										 <input type="checkbox" name="remenber">记住密码
                                         <button type="submit" class="btn btn-primary">登陆</button>                                                                      
									</div>
								</div>
							</form>
						</div>
						<div class="span4">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>