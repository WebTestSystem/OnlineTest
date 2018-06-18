package teacher;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import tool.ORMTool;
import tool.ZipTool;

public class DownloadAction extends ActionSupport{
	
	private int number;
 

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private String filename;
 
   

    public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public InputStream getTargetFile() throws IOException {
    	
    	//先打包在下载 
//    	HttpServletRequest request = ServletActionContext.getRequest(); 
//    	String sourceFilePath = request.getSession().getServletContext().getRealPath("/")+"/upload/answerPaper"; 
//        String zipFilePath = request.getSession().getServletContext().getRealPath("/")+"/filetemps";  
//        String fileName = "answerPaper";  
//        System.out.println(sourceFilePath+"class");
//        System.out.println(zipFilePath);
//        boolean flag = ZipTool.fileToZip(sourceFilePath, zipFilePath, fileName);  
//        if(flag){  
//            System.out.println("文件打包成功!");  
//        }else{  
//            System.out.println("文件打包失败!");  
//        }  
    	
        //下载路径
        if(number==1){
//            this.filename="answerPaper.zip";
//            this.filename=new String(this.filename.getBytes("gbk"), "iso-8859-1");
//            //获取资源路径
//            return ServletActionContext.getServletContext().getResourceAsStream("/filetemps/answerPaper.zip");
        }
        else if(number==2){
//              this.filename="answerPaper.zip";
//              this.filename=new String(this.filename.getBytes("gbk"), "iso-8859-1");
//              //获取资源路径
//              return ServletActionContext.getServletContext().getResourceAsStream("/filetemps/answerPaper.zip");
        }
        return null;
    }

    @Override
    public String execute() throws Exception {
    	System.out.println("teacher.....");
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
