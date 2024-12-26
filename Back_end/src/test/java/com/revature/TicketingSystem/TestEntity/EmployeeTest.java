package com.revature.TicketingSystem.TestEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.TicketingSystem.entity.Employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeTest {
    @Test
    void testDefaultContructor() {
        Employee employee = new Employee();
        assertEquals(null, employee.getEmployeeId());
        assertEquals(null, employee.getUsername());
        assertEquals(null, employee.getPassword());
        assertEquals(null, employee.getIsAdmin());
    }

    @Test
    void testThreeParamContructor() {
        Employee employee = new Employee("username","password",false);
        assertEquals(null, employee.getEmployeeId());
        assertEquals("username", employee.getUsername());
        assertEquals("password", employee.getPassword());
        assertEquals(false, employee.getIsAdmin());
    }

    @Test
    void testAllParamContructor(){
        Employee employee = new Employee(1,"username","password",false);
        assertEquals(1, employee.getEmployeeId());
        assertEquals("username", employee.getUsername());
        assertEquals("password", employee.getPassword());
        assertEquals(false, employee.getIsAdmin());
    }
    
    @Test 
    void testGettersandSetters() {
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setUsername("username");
        employee.setPassword("password");
        employee.setIsAdmin(false);

        assertEquals(1, employee.getEmployeeId());
        assertEquals("username", employee.getUsername());
        assertEquals("password", employee.getPassword());
        assertEquals(false, employee.getIsAdmin());

    }

    @Test
    void testIsEquals() {
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setUsername("username");
        employee.setPassword("password");
        employee.setIsAdmin(false);

        Employee employee2 = new Employee();
        employee2.setEmployeeId(1);
        employee2.setUsername("username");
        employee2.setPassword("password");
        employee2.setIsAdmin(false);
        assertEquals(false, employee.equals(employee2));
        
    }

}
