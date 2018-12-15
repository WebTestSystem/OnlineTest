package student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import tool.ORMTool;
import tool.ZipTool;

public class DownloadAction extends ActionSupport{
	
	private int number;
    private String fileName;
    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getDownLoadFile() throws IOException {
    	
    	
		
        if(1==number){
        	//获取studenttag了
    		HttpSession msession = ServletActionContext.getRequest().getSession();
    		String examnumber= msession.getAttribute("examnumber").toString();
    		System.out.println("examnumber At DownloadAction:"+examnumber);
        	
        	//获取examfilename
        	ORMTool ormtool0 = new ORMTool();
    		ormtool0.initSession();
    		String hql0 = "select e.examFileName,e.status from Exam as e where e.examnumber=?";
    		Query query0 = ormtool0.getQuery(hql0);
    		query0.setString(0, "" + examnumber);
    		List<Object[]> list0 = query0.list();
    		String examfileName = null;
    		for(Object[] obj : list0) {
    			examfileName=obj[0].toString();
    		}
    		System.out.println("examfileName:"+examfileName);
        	
        	
            this.fileName=examfileName;
            this.fileName=new String(this.fileName.getBytes("gbk"), "iso-8859-1");
            String path = "/upload/examinationPaper/"+examfileName;
            System.out.println(path);
          //获取资源路径
          return ServletActionContext.getServletContext().getResourceAsStream(path);
        }
        else if(2==number){
//            this.fileName="jd2chm源码生成chm格式文档.rar" ;  
//            //解决乱码
//            this.fileName=new String(this.fileName.getBytes("gbk"), "iso-8859-1");
//            return ServletActionContext.getServletContext().getResourceAsStream("upload/jd2chm源码生成chm格式文档.rar");
        	
        	//先打包在下载 
        	HttpServletRequest request = ServletActionContext.getRequest(); 
        	String sourceFilePath = request.getSession().getServletContext().getRealPath("/")+"/upload/answerPaper"; 
            String zipFilePath = request.getSession().getServletContext().getRealPath("/")+"/filetemps";  
            String fileName = "answerPaper";  
            System.out.println(sourceFilePath+"class");
            System.out.println(zipFilePath);
            boolean flag = ZipTool.fileToZip(sourceFilePath, zipFilePath, fileName);  
            if(flag){  
                System.out.println("文件打包成功!");  
            }else{  
                System.out.println("文件打包失败!");  
            }  
            this.fileName="answerPaper.zip";
            this.fileName=new String(this.fileName.getBytes("gbk"), "iso-8859-1");
            //获取资源路径
            return ServletActionContext.getServletContext().getResourceAsStream("/filetemps/answerPaper.zip");
        }
        return null;
    }

    @Override
    public String execute() throws Exception {
    	System.out.println("Student.....");
        return SUCCESS;
    }

	
//	//用户请求文件名
//	private String fileName;
//	//下载资源路径（Stucts中配置）
//	private String inputPath;
//	
//	public String getFileName() {
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//	public String getInputPath() {
//		return inputPath;
//	}
//	public void setInputPath(String inputPath) {
//		this.inputPath = inputPath;
//	}
//	
//	public String downloadFile() throws Exception{
//		ServletContext context = ServletActionContext.getServletContext();
//		String downloadDir = context.getRealPath("/upload");
//		String downloadFile= context.getRealPath(inputPath);
//		//防止用户请求不安全资源
//		if(!downloadFile.startsWith(downloadDir)) {
//			return null;
//		}
//		return "download_success";
//	}
//	
//	/*
//	 * 获取输入流资源
//	 */
//	public InputStream getInputStream() throws Exception{
//		String path = inputPath+File.separatorChar+new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
//		return ServletActionContext.getServletContext().getResourceAsStream(path);
//	}
//	
//	/*
//	 * 获取下载时文件默认的文件名
//	 */
//	public String  getDownloadFileName() {
//		String downloadFileName = fileName;
//		try {
//			downloadFileName=URLEncoder.encode(downloadFileName,"ISO-8859-1");
//		} catch (UnsupportedEncodingException e) {
//			// TODO: handle exception
//			e.getMessage();
//			e.printStackTrace();
//		}
//		return downloadFileName;
//	}
}
