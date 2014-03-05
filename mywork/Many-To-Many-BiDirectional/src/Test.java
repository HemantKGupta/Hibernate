
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        // Initialise
    	Session session = null;
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    	session = sessionFactory.openSession();
    	Transaction t = session.beginTransaction();
        System.out.println("MANY-TO-MANY Mapping BiDirectional");

        // Foos to Bars unidirectional 
        Set barset = new HashSet();
        Set fooset = new HashSet();
        
        Bar bar1 = new Bar();
        bar1.setId(1);
        Bar bar2 = new Bar();
        bar2.setId(2);
        
        barset.add(bar1);
        barset.add(bar2);
        
        Foo foo1 = new Foo();
        foo1.setId(1);
        foo1.setBars(barset);
        Foo foo2 = new Foo();
        foo2.setId(2);
        foo2.setBars(barset);
        
         
        
        
        session.save(foo1);
        session.save(foo2);
        
       // session.save(bar1);
       // session.save(bar2);
        
        t.commit();
        session.close();

        // Re-load
        session = sessionFactory.openSession();
        t = session.beginTransaction();
        foo2 = (Foo)session.load(Foo.class, new Integer(2));
        System.out.println("Foo: " + foo2.getId() + ", " + foo2.getBars());


        t.commit();
        session.close();
    }
}
