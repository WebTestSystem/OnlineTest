package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import AES.AESUtils;
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
		String hql = "delete Student s where s.studentnumber = :oldId";
		
		String en_studentnumber=AESUtils.encrypt("666", this.studentid);
		int deleteEnnity = ormtool.getSession().createQuery(hql)
				.setString("oldId", en_studentnumber)
				.executeUpdate();
		ormtool.getTranscation().commit();
		ormtool.closeSession();
		return SUCCESS;
	}
	
}