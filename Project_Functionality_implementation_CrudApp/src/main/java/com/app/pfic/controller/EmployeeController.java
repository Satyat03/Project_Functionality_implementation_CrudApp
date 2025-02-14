package com.app.pfic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<Employee> getsingleuser(@PathVariable int id)
	{
		Employee u= esi.getUser(id);
		return new ResponseEntity<Employee>(u,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAll() throws Exception
	{
		String message=esi.deleteAllData();
		
		return new ResponseEntity<String>("All Data Deleted",HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateData(@RequestBody Employee employee, @PathVariable("id") int id) throws Exception
	{
		Employee emp=esi.updateEmployeeData(employee, id);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		
		
	}
	
	
	
	
	
	
	
	
}
