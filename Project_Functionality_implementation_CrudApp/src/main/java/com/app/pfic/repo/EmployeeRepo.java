package com.app.pfic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pfic.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
