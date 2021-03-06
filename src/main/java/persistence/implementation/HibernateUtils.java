package persistence.implementation;

import models.auto.Body;
import models.auto.Brand;
import models.auto.Car;
import models.auto.Engine;
import models.items.Item;
import models.users.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.id.IdentifierGenerationException;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    private HibernateUtils() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Brand.class);
                configuration.addAnnotatedClass(Body.class);
                configuration.addAnnotatedClass(Car.class);
                configuration.addAnnotatedClass(Engine.class);
                configuration.addAnnotatedClass(Item.class);
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (IdentifierGenerationException ex) {
                ex.getCause();
                ex.getMessage();
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
