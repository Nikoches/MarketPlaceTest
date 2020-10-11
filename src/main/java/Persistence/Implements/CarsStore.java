package Persistence.Implements;

import Models.Auto.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Function;

public class CarsStore<E> implements Persistence.PartStore<E> {
    private final static SessionFactory factory = HibernateUtils.getSessionFactory();

    private E makeQuery(final Function<Session, E> command) {
        final Session session = factory.openSession();
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

    @Override
    public E add(E part) {
        return this.makeQuery(session -> {
            session.save(part);
            return part;
        });
    }

    public static void main(String[] args) {
                List<Car> cars = null;
        CarsStore<Car>  carCarsStore= new CarsStore<>();
        try {
            cars =  carCarsStore.findlAll();
            Car car = carCarsStore.findById(0,Car.class);
        }catch (Exception ex){
            ex.getMessage();
            ex.printStackTrace();
        }
        for (Car x:
             cars) {
            System.out.println(x.getBody().getName() + x.getBrand() + x.getId() + x.getColor()+" ");
        }
        System.out.println(new CarsStore<>().findlAll());
    }
    @Override
    public E update(E part, String id) {
        return this.makeQuery(session -> {
            session.update(part);
            return part;
        });
    }

    @Override
    public E remove(E part) {
        return this.makeQuery(session -> {
            session.remove(part);
            return part;
        });
    }

    @Override
    public List<E> findlAll() {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
      List list = session.createQuery("from Models.Auto.Car ").list();
        return list;
    }

    @Override
    public E findById(Integer id,Class<E> cl) {
        return this.makeQuery(session -> session.get(cl, id));
    }

    @Override
    public void removeAll() {

    }

}
