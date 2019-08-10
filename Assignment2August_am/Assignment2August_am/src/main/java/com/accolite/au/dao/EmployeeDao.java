package com.accolite.au.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accolite.au.entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	
	public Employee findByEmpNo(String empNo);
	
	public void deleteByEmpNo(String empNo);

}
