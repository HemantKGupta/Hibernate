package roseindia.tutorial.hibernate;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteHQLExample {
  /**
 * @author vinod Kumar
 * 
 * http://www.roseindia.net Hibernate
 Criteria Query Example
 *  
 */
  public static void main(String[] args) {
    // TODO Auto-generated method stub  
    Session sess = null;
    try {
      SessionFactory fact = new 
Configuration().configure().buildSessionFactory();
      sess = fact.openSession();
      
//      Transaction tr = sess.beginTransaction();
//      Insurance ins1 = new Insurance();
//      ins1.setInsuranceName("Jivan anand");
//      ins1.setInvestementAmount(10000000);
//      ins1.setInvestementDate(new Date());
//      sess.save(ins1);
//      tr.commit();
//      System.out.println("Created successfully!");
      
      String hql = "delete from Insurance insurance where id = 3";
      Query query = sess.createQuery(hql);
      int row = query.executeUpdate();
      if (row == 0){
        System.out.println("Doesn't deleted any row!");
      }
      else{
        System.out.println("Deleted Row: " + row);
      }
      sess.close();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
} 