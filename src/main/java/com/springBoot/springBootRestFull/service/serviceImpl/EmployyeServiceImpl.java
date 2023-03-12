package com.springBoot.springBootRestFull.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springBoot.springBootRestFull.Repository.EmployeeRepositry;
import com.springBoot.springBootRestFull.exception.ResourceNotFoundException;
import com.springBoot.springBootRestFull.model.Employee;
import com.springBoot.springBootRestFull.service.EmployeeService;


@Service
public class EmployyeServiceImpl implements EmployeeService {

	private EmployeeRepositry empRepositry;
	
	
	public EmployyeServiceImpl(EmployeeRepositry empRepositry) {
		super();
		this.empRepositry = empRepositry;
	}


	@Override
	public Employee saveEmployyee(Employee employee) {
	
		return empRepositry.save(employee);
	}


	@Override
	public List<Employee> getEmployee() {
		
		
		
		return empRepositry.findAll();
	}
	
	@Override
	public Employee getById(Long Id) {
		
		Optional<Employee> e1 =  empRepositry.findById(Id);
		
		if(e1 != null)
		{
			return e1.get();
		}
		else {
			throw new ResourceNotFoundException("Employee", "ID", Id);
		}
	
	}
	
	@Override
	public Employee updateEmployee(Employee emp, long id) {
		
		Employee exEmp = empRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		
		exEmp.setFirstName(emp.getFirstName());
		exEmp.setLastName(emp.getLastName());
		exEmp.setEmail(emp.getEmail());
		
		empRepositry.save(exEmp);
		
		return exEmp;
	}

}
