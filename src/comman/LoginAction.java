package comman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.eclipse.jdt.internal.compiler.codegen.MultiCatchExceptionLabel;
import org.hibernate.Query;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import tool.ORMTool;
import tool.SessionTool;

public class LoginAction extends ActionSupport{
	
	private String inputUsername;
	private String inputPassword;
	private String inputUsertype;
	
	private String result = "log_error";
	
	private String message_debug = "";
	private String ip;
	
	public String getInputUsername() {
		return inputUsername;
	}
	public void setInputUsername(String inputUsername) {
		this.inputUsername = inputUsername;
	}
	
	public String getInputPassword() {
		return inputPassword;
	}
	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}

	public String getInputUsertype() {
		return inputUsertype;
	}
	public void setInputUsertype(String inputUsertype) {
		this.inputUsertype = inputUsertype;
	}
	//HttpSession session = ServletActionContext.getRequest().getSession();
	
	//获取IP，绑定学生
	public String getClientIP() {

		HttpServletRequest request = ServletActionContext.getRequest();

		String ip = request.getHeader("x-forwarded-for");
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("Proxy-Client-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("X-Real-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getRemoteAddr();
		}

		return ip;
		}
	
	

	@SuppressWarnings({ "unchecked", "null" })
	public String execute()
	{
		SessionTool sTool = new SessionTool();
		sTool.init(ActionContext.getContext());
		this.message_debug = "登陆类型：" + this.inputUsertype + "\n登陆用户：" + this.inputUsername + "\n登陆密码：" + this.inputPassword;
		switch(this.inputUsertype)
		{
			case "管理员":
				
				/*System.out.println(list0.get(0).toString());
				System.out.println(list0.get(0).equals(inputPassword));
				System.out.println(list0.get(1).toString());
				System.out.println(list0.get(1).equals("是"));*/
				//Object[] obj1;
				//for(Object[] obj : list0) {
					//System.out.println("" + obj[0]);
					//obj1[0] = obj[0];
					//obj1[1] = obj[1];
				//}
				//if(obj1[0].equals(inputPassword)&&obj1[1].equals("是"))
				//{
				//	this.result = "admin";
					//sTool.setSession(inputUsername,inputPassword);
				//}
				//else {
				//	this.result="log_error";
				//}
				ORMTool ormtool0 = new ORMTool();
				ormtool0.initSession();
				String hql0 = "select t.number,t.isadmin from Teacher as t where t.name=?";
				Query query0 = ormtool0.getQuery(hql0);
				query0.setString(0, "" + this.inputUsername);
				List<Object[]> list0 = query0.list();
				Object[] obj1 = null;
				for(Object[] obj : list0) {
					System.out.println("" + obj[0]);
					obj1[0] = obj[0];
					obj1[1] = obj[1];
				}
				System.out.println(obj1[0]+" "+obj1[1]);
				if(obj1[0].equals(inputPassword)&&obj1[1].equals("是"))
				{
					this.result = "admin";
					sTool.setSession(inputUsername,inputPassword);
				}
				break;
				/*if(this.inputUsername.equals("admin")&&this.inputPassword.equals("123456"))
				{
					this.result = "admin";
					sTool.setSession(inputUsername);
				}
				break;*/
			case "教师":
				System.out.println("ceshi1");
				ORMTool ormtool1 = new ORMTool();
				ormtool1.initSession();
				String hql1 = "select t.number from Teacher as t where t.name=?";
				Query query1 = ormtool1.getQuery(hql1);
				query1.setString(0, "" + this.inputUsername);
				List<String> list1 = query1.list();
				if(list1.get(0).equals(inputPassword))
				{
					this.result = "teacher";
					sTool.setSession(inputUsername,inputPassword);
				}
				break;
			case "学生":
				//获取学号
				ORMTool ormtool2 = new ORMTool();
				ormtool2.initSession();
				String hql2 = "select s.number from Student as s where s.name=?";
				Query query2 = ormtool2.getQuery(hql2);
				query2.setString(0, "" + this.inputUsername);
				List<String> list2 = query2.list();
				//获取IP值
				ORMTool ormtool3 = new ORMTool();
				ormtool3.initSession();
				String hql3 = "select s.ipAdress from Student as s where s.name=?";
				Query query3 = ormtool3.getQuery(hql3);
				query3.setString(0, "" + this.inputUsername);
				List<String> list3 = query3.list();
				String dbip=list3.get(0).toString();
				System.out.println(dbip);//数据库中获取的ip
				System.out.println(list2.get(0).toString());//数据库中获取的密码
				System.out.println(list3.get(0).equals("ip"));//若为默认值"ip"则未绑定
				System.out.println(list2.get(0).equals(inputPassword));//匹配密码
				ip = getClientIP();
				System.out.println(ip);
				
				if(list2.get(0).equals(inputPassword)&&(list3.get(0).equals("ip")||list3.get(0).equals(ip))) {
					ip = getClientIP();
					System.out.println(ip);
					//登录成功则更新IP值
					ORMTool ormtool4 = new ORMTool();
					ormtool4.initSession();
					String hql4 = "update Student s set s.ipAdress=? where s.name=?";
					//Query query4 = ormtool4.getQuery(hql4);
					//query4.setString("ipadress", ip);
					//query4.setString("stuname", this.inputUsername);
					//int updateEntities = query4.executeUpdate();
					int updateEntities = ormtool4.getSession().createQuery(hql4)
							.setString(0, ip).setString(1, this.inputUsername)
							.executeUpdate();
					ormtool4.getSession().getTransaction().commit();
					ormtool4.getSession().close();
					
					System.out.println(updateEntities);
					sTool.setSession(inputUsername,inputPassword);
					
					this.result = "student";
				}
				else {
					this.result="log_error";
				}
				break;
				
		}
		System.out.println(this.message_debug +  "\n数据库结果："  +  this.result);
		return this.result;

	}
	
}