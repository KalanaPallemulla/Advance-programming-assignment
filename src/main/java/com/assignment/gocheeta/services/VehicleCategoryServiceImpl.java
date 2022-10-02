package com.assignment.gocheeta.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.VehicleCategory;
import com.assignment.gocheeta.repository.VehicleCategoryRepository;

@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

    @Autowired
    private VehicleCategoryRepository vehicleCategoryRepository;

    @Override
    public VehicleCategory addVehicleCat(VehicleCategory vehicleCategory) {
        VehicleCategory vc = new VehicleCategory();
        BeanUtils.copyProperties(vehicleCategory, vc);

        return vehicleCategoryRepository.save(vc);
    }

    @Override
    public List<VehicleCategory> getAllVehiclesCat() {
        List<VehicleCategory> vehicleCategories = vehicleCategoryRepository.findAll();
        return vehicleCategories;
    }

    @Override
    public VehicleCategory getVehicleCatById(Long id) {
        VehicleCategory vehicleCategory = vehicleCategoryRepository.findById(id).get();
        return vehicleCategory;
    }

    @Override
    public VehicleCategory updateCategory(Long id, VehicleCategory vehicleCategory) {
        VehicleCategory vc = vehicleCategoryRepository.findById(id).get();
        vc.setName(vehicleCategory.getName());
        return vehicleCategoryRepository.save(vc);
    }

    @Override
    public boolean deleteVehicle(Long id) {
        VehicleCategory vc = vehicleCategoryRepository.findById(id).get();
        vehicleCategoryRepository.delete(vc);
        return true;
    }

}
