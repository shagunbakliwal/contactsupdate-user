package com.contactsupdate.service.interfaces;

import com.contactsupdate.user.exception.InvalidUserException;
import com.contactsupdate.user.vo.UserVO;

public interface ICUserService {

	UserVO getUser(String username) throws InvalidUserException;

}
