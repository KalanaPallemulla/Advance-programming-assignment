package com.assignment.gocheeta.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
// @Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int catId;
    private int seats;
    private int branch_id;
    private int status = 0;
    private String[] driver_ids;

    // @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "vehicleCategory_id", referencedColumnName = "id")
    // private VehicleCategory vehicleCategory;

}
