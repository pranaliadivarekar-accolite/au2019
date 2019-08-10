package com.accolite.au.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accolite.au.entity.Department;

public interface DepartmentDao extends CrudRepository<Department, Integer> {
	
	public Department findByDepartmentNo(String deptNo);

}
