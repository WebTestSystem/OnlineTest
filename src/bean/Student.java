package bean;

/*
 * 此实例对应学生
 */

public class Student {
	
	private int studentid;
	private String studentname;//学生姓名
	private String studentnumber;//学生学号
	private String studenttag;//考试标识
	private String status;
	private String ipAdress;//绑定IP
	private String uploadFileName;//学生上传答案的文件名
	private String uploadFileDate;//上传答案的时间
	
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentnumber() {
		return studentnumber;
	}
	public void setStudentnumber(String studentnumber) {
		this.studentnumber = studentnumber;
	}
	public String getStudenttag() {
		return studenttag;
	}
	public void setStudenttag(String studenttag) {
		this.studenttag = studenttag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return the ipAdress
	 */
	public String getIpAdress() {
		return ipAdress;
	}
	/**
	 * @param ipAdress the ipAdress to set
	 */
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
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
	/**
	 * @return the uploadFileDate
	 */
	public String getUploadFileDate() {
		return uploadFileDate;
	}
	/**
	 * @param uploadFileDate the uploadFileDate to set
	 */
	public void setUploadFileDate(String uploadFileDate) {
		this.uploadFileDate = uploadFileDate;
	}
	

}
