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
            System.out.println("JOINED SUBCLASS");

            // Foo and Bar
            Foo foo = new Foo();
            foo.setId(1);
            foo.setName("John Smith");
            session.save(foo);
            Bar bar = new Bar();
            bar.setId(2);
            bar.setName("Joe Bloggs");
            bar.setAge("24");
            session.save(bar);
            t.commit();
            session.close();

            // Re-load
            session = sessionFactory.openSession();
            t = session.beginTransaction();
            foo = (Foo)session.load(Foo.class, new Integer(1));
            System.out.println("Foo: " + foo.getId() + ", " + foo.getName());
            bar = (Bar)session.load(Bar.class, new Integer(2));
            System.out.println("Bar: " + bar.getId() + ", " + bar.getName() + ", " + bar.getAge());

            t.commit();
            session.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
    }
}
