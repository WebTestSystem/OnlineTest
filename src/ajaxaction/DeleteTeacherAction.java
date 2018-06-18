package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import tool.ORMTool;

public class DeleteTeacherAction extends ActionSupport{
	
	private String teachernumber;

	public String getTeachernumber() {
		return teachernumber;
	}
	public void setTeachernumber(String teachernumber) {
		this.teachernumber = teachernumber;
	}

	public String execute()
	{
		ORMTool ormtool = new ORMTool();
		ormtool.initSession();
		String hql = "delete Teacher t where t.teachernumber = :oldNumber";
		int deleteEnnity = ormtool.getSession().createQuery(hql)
				.setString("oldNumber", this.teachernumber)
				.executeUpdate();
		ormtool.getTranscation().commit();
		ormtool.closeSession();
		return SUCCESS;
	}
	
}