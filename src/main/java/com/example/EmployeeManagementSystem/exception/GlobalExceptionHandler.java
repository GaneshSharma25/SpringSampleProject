package com.example.EmployeeManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //This annotation allows the class to handle exceptions globally across all controllers.
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class) //This method catches EmployeeNotFoundException 
	//and returns a 404 Not Found status with a custom error message.
	public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	
}
