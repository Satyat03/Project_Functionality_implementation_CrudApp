package com.app.pfic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pfic.model.Employee;
import com.app.pfic.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{

	
	@Autowired
	EmployeeRepo er;
	
	
	
	@Override
	public Employee saveemp(Employee e) throws Exception {
		
		
		
		return er.save(e);
	}

}
