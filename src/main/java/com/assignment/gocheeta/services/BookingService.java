package com.assignment.gocheeta.services;

import java.util.List;

import com.assignment.gocheeta.entity.Booking;

public interface BookingService {

    Booking createBooking(Booking booking);

    List<Booking> getAllBookings();

    Booking getBookingById(Long id);

    Booking acceptBooking(Long id, Booking book);

}
