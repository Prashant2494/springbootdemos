package com.example.manageemployee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeJPAService jpaservice;
	
	@RequestMapping(path= "employees", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createEmployee(@RequestBody Employee emp) {
		ResponseEntity response = null;
		boolean createResult = service.createEmployee(emp);
		if(createResult == true) {
			response = new ResponseEntity("Create successful", HttpStatus.CREATED); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Create Failed", HttpStatus.BAD_REQUEST); //returning string + 400
			return response;			
		}
	}
	
	@RequestMapping(path= "jpa_employees", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createJPAEmployee(@RequestBody Employee emp) {
		ResponseEntity response = null;
		Employee createResult = jpaservice.createEmployee(emp);
		if(createResult != null) {
			response = new ResponseEntity("Create successful", HttpStatus.CREATED); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Create Failed", HttpStatus.BAD_REQUEST); //returning string + 400
			return response;			
		}
	}

	@GetMapping(path="/employees/{empId}")
	public ResponseEntity getEmployee(@PathVariable("empId")Integer empId) {
		ResponseEntity response = null;
		Employee emp = service.findEmployeeById(empId);
		if(emp != null) {
			response = new ResponseEntity(emp, HttpStatus.FOUND); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Employee Not Found", HttpStatus.NOT_FOUND); //returning string + 200
			return response;
		}
	}
	
	@GetMapping(path="/jpa_employees/{empId}")
	public ResponseEntity getJPAEmployee(@PathVariable("empId")Integer empId) {
		ResponseEntity response = null;
		Employee emp = jpaservice.findEmployeeById(empId);
		if(emp != null) {
			response = new ResponseEntity(emp, HttpStatus.FOUND); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Employee Not Found", HttpStatus.NOT_FOUND); //returning string + 200
			return response;
		}
	}

	@GetMapping(path="/employees")
	public ResponseEntity getAllEmployees() {
		ResponseEntity response = null;
		List<Employee> emp = service.getAllEmployees();
		
		if(emp != null && !emp.isEmpty()) {
			response = new ResponseEntity(emp, HttpStatus.FOUND); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Employee Not Found", HttpStatus.NOT_FOUND); //returning string + 200
			return response;
		}
	}
	
	@GetMapping(path="/jpa_employees")
	public ResponseEntity getAllJPAEmployees() {
		ResponseEntity response = null;
		List<Employee> emp = jpaservice.getAllEmployees();
		
		if(emp != null && !emp.isEmpty()) {
			response = new ResponseEntity(emp, HttpStatus.FOUND); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Employee List is empty", HttpStatus.NOT_FOUND); //returning string + 200
			return response;
		}
	}
	
	@PutMapping("/employees/{empId}")
	public ResponseEntity updateEmployee(@PathVariable("empId")Integer empId, @RequestBody Employee emp) {
		ResponseEntity response = null;
		emp = service.updateEmployee(empId, emp);
		if(emp != null) {
			response = new ResponseEntity(emp, HttpStatus.OK); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Employee Not Found", HttpStatus.NOT_FOUND); //returning string + 200
			return response;
		}
	}
	
	@PutMapping("/jpa_employees/{empId}")
	public ResponseEntity updateJPAEmployee(@PathVariable("empId")Integer empId, @RequestBody Employee emp) {
		ResponseEntity response = null;
		emp = jpaservice.updateEmployee(empId, emp);
		if(emp != null) {
			response = new ResponseEntity(emp, HttpStatus.OK); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Employee Not Found", HttpStatus.NOT_FOUND); //returning string + 200
			return response;
		}
	}
	
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity deleteEmployee(@PathVariable("empId")Integer empId) {
		ResponseEntity response = null;
		boolean isEmpDeleted = service.deleteEmployee(empId);
		if(isEmpDeleted) {
			response = new ResponseEntity("Employee : "+ empId+" Deleted.", HttpStatus.OK); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Employee Not Found", HttpStatus.NOT_FOUND); //returning string + 200
			return response;
		}
	}
	
	@DeleteMapping("/jpa_employees/{empId}")
	public ResponseEntity deleteJPAEmployee(@PathVariable("empId")Integer empId) {
		ResponseEntity response = null;
		boolean isEmpDeleted = jpaservice.deleteEmployee(empId);
		if(isEmpDeleted) {
			response = new ResponseEntity("Employee : "+ empId+" Deleted.", HttpStatus.OK); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Employee Not Found", HttpStatus.NOT_FOUND); //returning string + 200
			return response;
		}
	}
	
}
