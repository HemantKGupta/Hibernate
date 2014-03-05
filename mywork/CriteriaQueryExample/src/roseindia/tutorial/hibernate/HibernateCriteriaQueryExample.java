package roseindia.tutorial.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
/**
 * @author Deepak Kumar
 * 
 * http://www.roseindia.net Hibernate Criteria Query Example
 *  
 */public class HibernateCriteriaQueryExample {
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
		      
		      Transaction tr = session.beginTransaction();
		      session.save(ins1);
		      session.save(ins2);
		      
		      tr.commit();
			//Criteria Query Example
			Criteria crit = session.createCriteria(Insurance.class);
			List insurances = crit.list();
			for(Iterator it = insurances.iterator();it.hasNext();){
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
