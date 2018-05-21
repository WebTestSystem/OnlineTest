package ajaxaction;

import java.util.List;

import org.hibernate.Query;

import com.opensymphony.xwork2.ActionSupport;

import bean.Teacher;
import tool.ORMTool;
/*
 * 管理员添加教师
 */
public class AddTeacherAction extends ActionSupport{
	
	private String teachername;
	private String teacherpassword;
	
	private String checkresult = "right";

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTeacherpassword() {
		return teacherpassword;
	}

	public void setTeacherpassword(String teacherpassword) {
		this.teacherpassword = teacherpassword;
	}

	
	public String execute()
	{
	/*	ORMTool ormtool = new ORMTool();
		ormtool.initSession();
		String hql = "select t.number from Teacher t";
		Query query = ormtool.getQuery(hql);
		List<String> list = query.list();
		System.out.println(list.size());
		for(String obj : list)
		{
			System.out.println("查询：" + obj);
			if(obj.equals(teacherpassword))
			{
				this.checkresult = "error";
			}
		}
		
		if(this.checkresult.equals("error"))
		{
			return "";
		}
		else
		{*/
			Teacher tea = new Teacher();
			tea.seteId(null);
			tea.setName(teachername);
			tea.setNumber(teacherpassword);
			ORMTool ormtool1 = new ORMTool("teacher",tea);
			ormtool1.insert();
			return SUCCESS;
		/*}*/
	}
	
}