package Persistence;

import Models.Auto.Car;

import java.util.List;

public interface PartStore<E> {

    E add(E part);

    E update(E part, String id);

    E remove(E id);

    List<E> findlAll();

    E findById(Integer id,Class<E> cl);

    void removeAll();

}
