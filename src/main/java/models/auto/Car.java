package models.auto;


import models.items.Item;

import javax.persistence.*;
import java.util.Iterator;

@Entity
@Table(name = "car")
public class Car {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "body_id", referencedColumnName = "id")
    private Body body;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    private Engine engine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item itemId;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    public Car(Body body, Engine engine, Brand brand, int id, Item itemId, String model, String color) {
        this.body = body;
        this.engine = engine;
        this.brand = brand;
        this.id = id;
        this.itemId = itemId;
        this.model = model;
        this.color = color;
    }

    public Car() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }
}
