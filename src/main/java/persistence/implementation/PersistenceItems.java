package persistence.implementation;

import models.auto.Car;
import models.items.Item;
import models.users.User;
import persistence.General;

public class PersistenceItems implements General<Item> {


    public Car getCarOfItem(String id) {
        return null;
    }


    public Car getCarOfItem(Item item) {
        return null;
    }


    public User getUserOfItem(User user) {
        return null;
    }


    public User getUserOfItem(String id) {
        return null;
    }

    @Override
    public Class<Item> setType() {
        return Item.class;
    }
}
