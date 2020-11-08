package persistence.implementation;

import models.auto.Car;
import models.items.Item;
import models.users.User;
import persistence.ItemsStore;


public class PersistenceItems implements ItemsStore {

    @Override
    public Car getCarOfItem(String id) {
        return null;
    }

    @Override
    public Car getCarOfItem(Item item) {
        return null;
    }

    @Override
    public User getUserOfItem(User user) {
        return null;
    }

    @Override
    public User getUserOfItem(String id) {
        return null;
    }
}
