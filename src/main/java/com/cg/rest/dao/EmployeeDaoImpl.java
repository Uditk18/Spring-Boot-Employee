//Dao method that implements all the methods we need for employee project

package com.cg.rest.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cg.rest.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	// Making a list of employees
	// We use ArrayList to make it mutable
	List<Employee> employeeDB = new ArrayList<>(Arrays.asList(new Employee("1001", "Udit"),
			new Employee("1002", "Ripudaman"), new Employee("1003", "Rahul")));

	// method to view all employees
	public List<Employee> viewAllEmployees() {
		return employeeDB;
	}

	//gives only one employee as output
	//We are looking for one id only
		public Employee getEmployee(String id)
		{
			//lambda expression
			return employeeDB.stream().filter(t->t.getEmpId().equals(id)).findFirst().get();
		}
	// method to add new employee
	public void addNewEmployee(Employee employee) {
		employeeDB.add(employee);

	}

	// method to delete an employee by id
	public void deleteEmployee(String id) {
		employeeDB.removeIf(emp -> emp.getEmpId().equals(id));

	}

	// method to update an employee by id
	public void updateEmployee(Employee employee, String id) {
		for(int i=0;i<employeeDB.size();i++)
		{
			Employee e=employeeDB.get(i);
			if(e.getEmpId().equals(id))
			{
				employeeDB.set(i, employee);
				return;
			}
		}
	}

}
