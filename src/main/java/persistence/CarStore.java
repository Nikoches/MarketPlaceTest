package persistence;

import models.auto.Car;
import models.items.Item;

public interface CarStore<E> extends General<E> {

    Item getItemFromCar(Car car);

}
