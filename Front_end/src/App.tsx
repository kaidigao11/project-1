import React from 'react';
import './App.css';
import { BrowserRouter, Route, Router, Routes } from 'react-router-dom';
import HomePageComponent from './Components/HomePage/HomePageComponent';
import RegisterPageComponent from './Components/Register/RegisterPageComponent';
import LoginPageComponent from './Components/Login/LoginPageComponent';
import AdminPageComponent from './Components/AdminPage/AdminPageComponent';
import LoginManagementComponent from './Components/LoginManagementComponent';
import RegisterManagementComponent from './Components/RegisterManagementComponent';
import EmployeeManagementComponent from './Components/EmployeePage/EmployeeManagementComponent';


function App() {
  return (
    <div className="App">




      <Routes>
        <Route path='/' element={ <HomePageComponent />}> Home Page </Route>
        <Route path='/register' element={<RegisterManagementComponent/>}> Register Page </Route>
        <Route path='/login' element={<LoginManagementComponent/>}> Login Page </Route>
        <Route path='/employee' element={<EmployeeManagementComponent/>}> Employee Page </Route>
        <Route path='/admin' element={<AdminPageComponent/>}> Manager Page </Route>


      </Routes>




    </div>
  );
}

export default App;
