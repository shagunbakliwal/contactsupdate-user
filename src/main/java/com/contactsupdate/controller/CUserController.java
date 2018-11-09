package com.contactsupdate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactsupdate.exception.DuplicateKeyException;
import com.contactsupdate.exception.InvalidUserException;
import com.contactsupdate.service.interfaces.ICUserService;
import com.contactsupdate.user.vo.UserVO;
import com.contactsupdate.web.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

@RestController
@Api(tags = { "User Profile" })
@RequestMapping(value = "/api/user")
public class CUserController {

	@Autowired
	private ICUserService icUserService;

	@GetMapping(name = "Get User Details by Username", value = "/{username}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Get User Details")
	public ResponseEntity<?> getUser(@PathVariable String username) throws InvalidUserException {
		return new ResponseEntity<>(icUserService.getUser(username), HttpStatus.OK);
	}

	@PostMapping(name = "Register User", value = "/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> registerUser(@RequestBody @Valid UserVO userVO, @RequestHeader String password)
			throws InvalidUserException, DuplicateKeyException {
		return new ResponseEntity<>(icUserService.register(userVO, password), HttpStatus.OK);
	}
}
