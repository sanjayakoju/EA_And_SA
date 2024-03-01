package com.example.programmingtest3.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

@Entity
@DiscriminatorValue("Owner")
public class Owner extends Person {

    @Embedded
    Address address;

    public Owner() {}

    public Owner(Date dateOfBirth, Car car, Address address) {
        super(dateOfBirth, car);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "address=" + address +
                '}';
    }
}
