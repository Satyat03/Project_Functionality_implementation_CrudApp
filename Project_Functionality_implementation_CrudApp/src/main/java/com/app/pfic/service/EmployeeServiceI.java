package com.app.pfic.service;

import com.app.pfic.model.Employee;

public interface EmployeeServiceI {

	public Employee saveemp(Employee e) throws Exception;

	public Employee getUser(int id);

	public String deleteAllData() throws Exception;

	public Employee updateEmployeeData(Employee employee, int id) throws Exception;

}
