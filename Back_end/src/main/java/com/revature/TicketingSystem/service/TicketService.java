package com.revature.TicketingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.TicketingSystem.entity.Ticket;
import com.revature.TicketingSystem.repository.TicketRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class TicketService {
    TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Ticket createNewTicket(Ticket ticket){
        if (ticket.getTicketDescription() != "" && ticket.getTicketDescription().length() <= 255 && ticket.getSubmittedBy() > -1) {
            return ticketRepository.save(ticket);
        }
        return null;
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Integer ticketId){
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (ticketOptional.isPresent()) {
            return ticketRepository.findById(ticketId).get();
        }
        return null;
    }

    public Integer deleteTicketById(Integer ticketId){
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (ticketOptional.isPresent()) {
            ticketRepository.deleteById(ticketId);
            return 1;
        }
        return 0;
    }

    public Integer updateTicketById(Integer ticketId, String ticketStatus){
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (ticketOptional.isPresent()) {
            Ticket persistedTicket = ticketOptional.get();
            persistedTicket.setTicketStatus(ticketStatus);
            ticketRepository.save(persistedTicket);
            return 1;
        }
        return 0;
    }

    public List<Ticket> getAllTicketsBySubmittedBy (Integer submittedBy) {
        return ticketRepository.findTicketsBySubmittedBy(submittedBy);
    }



}
