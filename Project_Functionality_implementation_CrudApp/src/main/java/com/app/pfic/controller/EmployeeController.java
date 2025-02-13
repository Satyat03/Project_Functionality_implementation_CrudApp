package com.app.pfic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("/get")
	public String success()
	{
		return "success";
		
	}
	
	
}
