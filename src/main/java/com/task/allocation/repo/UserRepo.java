package com.task.allocation.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.task.allocation.model.User;

public interface UserRepo extends MongoRepository<User, String>{

	public User findByUserName(String userName);
	public User findByUserNameAndPassword(String userName,String password);
}
