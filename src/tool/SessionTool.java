package tool;

import java.util.Map;

import javax.websocket.Session;

import com.opensymphony.xwork2.ActionContext;


public class SessionTool{
	
	
	private  ActionContext actionContext;
	private  Map<String, Object> session;
	
	
	public void init(ActionContext actionContext)
	{
		this.actionContext = actionContext;
		this.session = actionContext.getSession();
	}
  
	public void setSession(String username)
	{
		session.put("username", username);
	}
	
	public void setSession(String username,String userpassword)
	{
		session.put("username", username);
		session.put("usernumber", userpassword);
	}
	
	public void setSession(String username,String userpassword,String usernumber)
	{
		session.put("username", username);
		session.put("userpassword", userpassword);
		session.put("usernumber", usernumber);
	}
	public void setSession(String username,String userpassword,String usernumber,String enusername)
	{
		session.put("username", username);
		session.put("userpassword", userpassword);
		session.put("usernumber", usernumber);
		session.put("enusername", enusername);
	}
	public void setSession(String username,String userpassword,String usernumber,String enusername,String examnumber)
	{
		session.put("username", username);
		session.put("userpassword", userpassword);
		session.put("usernumber", usernumber);
		session.put("enusername", enusername);
		session.put("examnumber", examnumber);
	}
	
}
