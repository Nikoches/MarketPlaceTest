package Persistence.Implements;

import Models.Auto.Body;
import Models.Auto.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Function;

public class PersistenceCars<E>  {
    private final static SessionFactory factory = HibernateUtils.getSessionFactory();
    private <T> T tx(final Function<Session, T> command) {
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

    public E add(E car) {
        return this.tx(session -> {
            session.save(car);
            return car;
        });
    }

    public boolean update(Car car, String id) {
        return false;
    }

    public boolean delete(String id) {
        return false;
    }

    public List<Car> findlAll() {
        return null;
    }

    public Car findById(String id) {
        return null;
    }

    public void removeAll() {

    }

    public int getCounterId() {
        return 0;
    }
}
