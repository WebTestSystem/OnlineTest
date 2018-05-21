package comman;

import java.util.List;

import org.hibernate.Query;

import com.opensymphony.xwork2.ActionSupport;

import bean.PageIndex;
import tool.ORMTool;

public class LinkAction extends ActionSupport{
	
	private String url="null_page";
	private String index;

	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}

	public String execute()
	{
		switch(index)
		{
			case "0000":
				this.url = PageIndex.app_firstpage;
				break;
			case "0001":
				this.url = PageIndex.adminindex_teacher_firstpage;
				break;
			case "0002":
				this.url = PageIndex.adminindex_teacher_addteacher;
				break;
			case "0003":
				this.url = PageIndex.adminindex_teacher_operationafterexam;
				break;
			case "0004":
				this.url = PageIndex.adminindex_teacher_setsystem;
				break;
			case "1000":
				this.url = PageIndex.teacherindex_teacher_main;
				break;
			case "1004":
				this.url = PageIndex.teacherindex_teacher_afterexam;
				break;
			case "1005":
				this.url = PageIndex.teacherindex_teacher_beforeexam;
				break;
			case "1007":
				this.url = PageIndex.teacherindex_teacher_managenotify;
				break;
			case "1008":
				this.url = PageIndex.teacherindex_teacher_managestudent;
				break;
			case "1009":
				this.url = PageIndex.teacherindex_teacher_managesummary;
				break;
			case "1010":
				this.url = PageIndex.teacherindex_teacher_manageunlock;
				break;
			case "2000":
				this.url = PageIndex.studentindex_student_main;
				break;
			case "2001":
				this.url = PageIndex.studentindex_student_Submissionofinformation;
				break;
		}
		return url;
	}
	
}