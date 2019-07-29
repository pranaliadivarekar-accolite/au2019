package com.accolite.au.java;

import java.io.Serializable;

public class Student extends Person implements Serializable {

	private Integer studentId;
	private Integer standard;
	private Integer division;
	transient private Integer marks;
	private Address address;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getStandard() {
		return standard;
	}

	public void setStandard(Integer standard) {
		this.standard = standard;
	}

	public Integer getDivision() {
		return division;
	}

	public void setDivision(Integer division) {
		this.division = division;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [firstName="+getFirstName() +", lastName="+getLastName()+", studentId=" + studentId + ", standard=" + standard + ", division=" + division + ", marks="
				+ marks + ", address=" + address + "]";
	}

}
