package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import bean.Student;
import bean.Teacher;
import tool.ORMTool;

public class AddOneStudentAction extends ActionSupport{
	
	private String studentname;
	private String studentpassword;


	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentpassword() {
		return studentpassword;
	}
	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}


	public String execute()
	{
		Student stu = new Student();
		stu.seteId(null);
		stu.setName(this.studentname);
		stu.setNumber(this.studentpassword);
		stu.setStatus("¿Îœﬂ");
		ORMTool ormtool = new ORMTool("student",stu);
		ormtool.insert();
		return SUCCESS;
	}
	
}