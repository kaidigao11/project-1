package com.revature.TicketingSystem.TestService;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.TicketingSystem.entity.Employee;
import com.revature.TicketingSystem.entity.Ticket;
import com.revature.TicketingSystem.repository.EmployeeRepository;
import com.revature.TicketingSystem.service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.NoSuchElementException;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    public EmployeeRepository employeeRepository;

    @InjectMocks
    public EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testContainsEmployee_Null() {
        Employee employee = new Employee("username", "password", false);

        Employee foundEmployee = employeeService.containsEmployee(employee.getUsername());
        assertEquals(null, foundEmployee);
        // assertEquals("username", foundEmployee.getUsername());
        // assertEquals("password", foundEmployee.getPassword());

    }

    @Test
    void testContainsEmployee_ExistingUser() {
        String username = "existingUser";
        Employee employee = new Employee();
        employee.setUsername(username);

        when(employeeRepository.findEmployeeByUsername(username)).thenReturn(employee);

        Employee result = employeeService.containsEmployee(username);

        assertNotNull(result);
        assertEquals(username, result.getUsername());
        verify(employeeRepository, times(2)).findEmployeeByUsername(username);
    }

    @Test
    void testCreateNewEmployee_ValidEmployee() {
        Employee employee = new Employee();
        employee.setUsername("newUser");
        employee.setPassword("securePassword");

        when(employeeRepository.findEmployeeByUsername(employee.getUsername())).thenReturn(null);
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee result = employeeService.createNewEmployee(employee);

        assertNotNull(result);
        assertEquals(employee.getUsername(), result.getUsername());
        verify(employeeRepository, times(1)).findEmployeeByUsername(employee.getUsername());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testCreateNewEmployee_InvalidEmployee() {
        Employee employee = new Employee();
        employee.setUsername(""); // Invalid username
        employee.setPassword("pw"); // Password too short

        Employee result = employeeService.createNewEmployee(employee);

        assertNull(result);
        verify(employeeRepository, never()).save(employee);
    }

    @Test
    void testLoginEmployee_ValidCredentials() {
        Employee employee = new Employee();
        employee.setUsername("validUser");
        employee.setPassword("validPassword");

        when(employeeRepository.findEmployeeByUsernameAndPassword(employee.getUsername(), employee.getPassword()))
                .thenReturn(employee);

        Employee result = employeeService.loginEmployee(employee);

        assertNotNull(result);
        assertEquals(employee.getUsername(), result.getUsername());
        verify(employeeRepository, times(1)).findEmployeeByUsernameAndPassword(employee.getUsername(),
                employee.getPassword());
    }

    @Test
    void testLoginEmployee_InvalidCredentials() {
        Employee employee = new Employee();
        employee.setUsername("invalidUser");
        employee.setPassword("wrongPassword");

        when(employeeRepository.findEmployeeByUsernameAndPassword(employee.getUsername(), employee.getPassword()))
                .thenReturn(null);

        Employee result = employeeService.loginEmployee(employee);

        assertNull(result);
        verify(employeeRepository, times(1)).findEmployeeByUsernameAndPassword(employee.getUsername(),
                employee.getPassword());
    }

}
