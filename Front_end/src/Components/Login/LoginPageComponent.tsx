import React, { FormEvent, useState } from "react";
import RegisterPageComponent from "../Register/RegisterPageComponent";
import { Link } from "react-router-dom";

type UserInputProps = 
{username: string, setUsername: React.Dispatch<React.SetStateAction<string>>, password: string, setPassword: React.Dispatch<React.SetStateAction<string>>, handleSubmit: any };

function LoginPageComponent({username, setUsername, password, setPassword, handleSubmit}: UserInputProps) {
  

  return (
    <>
      <form style={{position: "absolute", top: "30%", left: "50%", marginTop: "-50px", marginLeft: "-50px", width: "200px"}} onSubmit={handleSubmit}>
      <p>Login to Existing Account</p>
        <label>Username:</label>
        <input
          type="text"
          className="form-control-sm"
          placeholder="username"
          value={username}
          onChange={(e: any) => setUsername(e.target.value)}
        />
        <br />
        <label>Password:</label>
        <input
          type="password"
          className="form-control-sm"
          placeholder="password"
          value={password}
          onChange={(e: any) => setPassword(e.target.value)}
        />
        <br />
        <button style={{marginTop:"20px"}} type="submit" className="btn btn-primary">
          Submit
        </button>
        
      </form>
    </>
  );
}

export default LoginPageComponent;
