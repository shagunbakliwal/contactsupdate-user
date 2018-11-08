package com.contactsupdate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.contactsupdate.domain.CUser;

public interface CUserRepository extends MongoRepository<CUser, Integer>{

	CUser findByUsername(String username);

}
