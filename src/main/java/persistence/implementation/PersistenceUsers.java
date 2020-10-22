package persistence.implementation;

import models.items.Item;
import models.users.User;
import persistence.UsersStore;

import java.util.List;
import java.util.Set;

public class PersistenceUsers implements UsersStore {

    @Override
    public List<User> findlAll() {
        return null;
    }

    @Override
    public void removeAll() {

    }

    @Override
    public Set<Item> getItemsOfUser(User user) {
        return user.getItemList();
    }
}
