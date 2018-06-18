package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import bean.Exam;
import tool.ORMTool;

public class TeacherToManager extends ActionSupport{
	
	private String teachernumber;
	private String btntext;

	
	public String getTeachernumber() {
		return teachernumber;
	}
	public void setTeachernumber(String teachernumber) {
		this.teachernumber = teachernumber;
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
			String hql = "update Teacher t set t.isadmin = :newarg where t.teachernumber = :oldNumber";
			ormtool.initSession();
			int update = ormtool.getSession().createQuery(hql).setString("newarg", "是").setString("oldNumber", this.teachernumber)
					.executeUpdate();
			ormtool.getTranscation().commit();
			ormtool.closeSession();
		}
		else
		{
			ORMTool ormtool = new ORMTool();
			String hql = "update Teacher t set t.isadmin = :newarg where t.teachernumber = :oldNumber";
			ormtool.initSession();
			int update = ormtool.getSession().createQuery(hql)
					.setString("newarg", "否")
					.setString("oldNumber", this.teachernumber)
					.executeUpdate();
			ormtool.getTranscation().commit();
			ormtool.closeSession();
		}
		return SUCCESS;
	}
	
}
