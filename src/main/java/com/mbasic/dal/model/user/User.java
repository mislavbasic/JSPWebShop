package com.mbasic.dal.model.user;

import com.mbasic.dal.model.log.LoginLog;
import com.mbasic.dal.model.log.OrderLog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Column(name = "IDUser")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<LoginLog> loginLogs = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<OrderLog> orderLogs = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public int getId() {
        return id;
    }
}