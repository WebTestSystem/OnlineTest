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
	 * ���캯����ȷ�����������ĸ���ͬʱ����Ҫ���ĵĶ���
	 */
	public ORMTool()
	{
		
	}
	public ORMTool(String TableName,Object object)//�ι��캯�����ڲ��������ݣ����硰ע�ᡱ
	{
		this.TableName = TableName;
		this.object = object;
	}
	
	
	/*
	 * ��ʼ��session
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
	 * �رնԻ�
	 */
	public void closeSession()
	{
		session.close();
	}
	
	/*
	 * ����hql����ȡ�Ի���query����
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
	 * ����в�������
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
	 * �������ݱ�
	
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
	 * �����ɾ������
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
	 * ���Ӧ���ѯ����
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> query(String hql)
	{
		Query query = session.createQuery(hql);
		return query.list();
	}
}
