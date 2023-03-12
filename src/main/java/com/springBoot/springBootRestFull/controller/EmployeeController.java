package com.springBoot.springBootRestFull.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.springBootRestFull.model.Employee;
import com.springBoot.springBootRestFull.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	
	private EmployeeService empService;

	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}
	
	
	
	@PostMapping("/create")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(empService.saveEmployyee(emp), HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getEmployee()
	{
		return new ResponseEntity<List<Employee>>(empService.getEmployee(), HttpStatus.FOUND);
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") long id)
	{
		return new ResponseEntity<Employee>(empService.getById(id), HttpStatus.FOUND);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(empService.updateEmployee(emp, id), HttpStatus.ACCEPTED);
	}
}
