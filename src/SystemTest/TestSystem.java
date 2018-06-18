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
 * 只用于测试某些类的作用
 */

public class TestSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Teacher teacher = new Teacher();
		teacher.seteId("20190302");
		teacher.setName("冯强");
		teacher.setNumber("0015720105");
		
		Student student = new Student();
		student.seteId("20190302");
		student.setName("李明");
		student.setNumber("1500100");
		
		Exam exam = new Exam();
		//exam.setAmount(10);
		exam.seteTeacher("冯强");
		exam.setmClass("2015");
		exam.setNumber("20190302");
		exam.setSubject("English");*/
		
		/*
		 * 经测试，插入已经可以
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
