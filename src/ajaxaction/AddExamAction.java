package ajaxaction;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Exam;
import bean.Student;
import tool.ORMTool;

public class AddExamAction extends ActionSupport{
	
	private String examsubject;
	private String examdata;
	private String examnumber;
	private String examteacher;
	private String examclass;
	private String examstatus = "未开始";

	
	
	public String getExamsubject() {
		return examsubject;
	}
	public void setExamsubject(String examsubject) {
		this.examsubject = examsubject;
	}
	public String getExamdata() {
		return examdata;
	}
	public void setExamdata(String examdata) {
		this.examdata = examdata;
	}
	public String getExamclass() {
		return examclass;
	}
	public void setExamclass(String examclass) {
		this.examclass = examclass;
	}
	


	public String execute()
	{
		HttpSession msession = ServletActionContext.getRequest().getSession();
		System.out.println("老师编号:" + msession.getAttribute("usernumber"));
		Exam exam = new Exam();
		exam.setData(examdata);
		exam.seteTeacher(msession.getAttribute("usernumber").toString());
		ServletContext  application = ServletActionContext.getServletContext();
		Object examamount = application.getAttribute("examamount");
		System.out.println("考试号：" + examamount.toString());
		exam.setNumber(msession.getAttribute("usernumber").toString() + String.format("%04d", (int)examamount));
		exam.setSubject(examsubject);
		exam.setmClass(examclass);
		exam.setStatus(examstatus);
		ORMTool ormtool = new ORMTool("exam",exam);
		ormtool.insert();
		return SUCCESS;
	}
	
}