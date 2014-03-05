package roseindia.tutorial.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateExample {
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Session sess = null;
    try {
      SessionFactory fact = new Configuration()
.configure().buildSessionFactory();
      sess = fact.openSession();
      Transaction tr = sess.beginTransaction();
      Insurance ins1 = new Insurance();
      ins1.setInsuranceName("Jivan anand");
      ins1.setInvestementAmount(10000000);
      ins1.setInvestementDate(new Date());
      sess.save(ins1);
      tr.commit();
      System.out.println("Created successfully!");
      
      Transaction tr1 = sess.beginTransaction();
      Insurance ins = (Insurance)sess.get
(Insurance.class, new Long(1));
      ins.setInsuranceName("Jivan Dhara");
      ins.setInvestementAmount(20000);
      ins.setInvestementDate(new Date());
      sess.update(ins);
      tr1.commit();
      System.out.println("Update successfully!");
      
      sess.close();
      
     
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
} 