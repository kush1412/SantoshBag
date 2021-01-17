package com.spring.SantoshBagApplication.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SantoshBagApplication.entity.User;
import com.spring.SantoshBagApplication.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
	private UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/users")
	public List<User> findAll() {
		System.out.println("get method is being called");
		return userService.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {
		
		User user = userService.findById(userId);
		
		if (user == null) {
			throw new RuntimeException("user id not found - " + userId);
		}
		
		return user;
	}
	
	@PostMapping("/User")
	public User addUser(@RequestBody User theuser) {
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		theuser.setId(0);
		userService.save(theuser);
		
		return theuser;
	}
	
	@PutMapping("/User")
	public User updateUser(@RequestBody User theuser) {
	
		userService.save(theuser);
		return theuser;
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteEmployee(@PathVariable int userId) {
		
		User tempUser = userService.findById(userId);
		
		// throw exception if null
		
		if (tempUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		userService.deleteById(userId);
		
		return "Deleted employee id - " + userId;
	}
	

}
