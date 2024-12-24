import React, { useContext } from "react";
import TicketComponent from "./TicketComponent";
import ViewPastTicketsComponent from "./ViewPastTicketsComponent";
import { Link, useNavigate } from "react-router-dom";
import { EmployeeContext } from "../../Contexts/UserContext";

function EmployeePageComponent() {
  const context = useContext(EmployeeContext);
  const navigate = useNavigate();
  if (!context) {
    throw new Error("Employee info must be used within a user provider");
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
      EmployeePageComponent
      <br />
      <TicketComponent />
      <br />
      <ViewPastTicketsComponent />
    </>
  );
}

export default EmployeePageComponent;
