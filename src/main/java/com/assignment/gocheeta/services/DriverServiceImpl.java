package com.assignment.gocheeta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.Branch;
import com.assignment.gocheeta.entity.Driver;
import com.assignment.gocheeta.repository.BranchRepository;
import com.assignment.gocheeta.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    @Autowired
    private BranchRepository branchRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver createDriver(Driver driver) {
        Driver driverEntity = new Driver();
        BeanUtils.copyProperties(driver, driverEntity);
        return driverRepository.save(driverEntity);

    }

    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> driverEntity = driverRepository.findAll();

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
        de.setBranch_id(driver.getBranch_id());
        de.setContactNo(driver.getContactNo());

        driverRepository.save(de);
        return driver;
        // return null;

    }

    @Override
    public Driver assignToBranch(Long branchId, Long driverId) {
        // Driver driver = driverRepository.findById(driverId).get();
        // Branch branch = branchRepository.findById(branchId).get();

        // driver.assignDriver(branch);
        // return driverRepository.save(driver);
        return null;

    }

    @Override
    public Driver getDriverByUsername(String username) {
        Driver driver = driverRepository.findByUsername(username);

        return driver;
    }

    @Override
    public Driver getDriverById(Long id) {
        Driver driver = driverRepository.findById(id).get();
        return driver;
    }

}
