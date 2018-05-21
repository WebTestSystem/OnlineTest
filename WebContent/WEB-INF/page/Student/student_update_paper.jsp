<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="tool.ORMTool,java.util.List,org.hibernate.Query,bean.Teacher,javax.servlet.http.HttpSession,org.apache.struts2.ServletActionContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/boostrap-darepicker.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/laydate/laydate.js"></script> <!-- 日期控件 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.my-modal.1.1.winStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.my-modal.1.1.js"></script>
<script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看提交</title>
</head>
<body>

	<div><jsp:include page="student_head.jsp"></jsp:include></div>
	<div style="margin:60px 10px 60px 10px">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>上传文件名</th>
					<th>上传时间</th>
				</tr>
			</thead>
			<tbody>
								<%
									System.out.print("test");
									ORMTool ormtool = new ORMTool();
									ormtool.initSession();
									String hql = "select s.uploadFileName,s.uploadFileDate from Student s";
									Query query = ormtool.getQuery(hql);
									List<Object[]> list = query.list();
									//System.out.println(list.size());
									//application.setAttribute("examamount", list.size());
									for(Object[] obj : list)
									{
										%>
										<tr>
											<td><%= obj[0]%></td>
											<td><%= obj[1]%></td>
										</tr>
										<% 
									}
								%>
						</tbody>
		</table>
	</div>
	<hr>
	<div style="margin:20px 10px 60px 500px">
		<h2>答案上传</h2>
		<form action="student/HandinAction" enctype="multipart/form-data" method="post">
	     	 上传文件:<input type="file" name="upload"/><br/>
	       <input type="submit" value="提交"/>
		</form>
	</div>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>