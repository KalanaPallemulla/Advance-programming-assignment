package com.assignment.gocheeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.gocheeta.entity.VehicleCategory;

@Repository
public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Long> {

}
