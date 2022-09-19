package com.assignment.gocheeta.controller;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.gocheeta.entity.Vehicle;
import com.assignment.gocheeta.services.VehicleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicle")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PutMapping("/reservevehicle/{id}")
    public Vehicle reserveVehicle(@PathVariable Long id) {
        return vehicleService.reserveVehicle(id);
    }

    @PutMapping("/freevehicle/{id}")
    public Vehicle freeVehicle(@PathVariable Long id) {
        return vehicleService.freeVehicle(id);
    }

    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVehicle(@PathVariable Long id) {
        boolean deleted = false;
        deleted = vehicleService.deleteVehicle(id);
        Map<String, Boolean> response = new Hashtable<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/vehicle/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    @PutMapping("/vehicle/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

}
