package com.assignment.gocheeta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.DriverEntity;
import com.assignment.gocheeta.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    @Override
    public DriverEntity createDriver(DriverEntity driver) {
        DriverEntity driverEntity = new DriverEntity();
        BeanUtils.copyProperties(driver, driverEntity);
        driverRepository.save(driverEntity);
        return driver;
    }

    @Override
    public List<DriverEntity> getAllDrivers() {
        List<DriverEntity> driverEntity = driverRepository.findAll();


        return driverEntity;
    }
    

    @Override
    public DriverEntity getDriver(Long id) {
        DriverEntity driverEntity = driverRepository.findById(id).get();
        return driverEntity;
    }

    @Override
    public boolean deleteDriver(Long id) {
        DriverEntity driverEntity = driverRepository.findById(id).get();
        driverRepository.delete(driverEntity);
        return true;
    }

    @Override
    public DriverEntity updateDriver(Long id, DriverEntity driver) {
        DriverEntity de = driverRepository.findById(id).get();

        de.setName(driver.getName());
        de.setUsername(driver.getUsername());
        de.setBranch(driver.getBranch());
        de.setContactNo(driver.getContactNo());

        driverRepository.save(de);
        return driver;
    }

    
    
}
