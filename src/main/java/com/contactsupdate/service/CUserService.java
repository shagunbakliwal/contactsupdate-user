package com.contactsupdate.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactsupdate.domain.CUser;
import com.contactsupdate.repository.CUserRepository;
import com.contactsupdate.service.interfaces.ICUserService;
import com.contactsupdate.user.exception.InvalidUserException;
import com.contactsupdate.user.vo.UserVO;

@Service
public class CUserService implements ICUserService {

	@Autowired
	CUserRepository userRepository;

	@Override
	public UserVO getUser(String username) throws InvalidUserException {
		CUser user = userRepository.findByUsername(username);
		if (user == null) {
			throw new InvalidUserException("Invalid User");
		}
		UserVO userVO = new UserVO();
		try {
			BeanUtils.copyProperties(userVO, user);
		} catch (IllegalAccessException | InvocationTargetException exception) {
			exception.printStackTrace();
		}
		return userVO;
	}

}
