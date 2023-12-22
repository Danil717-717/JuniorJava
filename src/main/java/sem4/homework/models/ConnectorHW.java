package sem4.homework.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConnectorHW {
    final StandardServiceRegistry registry;
    final SessionFactory sessionFactory;

    public ConnectorHW() {
        registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();

    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
