package com.ravipsingh.bloggingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ravipsingh.bloggingapp.entity.User;

public interface UserRepository extends MongoRepository<User,String> {

	public User findItemByEmail(String email);
	public User findItemByEmailAndPassword(String email,String password);



	
}
