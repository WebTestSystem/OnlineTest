<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="tool.ORMTool,java.util.List,org.hibernate.Query,bean.Teacher,javax.servlet.http.HttpSession,org.apache.struts2.ServletActionContext"%>
    <%@page import="SystemTest.TempClass"%>
<%@page import="AES.AESUtils"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	 <table id="t1"  class="table table-striped table-bordered">
				<thead>
					<tr>
					    <th>
							考试编号	
						</th>
<!-- 						<th>
							学生姓名	
						</th>
						<th>
							学号	
						</th> -->
						<th>
							考试科目
						</th>
						<th>
							操作	
						</th>
					</tr>
				</thead>

               <tbody>
						<%
						     System.out.println("TempClass.temp");
						    System.out.println("TempClass.temp   "+TempClass.temp);
							ORMTool download_ormtool = new ORMTool();
							download_ormtool.initSession();
							String download_hql = "select e.examnumber,e.examsubject,e.examdata,e.status from Exam e where e.examnumber=?";
							Query download_query = download_ormtool.getQuery(download_hql);
							download_query.setString(0, TempClass.temp);
							List<Object[]> download_list = download_query.list();
							
							
							System.out.println("download_list.size():  "+download_list.size());
							for(Object[] obj : download_list)
							{
					/*			//jiemi
								String key="666";
								String obj1=obj[1].toString();
								String obj2=obj[2].toString();
								String de_studentname;
								String de_studentnumber;
								String studenttag=obj[0].toString();
								String teachernumber=TempClass.temp.substring(0,19);
								String examtag=TempClass.temp.substring(20);
								String student0_19=obj[0].toString().substring(0,19);
								
								//获取examtag参数，未实现
								String[] studenttags=obj[0].toString().substring(20).split(",");
								//System.out.println("student0_22   "+student0_22);
								
								if(student0_19.equals(teachernumber))
								{
									for(int i=0;i<studenttags.length;i++)
									{
										if(examtag.equals(studenttags[i]))
										{
											de_studentname=AESUtils.decrypt(key, obj1);    
								    		de_studentnumber=AESUtils.decrypt(key, obj2);	 */	

								%>
								
								<tr>
								<td><%= TempClass.temp%></td>
							<%-- 	<td><%= de_studentname%></td>
								<td><%= TempClass.temp%></td> --%>
								<td><%= obj[1]%></td>
								<td>
									<div class="btn-group">
				 					 	<!--  <button id="btn_downloadpaper"  class="btn btn-primary" type="button">下载答案</button>-->
				 					 	<a href="${pageContext.request.contextPath}/teacher/DownLoadAction.action?number=2"><input type="button" id="btn_downloadpaper" value="下载答案"  class="btn btn-primary"  /></a> 
									</div>
								</td>
								</tr>

<%
					    	  }
					      //}
				     // } 
	//}

%>
                             


				</tbody>
				
			</table>
			
			<script type="text/javascript">	
				
			</script>
			
</body>
</html>