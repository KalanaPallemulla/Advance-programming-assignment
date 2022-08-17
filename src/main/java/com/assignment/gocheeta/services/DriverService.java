package com.assignment.gocheeta.services;


import java.util.List;

import com.assignment.gocheeta.entity.DriverEntity;


public interface DriverService {

    DriverEntity createDriver(DriverEntity driver);
    
    List<DriverEntity> getAllDrivers();

    DriverEntity getDriver(Long id);

    boolean deleteDriver(Long id);

    DriverEntity updateDriver(Long id, DriverEntity driver);

}
