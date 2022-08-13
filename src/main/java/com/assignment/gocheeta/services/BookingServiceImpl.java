package com.assignment.gocheeta.services;

import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.UserEntity;
import com.assignment.gocheeta.model.Booking;
import com.assignment.gocheeta.model.User;
import com.assignment.gocheeta.repository.BookingRepository;
import com.assignment.gocheeta.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService{
    private BookingRepository bookingRepository;

    private UserRepository userRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    

    @Override
    public Booking createBooking(Long userId, Long driverId) {
        UserEntity userEntity = userRepository.findById(userId).get();
        User user = new User(user)
        return null;
    }
}
