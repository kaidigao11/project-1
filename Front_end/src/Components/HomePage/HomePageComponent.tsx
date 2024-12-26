import React from "react";
import { Link } from "react-router-dom";

function HomePageComponent() {
    

  return (
    <>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <Link className="navbar-brand" to="/">
          Ticketing System
        </Link>
        <Link className="navbar-brand" to="/login">
          Login
        </Link>
        <Link className="navbar-brand" to="/register">
          Register
        </Link>
      </nav>
      

      <br/>
      HomePage
      <br/>
      {/* <img src={logo} alt="logo"></img> */}

  
    </>
    )
}

export default HomePageComponent;
