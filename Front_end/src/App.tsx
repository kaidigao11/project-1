import React from "react";
import "./App.css";
import { BrowserRouter, Route, Router, Routes } from "react-router-dom";
import HomePageComponent from "./Components/HomePage/HomePageComponent";
import RegisterPageComponent from "./Components/Register/RegisterPageComponent";
import LoginPageComponent from "./Components/Login/LoginPageComponent";
import AdminPageComponent from "./Components/AdminPage/AdminPageComponent";
import LoginManagementComponent from "./Components/Login/LoginManagementComponent";
import RegisterManagementComponent from "./Components/Register/RegisterManagementComponent";
import EmployeeManagementComponent from "./Components/EmployeePage/EmployeeManagementComponent";
import { EmployeeProvider } from "./Components/Contexts/UserContext";
import { TicketProvider } from "./Components/Contexts/TicketContext";



function App() {
  return (
    <div className="App">
      <TicketProvider>
      <EmployeeProvider>
        <Routes>
          <Route path="/" element={<HomePageComponent />}>
            {" "}
            Home Page{" "}
          </Route>
          <Route path="/register" element={<RegisterManagementComponent />}>
            {" "}
            Register Page{" "}
          </Route>
          <Route path="/login" element={<LoginManagementComponent />}>
            {" "}
            Login Page{" "}
          </Route>
          <Route path="/employee" element={<EmployeeManagementComponent />}>
            {" "}
            Employee Page{" "}
          </Route>
          
            <Route path="/admin" element={<AdminPageComponent />}>
              {" "}
              Manager Page{" "}
            </Route>
          
        </Routes>
      </EmployeeProvider>
      </TicketProvider>
    </div>
  );
}

export default App;
