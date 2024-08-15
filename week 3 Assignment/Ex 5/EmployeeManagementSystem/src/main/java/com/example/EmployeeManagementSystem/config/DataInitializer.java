package com.example.EmployeeManagementSystem.config;

import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @PostConstruct
    public void init() {
        Department department = new Department();
        department.setName("IT");
        departmentRepository.save(department);

        Employee employee1 = new Employee();
        employee1.setName("ruppesh");
        employee1.setEmail("ruppesh.22@example.com");
        employee1.setDepartment(department);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName("yokesh");
        employee2.setEmail("yokesh.11@example.com");
        employee2.setDepartment(department);
        employeeRepository.save(employee2);
    }
}

