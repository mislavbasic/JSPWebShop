package com.mbasic.dal.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("JpaDataSourceORMInspection")
@Embeddable
public class Address {
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

    public Address() {
    }

    public Address(String address1, String address2, String state, String city, String zip) {
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;
        this.city = city;
        this.zip = zip;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
