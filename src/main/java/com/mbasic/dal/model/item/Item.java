package com.mbasic.dal.model.item;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Items")
public class Item {

    @Column(name = "IDItem")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private String price;

    @Column(name = "Description")
    private String description;

    @Column(name = "Details")
    private String details;

    @Enumerated(EnumType.STRING)
    @Column(name = "Category")
    private Category category;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> imgNames = new ArrayList<>();

    public Item() {
    }

    public Item(String name, String price, String description, String details, Category category, List<String> imgNames) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.details = details;
        this.category = category;
        this.imgNames = imgNames;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public List<String> getImgNames() {
        return imgNames;
    }

    public String getDescription() {
        return description;
    }

    public String getDetails() {
        return details;
    }
}
