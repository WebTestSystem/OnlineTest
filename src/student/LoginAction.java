package student;

import java.util.List;

import org.hibernate.Query;

import com.opensymphony.xwork2.ActionSupport;

import tool.ORMTool;
//登录功能统一到comman包下logainaction处理逻辑
public class LoginAction extends ActionSupport{
	private String inputUsername;
	private String inputPassword;
	
	
	
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


	public String execute()
	{
		ORMTool ormtool = new ORMTool();
		ormtool.initSession();
		String hql = "select s.number from Student as s where s.name=?";
		Query query = ormtool.getQuery(hql);
		query.setString(0, "" + this.inputUsername);
		List<String> list = query.list();
		/*System.out.println(list.size() + this.inputUsername);
		for(String str : list)
		{
			System.out.println(list.get(0));
		}*/
		if(list.get(0).equals(inputPassword))
				return SUCCESS;
		else
			return ERROR;
	}
	
}
