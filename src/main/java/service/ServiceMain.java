package service;

import models.auto.Car;
import persistence.CarStore;
import persistence.implementation.PartsStore;
import persistence.implementation.PersistenceCars;
import persistence.implementation.PersistenceItems;
import persistence.implementation.PersistenceUsers;
import persistence.ItemsStore;
import persistence.UsersStore;

public class ServiceMain<E> {
    private final CarStore<Car> carStore = new PersistenceCars();
    private final UsersStore usersStore = new PersistenceUsers();
    private final ItemsStore itemsStore = new PersistenceItems();
    private final PartsStore<E> ePartsStore = new PartsStore<>();
    private final static ServiceMain serviceMain= new ServiceMain();

    private ServiceMain() {

    }

    public static ServiceMain getServiceMain() {
        return serviceMain;
    }
}