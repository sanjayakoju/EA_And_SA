package com.example.programmingtest3.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "person_type")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Car car;

    public Person(){}

    public Person(Date dateOfBirth, Car car) {
        this.dateOfBirth = dateOfBirth;
        this.car = car;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                ", car=" + car +
                '}';
    }
}
