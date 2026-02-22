package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.entity.LoginRequest;
import com.food.entity.User;
import com.food.service.UserService;
@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("user")
	public ResponseEntity<User> addUser(@RequestBody User u) {
		return ResponseEntity.ok(userService.addUser(u));
	}
	
	@GetMapping("user")
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok((List<User>)userService.getAllUser());
	}
	
	@GetMapping("user/{uid}")
	public ResponseEntity<User> getUser(@PathVariable("uid") int uid) {
		return ResponseEntity.ok(userService.getUser(uid));
	}
	
	@PutMapping("user/{uid}")
	public ResponseEntity<User> updateUser(User u, int uid) {

		User update = userService.updateUser(u,uid);
			return (update != null) ? ResponseEntity.ok(update) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("user/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable("uid") int uid) {
		return ResponseEntity.ok(userService.deleteUser(uid));
	}
	
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
		if(loginRequest.getEmail() == null || loginRequest.getPassword() ==null) {
			return ResponseEntity.badRequest().body("Email and password are required");
		}
		User user = userService.login(loginRequest.getEmail(),loginRequest.getPassword());
		if(user != null) {
			user.setPassword(null);
			return ResponseEntity.ok(user);
		}
		else {
			return ResponseEntity.status(401).body("Invalied email or password");
		}
	}
}
