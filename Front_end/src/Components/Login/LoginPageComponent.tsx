import React, { FormEvent, useState } from "react";
import RegisterPageComponent from "../Register/RegisterPageComponent";
import { Link } from "react-router-dom";

type UserInputProps = 
{username: string, setUsername: React.Dispatch<React.SetStateAction<string>>, password: string, setPassword: React.Dispatch<React.SetStateAction<string>>, handleSubmit: any };

function LoginPageComponent({username, setUsername, password, setPassword, handleSubmit}: UserInputProps) {
  

  return (
    <>
      <p>Login to Existing Account</p>
      <form onSubmit={handleSubmit}>
        <label>Username:</label>
        <input
          type="text"
          placeholder="username"
          value={username}
          onChange={(e: any) => setUsername(e.target.value)}
        />
        <br />
        <label>Password:</label>
        <input
          type="password"
          placeholder="password"
          value={password}
          onChange={(e: any) => setPassword(e.target.value)}
        />
        <br />
        <button type="submit">
          Submit
        </button>
        
      </form>
    </>
  );
}

export default LoginPageComponent;
