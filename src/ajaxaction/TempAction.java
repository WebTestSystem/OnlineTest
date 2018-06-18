package ajaxaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.opensymphony.xwork2.ActionSupport;

import SystemTest.TempClass;
import tool.ORMTool;

public class TempAction  extends ActionSupport{
	
	private String temp;
	
	
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String execute()
	{
		System.out.println("before:" + TempClass.temp);
		TempClass.temp = this.temp;
		System.out.println("aftre:" + TempClass.temp);
		return null;
	}
	
}