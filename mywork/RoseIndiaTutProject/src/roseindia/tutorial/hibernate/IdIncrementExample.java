/**
 * @author Deepak Kumar
 *
 * http://www.roseindia.net
 * Example to show the increment class of hibernate generator element to 
 * automatically generate the primay key
 */
package roseindia.tutorial.hibernate;

//Hibernate Imports
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class IdIncrementExample {
	public static void main(String[] args) {
		Session session = null;

		try{
			// This step will read hibernate.cfg.xml and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session =sessionFactory.openSession();
			 
			org.hibernate.Transaction tx = session.beginTransaction();
			System.out.println("Inserting Book object into database..");
			Book book = new Book();
			book.setStrBookName("Hibernate Tutorial");
			session.save(book);
			System.out.println("Book object persisted to the database.");
	        tx.commit();
	        session.flush();
	        session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			}
		
	}
}
