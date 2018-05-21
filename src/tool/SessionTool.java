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
	
	public void setSession(String username,String usernumber)
	{
		session.put("username", username);
		session.put("usernumber", usernumber);
	}
	
//	public Map<String, Object> getSession(ActionContext actionContext)
//	{
//		this.actionContext = actionContext;
//		return this.session = actionContext.getSession();
//	}
	
}
