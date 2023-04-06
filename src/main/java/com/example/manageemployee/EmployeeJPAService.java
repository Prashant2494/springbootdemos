package com.example.manageemployee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJPAService {

	@Autowired
	EmployeeJPARepository repository;
	
	public Employee createEmployee(Employee newEmp) {
		return repository.save(newEmp);
	}
	
	public Employee findEmployeeById(Integer empId) {
		Optional<Employee> opemp = repository.findById(empId);		
		if(opemp.isPresent()) {
			return opemp.get();
		}
		
		return null;
	}

	public List<Employee> getAllEmployees() {
		return (List<Employee>) repository.findAll();
	}
	
	public Employee updateEmployee(Integer empId, Employee emp) {
		
		Employee exisitingEmp = findEmployeeById(empId);
		
		if(exisitingEmp != null) {
			
			exisitingEmp.setEmpName(emp.getEmpName());
			exisitingEmp.setEmpDepartment(emp.getEmpDepartment());
			exisitingEmp.setEmpJob(emp.getEmpJob());
			exisitingEmp.setSalary(emp.getSalary());
			exisitingEmp.setEmpStatus(emp.getEmpStatus());
			repository.save(exisitingEmp);	
			return exisitingEmp;
		}		
		return null;
	}

	public boolean deleteEmployee(Integer empId) {
		
		//repository.deleteById(empId);
		//mark as resigned 
		
		Optional<Employee> opemp = repository.findById(empId);	
		
		if(opemp.isPresent()) {
			Employee emp = opemp.get();
			emp.setEmpStatus("RESIGNED");
			repository.save(emp);
			return true;
		}
		return false;
	}
	
}
