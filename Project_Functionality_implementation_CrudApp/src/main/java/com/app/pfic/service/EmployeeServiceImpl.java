package com.app.pfic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pfic.exception.CaseMismatchException;

import com.app.pfic.exception.CustomeException;
import com.app.pfic.exception.InvalidAdharCardException;


import com.app.pfic.exception.DataMismatchException;
import com.app.pfic.exception.IncorrectMobileNumberException;
import com.app.pfic.exception.InvaliPancardNumberException;
import com.app.pfic.exception.NoDataFoundException;
import com.app.pfic.exception.NoRecordFoundException;
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
		
		String pannumber="^[A-Z]{3}[0-9]{4}[A-Z]{1}$";
		
		String mblno= String.valueOf(e.getMobno());
		
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
		if(e.getPancard() == null || !e.getPancard().matches(pannumber))
		{
			throw new InvaliPancardNumberException("The PAN card number should have uppercase alphabets and numbers.");
			
			
		}
	
		if(mblno.length()!=10)
		{
			throw new IncorrectMobileNumberException("Please enter 10 digit correct mobile number");
			
			
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

	public List<Employee> getAllEmployee()
	{
		List<Employee> list = er.findAll();
		return list;
	}

	public String deleteAllData() throws Exception 
	{
		long count= er.count();			//count(); check how many records are present in data base
		
		if(count>0)
		{
			er.deleteAll();
			
		}
		else
		{
			
			throw new NoDataFoundException("please enter data in database");
		}
		
		
		return "Success";
		
		
		
	}



	@Override
	public Employee updateEmployeeData(Employee employee, int id) throws Exception 
	{
		Optional<Employee> op =er.findById(id);
		
		String mbn= String.valueOf(employee.getMobno());
		
			if(op.isPresent())
				
			{
				Employee e= op.get();
				
				if(employee.getName()!=null)
				{
					e.setName(employee.getName());
				}
			
				if(employee.getAddress()!=null)
				{
					
					e.setAddress(employee.getAddress());
					
				}
				
				if(employee.getUsername()!=null)
				{
					
					e.setUsername(employee.getUsername());
				}
				
				if(mbn!=null)
				{
					e.setMobno(employee.getMobno());
					
					
				}
				
				if(employee.getAdharcard()!=null)
				{
					
					
					e.setAdharcard(employee.getAdharcard());
				}
				if(employee.getPancard()!=null)
				{
					
					e.setPancard(employee.getPancard());
					
				}
				
				if(employee.getPassword()!=null)
				{
					
					e.setPassword(employee.getPassword());
					
				}
				
					er.save(e);
			
			}
			else
			{
				throw new DataMismatchException("Please enter data carefully");
				
			}
			
		
			return null;
		
		
	}



	@Override
	public String deleteSingleRecord(int id) throws Exception 
	{
		Optional<Employee> op=er.findById(id);
		
				if(op.isPresent())
				{
					
					er.deleteById(id);
					
				}
				else
				{
					throw new NoRecordFoundException("this id is not present so cannot delete");
	
				}	
				
				return "success";
				
	}
		
			
}
