<%@page import="SystemTest.TempClass"%>
<%@page import="AES.AESUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="tool.ORMTool,java.util.List,org.hibernate.Query,bean.Teacher,javax.servlet.http.HttpSession,org.apache.struts2.ServletActionContext,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/boostrap-darepicker.min.css" rel="stylesheet">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/laydate/laydate.js"></script> <!-- 日期控件 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.my-modal.1.1.winStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.my-modal.1.1.js"></script>
<script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
<!--自己的css-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/locate.css" />
<script type="text/javascript">
    laydate.render({
    	  elem: '#data' //指定元素
    	});
    laydate.render({
    	  elem: '#time'
    	  ,type: 'time'
    	  ,range: true
    	});
    laydate.render({
  	  elem: '#modal_data' //指定元素
  	});
  laydate.render({
  	  elem: '#modal_time'
  	  ,type: 'time'
  	  ,range: true
  	});
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<body>
<%
	HttpSession msession = ServletActionContext.getRequest().getSession();
	//System.out.println("hahahah" + msession.getAttribute("username"));
	String examtag;
%>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加学生</h4>
      </div>
      <div class="modal-body">
          <form class="form-inline horizatal_center600">
				<fieldset>
					<h4>单个导入学生信息</h4>
                    <input type="text" name="studentname" id="studentname" placeholder="姓名"/>
                    <input type="text" name="studentpassword" id="studentpassword" placeholder="学号"/>
                    <button id="btn_one_submit" class="btn btn-primary">添加</button>
				</fieldset>
			</form>

<!--		<form action="SwitchAction" method="post" class="form-inline" enctype="multipart/form-data"> 
				学生名单文件：
            	<input type="file" name="uploadImage">
            	<input type="submit" value="提交" id="btn_fileupload" class="btn btn-primary">
			</form>
			 -->
			<form action="teacher/UploadExcelAction" method="post" class="form-inline" enctype="multipart/form-data"> 
				学生名单文件：
				<input type="file" name="upload"/>
            	<input type="submit" value="提交" id="btn_fileupload" class="btn btn-primary">
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>



<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">下载</h4>
      </div>
      <div class="modal-body">
         <div class="row-fluid" id="table_row">
         
         <%-- <table  class="table table-striped table-bordered">
				<thead>
					<tr>
					    <th>
							考试编号	
						</th>
						<th>
							学生姓名	
						</th>
						<th>
							学号	
						</th>
						<th>
							下载路径	
						</th>
						<th>
							操作	
						</th>
					</tr>
				</thead>

               <tbody id="t_body1">
              			<script>
              				 <% System.out.println("Armon");%>
						</script>
						<%
							System.out.println("sgfsdgfsdfgsdfgdsfghahahah" + msession.getAttribute("test"));
						    String teachernumber=msession.getAttribute("teachernumber").toString();
						    String test = "";
							ORMTool download_ormtool = new ORMTool();
							download_ormtool.initSession();
							String download_hql = "select s.studenttag,s.studentname,s.studentnumber,s.status from Student s";
							Query download_query = download_ormtool.getQuery(download_hql);
							List<Object[]> download_list = download_query.list();
							System.out.println("download_list.size():  "+download_list.size());
							for(Object[] obj : download_list)
							{
								//jiemi
								String key="666";
								String obj1=obj[1].toString();
								String obj2=obj[2].toString();
								String de_studentname;
								String de_studentnumber;
								
								//获取examtag参数，未实现
								String student0_19=obj[0].toString().substring(0,19);
								if(student0_19.equals(teachernumber))
								{
									de_studentname=AESUtils.decrypt(key, obj1);    
						    		de_studentnumber=AESUtils.decrypt(key, obj2);									
								
								/* String examtag="";
								//String examtag=msession.getAttribute("examtag").toString();
								//System.out.println("examtag:=="+examtag+"   examtag.substring(20)"+examtag.substring(20));
							    String[] studenttags=obj[0].toString().substring(20).split(",");
							    for(int i=0;i<studenttags.length;i++)
							    {
							    	if(studenttags[i].equals(examtag.substring(20)))
							    	{ 
							    		de_studentname=AESUtils.decrypt(key, obj1);    
							    		de_studentnumber=AESUtils.decrypt(key, obj2);
							   */
								
								
								
						%>
								
								<tr>
								<td><%= obj[0]%></td>
								<td><%= de_studentname%></td>
								<td><%= de_studentnumber%></td>
								<td><%= de_studentnumber%></td>
								<td>
									<div class="btn-group">
				 					 	<button id="btn_downloadpaper" name="<%= de_studentnumber%>" value="<%= de_studentnumber%>" class="btn btn-primary" type="button">下载答案</button> 
									</div>
								</td>
								</tr>
						<% 
							 		}
 							    //}
							} 
						%>
				</tbody>
				
			</table> --%>
         
         </div>
        
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">上传试卷</h4>
      </div>
      <div class="modal-body">
         <div class="row-fluid" id="table_row">
         
         <form action="teacher/UploadAction" method="post" class="form-inline" enctype="multipart/form-data"> 
				上传文件:<input type="file" name="upload"/><br/>
            	<input type="submit" value="提交" id="btn_fileupload" class="btn btn-primary">
			</form>
         
         </div>
        
      </div>
    </div>
  </div>
