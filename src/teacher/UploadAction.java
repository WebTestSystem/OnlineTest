package teacher;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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
			
			//���������ļ�
			File saveFile = new File(file, uploadFileName);
			//ʹ��commons-io��FileUtils�ϴ��ļ�
			try {
				FileUtils.copyFile(upload, saveFile);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("�ļ��ϴ�����");
				act.put("message", "�ϴ�ʧ��");
				return ERROR;
			}
		}
		
		//��ȡ��ǰ�ϴ�ʱ�䲢д�����ݿ�
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		String date =df.format(System.currentTimeMillis());
		System.out.println(date); 
		
		HttpSession msession = ServletActionContext.getRequest().getSession();
		String TeaName=(String) msession.getAttribute("username");
		System.out.println(TeaName);
		
		//������ʦ���е�uploadFileName,uploadFileDate
		ORMTool ormtool1 = new ORMTool();
		ormtool1.initSession();
		String hql1 = "update Teacher t set t.uploadFileName=?,t.uploadFileDate=? where t.name=?";
		int updateEntities = ormtool1.getSession().createQuery(hql1)
				.setString(0, this.uploadFileName).setString(1, date).setString(2, TeaName)
				.executeUpdate();
		ormtool1.getSession().getTransaction().commit();
		ormtool1.getSession().close();
		System.out.println(updateEntities);
		
		//����Exam���е�ExamFileName  where�� teacherName����teacharId ??????
		ORMTool ormtool2 = new ORMTool();
		ormtool2.initSession();
		String hql2 = "update Exam e set e.examFileName=? where t.name=?";
		int updateEntities2 = ormtool1.getSession().createQuery(hql2)
				.setString(0, this.uploadFileName).setString(1, date).setString(2, TeaName)
				.executeUpdate();
		ormtool2.getSession().getTransaction().commit();
		ormtool2.getSession().close();
		System.out.println(updateEntities2);
		/*
		 * �ⲿ�ֻ�δ���
		 */
		
		act.put("message", "�ϴ��ɹ���");
		return SUCCESS;
	}
	
//	private File uploadImage; //�õ��ϴ����ļ�
//    private String uploadImageContentType; //�õ��ļ�������
//    private String uploadImageFileName; //�õ��ļ�������
//    
//    public String execute(){
//        System.out.println("fileName:"+this.getUploadImageFileName());
//        System.out.println("contentType:"+this.getUploadImageContentType());
//        System.out.println("File:"+this.getUploadImage());
//        
//        //��ȡҪ�����ļ��е�����·��(����·��)
//        String realPath=ServletActionContext.getServletContext().getRealPath("/upload");
//        File file = new File(realPath);
//        
//        //���Դ˳���·������ʾ���ļ���Ŀ¼�Ƿ���ڡ��������ڣ������˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼��
//        if(!file.exists())file.mkdirs();
//        
//        try {
//            //�����ļ�
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
	
}