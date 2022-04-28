package org.local.employeemanagement.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Could not find Employee with id " + id);
    }
}
