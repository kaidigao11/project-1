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
  }, [loading]);

  return (
    <>
      <br></br>
      {!loading ? (
        <button onClick={() => setLoading(!loading)}>Show past tickets</button>
      ) : (
        <button onClick={() => setLoading(!loading)}>Collapse</button>
      )}
      {loading && (data.length>0? (data.map((item: any) => {
          return (
            <table className="table table-bordered">
              <thead>
                <tr>
                  <th>Ticket ID</th>
                  <th>Amount</th>
                  <th>Description</th>
                  <th>Status</th>
                </tr>
              </thead>
              <tbody>
                <td>{item.ticketId}</td>
                <td>{item.amount}</td>
                <td>{item.ticketDescription}</td>
                <td>{item.ticketStatus}</td>
              </tbody>
            </table>
          );
        })) : <p>You have no past tickets.</p>)}
    </>
  );
}

export default ViewPastTicketsComponent;