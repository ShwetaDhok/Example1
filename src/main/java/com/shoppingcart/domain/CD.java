package com.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class CD {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Id
    private String id;
    private String  name;
    private String description;
    private double price;


    // public static int getId() {
    //  return id;
    //}

    ///public static void setId(int id) {
    //Book.id = id;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public CD ( String id , String name,  String description , double price)
    {
        this.id =id;
        this.name=name;
        this.description=description;
        this.price=price;
    }

    public CD () {


    }
}
