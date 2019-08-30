package com.department.model;

import lombok.*;

/**
 * Department type objects
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
    private int departmentId;
    private String departmentName;
}
