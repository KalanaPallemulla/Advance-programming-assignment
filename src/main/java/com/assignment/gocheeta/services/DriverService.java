package com.assignment.gocheeta.services;

import com.assignment.gocheeta.model.Driver;

import java.util.List;


public interface DriverService {

    Driver createDriver(Driver driver);
    
    List<Driver> getAllDrivers();

    Driver getDriver(Long id);

    boolean deleteDriver(Long id);

    Driver updateDriver(Long id, Driver driver);

}
