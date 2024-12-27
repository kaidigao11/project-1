import React from "react";
import { Link } from "react-router-dom";
import logo from "../../Images/logo.svg";

function HomePageComponent() {
  return (
    <>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <Link className="navbar-brand" to="/">
          RevTicketing
        </Link>
        <Link className="navbar-brand" to="/login">
          Login
        </Link>
        <Link className="navbar-brand" to="/register">
          Register
        </Link>
      </nav>

      <br></br>
      <h1> Welcome to the Online Ticketing System</h1>
      <img style={{ height: "40vh" }} src={logo} alt="logo"></img>
    </>
  );
}

export default HomePageComponent;
