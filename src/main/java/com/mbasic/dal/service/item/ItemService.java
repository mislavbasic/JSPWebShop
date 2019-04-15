package com.mbasic.dal.service.item;

import com.mbasic.dal.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findByCategory(String category);
    Item findById(int id);
    List<Item> findAll();
}
