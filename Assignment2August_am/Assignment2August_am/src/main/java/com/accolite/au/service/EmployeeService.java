package com.accolite.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.au.dao.EmployeeDao;
import com.accolite.au.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	//save employee
	public void insertEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	//get All employee
	public List<Employee> getEmployeeList() {
		return (List<Employee>) employeeDao.findAll();
	}

	//find employee by empNo
	public Employee getEmployeeByEmpNo(String empNo) {
		return employeeDao.findByEmpNo(empNo);
	}

	//update employee if exists
	public Employee updateEmployee(Employee emp, String empNo) {
		Employee empOld = employeeDao.findByEmpNo(empNo);
		if (empOld != null) {
			empOld.setEmpNo(emp.getEmpNo());
			empOld.setEmpName(emp.getEmpName());
			empOld.setSalary(emp.getSalary());
			empOld.setDesignation(emp.getDesignation());
			empOld.setEmail(emp.getEmail());
			return employeeDao.save(empOld);
		} else
			return null;
	}

	//delete employee
	public String deleteEmployeeByEmpNo(String empNo) {
		Employee empOld = employeeDao.findByEmpNo(empNo);
		if (empOld != null) {
			employeeDao.delete(empOld);
			return "Deleted";
		}
		return "No such Employee";
	}

}
