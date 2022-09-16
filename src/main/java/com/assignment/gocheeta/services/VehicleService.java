package com.assignment.gocheeta.services;

import java.util.List;

import com.assignment.gocheeta.entity.Vehicle;

public interface VehicleService {

    Vehicle addVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Vehicle reserveVehicle(Long id);

    Vehicle freeVehicle(Long id);

    boolean deleteVehicle(Long id);

    Vehicle getVehicleById(Long id);

    Vehicle updateVehicle(Long id, Vehicle vehicle);

}
