package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import tool.ORMTool;

public class DeleteExamAction extends ActionSupport{
	
	private String examnumber;


	public String getExamnumber() {
		return examnumber;
	}
	public void setExamnumber(String examnumber) {
		this.examnumber = examnumber;
	}


	public String execute()
	{
		ORMTool ormtool = new ORMTool();
		ormtool.initSession();
		String hql = "delete Exam e where e.examnumber = :oldnumber";
		int deleteEnnity = ormtool.getSession().createQuery(hql)
				.setString("oldnumber", this.examnumber)
				.executeUpdate();
		ormtool.getTranscation().commit();
		ormtool.closeSession();
		return SUCCESS;
	}
	
}
