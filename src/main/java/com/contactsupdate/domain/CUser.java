package com.contactsupdate.domain;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Shagun Bakliwal
 *
 */
@Document
public class CUser implements Cloneable, Serializable {

	private static final long serialVersionUID = -2940168548620725232L;
	private Integer id;
	@NotEmpty
	@UniqueElements
	private String username;
	@NotEmpty
	@Min(value = 8)
	private byte[] password;
	@Email
	private String email;
	@NotEmpty
	private String contactNumber;

	public CUser(Integer id, String username, byte[] password, String email, String contactNumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.contactNumber = contactNumber;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getPassword() {
		return this.password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
