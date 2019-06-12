package com.mbasic.dal.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @Column(name = "Category")
    private String category;
    @Column(name="Imgs")
    @Convert(converter = StringListConverter.class)
    private List<String> imgNames;

    public Item() {
    }

    public Item(String name, String price, String description, String details, String category, List<String> imgNames) {
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

    public String getDescription() {
        return description;
    }

    public String getDetails() {
        return details;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getImgNames() {
        return imgNames;
    }
}

@Converter
class StringListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> list) {
        return String.join(",", list);
    }

    @Override
    public List<String> convertToEntityAttribute(String joined) {
        return new ArrayList<>(Arrays.asList(joined.split(",")));
    }

}
