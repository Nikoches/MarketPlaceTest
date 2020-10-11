package Models.Items;

import Models.Auto.Car;
import Models.Users.User;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Car", referencedColumnName = "id")
    private Car car;

    @OneToOne( cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

    public Item() {
    }

    public Item(Car car, Models.Users.User user, int id) {
        this.id = id;
        this.car = car;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Models.Users.User getUser() {
        return user;
    }

    public void setUser(Models.Users.User user) {
        this.user = user;
    }
}
