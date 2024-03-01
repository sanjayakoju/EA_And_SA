package com.example.programmingtest3.repository;

import com.example.programmingtest3.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "SELECT * FROM Car as c JOIN Person as p on c.id = p.car_id JOIN Driver as d on p.id = d.id WHERE d.yearOfExperience > 3", nativeQuery = true)
    List<Car> findAllByDriverExperience();

    @Query(value = "SELECT max(price) FROM car", nativeQuery = true)
    double findCarByMaxPrice();

    @Query(value = "select * from car as c join person as p on c.id = p_car_id join Owner o on o.id = p.id join address as a on o.id = a.id =  where a.state = 'iowa'", nativeQuery = true)
    List<Car> findAllCarInYear();
}
