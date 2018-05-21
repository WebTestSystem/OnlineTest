package tool;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import bean.Exam;
import bean.Student;
import bean.Teacher;

public class ORMTool {
	
	private String TableName;
	private Object object;
	private String tag;
	private Session session;
	private Transaction trasaction;
	
	/*
	 * 构造函数来确定操作的是哪个表，同时传入要更改的对象
	 */
	public ORMTool()
	{
		
	}
	public ORMTool(String TableName,Object object)//次构造函数用于插入新数据，例如“注册”
	{
		this.TableName = TableName;
		this.object = object;
	}
	
	
	/*
	 * 初始化session
	 */
	public void  initSession()
	{
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		this.session = sessionFactory.openSession();
		trasaction = session.beginTransaction();
	}
	
	/*
	 * 关闭对话
	 */
	public void closeSession()
	{
		session.close();
	}
	
	/*
	 * 根据hql语句获取对话的query对象
	 */
	public Query getQuery(String hql)
	{
		return session.createQuery(hql);
	}
	
	public Session getSession()
	{
		return session;
	}
	
	public Transaction getTranscation()
	{
		return this.trasaction;
	}
	/*
	 * 向表中插入数据
	 */
	public void insert()
	{
		this.initSession();
		switch(this.TableName)
		{
			case "student":
				Student student = new Student();
				student = (Student)this.object;
				session.save(student);
				session.getTransaction().commit();
				break;
			case "teacher":
				Teacher teacher = new Teacher();
				teacher = (Teacher)this.object;
				session.save(teacher);
				session.getTransaction().commit();
				break;
			case "exam":
				Exam exam = new Exam();
				exam = (Exam)this.object;
				session.save(exam);
				session.getTransaction().commit();
				break;
		}
	}
	
	/*
	 * 更新数据表
	
	public int update(String hql)
	{
		this.initSession();
		Query query = session.createQuery(hql);
		int updateEntities = query.executeUpdate();
		session.getTransaction().commit();
		return updateEntities;
	}
	 */
	
	
	
	/*
	 * 向表中删除数据
	 */
	public void delete()
	{
		this.initSession();
		switch(this.TableName)
		{
			case "student":
				Student student = new Student();
				student = (Student)this.object;
				session.delete(student);
				session.getTransaction().commit();
				break;
			case "teacher":
				Teacher teacher = new Teacher();
				teacher = (Teacher)this.object;
				session.delete(teacher);
				session.getTransaction().commit();
				break;
			case "exam":
				Exam exam = new Exam();
				exam = (Exam)this.object;
				session.delete(exam);
				session.getTransaction().commit();
				break;
		}
	}
	
	/*
	 * 向对应表查询数据
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> query(String hql)
	{
		Query query = session.createQuery(hql);
		return query.list();
	}
}
