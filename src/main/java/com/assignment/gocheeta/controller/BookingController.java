package com.assignment.gocheeta.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.gocheeta.entity.Booking;
import com.assignment.gocheeta.services.BookingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/allbookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/booking/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PutMapping("/booking/{id}")
    public ResponseEntity<Booking> acceptBooking(@PathVariable Long id, @RequestBody Booking book) {
        Booking booking = bookingService.acceptBooking(id, book);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/booking/user/{id}")
    public List<Booking> findUserAllBookings(@PathVariable Long id) {
        return bookingService.findUserAllBookings(id);

    }

    @PutMapping("/bookingfinish/{id}")
    public ResponseEntity<Booking> finishBooking(@PathVariable Long id) {
        Booking booking = bookingService.finishBooking(id);
        return ResponseEntity.ok(booking);
    }

    @PutMapping("/bookingvehicle/{id}")
    public ResponseEntity<Booking> addVehicle(@PathVariable Long id, @RequestBody Booking booking) {
        Booking book = bookingService.addVehicle(id, booking);
        return ResponseEntity.ok(book);
    }
}
