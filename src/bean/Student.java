package bean;

/*
 * ��ʵ����Ӧѧ��
 */

public class Student {
	
	private int id;
	private String name;//ѧ������
	private String number;//ѧ��ѧ��
	private String eId;//���Ա�ʶ
	private String status;
	private String ipAdress;//��IP
	private String uploadFileName;//ѧ���ϴ��𰸵��ļ���
	private String uploadFileDate;//�ϴ��𰸵�ʱ��
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
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
