package SystemTest;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import bean.Exam;
import bean.Student;
import bean.Teacher;
import tool.ORMTool;

/*
 * ֻ���ڲ���ĳЩ�������
 */

public class TestSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Teacher teacher = new Teacher();
		teacher.seteId("20190302");
		teacher.setName("��ǿ");
		teacher.setNumber("0015720105");
		
		Student student = new Student();
		student.seteId("20190302");
		student.setName("����");
		student.setNumber("1500100");
		
		Exam exam = new Exam();
		//exam.setAmount(10);
		exam.seteTeacher("��ǿ");
		exam.setmClass("2015");
		exam.setNumber("20190302");
		exam.setSubject("English");*/
		
		/*
		 * �����ԣ������Ѿ�����
		 */
		//ORMTool ormtool = new ORMTool("exam",exam);
		//ormtool.insert();//success
		//ORMTool ormtool = new ORMTool("teacher",teacher);
		//ormtool.insert();//success
		//ORMTool ormtool = new ORMTool("student",student);
		//ormtool.insert();//success
		
		
		File file = new File("setting.xml");
		System.out.println("" + file.getAbsolutePath());
		
	}

}
