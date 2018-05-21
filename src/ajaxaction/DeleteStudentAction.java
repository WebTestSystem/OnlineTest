package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import bean.Student;
import tool.ORMTool;

public class DeleteStudentAction extends ActionSupport{
	
	private String studentid;


	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String execute()
	{
		System.out.println("id:" + this.studentid);
		ORMTool ormtool = new ORMTool();
		ormtool.initSession();
		String hql = "delete Student s where s.id = :oldId";
		int deleteEnnity = ormtool.getSession().createQuery(hql)
				.setString("oldId", this.studentid)
				.executeUpdate();
		ormtool.getTranscation().commit();
		ormtool.closeSession();
		return SUCCESS;
	}
	
}