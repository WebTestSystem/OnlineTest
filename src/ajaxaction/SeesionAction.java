package ajaxaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.Query;

import tool.ORMTool;

public class SeesionAction {
	String cleartag;
	
	
	public String getCleartag() {
		return cleartag;
	}


	public void setCleartag(String cleartag) {
		this.cleartag = cleartag;
	}


	@JSON(serialize=false)
	public String execute() throws IOException {
		System.out.println("clear session");
		if(this.cleartag.equals("clear"))
		{
			HttpSession msession = ServletActionContext.getRequest().getSession();
			msession.invalidate();
		}	
		return null;
	}
	
}
