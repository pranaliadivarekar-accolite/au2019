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

import com.accolite.au.entity.Department;
import com.accolite.au.service.DepartmentService;

@RestController 
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	Environment env;
	
	@PostMapping("/department")
	public String createNote(@RequestBody Department dept) {
		departmentService.insertDepartment(dept);
	    return "Saved successfully";
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartmentList() {
		return departmentService.getDepartmentList();
	}
	
	@GetMapping("/department/{no}")
	public Department getDeparmentByDeptNo(@PathVariable(value = "no") String deptNo) {
		return departmentService.getDeparmentByDeptNo(deptNo);
	}
	
	@PutMapping("/department/{no}")
	public Department updateDepartment(@PathVariable(value = "no") String deptNo, @RequestBody Department dept) {
		return departmentService.updateDepartment(dept, deptNo);
	}
	
	@DeleteMapping("/department/{no}")
	public String deleteDeparmentByDeptNo(@PathVariable(value = "no") String deptNo) {
		return departmentService.deleteDepartmentByDeptNo(deptNo);
	}
	
	@GetMapping("/getEnvVar")
	public String getEnvVar() {
		return env.getProperty("username");
	}
	
}
