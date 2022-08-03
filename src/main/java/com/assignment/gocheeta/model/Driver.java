package com.assignment.gocheeta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    private long id;
    private String name;
    private String contactNo;
    private String username;
    private String branch;
}
