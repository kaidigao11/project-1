package com.revature.TicketingSystem.TestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.TicketingSystem.controller.TicketingSystemController;
import com.revature.TicketingSystem.entity.Employee;
import com.revature.TicketingSystem.entity.Ticket;
import com.revature.TicketingSystem.service.EmployeeService;
import com.revature.TicketingSystem.service.TicketService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;


@WebMvcTest(TicketingSystemController.class)
public class TicketingSystemControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private EmployeeService employeeService;

    @MockitoBean
    private TicketService ticketService;

    @Test
    void testCreateNewEmployeeHandler() throws Exception {


        // Employee newEmployee = new Employee(null, "username", "password", false);
        // String json = objectMapper.writeValueAsString(newEmployee);

        // mockMvc.perform(post("/register").contentType("application/json").content(json))
        //         .andExpect(status().isOk())
        //         .andExpect(jsonPath("$.username").value("username"))
        //         .andExpect(jsonPath("$.password").value("password"));
    }

    @Test
    void testCreateNewEmployeeHandler_Success() throws Exception {
        Employee newEmployee = new Employee(1, "username", "password",false);
        Mockito.when(employeeService.createNewEmployee(any(Employee.class))).thenReturn(newEmployee);

        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "{\"username\":\"username\",\"password\":\"password\",\"isAdmin\":\"false\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("username"));
    }

    @Test
    void testLoginEmployeeHandler_Success() throws Exception {
        Employee existingEmployee = new Employee(1, "username", "password",false);
        Mockito.when(employeeService.loginEmployee(any(Employee.class))).thenReturn(existingEmployee);

        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"username\",\"password\":\"password\",\"isAdmin\":\"false\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("username"));
    }


    @Test
    void testCreateNewTicketHandler_Success() throws Exception {
        Ticket newTicket = new Ticket(1, 1, 1.0, "Description", "Pending", true);
        Mockito.when(ticketService.createNewTicket(any(Ticket.class))).thenReturn(newTicket);

        mockMvc.perform(post("/tickets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "{\"submittedBy\":\"1\",\"amouont\":\"1.0\",\"description\":\"Description\",\"ticketStatus\":\"Pending\",\"ticketChangeable\":\"true\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ticketId").value("1"));
    }

    @Test
    void testGetAllTicketsHandler_Success() throws Exception {
        Ticket ticket1 = new Ticket(1, 1, 1.0, "Description", "Pending", true);
        Ticket ticket2 = new Ticket(2, 2, 2.0, "Description", "Pending", true);
        Mockito.when(ticketService.getAllTickets()).thenReturn(Arrays.asList(ticket1, ticket2));

        mockMvc.perform(get("/tickets")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testUpdateTicketByIdHandler_Success() throws Exception {
        Mockito.when(ticketService.updateTicketById(eq(1), eq("Approved"))).thenReturn(1);

        mockMvc.perform(patch("/tickets/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"ticketStatus\":\"Approved\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void testGetAllTicketsBySubmittedBy_Success() throws Exception {
        Ticket ticket1 = new Ticket(1, 1, 1.0, "Description", "Pending", true);
        Ticket ticket2 = new Ticket(2, 1, 1.0, "Description", "Pending", true);
        Mockito.when(ticketService.getAllTicketsBySubmittedBy(1)).thenReturn(Arrays.asList(ticket1, ticket2));

        mockMvc.perform(get("/tickets/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    } 
} 
