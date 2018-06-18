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
	
	private int backgroudtime;//后台任务最后间隔时间
	private int recordamount;//每页的最大记录数
	private int filemaxsize;//文件上传的最大限制
	
	
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
		System.out.println("测试数据" + this.backgroudtime + "," +  this.filemaxsize + " " + this.recordamount);
		/*
		 * 使用DOM生成XML文档的大致步骤: 1:创建一个Document对象表示一个空文档 2:向Document中添加根元素
		 * 3:按照文档应有的结构从根元素开始顺序添加 子元素来形成该文档结构。 4:创建XmlWriter对象 5:将Document对象写出
		 * 若写入到文件中则形成一个xml文件 也可以写出到网络中作为传输数据使用
		 */

		// 1
		Document doc = DocumentHelper.createDocument();

		/*
		 * 2 Document提供了添加根元素的方法: Element addElement(String name) 向当前文档中添加指定名字的根元素，返回
		 * 的Element就表示这个根元素。 需要注意，该方法只能调用一次，因为一个 文档只能有一个根元素。
		 */
		Element root = doc.addElement("systemsetting");

		// 添加name信息
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
					System.out.println("创建文件成功");
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
			 * 通过获取类的加载路径找到文件
			 */
			//System.out.println(SettingAction.class.getClassLoader().getResource("").getPath());
			FileOutputStream fos = new FileOutputStream(PathTool.getFile("data/setting.xml"));
			writer.setOutputStream(fos);

			// 5
			writer.write(doc);
			System.out.println("写出完毕!");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
}