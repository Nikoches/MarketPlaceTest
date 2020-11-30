package persistence.implementation;


import models.auto.Car;
import models.items.Item;
import org.hibernate.Session;
import org.hibernate.query.Query;
import persistence.General;
import java.util.List;


public class PersistenceCars<E> implements General<Car> {

    public PersistenceCars() {

    }

    public Item getItemFromCar(Car car) {
        return car.getItemId();
    }

    public Class<Car> setType() {
        return Car.class;
    }

    public List<Car> getAllByCriteria(String type,String model) {
        Session session = SESSION_FACTORY.openSession();
        Query query;
        if(type.equals("model")) {
            query = session.createQuery("from Car where brand.id = :model");
            query.setParameter( "model",Integer.parseInt(model));
        }else if(type.equals("Noimg")){
            query = session.createQuery("from Car where image<>'noImg' ");
        }else {
            query = session.createQuery("from Car");
        }

       return query.list();
    }
}
