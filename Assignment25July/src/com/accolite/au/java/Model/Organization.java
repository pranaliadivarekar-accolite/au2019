package com.accolite.au.java.Model;

import java.util.HashMap;
import java.util.Map;

public class Organization {

	Map<Integer, Employee> empList;

	public Organization() {
		empList = new HashMap<>();
	}

	// Add
	public boolean addEmployee(Employee emp) {
		Employee employee = new Employee();
		employee.setEmpId(emp.getEmpId());
		employee.setEmpName(emp.getEmpName());
		employee.setDesignation(emp.getDesignation());
		empList.put(emp.getEmpId(), employee);
		return true;

	}

	// Delete
	public boolean deleteEmployee(Integer id) {
		if (empList.containsKey(id)) {
			empList.remove(id);
			return true;
		}
		return false;
	}

	// Get All
	public Map<Integer, Employee> getAllEmployee() {
		return empList;
	}

	// Find One
	public Employee getEmployeeById(Integer id) {
		return empList.get(id);
	}

	// Update
	public boolean updateEmployee(Employee emp) {
		Employee employee = empList.get(emp.getEmpId());
		if (employee == null)
			return false;

		employee.setEmpId(emp.getEmpId());
		employee.setEmpName(emp.getEmpName());
		employee.setDesignation(emp.getDesignation());
		empList.put(emp.getEmpId(), employee);
		return true;
	}

}
