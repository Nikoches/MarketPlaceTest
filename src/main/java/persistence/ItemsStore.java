package persistence;

import models.auto.Car;
import models.items.Item;
import models.users.User;

public interface ItemsStore  extends General<Item> {

    Car getCarOfItem(String id);

    Car getCarOfItem(Item item);

    User getUserOfItem(User user);

    User getUserOfItem(String id);
}
