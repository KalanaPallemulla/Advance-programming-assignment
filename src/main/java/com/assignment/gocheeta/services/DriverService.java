package com.assignment.gocheeta.services;

import com.assignment.gocheeta.model.Driver;

import java.util.List;


public interface DriverService {

    Driver createDriver(Driver driver);
    
    List<Driver> getAllDrivers();

}
