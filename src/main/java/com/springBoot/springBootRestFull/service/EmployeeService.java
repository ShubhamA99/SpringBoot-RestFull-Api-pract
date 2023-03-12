package com.springBoot.springBootRestFull.service;

import java.util.List;

import com.springBoot.springBootRestFull.model.Employee;

public interface EmployeeService {

	
	Employee saveEmployyee( Employee employee);
	
	List<Employee> getEmployee();
	
	Employee getById(Long Id);
	
	Employee updateEmployee(Employee emp ,long id);
}
