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

import Entity.Company;

public class CompanyDao {
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("config/hibernate.cfg.xml")
			.build();
	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

	SessionFactory factory = meta.getSessionFactoryBuilder().build();
	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	List<Company> companies = null;
	
	public List<Company> getAll(){
		
		try {
			Query<Company> query = session.createQuery("FROM Company");
			companies = query.list();
			return companies;
		} catch (Exception e) {
			System.out.println("Þirketler veritabanýndan çekilemedi : " + e.toString());
			return companies;
		}
	}
	
	public boolean add(Company company) {
		Company c = new Company();
		c.setCompanyCode(company.getCompanyCode());
		c.setCompanyTitle(company.getCompanyTitle());

		try {
			session.save(c);
			t.commit();
			factory.close();
			session.close();
			c = null;
			return true;

		} catch (Exception e) {
			System.out.println("Þirket kaydetmede hata : " + e.toString());
			return false;
		}
	}
	
	public boolean delete(Company company) {
		try {
			session.delete(company);
			t.commit();
			factory.close();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Þirket silme baþarýsýz." + e.toString());
			return false;
		}
	}
	
	public boolean update(Company company) {
		try {
			session.update(company);
			t.commit();
			factory.close();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Þirket güncelleme baþarýsýz." + e.toString());
			return false;
		}
	}
	
}
