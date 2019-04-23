package io.conor.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.conor.model.User;
import io.conor.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User>showAllUsers(){
		
		List<User> users = new ArrayList<>();
		userRepository.findAll()
		.forEach(users::add);
		return users;
	}
	
	
	/*public User getUser(int id) {
		
		return userRepository.findOne(id);
	}
	*/


	public void addUser(User user) {
		userRepository.save(user);
		
	}


	public void updateUser(int id, User user) {
		userRepository.save(user);
		
	}


	public void deleteTheUser(int id) {
	
		userRepository.delete(id);
	}
	
	public void saveMyUser(User user) {
		userRepository.save(user);
	}
	public User editUser(int id) {
		
		return userRepository.findOne(id);
	}
	
	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	

}
