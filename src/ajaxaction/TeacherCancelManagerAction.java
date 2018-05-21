package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import tool.ORMTool;

public class TeacherCancelManagerAction extends ActionSupport{
	
	private String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String execute()
	{
		ORMTool ormtool = new ORMTool();
		String hql = "update Teacher t set t.isadmin = :newarg where t.id = :oldid";
		ormtool.initSession();
		int update = ormtool.getSession().createQuery(hql)
				.setString("newarg", "·ñ")
				.setString("oldid", this.id)
				.executeUpdate();
		ormtool.getTranscation().commit();
		ormtool.closeSession();
		return SUCCESS;
	}
	
}
