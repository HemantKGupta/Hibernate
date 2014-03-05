package roseindia.tutorial.hibernate;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
/**
 * @author Deepak Kumar
 * 
 * http://www.roseindia.net HQL Group by Clause Example
 *  
 */
public class HQLGroupByExample6 {
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
		      ins2.setInsuranceName("Jivan Sukh");
		      ins2.setInvestementAmount(2500000);
		      ins2.setInvestementDate(new Date());
		      
		      Insurance ins3 = new Insurance();
		      ins3.setInsuranceName("Jivan SukhA");
		      ins3.setInvestementAmount(5000000);
		      ins3.setInvestementDate(new Date());
		      
		      Insurance ins4 = new Insurance();
		      ins4.setInsuranceName("Jivan SukhA");
		      ins4.setInvestementAmount(10000);
		      ins4.setInvestementDate(new Date());
		      
		      Insurance ins5 = new Insurance();
		      ins5.setInsuranceName("Jivan SukhA");
		      ins5.setInvestementAmount(100000);
		      ins5.setInvestementDate(new Date());
		      
		      Insurance ins6 = new Insurance();
		      ins6.setInsuranceName("Jivan SukhB");
		      ins6.setInvestementAmount(200000000);
		      ins6.setInvestementDate(new Date());
		      
		      Transaction tr = session.beginTransaction();
		      session.save(ins1);
		      session.save(ins2);
		      session.save(ins3);
		      session.save(ins4);
		      session.save(ins5);
		      session.save(ins6);
		      tr.commit();
		      
			//Group By Clause Example
			String SQL_QUERY = "select sum(insurance.investementAmount),insurance.insuranceName "
					+ "from Insurance insurance group by insurance.insuranceName";
			Query query = session.createQuery(SQL_QUERY);
			for (Iterator it = query.iterate(); it.hasNext();) {
				Object[] row = (Object[]) it.next();
				System.out.print("Invested Amount: " + row[0]+ "  ");
				System.out.println("  Insurance Name: " + row[1]);
			}
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		}
	}
}
