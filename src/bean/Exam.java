package bean;

/*
 * �����ʵ����Ӧһ�ο���
 */

public class Exam {
	
	private int id;
	private String subject;//���Կ�Ŀ
	private String mClass;//���԰༶
	private String eTeacher;//���Ը�����ʦ
	private String data;//
	private String number;
	private String status;
	private String examFileName;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getmClass() {
		return mClass;
	}
	public void setmClass(String mClass) {
		this.mClass = mClass;
	}
	public String geteTeacher() {
		return eTeacher;
	}
	public void seteTeacher(String eTeacher) {
		this.eTeacher = eTeacher;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the examFileName
	 */
	public String getExamFileName() {
		return examFileName;
	}
	/**
	 * @param examFileName the examFileName to set
	 */
	public void setExamFileName(String examFileName) {
		this.examFileName = examFileName;
	}
	
	

}
