package com.app.pfic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pfic.exception.CaseMismatchException;
import com.app.pfic.exception.CustomeException;
import com.app.pfic.exception.InvalidAdharCardException;
import com.app.pfic.exception.InvalidAdharCardException;
import com.app.pfic.exception.UserNotFoundException;
import com.app.pfic.exception.WrongUsernameException;
import com.app.pfic.model.Employee;
import com.app.pfic.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{

	
	@Autowired
	EmployeeRepo er;
	
	
	
	@Override
	public Employee saveemp(Employee e) throws Exception {
		
		if (e.getName() == null || !e.getName().equals(e.getName().toUpperCase())) {
            throw new CaseMismatchException("Fullname must be in uppercase and cannot be null.");
        }
		
		if (e.getUsername() == null || !e.getUsername().endsWith("@gmail.com")) {
            throw new WrongUsernameException("Username must end with @gmail.com and cannot be null.");
        }
		if(e.getAddress()== null ) {
			throw new  CustomeException("Address Compulsory !!");
		}
		if (e.getAdharcard() == null || e.getAdharcard().length() != 12 || !e.getAdharcard().matches("[0-9]+")) {
            throw new InvalidAdharCardException("Invalid Aadhar card number: " + e.getAdharcard());
        }
		return er.save(e);
	}



	@Override
	public Employee getUser(int id) {
		
		Optional<Employee> op = er.findById(id);
		if (op.isPresent()) {
            return op.get();
        } else {
            throw new UserNotFoundException("USER NOT FOUND FOR THE ID: " + id);
        }
    }



	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = er.findAll();
		return list;
	}
		

}
