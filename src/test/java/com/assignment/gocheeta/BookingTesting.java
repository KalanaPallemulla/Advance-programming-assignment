package com.assignment.gocheeta;

import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.assignment.gocheeta.entity.Booking;
import com.assignment.gocheeta.repository.BookingRepository;
import com.assignment.gocheeta.services.BookingService;

@SpringBootTest
public class BookingTesting {
    @Autowired
    private BookingService bookingService;

    @MockBean
    private BookingRepository bookingRepository;

    public void getAllBookingsTest() {
        // when(bookingRepository.findAll())
        // .thenReturn(Stream.of(new Booking(1,"Kandy","Nugegoda", "Kandy", , 1, 1, 2,
        // 1, 1, 8000.0, "Finished"))
        // .collect(Collectors.toList()));
    }
}
