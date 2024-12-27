import React, { useContext, useState } from "react";
import TicketComponent from "./TicketComponent";
import ViewPastTicketsComponent from "./ViewPastTicketsComponent";
import { Link, useNavigate } from "react-router-dom";
import { EmployeeContext } from "../Contexts/UserContext";
import axios from "axios";

function EmployeePageComponent() {
  const context = useContext(EmployeeContext);
  const navigate = useNavigate();
  const [amount, setAmount] = useState(0);
  const [ticketDescription, setTicketDescription] = useState("");
  if (!context) {
    throw new Error("Employee info must be used within a user provider");
  }

  function handleSubmitTicket(e: any) {
    e.preventDefault();
    axios
      .post("http://localhost:8080/tickets", {
        submittedBy: context?.employee?.employeeId,
        amount,
        ticketDescription,
        ticketStatus: "Pending",
        ticketChangeable: true,
      })
      .then((response) => {
        alert("ticket submitted successfully");
        setAmount(0);
        setTicketDescription("");
      })
      .catch((error) => {
        alert("ticket did not get posted");
      });
  }

  return (
    <>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <button
          onClick={() => {
            context.logout();
            navigate("/");
          }}
        >
          Logout
        </button>
       
      </nav> 
      <strong style={{fontSize: "40px"}}>Welcome {context.employee?.username}!</strong>
      <p>Submit your ticket reimbursement</p>
      <TicketComponent amount={amount} setAmount={setAmount} ticketDescription={ticketDescription} setTicketDescription={setTicketDescription} handleSubmit={handleSubmitTicket}/>
      <br />
      <ViewPastTicketsComponent />
    </>
  );
}

export default EmployeePageComponent;
