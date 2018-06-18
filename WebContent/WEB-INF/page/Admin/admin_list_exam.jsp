<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="tool.ORMTool,java.util.List,org.hibernate.Query,bean.Teacher"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员-考后操作</title>
</head>
<body >
<jsp:include page="admin_head.jsp"></jsp:include>
<div style="margin-left:50px;margin-top:60px">

<div >
	<div class="row-fluid">
		<div class="span12" class="container-fluid">
			<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>考试编号</th>
			<th>考试科目</th>
			<th>考试时间</th>
			<th>执行操作</th>
		</tr>
	</thead>
	<tbody>
						<%
							ORMTool ormtool = new ORMTool();
							ormtool.initSession();
							String hql = "select e.examnumber,e.examsubject,e.examdata from Exam e";
							Query query = ormtool.getQuery(hql);
							List<Object[]> list = query.list();
							System.out.println(list.size());
							for(Object[] obj : list)
							{
								%>
								<tr>
								<td><%= obj[0]%></td>
								<td><%= obj[1]%></td>
								<td><%= obj[2]%></td>
								<td><button name="<%= obj[0]%>"  class="btn btn_delete" type="button">删除考试数据</button></td>
								</tr>
								<% 
							}
						%>
				</tbody>
</table>
		</div>
	</div>
</div>


</div>



    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    
    
  			//此处实际数据库操作已经成功，但方法的转向始终是error
			 $('.btn_delete').click(function() {
                    var examnumber = this.name;

                    //${pageContext.request.contextPath}/Admin/AddTeacherAction
                $.ajax({ 
                    type : "post",
                    url : "${pageContext.request.contextPath}/ajaxaction/DeleteExamAction",
                    data : {
                    	examnumber : examnumber
                    },
                    dataType:"json",
            
                    success : function(data) {
                    	document.location.reload();
                    },

                    error : function() {
                        alert("操作成功");
                        document.location.reload();
                    }
                });
            });
		 
    </script>
</body>
</html>