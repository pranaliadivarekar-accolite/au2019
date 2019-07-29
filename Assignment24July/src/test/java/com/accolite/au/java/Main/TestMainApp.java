package com.accolite.au.java.Main;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.accolite.au.java.Model.Employee;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMainApp {

	private static MainApp mainApp;
	private static Employee employee1;
	private static Employee employee2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Object initialization...");
		
		mainApp = new MainApp();
		employee1 = new Employee();
		employee1.setEmpId(1);
		employee1.setEmpName("abc");
		employee1.setDesignation("def");
		employee1.setDateOfJoining(new Date());
		
		employee2 = new Employee();
		employee2.setEmpId(2);
		employee2.setEmpName("def");
		employee2.setDesignation("ghi");
		employee2.setDateOfJoining(new Date());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("End of unit testing.");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Executing next test case.");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Execution completed.");
	}

	@Test
	public void test1AddEmployeeInOrganization() {
		assertEquals(employee1, mainApp.addEmployeeInOrganization(employee1));
		assertEquals(employee2, mainApp.addEmployeeInOrganization(employee2));
	}
	
	@Test
	public void testSetDateOfJoining() {
		assertFalse("Invalid date",employee1.getDateOfJoining().after(new Date()));
	}
	
	@Test
	public void test2RemoveEmployeeFromOrganization() {
		Set<Employee> empList = new HashSet<Employee>();
		empList.add(employee2);
		assertEquals(empList, mainApp.removeEmployeeFromOrganization(employee1));
	}
	
	@Test
	public void test3GetEmployee() {
		assertNotNull(mainApp.getEmployee(2));
		assertNull(mainApp.getEmployee(1));
	}
	
	@Test
	public void test4GetEmployeeList() {
		Set<Employee> empList = new HashSet<Employee>();
		empList.add(employee2);
		assertTrue(empList.equals(mainApp.getEmployeeList()));
	}
	
	@Test
	public void test5UpdateEmployeeName() {
		employee1 = new Employee();
		employee1.setEmpId(2);
		employee1.setEmpName("def");
		employee1.setDesignation("ghi");
		employee1.setDateOfJoining(new Date());
		Employee updatedEmp =  mainApp.updateEmployeeName(2, "Updated name");
		assertNotEquals(employee1.getEmpName(), updatedEmp.getEmpName());
		
	}

}
