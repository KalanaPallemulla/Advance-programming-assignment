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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.assignment.gocheeta.entity.User;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_bookings", joinColumns = {
            @JoinColumn(name = "branch_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            })
    private Set<User> branchBookings = new HashSet<>();

    public void branchBookings(User userEntity) {
        branchBookings.add(userEntity);
    }

}
