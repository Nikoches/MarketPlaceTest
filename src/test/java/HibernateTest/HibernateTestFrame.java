package HibernateTest;

import models.auto.Car;
import org.junit.jupiter.api.*;
import service.ServiceMain;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("TestInfo")
public class HibernateTestFrame {
    public static ServiceMain serviceMain = ServiceMain.getServiceMain();;


    @Test
    @DisplayName("Adding new Car and get list of cars")
    public void AddAndGetCarsTest() {
        List<Car> cars = serviceMain.getListGeneral("cars");
        List<Car> carsTest = new LinkedList<>();
        carsTest.add(new Car())
    }
}
