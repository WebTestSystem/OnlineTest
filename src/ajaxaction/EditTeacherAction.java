package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import AES.AESUtils;
import tool.ORMTool;

/*
 * –ﬁ∏ƒ¿œ ¶√‹¬Î
 */
public class EditTeacherAction extends ActionSupport{
	
	private String teachernumber;
	private String teacherpassword;

	
	public String getTeacherpassword() {
		return teacherpassword;
	}
	public void setTeacherpassword(String teacherpassword) {
		this.teacherpassword = teacherpassword;
	}
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
		String hql = "update Teacher t set t.teacherpassword = :newPass where t.teachernumber = :oldNumber";
		
		//jiami
		String key="666";
		String en_teacherpassword=AESUtils.encrypt(key, this.teacherpassword);
		
		int updateEnnity = ormtool.getSession().createQuery(hql)
				.setString("newPass", en_teacherpassword)
				.setString("oldNumber", this.teachernumber)
				.executeUpdate();
		ormtool.getTranscation().commit();
		ormtool.closeSession();
		return SUCCESS;
	}
	
}