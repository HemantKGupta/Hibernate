
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
        System.out.println("TOP-LEVEL MAPPING");

        // Foo
        Foo foo = new Foo();
        Set set = new HashSet();
        foo.setId(1);
        set.add("John");
        set.add("Brian");
        set.add("Paula");
        set.add("Murphy");
        foo.setNames(set);
        session.save(foo);
        t.commit();
        session.close();

        // Re-load
        session = sessionFactory.openSession();
        t = session.beginTransaction();
        foo = (Foo)session.load(Foo.class, new Integer(1));
        System.out.println("Foo: " + foo.getId() + ", " + foo.getNames());

        t.commit();
        session.close();
    }
}
