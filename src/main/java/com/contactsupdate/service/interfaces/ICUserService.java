package com.contactsupdate.service.interfaces;

import javax.validation.Valid;

import com.contactsupdate.exception.DuplicateEmailException;
import com.contactsupdate.exception.DuplicateKeyException;
import com.contactsupdate.exception.InvalidUserException;
import com.contactsupdate.user.vo.UserVO;

public interface ICUserService {

	UserVO getUser(String username) throws InvalidUserException;

	boolean register(@Valid UserVO userVO, String password) throws DuplicateKeyException;

}
