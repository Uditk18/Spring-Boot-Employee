package com.cg.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cg.rest.service.EmployeeService;
import com.cg.rest.service.EmployeeServiceImpl;

import junit.framework.TestCase;


public class JUnitTest extends TestCase {
	
	private EmployeeService service;
	
	@Before
	public void setUp()
	{
		service=new EmployeeServiceImpl();
	}
	
	@Test
	public void IsEmployeeIdValid()
	{
		
	}

}
