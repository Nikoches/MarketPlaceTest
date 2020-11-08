package service;

import models.auto.Car;
import models.items.Item;
import models.users.User;
import persistence.CarStore;
import persistence.implementation.PartsStore;
import persistence.implementation.PersistenceCars;
import persistence.implementation.PersistenceItems;
import persistence.implementation.PersistenceUsers;
import persistence.ItemsStore;
import persistence.UsersStore;

import java.util.List;


public class ServiceMain<E> {
    private final static ServiceMain serviceMain = new ServiceMain();
    private final CarStore<Car> carStore = new PersistenceCars();
    private final UsersStore usersStore = new PersistenceUsers();
    private final ItemsStore itemsStore = new PersistenceItems();
    private final PartsStore<E> ePartsStore = new PartsStore<>();

    private ServiceMain() {

    }

    public static ServiceMain getServiceMain() {
        return serviceMain;
    }

    public List<E> getParts(E type) {
        return ePartsStore.findlAll(type);
    }

    public List<Car> getCars() {
        return carStore.findlAll(new Car());
    }

    public List<Item> getItems() {
        return itemsStore.findlAll(new Item());
    }

    public List<User> getUsers() {
        return usersStore.findlAll(new User());
    }

}