package com.jpqlandcriteria.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpqlandcriteria.model.Users;
import com.jpqlandcriteria.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
   
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping()
	public Users getUserByEmail(@RequestParam("email") String email) {
		return userRepo.findUserByEmail(email);
	}
	
	
	@PostMapping("/add")
	public Users addUser(@RequestBody Users user) {
		return userRepo.save(user);
	}
	
	@PutMapping("/userId/{userId}")
	public Users updateUser(@PathVariable("userId") Long userId, @RequestBody Users user) {
		user.setId(userId);
		return userRepo.save(user);
	}
	
	@DeleteMapping("/userId/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
	   userRepo.deleteById(userId);
	}
}
