package models.auto;

import javax.persistence.*;

@Entity
@Table(name = "brands")
public class Brand {

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Brand(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Brand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
