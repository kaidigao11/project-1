package com.revature.TicketingSystem.service;

import org.springframework.stereotype.Service;

import com.revature.TicketingSystem.entity.Employee;
import com.revature.TicketingSystem.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    public Employee containsEmployee(String username){
        if (employeeRepository.findEmployeeByUsername(username) != null) {
            return employeeRepository.findEmployeeByUsername(username);
        }
        return null;
    }

    public Employee createNewEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee loginEmployee(Employee employee){
        return employeeRepository.findEmployeeByUsernameAndPassword(employee.getUsername(), employee.getPassword());
    }




}
