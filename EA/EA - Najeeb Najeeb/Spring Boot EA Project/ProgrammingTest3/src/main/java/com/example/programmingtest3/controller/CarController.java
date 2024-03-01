package com.example.programmingtest3.controller;

import com.example.programmingtest3.model.Car;
import com.example.programmingtest3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public List<Car> getAllCar() {
        List<Car> carList = carRepository.findAll();
        return carList;
    }

    @DeleteMapping("/{car_id}")
    public void deleteCarById(@PathVariable("car_id") int id) {
        carRepository.deleteById(id);
        System.out.println("Car with id : "+id +" Deleted Successfully");
    }

    @PutMapping()
    public Car updateCar(@RequestBody Car car) {
        carRepository.save(car);
        return car;
    }
}
