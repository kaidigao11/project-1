import React, { FormEvent, useContext, useState } from "react";
import LoginPageComponent from "./Login/LoginPageComponent";
import RegisterPageComponent from "./Register/RegisterPageComponent";
import { Link, useNavigate } from "react-router-dom";
import { Employee, EmployeeContext } from "../Contexts/UserContext";
import axios from "axios";
import { error } from "console";


interface EmployeeLoginInfo {
  user: Employee;
  id: number;
  isAdmin: boolean;
}

function LoginManagementComponent() {
  const context = useContext(EmployeeContext);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  function onSubmithandler(e: any) {
    e.preventDefault();
    axios
      .post("http://localhost:8080/login", {
        username: username,
        password: password,
        isAdmin: false,
      })
      .then((response) => {
        context?.login(response.data.employeeId, response.data.username, response.data.password, response.data.isAdmin);
      })
      .catch((error) => console.error("Error posting data, ", error));
      navigate("/employee");
  }

  return (
    <>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <Link className="navbar-brand" to="/">
          Ticketing System
        </Link>
      </nav>

      <LoginPageComponent
        username={username}
        password={password}
        setUsername={setUsername}
        setPassword={setPassword}
        handleSubmit={onSubmithandler}
      />
    </>
  );
}

export default LoginManagementComponent;
