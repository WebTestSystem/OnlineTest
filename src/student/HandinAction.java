package student;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.javafx.collections.MappingChange.Map;
import com.sun.net.httpserver.Authenticator.Success;

import tool.ORMTool;
import tool.SessionTool;

/*
 * 交卷子的动作
 */
public class HandinAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}

	/**
	 * @return the uploadContentType
	 */
	public String getUploadContentType() {
		return uploadContentType;
	}
	/**
	 * @param uploadContentType the uploadContentType to set
	 */
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	/**
	 * @return the uploadFileName
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}
	/**
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
	public String execute() throws Exception{
		ActionContext act = ActionContext.getContext();
		//String realpath=ServletActionContext.getServletContext().getRealPath("/upload/"+this.uploadFileName);
		String realpath=ServletActionContext.getServletContext().getRealPath("/upload/answerPaper");
		if(upload!=null)
		{
			System.out.println(realpath);
			
			File file = new File(realpath);
			if(!file.exists())
				file.mkdirs();
			
			//创建保存文件
			File saveFile = new File(file, uploadFileName);
			//使用commons-io的FileUtils上传文件
			try {
				FileUtils.copyFile(upload, saveFile);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("文件上传出错！");
				act.put("message", "上传失败");
				return ERROR;
			}
		}
		
		//获取当前上传时间并写入数据库
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		String date =df.format(System.currentTimeMillis());
		System.out.println(date); 
		
//		SessionTool sTool = new SessionTool();
//		Map session =  (Map) sTool.getSession(ActionContext.getContext());
//		String StuName = (String) ((ActionContext) session).get("userName");
		
		HttpSession msession = ServletActionContext.getRequest().getSession();
		String stuName=(String) msession.getAttribute("username");
		System.out.println(stuName);
		
		ORMTool ormtool1 = new ORMTool();
		ormtool1.initSession();
		String hql1 = "update Student s set s.uploadFileName=?,s.uploadFileDate=? where s.name=?";
		int updateEntities = ormtool1.getSession().createQuery(hql1)
				.setString(0, this.uploadFileName).setString(1, date).setString(2, stuName)
				.executeUpdate();
		ormtool1.getSession().getTransaction().commit();
		ormtool1.getSession().close();
		System.out.println(updateEntities);
		
		
		act.put("message", "上传成功！");
		return SUCCESS;
	}
	
}
