package com.accolite.Entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mst_User {

	@Id
	@GeneratedValue
	Integer id;
	String firstName;
	String lastName;
	String userName;
	String userPassword;
	Integer attempts;
	Boolean blocked;
	Calendar waitTime;
	Character typeOfUser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(unique=true)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Character getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(Character typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

	public Calendar getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(Calendar waitTime) {
		this.waitTime = waitTime;
	}
	
	

}
