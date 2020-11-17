package HibernateTest;

import models.auto.Body;
import models.auto.Brand;
import models.auto.Car;
import models.auto.Engine;
import models.users.User;
import org.junit.jupiter.api.*;
import service.ServiceMain;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("TestInfo")
public class HibernateTestFrame {
    public static ServiceMain serviceMain = ServiceMain.getServiceMain();


    @Test
    @DisplayName("Adding new Car and get list of cars")
    public void AddAndGetCarsTest() {
        List<Car> cars = serviceMain.getListGeneral("cars");

    }
    @Test
    public void optionaltest(){
        User user = new User();
        Optional<String> optional = Optional.ofNullable(user.getName());
        //Optional<String> optionalS = Optional.of(user.getName());
        System.out.println(optional.isEmpty()?"epmty":"notempty ");
        System.out.println(optional.orElse("\n HELLOW"));

    }
}
