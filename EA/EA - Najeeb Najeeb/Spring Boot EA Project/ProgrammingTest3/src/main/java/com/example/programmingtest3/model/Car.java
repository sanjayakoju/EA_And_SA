package com.example.programmingtest3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double price;
    private double millage;
    private String year;

    public Car() {}

    public Car(double price, double millage, String year) {
        this.price = price;
        this.millage = millage;
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMillage() {
        return millage;
    }

    public void setMillage(double millage) {
        this.millage = millage;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", price=" + price +
                ", millage=" + millage +
                ", year=" + year +
                '}';
    }
}
