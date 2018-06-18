package teacher;

import java.util.List;

import org.hibernate.Query;

import com.opensymphony.xwork2.ActionSupport;

import AES.AESUtils;
import bean.Teacher;
import tool.ORMTool;

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
		String key="666";
		ORMTool ormtool = new ORMTool();
		ormtool.initSession();
		String hql = "select t.number from Teacher as t where t.name=?";
		Query query = ormtool.getQuery(hql);
		
		//¸Ä¡¢¼ÓÃÜ
		String en_inputUsername=AESUtils.encrypt(key, this.inputUsername);		
		String en_inputPassword=AESUtils.encrypt(key, inputPassword);
		query.setString(0, "" + en_inputUsername);
		
		//query.setString(0, "" + this.inputUsername);
		List<String> list = query.list();
		/*System.out.println(list.size() + this.inputUsername);
		for(String str : list)
		{
			System.out.println(list.get(0));
		}*/
		if(list.get(0).equals(en_inputPassword))
				return SUCCESS;
		else
			return ERROR;
	}
	
}