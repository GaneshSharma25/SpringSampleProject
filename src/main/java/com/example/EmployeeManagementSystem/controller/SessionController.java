package com.example.EmployeeManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
	
	@GetMapping("/session-expired")
    public String sessionExpired() {
    	return "Your session has expired. Please log in again.";
    }
}
