<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="tool.ORMTool,java.util.List,org.hibernate.Query,bean.Teacher,javax.servlet.http.HttpSession,org.apache.struts2.ServletActionContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/boostrap-darepicker.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/laydate/laydate.js"></script> <!-- 日期控件 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.my-modal.1.1.winStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.my-modal.1.1.js"></script>
<script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
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
	System.out.println("hahahah" + msession.getAttribute("username"));
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
					<form>
						<h4>编辑考试</h4>
						<input type="text" class="form-control" id="modal_subject" placeholder="考试科目" size="16" />
						<br>
						<input id="modal_data" type="text" placeholder="选择日期"/>
						<br>
						<input id="modal_time" type="text" placeholder="选择时间"/>
						<br>
						<input id="modal_class" type="text" placeholder="选择年纪"/>
						<br>
					</form>
				</div>
				<div class="m-bottom">
					<button id="btn_modal_sure" class="m-btn-sure">确定</button>
					<button class="m-btn-cancel">取消</button>
				</div>
			</div>
		</div>
<jsp:include page="teacher_head.jsp"></jsp:include>

<div style="margin-left:20px;margin-top:60px">

<form class="exam-form form-inline">
	<h4>添加考试</h4>
	<input type="text" class="form-control" id="examsubject" placeholder="考试科目" size="16" />
	<input id="data" type="text" placeholder="选择日期"/>
	<input id="time" type="text" placeholder="选择时间"/>
	<input id="class" type="text" placeholder="选择年纪"/>
	<input id="btn_submit" class="btn btn-primary" value="添加" type="button"/>
</form>

<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>考试编号</th>
			<th>考试科目</th>
			<th>负责老师</th>
			<th>考试时间</th>
			<th>考试状态</th>
			<th>执行操作</th>
		</tr>
	</thead>
	<tbody>
						<%
							System.out.print("sss");
							ORMTool ormtool = new ORMTool();
							ormtool.initSession();
							String hql = "select e.number,e.subject,e.eTeacher,e.data,e.status from Exam e";
							Query query = ormtool.getQuery(hql);
							List<Object[]> list = query.list();
							System.out.println(list.size());
							application.setAttribute("examamount", list.size());
							for(Object[] obj : list)
							{
								%>
								<tr>
								<td><%= obj[0]%></td>
								<td><%= obj[1]%></td>
								<td><%= obj[2]%></td>
								<td><%= obj[3]%></td>
								<td><%= obj[4]%></td>
								<%
									String manager_text  = "";
									String text_val = "";
									if(obj[4].toString().equals("进行中"))
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
				 					 	<button name="<%= obj[0]%>" class="btn btn-primary btn_edit" type="button" href="#<%= obj[0]%>" data-toggle="modal">编辑</button> 
				 					 	<button name="<%= obj[0]%>" class="btn btn-primary btn_delete" type="button">删除数据</button>
									</div>
								</td>
								</tr>
								<% 
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
    <script type="text/javascript" src="../bootstrap/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script type="text/javascript" src="../bootstrap/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
    <script type="text/javascript">
    	
    var temp;
    
    	$('#btn_submit').click(function() {
        var examsubject = $('#examsubject').val();
        var data = $('#data').val();
        var time = $('#time').val();
        var examclass = $('#class').val();
        //alert(articleID);
        //${pageContext.request.contextPath}/Admin/AddTeacherAction
    $.ajax({ 
        type : "post",
        url : "${pageContext.request.contextPath}/ajaxaction/AddExamAction",
        data : {
            examsubject : examsubject,
            examdata : data + "" + time,
            examclass :  examclass
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
			 alert(this.value);
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
                   	alert("操作成功！");
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
			var modalsubject = $('#modal_subject').val();
	        var modaldata = $('#modal_data').val();
	        var modaltime = $('#modal_time').val();
	        var modalclass = $('#modal_class').val();
	       alert(temp);
	        //${pageContext.request.contextPath}/Admin/AddTeacherAction
	    $.ajax({ 
	        type : "post",
	        url : "${pageContext.request.contextPath}/ajaxaction/EditExamAction",
	        data : {
	            examsubject : modalsubject,
	            examdata : modaldata + "" + modaltime,
	            examclass :  modalclass,
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
		
		/* 待完善 */
		$('.btn_delete').click(function() {
			alert(this.name);
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
	</script>
    
    
</body>
</html>