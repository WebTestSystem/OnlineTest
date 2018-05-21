package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import bean.Teacher;
import tool.ORMTool;

public class AddStudentByExcel extends ActionSupport{
	
	private String teachername;
	private String teacherpassword;

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTeacherpassword() {
		return teacherpassword;
	}

	public void setTeacherpassword(String teacherpassword) {
		this.teacherpassword = teacherpassword;
	}


	public String getInfo()
	{
		return "success";
	}
	
	
	public String execute()
	{
		Teacher tea = new Teacher();
		tea.seteId(null);
		tea.setName(teachername);
		tea.setNumber(teacherpassword);
		ORMTool ormtool = new ORMTool("teacher",tea);
		ormtool.insert();
		return SUCCESS;
	}
	
}
