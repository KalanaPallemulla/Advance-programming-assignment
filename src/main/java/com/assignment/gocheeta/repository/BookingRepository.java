package com.assignment.gocheeta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.gocheeta.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // List<Booking> findByUserId(@Param("user") Long user);
}
