package com.contactsupdate.user.vo;

import java.io.Serializable;

import javax.validation.constraints.Email;

import com.google.gson.Gson;

public class UserVO implements Serializable {
	private String username;
	private String firstName;
	private String lastName;
	@Email
	private String email;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserVO(String username, String firstName, String lastName, @Email String email) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UserVO() {
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
