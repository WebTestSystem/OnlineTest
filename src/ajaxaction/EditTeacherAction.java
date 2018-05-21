package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import tool.ORMTool;

public class EditTeacherAction extends ActionSupport{
	
	private String teacherid;
	private String teachername;
	private String teachernumber;



	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getTeachernumber() {
		return teachernumber;
	}
	public void setTeachernumber(String teachernumber) {
		this.teachernumber = teachernumber;
	}
	
	
	public String execute()
	{
		System.out.println("id:" + this.teacherid + "\nname" + this.teachername);
		ORMTool ormtool = new ORMTool();
		ormtool.initSession();
		String hql = "update Teacher t set t.name = :newName,t.number = :newNumber where t.id = :oldId";
		int updateEnnity = ormtool.getSession().createQuery(hql)
				.setString("newName", this.teachername)
				.setString("newNumber", this.teachernumber)
				.setString("oldId", this.teacherid)
				.executeUpdate();
		ormtool.getTranscation().commit();
		ormtool.closeSession();
		return SUCCESS;
	}
	
}