</div>


<div class="m-modal" >
			<div class="m-modal-dialog">
				<div class="m-top">
					<h4 class="m-modal-title">
						编辑
					</h4>
					<span class="m-modal-close">&times;</span>
				</div>
				<div class="m-middle">
					<form class="form-inline">
						<h4>编辑考试</h4>
						<select class="col-sm-4" style="background-color: transparent;" id="modal_subject" name="modal_subject">
      						<option value="01">电子学</option>
      						<option value="02">C++</option>
     						<option value="03">Java</option>
     						<option value="04">C#</option>
    					</select>
						
						<input id="modal_data" type="text" placeholder="选择日期"/>
						
						<input id="modal_time" type="text" placeholder="选择时间"/>
						
						
						<!-- <br>
						<input id="modal_class" type="text" placeholder="选择年级"/>
						<br> -->
						
						
					</form>
				</div>
				<div class="m-bottom">
					<button id="btn_modal_sure" class="m-btn-sure" type="submit">确定</button>
					<button class="m-btn-cancel">取消</button>
				</div>
			</div>
		</div>
		
		
		
<jsp:include page="teacher_head.jsp"></jsp:include>

<div class="container-fluid horizatal_center600" style="margin-top:60px">
<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center">
					添加考试
				</h3>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form">
		<%-- 	/*	<div class="form-group">
						<label for="name" class="col-sm-2">班级列表：</label>
    					<select class="col-sm-4" style="background-color: transparent;" id="classtype" name="classtype">
    					<%
    					
    					   String username=msession.getAttribute("username").toString();
    					   String key="666";
    					   
    					   
    					   ORMTool ormtool2 = new ORMTool();
    					   ormtool2.initSession();
    					   String hql2 = "select t.teachernumber from Teacher as t where t.teachername=?";
    					   
    					   Query query2 = ormtool2.getQuery(hql2);
    					
    					   
    					  
    					    String en_username=AESUtils.encrypt(key, username);		
    					    query2.setString(0,en_username);  
    					    List<String> list2 = query2.list();
    					   
    					   
    					    String teachernumber=list2.get(0).toString().substring(4, 6);
    					    System.out.println("66666"+teachernumber);
    					    //String teachernumber="2";
    						switch(teachernumber)
    						{
    						case "01":
    					%>
    							
    							<option value="01">计算机1班</option>
      						    <option value="02">计算机2班</option>
    							
    					<% 
    							break;
    						case "02":
    					%>
    							
    							<option value="03">软工1班</option>
    							
    					<%
    							break;
    						case "03":
    					%>
    							
    							<option value="04">网工1班</option>
    							<option value="05">网工2班</option>
    							
    					<% 
    							break;
    						}
    					%>
    					<!-- 此处应该为动态获取 -->
      					<!--	<option value="01">计算机1班</option>   -->
      					<!--	<option value="02">计算机2班</option>   -->
     					<!--	<option value="01">软工1班</option>     -->
     					<!--	<option value="01">网工2班</option>     -->
    					</select>
					</div>
					
			*/ --%>
					<div class="form-group">
						<label for="name" class="col-sm-2">科目列表：</label>
    					<select class="col-sm-4" style="background-color: transparent;" id="subjecttype" name="subjecttype">
      						<option value="01">电子学</option>
      						<option value="02">C++</option>
     						<option value="03">Java</option>
     						<option value="04">C#</option>
    					</select>
					</div>
					<div class="form-group">
					 	<label for="teachername" class="col-sm-2">日期：</label>
						<div class="col-sm-10">
							<input id="data" type="text" placeholder="选择日期"/>
						</div>
					</div>
					<div class="form-group">
						 <label for="teacherpassword" class="col-sm-2">时间：</label>
						<div class="col-sm-10">
							<input id="time" type="text" placeholder="选择时间"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							 <button id="btn_submit" type="button" class="btn btn-primary">添加</button>
						</div>
					</div>
				</form>
			</div>
		</div>
