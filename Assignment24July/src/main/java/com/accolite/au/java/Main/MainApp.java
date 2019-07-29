package com.accolite.au.java.Main;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import com.accolite.au.java.Model.Employee;
import com.accolite.au.java.Model.Organization;

public class MainApp {

	private Organization organization;

	public MainApp() {
		organization = new Organization();
	}

	//Add
	public Employee addEmployeeInOrganization(Employee emp) {
		Set<Employee> empList = organization.getEmployeeList();
		if (empList == null)
			empList = new HashSet();
		empList.add(emp);
		organization.setEmployeeList(empList);
		return emp;
	}

	//Delete
	public Set<Employee> removeEmployeeFromOrganization(Employee emp) {
		Set<Employee> empList = organization.getEmployeeList();
		if (empList == null)
			empList = new HashSet();
		empList.remove(emp);
		organization.setEmployeeList(empList);
		return empList;
	}

	//Get
	public Employee getEmployee(int id) {
		Set<Employee> empList = organization.getEmployeeList();
		List<Employee> results = empList.stream().filter(x -> x.getEmpId().equals(id)).collect(Collectors.toList());

		if (results.isEmpty())
			return null;
		else
			return (Employee) results.get(0);
	}

	//Get All
	public Set<Employee> getEmployeeList() {
		return organization.getEmployeeList();
	}

	//Update
	public Employee updateEmployeeName(int id, String name) {
		Set<Employee> empList = organization.getEmployeeList();
		Employee emp = empList.stream().filter(x -> x.getEmpId().equals(id)).collect(Collectors.toList()).get(0);
		emp.setEmpName(name);
		return emp;

	}

}
