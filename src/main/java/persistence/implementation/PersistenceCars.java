package persistence.implementation;


import models.auto.Car;
import models.items.Item;
import persistence.CarStore;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersistenceCars implements CarStore<Car> {

    @Override
    public List<Car> findlAll() {
        Session session = SESSION_FACTORY.openSession();
        Transaction tx = session.beginTransaction();
        return (List<Car>)session.createQuery("from models.auto.Car ").list();
    }

    @Override
    public void removeAll() {
        Session session = SESSION_FACTORY.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from models.auto.Car ").executeUpdate();
        tx.commit();
    }

    @Override
    public Item getItemFromCar(Car car) {
        return car.getItemId();
    }
}
