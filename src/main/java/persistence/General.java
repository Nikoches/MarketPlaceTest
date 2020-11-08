package persistence;

import persistence.implementation.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Function;

public interface General<E> {

    SessionFactory SESSION_FACTORY = HibernateUtils.getSessionFactory();
    default E makeQuery(final Function<Session, E> command) {
        final Session session = SESSION_FACTORY.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            E rsl = command.apply(session);
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

    default E add(E part) {
        return this.makeQuery(session -> {
            session.save(part);
            return part;
        });
    }

    default E update(E part, String id) {
        return this.makeQuery(session -> {
            session.update(part);
            return part;
        });
    }

    default E remove(E part) {
        return this.makeQuery(session -> {
            session.remove(part);
            return part;
        });
    }

    default List<E> findlAll(E type) {
        Session session = SESSION_FACTORY.openSession();
        Transaction tx = session.beginTransaction();
        return session.createQuery("from " + type.getClass().getCanonicalName()).list();
    }


    default void removeAll(E type) {
        Session session = SESSION_FACTORY.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from " + type.getClass().getCanonicalName()).executeUpdate();
        tx.commit();
    }

    default E findById(Integer id, Class<E> cl) {
        return this.makeQuery(session -> session.get(cl, id));
    }
}
