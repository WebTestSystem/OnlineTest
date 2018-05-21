package student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

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
            this.fileName="东山1.zip";
            this.fileName=new String(this.fileName.getBytes("gbk"), "iso-8859-1");
            //获取资源路径
            return ServletActionContext.getServletContext().getResourceAsStream("/upload/examinationPaper/东山1.zip");
        }
        else if(2==number){
//            this.fileName="jd2chm源码生成chm格式文档.rar" ;  
//            //解决乱码
//            this.fileName=new String(this.fileName.getBytes("gbk"), "iso-8859-1");
//            return ServletActionContext.getServletContext().getResourceAsStream("upload/jd2chm源码生成chm格式文档.rar");
        }
        return null;
    }

    @Override
    public String execute() throws Exception {

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
