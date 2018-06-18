<%@page import="AES.AESUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="tool.ORMTool,java.util.List,org.hibernate.Query,bean.Teacher,org.apache.struts2.ServletActionContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<!--win风格-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.my-modal.1.1.winStyle.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.my-modal.1.1.js"></script>
	<!--日期控件-->
	<script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
	<!--自己的css-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/locate.css" />
	<title>管理员</title>
</head>
<body>
	<%
		//toEdit字符在下面有用到，session取出为备用
		String toEdit = "***";
		HttpSession msession = ServletActionContext.getRequest().getSession();
		System.out.println("欢迎，" + msession.getAttribute("username"));
	%>
	<div class="m-modal">
			<div class="m-modal-dialog">
				<div class="m-top">
					<h4 class="m-modal-title">
						编辑
					</h4>
					<span class="m-modal-close">&times;</span>
				</div>
				<div class="m-middle">
						<div class="row">
							<div class="col-md-12 column">
								<form class="form-horizontal" role="form">
									<div class="form-group">
					 					<label for="teachername" class="col-sm-2 control-label">新密码：</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="modal_newpassword" name="modal_newpassword"/>
										</div>
									</div>
								</form>
							</div>
						</div>
				</div>
				<div class="m-bottom">
					<button id="btn_modal_sure" class="m-btn-sure">确定</button>
					<button class="m-btn-cancel">取消</button>
				</div>
			</div>
		</div>
	
	<jsp:include page="admin_head.jsp"></jsp:include>

	<div class="container-fluid horizatal_center600" style="margin-top:60px">
		<!-- 添加老师的表单 -->
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center">
					添加教师
				</h3>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form">
					<div class="form-group">
					 	<label for="teachername" class="col-sm-2">姓名：</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="teachername" name="teachername"/>
						</div>
					</div>
					<div class="form-group">
						 <label for="teacherpassword" class="col-sm-2">密码：</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" id="teacherpassword" name="teacherpassword"/>
						</div>
					</div>
					<div class="form-group">
						<label for="yeartype" class="col-sm-3">年级列表：</label>
    					<select class="col-sm-9 form-control" style="background-color: transparent;" id="yeartype" name="yeartype">
      						<option>2014</option>
      						<option>2015</option>
     						<option>2016</option>
     						<option>2017</option>
    					</select>
					</div>
					<div class="form-group">
						<label for="majortype" class="col-sm-3">专业列表：</label>
    					<select class="col-sm-9 form-control" style="background-color: transparent;" id="majortype" name="majortype">
      						<option value="01">计算机技术</option>
     						<option value="02">软件工程</option>
     						<option value="03">网络工程</option>
    					</select>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							 <button id="btn_submit" type="button" class="btn btn-primary">录入系统</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
		<hr>
	<div class="horizatal_center1200">
		<!-- 老师的列表 -->
		<div class="row-fluid">
			<div class="span12">
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
								密码
							</th>
							<th>
								是否为admin
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
							ORMTool ormtool = new ORMTool();
							ormtool.initSession();
							String hql = "select t.teachernumber,t.teacherpassword,t.teachername,t.isadmin,t.status from Teacher t";
							Query query = ormtool.getQuery(hql);
							List<Object[]> list = query.list();
							System.out.println(list.size());
							for(Object[] obj : list)
							{
								%>
								
								<%
								//jiemi
								String key="666";
								String obj1=obj[1].toString();
								String obj2=obj[2].toString();
								String de_teacherpassword=AESUtils.decrypt(key, obj1);
								String de_teachername=AESUtils.decrypt(key, obj2);
									
								%>
								
								
								
								<tr>
								<td><%= obj[0]%></td>
								<td><%= de_teachername%></td>
								<td><%= de_teacherpassword%></td>
								<td><%= obj[3]%></td>
								<td><%= obj[4]%></td>
								
								<%
									String manager_text  = "";
									if(obj[3].toString().equals("否"))
									{
										manager_text = "设为管理员";
									}
									else
									{
										manager_text = "取消管理员";
									}
								%>
								
								<td>
									<div class="btn-group">
				 						<button name="<%= obj[0]%>" value="<%= manager_text%>" class="btn btn-primary btn_manager" type="button"><%= manager_text%></button>
				 					 	<button name="<%= obj[0]%>" class="btn btn-primary btn_edit" type="button" href="#<%= obj[0]%>" data-toggle="modal">修改密码</button> 
				 					 	<button name="<%= obj[0]%>" class="btn btn-primary btn_delete" type="button">删除</button>
									</div>
								</td>
								</tr>
								<% 
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
    
    		var temp;			
    
    		/* 添加教师 */
			 $('#btn_submit').click(function() {
                    var teachername = $('#teachername').val();
                    var teacherpassword = $('#teacherpassword').val();
                    
                    var teacheryear = $('#yeartype option:selected').text();//选中的文本
                    var teacherclass = $('#majortype option:selected').val();//选中的文本
                    
                    //alert(articleID);
                    if (teachername == "") {
                        alert("名称不能为空");
                            return false;
                    }

                    //${pageContext.request.contextPath}/Admin/AddTeacherAction
                $.ajax({ 
                    type : "post",
                    url : "${pageContext.request.contextPath}/ajaxaction/AddTeacherAction",
                    data : {
                        teachername : teachername,
                        teacherpassword : teacherpassword,
                        teachernumber : teacheryear + teacherclass
                    },
                    dataType:"json",
            
                    success : function(data) {
                    	//alert(data);
                    	document.location.reload();
                    },

                    error : function(data) {
                        //alert("失败");
                    	document.location.reload();
                    }
                });
            });
			 
			 $('.btn_manager').click(function() {
				 $.ajax({ 
	                    type : "post",
	                    url : "${pageContext.request.contextPath}/ajaxaction/TeacherToManager",
	                    data : {
	                        teachernumber : this.name,
	                        btntext : this.value
	                    },
	                    dataType:"json",
	            
	                    success : function(data) {
	                    	document.location.reload();
	                    },
	                    
	                    error : function() {
	                    	//此处实际数据库操作已经成功，但方法的转向始终转到此处
	                    	alert("操作成功！");
	                    	document.location.reload();
	                    }
	                });
				 
			 });
			 /* 待完善 */
			$('.btn_edit').click(function() {
				temp = this.name;
				var m1 = new MyModal.modal(function() {
					//alert("你点击了确定");
				});
				m1.show();
				
			 });
			
			
			
			$('#btn_modal_sure').click(function() {
				var teachernumber = temp;
				var newteacherpassword = $('#modal_newpassword').val();
				
				//alert(newteachername + newteachernumber + "test  " + teacherid);
				
				$.ajax({ 
                    type : "post",
                    url : "${pageContext.request.contextPath}/ajaxaction/EditTeacherAction",
                    data : {
                    	teacherpassword : newteacherpassword,
                    	teachernumber : teachernumber
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
			
			/* 待完善 */
			$('.btn_delete').click(function() {
				var teachernumber = this.name;
				//alert(teachernumber);
				$.ajax({ 
                    type : "post",
                    url : "${pageContext.request.contextPath}/ajaxaction/DeleteTeacherAction",
                    data : {
                    	teachernumber : teachernumber
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
		 
    </script>
</body>
</html>