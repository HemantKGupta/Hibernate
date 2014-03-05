
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
            System.out.println("Coposite Id");

            Address addr = new Address();
            addr.setId(1);
            session.save(addr);

            Foo foo = new Foo();
            Person person = new Person();
            person.setName("Brian");
            person.setAddress(addr);
            foo.setId(person);
            foo.setAge("24");
            session.save(foo);
            t.commit();
            session.close();

            // Re-load
            session = sessionFactory.openSession();
            t = session.beginTransaction();
            foo = (Foo)session.load(Foo.class, person);
            System.out.println("Foo: " + foo.getId() + ", age = " + foo.getAge());

            t.commit();
            session.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
    }
}
