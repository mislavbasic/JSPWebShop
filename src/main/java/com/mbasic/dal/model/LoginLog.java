package com.mbasic.dal.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Login")
public class LoginLog {
    @Column(name = "IDLogin")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "UserEmail")
    private String userEmail;
    @Column(name = "Date")
    private Date dateTime;
    @Column(name = "Address")
    private String address;

    public LoginLog(String userEmail, Date dateTime, String address) {
        this.userEmail = userEmail;
        this.dateTime = dateTime;
        this.address = address;
    }

    public LoginLog() {
    }

    public int getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getAddress() {
        return address;
    }
}
