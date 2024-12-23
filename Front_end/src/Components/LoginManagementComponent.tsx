import React, { FormEvent, useState } from 'react'
import LoginPageComponent from './Login/LoginPageComponent';
import RegisterPageComponent from './Register/RegisterPageComponent';
import { Link, useNavigate } from 'react-router-dom';

function LoginManagementComponent() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    function onSubmithandler(e: FormEvent) {
      e.preventDefault();
      console.log(e.target);
      navigate("/employee");
    }


  return (

    <>
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <Link className="navbar-brand" to="/">
          Ticketing System
        </Link>
      </nav>
      
      <LoginPageComponent username={username} password={password} setUsername={setUsername} setPassword={setPassword} handleSubmit={onSubmithandler}/>
    </>
  )
}

export default LoginManagementComponent