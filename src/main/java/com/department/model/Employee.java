package com.department.model;

import lombok.*;

/**
 * Employee type objects
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int departmentID;
}
