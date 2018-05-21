package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import tool.ORMTool;

public class DeleteTeacherAction extends ActionSupport{
	
	private String teacherid;

	

	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String execute()
	{
		System.out.println("id:" + this.teacherid);
		ORMTool ormtool = new ORMTool();
		ormtool.initSession();
		String hql = "delete Teacher t where t.id = :oldId";
		int deleteEnnity = ormtool.getSession().createQuery(hql)
				.setString("oldId", this.teacherid)
				.executeUpdate();
		ormtool.getTranscation().commit();
		ormtool.closeSession();
		return SUCCESS;
	}
	
}