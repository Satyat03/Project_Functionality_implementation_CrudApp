package com.app.pfic.service;

import java.util.List;

import com.app.pfic.model.Employee;

public interface EmployeeServiceI {

	public Employee saveemp(Employee e) throws Exception;

	public Employee getUser(int id);

	public List<Employee> getAllEmployee();
	public String deleteAllData() throws Exception;

	public Employee updateEmployeeData(Employee employee, int id) throws Exception;

}
