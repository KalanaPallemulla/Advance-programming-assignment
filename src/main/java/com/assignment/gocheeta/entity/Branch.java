package com.assignment.gocheeta.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.assignment.gocheeta.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "branches")
@Getter
@Setter
// @Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // @ManyToMany
    // @JoinTable(
    // name = "user_bookings",
    // joinColumns = @JoinColumn(name="branch_id"),
    // inverseJoinColumns = @JoinColumn(name="user_id")
    // )
    // private Set<User> branchBookings = new HashSet<>();

    // public Set<User> getBranchBookings(){
    // return branchBookings;
    // }
    // // public void getBranchBookings(User user) {
    // // branchBookings.add(user);
    // // }

    // public void branchBookings(User userEntity) {
    // branchBookings.add(userEntity);

    // }
    @ManyToMany
    @JoinTable(name = "user_bookings", joinColumns = @JoinColumn(name = "branch_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<Booking> branchBookings = new HashSet<>();

    public void branchBookings(Booking booking) {
        branchBookings.add(booking);
    }
    // public void branchBookings(Booking booking) {
    // branchBookings.add(userEntity);
    // }

    @JsonIgnore
    @OneToMany(mappedBy = "branch")
    private Set<Driver> drivers = new HashSet<>();

    public Set<Driver> getDrivers() {
        return drivers;
    }

}
