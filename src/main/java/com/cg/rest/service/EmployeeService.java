package com.cg.rest.service;

import java.util.List;

import com.cg.rest.pojo.Employee;

public interface EmployeeService {

	

	List<Employee> viewAllEmployees();
	void addNewEmployee(Employee employee);
	void deleteEmployee(String id);
	void updateEmployee(Employee employee, String id);
	Employee getEmployee(String id);
}