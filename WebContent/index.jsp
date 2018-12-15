<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib prefix="s" uri="/struts-tags"%>
  <!--  2018.12.15 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/backgroud.css" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>登录</title>
</head>
<body  >
	
    	<diV class="container" style="background-image: inherit">
			<div class="jumbotron" style="background-image: inherit">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							
						</div>
						<div class="col-md-6">
							<h1>上机考试系统</h1>
						</div>
						<div class="col-md-2">
							
						</div>
					</div>
				</div>
			</div>
			<!--内容-->
			<div class="row">
				<div class="col-md-offset-4 col-md-4">
					<div class="container">
						<!--表单-->
						<s:form role="form"  method="post" action="LoginAction" namespace="/comman">
							<!--用户名-->
							<div class="row">
								<div class="container col-md-4">
									<div class="row">
										<div class="form-group">
											<label for="input_username">用户名：</label>
											<input title="请输入用户名" name="inputUsername" style="background-color: transparent;" class="form-control" id="input_username" type="text"/>
										</div>
									</div>
									<div class="row">
										<div id="input_username_message" class="text-right text-danger">
											
										</div>
									</div>
								</div>
							</div>
							<!--用户名-->
							<!--密码-->
							<div class="row">
								<div class="container col-md-4">	
									<div class="row">
										<div class="form-group">
											<label for="input_password">密码：</label>
											<input title="请输入你的密码" name="inputPassword" style="background-color: transparent;" class="form-control" id="input_password" type="password"/>
										</div>
									</div>
									<div class="row">
										<div id="input_password_message" class="text-right text-danger" style="visibility: hidden;">
											
										</div>
									</div>
								</div>
							</div>
							<!--密码-->
							<br />
							<!--用户类型-->
							<div class="row">
								<div class="container col-md-4">	
									<div class="row">
										<div class="form-group">
											<label for="name">选择列表</label>
    										<select class="form-control" style="background-color: transparent;" name="inputUsertype">
      											<option>管理员</option>
      											<option>教师</option>
     											<option>学生</option>
    										</select>
										</div>
									</div>
								</div>
							</div>
							<!--按钮-->
							<div class="row">
								<div class="container col-md-4">
									<div class="row">
										<button id="btn_ok" class="btn btn-primary col-xs-5">登录</button>
										<div class="col-xs-2"></div>
										<input id="btn_cancel" type="reset" class="btn btn-primary col-xs-5"></input>
									</div>
								</div>
							</div>
							<!--按钮-->
						</s:form>
						<!--表单-->
					</div>
				</div>			
				<div class="col-md-8"></div>
			</div>
	</diV>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>