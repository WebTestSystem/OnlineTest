package ajaxaction;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.opensymphony.xwork2.ActionSupport;

import AES.AESUtils;
import bean.Student;
import bean.Teacher;
import tool.ORMTool;

public class AddOneStudentAction extends ActionSupport{
	
	private String studentname;
	private String studentnumber;
	private String studenttag;

	public String getStudenttag() {
		return studenttag;
	}
	public void setStudenttag(String studenttag) {
		this.studenttag = studenttag;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentnumber() {
		return studentnumber;
	}
	public void setStudentnumber(String studentnumber) {
		this.studentnumber = studentnumber;
	}


	public String makeStudenttag()
	{
		HttpSession msession = ServletActionContext.getRequest().getSession();
		return msession.getAttribute("usernumber") + "," + this.studentnumber;
	}
	

	public String execute()
	{
		Student stu = new Student();
		
		//jiami
		String key="666";
		String en_studentname=AESUtils.encrypt(key, studentname);
		String en_studentnumber=AESUtils.encrypt(key, this.studentnumber);
		String new_examtag=this.studenttag.substring(21);
		
		
		ORMTool ormtoolstudent = new ORMTool();
        ormtoolstudent.initSession();
		String hqlstudent = "select s.studentnumber,s.studenttag from Student as s where s.studentname=?";
		Query querystudent = ormtoolstudent.getQuery(hqlstudent);
		querystudent.setString(0, "" + en_studentname);
		List<Object[]> list = querystudent.list();
		
		
		if(list.size()==0)
		{
			stu.setStudentname(en_studentname);
			stu.setStudentnumber(en_studentnumber);
			stu.setStudenttag(this.studenttag);
			stu.setIpAdress("ip");
			stu.setStatus("ÀëÏß");
			ORMTool ormtool = new ORMTool("student",stu);
			ormtool.insert();
	    }
		else
		{  for(Object[] obj0 : list)
		   {
			//20150220180505060534#03
			    String studenttag=obj0[1].toString();
			    if(studenttag.substring(0,20).equals(this.studenttag.substring(0, 20)))
			    {
			    	ORMTool ormtool = new ORMTool();
					ormtool.initSession();
					String hql = "delete Student s where s.studentnumber = :oldId";
					int deleteEnnity = ormtool.getSession().createQuery(hql)
							.setString("oldId", en_studentnumber)
							.executeUpdate();
					ormtool.getTranscation().commit();
					ormtool.closeSession();
								

					for(Object[] obj : list) {
						String studenttag2=obj[1]+","+new_examtag;
						
						System.out.println("978433369  "+studenttag2);				
						stu.setStudentname(en_studentname);
						stu.setStudentnumber(en_studentnumber);
						stu.setStudenttag(studenttag2);
						stu.setIpAdress("ip");
						stu.setStatus("ÀëÏß");
									
						ORMTool ormtool2= new ORMTool("student",stu);
						ormtool2.insert();
						System.out.println("ok!!!!  "+studenttag);			
					}
			    	
			    }
			    else
			    {
			    	stu.setStudentname(en_studentname);
					stu.setStudentnumber(en_studentnumber);
					stu.setStudenttag(this.studenttag);
					stu.setIpAdress("ip");
					stu.setStatus("ÀëÏß");
					ORMTool ormtool = new ORMTool("student",stu);
					ormtool.insert();
			    }
		   }
			
			
			
		}
		
		
		return SUCCESS;
	}
	
}