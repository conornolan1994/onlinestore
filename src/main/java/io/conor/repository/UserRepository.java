package io.conor.repository;

import org.springframework.data.repository.CrudRepository;

import io.conor.model.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	public User findByEmailAndPassword(String email,String password);
	

	

	
	
	
}
