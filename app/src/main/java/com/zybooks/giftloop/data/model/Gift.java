package com.zybooks.giftloop.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gift_table")
public class Gift {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String description;
    private double price;
    private String status;

    public Gift(String name, String description, double price, String status) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
}
