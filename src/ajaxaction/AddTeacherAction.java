package ajaxaction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.text.Highlighter.Highlight;

import org.hibernate.Query;

import com.opensymphony.xwork2.ActionSupport;

import AES.AESUtils;
import bean.Teacher;
import tool.ORMTool;
/*
 * 管理员添加教师
 */
public class AddTeacherAction extends ActionSupport{
	
	private String teachername;
	private String teacherpassword;
	private String teachernumber;

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
	public String getTeachernumber() {
		return teachernumber;
	}
	public void setTeachernumber(String teachernumber) {
		this.teachernumber = teachernumber;
	}
	
	//生成一个老师编号
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String makeTeacherNumber()
	{
		
		 Calendar cal = Calendar.getInstance();
	     int year = cal.get(Calendar.YEAR);//获取年份
	     int month=cal.get(Calendar.MONTH);//获取月份
	     int day=cal.get(Calendar.DATE);//获取日
	     int hour=cal.get(Calendar.HOUR);//小时
	     int minute=cal.get(Calendar.MINUTE);//分           
	     int second=cal.get(Calendar.SECOND);//秒
	     
	     
	     List list = new ArrayList();
	     list.add(month);
	     list.add(day);
	     list.add(hour);
	     list.add(minute);
	     list.add(second);
	     
	     System.out.println(year+" "+month+" "+day+" "+hour+" "+minute+" "+second);
	     
	     String endofid=String.valueOf(year);
	     
	     for(int i=0;i<list.size();i++) {
	    	 if(list.get(i).toString().length()<2) {
	    		 Object element = list.get(i);
	    		 //System.out.println("hhh"+element);
	    		 element = "0"+element;
	    		 //System.out.println(element);
	    		 list.set(i, element);
	    	 }
	    	 endofid=endofid+list.get(i);
	     }
	     System.out.println(endofid);
	     return this.teachernumber +endofid; 
	}
	
	
	public String execute()
	{
			
		Teacher tea = new Teacher();
		
		//jiami
		String key="666";
		String en_teachername=AESUtils.encrypt(key, teachername);
		String en_teacherpassword;
		tea.setTeachername(en_teachername);
		tea.setTeachernumber(this.makeTeacherNumber());
		//tea.setTeachername(teachername);
		//tea.setTeachernumber(this.makeTeacherNumber());
		if(this.teacherpassword.equals(""))
		{
			this.teacherpassword = this.makeTeacherNumber();
		}
		
		en_teacherpassword=AESUtils.encrypt(key, teacherpassword);
		tea.setTeacherpassword(en_teacherpassword);
		//tea.setTeacherpassword(teacherpassword);
		ORMTool ormtool1 = new ORMTool("teacher",tea);
		ormtool1.insert();
		return SUCCESS;
	}
	
}