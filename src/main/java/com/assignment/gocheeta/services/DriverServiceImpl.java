package com.assignment.gocheeta.services;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Driver> getAllDrivers() {
        List<DriverEntity> driverEntity = driverRepository.findAll();
        List<Driver> drivers = driverEntity.stream().map(driver -> new Driver(driver.getId(),driver.getName(),  driver.getContactNo(), driver.getUsername(),driver.getBranch())).collect(Collectors.toList());


        return drivers;
    }
    

    @Override
    public Driver getDriver(Long id) {
        DriverEntity driverEntity = driverRepository.findById(id).get();
        Driver driver = new Driver(driverEntity.getId(),driverEntity.getName(),driverEntity.getBranch(),driverEntity.getContactNo(), driverEntity.getUsername());
        return driver;
    }

    @Override
    public boolean deleteDriver(Long id) {
        DriverEntity driverEntity = driverRepository.findById(id).get();
        driverRepository.delete(driverEntity);
        return true;
    }

    @Override
    public Driver updateDriver(Long id, Driver driver) {
        DriverEntity de = driverRepository.findById(id).get();

        de.setName(driver.getName());
        de.setUsername(driver.getUsername());
        de.setBranch(driver.getBranch());
        de.setContactNo(driver.getContactNo());

        driverRepository.save(de);
        return driver;
    }

    
    
}
