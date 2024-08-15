package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.projection.DepartmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name); // Find department by name

    // Projection methods
    @Query("SELECT d FROM Department d")
    List<DepartmentProjection> findAllProjectedBy();
    

}

