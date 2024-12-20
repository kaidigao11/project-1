package com.revature.TicketingSystem.controller;

import org.springframework.web.bind.annotation.RestController;

import com.revature.TicketingSystem.entity.Employee;
import com.revature.TicketingSystem.entity.Ticket;
import com.revature.TicketingSystem.service.EmployeeService;
import com.revature.TicketingSystem.service.TicketService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class TicketingSystemController {
    EmployeeService employeeService;
    TicketService ticketService;

    public TicketingSystemController(EmployeeService employeeService, TicketService ticketService){
        this.employeeService = employeeService;
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity createNewEmployeeHandler(@RequestBody Employee newEmployee) {
        if (newEmployee.getUsername() !="" && newEmployee.getPassword().length()>4 && employeeService.containsEmployee(newEmployee.getUsername())==null) {
            Employee resultEmployee = employeeService.createNewEmployee(newEmployee);
            return ResponseEntity.status(200).body(resultEmployee);
        }
        return ResponseEntity.status(400).body(null);

    }

    @PostMapping(value = "/login")
    public ResponseEntity loginEmployeeHandler(@RequestBody Employee newEmployee) {
        Employee resultEmployee = employeeService.loginEmployee(newEmployee);
        if (resultEmployee !=null) {
            return ResponseEntity.status(200).body(resultEmployee);
        }
        return ResponseEntity.status(401).body(null);
    }

  
    @PostMapping(value="/tickets")
    public ResponseEntity createNewTicketHandler(@RequestBody Ticket newTicket) {
        Ticket resultTicket = ticketService.createNewTicket(newTicket);
        if (resultTicket !=null) {
            return ResponseEntity.status(200).body(resultTicket);
        }
        return ResponseEntity.status(400).body(null);
    }
    

    // for the admin
    @GetMapping(value="/tickets")
    public ResponseEntity getAllTicketsHandler() {
        List<Ticket> allTickets = ticketService.getAllTickets();
        return ResponseEntity.status(200).body(allTickets);
        
    }
    

    @PatchMapping(value="/tickets/{ticketId}") 
    public ResponseEntity updateTicketByIdHandler(@PathVariable Integer ticketId, @RequestBody Ticket ticketToChange){
        Integer rowsUpdated = ticketService.updateTicketById(ticketId, ticketToChange.getTicketStatus());
        if (rowsUpdated > 0) {
            return ResponseEntity.status(200).body(rowsUpdated);
        }
        return ResponseEntity.status(400).body(null);
    }

    // get tickets by employee id
    @GetMapping(value="/tickets/{submittedBy}")
    public ResponseEntity getAllTicketsBySubmittedBy(@PathVariable Integer submittedBy) {
        List<Ticket> allTicketsByEmployee = ticketService.getAllTicketsBySubmittedBy(submittedBy);
        return ResponseEntity.status(200).body(allTicketsByEmployee);
    }
    
  

    
    
    

}
