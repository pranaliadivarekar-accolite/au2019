package com.accolite.au.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.au.entity.Employee;
import com.accolite.au.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	Environment env;
	
	@PostMapping("/employee")
	public String createEmployee(@RequestBody Employee employee) {
		employeeService.insertEmployee(employee);
	    return "Saved";
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployeeList() {
		return employeeService.getEmployeeList();
	}
	
	@GetMapping("/employee/{no}")
	public Employee getEmployeeByEmpNo(@PathVariable(value = "no") String empNo) {
		return employeeService.getEmployeeByEmpNo(empNo);
	}
	
	@PutMapping("/employee/{no}")
	public Employee updateDepartment(@PathVariable(value = "no") String empNo, @RequestBody Employee emp) {
		return employeeService.updateEmployee(emp, empNo);
	}
	
	@DeleteMapping("/employee/{no}")
	public String deleteEmployeeByEmpNo(@PathVariable(value = "no") String empNo) {
		return employeeService.deleteEmployeeByEmpNo(empNo);
	}
	
	@GetMapping("/getEnvVar")
	public String getEnvVar() {
		return env.getProperty("username");
	}
}
