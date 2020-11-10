package persistence.implementation;


import models.auto.Car;
import models.items.Item;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import persistence.General;

import java.util.List;
import java.util.function.Function;

public class PersistenceCars<E>  implements General<Car> {

    public Item getItemFromCar(Car car) {
        return car.getItemId();
    }

    public Class<Car> setType() {
        return Car.class;
    }

}
