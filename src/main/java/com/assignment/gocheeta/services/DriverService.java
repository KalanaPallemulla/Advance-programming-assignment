package com.assignment.gocheeta.services;


import java.util.List;

import com.assignment.gocheeta.entity.Driver;



public interface DriverService {

    Driver createDriver(Driver driver);
    
    List<Driver> getAllDrivers();

    Driver getDriver(Long id);

    boolean deleteDriver(Long id);

    Driver updateDriver(Long id, Driver driver);

}
