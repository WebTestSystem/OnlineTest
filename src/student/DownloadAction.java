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
            this.fileName="��ɽ1.zip";
            this.fileName=new String(this.fileName.getBytes("gbk"), "iso-8859-1");
            //��ȡ��Դ·��
            return ServletActionContext.getServletContext().getResourceAsStream("/upload/examinationPaper/��ɽ1.zip");
        }
        else if(2==number){
//            this.fileName="jd2chmԴ������chm��ʽ�ĵ�.rar" ;  
//            //�������
//            this.fileName=new String(this.fileName.getBytes("gbk"), "iso-8859-1");
//            return ServletActionContext.getServletContext().getResourceAsStream("upload/jd2chmԴ������chm��ʽ�ĵ�.rar");
        }
        return null;
    }

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

	
//	//�û������ļ���
//	private String fileName;
//	//������Դ·����Stucts�����ã�
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
//		//��ֹ�û����󲻰�ȫ��Դ
//		if(!downloadFile.startsWith(downloadDir)) {
//			return null;
//		}
//		return "download_success";
//	}
//	
//	/*
//	 * ��ȡ��������Դ
//	 */
//	public InputStream getInputStream() throws Exception{
//		String path = inputPath+File.separatorChar+new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
//		return ServletActionContext.getServletContext().getResourceAsStream(path);
//	}
//	
//	/*
//	 * ��ȡ����ʱ�ļ�Ĭ�ϵ��ļ���
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
