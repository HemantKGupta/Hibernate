
package roseindia.tutorial.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.*;

import java.util.*;

/**
 * @author Deepak Kumar
 *
 * http://www.roseindia.net
 * HQL Select Clause Example
 */
public class SelectClauseProjection2 {
	public static void main(String[] args) {
		Session session = null;

		try{
			// This step will read hibernate.cfg.xml and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session =sessionFactory.openSession();
			//Create data

			Insurance ins1 = new Insurance();
			ins1.setInsuranceName("Jivan Sukh");
			ins1.setInvestementAmount(5000000);
			ins1.setInvestementDate(new Date());

			Transaction tr = session.beginTransaction();
			session.save(ins1);

			tr.commit();
			//Create Select Clause HQL
			String SQL_QUERY ="Select insurance.lngInsuranceId,insurance.insuranceName," + 
			"insurance.investementAmount,insurance.investementDate from Insurance insurance";
			Query query = session.createQuery(SQL_QUERY);
			for(Iterator it=query.iterate();it.hasNext();){
				Object[] row = (Object[]) it.next();
				System.out.println("ID: " + row[0]);
				System.out.println("Name: " + row[1]);
				System.out.println("Amount: " + row[2]);
				System.out.println("Date: " + row[3]);
			}

			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
		}
	}
}
