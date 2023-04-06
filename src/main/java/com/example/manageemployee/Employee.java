package com.example.manageemployee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

	@Id
	@Column(name = "EMP_ID")
	private Integer empId;
	
	@Column(name = "EMP_NAME")
	private String empName;
	
	@Column(name = "EMP_SALARY")
	private Double salary;
	
	@Column(name = "EMP_JOB")
	private String empJob;
	
	@Column(name="EMP_DEPARTMENT")
	private String empDepartment;
	
	@Column(name="EMP_STATUS")
	private String empStatus;

	public Employee() {		
	}

	public Employee(Integer empId, String empName, Double salary, String empJob, String empDepartment,
			String empStatus) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.empJob = empJob;
		this.empDepartment = empDepartment;
		this.empStatus = empStatus;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", empJob=" + empJob
				+ ", empDepartment=" + empDepartment + ", empStatus=" + empStatus + "]";
	}
	
	
}
