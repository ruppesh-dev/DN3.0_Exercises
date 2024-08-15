package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long departmentId); // Find employees by department ID
    Employee findByEmail(String email); // Find employee by email
    List<Employee> findByNameContaining(String name); // Find employees by name containing a substring

    @Query("SELECT e FROM Employee e WHERE e.department.id = ?1")
    List<Employee> findEmployeesByDepartmentId(Long departmentId);
    
    @Query(name = "Employee.findByName")
    List<Employee> findByName(@Param("name") String name);
}
