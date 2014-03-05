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
        System.out.println("ONE-TO-MANY Mapping Unidirectional");

        // One Foo has many Bar(s)in set
        Set set = new HashSet();
        
        Bar bar1 = new Bar();
        bar1.setId(1);
        session.save(bar1);
        set.add(bar1);
        
        Bar bar2 = new Bar();
        bar2.setId(2);
        session.save(bar2);
        set.add(bar2);

        Foo foo = new Foo();
        foo.setId(1);
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
