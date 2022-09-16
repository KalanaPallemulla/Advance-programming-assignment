package com.assignment.gocheeta.entity;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "drivers")
@Getter
@Setter
// @Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;
    private String contactNo;
    private String username;
    private int branch_id;
    private int status = 0;

    // @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "branch_id", referencedColumnName = "id")
    // private Branch branch;

    // public Branch getBranch() {
    // return branch_id;
    // }

    // public void assignDriver(Branch branch) {
    // this.branch = branch;
    // }

}
