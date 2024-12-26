package com.revature.TicketingSystem.TestEntity;






import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.TicketingSystem.entity.Ticket;


@ExtendWith(MockitoExtension.class)
public class TicketTest {

    @Test
    void testDefaultContructor() {
        Ticket ticket = new Ticket();
        assertEquals(null, ticket.getTicketId());
        assertEquals(null, ticket.getSubmittedBy());
        assertEquals(null, ticket.getAmount());
        assertEquals(null, ticket.getTicketDescription());
        assertEquals(null, ticket.getTicketStatus());
        assertEquals(null, ticket.getTicketChangeable());
    }

    @Test
    void testFiveParamContructor() {
        Ticket ticket = new Ticket(1,1.0,"description","Pending",true);
        assertEquals(null, ticket.getTicketId());
        assertEquals(1, ticket.getSubmittedBy());
        assertEquals(1.0, ticket.getAmount());
        assertEquals("description", ticket.getTicketDescription());
        assertEquals("Pending", ticket.getTicketStatus());
        assertEquals(true, ticket.getTicketChangeable());
    }

    @Test
    void testAllParamContructor(){
        Ticket ticket = new Ticket(1,1,1.0,"description","Pending",true);
        assertEquals(1, ticket.getTicketId());
        assertEquals(1, ticket.getSubmittedBy());
        assertEquals(1.0, ticket.getAmount());
        assertEquals("description", ticket.getTicketDescription());
        assertEquals("Pending", ticket.getTicketStatus());
        assertEquals(true, ticket.getTicketChangeable());
    }
    
    @Test 
    void testGettersandSetters() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setSubmittedBy(1);
        ticket.setAmount(1.0);
        ticket.setTicketDescription("description");
        ticket.setTicketStatus("Pending");
        ticket.setTicketChangeable(true);


        assertEquals(1, ticket.getTicketId());
        assertEquals(1, ticket.getSubmittedBy());
        assertEquals(1.0, ticket.getAmount());
        assertEquals("description", ticket.getTicketDescription());
        assertEquals("Pending", ticket.getTicketStatus());
        assertEquals(true, ticket.getTicketChangeable());

    }
    
}
