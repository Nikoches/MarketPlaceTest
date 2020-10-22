package persistence.implementation;

import models.auto.Car;
import models.items.Item;
import models.users.User;
import persistence.ItemsStore;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersistenceItems implements ItemsStore {


    public List<Item> findlAll() {
        Session session = SESSION_FACTORY.openSession();
        Transaction tx = session.beginTransaction();
        return session.createQuery("from models.items.Item ").list();
    }

    public void removeAll() {
        Session session = SESSION_FACTORY.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from models.items.Item ").executeUpdate();
        tx.commit();
    }

    @Override
    public Car getCarOfItem(String id) {
        return null;
    }

    @Override
    public Car getCarOfItem(Item item) {
        return null;
    }

    @Override
    public User getUserOfItem(User user) {
        return null;
    }

    @Override
    public User getUserOfItem(String id) {
        return null;
    }
}
