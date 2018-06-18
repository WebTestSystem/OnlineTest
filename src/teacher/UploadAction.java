//package teacher;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.struts2.ServletActionContext;
//
//import com.opensymphony.xwork2.ActionSupport;
//
//import tool.ORMTool;
//
//public class UploadAction extends ActionSupport{
//	
//	private File uploadImage; //得到上传的文件
//    private String uploadImageContentType; //得到文件的类型
//    private String uploadImageFileName; //得到文件的名称
//    
//    public String execute(){
//        System.out.println("fileName:"+this.getUploadImageFileName());
//        System.out.println("contentType:"+this.getUploadImageContentType());
//        System.out.println("File:"+this.getUploadImage());
//        
//        //获取要保存文件夹的物理路径(绝对路径)
//        String realPath=ServletActionContext.getServletContext().getRealPath("/upload");
//        File file = new File(realPath);
//        
//        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
//        if(!file.exists())file.mkdirs();
//        
//        try {
//            //保存文件
//            FileUtils.copyFile(uploadImage, new File(file,uploadImageFileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return SUCCESS;
//    }
//
//    public File getUploadImage() {
//        return uploadImage;
//    }
//
//    public void setUploadImage(File uploadImage) {
//        this.uploadImage = uploadImage;
//    }
//
//    public String getUploadImageContentType() {
//        return uploadImageContentType;
//    }
//
//    public void setUploadImageContentType(String uploadImageContentType) {
//        this.uploadImageContentType = uploadImageContentType;
//    }
//
//    public String getUploadImageFileName() {
//        return uploadImageFileName;
//    }
//
//    public void setUploadImageFileName(String uploadImageFileName) {
//        this.uploadImageFileName = uploadImageFileName;
//    }
package teacher;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import SystemTest.TempClass;
import tool.ORMTool;

public class UploadAction extends ActionSupport{
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
		String realpath=ServletActionContext.getServletContext().getRealPath("/upload/examinationPaper");
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
		
		HttpSession msession = ServletActionContext.getRequest().getSession();
		String TeaName=(String) msession.getAttribute("enusername");
		System.out.println(TeaName);
		
		//更新老师表中的uploadFileName,uploadFileDate
		ORMTool ormtool1 = new ORMTool();
		ormtool1.initSession();
		String hql1 = "update Teacher t set t.uploadFileName=?,t.uploadFileDate=? where t.teachername=?";
		int updateEntities = ormtool1.getSession().createQuery(hql1)
				.setString(0, this.uploadFileName).setString(1, date).setString(2, TeaName)
				.executeUpdate();
		ormtool1.getSession().getTransaction().commit();
		//ormtool1.getSession().close();
		System.out.println(updateEntities);
		
		//获取examnumber
		//HttpSession session = ServletActionContext.getRequest().getSession();
		//String examnumber = (String) session.getAttribute("thisexamnumber");
		String examnumber = TempClass.temp;
		System.out.println(examnumber+"哈哈哈");
		
		//更新Exam表中的ExamFileName
		ORMTool ormtool2 = new ORMTool();
		ormtool2.initSession();
		String hql2 = "update Exam e set e.examFileName=? where e.examnumber=?";
		int updateEntities2 = ormtool2.getSession().createQuery(hql2)
				.setString(0, this.uploadFileName).setString(1, examnumber)
				.executeUpdate();
		ormtool2.getSession().getTransaction().commit();
		ormtool2.getSession().close();
		System.out.println(updateEntities2+"hh");
		
		act.put("message", "上传成功！");
		return SUCCESS;
	}
}