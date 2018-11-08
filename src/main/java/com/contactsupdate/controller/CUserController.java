package com.contactsupdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.contactsupdate.service.interfaces.ICUserService;
import com.contactsupdate.user.exception.InvalidUserException;
import com.contactsupdate.web.ResponseEntity;

@RestController
public class CUserController {

	@Autowired
	private ICUserService icUserService;

	@GetMapping(name = "Get User Details by Username", value = "/{username}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getUser(@PathVariable String username) throws InvalidUserException {
		return new ResponseEntity<>(icUserService.getUser(username), HttpStatus.OK);
	}
}
