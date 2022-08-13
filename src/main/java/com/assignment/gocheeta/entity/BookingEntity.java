package com.assignment.gocheeta.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.assignment.gocheeta.model.Driver;
import com.assignment.gocheeta.model.User;

import lombok.Data;


@Entity
@Data
@Table(name="bookings")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private User user;
    private Driver driver;
}
