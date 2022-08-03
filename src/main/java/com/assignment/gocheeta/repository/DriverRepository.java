package com.assignment.gocheeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.gocheeta.entity.DriverEntity;


@Repository
public interface DriverRepository extends JpaRepository<DriverEntity,Long> {
    
}
