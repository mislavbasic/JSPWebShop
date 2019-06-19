package com.mbasic.dal.model.order;

import com.mbasic.dal.model.item.Item;

public class Order {

    private Item item;
    private int qty;

    public Order(Item item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    public Item getItem() {
        return item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void addQty(int qty) {
        this.qty += qty;
    }


}