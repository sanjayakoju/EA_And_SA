package com.example.programmingtest3.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String streetNo;
    private String city;
    private String state;
    private String zipCode;

    public Address() {
    }

    public Address(String streetNo, String city, String state, String zipCode) {
        this.streetNo = streetNo;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNo='" + streetNo + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
