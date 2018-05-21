/**
 * 
 */
 $('#btn_submit').click(function() {
                    var teachername = $('#teachername').val();
                    var teacherpassword = $('#teacherpassword').val();
                    //alert(articleID);
                    if (teachername == "" || teacherpassword == "") {
                        alert("昵称和内容都不能为空");
                            return false;
                    }

                $.ajax({ 
                    type : "post",
                    url : "${pageContext.request.contextPath}/Admin/AddTeacherAction",
                    data : {
                        teachername : teachername,
                        teacherpassword : teacherpassword
                    },
                    dataType:"json",
            
                    success : function(data) {
                        alert(data);
                    },

                    error : function() {
                        alert("失败");
                    }
                });
            });