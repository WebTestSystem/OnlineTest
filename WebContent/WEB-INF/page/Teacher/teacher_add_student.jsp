<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="tool.SessionTool"%>
<%@page import="AES.AESUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="tool.ORMTool,java.util.List,org.hibernate.Query,bean.Teacher"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<!--win风格-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.my-modal.1.1.winStyle.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.my-modal.1.1.js"></script>
	<script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
		<!--自己的css-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/locate.css" />
	<title>添加学生</title>
</head>
<body>
<%
	HttpSession msession = ServletActionContext.getRequest().getSession();
	System.out.println("hahahah" + msession.getAttribute("username"));
%>
<jsp:include page="teacher_head.jsp"></jsp:include>

<div class="m-modal">
			<div class="m-modal-dialog">
				<div class="m-top">
					<h4 class="m-modal-title">
						编辑
					</h4>
					<span class="m-modal-close">&times;</span>
				</div>
				<div class="m-middle">
					<form>
						<fieldset>
							  <label>名字</label>
							  <input type="text" id="modal_studentname"/>
							  <br>
							  <label>编号</label>
							  <input type="text" id="modal_studentnumber"/>
						</fieldset>
					</form>
				</div>
				<div class="m-bottom">
					<button id="btn_modal_sure" class="m-btn-sure">确定</button>
					<button class="m-btn-cancel">取消</button>
				</div>
			</div>
</div>

<div class="container-fluid" style="margin-left:20px;margin-top:60px">
	<div class="row-fluid">
		<div class="span12">
<!-- 			<form class="form-inline horizatal_center600">
				<fieldset>
					<h4>单个导入学生信息</h4>
                    <input type="text" name="studentname" id="studentname" placeholder="姓名"/>
                    <input type="text" name="studentpassword" id="studentpassword" placeholder="学号"/>
                    <input type="text" name="studentclass" id="studentclass" placeholder="班级"/>
                    <button id="btn_one_submit" class="btn btn-primary">添加</button>
				</fieldset>
			</form>

			<form action="SwitchAction" method="post" class="form-inline" enctype="multipart/form-data"> 
				文件：
            	<input type="file" name="uploadImage">
            	<input type="submit" value="提交" id="btn_fileupload">
			</form> -->
			
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							姓名
						</th>
						<th>
							学号
						</th>
						<th>
							状态
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>

               <tbody>
						<%
						    //msession.getAttribute("teachernumber");
						   
							ORMTool ormtool = new ORMTool();
							ormtool.initSession();
							String hql = "select s.studenttag,s.studentname,s.studentnumber,s.status from Student s";
							Query query = ormtool.getQuery(hql);
							List<Object[]> list = query.list();
							System.out.println(list.size());
							for(Object[] obj : list)
							{
								String studentnumber=msession.getAttribute("teachernumber").toString();
								
								System.out.println(obj[0].toString().substring(0,20));
								if(obj[0].toString().substring(0,20).equals(studentnumber))
								{
								//jiemi
								String key="666";
								String obj1=obj[1].toString();
								String obj2=obj[2].toString();
								String de_studentname=AESUtils.decrypt(key, obj1);
								String de_studentnumber=AESUtils.decrypt(key, obj2);
								
						%>
								
								<tr>
								<td><%= obj[0]%></td>
								<td><%= de_studentname%></td>
								<td><%= de_studentnumber%></td>
								<td><%= obj[3]%></td>
								<td>
									<div class="btn-group">
				 					 	<button name="<%= de_studentnumber%>" value="<%= de_studentnumber%>" class="btn btn-primary btn_edit" type="button">编辑</button> 
				 					 	<button name="<%= de_studentnumber%>" value="<%= de_studentnumber%>" class="btn btn-primary btn_delete" type="button">删除</button>
									</div>
								</td>
								</tr>
						<% 
								}
							}
						%>
				</tbody>
				
			</table>
		</div>
	</div>
</div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
   			$('#btn_fileupload').click(function() {
		
			});
   	 
			 $('#btn_one_submit').click(function() {
                    var studentname = $('#studentname').val();
                    var studentpassword = $('#studentpassword').val();

				//alert("");
                    //${pageContext.request.contextPath}/Admin/AddTeacherAction
                $.ajax({ 
                    type : "post",
                    url : "${pageContext.request.contextPath}/ajaxaction/AddOneStudentAction",
                    data : {
                        studentname : studentname,
                        studentnumber : studentpassword
                    },
                    dataType:"json",
            
                    success : function(data) {
                    	//document.location.reload();
                    },

                    error : function() {
                    	//document.location.reload();
                    }
                });
            });
			 
			 
			 $('.btn_edit').click(function() {
				 temp = this.name;
					var m1 = new MyModal.modal(function() {
						//alert("你点击了确定");
					});
					m1.show();
				/*  $.ajax({ 
	                    type : "post",
	                    url : "${pageContext.request.contextPath}/ajaxaction/AddOneStudentAction",
	                    data : {
	                        studentname : studentname,
	                        studentpassword : studentpassword
	                    },
	                    dataType:"json",
	            
	                    success : function(data) {
	                    	//document.location.reload();
	                    },

	                    error : function() {
	                        alert("失败");
	                    }
	                });
				*/
			 });
			 
			 $('#btn_modal_sure').click(function() {
					<%-- alert("<%= toEdit%>"); --%>
				var studentid = temp;
				var studentname = $('#modal_studentname').val();
				var studentnumber = $('#modal_studentnumber').val();
				
				alert(studentname + studentnumber + "test  " + studentid);
				
				$.ajax({ 
                    type : "post",
                    url : "${pageContext.request.contextPath}/ajaxaction/EditStudentAction",
                    data : {
                    	studentid : studentid,
                    	studentname : studentname,
                    	studentnumber : studentnumber
                    },
                    dataType:"json",
            
                    success : function(data) {
                    	document.location.reload();
                    },

                    error : function() {
                        //alert("操作成功");
                        document.location.reload();
                    }
                });
				 });
			 
			 $('.btn_delete').click(function() {
				 alert(this.value);
				 $.ajax({ 
	                    type : "post",
	                    url : "${pageContext.request.contextPath}/ajaxaction/DeleteStudentAction",
	                    data : {
	                        studentid : this.value,
	                    },
	                    dataType:"json",
	            
	                    success : function(data) {
	                    	document.location.reload();
	                    },

	                    error : function() {
	                    	//document.location.reload();
	                    }
	                });
			 });
    </script>
</body>
</html>