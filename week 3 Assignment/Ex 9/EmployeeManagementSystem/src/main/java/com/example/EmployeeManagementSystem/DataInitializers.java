	package com.example.EmployeeManagementSystem;
	
	import com.example.EmployeeManagementSystem.model.Employee;
	import com.example.EmployeeManagementSystem.model.Department;
	import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
	import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.stereotype.Component;
	import org.springframework.transaction.annotation.Transactional;

	@Component
	public class DataInitializers implements CommandLineRunner {

	    @Autowired
	    private EmployeeRepository employeeRepository;

	    @Autowired
	    private DepartmentRepository departmentRepository;

	    @Override
	    @Transactional
	    public void run(String... args) throws Exception {
	        // Initialize Departments
	        Department hr = new Department();
	        hr.setName("HR");
	        departmentRepository.save(hr);

	        Department it = new Department();
	        it.setName("IT");
	        departmentRepository.save(it);

	        // Initialize Employees
	        Employee emp1 = new Employee();
	        emp1.setFirstName("ram");
	        emp1.setLastName("sita");
	        emp1.setEmail("ramsita@gmail.com");
	        emp1.setDepartment(hr);
	        employeeRepository.save(emp1);

	        Employee emp2 = new Employee();
	        emp2.setFirstName("kabar");
	        emp2.setLastName("Khan");
	        emp2.setEmail("kabarkhan@example.com");
	        emp2.setDepartment(it);
	        employeeRepository.save(emp2);

	        System.out.println("Departments:");
	        departmentRepository.findAll().forEach(department ->
	            System.out.println(department.getName())
	        );

	        System.out.println("\nEmployees:");
	        employeeRepository.findAll().forEach(employee -> 
	            System.out.println(employee.getFirstName() + " " + employee.getLastName() + " - " + employee.getDepartment().getName())
	        );
	    }
	}