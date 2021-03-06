package models.auto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Engine {
    private String type;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Engine() {

    }

    public Engine(String type, int id) {
        this.type = type;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
