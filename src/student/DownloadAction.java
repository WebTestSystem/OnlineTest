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
        	//��ȡstudenttag��
    		HttpSession msession = ServletActionContext.getRequest().getSession();
    		String examnumber= msession.getAttribute("examnumber").toString();
    		System.out.println("examnumber At DownloadAction:"+examnumber);
        	
        	//��ȡexamfilename
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
          //��ȡ��Դ·��
          return ServletActionContext.getServletContext().getResourceAsStream(path);
        }
        else if(2==number){
//            this.fileName="jd2chmԴ������chm��ʽ�ĵ�.rar" ;  
//            //�������
//            this.fileName=new String(this.fileName.getBytes("gbk"), "iso-8859-1");
//            return ServletActionContext.getServletContext().getResourceAsStream("upload/jd2chmԴ������chm��ʽ�ĵ�.rar");
        	
        	//�ȴ�������� 
        	HttpServletRequest request = ServletActionContext.getRequest(); 
        	String sourceFilePath = request.getSession().getServletContext().getRealPath("/")+"/upload/answerPaper"; 
            String zipFilePath = request.getSession().getServletContext().getRealPath("/")+"/filetemps";  
            String fileName = "answerPaper";  
            System.out.println(sourceFilePath+"class");
            System.out.println(zipFilePath);
            boolean flag = ZipTool.fileToZip(sourceFilePath, zipFilePath, fileName);  
            if(flag){  
                System.out.println("�ļ�����ɹ�!");  
            }else{  
                System.out.println("�ļ����ʧ��!");  
            }  
            this.fileName="answerPaper.zip";
            this.fileName=new String(this.fileName.getBytes("gbk"), "iso-8859-1");
            //��ȡ��Դ·��
            return ServletActionContext.getServletContext().getResourceAsStream("/filetemps/answerPaper.zip");
        }
        return null;
    }

    @Override
    public String execute() throws Exception {
    	System.out.println("Student.....");
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
