package com.cg.rest;

//Rest controller which handles all the dependencies and use annotations to perform actions
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.pojo.Employee;
import com.cg.rest.service.EmployeeService;
import com.cg.rest.service.EmployeeServiceImpl;

//Our program is a REST application and handles WEB Request
@RestController
public class EmpController {

	private EmployeeService empService = new EmployeeServiceImpl();

	/*
	 * @RequestMapping
	 *It maps HTTP Requests to handler methods of MVC and REST controllers
	 *GIves Routing information
	 *Its like RequestDispatcher of spring
	 *
	 */
	
	
	//GET Method to show list of all employees
	@RequestMapping("/viewEmployee")
	public List<Employee> viewEmployee() {
		return empService.viewAllEmployees();
	}
	
	//POST Method to add new employee
	/*
	 * @RequestBody maps the HttpRequest body to transfer or domain object, enabling automatic deserialization of the 
	 * inbound HttpRequest body onto the java object
	*/
	
	//{id} tells that id is a variable 
		@RequestMapping("/getEmp/{id}")
		public Employee getEmployee(@PathVariable String id)
		{
			return empService.getEmployee(id);
		}
		
		
	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public void addNewEmployee( @RequestBody Employee employee) {
		empService.addNewEmployee(employee);
	}

	
	//DELETE Method to delete an employee
	//{id} tells that id is a variable
		/*
		 * @PathVariable tells that we are passing a variable in the url
		*/
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee( @PathVariable String id) {
			empService.deleteEmployee(id);
		}

	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	public void updateEmployee(@RequestBody Employee employee, @PathVariable String id) {
		empService.updateEmployee(employee,id);
	}
		
		
		
		
		
		
		
		
		
		
	
}
