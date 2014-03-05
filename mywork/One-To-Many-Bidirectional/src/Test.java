import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Test
{
    public static void main(String[] args) throws Exception
    {	   Session session = null;
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
      session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        System.out.println("ONE-TO-MANY Mapping Bidirectional");

        // One Foo has many Bar(s)in set        
        Foo foo = new Foo();
        foo.setId(1);
        
        Set set = new HashSet();
        
        Bar bar1 = new Bar();
        bar1.setId(1);
        bar1.setFoo(foo);
        set.add(bar1);
        foo.setBars(set);
        
        
        session.save(foo);
        t.commit();
        session.close();

        // Re-load
        session = sessionFactory.openSession();
        t = session.beginTransaction();
        foo = (Foo)session.load(Foo.class, new Integer(1));
        System.out.println("Foo: " + foo.getId() + ", " + foo.getBars());

        t.commit();
        session.close();
    }
}
