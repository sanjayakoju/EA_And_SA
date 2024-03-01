package com.example.programmingtest3.runner;

import com.example.programmingtest3.model.Address;
import com.example.programmingtest3.model.Car;
import com.example.programmingtest3.model.Driver;
import com.example.programmingtest3.model.Owner;
import com.example.programmingtest3.repository.CarRepository;
import com.example.programmingtest3.repository.DriverRepository;
import com.example.programmingtest3.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CarRunner implements CommandLineRunner {

    @Autowired
    CarRepository carRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public void run(String... args) throws Exception {

        dataLoader();

        List<Car> carList = carRepository.findAll();
        System.out.println("\n All Car");
        for(Car car: carList) {
            System.out.println(car);
        }

        System.out.println("\n Car By ID");
        Optional<Car> car = carRepository.findById(1);
        System.out.println(car);

        System.out.println("\n Max Price Car");
        double price = carRepository.findCarByMaxPrice();
        System.out.println(price);

//        carRepository.deleteById(2);
    }

    public void dataLoader() {
        Car car1 = new Car();
        car1.setMillage(12000);
        car1.setPrice(3200);
        car1.setYear("2005");

        Car car2 = new Car();
        car2.setMillage(160000);
        car2.setPrice(5200);
        car2.setYear("2010");

        Car car3 = new Car();
        car3.setMillage(1452000);
        car3.setPrice(8000);
        car3.setYear("2012");

        Car car4 = new Car();
        car4.setMillage(2352);
        car4.setPrice(2352);
        car4.setYear("2014");

        Car car5 = new Car();
        car5.setMillage(220000);
        car5.setPrice(7000);
        car5.setYear("2016");

//        carRepository.save(car1);
//        carRepository.save(car2);
//        carRepository.save(car3);

        Driver driver1 = new Driver();
        driver1.setYearOfExperience(5);
        driver1.setDateOfBirth(new Date(2001, 04, 23));
        driver1.setCar(car1);

        Driver driver2 = new Driver();
        driver2.setYearOfExperience(5);
        driver2.setDateOfBirth(new Date(1994, 06, 13));
        driver2.setCar(car2);

        Driver driver3 = new Driver();
        driver3.setYearOfExperience(5);
        driver3.setDateOfBirth(new Date(1990, 8, 23));
        driver3.setCar(car3);

        Address address1 = new Address();
        address1.setCity("Fairfield");
        address1.setState("Iowa");
        address1.setStreetNo("1000N 4St");
        address1.setZipCode("52257");

        Address address2 = new Address();
        address2.setCity("Mount Pleasant");
        address2.setState("Iowa");
        address2.setStreetNo("10E 4St");
        address2.setZipCode("52256");

        Address address3 = new Address();
        address3.setCity("Ottumwa");
        address3.setState("Iowa");
        address3.setStreetNo("100S 4St");
        address3.setZipCode("52259");

        Owner owner1 = new Owner();
        owner1.setAddress(address1);
        owner1.setDateOfBirth(new Date(1990, 06, 21));
        owner1.setCar(car4);

        Owner owner2 = new Owner();
        owner2.setAddress(address1);
        owner2.setDateOfBirth(new Date(1980, 02, 12));
        owner2.setCar(car5);

        driverRepository.save(driver1);
        driverRepository.save(driver2);
        driverRepository.save(driver3);

        ownerRepository.save(owner1);
        ownerRepository.save(owner2);

    }
}
