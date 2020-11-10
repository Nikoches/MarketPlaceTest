package persistence.implementation;

import models.items.Item;
import models.users.User;
import persistence.General;
import java.util.Set;

public class PersistenceUsers implements General<User> {


    public Set<Item> getItemsOfUser(User user) {
        return user.getItemList();
    }

    @Override
    public Class<User> setType() {
        return User.class;
    }
}
