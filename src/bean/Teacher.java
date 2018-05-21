package bean;


/*
 * 此实例对应一个来时
 */
public class Teacher {
	
	private int id;
	private String number;//老师证号
	private String name;//老师名字
	private String eId;//老师负责的考试
	private String isadmin = "否";
	private String status = "离线";
	private String uploadFileName;
	private String uploadFileDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
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
