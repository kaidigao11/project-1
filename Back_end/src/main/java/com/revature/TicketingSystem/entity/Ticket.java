package com.revature.TicketingSystem.entity;


import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;

@Entity
@Table(name="ticket")
public class Ticket {
    @Autowired
    @Column(name="ticketId")
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketId;

    @Column(name="submittedBy")
    private Integer submittedBy;

    @Column(name="amount")
    private Double amount;

    @Column(name="ticketDescription")
    private String ticketDescription;

    @Column(name="ticketStatus")
    private String ticketStatus;

    @Column(name="ticketChangeable")
    private Boolean ticketChangeable;

    public Ticket(){

    }

    @Autowired
    public Ticket(Integer submittedBy, Double amount, String ticketDescription, String ticketStatus, Boolean ticketChangeable){
        this.submittedBy = submittedBy;
        this.amount = amount;
        this.ticketDescription = ticketDescription;
        this.ticketStatus = ticketStatus;
        this.ticketChangeable = ticketChangeable;
    }

    @Autowired
    public Ticket(Integer ticketId, Integer submittedBy, Double amount, String ticketDescription, String ticketStatus, Boolean ticketChangeable){
        this.ticketId = ticketId;
        this.submittedBy = submittedBy;
        this.amount = amount;
        this.ticketDescription = ticketDescription;
        this.ticketStatus = ticketStatus;
        this.ticketChangeable = ticketChangeable;
    }

    // ticket id getter
    public Integer getTicketId() {
        return ticketId;
    }
    
    // ticket id setter
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    // submit by getter
    public Integer getSubmittedBy(){
        return submittedBy;
    }

    // submit by setter
    public void setSubmittedBy(Integer submittedBy){
        this.submittedBy = submittedBy;
    }

    // amount getter
    public Double getAmount() {
        return amount;
    }
    
    // amount setter
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    // ticketDescription getter
    public String getTicketDescription() {
        return ticketDescription;
    }
    
    // ticketDescription setter
    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    // ticketStatus getter
    public String getTicketStatus() {
        return ticketStatus;
    }
    
    // ticket status setter
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    // ticketchangeable getter
    public Boolean getTicketChangeable() {
        return ticketChangeable;
    }
    
    // ticketchangable setter
    public void setEmployeeId(Boolean ticketChangeable) {
        this.ticketChangeable = ticketChangeable;
    }

    /*
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (ticketId == null) {
			if (other.ticketId != null)
				return false;
		} else if (!ticketId.equals(other.ticketId))
			return false;
        if (amount == null) {
            if (other.amount != null)
                return false;
        } else if (!amount.equals(other.amount))
            return false;
		if (ticketDescription == null) {
			if (other.ticketDescription != null)
				return false;
		} else if (!ticketDescription.equals(other.ticketDescription))
			return false;
		if (ticketStatus == null) {
			if (other.ticketStatus != null)
				return false;
		} else if (!ticketStatus.equals(other.ticketStatus))
			return false;
        if (ticketChangeable == false && other.ticketChangeable == true) {
            return false;
        }
        if (ticketChangeable == true && other.ticketChangeable == false) {
            return false;
        }
		return true;
	}

 */


}

