package com.example.manageemployee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public boolean createEmployee(Employee newEmp) {
		return repository.createEmployee(newEmp);
	}
	
	public Employee findEmployeeById(Integer empId) {
		return repository.findEmployeeById(empId);
	}

	public List<Employee> getAllEmployees() {
		return repository.AllEmployee();
	}
	
	public Employee updateEmployee(Integer empId, Employee emp) {
		return repository.updateEmployee(empId, emp);
	}

	public boolean deleteEmployee(Integer empId) {
		return repository.deleteEmployee(empId);
	}
}
