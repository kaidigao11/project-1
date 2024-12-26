package com.revature.TicketingSystem.TestService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.TicketingSystem.entity.Ticket;
import com.revature.TicketingSystem.repository.TicketRepository;
import com.revature.TicketingSystem.service.TicketService;

class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateNewTicket_ValidTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketDescription("Valid description");
        ticket.setSubmittedBy(1);

        when(ticketRepository.save(ticket)).thenReturn(ticket);

        Ticket result = ticketService.createNewTicket(ticket);

        assertNotNull(result);
        assertEquals("Valid description", result.getTicketDescription());
        verify(ticketRepository, times(1)).save(ticket);
    }

    @Test
    void testCreateNewTicket_InvalidTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketDescription(""); // Invalid description
        ticket.setSubmittedBy(-1); // Invalid submittedBy

        Ticket result = ticketService.createNewTicket(ticket);

        assertNull(result);
        verify(ticketRepository, never()).save(ticket);
    }

    @Test
    void testGetAllTickets() {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();

        when(ticketRepository.findAll()).thenReturn(Arrays.asList(ticket1, ticket2));

        List<Ticket> result = ticketService.getAllTickets();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(ticketRepository, times(1)).findAll();
    }

    @Test
    void testGetTicketById_ExistingId() {
        Integer ticketId = 1;
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketId);

        when(ticketRepository.findById(ticketId)).thenReturn(Optional.of(ticket));

        Ticket result = ticketService.getTicketById(ticketId);

        assertNotNull(result);
        assertEquals(ticketId, result.getTicketId());
        verify(ticketRepository, times(2)).findById(ticketId);
    }

    @Test
    void testGetTicketById_NonExistingId() {
        Integer ticketId = 1;

        when(ticketRepository.findById(ticketId)).thenReturn(Optional.empty());

        Ticket result = ticketService.getTicketById(ticketId);

        assertNull(result);
        verify(ticketRepository, times(1)).findById(ticketId);
    }

    @Test
    void testDeleteTicketById_ExistingId() {
        Integer ticketId = 1;
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketId);

        when(ticketRepository.findById(ticketId)).thenReturn(Optional.of(ticket));

        Integer result = ticketService.deleteTicketById(ticketId);

        assertEquals(1, result);
        verify(ticketRepository, times(1)).deleteById(ticketId);
    }

    @Test
    void testDeleteTicketById_NonExistingId() {
        Integer ticketId = 1;

        when(ticketRepository.findById(ticketId)).thenReturn(Optional.empty());

        Integer result = ticketService.deleteTicketById(ticketId);

        assertEquals(0, result);
        verify(ticketRepository, never()).deleteById(ticketId);
    }

    @Test
    void testUpdateTicketById_ExistingId() {
        Integer ticketId = 1;
        String newStatus = "In Progress";
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketId);
        ticket.setTicketStatus("Open");

        when(ticketRepository.findById(ticketId)).thenReturn(Optional.of(ticket));

        Integer result = ticketService.updateTicketById(ticketId, newStatus);

        assertEquals(1, result);
        assertEquals(newStatus, ticket.getTicketStatus());
        verify(ticketRepository, times(1)).save(ticket);
    }

    @Test
    void testUpdateTicketById_NonExistingId() {
        Integer ticketId = 1;
        String newStatus = "In Progress";

        when(ticketRepository.findById(ticketId)).thenReturn(Optional.empty());

        Integer result = ticketService.updateTicketById(ticketId, newStatus);

        assertEquals(0, result);
        verify(ticketRepository, never()).save(any(Ticket.class));
    }

    @Test
    void testGetAllTicketsBySubmittedBy() {
        Integer submittedBy = 1;
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();

        when(ticketRepository.findTicketsBySubmittedBy(submittedBy)).thenReturn(Arrays.asList(ticket1, ticket2));

        List<Ticket> result = ticketService.getAllTicketsBySubmittedBy(submittedBy);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(ticketRepository, times(1)).findTicketsBySubmittedBy(submittedBy);
    }
}
