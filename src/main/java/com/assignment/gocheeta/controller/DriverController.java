package com.assignment.gocheeta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.gocheeta.model.Driver;
import com.assignment.gocheeta.services.DriverService;


@Controller
@RequestMapping("/api/v1/")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    @PostMapping("/createDriver")
    public Driver createDriver(@RequestBody Driver driver){
        return driverService.createDriver(driver);
    }
    
}
