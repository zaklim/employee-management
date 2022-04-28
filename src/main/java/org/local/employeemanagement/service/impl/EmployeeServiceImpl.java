package org.local.employeemanagement.service.impl;

import org.local.employeemanagement.model.Employee;
import org.local.employeemanagement.repository.EmployeeRepository;
import org.local.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee updatedEmployee) {
        return findBy(id).map(employee -> {
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setIsNew(false);
            return save(employee);
        }).orElseGet(()-> {
            updatedEmployee.setId(id);
            return save(updatedEmployee);
        });
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findBy(Long id) {
        return employeeRepository.findById(id);
    }
}
