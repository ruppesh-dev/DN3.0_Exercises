package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;
import com.example.EmployeeManagementSystem.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long departmentId); // Find employees by department ID
    Employee findByEmail(String email); // Find employee by email
    
    // Pagination and sorting method
    Page<Employee> findAll(Pageable pageable);
    
    // Projection methods
    @Query("SELECT e FROM Employee e")
    List<EmployeeProjection> findAllProjectedBy();

    // Fetching employee data as DTOs
    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeDto(e.id, e.name, e.email) FROM Employee e")
    List<EmployeeDto> findAllEmployeeDtos();
    

}
