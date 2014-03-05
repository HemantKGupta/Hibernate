package hello;
import org.hibernate.*;
import org.hibernate.cfg.*;
import test.animals.Dog;
public class HibernateUtil {
	
	public static void main(String[] args)throws Exception {
		Session session = null;
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
    	System.out.println("Transaction started");
    	Dog d = new Dog();
    	d.setName("bulldog");
    	session.save(d);
    	t.commit();
    	System.out.println("Transaction committed");
    	session.close();
	}
	
}