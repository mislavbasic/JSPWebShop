package com.mbasic.dal.model.user;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDAddress")
    private int id;

    @Column(name = "Address1")
    private String address1;

    @Column(name = "Address2")
    private String address2;

    @Column(name = "State")
    private String state;

    @Column(name = "City")
    private String city;

    @Column(name = "Zip")
    private String zip;

    @ManyToOne
    private User user;

    public Address() {
    }

    public Address(String address1, String address2, String state, String city, String zip, User user) {
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }
}
