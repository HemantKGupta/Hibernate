package roseindia.tutorial.hibernate;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
/**
 * @author Deepak Kumar
 * 
 * http://www.roseindia.net HQL Order by Clause Example
 *  
 */
public class HQLOrderByExample4 {
	public static void main(String[] args) {
		Session session = null;
		try {
			// This step will read hibernate.cfg.xml and prepare hibernate for
			// use
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			// create data	 
			 
		      Insurance ins1 = new Insurance();
		      ins1.setInsuranceName("Jivan Sukh");
		      ins1.setInvestementAmount(5000000);
		      ins1.setInvestementDate(new Date());
		      
		      Insurance ins2 = new Insurance();
		      ins2.setInsuranceName("Jivan SukhA");
		      ins2.setInvestementAmount(2500000);
		      ins2.setInvestementDate(new Date());
		      
		      Insurance ins3 = new Insurance();
		      ins3.setInsuranceName("Jivan SukhB");
		      ins3.setInvestementAmount(2000000);
		      ins3.setInvestementDate(new Date());
		      
		      Transaction tr = session.beginTransaction();
		      session.save(ins1);
		      session.save(ins2);
		      session.save(ins3);
		      tr.commit();
		      
			//Order By Example
			String SQL_QUERY = " from Insurance as insurance order by insurance.insuranceName";
			Query query = session.createQuery(SQL_QUERY);
			for (Iterator it = query.iterate(); it.hasNext();) {
				Insurance insurance = (Insurance) it.next();
				System.out.println("ID: " + insurance.getLngInsuranceId());
				System.out.println("Name: " + insurance.getInsuranceName());
			}
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		}
	}
}
