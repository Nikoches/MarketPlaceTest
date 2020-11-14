package models.users;

import models.items.Item;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "user")
    private Set<Item> itemList;

    public User() {
    }
    public User(String name) {
        this.name = name;
    }
    public User(int id, String name, Set<Item> itemList) {
        this.id = id;
        this.name = name;
        this.itemList = itemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Set<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public boolean equals(Object obj) {


            // If the object is compared with itself then return true
            if (obj == this) {
                return true;
            }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
            if (!(obj instanceof User)) {
                return false;
            }

            // typecast o to Complex so that we can compare data members
            User c = (User) obj;

            // Compare the data members and return accordingly
            return this.name.equals(c.getName());

    }
}
