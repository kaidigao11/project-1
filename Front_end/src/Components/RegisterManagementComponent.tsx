import React, { FormEvent, useState } from "react";
import { useNavigate } from "react-router-dom";
import RegisterPageComponent from "./Register/RegisterPageComponent";

function RegisterManagementComponent() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  function onSubmithandler(e: FormEvent) {
    e.preventDefault();
    console.log(e.target);
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
