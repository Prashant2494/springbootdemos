package com.example.manageemployee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

	private static List<Employee> employeeData = new ArrayList<>();
	
	static {
	Employee james = new Employee(100, "James Cooper", 12345.0, "Trainer", "Training", "ACTIVE");
	Employee steven = new Employee(200, "Steven King", 2345.0, "Devloper", "Training", "ACTIVE");
	Employee neena = new Employee(300, "Neena Kocchar", 3456.0, "Manager", "Training", "ACTIVE");
	employeeData.add(james);
	employeeData.add(steven);
	employeeData.add(neena);	
	}
	
	public boolean createEmployee(Employee newEmp) {
		//Check if the employee is already present in memory array
		for(Employee emp:employeeData) {
			if(emp.getEmpId() == newEmp.getEmpId())
				return false;//if present then return false
		}
		//if not present then add employee to memory & return true
		employeeData.add(newEmp);
		return true;
	}
	
	public Employee findEmployeeById(Integer empId) {
		for(Employee emp:employeeData) {
			if(emp.getEmpId().equals(empId))
				return emp;
		}		
		return null;
	}

	public List<Employee> AllEmployee() {
		return employeeData;
	}
	
	public Employee updateEmployee(Integer empId, Employee emp) {

		Employee updateEmp = null;
		
		for(Employee tempEmp:employeeData) {
			if(tempEmp.getEmpId().equals(empId)) {
				tempEmp.setEmpName(emp.getEmpName());
				tempEmp.setSalary(emp.getSalary());
				tempEmp.setEmpDepartment(emp.getEmpDepartment());
				tempEmp.setEmpJob(emp.getEmpJob());
				tempEmp.setEmpStatus(emp.getEmpStatus());
				updateEmp = tempEmp;
				break;
			}
		}
		
		return updateEmp;
		
	}

	public boolean deleteEmployee(Integer empId) {
		Employee updateEmp = null;
		
		for(Employee emp: employeeData) {
			if(emp.getEmpId().equals(empId)) {
				updateEmp = emp;
				break;
			}
		}
		
		if(updateEmp != null) {
			updateEmp.setEmpStatus("RESIGNED");
			return true;
		}
		
		return false;
	}
	
}
