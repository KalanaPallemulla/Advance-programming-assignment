package com.assignment.gocheeta.services;

import com.assignment.gocheeta.model.Booking;

public interface BookingService {

    Booking createBooking(Long userId, Long driverId);

    
}
