package Persistence;

import Models.Auto.Car;
import Models.Items.Item;

import java.util.List;

public interface ItemsStore {
    boolean add(Item item);

    boolean update(Item item, String id);

    boolean delete(String id);

    List<Item> findlAll();

    Item findById(String id);

    void removeAll();

    Car getCarOfItem(Item item);

}
