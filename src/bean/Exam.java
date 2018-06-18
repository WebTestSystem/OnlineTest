package bean;

/*
 * 此类的实例对应一次考试
 */

public class Exam {
	
	private int examid;
	private String examsubject;//考试科目
	private String examdata;//
	private String examnumber;
	private String status;
	private String examFileName;
	
	public int getExamid() {
		return examid;
	}
	public void setExamid(int examid) {
		this.examid = examid;
	}
	public String getExamsubject() {
		return examsubject;
	}
	public void setExamsubject(String examsubject) {
		this.examsubject = examsubject;
	}
	public String getExamdata() {
		return examdata;
	}
	public void setExamdata(String examdata) {
		this.examdata = examdata;
	}
	public String getExamnumber() {
		return examnumber;
	}
	public void setExamnumber(String examnumber) {
		this.examnumber = examnumber;
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
