package com.assignment.gocheeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.gocheeta.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
