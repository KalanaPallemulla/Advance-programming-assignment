package com.assignment.gocheeta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.Driver;
import com.assignment.gocheeta.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver createDriver(Driver driver) {
        Driver driverEntity = new Driver();
        BeanUtils.copyProperties(driver, driverEntity);
        driverRepository.save(driverEntity);
        return driver;
    }

    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> driverEntity = driverRepository.findAll();


        return driverEntity;
    }
    

    @Override
    public Driver getDriver(Long id) {
        Driver driverEntity = driverRepository.findById(id).get();
        return driverEntity;
    }

    @Override
    public boolean deleteDriver(Long id) {
        Driver driverEntity = driverRepository.findById(id).get();
        driverRepository.delete(driverEntity);
        return true;
    }

    @Override
    public Driver updateDriver(Long id, Driver driver) {
        Driver de = driverRepository.findById(id).get();

        de.setName(driver.getName());
        de.setUsername(driver.getUsername());
        de.setBranch(driver.getBranch());
        de.setContactNo(driver.getContactNo());

        driverRepository.save(de);
        return driver;
    }

    
    
}
