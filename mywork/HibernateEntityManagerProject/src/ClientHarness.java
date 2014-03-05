import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;


public class ClientHarness {

public static void main(String[] args) {
//Use the persistence.xml
EntityManagerFactory emf = Persistence.createEntityManagerFactory("think");
EntityManager em = emf.createEntityManager();

//
EntityTransaction tx = em.getTransaction();
tx.begin();

//Create and initialize an entity instance
BroadcastMessage mb = new BroadcastMessage();
mb.setId(1);
mb.setMessage("Hello World");

//Persist using the entity manager
em.persist(mb);

//Save
tx.commit();

em.close();
emf.close();

}
}
