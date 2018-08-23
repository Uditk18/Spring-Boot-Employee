
//Dao method that implements all the methods we need for employee project

package com.cg.rest.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Repository;

import com.cg.rest.controller.EmpController;
import com.cg.rest.employeenotfound.EmployeeNotFound;
import com.cg.rest.pojo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private Employee employee;
	// Making a list of employees
	// We use ArrayList to make it mutable
	List<Employee> employeeDB = new ArrayList<>(Arrays.asList(new Employee("1001", "Udit"),
			new Employee("1002", "Ripudaman"), new Employee("1003", "Rahul")));

	// method to view all employees
	public List<Employee> viewAllEmployees() {
		return employeeDB;
	}

	// method to add new employee
	public void addNewEmployee(Employee employee) {
		
		Link link = ControllerLinkBuilder.linkTo(EmpController.class).slash(employee.getEmpName()).withSelfRel();
		employee.add(link);
		employeeDB.add(employee);

	}
	
	// method to add new employee
	
		public Employee getEmployeeById(String id) {
			employee=employeeDB.stream().filter(t->t.getEmpId().equals(id).findFirst().get();
			if(employee==null)
			{//get fetches employee object from optional object
				throw new EmployeeNotFound("not found");			}
			else
				return employee;

		}
		
		
	// method to delete an employee by id
	public void deleteEmployee(String id) {
		Predicate<Employee> emp= p->p.getEmpId().equals(id);
		if(emp==null)
			throw new EmployeeNotFoundException("not found");
		else 
			
			employeeDB.removeIf(emp);

	}

	// method to update an employee by id
	public void updateEmployee(Employee employee, String id) {
		for(int i=0;i<employeeDB.size();i++)
		{
			Employee emp=employeeDB.get(i);
			if(emp.getEmpId().equals(id))
			{
				employeeDB.set(i, employee);
				return;
			}
		}
	}

}
