package persistence.implementation;


import models.auto.Car;
import models.items.Item;
import persistence.CarStore;

public class PersistenceCars implements CarStore<Car> {

    @Override
    public Item getItemFromCar(Car car) {
        return car.getItemId();
    }
}
