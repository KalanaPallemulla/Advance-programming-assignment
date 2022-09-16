package com.assignment.gocheeta.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.gocheeta.entity.VehicleCategory;
import com.assignment.gocheeta.services.VehicleCategoryService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/v1/")
public class VehicleCategoryController {

    public final VehicleCategoryService vehicleCategoryService;

    public VehicleCategoryController(VehicleCategoryService vehicleCategoryService) {
        this.vehicleCategoryService = vehicleCategoryService;
    }

    @PostMapping("/vc")
    public VehicleCategory addVehicleCat(@RequestBody VehicleCategory vehicleCategory) {
        return vehicleCategoryService.addVehicleCat(vehicleCategory);
    }

    @GetMapping("/vcs")
    public List<VehicleCategory> getAllVehiclesCat() {
        return vehicleCategoryService.getAllVehiclesCat();
    }

    @GetMapping("/vc/{id}")
    public VehicleCategory getVehicleCatById(@PathVariable Long id) {
        return vehicleCategoryService.getVehicleCatById(id);
    }

    @PutMapping("/vc/{id}")
    public ResponseEntity<VehicleCategory> updateVehicleCategory(@PathVariable Long id,
            @RequestBody VehicleCategory vehicleCategory) {
        VehicleCategory vc = vehicleCategoryService.updateCategory(id, vehicleCategory);
        return ResponseEntity.ok(vc);
    }

}
