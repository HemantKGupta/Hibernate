
import java.sql.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test
{
    public static void main(String[] args) throws Exception
    {	Session session = null;
        try
        {
            // Initialise
        	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        	session = sessionFactory.openSession();
        	Transaction t = session.beginTransaction();
            System.out.println("MANY-TO-ONE Mapping Unidirectional ");

            // Many Foos associated with one Bar           
            Bar bar1 = new Bar();
            bar1.setId(1);
            
                    
            
            Foo foo1 = new Foo();
            foo1.setId(1);
            foo1.setBar(bar1);
            session.save(foo1);
            
            
            Foo foo2 = new Foo();
            foo2.setId(2);
            foo2.setBar(bar1);            
            session.save(foo2);
           
          
            t.commit();
            session.close();

            // Re-load ; We can get bar from foo (unidirectional)
            session = sessionFactory.openSession();
            t = session.beginTransaction();
            foo1 = (Foo)session.load(Foo.class, new Integer(1));
            System.out.println("Foo: " + foo1.getId() + ", " + foo1.getBar());
            
           // bar = (Bar)session.load(Bar.class, new Integer(1));
           // System.out.println("Bar: " + bar.getId());

           t.commit();
           session.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
    }
}
