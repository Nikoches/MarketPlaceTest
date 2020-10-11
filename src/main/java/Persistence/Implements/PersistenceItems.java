package Persistence.Implements;

import Models.Auto.Car;
import Models.Items.Item;
import Persistence.ItemsStore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Function;

public class PersistenceItems implements ItemsStore {
    private final static SessionFactory factory = HibernateUtils.getSessionFactory();
    private <T> T makeQuery(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            System.out.println(tx.getStatus());
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }
    public boolean add(Item item) {
        return false;
    }

    public boolean update(Item item, String id) {
        return false;
    }

    public boolean delete(String id) {
        return false;
    }

    public List<Item> findlAll() {
        return null;
    }

    public Item findById(String id) {
        return null;
    }

    public void removeAll() {

    }

    public Car getCarOfItem(Item item) {
        return null;
    }
}
