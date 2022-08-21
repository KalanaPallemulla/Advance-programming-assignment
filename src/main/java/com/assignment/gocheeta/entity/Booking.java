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
    private Long user;
    private Long driver;
    private Long branch;
    private String status = "Pending";

    // public Booking(String pick, String drip, Long user, Long driver) {
    // this.pick = pick;
    // this.drip = drip;
    // this.user = user;
    // this.driver = driver;
    // }

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

}
