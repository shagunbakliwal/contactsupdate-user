package com.contactsupdate.user.exception;

import com.contactsupdate.exception.NotFoundException;

public class InvalidUserException extends NotFoundException {

	public InvalidUserException(String message) {
		super(message);
	}

}
