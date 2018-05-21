package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import bean.Exam;
import tool.ORMTool;

public class StartExamAction  extends ActionSupport{
	
	private String examnumber;
	private String nowstatus;

	
	
	public String getExamnumber() {
		return examnumber;
	}
	public void setExamnumber(String examnumber) {
		this.examnumber = examnumber;
	}
	public String getNowstatus() {
		return nowstatus;
	}
	public void setNowstatus(String nowstatus) {
		this.nowstatus = nowstatus;
	}
	
	
	public String execute()
	{
		if (this.nowstatus.equals("δ��ʼ")) {
			System.out.println("���༭�Ŀ��Ժ�:" + this.examnumber + "\n��ǰ״̬��" + this.nowstatus);
			ORMTool ormtool = new ORMTool();
			ormtool.initSession();
			String hql = "update Exam e set e.status = :newStatus where e.number = :oldNumber";
			int updateEnnity = ormtool.getSession().createQuery(hql).setString("newStatus", "������")
					.setString("oldNumber", this.examnumber).executeUpdate();
			ormtool.getTranscation().commit();
			ormtool.closeSession();
			return SUCCESS;
		} else {
			System.out.println("���༭�Ŀ��Ժ�:" + this.examnumber + "\n��ǰ״̬��" + this.nowstatus);
			ORMTool ormtool = new ORMTool();
			ormtool.initSession();
			String hql = "update Exam e set e.status = :newStatus where e.number = :oldNumber";
			int updateEnnity = ormtool.getSession().createQuery(hql).setString("newStatus", "δ��ʼ")
					.setString("oldNumber", this.examnumber).executeUpdate();
			ormtool.getTranscation().commit();
			ormtool.closeSession();
			return SUCCESS;
		}
	}
	
}