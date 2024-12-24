import React, { FormEvent, useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import RegisterPageComponent from "./RegisterPageComponent";
import { EmployeeContext } from "../Contexts/UserContext";
import axios from "axios";

function RegisterManagementComponent() {
  const context = useContext(EmployeeContext);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  function onSubmithandler(e: any) {
    e.preventDefault();
    axios
      .post("http://localhost:8080/register", {
        username: username,
        password: password,
        isAdmin: false,
      })
      .then((response) => {
        alert('Please continue to login');
      })
      .catch((error) => console.error("Error posting data, ", error));
    navigate("/login");
  }

  return (
    <>
      <RegisterPageComponent
        username={username}
        password={password}
        setUsername={setUsername}
        setPassword={setPassword}
        handleSubmit={onSubmithandler}
      />
    </>
  );
}

export default RegisterManagementComponent;
