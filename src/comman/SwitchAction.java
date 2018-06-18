package comman;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class SwitchAction extends ActionSupport{
   
    public String execute() throws IOException{
    	System.out.println("×ª·¢ÖÐ¡£¡£");
    	HttpServletResponse response = ServletActionContext.getResponse();  
    	response.getWriter().println("ok"); 
        return SUCCESS;
    }
    
}
