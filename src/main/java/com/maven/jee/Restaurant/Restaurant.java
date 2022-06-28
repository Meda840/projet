package com.maven.jee.Restaurant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Restaurant {

    public Restaurant() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String description; 
    @Column
    private String price; 
    @Column
    private boolean spicy;

    // public Restaurant(Integer id, String title, String description,String price) {
    //     this.id = id;
    //     this.title = title;
    //     this.description = description;
    //     this.price = price;

    // }



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public boolean getSpicy() {
        return this.spicy;
    }

    public void setSpicy(Boolean spicy) {
        this.spicy = spicy;
    }

    
}
