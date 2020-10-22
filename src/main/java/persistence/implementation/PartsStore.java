package persistence.implementation;

import persistence.General;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PartsStore<E> implements General<E> {
    @Override
    public List<E> findlAll() {
        Session session = SESSION_FACTORY.openSession();
        Transaction tx = session.beginTransaction();
        return session.createQuery("from models.auto.Car ").list();
    }

    @Override
    public void removeAll() {

    }
}
