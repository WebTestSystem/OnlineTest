package teacher;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import AES.AESUtils;
import SystemTest.TempClass;
import bean.Student;
import tool.ExcelReadTool;
import tool.ORMTool;

//上传Excel表，成功后写入student表
public class UploadExcelAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String studenttag;
	
	public String getStudenttag() {
		return studenttag;
	}
	public void setStudenttag(String studenttag) {
		this.studenttag = studenttag;
	}
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
		String realpath=ServletActionContext.getServletContext().getRealPath("/upload/excel");
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
		
		//获取当前examnumber并读取Excel表写入数据库
		String examnumber=TempClass.temp;
		System.out.println("examnumber in Excel Action:"+examnumber);
		//excel操作
		File file = new File(realpath+"/"+uploadFileName);
		ExcelReadTool er = new ExcelReadTool();
		List<Student> list = er.readExcel(file,examnumber);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getStudentname()+"....."+list.get(i).getStudentnumber());
			//写入数据库
				System.out.println("开始写入数据库");
			//先将明文加密
			String key="666";
			String en_studentname=AESUtils.encrypt(key, list.get(i).getStudentname());
			String en_studentnumber=AESUtils.encrypt(key, list.get(i).getStudentnumber());
			list.get(i).setStudentname(en_studentname);
			list.get(i).setStudentnumber(en_studentnumber);
			//list.get(i).setStudenttag(examnumber);
//			//查一下该学生是否已存在数据库
//			ORMTool ormtoolstudent = new ORMTool();
//	        ormtoolstudent.initSession();
//			String hqlstudent = "select s.studentnumber,s.studenttag from Student as s where s.studentname=?";
//			Query querystudent = ormtoolstudent.getQuery(hqlstudent);
//			querystudent.setString(0, "" + en_studentname);
//			List<Object[]> list0 = querystudent.list();
//			//不存在数据库
//			if(list0.size()==0)
//			{
//				ORMTool ormtool = new ORMTool("student",list.get(i));
//				ormtool.insert();
//		    }
//			else//存在数据库时
//			{  for(Object[] obj0 : list0)
//			   {
//				//20150220180505060534#03
//				    String studenttag=obj0[1].toString();
//				    if(studenttag.substring(0,20).equals(this.studenttag.substring(0, 20)))
//				    {
//				    	ORMTool ormtool = new ORMTool();
//						ormtool.initSession();
//						String hql = "delete Student s where s.studentnumber = :oldId";
//						int deleteEnnity = ormtool.getSession().createQuery(hql)
//								.setString("oldId", en_studentnumber)
//								.executeUpdate();
//						ormtool.getTranscation().commit();
//						ormtool.closeSession();
//									
//
//						for(Object[] obj : list0) {
//							String studenttag2=obj[1]+","+examnumber;
//							
//							System.out.println("ee "+studenttag2);				
//							list.get(i).setStudenttag(studenttag2);
//							ORMTool ormtool2= new ORMTool("student",list.get(i));
//							ormtool2.insert();
//							System.out.println("ok!!!!  "+studenttag);			
//						}
//				    	
//				    }
//				    else
//				    {
//						ORMTool ormtool = new ORMTool("student",list.get(i));
//						ormtool.insert();
//				    }
//			   }
//				
//				
//				
//			}
			
			ORMTool ormtool = new ORMTool("student",list.get(i));
			ormtool.insert();
			
			}
		System.out.println("读取Excel");
		
		
		
//		//获取当前上传时间并写入数据库
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
//		String date =df.format(System.currentTimeMillis());
//		System.out.println(date); 
//		
//		HttpSession msession = ServletActionContext.getRequest().getSession();
//		String TeaName=(String) msession.getAttribute("enusername");
//		System.out.println(TeaName);
//		
//		//更新老师表中的uploadFileName,uploadFileDate
//		ORMTool ormtool1 = new ORMTool();
//		ormtool1.initSession();
//		String hql1 = "update Teacher t set t.uploadFileName=?,t.uploadFileDate=? where t.teachername=?";
//		int updateEntities = ormtool1.getSession().createQuery(hql1)
//				.setString(0, this.uploadFileName).setString(1, date).setString(2, TeaName)
//				.executeUpdate();
//		ormtool1.getSession().getTransaction().commit();
//		//ormtool1.getSession().close();
//		System.out.println(updateEntities);
//		
//		//获取examnumber
//		//HttpSession session = ServletActionContext.getRequest().getSession();
//		//String examnumber = (String) session.getAttribute("thisexamnumber");
//		String examnumber = TempClass.temp;
//		System.out.println(examnumber+"哈哈哈");
//		
//		//更新Exam表中的ExamFileName
//		ORMTool ormtool2 = new ORMTool();
//		ormtool2.initSession();
//		String hql2 = "update Exam e set e.examFileName=? where e.examnumber=?";
//		int updateEntities2 = ormtool2.getSession().createQuery(hql2)
//				.setString(0, this.uploadFileName).setString(1, examnumber)
//				.executeUpdate();
//		ormtool2.getSession().getTransaction().commit();
//		ormtool2.getSession().close();
//		System.out.println(updateEntities2+"hh");
//		
		act.put("message", "上传成功！");
		return INPUT;
	}
}
