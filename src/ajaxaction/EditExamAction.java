package ajaxaction;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import tool.ORMTool;

public class EditExamAction extends ActionSupport{
	
	private String examsubject;
	private String examdata;
	private String examnumber;
	private String examclass;

	
	
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
	public String getExamnumber() {
		return examnumber;
	}
	public void setExamnumber(String examnumber) {
		this.examnumber = examnumber;
	}
	public void setExamclass(String examclass) {
		this.examclass = examclass;
	}



	public String execute()
	{
		System.out.println("�������ݣ���Ŀ��" + this.examsubject +  "\n����" + this.examdata + "\n��ͣ�" 
				+ this.examclass + "\n���Ժţ�" + this.examnumber);
		ORMTool ormtool = new ORMTool();
		ormtool.initSession();
		String hql = "update Exam e set e.subject = :newSubject,e.data = :newData,e.mClass = :newClass where e.number = :oldNumber";
		int updateEnnity = ormtool.getSession().createQuery(hql)
				.setString("newSubject", this.examsubject)
				.setString("newData", this.examdata)
				.setString("newClass", this.examclass)
				.setString("oldNumber", this.examnumber)
				.executeUpdate();
		ormtool.getTranscation().commit();
		ormtool.closeSession();
		return SUCCESS;
	}
	
}
