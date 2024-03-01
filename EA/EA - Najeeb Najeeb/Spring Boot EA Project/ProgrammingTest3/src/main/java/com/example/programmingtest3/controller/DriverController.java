package com.example.programmingtest3.controller;

import com.example.programmingtest3.model.Driver;
import com.example.programmingtest3.repository.DriverRepository;
import com.example.programmingtest3.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    Sender sender;

    @PutMapping
    public void updateDriver(@RequestBody Driver driver) {
        driverRepository.save(driver);
        sender.send("Driver Updated Successfully");
    }
}
