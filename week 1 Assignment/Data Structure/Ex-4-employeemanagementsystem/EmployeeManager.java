package company.employee_management;

public class EmployeeManager {
    private Employee[] employeeArray;
    private int size;

    // Constructor
    public EmployeeManager(int initialCapacity) {
        employeeArray = new Employee[initialCapacity];
        size = 0;
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        try {
            if (size >= employeeArray.length) {
                // Resize the array if needed
                Employee[] newArray = new Employee[employeeArray.length * 2];
                System.arraycopy(employeeArray, 0, newArray, 0, employeeArray.length);
                employeeArray = newArray;
            }
            employeeArray[size] = employee;
            size++;
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    // Method to search for an employee by ID
    public Employee searchEmployeeById(int employeeId) {
        try {
            for (int i = 0; i < size; i++) {
                if (employeeArray[i].getEmployeeId() == employeeId) {
                    return employeeArray[i];
                }
            }
            return null; // Employee not found
        } catch (Exception e) {
            System.out.println("Error searching for employee: " + e.getMessage());
            return null;
        }
    }

    // Method to traverse and display all employees
    public void displayEmployees() {
        try {
            for (int i = 0; i < size; i++) {
                System.out.println(employeeArray[i]);
            }
        } catch (Exception e) {
            System.out.println("Error displaying employees: " + e.getMessage());
        }
    }

    // Method to delete an employee by ID
    public boolean deleteEmployeeById(int employeeId) {
        try {
            int indexToDelete = -1;
            for (int i = 0; i < size; i++) {
                if (employeeArray[i].getEmployeeId() == employeeId) {
                    indexToDelete = i;
                    break;
                }
            }
            if (indexToDelete == -1) {
                return false; // Employee not found
            }
            // Shift elements to the left to fill the gap
            for (int i = indexToDelete; i < size - 1; i++) {
                employeeArray[i] = employeeArray[i + 1];
            }
            employeeArray[size - 1] = null; // Clear the last element
            size--;
            return true; // Employee successfully deleted
        } catch (Exception e) {
            System.out.println("Error deleting employee: " + e.getMessage());
            return false;
        }
    }
}
