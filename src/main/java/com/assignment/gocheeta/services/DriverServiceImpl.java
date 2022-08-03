package com.assignment.gocheeta.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.DriverEntity;
import com.assignment.gocheeta.model.Driver;
import com.assignment.gocheeta.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver createDriver(Driver driver) {
        DriverEntity driverEntity = new DriverEntity();
        BeanUtils.copyProperties(driver, driverEntity);
        driverRepository.save(driverEntity);
        return driver;
    }
    
}
