package com.revature.TicketingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.TicketingSystem.entity.Employee;
import com.revature.TicketingSystem.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.extern.java.Log;

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
        if (employee.getUsername() !="" && employee.getPassword().length()>3 && containsEmployee(employee.getUsername())==null) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    public Employee loginEmployee(Employee employee){

        return employeeRepository.findEmployeeByUsernameAndPassword(employee.getUsername(), employee.getPassword());

    }




}
