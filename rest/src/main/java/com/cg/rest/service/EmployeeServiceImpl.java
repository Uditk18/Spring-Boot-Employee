package com.cg.rest.service;

import java.util.List;

import com.cg.rest.dao.EmployeeDao;
import com.cg.rest.dao.EmployeeDaoImpl;
import com.cg.rest.pojo.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public List<Employee> viewAllEmployees() {
		return dao.viewAllEmployees();
	}

	@Override
	public void addNewEmployee(Employee employee) {
		dao.addNewEmployee(employee);
	}

	public void deleteEmployee(String id) {
		dao.deleteEmployee(id);
	}

	@Override
	public void updateEmployee(Employee employee, String id) {
		dao.updateEmployee(employee, id);
	}

	public void getEmployeeById(String id)
	{
		dao.getEmployeeById(id);
	}

}
