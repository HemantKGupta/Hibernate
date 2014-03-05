
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
            System.out.println("ONE-TO-ONE Mapping Unidirectional");

            // Foo and Bar
            Foo foo = new Foo();
            foo.setId(1);
            
            
            Bar bar = new Bar();
            bar.setId(1);
            
            foo.setBar(bar);
            session.save(foo);
            
            bar.setFoo(foo);
            
            session.save(bar);
            t.commit();
          
            
            session.close();

            // Re-load ; We can get bar from foo (unidirectional)
            session = sessionFactory.openSession();
            t = session.beginTransaction();
            foo = (Foo)session.load(Foo.class, new Integer(1));
            System.out.println("Foo: " + foo.getId() + ", " + foo.getBar());
            
            bar = (Bar)session.load(Bar.class, new Integer(1));
            System.out.println("Bar: " + bar.getFoo());

            t.commit();
            session.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
    }
}