</div>
<hr>
<div class="horizatal_center1200">
<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>考试编号</th>
			<th>考试科目</th>
			<th>考试时间</th>
			<th>考试状态</th>
			<th>执行操作</th>
		</tr>
	</thead>
	<tbody>
						<%
							String str = TempClass.temp;
							System.out.println("testfytafdfdanda" + str);
							ORMTool ormtool = new ORMTool();
							ormtool.initSession();
							String hql = "select e.examnumber,e.examsubject,e.examdata,e.status from Exam e";
							Query query = ormtool.getQuery(hql);
							List<Object[]> list = query.list();
							System.out.println(list.size());
							application.setAttribute("examamount", list.size());
							
							
							for(Object[] obj : list)
							{
								
								String studentnumber=msession.getAttribute("teachernumber").toString();
								if(obj[0].toString().substring(0,20).equals(studentnumber))
								{
								
								
								%>
								<tr>
								<td><%= obj[0]%></td>
								<td><%= obj[1]%></td>
								<td><%= obj[2]%></td>
								<td><%= obj[3]%></td>
								<%
									String manager_text  = "";
									String text_val = "";
									if(obj[3].toString().equals("进行中"))
									{
										manager_text = "停止";
										text_val = "进行中";
									}
									else
									{
										manager_text = "开始";
										text_val = "未开始";
									}
								%>
								<td>
									<div class="btn-group">
				 						<button name="<%= obj[0]%>" value="<%= text_val%>" class="btn btn-primary btn_manager" type="button"><%= manager_text %></button>
				 					 	<button name="<%= obj[0]%>" class="btn btn-primary btn_edit" type="button">编辑</button> 
				 					 	<button name="<%= obj[0]%>" class="btn btn-primary btn_addstudent" type="button" data-toggle="modal"data-target="#myModal">添加学生</button>
				 					 	<button name="<%= obj[0]%>" class="btn btn-primary btn_delete" type="button">删除数据</button>
				 					 	<button name="<%= obj[0]%>" id="btnofdownload" data-id="<%= obj[0]%>"
				 					 	
				 					 	<%
				 					 	 if(manager_text.equals("开始"))
				 					 	 {
				 					 		out.println("disabled=true");				 		
				 					 	 }
				 					 	%>
				 					 	
				 					 	 class="btn btn-primary btn_download"  type="button" data-toggle="modal" data-target="#myModal1" onclick="value()">下载</button>
				 					 	 
				 					 	 
				 					 	 	<button name="<%= obj[0]%>" id="btnofupdate" data-id="<%= obj[0]%>"			 	
				 					 	<%
				 					 	 if(manager_text.equals("停止"))
				 					 	 {
				 					 		out.println("disabled=true");				 		
				 					 	 }
				 					 	%>				 					 	
				 					 	 class="btn btn-primary btn_update"  type="button" data-toggle="modal" data-target="#myModal2" onclick="value()">上传试卷
				 					 	 
				 					 	 <%
				 					 	 	//msession.setAttribute("thisexamnumber", );
				 					 	 %>
				 					 	 </button>
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





    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
  
    
    <script type="text/javascript" src="../jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript">
    	
    	var temp;
        
    	
    	$('#btn_submit').click(function() {
    		
        var examsubject = $('#subjecttype option:selected').val();
        /* var examclass = $('#classtype option:selected').val(); */
        //alert(examsubject);
        var data = $('#data').val();
        var time = $('#time').val();
        //alert(examsubject +  data +  time);
        //${pageContext.request.contextPath}/Admin/AddTeacherAction
   		 $.ajax({ 
        	type : "post",
       	    url : "${pageContext.request.contextPath}/ajaxaction/AddExamAction",
        	data : {
            	examsubject : examsubject,
            	examdata : data + "" + time,
            	/* examclass :  examclass */
        		},
        	dataType:"json",

        	success : function(data) {
        		document.location.reload();
       		 },

       		error : function() {
        		document.location.reload();
       		 }
   		 });
		});
    	
    	
    	
    	
    	//此处实际数据库操作已经成功，但方法的转向始终是error
		 $('.btn_manager').click(function() {
			 //alert(this.value);
			 
			/*  var sta = document.getElementById('btnofdownload');
			 if(this.value.equals("未开始"))
			{
				 sta.disabled=true;
			}
			 else
		    {
				 sta.disabled=false;
			 } */
			 var sta = document.getElementById('btnofdownload');
			 var status=this.value;
/* 			 if(status.equals("未开始"))
			 { */
				// sta.disabled=false;
		    // }
/* 			 else
			 {
				 sta.disabled=false;
			 } */
			 
			
			 $.ajax({ 
                   type : "post",
                   url : "${pageContext.request.contextPath}/ajaxaction/StartExamAction",
                   data : {
                       examnumber : this.name,
                       nowstatus : this.value
                   },
                   dataType:"json",
           
                    success : function(data) {
                   	document.location.reload();
                   },
                   
                   error : function() {
                   	//此处实际数据库操作已经成功，但方法的转向始终转到此处
                   	//alert("操作成功！");
                   	document.location.reload();
                   }
               });
			 
		 });
    	
    	
    	
    	
    	
		$('.btn_edit').click(function() {
			temp = this.name;
			var m1 = new MyModal.modal(function() {
				//alert("你点击了确定");
			});
			m1.show();
		 });
		$('#btn_modal_sure').click(function() {
			<%-- alert("<%= toEdit%>"); --%>
			var modalsubject = $('#modal_subject option:selected').text();
	        var modaldata = $('#modal_data').val();
	        var modaltime = $('#modal_time').val();
	        //var modalclass = $('#modal_class').val();
	       //alert("modalsubject"+modalsubject); 
	        //${pageContext.request.contextPath}/Admin/AddTeacherAction
	    $.ajax({ 
	        type : "post",
	        url : "${pageContext.request.contextPath}/ajaxaction/EditExamAction",
	        data : {
	            examsubject : modalsubject,
	            examdata : modaldata + "" + modaltime,
	            //examclass :  modalclass,
	            examnumber : temp
	        },
	        dataType:"json",

	        success : function(data) {
	        	document.location.reload();
	        },

	        error : function() {
	        	document.location.reload();
	        }
	    });
		 });
		
		
		/* 添加学生 */
		$('.btn_addstudent').click(function() {
			temp = this.name;
			/* alert(temp); */
		 });
		$('#btn_one_submit').click(function() {
			<%-- alert("<%= toEdit%>"); --%>
			
			var studentname = $('#studentname').val();			
	        var studentpassword = $('#studentpassword').val();        
	        //alert(temp);
			    $.ajax({ 
			        type : "post",
			        url : "${pageContext.request.contextPath}/ajaxaction/AddOneStudentAction",
			        data : {
			        	studentname : studentname,
			        	studentnumber : studentpassword,
			        	studenttag :  temp
			        },
			        dataType:"json",

			        success : function(data) {
			        	document.location.reload();
			        },

			        error : function() {
			        	document.location.reload();
			        }
			    });
			      // alert(temp);
				
			/* }
			else
			{
				String new_examnumber=temp.substring(20);
				for(Object[] obj : list) {
					var studenttag=obj[1]+","+new_examnumber;
					
					
				}
			}
			 */
	        
	    
		 });
		
		
		/* 待完善 */
		$('.btn_delete').click(function() {
			//alert(this.name);
			$.ajax({ 
               type : "post",
               url : "${pageContext.request.contextPath}/ajaxaction/DeleteExamAction",
               data : {
               	examnumber : this.name
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
		
		
		
		
		
		//下载试卷
		
		$('.btn_download').click(function() {
			//alert("test");
			temp = this.name;
			$.ajax({ 
	               type : "post",
	               url : "${pageContext.request.contextPath}/ajaxaction/TempAction",
	               data : {
	               	temp : temp
	               },
	               dataType:"json",
	       
	               success : function(data) {
	            	   var request = "${pageContext.request.contextPath}/temp/mytemp.jsp" + " " + "#t1"; 
	            	   $("#table_row").load(request,null,function () {  
	                       //alert("OKJJJJ");
	                   });  
	            	   var m1 = new MyModal1.modal(function() {
		      				 $('#paperId').val(temp);
		      				 application.setAttribute("examtag", temp);
		      			});
		      			m1.show();
	               },

	               error : function() {
	            	   var request = "${pageContext.request.contextPath}/temp/mytemp.jsp" + " " + "#t1"; 
	            	   $("#table_row").load(request,null,function () {  
	                       //alert("OKJJJJ");
	                   });  
	                   //alert("操作成功");
	            	   var m1 = new MyModal1.modal(function() {
		      				 $('#paperId').val(temp);
		      				 application.setAttribute("examtag", temp);
		      			});
		      			m1.show();
	               }
	           });
		 });
		
		//上传Excel
		
		$('.btn_addstudent').click(function() {
			//alert("test");
			temp = this.name;
			$.ajax({ 
	               type : "post",
	               url : "${pageContext.request.contextPath}/ajaxaction/TempAction",
	               data : {
	               	temp : temp
	               },
	               dataType:"json",
	       
	               success : function(data) {
	            	   var request = "${pageContext.request.contextPath}/temp/mytemp.jsp" + " " + "#t1"; 
	            	   $("#table_row").load(request,null,function () {  
	                       //alert("OKJJJJ");
	                   });  
	            	   var m1 = new MyModal1.modal(function() {
		      				 $('#paperId').val(temp);
		      				 application.setAttribute("examtag", temp);
		      			});
		      			m1.show();
	               },

	               error : function() {
	            	   var request = "${pageContext.request.contextPath}/temp/mytemp.jsp" + " " + "#t1"; 
	            	   $("#table_row").load(request,null,function () {  
	                       //alert("OKJJJJ");
	                   });  
	                   //alert("操作成功");
	            	   var m1 = new MyModal1.modal(function() {
		      				 $('#paperId').val(temp);
		      				 application.setAttribute("examtag", temp);
		      			});
		      			m1.show();
	               }
	           });
		 });
		
		
		
		$('#btn_downloadpaper').click(function() {
			
			//待更改
			
			
			
	    });
		
		$("#myModal1").on("show.bs.modal",function(e){
			 
			//do something ……
			 var btn = $(e.relatedTarget),
		        id = btn.data("id"); 
			});
		
		
		//temp 即考试编号,将temp的值传给TempAction类，其他页面可以通过 TempClass.temp 访问temp的值

		
		$('.btn_update').click(function() {
			//alert("test");
			//temp 即考试编号,将temp的值传给TempAction类，其他页面可以通过 TempClass.temp 访问temp的值
			
			temp = this.name;
			alert("test"+temp);
			$.ajax({ 
	               type : "post",
	               url : "${pageContext.request.contextPath}/ajaxaction/TempAction",
	               data : {
	               	temp : temp
	               },
	               dataType:"json",
	       
	               success : function(data) {
	            	   //alert("test"+TempClass.temp);
	               },

	               error : function() {
	            	   //alert("test"+TempClass.temp);
	               }
	           });
		 });
		
	</script>
    
    
</body>
</html>