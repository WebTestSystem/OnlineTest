package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import AES.AESUtils;
import tool.ORMTool;

public class EditStudentAction extends ActionSupport{
	
	private String studentid;
	private String studentname;
	private String studentnumber;

	
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentnumber() {
		return studentnumber;
	}
	public void setStudentnumber(String studentnumber) {
		this.studentnumber = studentnumber;
	}


	public String execute()
	{
		System.out.println("id:" + this.studentid + "\nname" + this.studentname);
		ORMTool ormtool = new ORMTool();
		ormtool.initSession();
		String hql = "update Student s set s.name = :newName,s.number = :newNumber where s.id = :oldId";
		
		//jiami
		String key="666";
		String en_studentname=AESUtils.encrypt(key, this.studentname);
		
		int updateEnnity = ormtool.getSession().createQuery(hql)
				.setString("newName", en_studentname)
				.setString("newNumber", this.studentnumber)
				.setString("oldId", this.studentid)
				.executeUpdate();
		ormtool.getTranscation().commit();
		ormtool.closeSession();
		return SUCCESS;
	}
	
}