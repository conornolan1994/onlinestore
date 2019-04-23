package io.conor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.conor.model.User;
import io.conor.service.UserService;



@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.showAllUsers();
	}
	
	
	/*@RequestMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}*/
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User user ) {
		userService.addUser(user);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}")
	public void updateUser(@RequestBody User user,@PathVariable int id ) {
		userService.updateUser(id,user);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteTheUser(id);
	}
	
	@GetMapping("/saveUser")
	public String saveUser(  @RequestParam String email,@RequestParam String username,@RequestParam String password, @RequestParam String shippingAddress) {
		User user= new User(email,username, password,shippingAddress);
		userService.saveMyUser(user);
		return "User saved";
	}

}
