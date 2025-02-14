package com.app.pfic.controller;

import java.util.List;


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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmployeeController {
	
	@Autowired
	EmployeeServiceI esi;
	
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addUser(@RequestBody Employee e) throws Exception
	{
		log.warn("this is warn log");
		log.debug("this is debug log");
		log.info("this is info log");
		log.error("this is error log");
		Employee e1= esi.saveemp(e);
		return new ResponseEntity<Employee>(e1,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<Employee> getsingleuser(@PathVariable ("id") int id)
	{
		log.warn("this is warn log");
		log.debug("this is debug log");
		log.info("this is info log");
		log.error("this is error log");
		Employee u= esi.getUser(id);
		return new ResponseEntity<Employee>(u,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		log.warn("this is warn log");
		log.debug("this is debug log");
		log.info("this is info log");
		log.error("this is error log");
	List<Employee> emp=	esi.getAllEmployee();
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAll() throws Exception
	{
		log.warn("this is warn log");
		log.debug("this is debug log");
		log.info("this is info log");
		log.error("this is error log");
		String message=esi.deleteAllData();
		
		return new ResponseEntity<String>("All Data Deleted",HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateData(@RequestBody Employee employee, @PathVariable("id") int id) throws Exception
	{
		log.warn("this is warn log");
		log.debug("this is debug log");
		log.info("this is info log");
		log.error("this is error log");
		Employee emp=esi.updateEmployeeData(employee, id);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/deleteby/{id}")
	public ResponseEntity<String> deleteSingle(@PathVariable ("id") int id) throws Exception
	{
		String srt=esi.deleteSingleRecord(id);
		
		return new ResponseEntity<String>("Single Record Deleted",HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
}
