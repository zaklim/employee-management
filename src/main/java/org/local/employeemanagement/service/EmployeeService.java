package org.local.employeemanagement.service;

import org.local.employeemanagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findBy(Long id);

    Employee save(Employee employee);

    Employee update(Long id, Employee employee);

    void delete(Long id);
}
