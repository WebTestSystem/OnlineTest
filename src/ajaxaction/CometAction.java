package ajaxaction;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.Query;

import com.opensymphony.xwork2.ActionSupport;

import bean.Exam;
import tool.ORMTool;

public class CometAction extends ActionSupport {
	String studenttag;
	
	public String getStudenttag() {
		return studenttag;
	}

	public void setStudenttag(String studenttag) {
		this.studenttag = studenttag;
	}

	@JSON(serialize=false)
	
	public String execute() throws IOException {
		System.out.println("转发中。。");
		String examnumber=this.studenttag;
		/*StringBuffer sb = new StringBuffer();
		sb.append("<table border='2px'>").append("<tr><td>编号</td><td>姓名</td></tr>");
		sb.append("<tr><td>1</td><td>wyc</td></tr>");
		sb.append("<tr><td>2</td><td>tele</td></tr>");
		sb.append("<tr><td>3</td><td>fifth</td></tr>");
		sb.append("</table>");*/
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		ORMTool ormtool = new ORMTool();
		ormtool.initSession();
		String sql = "select e.examnumber,e.status from Exam as e where e.examnumber=?";
		Query query = ormtool.getQuery(sql);
		System.out.println("examnumber  "+examnumber);
		query.setString(0,examnumber);
		List<Object[]> list = query.list();
		System.out.println("list.size():  "+list.size());
		for(Object[] obj1 : list) {	
			System.out.println("clear");
			if(obj1[1].toString().equals("未开始"))
			{
				
				pw.write("noend");
			}
			else
			{
				pw.write("nostart");
			}
		}
		//pw.write("noend");
					
		pw.flush();
		pw.close();
		return null;
	}

}