package com.contactsupdate.domain;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.contactsupdate.user.vo.UserVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;

/**
 * @author Shagun Bakliwal
 *
 */
@Document
public class CUser implements Cloneable, Serializable {

	private static final long serialVersionUID = -2940168548620725232L;
	@Field(order = 4)
	@NotEmpty
	private String contactNumber;
	@Field(order = 7)
	@NotEmpty
	private Timestamp dob;
	@Field(order = 3)
	@Email
	@Indexed(unique = true)
	private String email;
	@Field(order = 5)
	@NotEmpty
	private String firstName;
	@Id
	@Field(order = 0)
	private String id;
	@Field(order = 6)
	@NotEmpty
	private String lastName;
	@NotEmpty
	@Min(value = 8)
	@Field(order = 2)
	@JsonIgnore
	private byte[] password;

	@NotEmpty
	@Indexed(unique = true)
	@Field(order = 1)
	private String username;

	public CUser() {
		super();
	}

	public CUser(@NotEmpty String contactNumber, @Email String email, @NotEmpty String firstName,
			@NotEmpty String lastName, @NotEmpty @Min(8) byte[] password, @NotEmpty @UniqueElements String username,
			@NotEmpty Timestamp dob) {
		super();
		this.contactNumber = contactNumber;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
		this.dob = dob;
	}

	public CUser(@NotEmpty String contactNumber, @Email String email, @NotEmpty String firstName, String id,
			@NotEmpty String lastName, @NotEmpty @Min(8) byte[] password, @NotEmpty @UniqueElements String username,
			@NotEmpty Timestamp dob) {
		super();
		this.contactNumber = contactNumber;
		this.email = email;
		this.firstName = firstName;
		this.id = id;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
		this.dob = dob;
	}

	public CUser(@Valid UserVO userVO) {
		try {
			BeanUtils.copyProperties(this, userVO);
		} catch (IllegalAccessException | InvocationTargetException exception) {
			exception.printStackTrace();
		}
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getId() {
		return this.id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public byte[] getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
