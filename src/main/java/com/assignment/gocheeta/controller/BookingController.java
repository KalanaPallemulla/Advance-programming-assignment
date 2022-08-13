package com.assignment.gocheeta.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.gocheeta.model.Booking;
import com.assignment.gocheeta.services.BookingService;

@RestController
@RequestMapping("/api/v1/")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public Booking createBooking(@RequestBody Long userId, @RequestBody Long driverId){
        return bookingService.createBooking(userId, driverId);
    }



}
