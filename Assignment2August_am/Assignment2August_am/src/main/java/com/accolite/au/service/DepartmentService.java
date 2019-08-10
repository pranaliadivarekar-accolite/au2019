package com.accolite.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.au.dao.DepartmentDao;
import com.accolite.au.entity.Department;
import com.accolite.au.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	DepartmentDao departmentDao;
	
	//save
	public void insertDepartment(Department dept) {
			departmentDao.save(dept);
	}
	
	//find all dept
	public List<Department> getDepartmentList() {
		return (List<Department>) departmentDao.findAll();
	}
	
	//find dept by depNo
	public Department getDeparmentByDeptNo(String deptNo) {
		return departmentDao.findByDepartmentNo(deptNo);
	}
	
	//update dept if exists
	public Department updateDepartment(Department dept, String deptNo) {
		Department deptOld = departmentDao.findByDepartmentNo(deptNo);
		if(deptOld != null)
		{
			deptOld.setDepartmentNo(dept.getDepartmentNo());
			deptOld.setDepartmentName(dept.getDepartmentName());
			return departmentDao.save(deptOld);
		}
		else
			return null;
	}
	
	//delete dept
	public String deleteDepartmentByDeptNo(String deptNo) {
		Department deptOld = departmentDao.findByDepartmentNo(deptNo);
		if (deptOld != null) {
			departmentDao.delete(deptOld);
			return "Deleted";
		}
		return "No such Department";
	}
}
