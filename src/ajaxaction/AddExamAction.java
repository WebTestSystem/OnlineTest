package ajaxaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Exam;
import bean.Student;
import tool.ORMTool;

public class AddExamAction extends ActionSupport{
	
	private String examsubject;
	//private String examclass;
	private String examdata;
	private String examnumber;
	private String examstatus = "未开始";

	
	
	public String getExamsubject() {
		return examsubject;
	}
	public void setExamsubject(String examsubject) {
		this.examsubject = examsubject;
	}
	/*public String getExamclass() {
		return examclass;
	}
	public void setExamclass(String examclass) {
		this.examclass = examclass;
	}*/
	public String getExamdata() {
		return examdata;
	}
	public void setExamdata(String examdata) {
		this.examdata = examdata;
	}


	public String makeExamnumber()
	{
		HttpSession msession = ServletActionContext.getRequest().getSession();
		return msession.getAttribute("usernumber") + "#" + this.examsubject;
	}
	


	public String execute()
	{
		String temp = "";
		if(this.examsubject.equals("01"))
		{
			temp = "电子学";
		}
		if(this.examsubject.equals("02"))
		{
			temp = "C++";
		}
		if(this.examsubject.equals("03"))
		{
			temp = "Java";
		}
		if(this.examsubject.equals("04"))
		{
			temp = "C#";
		}
		//time:  2018-06-0101:01:01 - 00:00:00
		
		String be_time=examdata.substring(10,18);
		String end_time=examdata.substring(21);
		String Day=examdata.substring(0,10)+" "+be_time;
		Date day_now=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			day_now= sdf.parse(sdf.format(new Date()));

			} catch (ParseException e) {

			   e.printStackTrace();
			}
		
		Date day = null;
		try {
			day = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(Day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		Date begin = null;
		try {
			begin = new SimpleDateFormat("HH:mm:ss").parse(be_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Date end = null;
		try {
			end = new SimpleDateFormat("HH:mm:ss").parse(end_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long d=day_now.getTime();
		long d1=day.getTime();
		long b1 = begin.getTime();  
        long e1 = end.getTime();  
        
        System.out.println("d:"+d+"   d1:"+d1+"   b1:"+b1+"   e1:"+e1);
        
        if(d<=d1)
        {
        	if(b1<e1)
        	{
        		HttpSession msession = ServletActionContext.getRequest().getSession();
        		System.out.println("老师编号:" + msession.getAttribute("usernumber") + "kemu:" + temp);
        		Exam exam = new Exam();
        		exam.setExamdata(examdata);
        		exam.setExamnumber(this.makeExamnumber());
        		exam.setExamsubject(temp);
        		exam.setStatus(examstatus);
        		ORMTool ormtool = new ORMTool("exam",exam);
        		ormtool.insert();
        	}
        	
        }
		
		/*HttpSession msession = ServletActionContext.getRequest().getSession();
		System.out.println("老师编号:" + msession.getAttribute("usernumber") + "kemu:" + temp);
		Exam exam = new Exam();
		exam.setExamdata(examdata);
		exam.setExamnumber(this.makeExamnumber());
		exam.setExamsubject(temp);
		exam.setStatus(examstatus);
		ORMTool ormtool = new ORMTool("exam",exam);
		ormtool.insert();*/
		return SUCCESS;
	}
	
}