package com.assignment.gocheeta.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
// @Data
@Table(name = "booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickLocation;
    private String dropLocation;
    private String address;
    private int user_id;
    private int driver_id = 0;
    private int branch_id;
    private int vehicle_id = 0;
    private int vehicleCat_id;
    private float cost;
    private String status = "Pending";

    // @JsonIgnore
    // @ManyToMany(mappedBy = "branchBookings")
    // private Set<Branch> branches = new HashSet<>();

    // public Set<Branch> getBranches(){
    // return branches;
    // }

    // @JsonIgnore
    // @ManyToMany(mappedBy = "branchBookings")
    // private Set<Branch> branches = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "branchBookings")
    private Set<Branch> branches = new HashSet<>();

    public Booking(String pickLocation, String dropLocation, String address, int user_id, int driver_id,
            int branch_id, int vehicle_id, int vehicleCat_id, float cost, String status, Set<Branch> branches) {
        this.pickLocation = pickLocation;
        this.dropLocation = dropLocation;
        this.address = address;
        this.user_id = user_id;
        this.driver_id = driver_id;
        this.branch_id = branch_id;
        this.vehicle_id = vehicle_id;
        this.vehicleCat_id = vehicleCat_id;
        this.cost = cost;
        this.status = status;
        this.branches = branches;
    }

}
