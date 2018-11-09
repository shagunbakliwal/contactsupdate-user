package com.contactsupdate.exception;

public class DuplicateEmailException extends DuplicateKeyException {

	public DuplicateEmailException(String message) {
		super(message);
	}

}
