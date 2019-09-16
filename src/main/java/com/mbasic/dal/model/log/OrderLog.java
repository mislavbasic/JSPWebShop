package com.mbasic.dal.model.log;

import com.mbasic.dal.model.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class OrderLog {

    @Column(name = "IDOrders")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @Column(name = "itemNames")
    private String itemNames;

    @Column(name = "orders_date")
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    public OrderLog() {
    }

    public OrderLog(User user, String itemNames, Date orderDate, PaymentMethod paymentMethod) {
        this.user = user;
        this.itemNames = itemNames;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
    }

    public String getItemNames() {
        return itemNames;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
