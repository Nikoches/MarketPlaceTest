package service;

import models.auto.Body;
import models.auto.Brand;
import models.auto.Car;
import models.auto.Engine;
import persistence.General;
import persistence.implementation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;


public class ServiceMain<E> {
    private final static ServiceMain serviceMain = new ServiceMain();
    private final  PersistenceCars carStore = new PersistenceCars();
    private final  PersistenceUsers usersStore = new PersistenceUsers();
    private final static PersistenceItems itemsStore = new PersistenceItems();
    private final HashMap<String, General> maps = new HashMap<>();

    private ServiceMain() {
        maps.put("cars", carStore);
        maps.put("users", usersStore);
        maps.put("items", itemsStore);
        maps.put("body", new PartsStore<>(() -> Body.class));
        maps.put("brands", new PartsStore<>(() -> Brand.class));
        maps.put("engines", new PartsStore<>(() -> Engine.class));
    }

    public static ServiceMain getServiceMain() {
        return serviceMain;
    }

    public static void main(String... args) {
        ServiceMain serviceMain = getServiceMain();
        List<Car> cars = serviceMain.getListGeneral("cars");
        String name = cars.get(0).getItemId().getUser().getName();
        System.out.println();
        //serviceMain.remove("cars", car);
    }

    public List<E> getListGeneral(String type) {
        return maps.get(type).findAll();
    }

    public void removeAll(String type) {
        maps.get(type).removeAll();
    }

    public E getById(String type, Integer id) {
        return (E) maps.get(type).findById(id);
    }

    public void remove(String type, E part) {
        maps.get(type).remove(part);
    }
}