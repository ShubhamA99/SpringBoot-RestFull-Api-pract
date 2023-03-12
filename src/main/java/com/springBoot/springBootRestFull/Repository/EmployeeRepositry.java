package com.springBoot.springBootRestFull.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.springBootRestFull.model.Employee;



public interface EmployeeRepositry extends JpaRepository<Employee, Long>{

}
