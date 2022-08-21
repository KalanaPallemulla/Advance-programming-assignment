package com.assignment.gocheeta.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.Booking;
import com.assignment.gocheeta.entity.User;
import com.assignment.gocheeta.repository.BookingRepository;
import com.assignment.gocheeta.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Booking createBooking(Booking booking) {
        Booking bookingEntity = new Booking();
        BeanUtils.copyProperties(booking, bookingEntity);
        return bookingRepository.save(bookingEntity);
    }

    @Override
    public List<Booking> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings;
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).get();

    }

    @Override
    public Booking acceptBooking(Long id, Booking book) {
        Booking booking = bookingRepository.findById(id).get();
        booking.setDriver(book.getDriver());
        booking.setStatus("Confirm");

        return bookingRepository.save(booking);
    }

}
