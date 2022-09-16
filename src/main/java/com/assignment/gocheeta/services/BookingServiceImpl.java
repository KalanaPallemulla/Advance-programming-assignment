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
        booking.setDriver_id(book.getDriver_id());
        booking.setStatus("Confirm");

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findUserAllBookings(Long id) {
        // List<Booking> booking = bookingRepository.findByUserId(id);
        return null;
    }

    @Override
    public Booking finishBooking(Long id) {
        Booking booking = bookingRepository.findById(id).get();
        booking.setStatus("Finished");
        return bookingRepository.save(booking);
    }

    @Override
    public Booking addVehicle(Long id, Booking booking) {
        Booking book = bookingRepository.findById(id).get();
        book.setVehicle_id(booking.getVehicle_id());
        return bookingRepository.save(book);
    }

}
