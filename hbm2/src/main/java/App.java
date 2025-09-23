import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("db_config.xml").build();

        Metadata metadata = new MetadataSources(ssr).buildMetadata();

        SessionFactory sessionFactory = metadata.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        User user = new User();

        user.setName("Vinit");
        user.setUsername("vinit108");
        user.setPassword("vinit@123");

        transaction.begin();
        session.persist(user);
        transaction.commit();


    }
}
