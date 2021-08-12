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

import Entity.Section;

public class SectionDao {
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("config/hibernate.cfg.xml").build();
	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

	SessionFactory factory = meta.getSessionFactoryBuilder().build();
	Session session = factory.openSession();
	Transaction t = session.beginTransaction();

	List<Section> sections = null;

	public List<Section> getAll(int companyId) {

		try {
			String hql = "FROM Section S WHERE S.companyId = " + companyId;
			//String hql = "FROM Section";
			Query<Section> query = session.createQuery(hql);
			sections = query.list();
			
			return sections;
		} catch (Exception e) {
			System.out.println("B�l�mler veritaban�ndan �ekilemedi : " + e.toString());
			return sections;
		}

	}
	
	public boolean add(Section section) {
		try {
			session.save(section);
			t.commit();
			factory.close();
			session.close();
			section=null;
			return true;

		} catch (Exception e) {
			System.out.println("B�l�m kaydetmede hata : " + e.toString());
			return false;
		}
	}
	
	public boolean delete(Section section) {
		try {
			session.delete(section);
			t.commit();
			System.out.println("B�l�m silme ba�ar�l�.");
			factory.close();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("B�l�m silme ba�ar�s�z." + e.toString());
			return false;
		}
	}
	
	public boolean update(Section section) {
		try {
			session.update(section);
			t.commit();
			System.out.println("B�l�m g�ncelleme ba�ar�l�.");
			factory.close();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("B�l�m g�ncelleme ba�ar�s�z." + e.toString());
			return false;
		}
	}

}
