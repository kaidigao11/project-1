package com.revature.TicketingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.TicketingSystem.entity.Ticket;



@Repository
public interface TicketRepository extends JpaRepository <Ticket, Integer> {
    
    List<Ticket> findTicketsBySubmittedBy(Integer submittedBy);

} 