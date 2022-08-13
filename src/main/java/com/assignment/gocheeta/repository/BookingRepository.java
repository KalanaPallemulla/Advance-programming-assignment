package com.assignment.gocheeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.gocheeta.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
