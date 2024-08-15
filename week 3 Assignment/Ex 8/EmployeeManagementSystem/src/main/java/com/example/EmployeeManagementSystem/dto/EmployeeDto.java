package com.example.EmployeeManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeDto {
    private Long id; // Add the ID if you want to include it
    private String name;
    private String email;
}
