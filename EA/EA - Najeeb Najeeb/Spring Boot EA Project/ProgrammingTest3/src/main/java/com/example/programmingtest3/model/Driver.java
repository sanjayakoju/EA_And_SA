package com.example.programmingtest3.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

@Entity
@DiscriminatorValue("Driver")
public class Driver extends Person {

    private int yearOfExperience;

    public Driver() {}

    public Driver(Date dateOfBirth, Car car, int yearOfExperience) {
        super(dateOfBirth, car);
        this.yearOfExperience = yearOfExperience;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "yearOfExperience=" + yearOfExperience +
                '}';
    }
}
