package com.mbasic.dal.model.log;

import com.mbasic.dal.model.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Login")
public class LoginLog {
    @Column(name = "IDLogin")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @Column(name = "Date")
    private Date dateTime;

    @Column(name = "IPAddress")
    private String address;

    public LoginLog() {
    }

    public LoginLog(User user, Date dateTime, String address) {
        this.user = user;
        this.dateTime = dateTime;
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getAddress() {
        return address;
    }
}
