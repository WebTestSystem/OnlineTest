package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import bean.Exam;
import tool.ORMTool;

public class TeacherToManager extends ActionSupport{
	
	private String id;
	private String btntext;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBtntext() {
		return btntext;
	}
	public void setBtntext(String btntext) {
		this.btntext = btntext;
	}
	
	public String execute()
	{
		if (this.btntext.equals("设为管理员")) {
			ORMTool ormtool = new ORMTool();
			String hql = "update Teacher t set t.isadmin = :newarg where t.id = :oldid";
			ormtool.initSession();
			int update = ormtool.getSession().createQuery(hql).setString("newarg", "是").setString("oldid", this.id)
					.executeUpdate();
			ormtool.getTranscation().commit();
			ormtool.closeSession();
		}
		else
		{
			ORMTool ormtool = new ORMTool();
			String hql = "update Teacher t set t.isadmin = :newarg where t.id = :oldid";
			ormtool.initSession();
			int update = ormtool.getSession().createQuery(hql)
					.setString("newarg", "否")
					.setString("oldid", this.id)
					.executeUpdate();
			ormtool.getTranscation().commit();
			ormtool.closeSession();
		}
		return SUCCESS;
	}
	
}
