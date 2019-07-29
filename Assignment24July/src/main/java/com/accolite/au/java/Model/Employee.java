package com.accolite.au.java.Model;

import java.util.Date;

public class Employee {

	private Integer empId;
	private String empName;
	private String designation;
	private Date dateOfJoining;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		if(dateOfJoining.after(new Date()))
			this.dateOfJoining = new Date();
		else
			this.dateOfJoining = dateOfJoining;
	}

}
