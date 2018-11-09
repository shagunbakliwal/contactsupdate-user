package com.contactsupdate.user.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class UserVO implements Serializable {

	private String contactNumber;
	@Past
	private Timestamp dob;
	@Email
	private String email;
	private String firstName;
	private String lastName;
	private String username;

	public UserVO() {
	}

	public UserVO(String username, String firstName, String lastName, @Email String email) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public Timestamp getDob() {
		return this.dob;
	}

	public String getEmail() {
		return this.email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
