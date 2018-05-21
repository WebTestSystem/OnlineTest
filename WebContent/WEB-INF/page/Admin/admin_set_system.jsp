<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员-系统设置</title>
</head>
<body>
<!-- 问题：文件路径问题 -->
<jsp:include page="admin_head.jsp"></jsp:include>
<div style="margin-left:50px;margin-top:60px">

<form class="exam-form form-horizontal">
	<h4>修改系统配置</h4>
	
	<div class="control-group">
		<label class="control-label" for="interval">后台任务间隔时间</label>
		<div class="controls">
			<input type="text" id="interval" name="interval" value="30" />
			<p class="help-block">指定扫描考试信息的间隔时间，单位为 分钟。</p>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="pagesize">分页查询记录条数</label>
		<div class="controls">
			<input type="text" id="pagesize" name="pagesize" value="30" />
			<p class="help-block">指定分页查询时每页显示记录数的默认值（查询页面中可以更改）。</p>
		</div>
	</div>
	
<!-- 	<div class="control-group">
		<label class="control-label" for="timegap">手动开启考试时间阈值</label>
		<div class="controls">
			<input type="text" id="timegap" name="timegap" value="15" />
			<p class="help-block">指定手工开启考试时允许的最大提前量，单位为分钟</p>
		</div>
	</div> -->
	
	<div class="control-group">
		<label class="control-label" for="maxfilesize">上传文件字节数上限</label>
		<div class="controls">
			<input type="text" id="maxfilesize" name="maxfilesize" value="131072" />
			<p class="help-block">指定上传文件的长度上限（字节），高于此值发出警告</p>
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<input id="btn_submit" type="button" class="btn btn-primary" value="修改" />
		</div>
	</div>
</form>

</div>




    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
			 $('#btn_submit').click(function() {
                    var interval = $('#interval').val();
                    var amount = $('#pagesize').val();
                    var maxsize = $('#maxfilesize').val();
                    
                $.ajax({ 
                    type : "post",
                    
                    url : "${pageContext.request.contextPath}/ajaxaction/SettingAction",
                    
                    data : {
                    	backgroudtime : interval,
                    	recordamount : amount,
                    	filemaxsize : maxsize
                    },
                    
                    dataType:"json",
            
                    success : function(data) {
                    	document.location.reload();
                    	alert("OK");
                    }
                });
            });
    </script>
</body>
</html>