package com.girlsteam.Car.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cartable")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String model;
    private String color;
    private double price;

    // Constructors
    public Cars() {}

    public Cars(String name, String model, String color, double price) {
        this.name = name;
        this.model = model;
        this.color = color;
        this.price = price;
    }

    // Getters and Setters manually
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
