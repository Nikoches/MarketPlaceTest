package persistence;

import models.items.Item;
import models.users.User;

import java.util.Set;

public interface UsersStore extends General<User> {
    Set<Item> getItemsOfUser(User user);

}
