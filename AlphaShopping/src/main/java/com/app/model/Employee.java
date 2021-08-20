package com.app.model;

public class Employee {

	private String email;
	private String employeeName;

	
	public Employee() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	

	public Employee(String email, String employeeName, String employeePassword) {
		super();
		this.email = email;
		this.employeeName = employeeName;
		
	}
	
}
