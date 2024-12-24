import React, { useContext, useEffect, useState } from "react";
import { EmployeeContext } from "../Contexts/UserContext";
import axios from "axios";
import { logDOM } from "@testing-library/react";

export type TicketData = {
  ticketId: number;
  submittedBy: string;
  amount: number;
  ticketDescription: string;
  ticketStatus: string;
  ticketChangeable: boolean;
};

function ViewPastTicketsComponent() {
  const context = useContext(EmployeeContext);
  const [data, setData] = useState<TicketData[]>([]);
  const [loading, setLoading] = useState(false);

   useEffect(() => {
    axios
      .get(`http://localhost:8080/tickets/${context?.employee?.employeeId}`)
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => console.error("Error getting data, ", error));
  },[loading])

  return (
    <>

      <br></br>
      {!loading ? <button onClick={()=>setLoading(!loading)}>Show past tickets</button> : <button onClick={()=>setLoading(!loading)}>Collapse</button>}
      {loading && 
        (data.map((item:any) => {
          return(
            <ul>
              <li key={item.ticketId}><p>Ticket ID: {item.ticketId}</p></li>
              <li><p>Submitted By (Employee number): {item.submittedBy}</p></li>
              <li><p>Amount: {item.amount}</p></li>
              <li><p>Description: {item.ticketDescription}</p></li>
              <li><p>Status: {item.ticketStatus}</p></li>
              <br></br>
            </ul>
          )
        })) 
      } 
    </>
  );
}

export default ViewPastTicketsComponent;
