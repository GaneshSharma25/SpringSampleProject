package com.example.EmployeeManagementSystem.exception;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(Long id) {
		// TODO Auto-generated constructor stub
		super("Employee not found with id: "+id);
	}

}
