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
        System.out.println("COMPONENT MAPPING");

        // Foo
        Foo foo = new Foo();
        foo.setId(1);
        FooSecond second = new FooSecond();
        second.setFirstName("John");
        second.setLastName("Smith");
        foo.setSecond(second);
        session.save(foo);
        t.commit();
        session.close();

        // Re-load
        session = sessionFactory.openSession();
        t = session.beginTransaction();
        foo = (Foo)session.load(Foo.class, new Integer(1));
        System.out.println("Foo: " + foo.getId() + ", " + foo.getSecond().getFirstName() + ", "
                           + foo.getSecond().getLastName());

        t.commit();
        session.close();
    }
}
