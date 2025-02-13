package com.app.pfic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pfic.model.Employee;
import com.app.pfic.service.EmployeeServiceI;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceI esi;
	
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addUser(@RequestBody Employee e) throws Exception
	{
		Employee e1= esi.saveemp(e);
		return new ResponseEntity<Employee>(e1,HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
}
