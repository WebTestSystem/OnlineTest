<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="javax.servlet.http.HttpSession,org.apache.struts2.ServletActionContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/js/comet4j.js"></script>
<title>学生考试</title>
<style type="text/css"> 
.align-center{ 
position:fixed;left:50%;top:50%;margin-left:width/2;margin-top:height/2;border:1px solid #F00;
} 
.Up{  width:100px; height:100px; border:1px solid #F00; clear:both;}
.Down{ width:100px; height:100px; border:1px solid #F00; clear:both;}
</style>
</head>
<body>


<%
		HttpSession msession = ServletActionContext.getRequest().getSession();
	%>
	
<input id="studenttag" style="display:none" name="<%= msession.getAttribute("studenttag")%>" value="<%= msession.getAttribute("studenttag")%>"/>

<jsp:include page="student_head.jsp"></jsp:include>
<!-- loginsuccess！ -->
	
<div style="margin-left:360px;margin-top:60px">

<div class="container-fluid">
	<div class="row-fluid">
	<div class=".Up"><h3><%= msession.getAttribute("username") %> 上机考试中</h3></div>
		<div class="span6">
		
			<h3>试卷下载</h3>
			<br/>
			
               <a href="${pageContext.request.contextPath}/student/DownLoadAction.action?number=1">点击下载</a>
			
		</div>
		<br/>
		<label>------------------------------------------------------------------------------------------------------------------------------------------</label>
		<br/>
		<div class="span6">
			<h3>答案上传</h3>
			<br/>
			<p>请按照考试要求将答案文件打包，再次进行上传。同名文件多次上传将会覆盖。</p>
			<form action="student/HandinAction" enctype="multipart/form-data" method="post">
	     			 上传文件:<input type="file" name="upload"/><br/>
	        		<input type="submit" value="提交" class="btn btn-primary"/>
	   		</form>
		</div>
	</div>
</div>







<div id="message">
</div>
<script type="text/javascript">  
    var studenttag = $('#studenttag').val();	
    alert("#studenttag: "+studenttag);
    var polling = function(){  
        /* $.post('${pageContext.request.contextPath}/ajaxaction/CometAction.do?method=polling', function(data, textStatus){  
            $("#message").append(data+"<br>");  
        }); */
        $.ajax({ 
            type : "post",
            url : "${pageContext.request.contextPath}/ajaxaction/CometAction",
            data : {
                studenttag : studenttag
            },
            dataType:"text",
    
            success : function(data) {
            	//alert(data+"yyy"+(data == "end"));
            	if(data == "noend")
            	{
            		//alert("xxx");
            		$.ajax({
            			 type : "post",
            	            url : "${pageContext.request.contextPath}/ajaxaction/SeesionAction",
            	            data : {
            	            	clear : "clear"
            	            },
            	            dataType:"text",
            	            
            	            success : function(data)
            	            {
            	            	//response.sendRedirect(".../index.jsp");
            	            	//alert("清理Session");
            	            	document.location.reload();
            	            },
            	            
            	            error : function() {
            	                //alert("失败");  
            	                document.location.reload();
            	            }
            		});
            		/* alert(data);
            		ServletActionContext.getRequest().getSession().removeAttribute();
            		ServletActionContext.getRequest().getSession().invalidate();            		
            		//request.getSession().removeAttribute("user");//清空session信息  
            		//request.getSession().invalidate();//清除 session 中的所有信息  
            		//退出登录的时候清空cookie信息,cookie需要通过HttpServletRequest，HttpServletResponse获取  
            		 var cookie=request.getCookies();  
            		for(var c:cookie){  
            		    if("autoLogin".equals(c.getName())){  
            		        c.setMaxAge(0);  
            		        response.addCookie(c);  
            		    }  
            		}  */
            		document.location.reload();
            		//response.sendRedirect("index.jsp");
            	}
            	else
            	{
            		
            	}
            	/* alert(data)
            	$("#message").append(data+"<br>");   */
            },

            error : function() {
                //alert("失败");
               
            	
            }
        });
    };  
    interval = setInterval(polling, 3000);  
</script>   


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--     <script type="text/javascript">
    var polling = function(){
        $.post('../comet.do?method=polling', function(data, textStatus){
            $("#message").append(data+"<br>");
        });
    };
    interval = setInterval(polling, 3000);
</script> -->
</body>
</html>