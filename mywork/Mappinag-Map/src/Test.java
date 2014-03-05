
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        try
        {
        	// Initialise
        	Session session = null;
        	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        	session = sessionFactory.openSession();
        	Transaction t = session.beginTransaction();
            System.out.println("MAP MAPPING");

            // Foo and Bar
            Foo foo = new Foo();
            foo.setId(1);
            Map map = new HashMap();
            map.put("Brian", "24");
            map.put("Paula", "51");
            map.put("John", "33");
            map.put("Murphy", "27");
            foo.setAges(map);
            session.save(foo);
            t.commit();
            session.close();

            // Re-load
            session = sessionFactory.openSession();
            t = session.beginTransaction();
            foo = (Foo)session.load(Foo.class, new Integer(1));
            System.out.println("Foo: " + foo.getId() + ", " + foo.getAges());

            t.commit();
            session.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
    }
}
