package bean;


/*
 * 此实例对应一个来时
 */
public class Teacher {
	
	private int teacherid;
	private String teachernumber;//老师编号号
	private String teacherpassword;//老师的密码，若输入未输入，默认为其编号
	private String teachername;//老师名字
	private String isadmin = "否";
	private String status = "离线";
	private String uploadFileName;
	private String uploadFileDate;
	
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeachernumber() {
		return teachernumber;
	}
	public void setTeachernumber(String teachernumber) {
		this.teachernumber = teachernumber;
	}
	public String getTeacherpassword() {
		return teacherpassword;
	}
	public void setTeacherpassword(String teacherpassword) {
		this.teacherpassword = teacherpassword;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
