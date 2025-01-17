import axios from "axios";
import React, { useContext, useEffect, useState } from "react";
import { TicketData } from "../EmployeePage/ViewPastTicketsComponent";
import { TicketContext } from "../Contexts/TicketContext";

function ViewActiveTicketsComponent() {
  const [data, setData] = useState<TicketData[]>([]);
  const [visible, setVisible] = useState(false);
  const context = useContext(TicketContext);

  if (!context) {
    throw new Error("admin page must be used in ticket context");
  }

  useEffect(() => {
    axios
      .get(`http://localhost:8080/tickets`)
      .then((response) => {
        setData(response.data);
        context.createTicket(
          response.data.ticketId,
          response.data.submittedBy,
          response.data.amount,
          response.data.ticketDescription,
          response.data.ticketStatus,
          true
        );
      })
      .catch((error) => console.error("Error getting data, ", error));
  }, [visible]);

  function handleApprove(ticketId:number) {
    axios
      .patch(`http://localhost:8080/tickets/${ticketId}`, {
        ticketStatus: "Approved"
      })
      .then((response) => {
        alert(`You have APPROVED ticket number: ${ticketId}`);
      })
      .catch((error) => console.error("Error patching data, ", error));
  }

  function handleDeny(ticketId:number) {
    axios
      .patch(`http://localhost:8080/tickets/${ticketId}`, {
        ticketStatus: "Denied"
      })
      .then((response) => {
        alert(`You have DENIED ticket number: ${ticketId}`);
      })
      .catch((error) => console.error("Error patching data, ", error));
  }

  return (
    <>
      {visible ? (
        <button onClick={() => setVisible(!visible)}>Collapse</button>
      ) : (
        <button onClick={() => setVisible(!visible)}>
          show all pending tickets
        </button>
      )}
      {visible &&
        (data.filter((item) => item.ticketStatus === "Pending").length > 0 ? (
          data
            .filter((item) => item.ticketStatus === "Pending")
            .map((mapItem) => {
                
              return (
                <div key={mapItem.ticketId}>
                  <table className="table table-bordered">
              <thead>
                <tr>
                  <th>Ticket ID</th>
                  <th>Submitted By</th>
                  <th>Amount</th>
                  <th>Description</th>
                  <th>Status</th>
                </tr>
              </thead>
              <tbody>
                <td>{mapItem.ticketId}</td>
                <td>{mapItem.submittedBy}</td>
                <td>{mapItem.amount}</td>
                <td>{mapItem.ticketDescription}</td>
                <td>
                <button onClick={() => handleApprove(mapItem.ticketId )}>Approve</button>
                <button onClick={() => handleDeny(mapItem.ticketId)}>Deny</button>
                </td>
              </tbody>
            </table>
                </div>
              


              );
            })
        ) : 
          <p>No pending tickets</p>
        )}
    </>
  );
}

export default ViewActiveTicketsComponent;
