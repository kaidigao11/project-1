import React, { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { EmployeeContext } from "../Contexts/UserContext";
import ViewActiveTicketsComponent from "./ViewActiveTicketsComponent";

function AdminPageComponent() {
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
      <p>Welcome Administrator {context.employee?.username}!</p>
      <p>Approve or deny tickets below</p>
      <ViewActiveTicketsComponent />
    </>
  );
}

export default AdminPageComponent;
