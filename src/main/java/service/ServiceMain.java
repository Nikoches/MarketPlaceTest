package service;

import models.auto.Body;
import models.auto.Brand;
import models.auto.Car;
import models.auto.Engine;
import models.items.Item;
import models.users.User;
import org.apache.commons.fileupload.FileItem;
import org.hibernate.query.Query;
import persistence.General;
import persistence.implementation.*;

import java.io.File;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;



public class ServiceMain<E> {
    private final static ServiceMain serviceMain = new ServiceMain();
    private final  PersistenceCars carStore = new PersistenceCars();
    private final  PersistenceUsers usersStore = new PersistenceUsers();
    private final static PersistenceItems itemsStore = new PersistenceItems();
    private final HashMap<String, General> maps = new HashMap<>();
    private final HashMap<String,String> carsFilter = new HashMap<>();
    private ServiceMain() {
        maps.put("cars", carStore);
        maps.put("users", usersStore);
        maps.put("items", itemsStore);
        maps.put("body", new PartsStore<>(() -> Body.class));
        maps.put("brands", new PartsStore<>(() -> Brand.class));
        maps.put("engines", new PartsStore<>(() -> Engine.class));
        carsFilter.put("by_model","from car where model=?");
        carsFilter.put("withFoto","from car where image_name<>noImg");
    }

    public static ServiceMain getServiceMain() {
        return serviceMain;
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

    public void add(String type, E part) {
        maps.get(type).add(part);
    }

    public boolean authentificate(String userName) {
        return serviceMain.getListGeneral("users").contains(new User(userName));
    }
    public List<Car> getCarsByCriteria(String type, String model) {
        return carStore.getAllByCriteria(type,model);
    }
    public void update(String type,E part) {
        maps.get(type).update(part);
    }
    public Car createCar(List<FileItem> items, String path,String username,String userId) {
        HashMap<String,String> params = new HashMap<>();
        Car car = new Car();
        try {
            car.setImage("noImg");
            for (FileItem fileItem : items) {
                if (!fileItem.isFormField()) {
                    if (!fileItem.isFormField()) {
                        fileItem.write(new File(path + File.separator + fileItem.getName()));
                        car.setImage(fileItem.getName());
                    }
                }else {
                    params.put(fileItem.getFieldName(), fileItem.getString());
                }
            }
        }catch (Exception ex){
            ex.getMessage();
            ex.printStackTrace();
        }
        car.setColor(params.get("color"));
        car.setBody((Body)getById("body",Integer.parseInt(params.get("body"))));
        car.setBrand((Brand) getById("brand",Integer.parseInt(params.get("brand"))));
        car.setEngine((Engine)getById("engine",Integer.parseInt(params.get("engine"))));
        Item item = new Item();
        item.setCar(car);
        User user = usersStore.findById(Integer.parseInt(userId));
        item.setUser(usersStore.findById(Integer.parseInt(userId)));
        return car;
    }
}