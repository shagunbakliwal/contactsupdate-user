package com.contactsupdate.exception;

public class DuplicateUsernameException extends DuplicateKeyException {

	public DuplicateUsernameException(String message) {
		super(message);
	}

}
