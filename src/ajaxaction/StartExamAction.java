package ajaxaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

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
		if (this.nowstatus.equals("未开始")) {
			System.out.println("待编辑的考试号:" + this.examnumber + "\n当前状态：" + this.nowstatus);
			ORMTool ormtool = new ORMTool();
			ormtool.initSession();
			
			String hql_status_started="select e.examdata,e.examnumber,e.examsubject from Exam e where e.status=?";
			Query query_started = ormtool.getQuery(hql_status_started);
			query_started.setString(0, "进行中");
			List<Object[]> list_started = query_started.list();
			
			String hql_this= "select e.examnumber,e.examsubject,e.examdata,e.status from Exam e where e.examnumber=?";
			Query query = ormtool.getQuery(hql_this);
			query.setString(0, this.examnumber);
			
			int cover_count=0;
			String day_started;
			String day_this;
			String time_started_start;
			String time_this_start;
			String time_started_end;
			String time_this_end;
			
			List<Object[]> list_this = query.list();		
			for(Object[] obj : list_started)
			{
				for(Object[] obj2 : list_this)
				{
					day_started=obj[0].toString().substring(0,10);
					day_this=obj2[2].toString().substring(0,10);
					
					time_started_start=obj[0].toString().substring(10,18);
					time_this_start=obj2[2].toString().substring(10,18);
					time_started_end=obj[0].toString().substring(21);
					time_this_end=obj2[2].toString().substring(21);
					
					Date started1 = null;
					try {
						started1 = new SimpleDateFormat("HH:mm:ss").parse(time_started_start);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					Date started2 = null;
					try {
						started2= new SimpleDateFormat("HH:mm:ss").parse(time_this_start);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					Date end1 = null;
					try {
						end1 = new SimpleDateFormat("HH:mm:ss").parse(time_started_end);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					Date end2 = null;
					try {
						end2 = new SimpleDateFormat("HH:mm:ss").parse(time_this_end);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					long b1 = started1.getTime();  
			        long e1 = end1.getTime();  
			        long b2 = started2.getTime();  
			        long e2 = end2.getTime();  
					if(day_started.equals(day_this))
					{
						if(b1<=e2&&e1>=b2)
						{
							cover_count++;
						}
					}
				}
			}
			
			if(cover_count==0)
			{
				String hql = "update Exam e set e.status = :newStatus where e.examnumber = :oldNumber";
				int updateEnnity = ormtool.getSession().createQuery(hql).setString("newStatus", "进行中")
						.setString("oldNumber", this.examnumber).executeUpdate();
				ormtool.getTranscation().commit();
				ormtool.closeSession();
				
				String hql2 = "update Student s set s.status = :newStatus where s.examnumber = :oldNumber";
				int updateEnnity2 = ormtool.getSession().createQuery(hql2).setString("newStatus", "进行中")
						.setString("oldNumber", this.examnumber).executeUpdate();
				ormtool.getTranscation().commit();
				ormtool.closeSession();
				
			}			
			return SUCCESS;
		} else
		{
			System.out.println("待编辑的考试号:" + this.examnumber + "\n当前状态：" + this.nowstatus);
			ORMTool ormtool = new ORMTool();
			ormtool.initSession();
			String hql = "update Exam e set e.status = :newStatus where e.examnumber = :oldNumber";
			int updateEnnity = ormtool.getSession().createQuery(hql).setString("newStatus", "未开始")
					.setString("oldNumber", this.examnumber).executeUpdate();
			ormtool.getTranscation().commit();
			ormtool.closeSession();
			
			ORMTool ormtool2 = new ORMTool();
			ormtool2.initSession();
			String hql2 = "update Student s set s.ipAdress = :newipAdress";
			int updateEnnity2 = ormtool2.getSession().createQuery(hql2).setString("newipAdress", "ip").
					executeUpdate();
			ormtool2.getTranscation().commit();
			ormtool2.closeSession();
			return SUCCESS;
		}
	}
	
}