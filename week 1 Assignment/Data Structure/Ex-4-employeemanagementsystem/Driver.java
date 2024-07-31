package company.employee_management;

public class Driver {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(2); // Initial capacity of 2

        // Add employees
        manager.addEmployee(new Employee(1, "John Doe", "Software Engineer", 75000.00));
        manager.addEmployee(new Employee(2, "Jane Smith", "Senior Software Engineer", 90000.00));
        manager.addEmployee(new Employee(3, "Bob Johnson", "Project Manager", 105000.00)); // Triggers array resize

        // Display all employees
        System.out.println("Current Employees:");
        manager.displayEmployees();

        // Search for an employee
        Employee searchedEmployee = manager.searchEmployeeById(2);
        System.out.println("\nSearched Employee Details:");
        if (searchedEmployee != null) {
            System.out.println(searchedEmployee);
        } else {
            System.out.println("Employee not located.");
        }

        // Delete an employee
        boolean isDeleted = manager.deleteEmployeeById(2);
        System.out.println("\nDeletion Status: " + (isDeleted ? "Employee successfully removed." : "Employee not located."));

        // Display all employees after deletion
        System.out.println("\nEmployees after removal:");
        manager.displayEmployees();
    }
}
