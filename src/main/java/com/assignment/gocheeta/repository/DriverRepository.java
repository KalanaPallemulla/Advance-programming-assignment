package com.assignment.gocheeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.gocheeta.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findByUsername(@Param("username") String username);
}
