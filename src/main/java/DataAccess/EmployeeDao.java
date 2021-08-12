package DataAccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import Entity.Employee;

public class EmployeeDao {
	
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("config/hibernate.cfg.xml")
			.build();
	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

	SessionFactory factory = meta.getSessionFactoryBuilder().build();
	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	
	List<Employee> employees = null;
	
	public List<Employee> getAll(int sectionId) {

		try {
			String hql = "FROM Employee E WHERE E.sectionId = " + sectionId;
			Query<Employee> query = session.createQuery(hql);
			employees = query.list();
			return employees;
		} catch (Exception e) {
			System.out.println("Çalýþanlar veritabanýndan getirilemedi : " + e.toString());
			return employees;
		}

	}
	
	public Boolean add(Employee employee) {
		try {
			session.save(employee);
			t.commit();
			factory.close();
			session.close();
			employee=null;
			return true;

		} catch (Exception e) {
			System.out.println("Çalýþan kaydetmede hata : " + e.toString());
			return false;
		}
	}
	
	public boolean delete(Employee employee) {
		try {
			session.delete(employee);
			t.commit();
			factory.close();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Çalýþan silme baþarýsýz." + e.toString());
			return false;
		}
	}
	
	public boolean update(Employee employee) {
		try {
			session.update(employee);
			t.commit();
			factory.close();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Çalýþan güncelleme baþarýsýz." + e.toString());
			return false;
		}
	}

}
