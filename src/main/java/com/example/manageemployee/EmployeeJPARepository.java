package com.example.manageemployee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeJPARepository extends CrudRepository<Employee, Integer> {

}
