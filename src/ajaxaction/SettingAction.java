package ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import bean.Exam;
import tool.ORMTool;
import tool.PathTool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class SettingAction extends ActionSupport{
	
	private int backgroudtime;//��̨���������ʱ��
	private int recordamount;//ÿҳ������¼��
	private int filemaxsize;//�ļ��ϴ����������
	
	
	public int getBackgroudtime() {
		return backgroudtime;
	}
	public void setBackgroudtime(int backgroudtime) {
		this.backgroudtime = backgroudtime;
	}

	public int getRecordamount() {
		return recordamount;
	}
	public void setRecordamount(int recordamount) {
		this.recordamount = recordamount;
	}

	public int getFilemaxsize() {
		return filemaxsize;
	}
	public void setFilemaxsize(int filemaxsize) {
		this.filemaxsize = filemaxsize;
	}


	public String execute()
	{
		System.out.println("��������" + this.backgroudtime + "," +  this.filemaxsize + " " + this.recordamount);
		/*
		 * ʹ��DOM����XML�ĵ��Ĵ��²���: 1:����һ��Document�����ʾһ�����ĵ� 2:��Document����Ӹ�Ԫ��
		 * 3:�����ĵ�Ӧ�еĽṹ�Ӹ�Ԫ�ؿ�ʼ˳����� ��Ԫ�����γɸ��ĵ��ṹ�� 4:����XmlWriter���� 5:��Document����д��
		 * ��д�뵽�ļ������γ�һ��xml�ļ� Ҳ����д������������Ϊ��������ʹ��
		 */

		// 1
		Document doc = DocumentHelper.createDocument();

		/*
		 * 2 Document�ṩ����Ӹ�Ԫ�صķ���: Element addElement(String name) ��ǰ�ĵ������ָ�����ֵĸ�Ԫ�أ�����
		 * ��Element�ͱ�ʾ�����Ԫ�ء� ��Ҫע�⣬�÷���ֻ�ܵ���һ�Σ���Ϊһ�� �ĵ�ֻ����һ����Ԫ�ء�
		 */
		Element root = doc.addElement("systemsetting");

		// ���name��Ϣ
		Element backgroudtime = root.addElement("backgroudtime");
		backgroudtime.addText(backgroudtime.toString());

		Element recordamount = root.addElement("recordamount");
		recordamount.addText(recordamount.toString());

		Element filemaxsize = root.addElement("filemaxsize");
		filemaxsize.addText(filemaxsize.toString());
		
		/*try {
			System.out.println(ServletActionContext.getServletContext().getResource("/").getPath());
			File file = new File( + "/WebContent/res/setting.xml");
			if(!file.exists())
			{
				boolean result = false;
				try {
					result = file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(result == true)
				{
					System.out.println("�����ļ��ɹ�");
				}
			}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		try {
			// 4
			XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
			//FileOutputStream fos = new FileOutputStream("resource" + File.separator +"setting.xml");
			/*
			 * ͨ����ȡ��ļ���·���ҵ��ļ�
			 */
			//System.out.println(SettingAction.class.getClassLoader().getResource("").getPath());
			FileOutputStream fos = new FileOutputStream(PathTool.getFile("setting.xml"));
			writer.setOutputStream(fos);

			// 5
			writer.write(doc);
			System.out.println("д�����!");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
}