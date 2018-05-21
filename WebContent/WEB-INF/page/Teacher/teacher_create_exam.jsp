<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker-standalone.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker-standalone.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="teacher_head.jsp"></jsp:include>

<div class="container-fluid" style="margin-left:20px;margin-top:60px">

									
<form class="exam-form form-inline" action="teacher_exam_insert" enctype="multipart/form-data" method="post">
	<h4>添加考试</h4>
	<input type="text" name="ename" placeholder="考试名称*" size="20" />
	<div class="controls input-append date" id="datetimepicker" data-link-field="etime" >
		<input class="span2" size="16" type="text"  placeholder="考试时间*" readonly/> 
		<span class="add-on"><i class="icon-remove"></i></span>
		<span class="add-on"><i class="icon-th"></i></span>
	</div>    
	<input type="hidden" id="etime" name="etime" />
	<input type="checkbox" name="eautostart" value="true"/> 自动开始&nbsp;
	<input type="submit" class="btn btn-primary" value="添加" />
</form>
</div>
				<div class="span4">
					<dl>
						<dt>
							Rolex
						</dt>
						<dd>
							劳力士创始人为汉斯.威尔斯多夫，1908年他在瑞士将劳力士注册为商标。
						</dd>
						<dt>
							Vacheron Constantin
						</dt>
						<dd>
							始创于1775年的江诗丹顿已有250年历史，
						</dd>
						<dd>
							是世界上历史最悠久、延续时间最长的名表之一。
						</dd>
						<dt>
							IWC
						</dt>
					</dl>
				</div>

</body>


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    
    
    
<script type="text/javascript">
$("#datetimepicker").datetimepicker({
    format: "yyyy-mm-dd hh:ii",
    autoclose: true,
    todayBtn: true,
    minuteStep: 10,
    minView:0,
    pickerPosition:'bottom-left',
    language:'zh-CN'
});
</script>
</html>


