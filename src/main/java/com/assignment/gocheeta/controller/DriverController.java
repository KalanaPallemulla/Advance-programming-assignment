package com.assignment.gocheeta.controller;

import java.util.List;
import java.util.Map;
import java.util.Hashtable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.assignment.gocheeta.entity.Driver;
import com.assignment.gocheeta.services.DriverService;


@RestController
@RequestMapping("/api/v1/")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    @PostMapping("/driver")
    public Driver createDriver(@RequestBody Driver driver){
        return driverService.createDriver(driver);
    }

    @GetMapping("/drivers")
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }
    
    @GetMapping("/driver/{id}")
    public Driver getDriver(@PathVariable Long id){
        return driverService.getDriver(id);
    }

    @DeleteMapping("/driver/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteDriver(@PathVariable Long id){
        boolean deleted = false;
        deleted = driverService.deleteDriver(id);
        Map<String,Boolean> response = new Hashtable<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/driver/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driver){
        driver = driverService.updateDriver(id,driver);
        return ResponseEntity.ok(driver); 
    }
}

