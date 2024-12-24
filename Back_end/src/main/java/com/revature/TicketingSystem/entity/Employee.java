package com.revature.TicketingSystem.entity;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Autowired
    @Column(name="employeeId")
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="isAdmin")
    private Boolean isAdmin;

    // default constructor
    public Employee(){

    }

    // param constructor
    @Autowired
    public Employee(String username, String password, Boolean isAdmin){
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    // param constructor with Id
    @Autowired
    public Employee(Integer employeeId, String username, String password, Boolean isAdmin){
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    
    // account id getter
    public Integer getEmployeeId() {
        return employeeId;
    }
    
    // account id setter
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    // username getter
    public String getUsername() {
        return username;
    }

    // username setter
    public void setUsername(String username) {
        this.username = username;
    }

    // password getter
    public String getPassword() {
        return password;
    }

    // password setter
    public void setPassword(String password) {
        this.password = password;
    }

    // isadmin getter
    public Boolean getIsAdmin(){
        return isAdmin;
    }

    // isadmin setter
    public void setIsAdmin(Boolean isAdmin){
        this.isAdmin = isAdmin;
    }
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
        if (isAdmin == false && other.isAdmin == true) {
            return false;
        }
        if (isAdmin == true && other.isAdmin == false) {
            return false;
        }
		return true;
	}


}
