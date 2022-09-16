package com.assignment.gocheeta.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.Vehicle;
import com.assignment.gocheeta.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        Vehicle vehi = new Vehicle();
        BeanUtils.copyProperties(vehicle, vehi);
        vehicleRepository.save(vehi);
        return vehi;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles;
    }

    @Override
    public Vehicle reserveVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).get();
        vehicle.setStatus(1);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle freeVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).get();
        vehicle.setStatus(0);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public boolean deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).get();
        vehicleRepository.delete(vehicle);
        return true;
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).get();
        return vehicle;
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle vehi = vehicleRepository.findById(id).get();
        vehi.setName(vehicle.getName());
        vehi.setCatId(vehicle.getCatId());
        vehi.setSeats(vehicle.getSeats());
        vehi.setBranch_id(vehicle.getBranch_id());
        // vehi.setStatus(vehicle.getStatus());
        vehi.setDriver_ids(vehicle.getDriver_ids());
        return vehicleRepository.save(vehi);

    }

}
