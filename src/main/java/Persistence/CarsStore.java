package Persistence;

import Models.Auto.Car;


import java.util.List;

public interface CarsStore {

    boolean add(Car car);

    boolean update(Car car, String id);

    boolean delete(String id);

    List<Car> findlAll();

    Car findById(String id);

    void removeAll();

    int getCounterId();
}
