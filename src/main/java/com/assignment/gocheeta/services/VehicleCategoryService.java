package com.assignment.gocheeta.services;

import java.util.List;

import com.assignment.gocheeta.entity.VehicleCategory;

public interface VehicleCategoryService {

    VehicleCategory addVehicleCat(VehicleCategory vehicleCategory);

    List<VehicleCategory> getAllVehiclesCat();

    VehicleCategory getVehicleCatById(Long id);

    VehicleCategory updateCategory(Long id, VehicleCategory vehicleCategory);

    boolean deleteVehicle(Long id);

}
