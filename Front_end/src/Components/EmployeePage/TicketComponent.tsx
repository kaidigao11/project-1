import React, { useContext, useEffect } from 'react'
import { EmployeeContext } from '../Contexts/UserContext'
import axios from 'axios';
import { error } from 'console';

type TicketInputProps = 
{amount: number, setAmount: React.Dispatch<React.SetStateAction<number>>, ticketDescription: string, setTicketDescription: React.Dispatch<React.SetStateAction<string>>, handleSubmit: any };

function TicketComponent({amount, setAmount, ticketDescription, setTicketDescription, handleSubmit} : TicketInputProps) {
  


  return (
    <>
    <form style={{display: "block" , width: "50"}} onSubmit={handleSubmit}>
        <label>Amount: </label>
        <input
        className="form-control-sm"
          type="text"
          placeholder="amount"
          value={amount}
          onChange={(e: any) => setAmount(e.target.value)}
        />
        <br />
        <label>Description:</label>
        <input
        className="form-control-sm"
          type="text"
          placeholder="description"
          value={ticketDescription}
          onChange={(e: any) => setTicketDescription(e.target.value)}
        />
        <br />
        <button style={{marginTop:"2px"}} type="submit" className="btn btn-primary">Submit</button>
      </form>
    
    </>
  )
}

export default TicketComponent