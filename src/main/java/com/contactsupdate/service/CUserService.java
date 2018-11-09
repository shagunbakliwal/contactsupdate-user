package com.contactsupdate.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.contactsupdate.domain.CUser;
import com.contactsupdate.exception.DuplicateEmailException;
import com.contactsupdate.exception.DuplicateKeyException;
import com.contactsupdate.exception.DuplicateUsernameException;
import com.contactsupdate.exception.InvalidUserException;
import com.contactsupdate.repository.CUserRepository;
import com.contactsupdate.service.interfaces.ICUserService;
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

	@Override
	public boolean register(@Valid UserVO userVO, String password) throws DuplicateKeyException {
		if (emailExists(userVO.getEmail())) {
			throw new DuplicateEmailException("Email is already registered");
		}
		if (usernameExists(userVO.getUsername())) {
			throw new DuplicateUsernameException("Username is already registered");
		}

		CUser user = new CUser(userVO);
		user.setPassword(password.getBytes());
		System.out.println(Arrays.toString(user.getPassword()));
		try {
			userRepository.save(user);
			return true;
		} catch (DataAccessException dae) {
			System.out.println(dae.getMessage());
			return false;
		}

	}

	private boolean usernameExists(String username) {
		return userRepository.existsByUsername(username);
	}

	private boolean emailExists(String email) {
		return userRepository.existsByEmail(email);
	}

}
